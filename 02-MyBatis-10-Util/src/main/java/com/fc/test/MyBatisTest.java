package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import com.fc.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {

    @Test
    public void test() {
        try {
            StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

            List<Student> students = studentDao.findAll();

            for (Student student : students) {
                System.out.println(student);
            }

            // 成功就提交
            MyBatisUtil.commit();
        } catch (Exception e) {
            // 失败回滚
            MyBatisUtil.rollback();
            e.printStackTrace();
        }

    }
}
