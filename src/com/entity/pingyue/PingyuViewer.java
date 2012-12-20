/*    */ package com.entity.pingyue;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class PingyuViewer
/*    */   implements Serializable
/*    */ {
/*    */   private Integer pyvid;
/*    */   private String stucode;
/*    */   private String teccode;
/*    */   private Integer atid;
/*    */   private String pingyu;
/*    */   private Date uptime;
/*    */ 
/*    */   public PingyuViewer()
/*    */   {
/*    */   }
/*    */ 
/*    */   public PingyuViewer(String stucode, String teccode, Integer atid, String pingyu, Date uptime)
/*    */   {
/* 31 */     this.stucode = stucode;
/* 32 */     this.teccode = teccode;
/* 33 */     this.atid = atid;
/* 34 */     this.pingyu = pingyu;
/* 35 */     this.uptime = uptime;
/*    */   }
/*    */ 
/*    */   public Integer getPyvid()
/*    */   {
/* 41 */     return this.pyvid;
/*    */   }
/*    */ 
/*    */   public void setPyvid(Integer pyvid) {
/* 45 */     this.pyvid = pyvid;
/*    */   }
/*    */ 
/*    */   public String getStucode() {
/* 49 */     return this.stucode;
/*    */   }
/*    */ 
/*    */   public void setStucode(String stucode) {
/* 53 */     this.stucode = stucode;
/*    */   }
/*    */ 
/*    */   public String getTeccode() {
/* 57 */     return this.teccode;
/*    */   }
/*    */ 
/*    */   public void setTeccode(String teccode) {
/* 61 */     this.teccode = teccode;
/*    */   }
/*    */ 
/*    */   public Integer getAtid() {
/* 65 */     return this.atid;
/*    */   }
/*    */ 
/*    */   public void setAtid(Integer atid) {
/* 69 */     this.atid = atid;
/*    */   }
/*    */ 
/*    */   public String getPingyu() {
/* 73 */     return this.pingyu;
/*    */   }
/*    */ 
/*    */   public void setPingyu(String pingyu) {
/* 77 */     this.pingyu = pingyu;
/*    */   }
/*    */ 
/*    */   public Date getUptime() {
/* 81 */     return this.uptime;
/*    */   }
/*    */ 
/*    */   public void setUptime(Date uptime) {
/* 85 */     this.uptime = uptime;
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.pingyue.PingyuViewer
 * JD-Core Version:    0.5.4
 */