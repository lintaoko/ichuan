package App.Service;

import App.Domain.ShopCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ShopCarService {
    @Autowired
    private RestTemplate restTemplate;
    //购物车查询
    public ShopCar[] queryShopCarByUserId(Integer userId){
        String url="http://127.0.0.1:8081/api/shopcar/"+userId+"/userid";
        return this.restTemplate.getForObject(url,ShopCar[].class);
    }
    //购物车添加
    public Integer shopCarInsert (Integer userId,String goodsName,String goodsImg,Double goodsPrice, Integer purchaseQuantity){
        String url="http://127.0.0.1:8081/api/shopcar";
        MultiValueMap<String,Object> multiValueMap=new LinkedMultiValueMap<>();
        multiValueMap.add("userId",userId);
        multiValueMap.add("goodsName",goodsName);
        multiValueMap.add("goodsImg",goodsImg);
        multiValueMap.add("goodsPrice",goodsPrice);
        multiValueMap.add("purchaseQuantity",purchaseQuantity);
        return this.restTemplate.postForObject(url, multiValueMap, Integer.class);
    }
    //购物车单项删除
    public Integer shopCarDeleteByShopCarId(Integer shopCarId){
        String url="http://127.0.0.1:8081/api/shopcar/"+shopCarId+"/shopcarid";
        return this.restTemplate.exchange(url, HttpMethod.DELETE,null,Integer.class).getBody();
    }
    //清空购物车
    public Integer shopCarDeleteByUserId(Integer userId){
        String url="http://127.0.0.1:8081/api/shopcar/"+userId+"/userid";
        return this.restTemplate.exchange(url, HttpMethod.DELETE,null,Integer.class).getBody();
    }

}
