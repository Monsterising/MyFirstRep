/*    */ package com.entity.basedata;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class ClassList
/*    */   implements Serializable
/*    */ {
/*    */   private Integer classid;
/*    */   private String classname;
/*    */   private Integer collegeid;
/*    */   private Integer departid;
/*    */   private Integer gradeid;
/*    */   private String classnameshort;
/*    */ 
/*    */   public ClassList()
/*    */   {
/*    */   }
/*    */ 
/*    */   public ClassList(String classname, Integer collegeid, Integer departid, Integer gradeid, String classnameshort)
/*    */   {
/* 29 */     this.classname = classname;
/* 30 */     this.collegeid = collegeid;
/* 31 */     this.departid = departid;
/* 32 */     this.gradeid = gradeid;
/* 33 */     this.classnameshort = classnameshort;
/*    */   }
/*    */ 
/*    */   public Integer getClassid()
/*    */   {
/* 39 */     return this.classid;
/*    */   }
/*    */ 
/*    */   public void setClassid(Integer classid) {
/* 43 */     this.classid = classid;
/*    */   }
/*    */ 
/*    */   public String getClassname() {
/* 47 */     return this.classname;
/*    */   }
/*    */ 
/*    */   public void setClassname(String classname) {
/* 51 */     this.classname = classname;
/*    */   }
/*    */ 
/*    */   public Integer getCollegeid() {
/* 55 */     return this.collegeid;
/*    */   }
/*    */ 
/*    */   public void setCollegeid(Integer collegeid) {
/* 59 */     this.collegeid = collegeid;
/*    */   }
/*    */ 
/*    */   public Integer getDepartid() {
/* 63 */     return this.departid;
/*    */   }
/*    */ 
/*    */   public void setDepartid(Integer departid) {
/* 67 */     this.departid = departid;
/*    */   }
/*    */ 
/*    */   public Integer getGradeid() {
/* 71 */     return this.gradeid;
/*    */   }
/*    */ 
/*    */   public void setGradeid(Integer gradeid) {
/* 75 */     this.gradeid = gradeid;
/*    */   }
/*    */ 
/*    */   public String getClassnameshort() {
/* 79 */     return this.classnameshort;
/*    */   }
/*    */ 
/*    */   public void setClassnameshort(String classnameshort) {
/* 83 */     this.classnameshort = classnameshort;
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.basedata.ClassList
 * JD-Core Version:    0.5.4
 */