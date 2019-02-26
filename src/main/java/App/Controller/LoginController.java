package App.Controller;


import App.Domain.SystemManager;
import App.Service.SystemManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequestMapping("/user")
public class LoginController {

    @Autowired
    SystemManagerService systemManagerService;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/loginVerify")
    public String loginVerify(String userName, String userPass, HttpSession session){


        SystemManager systemManager=systemManagerService.queryByUserNameAndUserPass(userName,userPass);
        if (systemManager==null){
            return "login";
        }
        else {
            session.setAttribute("user",systemManager);
            return "index";
        }
        return null;
    }
}
