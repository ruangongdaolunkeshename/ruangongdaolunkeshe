package com.example.demo.entity;

import lombok.Data;

@Data
public class Proposal {
    private String Id;   //编号，唯一索引主键,本地文档存储路径名称
    private String PName;//提案名称
    private String AName;//作者名称
    private int TNum; //复议数
    private int FNum; //反对数
    private String Time;//截止日期
    private String Content;//内容

    public String getId(){ return  Id;}
    public String getPName(){return PName;}
    public String getAName(){return AName;}
    public int getTNum(){return TNum;}
    public int getFNum(){return FNum;}
    public String getTime(){return Time;}
    public String getContent(){return Content;}

    public void setAName(String AName){this.AName=AName;}
    public void setTime(String Time){this.Time=Time;}

    public Proposal(){TNum=0;FNum=0;};
}
