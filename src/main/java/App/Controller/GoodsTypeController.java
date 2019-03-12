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
    @GetMapping("api/goodstype/{Typeid}/typeid")
    public GoodsType queryGoodsTypeByTypeId(@PathVariable("Typeid") Integer typeid) {
        GoodsType result = goodsTypeService.queryGoodsTypeByTypeId(typeid);
        return result;
    }

    //增加类别
    @PutMapping("api/goodstype/{TypeName}/typename")
    public Integer goodsTypeInsert(@PathVariable("TypeName") String typeName) {
        Integer result = goodsTypeService.goodsTypeInsert(typeName);
        return result;
    }
    //删除类别
    @DeleteMapping("apo/goodstype/{Typeid}/typeid")
    public Integer goodsTypeDeleteByTypeId(@PathVariable("Typeid")Integer typeId){
        Integer result =goodsTypeService.goodsTypeDeleteByTypeId(typeId);
        return result;
    }
}
