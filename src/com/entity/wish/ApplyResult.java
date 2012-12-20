/*    */ package com.entity.wish;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class ApplyResult
/*    */   implements Serializable
/*    */ {
/*    */   private Integer id;
/*    */   private Integer departid;
/*    */   private String resultname;
/*    */ 
/*    */   public ApplyResult()
/*    */   {
/*    */   }
/*    */ 
/*    */   public ApplyResult(Integer departid, String resultname)
/*    */   {
/* 25 */     this.departid = departid;
/* 26 */     this.resultname = resultname;
/*    */   }
/*    */ 
/*    */   public Integer getId()
/*    */   {
/* 32 */     return this.id;
/*    */   }
/*    */ 
/*    */   public void setId(Integer id) {
/* 36 */     this.id = id;
/*    */   }
/*    */ 
/*    */   public Integer getDepartid() {
/* 40 */     return this.departid;
/*    */   }
/*    */ 
/*    */   public void setDepartid(Integer departid) {
/* 44 */     this.departid = departid;
/*    */   }
/*    */ 
/*    */   public String getResultname() {
/* 48 */     return this.resultname;
/*    */   }
/*    */ 
/*    */   public void setResultname(String resultname) {
/* 52 */     this.resultname = resultname;
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.wish.ApplyResult
 * JD-Core Version:    0.5.4
 */