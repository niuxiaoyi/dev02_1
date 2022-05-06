package com.fc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication
//加到配置类中
//@EnableSwagger2WebMvc
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
