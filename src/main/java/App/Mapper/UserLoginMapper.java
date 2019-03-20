package App.Mapper;

        import App.Domain.UserLogin;
        import org.apache.ibatis.annotations.*;

public interface UserLoginMapper {
    //整合spring安全
//    //管理员登陆
//    @Select("select * from user_login where (AccountNumber=#{LoginObject} or Email=#{LoginObject} or Phone=#{LoginObject}  ) and Password=#{Password} and Type=1" )
//    UserLogin systemManagerLogin (@Param("LoginObject") String accountNumber, @Param("Password") String password);
//    //用户登陆
//    @Select("select * from user_login where (AccountNumber=#{LoginObject} or Email=#{LoginObject} or Phone=#{LoginObject}  ) and Password=#{Password} and Type=0" )
//    UserLogin userLogin  (@Param("LoginObject") String accountNumber, @Param("Password") String password);
    //获取用户名
    @Select("select * from user_login where AccountNumber=#{LoginObject} or Email=#{LoginObject} or Phone=#{LoginObject}")
    UserLogin findByName (@Param("LoginObject") String accountNumber);
    //添加普通用户。注册
    @Insert("insert into user_login(AccountNumber,Password,Email,Type) values(#{AccountNumber},#{Password},#{Email},#{Phone},0)" )
    int userLoginInsert (@Param("AccountNumber") String accountNumber, @Param("Password") String password,@Param("Email") String email,@Param("Phone") String phone);
    //更改用户密码
    @Update("update user_login set Password = #{Password} where UserLoginId=#{UserLoginId} ")
    int userLoginUpdatePasswordById(@Param("Password")String password,@Param("UserLoginId") Integer userLoginId);
    //更改user_login邮箱
    @Update("update user_login set Email =#{Email} where UserLoginId=#{UserLoginId} ")
    int userLoginUpdateEmailById(@Param("Email")String email,@Param("UserLoginId") Integer userLoginId);      //更改user_login电话
    @Update("update user_login set Phone =#{Phone} where UserLoginId=#{UserLoginId} ")
    int userLoginUpdatePhoneById(@Param("Phone")String phone,@Param("UserLoginId") Integer userLoginId);
}
