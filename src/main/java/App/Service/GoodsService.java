package App.Service;

import App.Domain.Goods;
import App.Mapper.GoodsMapper;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    //查询单件货物包括样式名
    public Goods queryGoodsAllInfByGoodsId(Integer goodsId) {
        Goods selectResult = goodsMapper.queryGoodsAllInfByGoodsId(goodsId);
        return selectResult;
    }

    //查询单件货物不包括样式名
    public Goods queryGoodsInfByGoodsId(Integer goodsId) {
        Goods selectResult = goodsMapper.queryGoodsInfByGoodsId(goodsId);
        return selectResult;
    }

    //查询货物从样式
    public ArrayList<Goods> queryGoodsInfByGoodsType(Integer goodsType) {
        ArrayList<Goods> selectResult = goodsMapper.queryGoodsInfByGoodsTyp(goodsType);
        return selectResult;
    }

    //添加货物
    public Integer goodsInsert(String goodsName ,String goodsImg , Integer goodsQuantity, JsonObject goodsinf,Integer goodsType){
        Integer insertResult = goodsMapper.goodsInsert(goodsName, goodsImg, goodsQuantity, goodsinf, goodsType);
        return insertResult;
    }
    //删除货物
    public Integer goodsDeleteByGoodsId (Integer goodsId){
        Integer deleteResult =goodsMapper.goodsDeleteByGoodsId(goodsId);
        return deleteResult;
    }
    //货物数量变更
    public Integer goodsUpdateGoodsQuantity (Integer goodsQuantity){
        Integer updateResult =goodsMapper.goodsUpdateGoodsQuantity(goodsQuantity);
        return  updateResult;
    }


}
