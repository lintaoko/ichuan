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
    @GetMapping("api/mainposting")
    public MainPosting[] queryAllMainPosting(){
        return mainPostingService.queryAllMainPosting();

    }
    //主题帖查询byUserId(查询自己的贴子)
    @GetMapping("api/mainposting/{UserId}/userid")
    public MainPosting[] queryMainPostingByUserId(@PathVariable("UserId") Integer userId){
        return mainPostingService.queryMainPostingByUserId(userId);

    }
    //主题帖搜索
    @GetMapping("api/mainposting/{PostingTitle}/postingtitle")
    public MainPosting[] queryMainPostingByLikePostingTitle(@PathVariable("PostingTitle") String postingTitle){
        return mainPostingService.queryMainPostingByLikePostingTitle(postingTitle);
    }
    //发表主题帖
    @PostMapping("api/mainposting")
    public Integer mainPostingInsert(Integer userId, String postingTitle, String postingContent, Date postedTime, String postAuthor, String postImg){
        return mainPostingService.mainPostingInsert(userId, postingTitle, postingContent, postAuthor, postImg);
    }
    //删除主题帖
    @DeleteMapping("api/mainposting/{MainPostingId}/mainpostingid")
    public Integer mainPostingDeleteByMainPostingId(@PathVariable("MainPostingId") Integer mainPostingId){
        return mainPostingService.mainPostingDeleteByMainPostingId(mainPostingId);
    }
}
