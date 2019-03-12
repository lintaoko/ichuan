package App.Controller;


import App.Domain.UserLogin;
import App.Service.UserLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@Slf4j
public class UserLoginController {

    @Autowired
    UserLoginService userLoginService;

    //普通用户登陆接口
    @PostMapping("/api/userlogin/user" )
    public String userloginVerify(String accountNumber , String password, HttpSession session){

        //登陆验证
        UserLogin userLogin=userLoginService.userLogin(accountNumber,password);
        if (userLogin==null){
            return "0";
        }
        else {
            session.setAttribute("user",userLogin);
            return "1";
        }
    }
    //管理员用户登录接口
    @PostMapping("/api/userlogin/admin")
    public String adminloginVerify(String accountNumber , String password, HttpSession session){

        //登陆验证
        UserLogin userLogin=userLoginService.systemManagerLogin(accountNumber,password);
        if (userLogin==null){
            return "0";
        }
        else {
            session.setAttribute("user",userLogin);
            return "1";
        }
    }
    //添加用户，注册
    @PostMapping("/api/userlogin/3")
    public Integer userLoginInsert (String accountNumber,String password,String email,String phone){
        //判断代码正则
        //todo
        Integer result =userLoginService.userLoginInsert(accountNumber, password, email, phone);
        return result;
    }
    //修改密码
    @PutMapping("/api/userlogin/{UserLoginId}/password")
    public Integer userLoginUpdatePasswordById(String password,@PathVariable("UserLoginId") Integer userLoginId){
        Integer result=userLoginService.userLoginUpdatePasswordById(password, userLoginId);
        return result;
    }
    //修改邮箱
    @PutMapping("/api/userlogin/{UserLoginId}/email")
    public Integer userLoginUpdateEmailById(String email,@PathVariable("UserLoginId")Integer userLoginId){
        Integer result=userLoginService.userLoginUpdateEmailById(email, userLoginId);
        return result;
    }
    //修改电话
    @PutMapping("/api/userlogin/{UserLoginId}/phone")
    public Integer userLoginUpdatePhoneById(String phone,@PathVariable("UserLoginId")Integer userLoginId){
        Integer result=userLoginService.userLoginUpdatePhoneById(phone, userLoginId);
        return result;
    }


}
