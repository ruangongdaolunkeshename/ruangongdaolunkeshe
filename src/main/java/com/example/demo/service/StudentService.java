package com.example.demo.service;

import com.example.demo.entity.Proposal;
import com.example.demo.entity.Student;

import java.util.List;

/**
* @description 
* @author Tim Lin
* @create 2018-07-01 
**/

public interface StudentService {
    List<Student> getAllStudent();
    List<Proposal>getAllProposal();
    Boolean saveStudent(Student student);
    Student searchstudent(String username);
    String searchstudent_Name(String ID);//通过文档的ID搜索作者姓名
    Proposal searchproposal_Prop(String ID);//通过文档的ID搜索文档
    int compareStudentpassword(Student student);
    void updateStudent(Student student);
    void deleteStudent(String username);
    int searchflat(String username);
}
