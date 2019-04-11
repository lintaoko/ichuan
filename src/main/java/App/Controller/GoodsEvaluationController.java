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
    @GetMapping("api/goodsevaluation/goodsid")
    public GoodsEvaluation[] queryGoodsEvaluationByGoodsId(@RequestParam Integer goodsEvaluationId){
        return goodsEvaluationService.queryGoodsEvaluationByGoodsId(goodsEvaluationId);
    }
    //评论添加
    @PostMapping("api/goodsevaluation")
    public Integer goodsEvaluationInsert(@RequestBody GoodsEvaluation goodsEvaluation){
        return goodsEvaluationService.goodsEvaluationInsert(goodsEvaluation.getGoodsId(), goodsEvaluation.getEvaluationType(), goodsEvaluation.getEvaluationContent(), goodsEvaluation.getEvaluationImg());
}
    //删除评论
    @DeleteMapping("api/goodsevaluation/goodsEvaluationId")
    public Integer goodsEvaluationDeleteByGoodsEvalutionId( @RequestBody GoodsEvaluation goodsEvaluation){
        return goodsEvaluationService.goodsEvaluationDeleteByGoodsEvalutionId(goodsEvaluation.getGoodsEvaluationId());
    }
}
