package com.example.demo.entity;

import lombok.Data;

@Data
public class Proposal {
    private String Id;   //编号，唯一索引主键,本地文档存储路径名称
    private String PName;//提案名称
    private String AName;//作者名称
    private String TNum; //复议数
    private String FNum; //反对数
    private String Time;//截止日期
    private String Content;//内容

    public String getId(){ return  Id;}
    public String getPName(){return PName;}
    public String getAName(){return AName;}
    public String getTNum(){return TNum;}
    public String getFNum(){return FNum;}
    public String getTime(){return Time;}

    public Proposal(){};
}
