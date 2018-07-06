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
    Boolean saveStudent(Student student);
    int compareStudentpassword(Student student);
    int updateStudentlevel(Student student, int flat);
    void deleteStudent(String username);
}
