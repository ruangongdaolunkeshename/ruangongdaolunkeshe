package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @description 
* @author Tim Lin
* @create 2018-07-01 
**/
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/stu/getAllStudent",method = RequestMethod.GET)
    public String getAllStudent(HttpServletRequest request){
        List<Student> list = studentService.getAllStudent();
        request.setAttribute("students",list);
        return "student";
    }

    @RequestMapping(value = "/stu/insert",method = RequestMethod.GET)
    public String insert(@ModelAttribute("student") Student student,Model model){
        studentService.insert(student);
        return "redirect:/stu/getAllStudent";
    }

    @RequestMapping(value = "/stu/update",method = RequestMethod.GET)
    public String update(Model model){
        List<Student> list = studentService.getAllStudent();
//        request.setAttribute("students",list);
        return "student.html";
    }

    @RequestMapping(value = "/stu/index",method = RequestMethod.GET)
    public String indexStu(Model model){
        model.addAttribute("student",new Student());
        return "insert";
    }




    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(Model model){
        return "starter";
    }






    @RequestMapping(value = "/login111",method = RequestMethod.GET)
    public String login(Model model){
        return "login111";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(Model model){
        return "register";
    }

    @RequestMapping(value = "/PPS",method = RequestMethod.GET)
    public String PPS(Model model){
        return "PPS";
    }

    @RequestMapping(value = "/PPSD",method = RequestMethod.GET)
    public String PPSD(Model model){
        return "PPSD";
    }

    @RequestMapping(value = "/PPW",method = RequestMethod.GET)
    public String PPW(Model model){
        return "PPW";
    }

    @RequestMapping(value = "/NMS",method = RequestMethod.GET)
    public String NMS(Model model){
        return "NMS";
    }

    @RequestMapping(value = "/NMW",method = RequestMethod.GET)
    public String NMW(Model model){
        return "NMW";
    }

    @RequestMapping(value = "/IFM",method = RequestMethod.GET)
    public String IFM(Model model){
        return "IFM";
    }

    @RequestMapping(value = "/IDM",method = RequestMethod.GET)
    public String IDM(Model model){
        return "IDM";
    }

    @RequestMapping(value = "/PPR",method = RequestMethod.GET)
    public String PPR(Model model){
        return "PPR";
    }

    @RequestMapping(value = "/STT",method = RequestMethod.GET)
    public String STT(Model model){
        return "STT";
    }

}
