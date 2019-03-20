package App.Controller;

import App.Domain.UserInf;
import App.Service.UserInfService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class UserInfController  {
    @Autowired
    UserInfService userInfService;
    //查询个人信息
    @GetMapping("api/userinf/{UserLoginId}/userloginid")
    public UserInf queryUserInfByUserLoginId(@PathVariable("UserLoginId") Integer userLoginId){
        return userInfService.queryUserInfByUserLoginId(userLoginId);
    }
    //增添个人信息
    @PostMapping("api/userinf")
    public Integer userInfInsert (@RequestParam Integer userLoginId,@RequestParam String userName,@RequestParam String Phone , String address,@RequestParam String email ,Integer age ,String Hobby){
        return userInfService.userInfInsert(userLoginId, userName, Phone, address, email, age, Hobby);
    }
    //更改user_inf邮箱
    @PutMapping("api/userinf/{UserLoginId}/email")
    public Integer userInfUpdateEmailById(@RequestParam String email, @PathVariable("UserLoginId")Integer userLoginId, Authentication authentication){
        return userInfService.userInfUpdateEmailById(email, userLoginId);
    }
    //更改user_inf电话
    @PutMapping("api/userinf/{UserLoginId}/phone")
    public Integer userInfUpdatePhoneById(@RequestParam String phone,@PathVariable("UserLoginId")Integer userLoginId, Authentication authentication){
        return userInfService.userInfUpdatePhoneById(phone, userLoginId);
    }
    //更改user_inf昵称
    @PutMapping("api/userinf/{UserLoginId}/username")
    public Integer userInfUpdateUserNameById(@RequestParam String userName,@PathVariable("UserLoginId")Integer userLoginId, Authentication authentication){
        return userInfService.userInfUpdateUserNameById(userName, userLoginId);
    }
    //修改个人地址
    @PutMapping("api/userinf/{UserLoginId}/address")
    public Integer userInfUpdateAddressById(String address,@PathVariable("UserLoginId")Integer userLoginId, Authentication authentication) {
        return userInfService.userInfUpdateAddressById(address,userLoginId);
    }
}