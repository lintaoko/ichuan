package App.Service;

import App.Domain.GoodsEvaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class GoodsEvaluationService {
    @Autowired
    private RestTemplate restTemplate;
    //评论查询bygoodId
    public GoodsEvaluation[] queryGoodsEvaluationByGoodsId(Integer goodsId){
        String url="http://127.0.0.1:8081/api/goodsevaluation/"+goodsId+"/goodsid";
        return this.restTemplate.getForObject(url,GoodsEvaluation[].class);
    }
    //评论添加
    public Integer goodsEvaluationInsert(Integer goodsId ,String evaluationType, String evaluationContent,String evaluationImg){
        String url="http://127.0.0.1:8081/api/goodsevaluation";
        MultiValueMap<String,Object> multiValueMap=new LinkedMultiValueMap<>();
        multiValueMap.add("goodsId",goodsId);
        multiValueMap.add("evaluationType",evaluationType);
        multiValueMap.add("evaluationContent",evaluationContent);
        multiValueMap.add("evaluationImg",evaluationImg);
        return this.restTemplate.postForObject(url, multiValueMap, Integer.class);
    }
    //删除评论
    public Integer goodsEvaluationDeleteByGoodsEvalutionId( Integer goodsEvaluationId){
        String url="http://127.0.0.1:8081/api/goodsevaluation/"+goodsEvaluationId+"/goodsEvaluationId";
        return this.restTemplate.exchange(url, HttpMethod.DELETE,null,Integer.class).getBody();
    }
}
