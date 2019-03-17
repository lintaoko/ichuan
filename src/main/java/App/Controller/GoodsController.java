package App.Controller;

import App.Domain.Goods;
import App.Service.GoodsService;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class GoodsController {
    @Autowired
    GoodsService goodsService;
    //查询单件货物包括样式名
    @GetMapping("api/goods/{GoodsId}/goodsid/all")
    public Goods queryGoodsAllInfByGoodsId (@PathVariable("GoodsId") Integer goodsId){
       return goodsService.queryGoodsAllInfByGoodsId(goodsId);
    }
    //查询单件货物不包括样式名
    @GetMapping("api/goods/{GoodsId}/goodsid")
    public Goods queryGoodsInfByGoodsId (@PathVariable("GoodsId") Integer goodsId){
        return goodsService.queryGoodsInfByGoodsId(goodsId);
    }
    //查询货物从样式
    @GetMapping("api/goods/{GoodsType}/goodstype")
    public Goods[] queryGoodsInfByGoodsType(@PathVariable("GoodsType")Integer goodsType) {
        return goodsService.queryGoodsInfByGoodsType(goodsType);
    }
    //添加货物
    @PostMapping("api/goods")
    public Integer goodsInsert(String goodsName , String goodsImg , Integer goodsQuantity, JsonObject goodsinf, Integer goodsType){
        return  goodsService.goodsInsert(goodsName, goodsImg, goodsQuantity, goodsinf, goodsType);
    }
    //删除货物
    @DeleteMapping("api/goods/{GoodsId}/goodsid")
    public Integer goodsDeleteByGoodsId (@PathVariable("GoodsId")Integer goodsId){
        return goodsService.goodsDeleteByGoodsId(goodsId);
    }
    //货物数量变更
    @PutMapping("api/goods/{GoodsQuantity}/goodsquantity")
    public Integer goodsUpdateGoodsQuantity (@PathVariable("GoodsQuantity")Integer goodsQuantity){
        return goodsService.goodsUpdateGoodsQuantity(goodsQuantity);
    }
}
