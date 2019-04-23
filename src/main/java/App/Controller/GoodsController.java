package App.Controller;

import App.Domain.Goods;
import App.Domain.GoodsVo;
import App.Service.GoodsService;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class GoodsController {
    @Autowired
    GoodsService goodsService;
    //查询单件货物包括样式名
    @GetMapping("api/goods/goodsid/all")
    public GoodsVo queryGoodsAllInfByGoodsId (@RequestParam Integer goodsId){
        GoodsVo goodsVo=goodsService.queryGoodsAllInfByGoodsId(goodsId);
        goodsVo.setGoodsInfJson(JSONObject.parseObject(goodsVo.getGoodsInf()));
        return goodsVo;
    }
    //查询单件货物不包括样式名
    @GetMapping("api/goods/goodsid")
    public GoodsVo queryGoodsInfByGoodsId (@RequestParam Integer goodsId){
        GoodsVo goodsVo=goodsService.queryGoodsInfByGoodsId(goodsId);
        goodsVo.setGoodsInfJson(JSONObject.parseObject(goodsVo.getGoodsInf()));
        return goodsVo;
    }
    //查询货物从样式
    @GetMapping("api/goods/goodstype")
    public Map queryGoodsInfByGoodsType(@RequestParam Integer goodsType, Integer pageNum, Integer pageSize) {
        return goodsService.queryGoodsInfByGoodsType(goodsType,pageNum,pageSize);
    }
    //添加货物
    @PostMapping("api/goods")
    public Integer goodsInsert(@RequestBody GoodsVo goods){
        return  goodsService.goodsInsert(goods.getGoodsName(), goods.getGoodsImg(), goods.getGoodsQuantity(), goods.getGoodsInf(), goods.getGoodsType());
    }
    //删除货物
    @DeleteMapping("api/goods/goodsid")
    @RolesAllowed("ADMIN")
    public Integer goodsDeleteByGoodsId (@RequestBody Goods goods){
        return goodsService.goodsDeleteByGoodsId(goods.getGoodsId());
    }
    //货物数量变更
    @PutMapping("api/goods/goodsquantity")
    public Integer goodsUpdateGoodsQuantity (@RequestBody Goods goods){
        return goodsService.goodsUpdateGoodsQuantity(goods.getGoodsQuantity());
    }
}
