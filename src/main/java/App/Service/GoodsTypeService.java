package App.Service;

import App.Domain.GoodsType;
import App.Mapper.GoodsTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GoodsTypeService {
    @Autowired
    private RestTemplate restTemplate;

    //查询类别
    public GoodsType queryGoodsTypeByTypeId(Integer typeid){
        String url="http://127.0.0.1:8081/api/shopcar/"+userId+"/userid";
        return this.restTemplate.getForObject(url,ShopCar.class);
    }
    //增加类别
    public Integer goodsTypeInsert ( String typeName){
        Integer insertResult =goodsTypeMapper.goodsTypeInsert(typeName);
        return insertResult;
    }
    //删除类别
    public Integer goodsTypeDeleteByTypeId(Integer typeId){
        Integer deleteResult =goodsTypeMapper.goodsTypeDeleteByTypeId(typeId);
        return deleteResult;
    }
}
