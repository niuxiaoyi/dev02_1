package com.fc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

//纯启动器---只有启动功能
//Controller|ResponseBody
//@RestController
//开启自动装配
//@EnableAutoConfiguration
//当前SpringBoot项目的启动项
@SpringBootApplication
public class MyApplication {

    //请求路径
//    @RequestMapping("/")
//    String home() {
//        return "Hello World!";
//    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));

        SpringApplication.run(MyApplication.class, args);
    }

}

