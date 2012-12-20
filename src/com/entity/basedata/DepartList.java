/*    */ package com.entity.basedata;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class DepartList
/*    */   implements Serializable
/*    */ {
/*    */   private Integer departid;
/*    */   private String departname;
/*    */   private Integer collegeid;
/*    */ 
/*    */   public DepartList()
/*    */   {
/*    */   }
/*    */ 
/*    */   public DepartList(String departname, Integer collegeid)
/*    */   {
/* 25 */     this.departname = departname;
/* 26 */     this.collegeid = collegeid;
/*    */   }
/*    */ 
/*    */   public Integer getDepartid()
/*    */   {
/* 32 */     return this.departid;
/*    */   }
/*    */ 
/*    */   public void setDepartid(Integer departid) {
/* 36 */     this.departid = departid;
/*    */   }
/*    */ 
/*    */   public String getDepartname() {
/* 40 */     return this.departname;
/*    */   }
/*    */ 
/*    */   public void setDepartname(String departname) {
/* 44 */     this.departname = departname;
/*    */   }
/*    */ 
/*    */   public Integer getCollegeid() {
/* 48 */     return this.collegeid;
/*    */   }
/*    */ 
/*    */   public void setCollegeid(Integer collegeid) {
/* 52 */     this.collegeid = collegeid;
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.basedata.DepartList
 * JD-Core Version:    0.5.4
 */