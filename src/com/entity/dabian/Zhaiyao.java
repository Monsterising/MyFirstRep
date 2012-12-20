/*    */ package com.entity.dabian;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class Zhaiyao
/*    */   implements Serializable
/*    */ {
/*    */   private String stucode;
/*    */   private String content;
/*    */   private String keyword;
/*    */   private Date uptime;
/*    */ 
/*    */   public Zhaiyao()
/*    */   {
/*    */   }
/*    */ 
/*    */   public Zhaiyao(String stucode)
/*    */   {
/* 28 */     this.stucode = stucode;
/*    */   }
/*    */ 
/*    */   public Zhaiyao(String stucode, String content, String keyword, Date uptime)
/*    */   {
/* 33 */     this.stucode = stucode;
/* 34 */     this.content = content;
/* 35 */     this.keyword = keyword;
/* 36 */     this.uptime = uptime;
/*    */   }
/*    */ 
/*    */   public String getStucode()
/*    */   {
/* 42 */     return this.stucode;
/*    */   }
/*    */ 
/*    */   public void setStucode(String stucode) {
/* 46 */     this.stucode = stucode;
/*    */   }
/*    */ 
/*    */   public String getContent() {
/* 50 */     return this.content;
/*    */   }
/*    */ 
/*    */   public void setContent(String content) {
/* 54 */     this.content = content;
/*    */   }
/*    */ 
/*    */   public String getKeyword() {
/* 58 */     return this.keyword;
/*    */   }
/*    */ 
/*    */   public void setKeyword(String keyword) {
/* 62 */     this.keyword = keyword;
/*    */   }
/*    */ 
/*    */   public Date getUptime() {
/* 66 */     return this.uptime;
/*    */   }
/*    */ 
/*    */   public void setUptime(Date uptime) {
/* 70 */     this.uptime = uptime;
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.dabian.Zhaiyao
 * JD-Core Version:    0.5.4
 */