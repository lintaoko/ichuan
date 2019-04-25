package App.Controller;

import App.Domain.ShopCar;
import App.Service.ShopCarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ShopCarController {
    @Autowired
    ShopCarService shopCarService;
    //购物车查询
    @GetMapping("api/shopcar/userid")
    public ShopCar[] queryShopCarByUserId(@RequestParam Integer userId){
        return shopCarService.queryShopCarByUserId(userId);
    }
    //购物车添加
    @PostMapping("api/shopcar")
    public Integer shopCarInsert (@RequestBody ShopCar shopCar){
        return shopCarService.shopCarInsert(shopCar.getUserId(), shopCar.getGoodsName(), shopCar.getGoodsImg(), shopCar.getGoodsPrice(), shopCar.getPurchaseQuantity());
    }
    //购物车单项删除
    @DeleteMapping("api/shopcar/shopcarid")
    public Integer shopCarDeleteByShopCarId(@RequestBody ShopCar shopCar) {
        return shopCarService.shopCarDeleteByShopCarId(shopCar.getShopCarId());
    }
    //购物车清空
    @DeleteMapping("api/shopcar/userid")
    public Integer shopCarDeleteByUserId(@RequestBody ShopCar shopCar) {
        return shopCarService.shopCarDeleteByUserId(shopCar.getUserId());
    }
}

