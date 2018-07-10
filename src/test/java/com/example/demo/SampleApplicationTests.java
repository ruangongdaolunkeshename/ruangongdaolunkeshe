package com.example.demo;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleApplicationTests {

    @Autowired
    private StudentService studentService;

    @Test
    public void contextLoads() {
    }


    @Test
    public void findAllUsers() {
        List<Student> list = studentService.getAllStudent();
        System.out.println(list);
    }

    @Test
    public void findUserById(String ID) {
        Student user = studentService.searchstudent_ID(ID);
    }

    @Test
    public void updateById() {
        Student newUser = new Student();
        studentService.updateStudent(newUser);
        Student newUser2 = studentService.searchstudent_ID(newUser.ID());
    }


    @Test
    public void createUser() {
        Student user = new Student();
        boolean savedUser = studentService.saveStudent(user);
    }
}



