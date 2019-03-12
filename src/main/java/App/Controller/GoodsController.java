package App.Controller;

import App.Domain.Goods;
import App.Service.GoodsService;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@Slf4j
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    //查询单件货物包括样式名
    @GetMapping("api/goods/{GoodsId}/goodsid/all")
    public Goods queryGoodsAllInfByGoodsId (@PathVariable("GoodsId") Integer goodsId){
        Goods result =goodsService.queryGoodsAllInfByGoodsId(goodsId);
        System.out.println(result);
        return result;
    }
    //查询单件货物不包括样式名
    @GetMapping("api/goods/{GoodsId}/goodsid")
    public Goods queryGoodsInfByGoodsId (@PathVariable("GoodsId") Integer goodsId){
        Goods result =goodsService.queryGoodsInfByGoodsId(goodsId);
        System.out.println(result);
        return result;
    }
    //查询货物从样式
    @GetMapping("api/goods/{GoodsType}/goodstype")
    public ArrayList<Goods> queryGoodsInfByGoodsType(@PathVariable("GoodsType")Integer goodsType) {
        ArrayList<Goods> result=goodsService.queryGoodsInfByGoodsType(goodsType);
        return result;
    }
    //添加货物
    @PostMapping("api/goods/")
    public Integer goodsInsert(String goodsName , String goodsImg , Integer goodsQuantity, JsonObject goodsinf, Integer goodsType){
        Integer result = goodsService.goodsInsert(goodsName, goodsImg, goodsQuantity, goodsinf, goodsType);
        return result;
    }
    //删除货物
    @DeleteMapping("api/goods/{GoodsId}/goodsid")
    public Integer goodsDeleteByGoodsId (@PathVariable("GoodsId")Integer goodsId){
        Integer result =goodsService.goodsDeleteByGoodsId(goodsId);
        return result;
    }
    //货物数量变更
    @PutMapping("api/goods/{GoodsQuantity}/goodsquantity")
    public Integer goodsUpdateGoodsQuantity (@PathVariable("GoodsQuantity")Integer goodsQuantity){
        Integer result =goodsService.goodsUpdateGoodsQuantity(goodsQuantity);
        return  result;
    }
}
