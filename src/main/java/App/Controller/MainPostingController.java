package App.Controller;


import App.Domain.MainPosting;
import App.Service.MainPostingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Slf4j
public class MainPostingController {
    @Autowired
    MainPostingService mainPostingService;


    //主题帖获取
    @GetMapping("api/mainposting/")
    public MainPosting[] queryAllMainPosting(){
        MainPosting[] result=mainPostingService.queryAllMainPosting();
        return result;
    }
    //主题帖查询byUserId(查询自己的贴子)
    @GetMapping("api/mainposting/{UserId}/userid")
    public MainPosting[] queryMainPostingByUserId(@PathVariable("UserId") Integer userId){
        MainPosting[] result=mainPostingService.queryMainPostingByUserId(userId);
        return result;
    }
    //主题帖搜索
    @GetMapping("api/mainposting/{PostingTitle}/postingtitle")
    public MainPosting[] queryMainPostingByLikePostingTitle(@PathVariable("PostingTitle") String postingTitle){
        MainPosting[] result=mainPostingService.queryMainPostingByLikePostingTitle(postingTitle);
        return result;
    }
    //发表主题帖
    @PutMapping("api/mainposting/")
    public Integer mainPostingInsert(Integer userId, String postingTitle, String postingContent, Date postedTime, String postAuther, String postImg){
        Integer result =mainPostingService.mainPostingInsert(userId, postingTitle, postingContent, postedTime, postAuther, postImg);
        return result;
    }
    //删除主题帖
    @DeleteMapping("api/mainposting/{MainPostingId}/mainpostingid")
    public Integer mainPostingDeleteByMainPostingId(@PathVariable("MainPostingId") Integer mainPostingId){
        Integer result =mainPostingService.mainPostingDeleteByMainPostingId(mainPostingId);
        return result;
    }
}
