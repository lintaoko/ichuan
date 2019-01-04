package App.Controller;


import App.Service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
//@restController 表示该类所有方法返回json 格式 =@App.App.Controller +@ResponseBody
public class MemberController {


    @Autowired
    MemberService memberService;


    @Value("${http_url}")
    private String httpurl;

    //test
    @RequestMapping("/abc")
    public String memberIndex(){
        return httpurl;
    }
    @RequestMapping("/abcd")
    public String test2(){
        log.info("1");
       String result=memberService.Asynctest();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("4");
        return "result:"+result ;
    }
}
