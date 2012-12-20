/*    */ package com.entity.basedata;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class CollegeList
/*    */   implements Serializable
/*    */ {
/*    */   private Integer collegeid;
/*    */   private String collegename;
/*    */ 
/*    */   public CollegeList()
/*    */   {
/*    */   }
/*    */ 
/*    */   public CollegeList(String collegename)
/*    */   {
/* 24 */     this.collegename = collegename;
/*    */   }
/*    */ 
/*    */   public Integer getCollegeid()
/*    */   {
/* 30 */     return this.collegeid;
/*    */   }
/*    */ 
/*    */   public void setCollegeid(Integer collegeid) {
/* 34 */     this.collegeid = collegeid;
/*    */   }
/*    */ 
/*    */   public String getCollegename() {
/* 38 */     return this.collegename;
/*    */   }
/*    */ 
/*    */   public void setCollegename(String collegename) {
/* 42 */     this.collegename = collegename;
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.basedata.CollegeList
 * JD-Core Version:    0.5.4
 */