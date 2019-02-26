package App.Mapper;

import App.Domain.SystemManager;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SystemManagerMapper {

    @Select("select * from SystemManager where userName=#{userName} and userPass=#{userPass}")
    SystemManager login (@Param("userName") String userName,@Param("userPass") String userPass);
 }
