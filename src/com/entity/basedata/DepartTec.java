/*    */ package com.entity.basedata;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class DepartTec
/*    */   implements Serializable
/*    */ {
/*    */   private Integer dtid;
/*    */   private Integer departid;
/*    */   private String teccode;
/*    */   private Integer tecrole;
/*    */ 
/*    */   public DepartTec()
/*    */   {
/*    */   }
/*    */ 
/*    */   public DepartTec(Integer departid, String teccode, Integer tecrole)
/*    */   {
/* 26 */     this.departid = departid;
/* 27 */     this.teccode = teccode;
/* 28 */     this.tecrole = tecrole;
/*    */   }
/*    */ 
/*    */   public Integer getDtid()
/*    */   {
/* 34 */     return this.dtid;
/*    */   }
/*    */ 
/*    */   public void setDtid(Integer dtid) {
/* 38 */     this.dtid = dtid;
/*    */   }
/*    */ 
/*    */   public Integer getDepartid() {
/* 42 */     return this.departid;
/*    */   }
/*    */ 
/*    */   public void setDepartid(Integer departid) {
/* 46 */     this.departid = departid;
/*    */   }
/*    */ 
/*    */   public String getTeccode() {
/* 50 */     return this.teccode;
/*    */   }
/*    */ 
/*    */   public void setTeccode(String teccode) {
/* 54 */     this.teccode = teccode;
/*    */   }
/*    */ 
/*    */   public Integer getTecrole() {
/* 58 */     return this.tecrole;
/*    */   }
/*    */ 
/*    */   public void setTecrole(Integer tecrole) {
/* 62 */     this.tecrole = tecrole;
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.basedata.DepartTec
 * JD-Core Version:    0.5.4
 */