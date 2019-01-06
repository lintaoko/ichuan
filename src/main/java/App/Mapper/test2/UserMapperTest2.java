package App.Mapper.test2;

import App.Domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface UserMapperTest2 {


    @Select("select * from user where name=#{name}")
     User findbyname(@Param("name") String name);


    @Insert("insert into user(name,age) values(#{name},#{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);


}
