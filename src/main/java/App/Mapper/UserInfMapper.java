package App.Mapper;

import App.Domain.UserInf;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserInfMapper {
    //查询个人信息
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
    //修改个人地址
    @Update("update user_inf set Address =#{Address} where id=#{UserLoginId}" )
    int userInfUpdateAddressById (@Param("Address")String address,@Param("UserLoginId") Integer userLoginId);
    //增添个人信息
    @Insert("insert into user_inf(UserLoginId,UserName,Phone,Address,Email,Age,Hobby) VALUES(#{UserLoginId},#{UserName},#{Phone},#{Address},#{Email},#{Age},#{Hobby})")
    int userInfInsert(@Param("UserLoginId") Integer userLoginId,@Param("UserName") String userName,@Param("Phone") String phone,@Param("Address") String address,@Param("Email") String email,@Param("Age")Integer age,@Param("Hobby")String hobby);
}
