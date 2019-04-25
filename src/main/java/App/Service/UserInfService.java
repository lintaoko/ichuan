package App.Service;

import App.Domain.UserInf;
import App.Mapper.UserInfMapper;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Service
@Transactional
@Slf4j
public class UserInfService {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    UserInfMapper userInfMapper;
    //查询个人信息
    public UserInf queryUserInfByUserLoginId(Integer userLoginId){
        String key = "userInf" + userLoginId;
        // 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) { // 从缓存中取
            UserInf userInf = (UserInf) redisTemplate.opsForValue().get(key);
            log.info("从缓存中获取了用户！");
            return userInf;
        }
        UserInf userInf= userInfMapper.queryUserInfByUserLoginId(userLoginId);
        redisTemplate.opsForValue().set(key, userInf, 600, TimeUnit.SECONDS);
        return  userInf;
    }
    //增添个人信息
    public Integer userInfInsert (Integer userLoginId,String userName,String Phone ,String address,String email ,Integer age ,String Hobby)
    {
        return userInfMapper.userInfInsert(userLoginId, userName, Phone, address, email, age, Hobby);
    }
    //更改user_inf邮箱
    public Integer userInfUpdateEmailById(String email,Integer userLoginId){
        return userInfMapper.userInfUpdateEmailById(email, userLoginId);
    }
    //更改user_inf电话
    public Integer userInfUpdatePhoneById(String phone,Integer userLoginId){
        return userInfMapper.userInfUpdatePhoneById(phone, userLoginId);
    }
    //更改user_inf昵称
    public Integer userInfUpdateUserNameById(String userName,Integer userLoginId){
        return userInfMapper.userInfUpdateUserNameById(userName, userLoginId);
    }
    //修改个人地址
    public Integer userInfUpdateAddressById(String address,Integer userLoginId){
        return userInfMapper.userInfUpdateAddressById(address,userLoginId);
    }
}
