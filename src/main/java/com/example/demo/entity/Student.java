package com.example.demo.entity;

import lombok.Data;

/**
* @description 
* @author Tim Lin
* @create 2018-07-01 
**/
@Data
public class Student {

    private Integer id;
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

    public Integer id(){
        return id;
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
    public void setid(Integer id){
        this.id=id;
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

}
