package com.fc.dao;

import com.fc.entity.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.annotation.Resources;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface StudentDao {
    // 查询指定年龄的学生
    List<Student> findByAge(String age);

    List<Student> findById(String id);
}
