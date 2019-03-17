package App.Service;

import App.Domain.ReplyPosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@Service
public class ReplyPostingService {
    @Autowired
    private RestTemplate restTemplate;
    //查询自己的回复贴
    public ReplyPosting[] queryReplyPostingByReplyUserId(Integer replyUserId){
        String url="http://127.0.0.1:8082/replyposting/"+replyUserId+"/replyuserid";
        ReplyPosting[] replyPostings =restTemplate.getForObject(url, ReplyPosting[].class);
        return  replyPostings;
    }
    //查询主题帖的回复贴
    public ReplyPosting[] queryReplyPostingByMainPostingId(Integer mainPostingId){
        String url="http://127.0.0.1:8082/replyposting/"+mainPostingId+"/mainpostingid";
        ReplyPosting[] replyPostings =restTemplate.getForObject(url, ReplyPosting[].class);
        return  replyPostings;
    }
    //查询主题帖中某人的回复贴(只看楼主)
    public ReplyPosting[] queryReplyPostingByMainPostingIdAndReplyUserId(Integer mainPostingId, Integer replyUserId){
        String url="http://127.0.0.1:8082/replyposting/"+mainPostingId+"/mainpostingid/"+replyUserId+"/replyuserid";
        ReplyPosting[] replyPostings =restTemplate.getForObject(url, ReplyPosting[].class);
        return  replyPostings;
    }

    //回复主题帖
    public Integer replyPostingInsert(Integer mainPostingId, Date replyTime, Integer replyUserId, String replyContent, String replyImg, String Replier){
        String url="http://127.0.0.1:8082/api/replyposting";
        return this.restTemplate.getForObject(url, Integer.class);
    }
    //删除回复
    public Integer replyPostingDeleteByReplyPostingId( Integer replyPostingId){
        String url="http://127.0.0.1:8082/api/replyposting/"+replyPostingId+"/replyuserid";
        return this.restTemplate.getForObject(url, Integer.class);
    }
}
