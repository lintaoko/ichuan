package App.Service;


import App.Domain.SystemManager;
import App.Mapper.SystemManagerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class SystemManagerService {
    @Autowired
    private SystemManagerMapper systemManagerMapper;


    @Transactional

    public SystemManager queryByUserNameAndUserPass(String userName,String userPass){
        SystemManager selectResult=systemManagerMapper.login(userName,userPass);
        return   selectResult;
    }


}
