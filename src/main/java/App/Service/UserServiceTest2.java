package App.Service;

import App.Domain.User;
import App.Mapper.test2.UserMapperTest2;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class UserServiceTest2 {
    @Autowired
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
    public PageInfo<User> queryUser(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);//底层实现原理采用改写sql语句
        List<User> selectResult=userMapperTest2.qureyUser();
        log .info("result:{}",selectResult);
        //返回客户端展示代码
        PageInfo<User> pageInfoUserList=new PageInfo<User>(selectResult);
        return pageInfoUserList;
    }

}