package App.Domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@ToString
public class SystemManager {
    private  Integer userId;
   private String userName;
   private String userPass;
//    public static void main(String[] args) {
//        User user=new User();
//        user.setName("name");
//        user.setAge(555);
//        log.info(user.toString());
//    }
}
