package App.Domain;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;

@Data
@ToString
public class ShopCar {
    private Integer shopCarId;
    private Integer userId;
    private String goodsName;
    private String goodsImg;
    private Double goodsPrice;
    private Integer purchaseQuantity;

}
