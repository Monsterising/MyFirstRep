/*    */ package com.entity.wish;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class Xuanti
/*    */   implements Serializable
/*    */ {
/*    */   private String stucode;
/*    */   private Integer atid;
/*    */   private String teccode;
/*    */   private Date dateaccess;
/*    */ 
/*    */   public Xuanti()
/*    */   {
/*    */   }
/*    */ 
/*    */   public Xuanti(String stucode)
/*    */   {
/* 28 */     this.stucode = stucode;
/*    */   }
/*    */ 
/*    */   public Xuanti(String stucode, Integer atid, String teccode, Date dateaccess)
/*    */   {
/* 33 */     this.stucode = stucode;
/* 34 */     this.atid = atid;
/* 35 */     this.teccode = teccode;
/* 36 */     this.dateaccess = dateaccess;
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
/*    */   public Integer getAtid() {
/* 50 */     return this.atid;
/*    */   }
/*    */ 
/*    */   public void setAtid(Integer atid) {
/* 54 */     this.atid = atid;
/*    */   }
/*    */ 
/*    */   public String getTeccode() {
/* 58 */     return this.teccode;
/*    */   }
/*    */ 
/*    */   public void setTeccode(String teccode) {
/* 62 */     this.teccode = teccode;
/*    */   }
/*    */ 
/*    */   public Date getDateaccess() {
/* 66 */     return this.dateaccess;
/*    */   }
/*    */ 
/*    */   public void setDateaccess(Date dateaccess) {
/* 70 */     this.dateaccess = dateaccess;
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.wish.Xuanti
 * JD-Core Version:    0.5.4
 */