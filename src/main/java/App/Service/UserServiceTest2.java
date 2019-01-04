package App.Service;

import App.Domain.User;
import App.Mapper.test2.UserMapperTest2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Slf4j
public class UserServiceTest2 {
    @Resource
    private UserMapperTest2 userMapperTest2;

    @Transactional
    public int insertUser(String name,Integer age){
        int insertUserResult =userMapperTest2.insert(name,age);
        log .info("result:{}",insertUserResult);
        return insertUserResult;
    }
    public User querybyUsername(String name){
        User selectResult=userMapperTest2.findbyname(name);
        log .info("result:{}",selectResult);
        return  selectResult;
    }

}