/*    */ package com.entity.basedata;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class CollegeUser
/*    */   implements Serializable
/*    */ {
/*    */   private Integer cuid;
/*    */   private Integer collegeid;
/*    */   private Integer userid;
/*    */   private Integer curole;
/*    */ 
/*    */   public CollegeUser()
/*    */   {
/*    */   }
/*    */ 
/*    */   public CollegeUser(Integer collegeid, Integer userid, Integer curole)
/*    */   {
/* 26 */     this.collegeid = collegeid;
/* 27 */     this.userid = userid;
/* 28 */     this.curole = curole;
/*    */   }
/*    */ 
/*    */   public Integer getCuid()
/*    */   {
/* 34 */     return this.cuid;
/*    */   }
/*    */ 
/*    */   public void setCuid(Integer cuid) {
/* 38 */     this.cuid = cuid;
/*    */   }
/*    */ 
/*    */   public Integer getCollegeid() {
/* 42 */     return this.collegeid;
/*    */   }
/*    */ 
/*    */   public void setCollegeid(Integer collegeid) {
/* 46 */     this.collegeid = collegeid;
/*    */   }
/*    */ 
/*    */   public Integer getUserid() {
/* 50 */     return this.userid;
/*    */   }
/*    */ 
/*    */   public void setUserid(Integer userid) {
/* 54 */     this.userid = userid;
/*    */   }
/*    */ 
/*    */   public Integer getCurole() {
/* 58 */     return this.curole;
/*    */   }
/*    */ 
/*    */   public void setCurole(Integer curole) {
/* 62 */     this.curole = curole;
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.basedata.CollegeUser
 * JD-Core Version:    0.5.4
 */