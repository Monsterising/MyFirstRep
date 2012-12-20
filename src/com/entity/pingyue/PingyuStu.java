/*    */ package com.entity.pingyue;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class PingyuStu
/*    */   implements Serializable
/*    */ {
/*    */   private String stucode;
/*    */   private Integer atid;
/*    */   private String beijin;
/*    */   private String content;
/*    */   private String attitude;
/*    */   private String result;
/*    */   private Date uptime;
/*    */ 
/*    */   public PingyuStu()
/*    */   {
/*    */   }
/*    */ 
/*    */   public PingyuStu(Integer atid, String beijin, String content, String attitude, String result, Date uptime)
/*    */   {
/* 32 */     this.atid = atid;
/* 33 */     this.beijin = beijin;
/* 34 */     this.content = content;
/* 35 */     this.attitude = attitude;
/* 36 */     this.result = result;
/* 37 */     this.uptime = uptime;
/*    */   }
/*    */ 
/*    */   public String getStucode()
/*    */   {
/* 43 */     return this.stucode;
/*    */   }
/*    */ 
/*    */   public void setStucode(String stucode) {
/* 47 */     this.stucode = stucode;
/*    */   }
/*    */ 
/*    */   public Integer getAtid() {
/* 51 */     return this.atid;
/*    */   }
/*    */ 
/*    */   public void setAtid(Integer atid) {
/* 55 */     this.atid = atid;
/*    */   }
/*    */ 
/*    */   public String getBeijin() {
/* 59 */     return this.beijin;
/*    */   }
/*    */ 
/*    */   public void setBeijin(String beijin) {
/* 63 */     this.beijin = beijin;
/*    */   }
/*    */ 
/*    */   public String getContent() {
/* 67 */     return this.content;
/*    */   }
/*    */ 
/*    */   public void setContent(String content) {
/* 71 */     this.content = content;
/*    */   }
/*    */ 
/*    */   public String getAttitude() {
/* 75 */     return this.attitude;
/*    */   }
/*    */ 
/*    */   public void setAttitude(String attitude) {
/* 79 */     this.attitude = attitude;
/*    */   }
/*    */ 
/*    */   public String getResult() {
/* 83 */     return this.result;
/*    */   }
/*    */ 
/*    */   public void setResult(String result) {
/* 87 */     this.result = result;
/*    */   }
/*    */ 
/*    */   public Date getUptime() {
/* 91 */     return this.uptime;
/*    */   }
/*    */ 
/*    */   public void setUptime(Date uptime) {
/* 95 */     this.uptime = uptime;
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.pingyue.PingyuStu
 * JD-Core Version:    0.5.4
 */