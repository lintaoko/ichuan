package App.Controller;

import App.Domain.ShopCar;
import App.Service.ShopCarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class ShopCarController {
    @Autowired
    ShopCarService shopCarService;

    //购物车查询
    @GetMapping("api/shopcar/1/#{UserId}")
    public ShopCar queryShopCarByUserId(@PathVariable("UserId") Integer userId){
        ShopCar result =shopCarService.queryShopCarByUserId(userId);
        return result;
    }
    //购物车添加
    @PutMapping("api/shopcar/1")
    public Integer shopCarInsert (Integer userId,String goodsName,String goodsImg,Double goodsPrice, Integer purchaseQuantity){
        Integer result =shopCarService.shopCarInsert(userId, goodsName, goodsImg, goodsPrice, purchaseQuantity);
        return  result;
    }
    //购物车单项删除
    @DeleteMapping("api/shopcar/1")
    public Integer shopCarDeleteByShopCarId(Integer shopCarId) {
        Integer result =shopCarService.shopCarDeleteByShopCarId(shopCarId);
        return  result;
    }
    //购物车清空
    @DeleteMapping("api/shopcar/2")
    public Integer shopCarDeleteByUserId(Integer userId) {
        Integer result =shopCarService.shopCarDeleteByUserId(userId);
        return result;
    }

}

