package com.fc.dao;

import com.fc.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    List<Student> findAll();

    //迷糊查询
    List<Student> findByKeyword(@Param("name") String name, @Param("age") Integer age);

    //测试where
    List<Student> findByStudent(Student student);

    //测试trim
    List<Student> findByStudentWithTrim(Student student);

    //修改
    int update(Student student);

    int updateWithTrim(Student student);

    //删除，可变长参数或不定长参数，特点是参数可以是0、1或多个，底层是一个数组
    //可变长参数是jdk1.5的新特性，只能用于方法声明参数列表中的最后一个
    int deleteMore(Integer... ids);
}
