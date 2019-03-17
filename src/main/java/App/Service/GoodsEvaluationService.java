package App.Service;

import App.Domain.GoodsEvaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@Service
public class GoodsEvaluationService {
    @Autowired
    private RestTemplate restTemplate;
    //评论查询bygoodId
    public GoodsEvaluation[] queryGoodsEvaluationByGoodsId(Integer goodsId){
        String url="http://127.0.0.1:8081/api/goodsevaluation/"+goodsId+"/goodsid";
        GoodsEvaluation[] goodsEvaluations=restTemplate.getForObject(url,GoodsEvaluation[].class);
        return goodsEvaluations;
    }
    //评论添加
    public Integer goodsEvaluationInsert(Integer goodsId,  Date evaluationTime, String evaluationType, String evaluationContent,String evaluationImg){
        String url="http://127.0.0.1:8081/api/goodsevaluation";
        return this.restTemplate.getForObject(url, Integer.class);
    }
    //删除评论
    public Integer goodsEvaluationDeleteByGoodsEvalutionId( Integer goodsEvaluationId){
        String url="http://127.0.0.1:8081/api/goodsevaluation/"+goodsEvaluationId+"/goodsEvaluationId";
        return this.restTemplate.getForObject(url, Integer.class);
    }
}
