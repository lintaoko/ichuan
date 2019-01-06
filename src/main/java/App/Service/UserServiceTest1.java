package App.Service;

import App.Domain.User;
import App.Mapper.test1.UserMapperTest1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Slf4j
public class UserServiceTest1 {
    @Autowired
    private UserMapperTest1 userMapperTest1;

    @Transactional
    public int insertUser(String name,Integer age){
        int insertUserResult =userMapperTest1.insert(name,age);
        log .info("result:{}",insertUserResult);
        return insertUserResult;
    }
    public User querybyUsername(String name){
        User selectResult=userMapperTest1.findbyname(name);
        log .info("result:{}",selectResult);
        return  selectResult;
    }

}