package App.Domain;


import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Data
@ToString
public class UserInf {
   private Integer userInfId;
   private Integer userLoginId;
   private String userName;
   private String phone;
   private String address;
   private String email;
   private Integer age;
   private String hobby;
}
