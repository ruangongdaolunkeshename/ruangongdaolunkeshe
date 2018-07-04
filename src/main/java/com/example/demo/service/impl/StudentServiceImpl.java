package com.example.demo.service.impl;

import com.example.demo.dao.StudentDAO;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Map;

/**
* @description 
* @author Tim Lin
* @create 2018-07-01 
**/

@Service
public abstract class StudentServiceImpl implements StudentService{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> getAllStudent() {
        List<Map<String,Object>> list=jdbcTemplate.queryForList("select * from student");
        List<Student> studentList=new ArrayList<>();
        for(Map<String,Object> map:list){
            Student student=new Student();

            student.setid(map.get("id").toString());
            student.setsex(map.get("sex").toString());
            student.setname(map.get("name").toString());
            student.setaddress(null==map.get("address")?"":map.get("address").toString());
            student.setbirthday(null==map.get("birthday")?"":map.get("birthday").toString());
            student.settelephone(map.get("telephone").toString());
            student.setpeople(null==map.get("people")?"":map.get("people").toString());
            student.setbranch(null==map.get("branch")?"":map.get("branch").toString());
            student.setcommitte(null==map.get("committee")?"":map.get("committee").toString());
        }
        return studentList;
    }

    @Override
    public Student saveStudent(Student student){
        student.setid(StudentDAO.getid());
        String sql="insert into student(id,sex,name,address,birthday,telephone,people,branch,committee) values(?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,new Object[]{student.id(),student.sex(),student.name(), student.address(), student.birthday(), student.telephone(), student.people(), student.branch(), student.committee()});
        return getStudentid(student.id());
    }

    @Override
    public Student getStudentid(String id){
        Map<String,Object> map=jdbcTemplate.queryForMap("SELECT * FROM student where id = ?",id);
        if(null!=map&&map.size()>0){
            Student student=new Student();
            student.setid(map.get("id").toString());
            student.setsex(map.get("sex").toString());
            student.setname(map.get("name").toString());
            student.setaddress(null==map.get("address")?"":map.get("address").toString());
            student.setbirthday(null==map.get("birthday")?"":map.get("birthday").toString());
            student.settelephone(map.get("telephone").toString());
            student.setpeople(null==map.get("people")?"":map.get("people").toString());
            student.setbranch(null==map.get("branch")?"":map.get("branch").toString());
            student.setcommitte(null==map.get("committee")?"":map.get("committee").toString());
            return student;
        }
        return null;
    }

    @Override
    public Student updateStudent(Student student){
        String sql="update student set sex=?,name=?,address=?,birthday=?,telephone=?,people=?,branch=?,committee=?";
        jdbcTemplate.update(sql,new Object[]{student.sex(),student.name(), student.address(), student.birthday(), student.telephone(), student.people(), student.branch(), student.committee()});
        return getStudentid(student.id());
    }

    @Override
    public void deleteStudent(String id){
        String sql="delete from student where id=?";
        jdbcTemplate.update(sql,new Object[]{id});
    }

}
