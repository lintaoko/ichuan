package App.Aop;

import App.Domain.UserInf;
import App.Domain.UserLogin;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Aspect
@Component
public class UserInfAuthorityAspect {
    private Logger logger = Logger.getLogger(getClass());
    @Pointcut("execution(public Integer App.Controller.UserInfController.user*Update*(..))")
    public void userInfAuthority() {
    }
    @Before("userInfAuthority()")
    public void userInfDoBefore(JoinPoint joinPoint) throws Exception {
        Object[] obj = joinPoint.getArgs();
        Authentication authentication;
        UserLogin us = new UserLogin();
        UserInf userInf = new UserInf();
        for (Object argItem : obj) {
            System.out.println("---->now-->argItem:" + argItem);
            if (argItem instanceof Authentication) {
                authentication = (Authentication) argItem;
                us = (UserLogin) authentication.getPrincipal();
            }
            if (argItem instanceof UserInf) {
                userInf = (UserInf)argItem;
            }
        }
            if (us.getUserLoginId() == null) {
                logger.info("无法查询到登陆状态");
                throw new RuntimeException("无法查询到登陆状态");
            }else {
                if (us.getUserLoginId().equals(userInf.getUserLoginId()) || us.getType() == 1) {
                } else {
                    logger.info("权限不足");
                   throw new RuntimeException("权限不足");
                }
            }
    }

}
