package App.Controller;


import App.Domain.UserLogin;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;


@Controller
@Slf4j
public class JspController {
    @RequestMapping("/game")
    public ModelAndView game(){
        ModelAndView mv = new ModelAndView("redirect:/pages/game.html");
        return  mv;
    }
    @RequestMapping("/logoutsuccess")
    public String logout(){
        return "logoutSuccess";
    }
    //转向Suuu页面
    @RequestMapping("/login")
    public String aaa(){
        System.out.println("Turn to Login.jsp");
        return "login";
    }
    @RequestMapping("/index")
    public String index(){
        System.out.println("Turn to index.jsp");
        return "index";
    }
    @ResponseBody
    @RequestMapping("/userId")
    public Integer id(Authentication authentication){
//        authentication.getPrincipal() instanceof UserLogin
//        System.out.println(authentication.getPrincipal().getClass().getName());
        UserLogin us = (UserLogin) authentication.getPrincipal();
        return  us.getUserLoginId() ;
    }
    @RequestMapping("/Suuu")
    public String Suuu(){
        System.out.println("Turn to Suuu.jsp");
        return "Suuu";
    }
    //全局错误测试
    @RequestMapping("/errortest")
    public String bbb(){
        int i;
        i=5/0;
        return "Suuu";
    }
}
