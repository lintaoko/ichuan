package App.Mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface ShopCarMapper {
    //购物车添加
    @Insert("insert into shopcar(UserId,GoodsName,GoodsImg,GoodsPrice,PurchaseQuantity) VALUES(#{UserId},#{GoodsName},#{GoodsImg},#{GoodsPrice},#{PurchaseQuantity})")
    int shopCarInsert (@Param("UserId") Integer userId,@Param("GoodsName")String goodsName,@Param("GoodsImg")String goodsImg,@Param("GoodsPrice")Double goodsPrice,@Param("PurchaseQuantity") Integer purchaseQuantity);
    //购物车单项删除
    @Delete("delete shopcar where ShopCarId=#{ShopCarId}")
    int shopCarDeleteByShopCarId(@Param("ShopCarId") Integer shopCarId);
    //购物车清空
    @Delete("delete shopcar where UserId=#{UserId}")
    int shopCarDeleteByUserId(@Param("UserId")Integer userId);
}
