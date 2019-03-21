package App.Controller;

import App.Domain.ReplyPosting;
import App.Service.ReplyPostingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Slf4j
public class ReplyPostingController {
    @Autowired
    ReplyPostingService replyPostingService;
    //查询自己的回复贴
    @GetMapping("api/replyposting/replyuserid")
    public ReplyPosting[] queryReplyPostingByReplyUserId(@RequestBody ReplyPosting replyPosting){
     return replyPostingService.queryReplyPostingByReplyUserId(replyPosting.getReplyUserId());
    }
    //查询主题帖的回复贴
    @GetMapping("api/replyposting/mainpostingid")
    public ReplyPosting[] queryReplyPostingByMainPostingId(@RequestBody ReplyPosting replyPosting){
        return replyPostingService.queryReplyPostingByMainPostingId(replyPosting.getMainPostingId());
    }
    //查询主题帖中某人的回复贴(只看楼主)
    @GetMapping("api/replyposting/mainpostingid/replyuserid")
    public ReplyPosting[] queryReplyPostingByMainPostingIdAndReplyUserId(@RequestBody ReplyPosting replyPosting){
        return replyPostingService.queryReplyPostingByMainPostingIdAndReplyUserId(replyPosting.getMainPostingId(), replyPosting.getReplyUserId());
    }
    //回复主题帖
    @PostMapping("api/replyposting")
    public Integer replyPostingInsert(Integer mainPostingId, Integer replyUserId, String replyContent, String replyImg, String Replier){
        return replyPostingService.replyPostingInsert(mainPostingId, replyUserId, replyContent, replyImg, Replier);
    }
    //删除回复
    @DeleteMapping("api/replyposting/replypostingid")
    public Integer replyPostingDeleteByReplyPostingId( @RequestBody ReplyPosting replyPosting){
        return replyPostingService.replyPostingDeleteByReplyPostingId(replyPosting.getReplyPostingId());
    }
}
