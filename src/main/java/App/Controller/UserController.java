package App.Controller;

import App.Service.UserServiceTest1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserServiceTest1 userServiceTest1;


    @RequestMapping("/insertUser")
    public Integer insertUser(String name,Integer age){
         return userServiceTest1.insertUser(name,age);
    }
}
