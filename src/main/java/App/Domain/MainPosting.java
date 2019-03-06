package App.Domain;


import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Data
@ToString
public class MainPosting {
    private Integer mainPostingId;
    private Integer userId;
    private String postingTitle;
    private String postingContent;
    private Date postedTime;
    private String postAuther;
    private String postImg;
}
