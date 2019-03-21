package App.Controller;

import App.Domain.UserInf;
import App.Domain.UserLogin;
import App.Service.UserInfService;
import App.Untils.SecurityParameter;
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
    @GetMapping("api/userinf/userloginid")
    public UserInf queryUserInfByUserLoginId( @RequestBody UserInf userInf){
        return userInfService.queryUserInfByUserLoginId(userInf.getUserLoginId());
    }
    //增添个人信息
    @PostMapping("api/userinf")
    public Integer userInfInsert (@RequestBody UserInf userInf){
        return userInfService.userInfInsert(userInf.getUserLoginId(), userInf.getUserName(), userInf.getPhone(), userInf.getAddress(), userInf.getEmail(), userInf.getAge(), userInf.getHobby());
    }
    //更改user_inf邮箱
    @PutMapping("api/userinf/email")
    public Integer userInfUpdateEmailById(@RequestBody UserInf userInf, Authentication authentication){
        return userInfService.userInfUpdateEmailById(userInf.getEmail(),userInf.getUserLoginId());
    }
    //更改user_inf电话
    @PutMapping("api/userinf/phone")
    public Integer userInfUpdatePhoneById(@RequestBody UserInf userInf, Authentication authentication){
        return userInfService.userInfUpdatePhoneById(userInf.getPhone(), userInf.getUserLoginId());
    }
    //更改user_inf昵称
    @PutMapping("api/userinf/username")
    public Integer userInfUpdateUserNameById(@RequestBody UserInf userInf, Authentication authentication){
        return userInfService.userInfUpdateUserNameById(userInf.getUserName(), userInf.getUserLoginId());
    }
    //修改个人地址
    @PutMapping("api/userinf/address")
    public Integer userInfUpdateAddressById(@RequestBody UserInf userInf, Authentication authentication) {
        return userInfService.userInfUpdateAddressById(userInf.getAddress(),userInf.getUserLoginId());
    }
}