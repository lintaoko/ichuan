package App.Controller;

import App.Domain.GoodsType;
import App.Service.GoodsTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class GoodsTypeController {
    @Autowired
    GoodsTypeService goodsTypeService;

    //查询类别
    @GetMapping("api/goodstype/typeid")
    public GoodsType queryGoodsTypeByTypeId(@RequestBody GoodsType goodsType) {
        return goodsTypeService.queryGoodsTypeByTypeId(goodsType.getTypeId());
    }
    //增加类别
    @PostMapping("api/goodstype/typename")
    public Integer goodsTypeInsert(@RequestBody GoodsType goodsType) {
        return goodsTypeService.goodsTypeInsert(goodsType.getTypeName());
    }
    //删除类别
    @DeleteMapping("apo/goodstype/typeid")
    public Integer goodsTypeDeleteByTypeId(@RequestBody GoodsType goodsType){
        return goodsTypeService.goodsTypeDeleteByTypeId(goodsType.getTypeId());
    }
}
