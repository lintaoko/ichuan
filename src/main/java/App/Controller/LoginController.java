package App.Controller;


import App.Domain.UserLogin;
import App.Mapper.UserLoginMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@Slf4j
public class LoginController {

    @Autowired
    UserLoginMapper userLoginMapper;

    @PostMapping("/user/loginVerify" )
    public String userloginVerify(String accountNumber , String password, HttpSession session){

        //登陆验证
        UserLogin userLogin=userLoginMapper.userLogin(accountNumber,password);
        if (userLogin==null){
            return "0";
        }
        else {
            session.setAttribute("user",userLogin);
            return "1";
        }
    }
    @PostMapping("/admin/loginVerify")
    public String adminloginVerify(String accountNumber , String password, HttpSession session){

        //登陆验证
        UserLogin userLogin=userLoginMapper.systemManagerLogin(accountNumber,password);
        if (userLogin==null){
            return "0";
        }
        else {
            session.setAttribute("user",userLogin);
            return "1";
        }
    }
}
