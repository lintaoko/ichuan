package App.Service;

import App.Domain.MainPosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@Service
public class MainPostingService {
    @Autowired
    private RestTemplate restTemplate;
    //主题帖获取
    public MainPosting[] queryAllMainPosting(){
        String url="http://127.0.0.1:8082/api/mainposting";
        MainPosting[] mainPostings=restTemplate.getForObject(url, MainPosting[].class);
        return mainPostings;
    }
    //主题帖查询byUserId(查询自己的贴子)
    public MainPosting[] queryMainPostingByUserId(Integer userId){
        String url="http://127.0.0.1:8082/api/mainposting/"+userId+"/userid";
        MainPosting[] mainPostings=restTemplate.getForObject(url, MainPosting[].class);
        return mainPostings;
    }
    //主题帖搜索
    public MainPosting[] queryMainPostingByLikePostingTitle(String postingTitle){
        String url="http://127.0.0.1:8082/api/mainposting/"+postingTitle+"/postingtitle";
        MainPosting[] mainPostings=restTemplate.getForObject(url, MainPosting[].class);
        return mainPostings;
    }
    //发表主题帖
    public Integer mainPostingInsert(Integer userId, String postingTitle, String postingContent, Date postedTime, String postAuther,String postImg){
        String url="http://127.0.0.1:8082/api/mainposting/";
        return this.restTemplate.getForObject(url, Integer.class);
    }
    //删除主题帖
    public Integer mainPostingDeleteByMainPostingId(Integer mainPostingId){
        String url="http://127.0.0.1:8082/api/mainposting/"+mainPostingId+"/mainpostingid";
        return this.restTemplate.getForObject(url, Integer.class);
    }


}
