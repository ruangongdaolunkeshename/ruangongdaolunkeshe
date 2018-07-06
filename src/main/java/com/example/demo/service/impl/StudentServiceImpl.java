package com.example.demo.service.impl;

import com.example.demo.dao.StudentDAO;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if(student.password()==studentDAO.search(student.username()))
            return 1;
        return 0;
    }

    @Override
    public int updateStudentlevel(Student student, int flat){
        return studentDAO.updatelevel(student.username(),flat);
    }

    @Override
    public void deleteStudent(String username){
        studentDAO.delete(username);
    }

}
