/*    */ package com.entity.pingyue;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class Biaozhun
/*    */   implements Serializable
/*    */ {
/*    */   private Integer bzid;
/*    */   private String type;
/*    */   private String grade;
/*    */   private Integer maxnum;
/*    */   private Integer minnum;
/*    */   private String content;
/*    */ 
/*    */   public Biaozhun()
/*    */   {
/*    */   }
/*    */ 
/*    */   public Biaozhun(String type, String grade, Integer maxnum, Integer minnum, String content)
/*    */   {
/* 29 */     this.type = type;
/* 30 */     this.grade = grade;
/* 31 */     this.maxnum = maxnum;
/* 32 */     this.minnum = minnum;
/* 33 */     this.content = content;
/*    */   }
/*    */ 
/*    */   public Integer getBzid()
/*    */   {
/* 39 */     return this.bzid;
/*    */   }
/*    */ 
/*    */   public void setBzid(Integer bzid) {
/* 43 */     this.bzid = bzid;
/*    */   }
/*    */ 
/*    */   public String getType() {
/* 47 */     return this.type;
/*    */   }
/*    */ 
/*    */   public void setType(String type) {
/* 51 */     this.type = type;
/*    */   }
/*    */ 
/*    */   public String getGrade() {
/* 55 */     return this.grade;
/*    */   }
/*    */ 
/*    */   public void setGrade(String grade) {
/* 59 */     this.grade = grade;
/*    */   }
/*    */ 
/*    */   public Integer getMaxnum() {
/* 63 */     return this.maxnum;
/*    */   }
/*    */ 
/*    */   public void setMaxnum(Integer maxnum) {
/* 67 */     this.maxnum = maxnum;
/*    */   }
/*    */ 
/*    */   public Integer getMinnum() {
/* 71 */     return this.minnum;
/*    */   }
/*    */ 
/*    */   public void setMinnum(Integer minnum) {
/* 75 */     this.minnum = minnum;
/*    */   }
/*    */ 
/*    */   public String getContent() {
/* 79 */     return this.content;
/*    */   }
/*    */ 
/*    */   public void setContent(String content) {
/* 83 */     this.content = content;
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.pingyue.Biaozhun
 * JD-Core Version:    0.5.4
 */