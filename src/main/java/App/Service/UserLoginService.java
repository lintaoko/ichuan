package App.Service;

import App.Domain.UserLogin;
import App.Mapper.UserLoginMapper;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {
    @Autowired
    UserLoginMapper userLoginMapper;

    //管理员登陆
    public UserLogin systemManagerLogin(String accountNumber,String password)
    {
        UserLogin selectResult= userLoginMapper.systemManagerLogin(accountNumber, password);
        return selectResult;
    }
    //用户登陆
    public UserLogin userLogin (String accountNumber,String password){
        UserLogin selectResult= userLoginMapper.userLogin(accountNumber, password);
        return  selectResult;
    }
    //增加用户
    public int userLoginInsert (String accountNumber,String password,String email,String phone){
        int insertResult= userLoginMapper.userLoginInsert(accountNumber, password, email, phone);
        return insertResult;
    }
    //修改密码
    public int userLoginUpdatePasswordById(String password,Integer userLoginId){
        int updateResult= userLoginMapper.userLoginUpdatePasswordById(password, userLoginId);
        return updateResult;
    }

}
