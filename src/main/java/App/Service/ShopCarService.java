package App.Service;

import App.Domain.ShopCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ShopCarService {
    @Autowired
    private RestTemplate restTemplate;

    //购物车查询
    public ShopCar queryShopCarByUserId(Integer userId){
        String url="http://127.0.0.1:8081/api/shopcar/1/"+userId;
        return this.restTemplate.getForObject(url,ShopCar.class);
    }
    //购物车添加
    public Integer shopCarInsert (Integer userId,String goodsName,String goodsImg,Double goodsPrice, Integer purchaseQuantity){
        String url="http://127.0.0.1:8081/api/shopcar/1";
        return this.restTemplate.getForObject(url,Integer.class);
    }
    //购物车单项删除
    public Integer shopCarDeleteByShopCarId(Integer shopCarId){
        String url="http://127.0.0.1:8081/api/shopcar/1";
        return this.restTemplate.getForObject(url,Integer.class);
    }
    public Integer shopCarDeleteByUserId(Integer userId){
        String url="http://127.0.0.1:8081/api/shopcar/1";
        return this.restTemplate.getForObject(url,Integer.class);
    }
    //todo
//    public Item queryItemById(Long id){
//        String url =itcastItemurl+id;
//        return this.restTemplate.getForObject(url,Item.class);
//    }
}
