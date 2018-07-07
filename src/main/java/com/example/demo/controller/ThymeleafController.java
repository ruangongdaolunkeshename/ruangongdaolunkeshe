package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
     * @author gacl
     * 获取客户端通过Form表单提交上来的参数
     */
    @RestController
    public class ThymeleafController extends HttpServlet {

        @Autowired
        private StudentService studentService;

        @RequestMapping(value = "/stu/getAllStudent", method = RequestMethod.GET)
        public String getAllstudent(HttpServletRequest request){
            List<Student> list=studentService.getAllStudent();
            System.out.println(list.get(1).username());
            request.setAttribute("student",list);
            return "student";
        }

        @RequestMapping(value = "/stu/WholeFrame", method= RequestMethod.GET)
        public String login(@ModelAttribute("password") Student student) {
            if (studentService.compareStudentpassword(student) == 1)
                return "登陆成功";
            return "登陆失败";
        }

        @RequestMapping(value = "/stu/insert" , method=RequestMethod.GET)
        public String insert(@ModelAttribute("student") Student student){
            if(studentService.searchstudent(student.username()))
                if(studentService.saveStudent(student))
                    return "加入successful";
            return "qwq fault";

        }

        @RequestMapping(value = "/stu/changestudent", method = RequestMethod.GET)
        public String changestudent(@ModelAttribute("student") Student student) {
            studentService.updateStudent(student);
            return "change successful";
        }

        @RequestMapping(value = "/stu/delete", method = RequestMethod.GET)
        public String deleteStudent(@ModelAttribute("student") Student student){
            if(studentService.searchflat(student.username())>1){
                studentService.deleteStudent(student.deletename());
                return "delete";
            }
            return "not enough level, delete fall";
        }
    }

