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
        UserInf selectResult =userInfMapper.queryUserInfByUserLoginId(userLoginId);
        return selectResult;
    }
    //增添个人信息
    public Integer userInfInsert (Integer userLoginId,String userName,String Phone ,String address,String email ,Integer age ,String Hobby)
    {
        Integer insertResult =userInfMapper.userInfInsert(userLoginId, userName, Phone, address, email, age, Hobby);
        return insertResult;
    }
    //更改user_inf邮箱
    public Integer userInfUpdateEmailById(String email,Integer userLoginId){
        Integer updateResult =userInfMapper.userInfUpdateEmailById(email, userLoginId);
        return updateResult;
    }
    //更改user_inf电话
    public Integer userInfUpdatePhoneById(String phone,Integer userLoginId){
        Integer updateResult =userInfMapper.userInfUpdatePhoneById(phone, userLoginId);
        return updateResult;
    }
    //更改user_inf昵称
    public Integer userInfUpdateUserNameById(String userName,Integer userLoginId){
        Integer updateResult =userInfMapper.userInfUpdatePhoneById(userName, userLoginId);
        return updateResult;
    }
    //修改个人地址
    public Integer userInfUpdateAddressById(String address,Integer userLoginId){
        Integer updateResult =userInfMapper.userInfUpdateAddressById(address,userLoginId);
        return updateResult;
    }

}
