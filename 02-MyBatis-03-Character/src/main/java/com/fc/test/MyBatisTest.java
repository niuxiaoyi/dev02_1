package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    @Test
    public void testGreaterThan(){
        try {
            // 读取配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            //构建会话工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            //获取绘画连接
            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            List<Student> students = studentDao.findGreaterThanAge(3);

            for(Student student:students){
                System.out.println(student);
            }

            session.commit();

            session.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLessThan(){
        try {
            // 读取配置文件
            InputStream inputStream  = Resources.getResourceAsStream("mybatis-config.xml");

            //构建会话工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            //获取会话连接
            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            List<Student> students = studentDao.findByLessThanAge(31);

            for (Student student:students) {
                System.out.println(student);
            }

            session.commit();

            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
