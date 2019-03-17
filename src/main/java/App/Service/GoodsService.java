package App.Service;

import App.Domain.Goods;
import App.Domain.GoodsType;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsService {
    @Autowired
    private RestTemplate restTemplate;
    //查询单件货物包括样式名
    public Goods queryGoodsAllInfByGoodsId(Integer goodsId) {
        String url="http://127.0.0.1:8081/api/goods/"+goodsId+"/goodsid/all";
        return this.restTemplate.getForObject(url, Goods.class);
    }
    //查询单件货物不包括样式名
    public Goods queryGoodsInfByGoodsId(Integer goodsId) {
        String url="http://127.0.0.1:8081/api/goods/"+goodsId+"/goodsid";
        return this.restTemplate.getForObject(url, Goods.class);
    }
    //查询货物BygoodType
    public Goods[] queryGoodsInfByGoodsType(Integer goodsType) {
        String url="http://127.0.0.1:8081/api/goods/"+goodsType+"/goodstype";
        return this.restTemplate.getForObject(url, Goods[].class);
    }
    //添加货物
    public Integer goodsInsert(String goodsName ,String goodsImg , Integer goodsQuantity, JsonObject goodsinf,Integer goodsType){
        String url="http://127.0.0.1:8081/api/goods";
        MultiValueMap<String,Object> multiValueMap=new LinkedMultiValueMap<>();
        multiValueMap.add("goodsName",goodsName);
        multiValueMap.add("goodsImg",goodsImg);
        multiValueMap.add("goodsQuantity",goodsQuantity);
        multiValueMap.add("goodsinf",goodsinf);
        multiValueMap.add("goodsType",goodsType);
        return this.restTemplate.postForObject(url, multiValueMap, Integer.class);
    }
    //删除货物
    public Integer goodsDeleteByGoodsId (Integer goodsId){
        String url="http://127.0.0.1:8081/api/goods/"+goodsId+"/goodsid";
        return this.restTemplate.exchange(url, HttpMethod.DELETE,null,Integer.class).getBody();
    }
    //货物数量变更
    public Integer goodsUpdateGoodsQuantity (Integer goodsQuantity){
        String url="http://127.0.0.1:8081/api/goods/"+goodsQuantity+"/goodsquantity";
        return this.restTemplate.exchange(url, HttpMethod.PUT,null,Integer.class).getBody();
    }
}