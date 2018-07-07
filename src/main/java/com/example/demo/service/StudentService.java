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
    Boolean searchstudent(String username);
    int compareStudentpassword(Student student);
    void updateStudent(Student student);
    void deleteStudent(String username);
    int searchflat(String username);
}
