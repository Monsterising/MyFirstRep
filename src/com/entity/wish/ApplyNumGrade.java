/*    */ package com.entity.wish;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class ApplyNumGrade
/*    */   implements Serializable
/*    */ {
/*    */   private Integer departid;
/*    */   private Integer num;
/*    */   private Integer gradeid;
/*    */ 
/*    */   public ApplyNumGrade()
/*    */   {
/*    */   }
/*    */ 
/*    */   public ApplyNumGrade(Integer departid)
/*    */   {
/* 25 */     this.departid = departid;
/*    */   }
/*    */ 
/*    */   public ApplyNumGrade(Integer departid, Integer num, Integer gradeid)
/*    */   {
/* 30 */     this.departid = departid;
/* 31 */     this.num = num;
/* 32 */     this.gradeid = gradeid;
/*    */   }
/*    */ 
/*    */   public Integer getDepartid()
/*    */   {
/* 38 */     return this.departid;
/*    */   }
/*    */ 
/*    */   public void setDepartid(Integer departid) {
/* 42 */     this.departid = departid;
/*    */   }
/*    */ 
/*    */   public Integer getNum() {
/* 46 */     return this.num;
/*    */   }
/*    */ 
/*    */   public void setNum(Integer num) {
/* 50 */     this.num = num;
/*    */   }
/*    */ 
/*    */   public Integer getGradeid() {
/* 54 */     return this.gradeid;
/*    */   }
/*    */ 
/*    */   public void setGradeid(Integer gradeid) {
/* 58 */     this.gradeid = gradeid;
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.wish.ApplyNumGrade
 * JD-Core Version:    0.5.4
 */