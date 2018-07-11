package com.example.demo.controller;

import com.example.demo.entity.Proposal;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import com.sun.org.apache.bcel.internal.generic.MONITORENTER;
import org.mybatis.spring.annotation.MapperScan;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.io.IOException;
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

    public String LoginName=null;
    public int LoginFlat=-1;

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
    public String index(@ModelAttribute("student") Student student,Model model){
        LoginFlat=studentService.compareStudentpassword(student);
        LoginName=student.username();
        System.out.print(LoginFlat);
        System.out.print(LoginName);
        model.addAttribute("Flat",LoginFlat);
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
    public String Start(HttpServletRequest request){
        request.setAttribute("LName",LoginName);
        if(LoginFlat==1){return "StarterW";}
        else if(LoginFlat==2||LoginFlat==3){return "StarterM"; }
        else return "starter";
    }

    @RequestMapping(value = "/in/starter",method = RequestMethod.GET)
    public String StartW(HttpServletRequest request){
        LoginFlat=-1;
        LoginName=null;
        return "starter";
    }

    /*@RequestMapping(value = "/in/starterw",method = RequestMethod.GET)
    public String StartW(HttpServletRequest request){
        return "StarterW";
    }

    @RequestMapping(value = "/in/starterm",method = RequestMethod.GET)
    public String StartM(HttpServletRequest request){
        return "StarterM";
    }*/

    /*
    *文档管理（需求2）
     */
    //提案查询
    @RequestMapping(value = "/in/pps",method = RequestMethod.GET)
    public String PPS(Model model,HttpServletRequest request){
        List<Proposal> list= studentService.getAllProposal();
        request.setAttribute("LName",LoginName);
        model.addAttribute("proposals",list);
        model.addAttribute("proposal",new Proposal());
        return "Pps";
    }

    //提案管理
    @RequestMapping(value = "/out/ppsd",method = RequestMethod.GET)
    public String PPSD(@ModelAttribute("Proposal") Proposal proposal,Model model,HttpServletRequest request) throws IOException {
        //由文档ID读取作者作者名称，由作者名称读取作者信息
        Student student=studentService.searchstudent(studentService.searchstudent_Name(proposal.getId()));
        Proposal proposal1=studentService.searchproposal_Prop(proposal.getId());
        proposal1.setContent(studentService.getContent(proposal.getId()));
        request.setAttribute("proposals",proposal1);
        request.setAttribute("Student",student);
        request.setAttribute("LName",LoginName);
        return "Ppsd";
    }

    //提案编写
    @RequestMapping(value = "/in/ppw",method = RequestMethod.GET)
    public String PPW(Model model,HttpServletRequest request){
        model.addAttribute("proposal",new Proposal());
        request.setAttribute("LName",LoginName);
        return "Ppw";
    }
    @RequestMapping(value = "out/ppw",method = RequestMethod.GET)
    public String PPW_PPS(@ModelAttribute("proposal")Proposal proposal,HttpServletRequest request) throws IOException {
        proposal.setAName(LoginName);
        studentService.saveProposal(proposal);
        //跳转到提案查询 问题：textarea提交的内容会附带<p>***</p>
        return "redirect:/in/pps";
    }

    //规范查询
    @RequestMapping(value = "/in/nms",method = RequestMethod.GET)
    public String NMS(Model model,HttpServletRequest request){
        List<Proposal> list= studentService.getAllProposal();
        model.addAttribute("proposals",list);
        model.addAttribute("proposal",new Proposal());
        request.setAttribute("LName",LoginName);
        return "Nms";
    }
    //规范编写
    @RequestMapping(value = "/in/nmw",method = RequestMethod.GET)
    public String NMW(Model model,HttpServletRequest request){
        model.addAttribute("proposal",new Proposal());
        request.setAttribute("LName",LoginName);
        return "Nmw";
    }
    @RequestMapping(value = "out/nmw",method = RequestMethod.GET)
    public String NMW_NMS(@ModelAttribute("proposal")Proposal proposal,HttpServletRequest request) throws IOException {
        studentService.saveProposal(proposal);
        //跳转到提案查询 问题：textarea提交的内容会附带<p>***</p>
        return "redirect:/in/nms";
    }

    //信息维护
    @RequestMapping(value = "/in/ifm",method = RequestMethod.GET)
    public String IFM(HttpServletRequest request){
        List<Student> list=studentService.getAllStudent();
        request.setAttribute("students",list);
        request.setAttribute("LName",LoginName);
        return "Ifm";
    }

    /*
    *管理者功能（需求3）
     */
    //身份管理
    @RequestMapping(value = "/in/idm",method = RequestMethod.GET)
    public String IDM(HttpServletRequest request){
        List<Student> list=studentService.getAllStudent();
        request.setAttribute("students",list);
        request.setAttribute("LName",LoginName);
        return "Idm";
    }
    @RequestMapping(value = "/out/idmd",method = RequestMethod.GET)
    public String IDMD(@ModelAttribute("students")Student student,Model model,HttpServletRequest request){
        System.out.print(student.ID());
        Student student1=studentService.searchstudent_ID(student.ID());
        System.out.print(student1);
        model.addAttribute("Student",student1);
        request.setAttribute("LName",LoginName);
        return "Idmd";
    }
    //提案审批
    //推荐
    @RequestMapping(value="/in/ppr1",method=RequestMethod.GET)
    public String PPR1(Model model,HttpServletRequest request){
        List<Proposal>list=studentService.getAllProposalByFlat("1");
        model.addAttribute("proposals",list);
        request.setAttribute("LName",LoginName);
        return "Ppr1";
    }
    @RequestMapping(value="/out/ppr1",method=RequestMethod.GET)
    public String PPR1_OUT(@RequestParam(value="boxes",required = false,defaultValue = "0") String [] Id,
                           @RequestParam(value="allbox",required = false,defaultValue = "0") String  All,
                           @RequestParam(value="table_search",required = false,defaultValue = "0") String  SearchId){
        if(All.equals("1")){//当全选，升级所有文档为2级;
            studentService.UpdateProposalAllFlat("2");
            return "redirect:/in/ppr1";
        }
        if(Id[0].equals("0"))//一个都没有选时重回界面
            return "redirect:/in/ppr1";
        for(String s:Id){//升级选中文档为2级
            studentService.UpdateProposalFlat(s,"2");
        }

        return "redirect:/in/ppr1";
    }
    //备案
    @RequestMapping(value="/in/ppr2",method=RequestMethod.GET)
    public String PPR2(Model model,HttpServletRequest request){
        List<Proposal>list=studentService.getAllProposalByFlat("2");
        model.addAttribute("proposals",list);
        request.setAttribute("LName",LoginName);
        return "Ppr2";
    }
    @RequestMapping(value = "/out/ppr2",method = RequestMethod.GET)
    public String PPR2_OUT(@RequestParam(value="boxes",required = false,defaultValue="0")String[] Id,
                           @RequestParam(value="allbox",required = false,defaultValue = "0") String  All,
                           @RequestParam(value="table_search",required = false,defaultValue = "0") String  SearchId){
        if(All.equals("1")){//当全选，升级所有文档为2级
            System.out.print("备案");
            studentService.UpdateProposalAllFlat("3");
            return "redirect:/in/ppr2";
        }
        if(Id[0].equals("0"))//一个都没有选时重回界面
            return "redirect:/in/ppr2";
        for(String s:Id){//升级选中文档为2级
            studentService.UpdateProposalFlat(s,"3");
        }
        System.out.print(All);
        return "redirect:/in/ppr2";
    }
    //立案
    @RequestMapping(value="/in/ppr3",method=RequestMethod.GET)
    public String PPR3(Model model,HttpServletRequest request){
        List<Proposal>list=studentService.getAllProposalByFlat("3");
        model.addAttribute("proposals",list);
        request.setAttribute("LName",LoginName);
        return "Ppr3";
    }
    @RequestMapping(value = "/out/ppr3",method = RequestMethod.GET)
    public String PPR3_OUT(@RequestParam(value="boxes",required = false,defaultValue="0")String[] Id,
                           @RequestParam(value="allbox",required = false,defaultValue = "0") String  All,
                           @RequestParam(value="table_search",required = false,defaultValue = "0") String  SearchId){
        if(All.equals("1")){//当全选，升级所有文档为2级
            studentService.UpdateProposalAllFlat("4");
        }
        if(Id[0].equals("0"))//一个都没有选时重回界面
            return "redirect:/in/ppr3";

        for(String s:Id){//升级选中文档为2级
            studentService.UpdateProposalFlat(s,"4");
        }
        return "redirect:/in/ppr3";
    }


    //启动任务
    @RequestMapping(value="/in/ppr4",method=RequestMethod.GET)
    public String PPR4(Model model,HttpServletRequest request){
        List<Proposal>list=studentService.getAllProposalByFlat("4");
        model.addAttribute("proposals",list);
        request.setAttribute("LName",LoginName);
        return "Ppr4";
    }
    @RequestMapping(value = "/out/ppr4",method = RequestMethod.GET)
    public String PPR4_OUT(@RequestParam(value="boxes",required = false,defaultValue="0")String[] Id,
                           @RequestParam(value="allbox",required = false,defaultValue = "0") String  All,
                           @RequestParam(value="sub1",required = false,defaultValue = "0") String  sub1,
                           @RequestParam(value="sub2",required = false,defaultValue = "0") String  sub2,
                           @RequestParam(value="table_search",required = false,defaultValue = "0") String  SearchId){
        if(sub1.equals("1")){
            if(All.equals("1")){//当全选，升级所有文档为2级
                studentService.UpdateProposalAllFlat("1");
                return "redirect:/in/ppr4";
            }
            if(Id[0].equals("0"))//一个都没有选时重回界面
                return "redirect:/in/ppr4";
            for(String s:Id){//升级选中文档为2级
                studentService.UpdateProposalFlat(s,"1");
            };
        }
        else if(sub2.equals("1")){
            if(All.equals("1")){//当全选，升级所有文档为2级
                studentService.deleteAllProposal("4");
                return "redirect:/in/ppr4";
            }
            if(Id[0].equals("0"))//一个都没有选时重回界面
                return "redirect:/in/ppr4";
            for(String s:Id){//升级选中文档为2级
                studentService.deleteProposal(s);
            }
        }
        return "redirect:/in/ppr4";
    }

    /*
    *测试
     */
    @RequestMapping(value = "/stu/test1",method = RequestMethod.GET)
    public String test(HttpServletRequest request){
        return "test";
    }
}
