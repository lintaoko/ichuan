package App;


import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;


import javax.servlet.MultipartConfigElement;
import java.util.Properties;


//@EnableAutoConfiguration
//@ComponentScan("App.App.Controller")
//1.@EnableAutoConfiguration 自动配置 扫包范围默认当前类。
//2.加上扫包范围
@SpringBootApplication
//@EnableAsync   //开启异步调用
@MapperScan(basePackages = {"App/Mapper"})//Mapper调用
public class App   {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
    @Bean
    public RestTemplate restTemplate(){
//        return new RestTemplate();
        //整合okhttp
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory=new MultipartConfigFactory();
        factory.setLocation("D:/Project/ichuan粉丝站后台管理系统/src/main/resources/");
        return factory.createMultipartConfig();
    }
        public static void main(String[] args) {
            //整个程序的入口，启动springboot项目
//        @SpringBootApplication
            // @en..  +@co..  同级包和当前包
            SpringApplication.run(App.class,args);
        }
}

