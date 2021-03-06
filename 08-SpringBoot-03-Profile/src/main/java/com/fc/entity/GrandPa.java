package com.fc.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("student")
@Profile("test")
public class GrandPa implements Student{
    private String name;
    private Integer age;
}
