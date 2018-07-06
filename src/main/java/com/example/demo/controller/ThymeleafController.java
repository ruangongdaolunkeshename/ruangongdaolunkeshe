package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

import java.io.IOException;
import java.text.MessageFormat;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
    /**
     * @author gacl
     * 获取客户端通过Form表单提交上来的参数
     */
    @RestController
    public class ThymeleafController extends HttpServlet {

        @Autowired
        private StudentService studentService;

        @RequestMapping(value = "/stu/WholeFrame", method= RequestMethod.GET)
        public String login(@ModelAttribute("password") Student student) {
            if (studentService.compareStudentpassword(student) == 1) ;
            return student.username()+"，是他吧是他吧";
        }

        @RequestMapping(value = "/stu/insert" , method=RequestMethod.GET)
        public String insert(@ModelAttribute("student") Student student){
            studentService.saveStudent(student);
            return "不知所云";
        }

        @RequestMapping(value = "/stu/levelchange", method = RequestMethod.GET)
        public String levelchange(@ModelAttribute("student") Student student){
            studentService.updateStudentlevel(student,student.flat());
            return "恶魔妹妹喵喵喵";
        }

    }

