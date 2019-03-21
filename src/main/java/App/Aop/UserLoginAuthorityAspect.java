package App.Aop;

import App.Domain.UserInf;
import App.Domain.UserLogin;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserLoginAuthorityAspect {
    private Logger logger = Logger.getLogger(getClass());
    @Pointcut("execution(public Integer App.Controller.UserLoginController.user*Update*(..))")
    public void userLoginAuthority(){
    }
    @Before("userLoginAuthority()")
    public void userLoginDoBefore(JoinPoint joinPoint) throws Exception {
        Object[] obj = joinPoint.getArgs();
        Authentication authentication;
        UserLogin us = new UserLogin();
        UserLogin userLoginr = new UserLogin();
        for (Object argItem : obj) {
            System.out.println("---->now-->argItem:" + argItem);
            if (argItem instanceof Authentication) {
                authentication = (Authentication) argItem;
                us = (UserLogin) authentication.getPrincipal();
            }
            if (argItem instanceof UserInf) {
                userLoginr = (UserLogin) argItem;
            }
        }
        if (us.getUserLoginId() == null) {
            logger.info("无法查询到登陆状态");
            throw new RuntimeException("无法查询到登陆状态");
        }else {
            if (us.getUserLoginId().equals(userLoginr.getUserLoginId()) || us.getType() == 1) {
            } else {
                logger.info("权限不足");
                throw new RuntimeException("权限不足");
            }
        }
    }
}
