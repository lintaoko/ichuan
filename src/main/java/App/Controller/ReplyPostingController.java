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
    @GetMapping("api/replyposting/{ReplyUserId}/replyuserid")
    public ReplyPosting[] queryReplyPostingByReplyUserId(@PathVariable("ReplyUserId") Integer replyUserId){
        ReplyPosting[] result =replyPostingService.queryReplyPostingByReplyUserId(replyUserId);
        return  result;
    }
    //查询主题帖的回复贴
    @GetMapping("api/replyposting/{MainPostingId}/mainpostingid")
    public ReplyPosting[] queryReplyPostingByMainPostingId(@PathVariable("MainPostingId") Integer mainPostingId){
        ReplyPosting[] result =replyPostingService.queryReplyPostingByMainPostingId(mainPostingId);
        return result;
    }
    //查询主题帖中某人的回复贴(只看楼主)
    @GetMapping("api/replyposting/{MainPostingId}/mainpostingid/{ReplyUserId}/replyuserid")
    public ReplyPosting[] queryReplyPostingByMainPostingIdAndReplyUserId(@PathVariable("MainPostingId") Integer mainPostingId, @PathVariable("ReplyUserId") Integer replyUserId){
        ReplyPosting[] result =replyPostingService.queryReplyPostingByMainPostingIdAndReplyUserId(mainPostingId, replyUserId);
        return result;
    }
    //回复主题帖
    @PutMapping("api/replyposting")
    public Integer replyPostingInsert(Integer mainPostingId, Date replyTime, Integer replyUserId, String replyContent, String replyImg, String Replier){
        Integer result=replyPostingService.replyPostingInsert(mainPostingId, replyTime, replyUserId, replyContent, replyImg, Replier);
        return result;
    }
    //删除回复
    @DeleteMapping("api/replyposting/{ReplyUserId}/replyuserid")
    public Integer replyPostingDeleteByReplyPostingId( Integer replyPostingId){
        Integer result=replyPostingService.replyPostingDeleteByReplyPostingId(replyPostingId);
        return  result;
    }

}
