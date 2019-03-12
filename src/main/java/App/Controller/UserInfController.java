package App.Controller;

import App.Domain.UserInf;
import App.Service.UserInfService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class UserInfController {

    @Autowired
    UserInfService userInfService;


    //查询个人信息
    @GetMapping("api/userinf/1/{UserLoginId}")
    public UserInf queryUserInfByUserLoginId(@PathVariable("UserLoginId") Integer userLoginId){
        UserInf result=userInfService.queryUserInfByUserLoginId(userLoginId);
        return result;
    }
    //增添个人信息
    @PostMapping("api/userinf/")
    public Integer userInfInsert (Integer userLoginId,String userName,String Phone ,String address,String email ,Integer age ,String Hobby){
        Integer result=userInfService.userInfInsert(userLoginId, userName, Phone, address, email, age, Hobby);
        return result;
    }
    //更改user_inf邮箱
    @PutMapping("api/userinf/{UserLoginId}/email")
    public Integer userInfUpdateEmailById(String email,@PathVariable("UserLoginId")Integer userLoginId){
        Integer result=userInfService.userInfUpdateEmailById(email, userLoginId);
        return  result;
    }
    //更改user_inf电话
    @PutMapping("api/userinf/{UserLoginId}/phone")
    public Integer userInfUpdatePhoneById(String phone,@PathVariable("UserLoginId")Integer userLoginId){
        Integer result=userInfService.userInfUpdatePhoneById(phone, userLoginId);
        return result;
    }
    //更改user_inf昵称
    @PutMapping("api/userinf/{UserLoginId}/username")
    public Integer userInfUpdateUserNameById(String userName,@PathVariable("UserLoginId")Integer userLoginId){
        Integer result=userInfService.userInfUpdateUserNameById(userName, userLoginId);
        return result;
    }
    //修改个人地址
    @PutMapping("api/userinf/{UserLoginId}/address")
    public Integer userInfUpdateAddressById(String address,@PathVariable("UserLoginId")Integer userLoginId){
        Integer result=userInfService.userInfUpdateAddressById(address,userLoginId);
        return result;
    }

}
