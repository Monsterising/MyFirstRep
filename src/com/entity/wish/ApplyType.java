/*    */ package com.entity.wish;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class ApplyType
/*    */   implements Serializable
/*    */ {
/*    */   private Integer id;
/*    */   private Integer departid;
/*    */   private String typename;
/*    */ 
/*    */   public ApplyType()
/*    */   {
/*    */   }
/*    */ 
/*    */   public ApplyType(Integer departid, String typename)
/*    */   {
/* 25 */     this.departid = departid;
/* 26 */     this.typename = typename;
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
/*    */   public String getTypename() {
/* 48 */     return this.typename;
/*    */   }
/*    */ 
/*    */   public void setTypename(String typename) {
/* 52 */     this.typename = typename;
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.wish.ApplyType
 * JD-Core Version:    0.5.4
 */