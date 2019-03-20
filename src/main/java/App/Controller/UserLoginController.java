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
    public Integer userLoginInsert (@RequestParam String accountNumber,@RequestParam String password,@RequestParam String email,@RequestParam String phone){
        //判断代码正则
        //todo
        return userLoginService.userLoginInsert(accountNumber, password, email, phone);
    }
    //修改密码
    @PutMapping("/api/userlogin/{UserLoginId}/password")
    public Integer userLoginUpdatePasswordById(@RequestParam String password, @PathVariable("UserLoginId") Integer userLoginId, Authentication authentication)  {
            String encoderpassword=passwordEncoder.encode(password);
            return  userLoginService.userLoginUpdatePasswordById(encoderpassword, userLoginId);
    }
    //修改邮箱
    @PutMapping("/api/userlogin/{UserLoginId}/email")
    public Integer userLoginUpdateEmailById(String email,@PathVariable("UserLoginId")Integer userLoginId,Authentication authentication){
            return  userLoginService.userLoginUpdateEmailById(email, userLoginId);
    }
    //修改电话
    @PutMapping("/api/userlogin/{UserLoginId}/phone")
    public Integer userLoginUpdatePhoneById(String phone,@PathVariable("UserLoginId")Integer userLoginId,Authentication authentication){
            return userLoginService.userLoginUpdatePhoneById(phone, userLoginId);
    }
}