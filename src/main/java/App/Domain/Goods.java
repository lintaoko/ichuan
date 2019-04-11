package App.Domain;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.ToString;
@Data
@ToString
public class Goods {
    private Integer goodsId;
    private String goodsName;
    private String goodsImg;
    private Integer goodsQuantity;
    private String goodsInf;
    private Integer goodsType;
    private String TypeName;
}
