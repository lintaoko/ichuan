package App.Config;

import App.Domain.Result;
import App.Domain.UserLogin;
import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.xdevapi.JsonArray;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        PrintWriter out;
        UserLogin userLogin=(UserLogin) authentication.getPrincipal();
        try {
            out = httpServletResponse.getWriter();
            JSONObject object = (JSONObject) JSONObject.toJSON(userLogin);
            object.put("code",Result.SUCCESS.getCode());
            System.out.println(object.toString());
            out.append(JSONObject.toJSONString(object));
        }
        catch (Exception e){
            e.printStackTrace();
            httpServletResponse.sendError(500);
        }
    }
}

