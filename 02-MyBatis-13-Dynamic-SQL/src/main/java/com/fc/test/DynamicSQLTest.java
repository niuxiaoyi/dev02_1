package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import com.fc.util.MyBatisUtil;
import lombok.Data;
import org.junit.Test;

import java.util.List;

public class DynamicSQLTest {
    @Test
    public void testDeleteMore(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        int affectedRows = studentDao.deleteMore(4,6);

        MyBatisUtil.commit();


    }


    @Test
    public void testFindStudentWithTrim(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        Student student = new Student();
//        添加查询条件（可多个）
        student.setGender("女");//查询全部性别女
        student.setId(5);
        List<Student> students = studentDao.findByStudentWithTrim(student);

        for (Student temp : students) {
            System.out.println(temp);
        }
    }
    @Test
    public void testUpdateWithTrim(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        Student student = new Student();
        student.setId(7);
        student.setAge((byte)19);
        student.setName("鹿");

        int affectedRows = studentDao.updateWithTrim(student);

        MyBatisUtil.commit();
    }

    @Test
    public void testUpdate(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        Student student = new Student();
        student.setId(7);
        student.setAge((byte)20);
        student.setInfo("喔嚯");

        int affectedRows = studentDao.update(student);

        MyBatisUtil.commit();
    }

    @Test
    public void testFindStudent(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        Student student = new Student();
        //添加查询条件（可多个）
        student.setGender("女");//查询全部性别女

        List<Student> students = studentDao.findByStudent(student);

        for (Student temp : students) {
            System.out.println(temp);
        }
    }

    @Test
    public void testFindAll(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        List<Student> students = studentDao.findAll();

        for(Student student:students){
            System.out.println(student);
        }
    }

    @Test
    public void testFindByKeyword(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        List<Student> students = studentDao.findByKeyword(null, null);

        for (Student student : students) {
            System.out.println(student);
        }
    }
}
