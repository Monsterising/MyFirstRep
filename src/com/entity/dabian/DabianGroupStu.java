/*    */ package com.entity.dabian;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class DabianGroupStu
/*    */   implements Serializable
/*    */ {
/*    */   private Integer dgsid;
/*    */   private Integer dbgid;
/*    */   private String stucode;
/*    */ 
/*    */   public DabianGroupStu()
/*    */   {
/*    */   }
/*    */ 
/*    */   public DabianGroupStu(Integer dbgid, String stucode)
/*    */   {
/* 25 */     this.dbgid = dbgid;
/* 26 */     this.stucode = stucode;
/*    */   }
/*    */ 
/*    */   public Integer getDgsid()
/*    */   {
/* 32 */     return this.dgsid;
/*    */   }
/*    */ 
/*    */   public void setDgsid(Integer dgsid) {
/* 36 */     this.dgsid = dgsid;
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
/*    */   public String getStucode() {
/* 48 */     return this.stucode;
/*    */   }
/*    */ 
/*    */   public void setStucode(String stucode) {
/* 52 */     this.stucode = stucode;
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.dabian.DabianGroupStu
 * JD-Core Version:    0.5.4
 */