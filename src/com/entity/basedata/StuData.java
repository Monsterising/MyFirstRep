/*    */ package com.entity.basedata;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class StuData
/*    */   implements Serializable
/*    */ {
/*    */   private String stucode;
/*    */   private String stuname;
/*    */   private String stucollege;
/*    */   private String studepart;
/*    */   private String stugrade;
/*    */   private String stuclass;
/*    */   private String stusex;
/*    */ 
/*    */   public StuData()
/*    */   {
/*    */   }
/*    */ 
/*    */   public StuData(String stuname, String stucollege, String studepart, String stugrade, String stuclass, String stusex)
/*    */   {
/* 30 */     this.stuname = stuname;
/* 31 */     this.stucollege = stucollege;
/* 32 */     this.studepart = studepart;
/* 33 */     this.stugrade = stugrade;
/* 34 */     this.stuclass = stuclass;
/* 35 */     this.stusex = stusex;
/*    */   }
/*    */ 
/*    */   public String getStucode()
/*    */   {
/* 41 */     return this.stucode;
/*    */   }
/*    */ 
/*    */   public void setStucode(String stucode) {
/* 45 */     this.stucode = stucode;
/*    */   }
/*    */ 
/*    */   public String getStuname() {
/* 49 */     return this.stuname;
/*    */   }
/*    */ 
/*    */   public void setStuname(String stuname) {
/* 53 */     this.stuname = stuname;
/*    */   }
/*    */ 
/*    */   public String getStucollege() {
/* 57 */     return this.stucollege;
/*    */   }
/*    */ 
/*    */   public void setStucollege(String stucollege) {
/* 61 */     this.stucollege = stucollege;
/*    */   }
/*    */ 
/*    */   public String getStudepart() {
/* 65 */     return this.studepart;
/*    */   }
/*    */ 
/*    */   public void setStudepart(String studepart) {
/* 69 */     this.studepart = studepart;
/*    */   }
/*    */ 
/*    */   public String getStugrade() {
/* 73 */     return this.stugrade;
/*    */   }
/*    */ 
/*    */   public void setStugrade(String stugrade) {
/* 77 */     this.stugrade = stugrade;
/*    */   }
/*    */ 
/*    */   public String getStuclass() {
/* 81 */     return this.stuclass;
/*    */   }
/*    */ 
/*    */   public void setStuclass(String stuclass) {
/* 85 */     this.stuclass = stuclass;
/*    */   }
/*    */ 
/*    */   public String getStusex() {
/* 89 */     return this.stusex;
/*    */   }
/*    */ 
/*    */   public void setStusex(String stusex) {
/* 93 */     this.stusex = stusex;
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.basedata.StuData
 * JD-Core Version:    0.5.4
 */