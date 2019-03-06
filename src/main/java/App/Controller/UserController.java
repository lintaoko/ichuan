//package App.Controller;
//
//import App.Domain.User;
//import App.Service.UserServiceTest1;
//import App.Service.UserServiceTest2;
//import com.github.pagehelper.PageInfo;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@Slf4j
//@RequestMapping(value = "/abcd")
//public class UserController {
//    @Autowired
//    private UserServiceTest1 userServiceTest1;
//    @Autowired
//    private UserServiceTest2 userServiceTest2;
//
//
//
//    @RequestMapping("/abc")
//    public String abc(){
//        return "林涛帅哥";
//    }
//    @RequestMapping("/insertUser1")
//    public Integer insertUser1(String name,Integer age){
//         return userServiceTest1.insertUser(name,age);
//    }
//    @RequestMapping("/insertUser2")
//    public Integer insertUser2(String name,Integer age){
//        return userServiceTest2.insertUser(name,age);
//    }
//    @RequestMapping("/getuser")
//    public User aaa(String name){
//        return  userServiceTest2.querybyUsername(name);
//    }
//    @RequestMapping("/pagehelpertest")
//    public PageInfo<User> pagehelptset(int pageNum,int pageSize){
//        return userServiceTest2.queryUser(pageNum,pageSize);
//    }
//}
