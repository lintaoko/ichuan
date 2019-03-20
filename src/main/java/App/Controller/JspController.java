package App.Controller;


import App.Domain.UserLogin;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.Date;
import java.util.List;


@Controller
@Slf4j
public class JspController {
    @RequestMapping("/game")
    public ModelAndView game(){
        return new ModelAndView("redirect:/pages/game.html");
    }
    @RequestMapping("/logoutsuccess")
    public String logout(){
        return "logoutSuccess";
    }
    //转向Suuu页面
    @RequestMapping("/login")
    public String aaa(){
        System.out.println("Turn to Login.jsp");
        return "login";
    }
    @RequestMapping("/index")
    public String index(){
        System.out.println("Turn to index.jsp");
        return "index";
    }
    @ResponseBody
    @RequestMapping("/userId")
    public Integer id(Authentication authentication){
//        authentication.getPrincipal() instanceof UserLogin
//        System.out.println(authentication.getPrincipal().getClass().getName());
        UserLogin us = (UserLogin) authentication.getPrincipal();
        return  us.getUserLoginId() ;
    }
    @RequestMapping("/Suuu")
    public String Suuu(){
        System.out.println("Turn to Suuu.jsp");
        return "Suuu";
    }
    //全局错误测试
    @RequestMapping("/errortest")
    public String bbb(){
        int i;
        i=5/0;
        return "Suuu";
    }
    @RequestMapping("/file")
    public String file(){
        return "file";
    }
    @PostMapping("/file/upload")
    @ResponseBody
    public String upload(HttpServletRequest request) {
        List<MultipartFile> files =((MultipartHttpServletRequest)request).getFiles("file");
        MultipartFile file;
        StringBuilder src= new StringBuilder(new String());
        for (int i =0; i< files.size(); ++i) {
            file=files.get(i);
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                int size = (int) file.getSize();
                System.out.println(fileName + "-->" + size);
                String path = "static/img";
                File dest = new File(path + "/" + (new Date().getTime()+ (int) (Math.random() * (100000))) + ".png");
                try {
                    Thread.sleep(100);
                    file.transferTo(dest); //保存文件
                    src.append(" ").append(i).append(":").append(path).append("/").append(dest.getName()).append(";");;
                } catch (IllegalStateException | IOException e) {
                    e.printStackTrace();
                    return "false";
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                src.append(" ").append(i).append(":null");
            }
        }
        return src.toString();
    }
}
