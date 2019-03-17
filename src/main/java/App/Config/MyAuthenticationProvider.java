package App.Config;

import App.App;
import App.Domain.UserLogin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;


@Component
@Slf4j
public class MyAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserDetailsService userDetailService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Override
    public Authentication authenticate(Authentication authentication ) throws AuthenticationException {
        String userName = authentication.getName();// 这个获取表单输入中返回的用户名;
        String password = (String) authentication.getCredentials();// 这个是表单中输入的密码；
        // 这里构建来判断用户是否存在和密码是否正确
        UserLogin userLogin = (UserLogin) userDetailService.loadUserByUsername(userName); // 这里调用我们的自己写的获取用户的方法；
        if (userLogin == null) {
            throw new BadCredentialsException("用户名不存在");
        }else if (passwordEncoder.matches(password,userLogin.getPassword())){
        log.info("用户{}登录", userName);
            Collection<? extends GrantedAuthority> authorities = userLogin.getAuthorities();
            // 构建返回的用户登录成功的token
            return new UsernamePasswordAuthenticationToken(userLogin, password, authorities);
        }else {
            throw new BadCredentialsException("密码错误");
        }
        // 就是加点盐的意思，这样的好处就是用户的密码如果都是123456，由于盐的不同，密码也是不一样的，就不用怕相同密码泄漏之后，不会批量被破解。
        // String encodePwd=md5PasswordEncoder.encodePassword(password, userName);
        // //这里判断密码正确与否
        // if(!userInfo.getPassword().equals(encodePwd))
        // //这里我们还要判断密码是否正确，实际应用中，我们的密码一般都会加密，以Md5加密为例
        // Md5PasswordEncoder md5PasswordEncoder=new Md5PasswordEncoder();
        // //这里第个参数，是salt
        // {
        // throw new BadCredentialsException("密码不正确");
        // }
        // //这里还可以加一些其他信息的判断，比如用户账号已停用等判断，这里为了方便我接下去的判断，我就不用加密了。
        //
        //
    }
    @Override
    public boolean supports(Class<?> authentication) {
        // TODO Auto-generated method stub
        // 这里直接改成retrun true;表示是支持这个执行
        return true;
    }
}
