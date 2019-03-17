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
    @GetMapping("api/shopcar/{UserId}/userid")
    public ShopCar[] queryShopCarByUserId(@PathVariable("UserId") Integer userId){
        return shopCarService.queryShopCarByUserId(userId);
    }
    //购物车添加
    @PostMapping("api/shopcar")
    public Integer shopCarInsert (Integer userId,String goodsName,String goodsImg,Double goodsPrice, Integer purchaseQuantity){
        return shopCarService.shopCarInsert(userId, goodsName, goodsImg, goodsPrice, purchaseQuantity);
    }
    //购物车单项删除
    @DeleteMapping("api/shopcar/{ShopCar}/shopcarid")
    public Integer shopCarDeleteByShopCarId(@PathVariable("ShopCar") Integer shopCarId) {
        return shopCarService.shopCarDeleteByShopCarId(shopCarId);
    }
    //购物车清空
    @DeleteMapping("api/shopcar/{UserId}/userid")
    public Integer shopCarDeleteByUserId(@PathVariable("UserId") Integer userId) {
        return shopCarService.shopCarDeleteByUserId(userId);
    }
}

