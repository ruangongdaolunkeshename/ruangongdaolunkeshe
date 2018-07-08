package com.example.demo.controller;

import com.example.demo.entity.Proposal;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import com.sun.org.apache.bcel.internal.generic.MONITORENTER;
import org.mybatis.spring.annotation.MapperScan;
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

public class StudentController{

    @Autowired
    private StudentService studentService;

    /*
     *注册与登录，需求1
     */

    //注册
    @RequestMapping(value = "/in/reg",method = RequestMethod.GET)
    public String indexStu(Model model){
        model.addAttribute("student",new Student());
        return "Register";
    }

    @RequestMapping(value = "/out/reg", method= RequestMethod.GET)
    public String Register(@ModelAttribute("student") Student student,Model model) {
        studentService.saveStudent(student);
        return "redirect:/in/login";
    }
    //登录
    @RequestMapping(value = "/in/login",method = RequestMethod.GET)
    public String Login(Model model){
        model.addAttribute("student",new Student());
        return "Login";
    }
    @RequestMapping(value = "/out/login",method = RequestMethod.GET)
    public String index(@ModelAttribute("student") Student student){
        if (studentService.compareStudentpassword(student) == 1)
            return "redirect:/in/index";
        else
            return "redirect:/in/error";
    }
    @RequestMapping(value = "/in/error",method = RequestMethod.GET)
    public String Login_error(HttpServletRequest request){
        return "Login_error";
    }


    /*
    *文件读写
     */
    @RequestMapping(value = "/import",method = RequestMethod.GET)
    public String API(HttpServletRequest request){
        request.setAttribute("path","1.txt");
        return "file";
    }

    /*
    *主界面
     */
    @RequestMapping(value = "/in/index",method = RequestMethod.GET)
    public String start(HttpServletRequest request){
        return "starter";
    }

    /*
    *文档管理（需求2）
     */
    //文档查询
    @RequestMapping(value = "/in/pps",method = RequestMethod.GET)
    public String PPS(Model model){
        List<Proposal> list= studentService.getAllProposal();
        model.addAttribute("Proposals",list);
        model.addAttribute("Proposal",new Proposal());
        return "Pps";
    }

    //文档管理
    @RequestMapping(value = "/out/ppsd",method = RequestMethod.GET)
    public String PPSD(@ModelAttribute("Proposal") Proposal proposal,Model model,HttpServletRequest request){
        //由文档ID读取作者作者名称，由作者名称读取作者信息
        Student student=studentService.searchstudent(studentService.searchstudent_Name(proposal.getId()));
        Proposal proposal1=studentService.searchproposal_Prop(proposal.getId());
        request.setAttribute("proposals",proposal1);
        request.setAttribute("Student",student);
        System.out.print(student);
        System.out.print(proposal1);
        return "Ppsd";
    }

    /*
    *身份管理（需求3）
     */
    @RequestMapping(value = "/in/idm",method = RequestMethod.GET)
    public String IDM(HttpServletRequest request){
        return "Idm";
    }

    /*
    *测试
     */
    @RequestMapping(value = "/stu/test1",method = RequestMethod.GET)
    public String test(HttpServletRequest request){
        return "test";
    }
}
