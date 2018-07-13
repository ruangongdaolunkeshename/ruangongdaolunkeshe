package com.example.demo.service;

import com.example.demo.entity.Proposal;
import com.example.demo.entity.Student;

import java.io.IOException;
import java.util.List;

/**
* @description 
* @author Tim Lin
* @create 2018-07-01 
**/

public interface StudentService {
    List<Student> getAllStudent();
    List<Proposal>getAllProposal();
    List<Proposal>getAllProposalByFlat(String flat);
    boolean UpdateProposalFlat(String Id,String Flat);//升级文档等级
    boolean UpdateProposalAllFlat(String Flat);//升级所有文档等级
    Boolean saveStudent(Student student);
    Boolean saveProposal(Proposal proposal) throws IOException;
    Student searchstudent(String username);
    Student searchstudent_ID(String ID);//通过用户ID搜索用户
    String searchstudent_Name(String ID);//通过文档的ID搜索作者姓名
    Proposal searchproposal_Prop(String ID);//通过文档的ID搜索文档
    int compareStudentpassword(Student student);
    void updateStudent(Student student);
    void deleteStudent(String username);
    void deleteProposal(String Id);
    void deleteAllProposal(String Flat);
    int searchflat(String username);

    String getContent(String Id) throws IOException;//获取文档内容

}
