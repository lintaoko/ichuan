package App.Domain;

import com.google.gson.JsonObject;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Goods {
    private Integer goodsId;
    private String goodsName;
    private String goodsImg;
    private Integer goodsQuantity;
    private JsonObject goodInf;
    private Integer goodsType;
    private String goodsTypeName;
}
