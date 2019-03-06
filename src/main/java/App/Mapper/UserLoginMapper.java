package App.Mapper;

        import App.Domain.UserLogin;
        import org.apache.ibatis.annotations.*;

public interface UserLoginMapper {
    //管理员登陆
    @Select("select * from user_login where (AccountNumber=#{LoginObject} or Email=#{LoginObject} or Phone=#{LoginObject}  ) and Password=#{Password} and Type=1" )
    UserLogin systemManagerLogin (@Param("LoginObject") String accountNumber, @Param("Password") String password);
    //用户登陆
    @Select("select * from user_login where (AccountNumber=#{LoginObject} or Email=#{LoginObject} or Phone=#{LoginObject}  ) and Password=#{Password} and Type=0" )
    UserLogin userLogin  (@Param("LoginObject") String accountNumber, @Param("Password") String password);
    //添加普通用户。注册
    @Insert("insert into user_login(AccountNumber,Password,Email,Email,Type) values(#{AccountNumber},#{Password},#{Email},#{Phone},0)" )
    int userLoginInsert (@Param("AccountNumber") String accountNumber, @Param("Password") String password,@Param("Email") String email,@Param("Phone") String phone);
    //更改用户密码
    @Update("update user_login set Password = #{Password} where id=#{UserLoginId} ")
    int userLoginUpdatePasswordById(@Param("Password")String password,@Param("UserLoginId") Integer userLoginId);
    //更改user_login邮箱
    @Update("update user_login set Email =#{Email} where id=#{UserLoginId} ")
    int userLoginUpdateEmailById(@Param("Email")String email,@Param("UserLoginId") Integer userLoginId);
    //更改user_login电话
    @Update("update user_login set Phone =#{Phone} where id=#{UserLoginId} ")
    int userLoginUpdatePhoneById(@Param("Phone")String phone,@Param("UserLoginId") Integer userLoginId);

}
