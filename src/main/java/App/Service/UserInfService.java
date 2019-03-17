package App.Service;

import App.Domain.UserInf;
import App.Mapper.UserInfMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfService {
    @Autowired
    UserInfMapper userInfMapper;
    //查询个人信息
    public UserInf queryUserInfByUserLoginId(Integer userLoginId){
        return userInfMapper.queryUserInfByUserLoginId(userLoginId);
    }
    //增添个人信息
    public Integer userInfInsert (Integer userLoginId,String userName,String Phone ,String address,String email ,Integer age ,String Hobby)
    {
        return userInfMapper.userInfInsert(userLoginId, userName, Phone, address, email, age, Hobby);
    }
    //更改user_inf邮箱
    public Integer userInfUpdateEmailById(String email,Integer userLoginId){
        return userInfMapper.userInfUpdateEmailById(email, userLoginId);
    }
    //更改user_inf电话
    public Integer userInfUpdatePhoneById(String phone,Integer userLoginId){
        return userInfMapper.userInfUpdatePhoneById(phone, userLoginId);
    }
    //更改user_inf昵称
    public Integer userInfUpdateUserNameById(String userName,Integer userLoginId){
        return userInfMapper.userInfUpdatePhoneById(userName, userLoginId);
    }
    //修改个人地址
    public Integer userInfUpdateAddressById(String address,Integer userLoginId){
        return userInfMapper.userInfUpdateAddressById(address,userLoginId);
    }
}
