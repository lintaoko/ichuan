package App.Service;

import App.Domain.GoodsEvaluation;
import App.Mapper.GoodsEvaluationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class GoodsEvaluationService {
    @Autowired
    GoodsEvaluationMapper goodsEvaluationMapper;

    //评论查询
    public GoodsEvaluation queryGoodsEvaluationByGoodsId(Integer goodsId){
        GoodsEvaluation selectResult =goodsEvaluationMapper.queryGoodsEvaluationByGoodsId(goodsId);
        return selectResult;
    }
    //评论添加
    public Integer goodsEvaluationInsert(Integer goodsId,  Date evaluationTime, String evaluationType, String evaluationContent,String evaluationImg){
        Integer insertResult =goodsEvaluationMapper.goodsEvaluationInsert(goodsId, evaluationTime, evaluationType, evaluationContent, evaluationImg);
        return  insertResult;
    }
    //删除评论
    public Integer goodsEvaluationDeleteByGoodsEvalutionId( Integer goodsEvaluationId){
        Integer deleteResult =goodsEvaluationMapper.goodsEvaluationDeleteByGoodsEvalutionId(goodsEvaluationId);
        return  deleteResult;
    }



}
