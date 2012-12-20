/*    */ package com.entity.basedata;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class GradeList
/*    */   implements Serializable
/*    */ {
/*    */   private Integer gradeid;
/*    */   private String gradename;
/*    */   private Integer collegeid;
/*    */   private Integer departid;
/*    */ 
/*    */   public GradeList()
/*    */   {
/*    */   }
/*    */ 
/*    */   public GradeList(String gradename, Integer collegeid, Integer departid)
/*    */   {
/* 26 */     this.gradename = gradename;
/* 27 */     this.collegeid = collegeid;
/* 28 */     this.departid = departid;
/*    */   }
/*    */ 
/*    */   public Integer getGradeid()
/*    */   {
/* 34 */     return this.gradeid;
/*    */   }
/*    */ 
/*    */   public void setGradeid(Integer gradeid) {
/* 38 */     this.gradeid = gradeid;
/*    */   }
/*    */ 
/*    */   public String getGradename() {
/* 42 */     return this.gradename;
/*    */   }
/*    */ 
/*    */   public void setGradename(String gradename) {
/* 46 */     this.gradename = gradename;
/*    */   }
/*    */ 
/*    */   public Integer getCollegeid() {
/* 50 */     return this.collegeid;
/*    */   }
/*    */ 
/*    */   public void setCollegeid(Integer collegeid) {
/* 54 */     this.collegeid = collegeid;
/*    */   }
/*    */ 
/*    */   public Integer getDepartid() {
/* 58 */     return this.departid;
/*    */   }
/*    */ 
/*    */   public void setDepartid(Integer departid) {
/* 62 */     this.departid = departid;
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.basedata.GradeList
 * JD-Core Version:    0.5.4
 */