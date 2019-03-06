package App.Domain;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Data
@ToString
public class GoodsType {
    private Integer typeId;
    private String typeName;
}
