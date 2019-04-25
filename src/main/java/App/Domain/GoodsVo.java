package App.Domain;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class GoodsVo extends Goods{
    private JSONObject goodsInfJson;
}
