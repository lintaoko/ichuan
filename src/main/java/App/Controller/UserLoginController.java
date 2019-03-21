package App.Controller;
import App.Domain.UserLogin;
import App.Service.UserLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
@RestController
@Slf4j
public class UserLoginController {
    @Autowired
    UserLoginService userLoginService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
//    //普通用户登陆接口
//        @PostMapping("/api/userlogin/user" )
//    public String userloginVerify(@PathVariable("username") String accountNumber , String password, HttpSession session){
//
//        //登陆验证
//        UserLogin userLogin=userLoginService.userLogin(accountNumber,password);
//        if (userLogin==null){
//            log.info("0");
//            return "0";
//        }
//        else {
//            session.setAttribute("user",userLogin);
//            log.info("1");
//            return "1";
//        }
//    }
//    //管理员用户登录接口
//    @PostMapping("/api/userlogin/admin")
//    public String adminloginVerify(@PathVariable("username") String accountNumber , String password, HttpSession session){
//
//        //登陆验证
//        UserLogin userLogin=userLoginService.systemManagerLogin(accountNumber,password);
//        if (userLogin==null){
//            return "0";
//
//        }
//        else {
//            session.setAttribute("user",userLogin);
//            return "1";
//        }
//    }
    //添加用户，注册
    @PostMapping("/api/userlogin/register")
    public Integer userLoginInsert (@RequestBody UserLogin userLogin){
        //判断代码正则
        //todo
        return userLoginService.userLoginInsert(userLogin.getAccountNumber(), userLogin.getPassword(), userLogin.getEmail(), userLogin.getPhone());
    }
    //修改密码
    @PutMapping("/api/userlogin/password")
    public Integer userLoginUpdatePasswordById(@RequestBody UserLogin userLogin,Authentication authentication)  {
            String encoderpassword=passwordEncoder.encode(userLogin.getPassword());
            return  userLoginService.userLoginUpdatePasswordById(encoderpassword, userLogin.getUserLoginId());
    }
    //修改邮箱
    @PutMapping("/api/userlogin/email")
    public Integer userLoginUpdateEmailById(@RequestBody UserLogin userLogin,Authentication authentication){
            return  userLoginService.userLoginUpdateEmailById(userLogin.getEmail(), userLogin.getUserLoginId());
    }
    //修改电话
    @PutMapping("/api/userlogin/phone")
    public Integer userLoginUpdatePhoneById(@RequestBody UserLogin userLogin,Authentication authentication){
            return userLoginService.userLoginUpdatePhoneById(userLogin.getPhone(), userLogin.getUserLoginId());
    }
}