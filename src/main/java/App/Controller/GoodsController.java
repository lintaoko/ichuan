package App.Controller;

import App.Domain.Goods;
import App.Service.GoodsService;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class GoodsController {
    @Autowired
    GoodsService goodsService;
    //查询单件货物包括样式名
    @GetMapping("api/goods/goodsid/all")
    public Goods queryGoodsAllInfByGoodsId (@RequestBody Goods goods){
       return goodsService.queryGoodsAllInfByGoodsId(goods.getGoodsId());
    }
    //查询单件货物不包括样式名
    @GetMapping("api/goods/goodsid")
    public Goods queryGoodsInfByGoodsId (@RequestBody Goods goods){
        return goodsService.queryGoodsInfByGoodsId(goods.getGoodsId());
    }
    //查询货物从样式
    @GetMapping("api/goods/goodstype")
    public Goods[] queryGoodsInfByGoodsType(@RequestBody Goods goods) {
        return goodsService.queryGoodsInfByGoodsType(goods.getGoodsType());
    }
    //添加货物
    @PostMapping("api/goods")
    @RolesAllowed("ADMIN")
    public Integer goodsInsert(@RequestBody Goods goods){
        return  goodsService.goodsInsert(goods.getGoodsName(), goods.getGoodsImg(), goods.getGoodsQuantity(), goods.getGoodInf(), goods.getGoodsType());
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
