package App;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class SpringTest {
    @Autowired
    StringEncryptor encryptor;
    @Test
    public void getPass() {
        String url = encryptor.encrypt("jdbc:mysql://www.f00w.com:3306/ichuan?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT&useSSL=false");
        String name = encryptor.encrypt("dd");
        String password = encryptor.encrypt("zx123456");
        System.out.println(url+"----------------");
        System.out.println(name+"----------------");
        System.out.println(password+"----------------");
    }
}
