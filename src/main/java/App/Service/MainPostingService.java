package App.Service;

import App.Domain.MainPosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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
        return this.restTemplate.getForObject(url, MainPosting[].class);
    }
    //主题帖查询byUserId(查询自己的贴子)
    public MainPosting[] queryMainPostingByUserId(Integer userId){
        String url="http://127.0.0.1:8082/api/mainposting/"+userId+"/userid";
        return this.restTemplate.getForObject(url, MainPosting[].class);
    }
    //主题帖搜索
    public MainPosting[] queryMainPostingByLikePostingTitle(String postingTitle){
        String url="http://127.0.0.1:8082/api/mainposting/"+postingTitle+"/postingtitle";
        return this.restTemplate.getForObject(url, MainPosting[].class);
    }
    //发表主题帖
    public Integer mainPostingInsert(Integer userId, String postingTitle, String postingContent, String postAuthor,String postImg){
        String url="http://127.0.0.1:8082/api/mainposting";
        MultiValueMap<String,Object> multiValueMap=new LinkedMultiValueMap<>();
        multiValueMap.add("userId",userId);
        multiValueMap.add("postingTitle",postingTitle);
        multiValueMap.add("postingContent",postingContent);
        multiValueMap.add("postAuthor",postAuthor);
        multiValueMap.add("postImg",postImg);
        return this.restTemplate.postForObject(url, multiValueMap, Integer.class);
    }
    //删除主题帖
    public Integer mainPostingDeleteByMainPostingId(Integer mainPostingId){
        String url="http://127.0.0.1:8082/api/mainposting/"+mainPostingId+"/mainpostingid";
        return this.restTemplate.exchange(url, HttpMethod.DELETE,null,Integer.class).getBody();
    }
}
