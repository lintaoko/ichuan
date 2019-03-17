package App.Service;

import App.Domain.GoodsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GoodsTypeService {
    @Autowired
    private RestTemplate restTemplate;

    //查询类别
    public GoodsType queryGoodsTypeByTypeId(Integer typeid){
        String url="http://127.0.0.1:8081/api/goodstype/"+typeid+"/typeid";
        return this.restTemplate.getForObject(url,GoodsType.class);
    }
    //增加类别
    public Integer goodsTypeInsert ( String typeName){
        String url="http://127.0.0.1:8081/api/goodstype/"+typeName+"/typename";
        return this.restTemplate.getForObject(url,Integer.class);
    }
    //删除类别
    public Integer goodsTypeDeleteByTypeId(Integer typeId){
        String url="http://127.0.0.1:8081/api/goodstype/"+typeId+"/typeid";
        return this.restTemplate.getForObject(url,Integer.class);
    }
}
