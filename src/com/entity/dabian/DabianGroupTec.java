/*    */ package com.entity.dabian;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class DabianGroupTec
/*    */   implements Serializable
/*    */ {
/*    */   private Integer dgtid;
/*    */   private Integer dbgid;
/*    */   private String teccode;
/*    */ 
/*    */   public DabianGroupTec()
/*    */   {
/*    */   }
/*    */ 
/*    */   public DabianGroupTec(Integer dbgid, String teccode)
/*    */   {
/* 25 */     this.dbgid = dbgid;
/* 26 */     this.teccode = teccode;
/*    */   }
/*    */ 
/*    */   public Integer getDgtid()
/*    */   {
/* 32 */     return this.dgtid;
/*    */   }
/*    */ 
/*    */   public void setDgtid(Integer dgtid) {
/* 36 */     this.dgtid = dgtid;
/*    */   }
/*    */ 
/*    */   public Integer getDbgid() {
/* 40 */     return this.dbgid;
/*    */   }
/*    */ 
/*    */   public void setDbgid(Integer dbgid) {
/* 44 */     this.dbgid = dbgid;
/*    */   }
/*    */ 
/*    */   public String getTeccode() {
/* 48 */     return this.teccode;
/*    */   }
/*    */ 
/*    */   public void setTeccode(String teccode) {
/* 52 */     this.teccode = teccode;
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.dabian.DabianGroupTec
 * JD-Core Version:    0.5.4
 */