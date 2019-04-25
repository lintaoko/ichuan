package App.Controller;


import App.Domain.MainPosting;
import App.Domain.UserLogin;
import App.Service.MainPostingService;
import com.mysql.cj.xdevapi.JsonArray;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class MainPostingController {
    @Autowired
    MainPostingService mainPostingService;


    //主题帖获取
    @GetMapping("api/mainposting")
    public Map queryAllMainPosting( Integer pageNum,Integer pageSize){
        return mainPostingService.queryAllMainPosting(pageNum, pageSize);
//        Map<String,Object> map=new HashMap<>();
//        int i=1;
//        for (MainPosting mainPosting:mainPostings) {
//            map.put(Integer.toString(i),mainPosting);
//            i++;
//        }
//        map.put("pageNum",pageNum);
//        map.put("pageSize",pageSize);
//        return map;
    }
    //主题帖查询byUserId(查询自己的贴子)
    @GetMapping("api/mainposting/userid")
    public MainPosting[] queryMainPostingByUserId(@RequestParam Integer userId){
        return mainPostingService.queryMainPostingByUserId(userId);
    }
    //主题帖搜索
    @GetMapping("api/mainposting/postingtitle")
    public MainPosting[] queryMainPostingByLikePostingTitle(@RequestParam String postingTitle){
        return mainPostingService.queryMainPostingByLikePostingTitle(postingTitle);
    }
    //发表主题帖
    @PostMapping("api/mainposting")
    public Integer mainPostingInsert(@RequestBody MainPosting mainPosting){
        return mainPostingService.mainPostingInsert(mainPosting.getUserId(), mainPosting.getPostingTitle(), mainPosting.getPostingContent(), mainPosting.getPostAuthor(), mainPosting.getPostImg());
    }
    //删除主题帖
    @DeleteMapping("api/mainposting/mainpostingid")
    public Integer mainPostingDeleteByMainPostingId(@RequestBody MainPosting mainPosting, Authentication authentication){
        UserLogin us = (UserLogin) authentication.getPrincipal();
        if (us.getUserLoginId().equals(mainPosting.getMainPostingId()) ||us.getType()==1) {
            return mainPostingService.mainPostingDeleteByMainPostingId(mainPosting.getMainPostingId());
        }else {
            throw new RuntimeException("权限不足");
        }
    }
}
