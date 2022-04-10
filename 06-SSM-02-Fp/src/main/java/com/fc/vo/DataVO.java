package com.fc.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataVO<T> {//泛型类中才能用泛型成员变量
    private Long total;
    private List<T> list;
    private Integer pageNum;
    private Integer pageSize;
}
