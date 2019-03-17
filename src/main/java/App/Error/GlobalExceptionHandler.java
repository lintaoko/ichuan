package App.Error;

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
    @ExceptionHandler(RuntimeException.class)
    public Map<String,Object> errorResult(Exception e){
        Map<String,Object> errorResultMap=new HashMap<String, Object>();
        StringWriter sw=new StringWriter();
        PrintWriter pw=new PrintWriter(sw);
        e.printStackTrace(pw);
        errorResultMap.put("errorCode",e.getMessage());
        return errorResultMap;
    }
}
