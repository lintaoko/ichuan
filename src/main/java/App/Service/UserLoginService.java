package App.Service;

import App.Domain.UserLogin;
import App.Mapper.UserLoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class UserLoginService {
    @Autowired
    UserLoginMapper userLoginMapper;

//    //管理员登陆
//    public UserLogin systemManagerLogin(String accountNumber,String password)
//    {
//        UserLogin selectResult= userLoginMapper.systemManagerLogin(accountNumber, password);
//        return selectResult;
//    }
//    //用户登陆
//    public UserLogin userLogin (String accountNumber,String password){
//        UserLogin selectResult= userLoginMapper.userLogin(accountNumber, password);
//        return  selectResult;
//    }
    //增加用户
    public Integer userLoginInsert (String accountNumber,String password,String email,String phone){
        return userLoginMapper.userLoginInsert(accountNumber, password, email, phone);
    }
    //修改密码
    public Integer userLoginUpdatePasswordById(String password,Integer userLoginId){
        return userLoginMapper.userLoginUpdatePasswordById(password, userLoginId);
    }
    //修改邮箱
    public Integer userLoginUpdateEmailById(String email,Integer userLoginId)
    {
        return userLoginMapper.userLoginUpdateEmailById(email, userLoginId);
    }
    //修改电话
    public Integer userLoginUpdatePhoneById(String phone,Integer userLoginId)
    {
        return userLoginMapper.userLoginUpdatePhoneById(phone, userLoginId);
    }
}
