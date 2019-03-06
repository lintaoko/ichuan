package App.Controller;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Slf4j
public class JspController {
    //转向Suuu页面
    @RequestMapping("/login")
    public String aaa(String name,String age){
        System.out.println("Turn to Suuu.jsp");
        return "login";
    }
    //全局错误测试
    @RequestMapping("/errortest")
    public String bbb(){
        int i;
        i=5/0;
        return "Suuu";
    }
}
