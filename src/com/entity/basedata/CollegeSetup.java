/*    */ package com.entity.basedata;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class CollegeSetup
/*    */   implements Serializable
/*    */ {
/*    */   private Integer collegeid;
/*    */   private String datestart;
/*    */   private String dateover;
/*    */ 
/*    */   public CollegeSetup()
/*    */   {
/*    */   }
/*    */ 
/*    */   public CollegeSetup(Integer collegeid)
/*    */   {
/* 25 */     this.collegeid = collegeid;
/*    */   }
/*    */ 
/*    */   public CollegeSetup(Integer collegeid, String datestart, String dateover)
/*    */   {
/* 30 */     this.collegeid = collegeid;
/* 31 */     this.datestart = datestart;
/* 32 */     this.dateover = dateover;
/*    */   }
/*    */ 
/*    */   public Integer getCollegeid()
/*    */   {
/* 38 */     return this.collegeid;
/*    */   }
/*    */ 
/*    */   public void setCollegeid(Integer collegeid) {
/* 42 */     this.collegeid = collegeid;
/*    */   }
/*    */ 
/*    */   public String getDatestart() {
/* 46 */     return this.datestart;
/*    */   }
/*    */ 
/*    */   public void setDatestart(String datestart) {
/* 50 */     this.datestart = datestart;
/*    */   }
/*    */ 
/*    */   public String getDateover() {
/* 54 */     return this.dateover;
/*    */   }
/*    */ 
/*    */   public void setDateover(String dateover) {
/* 58 */     this.dateover = dateover;
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.basedata.CollegeSetup
 * JD-Core Version:    0.5.4
 */