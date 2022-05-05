package com.fc.dao;

import com.fc.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//其实没用，但是可以不让service报错
//@Repository

//@Mapper
public interface StudentDao {
    List<Student> findAll();
}
