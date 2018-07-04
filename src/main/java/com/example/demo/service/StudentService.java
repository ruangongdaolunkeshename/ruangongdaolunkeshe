package com.example.demo.service;

import com.example.demo.entity.Student;

import java.util.List;

/**
* @description 
* @author Tim Lin
* @create 2018-07-01 
**/

public interface StudentService {
    List<Student> getAllStudent();
    Student saveStudent(Student student);
    Student getStudentid(String id);
    Student updateStudent(Student student);
    void deleteStudent(String id);
}
