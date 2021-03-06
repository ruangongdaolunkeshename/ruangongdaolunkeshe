package com.example.demo.service.impl;

import com.example.demo.dao.StudentDAO;
import com.example.demo.entity.Proposal;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public List<Proposal>getAllProposal(){return studentDAO.getAllProposal();}

    @Override
    public List<Proposal> getAllProposalByFlat(String flat) {
        return studentDAO.getAllProposalByFlat(flat);
    }

    @Override
    public boolean UpdateProposalFlat(String Id,String Flat){
        studentDAO.updateProposalFlat(Id,Flat);
        return true;
    }

    @Override
    public boolean UpdateProposalAllFlat(String Flat) {

        return studentDAO.updateProposalAllFlat(Flat);
    }


    @Override
    public Boolean saveStudent(Student student){
        if(null==student)
            return false;
        else
            studentDAO.insert(student);
        return true;
    }

    //测试：插入文档
    @Override
    public Boolean saveProposal(Proposal proposal) throws IOException {
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        proposal.setTime(df.format(new Date()));
        studentDAO.insert_proposal(proposal);
        Proposal proposal1=studentDAO.search_ProposalByPName(proposal.getPName());
        String url="src/main/resources/static/txt/ppsd/"+proposal1.getId()+".txt";
        File file=new File(url);
        if(!file.exists()) {
            file.createNewFile();
        }
        FileWriter wr=new FileWriter(file);
        wr.write(proposal.getContent());
        wr.flush();
        wr.close();
        return true;
    }

    @Override
    public int compareStudentpassword(Student student){
        if(student.password().equals(studentDAO.search(student.username()).password()))
            return searchflat(student.username());
        return -1;
    }

    @Override
    public Student searchstudent(String username){
        return studentDAO.search(username);
    }

    //通过用户ID搜索用户
    @Override
    public Student searchstudent_ID(String ID){return studentDAO.search_ID(ID);}

    @Override
    public String searchstudent_Name(String ID){
        return studentDAO.search_Name(ID);
    }

    @Override
    public Proposal searchproposal_Prop(String ID){
        return studentDAO.search_Proposal(ID);
    }

    @Override
    public void updateStudent(Student student){
        Student s=studentDAO.search(student.username());
        studentDAO.delete(student.username());
        if(student.password()!=null)
            s.setpassword(student.password());
        if(student.committee()!=null)
            s.setcommitte(student.committee());
        if(student.flat()!=0)
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
        if(student.changeusername()!=null&&studentDAO.search(student.changeusername())==null)
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
    public void deleteProposal(String Id) {
        studentDAO.deleteProposal(Id);
    }

    @Override
    public void deleteAllProposal(String Flat) {
        studentDAO.deleteAllProposal(Flat);
    }

    @Override
    public int searchflat(String username){
        return studentDAO.searchflat(username);
    }

    @Override
    public String getContent(String Id) throws IOException {
        String url="src/main/resources/static/txt/ppsd/"+Id+".txt";
        String line="";
        String content="";
        File file=new File(url);
        if(!file.exists()) {
            file.createNewFile();
        }

        BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
        while(line!=null){
            content+=line;
            line=br.readLine();
        }
        System.out.print(content);
        return content;
    }

}
