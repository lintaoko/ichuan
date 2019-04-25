package App.Domain;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
public  enum  Result {
    SUCCESS(200),
    FAULT(400);

    //todo

    private int code;
    public static String toJson(Result result){
            JSONObject object = new JSONObject();
            object.put("code", result.getCode());
        return object.toJSONString();
    }
    public void setCode(int code) {
        this.code = code;
    }
}
