package App.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ShopCarService {
    @Autowired
    private RestTemplate restTemplate;

    //todo
//    public Item queryItemById(Long id){
//        String url =itcastItemurl+id;
//        return this.restTemplate.getForObject(url,Item.class);
//    }
}
