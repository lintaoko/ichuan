package App.Controller;

import App.Service.UserServiceTest1;
import App.Service.UserServiceTest2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserServiceTest1 userServiceTest1;
    @Autowired
    private UserServiceTest2 userServiceTest2;


    @RequestMapping("/insertUser1")
    public Integer insertUser1(String name,Integer age){
         return userServiceTest1.insertUser(name,age);
    }
    @RequestMapping("/insertUser2")
    public Integer insertUser2(String name,Integer age){
        return userServiceTest2.insertUser(name,age);
    }
}
