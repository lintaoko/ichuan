package App.Controller;

import App.Domain.GoodsEvaluation;
import App.Service.GoodsEvaluationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Slf4j
public class GoodsEvaluationController {
    @Autowired
    GoodsEvaluationService goodsEvaluationService;
    //评论查询
    @GetMapping("api/goodsevaluation/{GoodsID}/goodsid")
    public GoodsEvaluation[] queryGoodsEvaluationByGoodsId(@PathVariable("GoodsID") Integer goodsId){
        return goodsEvaluationService.queryGoodsEvaluationByGoodsId(goodsId);
    }
    //评论添加
    @PostMapping("api/goodsevaluation")
    public Integer goodsEvaluationInsert(Integer goodsId, String evaluationType, String evaluationContent,String evaluationImg){
        return goodsEvaluationService.goodsEvaluationInsert(goodsId, evaluationType, evaluationContent, evaluationImg);
}
    //删除评论
    @DeleteMapping("api/goodsevaluation/{GoodsEvaluationId}/goodsEvaluationId")
    public Integer goodsEvaluationDeleteByGoodsEvalutionId( @PathVariable("GoodsEvaluationId") Integer goodsEvaluationId)throws Exception{
        Integer deleteResult =goodsEvaluationService.goodsEvaluationDeleteByGoodsEvalutionId(goodsEvaluationId);
        return  deleteResult;
    }
}
