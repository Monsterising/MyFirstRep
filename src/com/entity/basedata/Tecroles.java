/*    */ package com.entity.basedata;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class Tecroles
/*    */   implements Serializable
/*    */ {
/*    */   private Integer departid;
/*    */   private Integer tecrole;
/*    */ 
/*    */   public Tecroles()
/*    */   {
/*    */   }
/*    */ 
/*    */   public Tecroles(Integer departid, Integer tecrole)
/*    */   {
/* 20 */     this.departid = departid;
/* 21 */     this.tecrole = tecrole;
/*    */   }
/*    */   public Integer getDepartid() {
/* 24 */     return this.departid;
/*    */   }
/*    */   public void setDepartid(Integer departid) {
/* 27 */     this.departid = departid;
/*    */   }
/*    */   public Integer getTecrole() {
/* 30 */     return this.tecrole;
/*    */   }
/*    */   public void setTecrole(Integer tecrole) {
/* 33 */     this.tecrole = tecrole;
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.basedata.Tecroles
 * JD-Core Version:    0.5.4
 */