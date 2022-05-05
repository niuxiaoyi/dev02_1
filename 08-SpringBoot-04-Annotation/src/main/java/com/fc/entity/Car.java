package com.fc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//使用后添加一个构造函数，该构造函数含有所有已声明字段属性参数
@NoArgsConstructor
//使用后创建一个无参构造函数
@AllArgsConstructor
public class Car {
    private String brand;
    private String color;
}
