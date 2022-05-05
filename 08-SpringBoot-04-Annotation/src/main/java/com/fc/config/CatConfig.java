package com.fc.config;


import com.fc.entity.Cat;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// 相当于交给容器创建一个对象
@Import({Cat.class})
//@Import注解是用来导入配置类或者一些需要前置加载的类.
@Configuration
public class CatConfig {
}
