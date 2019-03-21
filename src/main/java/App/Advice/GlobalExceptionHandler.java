package App.Advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice(basePackages ="App.Controller")
public class GlobalExceptionHandler {
    @ResponseBody
    //输出形式
    //因为某些业务需要进行业务回滚。
    // 但spring的事务只针对RuntimeException的进行回滚操作。所以需要回滚就要继承RuntimeException。
    @ExceptionHandler(RuntimeException.class)
    public Map<String,Object> errorResult(Exception e){
        Map<String,Object> errorResultMap=new HashMap<>();
        StringWriter sw=new StringWriter();
        PrintWriter pw=new PrintWriter(sw);
        e.printStackTrace(pw);
        errorResultMap.put("errorCode",e.getMessage());
        return errorResultMap;
    }
}
