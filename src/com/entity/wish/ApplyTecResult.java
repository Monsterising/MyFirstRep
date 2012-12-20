/*    */ package com.entity.wish;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class ApplyTecResult
/*    */   implements Serializable
/*    */ {
/*    */   private Integer atrid;
/*    */   private Integer atid;
/*    */   private Integer resultid;
/*    */   private Integer isok;
/*    */   private String url;
/*    */   private Date uptime;
/*    */   private String stucode;
/*    */ 
/*    */   public ApplyTecResult()
/*    */   {
/*    */   }
/*    */ 
/*    */   public ApplyTecResult(Integer atid, Integer resultid, Integer isok, String url, Date uptime, String stucode)
/*    */   {
/* 32 */     this.atid = atid;
/* 33 */     this.resultid = resultid;
/* 34 */     this.isok = isok;
/* 35 */     this.url = url;
/* 36 */     this.uptime = uptime;
/* 37 */     this.stucode = stucode;
/*    */   }
/*    */ 
/*    */   public Integer getAtrid()
/*    */   {
/* 43 */     return this.atrid;
/*    */   }
/*    */ 
/*    */   public void setAtrid(Integer atrid) {
/* 47 */     this.atrid = atrid;
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
/*    */   public Integer getResultid() {
/* 59 */     return this.resultid;
/*    */   }
/*    */ 
/*    */   public void setResultid(Integer resultid) {
/* 63 */     this.resultid = resultid;
/*    */   }
/*    */ 
/*    */   public Integer getIsok() {
/* 67 */     return this.isok;
/*    */   }
/*    */ 
/*    */   public void setIsok(Integer isok) {
/* 71 */     this.isok = isok;
/*    */   }
/*    */ 
/*    */   public String getUrl() {
/* 75 */     return this.url;
/*    */   }
/*    */ 
/*    */   public void setUrl(String url) {
/* 79 */     this.url = url;
/*    */   }
/*    */ 
/*    */   public Date getUptime() {
/* 83 */     return this.uptime;
/*    */   }
/*    */ 
/*    */   public void setUptime(Date uptime) {
/* 87 */     this.uptime = uptime;
/*    */   }
/*    */ 
/*    */   public String getStucode() {
/* 91 */     return this.stucode;
/*    */   }
/*    */ 
/*    */   public void setStucode(String stucode) {
/* 95 */     this.stucode = stucode;
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.wish.ApplyTecResult
 * JD-Core Version:    0.5.4
 */