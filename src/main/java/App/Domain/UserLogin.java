package App.Domain;


import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Data
@ToString
public class UserLogin {
   private Integer userLoginId;
   private String accountNumber;
   private String password;
   private String email;
   private String phone;
   private Integer type;
}
