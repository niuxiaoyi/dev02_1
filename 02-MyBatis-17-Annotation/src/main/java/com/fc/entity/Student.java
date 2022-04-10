package com.fc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {
    // Field成员变量、Method成员方法、Constructor构造方法、Inner Class内部类
    private Integer id;
    private String name;
    private Byte age;
    private String gender;
    private Data birthday;
    private String info;



}
