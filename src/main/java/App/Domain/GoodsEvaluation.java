package App.Domain;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Data
@ToString
public class GoodsEvaluation {
    private Integer goodsEvaluationId;
    private Integer goodsId;
    private Date evaluationTime;
    private String evaluationType;
    private String evaluationContent;
    private String evaluationImg;
}
