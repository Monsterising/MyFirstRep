/*    */ package com.entity.dabian;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class Pingfen
/*    */   implements Serializable
/*    */ {
/*    */   private Integer pfid;
/*    */   private String stucode;
/*    */   private String type;
/*    */   private String score;
/*    */   private Date checktime;
/*    */ 
/*    */   public Pingfen()
/*    */   {
/*    */   }
/*    */ 
/*    */   public Pingfen(String stucode, String type, String score, Date checktime)
/*    */   {
/* 29 */     this.stucode = stucode;
/* 30 */     this.type = type;
/* 31 */     this.score = score;
/* 32 */     this.checktime = checktime;
/*    */   }
/*    */ 
/*    */   public Integer getPfid()
/*    */   {
/* 38 */     return this.pfid;
/*    */   }
/*    */ 
/*    */   public void setPfid(Integer pfid) {
/* 42 */     this.pfid = pfid;
/*    */   }
/*    */ 
/*    */   public String getStucode() {
/* 46 */     return this.stucode;
/*    */   }
/*    */ 
/*    */   public void setStucode(String stucode) {
/* 50 */     this.stucode = stucode;
/*    */   }
/*    */ 
/*    */   public String getType() {
/* 54 */     return this.type;
/*    */   }
/*    */ 
/*    */   public void setType(String type) {
/* 58 */     this.type = type;
/*    */   }
/*    */ 
/*    */   public String getScore() {
/* 62 */     return this.score;
/*    */   }
/*    */ 
/*    */   public void setScore(String score) {
/* 66 */     this.score = score;
/*    */   }
/*    */ 
/*    */   public Date getChecktime() {
/* 70 */     return this.checktime;
/*    */   }
/*    */ 
/*    */   public void setChecktime(Date checktime) {
/* 74 */     this.checktime = checktime;
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.dabian.Pingfen
 * JD-Core Version:    0.5.4
 */