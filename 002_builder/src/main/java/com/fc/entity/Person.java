package com.fc.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Person {
    private String name;
    private Integer age;
    private String gender;
    private Date birthday;
    private String info;
}
