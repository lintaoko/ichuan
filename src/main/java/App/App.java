package App;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;


//@EnableAutoConfiguration
//@ComponentScan("App.App.Controller")
//1.@EnableAutoConfiguration 自动配置 扫包范围默认当前类。
//2.加上扫包范围
@SpringBootApplication
@EnableAsync   //开启异步调用
@MapperScan(basePackages = {"App/Mapper"})//Mapper调用
public class App {
        public static void main(String[] args) {
            //整个程序的入口，启动springboot项目
//        @SpringBootApplication
            // @en..  +@co..  同级包和当前包
            SpringApplication.run(App.class,args);

        }


}
