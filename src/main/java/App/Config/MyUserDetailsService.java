package App.Config;

import App.App;
import App.Domain.UserLogin;
import App.Mapper.UserLoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserLoginMapper userLoginMapper;
    @Override
     public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //查询账号是否存在，是就返回一个UserDetails的对象，否就抛出异常！
        UserLogin user = userLoginMapper.findByName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("UserName " + userName + " not found");
        }
        if (user.getType()==1) {
            user.setRole("ROLE_ADMIN");
        }else {
            user.setRole("ROLE_USER");
        }
        return user;
    }
}
