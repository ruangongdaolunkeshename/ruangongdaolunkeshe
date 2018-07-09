package com.example.demo.entity;

import lombok.Data;

/**
* @description 
* @author Tim Lin
* @create 2018-07-01 
**/
@Data
public class Student {

    private String ID;
    private String password;
    private String username;
    private String sex;
    private String name;
    private String birthday;
    private String address;
    private String telephone;
    //推荐人
    private String people;
    //行业分会
    private String branch;
    //委员会
    private String committee;
    //权限标志
    private Integer flat=0;
    private String deletename;
    private String changeusername;
    //文档部分
    private String papername;
    private String uploadtime;
    private String paperurl;

    public String ID(){return ID;}
    public String username(){
        return username;
    }
    public String sex(){
        return sex;
    }
    public String name(){
        return name;
    }
    public String birthday(){
        return birthday;
    }
    public String address(){
        return address;
    }
    public String telephone(){
        return telephone;
    }
    public String people(){
        return people;
    }
    public String branch(){
        return branch;
    }
    public String committee(){
        return committee;
    }
    public Integer flat(){
        return flat;
    }
    public String password(){
        return password;
    }
    public String deletename(){return deletename;}
    public String changeusername(){return changeusername;}
    public String papername(){return papername;}
    public String uploadtime(){return uploadtime;}
    public String paperurl(){return paperurl;}


    public void setusername(String username){
        this.username=username;
    }
    public void setpassword(String password){
        this.password=password;
    }
    public void setflat(Integer flat){
        this.flat=flat;
    }
    public void setsex(String sex){
        this.sex=sex;
    }
    public void setname(String name){
        this.name=name;
    }
    public void setbirthday(String birthday){
        this.birthday=birthday;
    }
    public void setaddress(String address){
        this.address=address;
    }
    public void settelephone(String telephone){
        this.telephone=telephone;
    }
    public void setpeople(String people){
        this.people=people;
    }
    public void setbranch(String branch){
        this.branch=branch;
    }
    public void setcommitte(String committee){
        this.committee=committee;
    }
    public void setpapername(String papername){this.papername=papername;}
    public void setpaperurl(String paperurl){
        this.paperurl=paperurl;
    }
    public void setuploadtime(String uploadtime){
        this.uploadtime=uploadtime;
    }

}
