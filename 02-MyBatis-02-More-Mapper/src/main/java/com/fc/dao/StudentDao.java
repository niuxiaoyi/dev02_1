package com.fc.dao;

import com.fc.entity.Student;

import java.util.List;

public interface StudentDao {
    Student select();

    Student insert();

    Student findById();

    List<Student> findAll();

    Student findStudentById(Integer id);
}
