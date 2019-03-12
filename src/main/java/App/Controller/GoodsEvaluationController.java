package App.Controller;

import App.Domain.GoodsEvaluation;
import App.Service.GoodsEvaluationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@Slf4j
public class GoodsEvaluationController {
    @Autowired
    GoodsEvaluationService goodsEvaluationService;
    //评论查询
    @GetMapping("api/goodsevaluation/{GoodsID}/goodsid")
    public GoodsEvaluation queryGoodsEvaluationByGoodsId(@PathVariable("GoodsID") Integer goodsId){
        GoodsEvaluation result =goodsEvaluationService.queryGoodsEvaluationByGoodsId(goodsId);
        return result;
    }
    //评论添加
    @PutMapping("api/goodsevaluation/")
    public Integer goodsEvaluationInsert(Integer goodsId, Date evaluationTime, String evaluationType, String evaluationContent,String evaluationImg){
        Integer result =goodsEvaluationService.goodsEvaluationInsert(goodsId, evaluationTime, evaluationType, evaluationContent, evaluationImg);
        return  result;
}
    //删除评论
    @DeleteMapping("api/goodsevaluation/{GoodsEvaluationId}/goodsEvaluationId")
    public Integer goodsEvaluationDeleteByGoodsEvalutionId( @PathVariable("GoodsEvaluationId") Integer goodsEvaluationId){
        Integer deleteResult =goodsEvaluationService.goodsEvaluationDeleteByGoodsEvalutionId(goodsEvaluationId);
        return  deleteResult;
    }

}
