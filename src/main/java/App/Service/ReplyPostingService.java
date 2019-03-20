package App.Service;

import App.Domain.ReplyPosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@Service
public class ReplyPostingService {
    @Autowired
    private RestTemplate restTemplate;
    //查询自己的回复贴
    public ReplyPosting[] queryReplyPostingByReplyUserId(Integer replyUserId){
        String url="http://127.0.0.1:8082/api/replyposting/"+replyUserId+"/replyuserid";
        return this.restTemplate.getForObject(url,ReplyPosting[].class);
    }
    //查询主题帖的回复贴
    public ReplyPosting[] queryReplyPostingByMainPostingId(Integer mainPostingId){
        String url="http://127.0.0.1:8082/api/replyposting/"+mainPostingId+"/mainpostingid";
        return this.restTemplate.getForObject(url,ReplyPosting[].class);
    }
    //查询主题帖中某人的回复贴(只看楼主)
    public ReplyPosting[] queryReplyPostingByMainPostingIdAndReplyUserId(Integer mainPostingId, Integer replyUserId){
        String url="http://127.0.0.1:8082/api/replyposting/"+mainPostingId+"/mainpostingid/"+replyUserId+"/replyuserid";
        return this.restTemplate.getForObject(url, ReplyPosting[].class);
    }
    //回复主题帖
    public Integer replyPostingInsert(Integer mainPostingId, Integer replyUserId, String replyContent, String replyImg, String Replier){
        String url="http://127.0.0.1:8082/api/replyposting";
        MultiValueMap<String,Object> multiValueMap=new LinkedMultiValueMap<>();
        multiValueMap.add("mainPostingId",mainPostingId);
        multiValueMap.add("replyUserId",replyUserId);
        multiValueMap.add("replyContent",replyContent);
        multiValueMap.add("replyImg",replyImg);
        multiValueMap.add("Replier",Replier);
        return this.restTemplate.postForObject(url, multiValueMap, Integer.class);
    }
    //删除回复
    public Integer replyPostingDeleteByReplyPostingId( Integer replyPostingId){
        String url="http://127.0.0.1:8082/api/replyposting/"+replyPostingId+"/replyuserid";
        return this.restTemplate.exchange(url, HttpMethod.DELETE,null,Integer.class).getBody();
    }
}
