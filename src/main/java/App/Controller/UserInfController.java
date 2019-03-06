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
    @GetMapping("api/userinf/1/#{userLoginId}")
    public UserInf queryUserInfByUserLoginId(@PathVariable("userLoginId") Integer userLoginId){
        UserInf result=userInfService.queryUserInfByUserLoginId(userLoginId);
        return result;
    }
    //增添个人信息
    @PostMapping("api/userinf/1")
    public Integer userInfInsert (Integer userLoginId,String userName,String Phone ,String address,String email ,Integer age ,String Hobby){
        Integer result=userInfService.userInfInsert(userLoginId, userName, Phone, address, email, age, Hobby);
        return result;
    }
    //更改user_inf邮箱
    @PutMapping("api/userinf/1")
    public Integer userInfUpdateEmailById(String email,Integer userLoginId){
        Integer result=userInfService.userInfUpdateEmailById(email, userLoginId);
        return  result;
    }
    //更改user_inf电话
    @PutMapping("api/userinf/2")
    public Integer userInfUpdatePhoneById(String phone,Integer userLoginId){
        Integer result=userInfService.userInfUpdatePhoneById(phone, userLoginId);
        return result;
    }
    //更改user_inf昵称
    @PutMapping("api/userinf/3")
    public Integer userInfUpdateUserNameById(String userName,Integer userLoginId){
        Integer result=userInfService.userInfUpdateUserNameById(userName, userLoginId);
        return result;
    }
    //修改个人地址
    @PutMapping("api/userinf/4")
    public Integer userInfUpdateAddressById(String address,Integer userLoginId){
        Integer result=userInfService.userInfUpdateAddressById(address,userLoginId);
        return result;
    }

}
