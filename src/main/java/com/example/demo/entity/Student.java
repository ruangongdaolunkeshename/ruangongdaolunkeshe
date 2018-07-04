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
    private String no;
    private String name;
    private Double score;

    public Integer getid(){
        return id;
    }
    public String no(){
        return no;
    }
    public String name(){
        return name;
    }
    public Double score(){
        return score;
    }
    public void getid(Integer id){
        this.id=id;
    }
    public void getno(String no){
        this.no=no;
    }
    public void getname(String name){
        this.name=name;
    }
    public void getscore(Double score){
        this.score=score;
    }

}
