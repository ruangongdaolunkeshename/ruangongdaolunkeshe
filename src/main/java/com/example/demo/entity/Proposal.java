package com.example.demo.entity;

import lombok.Data;

@Data
public class Proposal {
    private String Id="2";   //编号，唯一索引主键
    private String PName="2";//提案名称
    private String AName="alex";//作者名称
    private String TNum="4"; //复议数
    private String FNum="5"; //反对数
    private String Time="1998";//截止日期

    public String getId(){ return  Id;}
    public String getPName(){return PName;}
    public String getAName(){return AName;}
    public String getTNum(){return TNum;}
    public String getFNum(){return FNum;}
    public String getTime(){return Time;}

    public Proposal(){};
}
