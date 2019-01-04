package App.Controller;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Slf4j
public class JspController {
    @RequestMapping("/aaaa")
    public String aaa(String name,String age){
        System.out.println("Aaaaaaa");
        return "Suuu";
    }
    @RequestMapping("/bbbb")
    public String bbb(){
        int i;
        i=5/0;
        return "Suuu";
    }
}
