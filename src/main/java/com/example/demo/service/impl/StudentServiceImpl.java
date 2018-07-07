package com.example.demo.service.impl;

import com.example.demo.dao.StudentDAO;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;

/**
* @description 
* @author Tim Lin
* @create 2018-07-01 
**/

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDAO studentDAO;

    @Override
    public List<Student> getAllStudent() {
        return studentDAO.getAllStudent();
    }

    @Override
    public Boolean saveStudent(Student student){
        if(null==student)
            return false;
        else
            studentDAO.insert(student);
        return true;
    }

    @Override
    public int compareStudentpassword(Student student){
        if(student.password().equals(studentDAO.search(student.username()).password()))
            return 1;
        return 0;
    }

    @Override
    public Boolean searchstudent(String username){
        if(studentDAO.search(username)== null)
            return true;
        return false;
    }

    @Override
    public void updateStudent(Student student){
        Student s=studentDAO.search(student.username());
        studentDAO.delete(student.username());
        if(student.password()!=null)
            s.setpassword(student.password());
        if(student.committee()!=null)
            s.setcommitte(student.committee());
        if(student.flat()!=null)
            s.setflat(student.flat());
        if(student.people()!=null)
            s.setpeople(student.people());
        if(student.name()!=null)
            s.setname(student.name());
        if(student.address()!=null)
            s.setaddress(student.address());
        if(student.birthday()!=null)
            s.setbirthday(student.birthday());
        if(student.branch()!=null)
            s.setbranch(student.branch());
        if(student.username()!=null)
            s.setusername(student.changeusername());
        if(student.telephone()!=null)
            s.settelephone(student.telephone());
        if(student.sex()!=null)
            s.setsex(student.sex());
        studentDAO.insert(s);
    }

    @Override
    public void deleteStudent(String username){
        studentDAO.delete(username);
    }

    @Override
    public int searchflat(String username){
        return studentDAO.searchflat(username);
    }

}
