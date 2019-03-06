package App.Mapper;

import App.Domain.UserInf;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserInfMapper {
    //查看个人信息
    @Select("select * from user_inf where UserLoginId=#{UserLoginId}")
    UserInf queryUserInfByUserLoginId (@Param("UserLoginId")Integer userLoginId);
    //更改user_login邮箱
    @Update("update user_inf set Email =#{Email} where id=#{UserLoginId} ")
    int userInfUpdateEmailById(@Param("Email")String email,@Param("UserLoginId") Integer userLoginId);
    //更改user_inf电话
    @Update("update user_inf set Phone =#{Phone} where id=#{UserLoginId} ")
    int userInfUpdatePhoneById(@Param("Phone")String phone,@Param("UserLoginId") Integer userLoginId);
    //更改user_inf昵称
    @Update("update user_inf set UserName =#{UserName} where id=#{UserLoginId} ")
    int userInfUpdateUserNameById(@Param("UserName")String userName,@Param("UserLoginId") Integer userLoginId);
}
