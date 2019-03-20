package App.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyAuthenticationProvider provider;
    @Override
    //重写了configure参数为AuthenticationManagerBuilder的方法
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(provider);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //我们指定任何用户都可以访问多个URL的模式。
                //任何用户都可以访问以"/resources/","/signup", 或者 "/about"开头的URL。                                                     
                .antMatchers("/login","/api/**","/file/**").permitAll()
                //以 "/admin/" 开头的URL只能让拥有 "ROLE_ADMIN"角色的用户访问。
                //请注意我们使用 hasRole 方法，没有使用 "ROLE_" 前缀。
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/aa").hasRole("USER")
                //任何以"/db/" 开头的URL需要同时具有 "ROLE_ADMIN" 和 "ROLE_DBA"权限的用户才可以访问。
                //和上面一样我们的 hasRole 方法也没有使用 "ROLE_" 前缀。              
                .antMatchers("/tooooo").access("hasRole('ADMIN') and hasRole('USER')")
                //任何以"/db/" 开头的URL只需要拥有 "ROLE_ADMIN" 和 "ROLE_DBA"其中一个权限的用户才可以访问。
                //和上面一样我们的 hasRole 方法也没有使用 "ROLE_" 前缀。          
//                .antMatchers("/api/**").hasAnyRole("ADMIN", "USER")
                //尚未匹配的任何URL都要求用户进行身份验证
                .anyRequest().authenticated()
                .and()
                //指定登录页的路径
                .formLogin().loginPage("/login").loginProcessingUrl("/loginProcessingUrl")
                //指定登录成功后跳转到/index页面
                .defaultSuccessUrl("/userId")
                //指定登录失败后跳转到/login?error页面
                .failureUrl("/Suuu")
                .permitAll()
                .and()
                //开启cookie储存用户信息，并设置有效期为14天，指定cookie中的密钥
                .rememberMe().tokenValiditySeconds(1209600).key("mykey")
                .and()
                .logout()
                //指定登出的url
                .logoutUrl("/logout")
                //指定登场成功之后跳转的url
                .logoutSuccessUrl("/logoutsuccess")
                .permitAll()
                .and()
                .csrf().disable();//否则无法提交表单
        http.sessionManagement().maximumSessions(1).expiredUrl("/login");
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }
}
