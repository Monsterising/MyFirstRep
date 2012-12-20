/*    */ package com.entity.dabian;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class DabianChengji
/*    */   implements Serializable
/*    */ {
/*    */   private Integer dcid;
/*    */   private String stucode;
/*    */   private Integer dbgid;
/*    */   private String pingyu;
/*    */   private Date pingyutime;
/*    */   private String chengji;
/*    */   private Date chengjitime;
/*    */ 
/*    */   public DabianChengji()
/*    */   {
/*    */   }
/*    */ 
/*    */   public DabianChengji(String stucode, Integer dbgid, String pingyu, Date pingyutime, String chengji, Date chengjitime)
/*    */   {
/* 32 */     this.stucode = stucode;
/* 33 */     this.dbgid = dbgid;
/* 34 */     this.pingyu = pingyu;
/* 35 */     this.pingyutime = pingyutime;
/* 36 */     this.chengji = chengji;
/* 37 */     this.chengjitime = chengjitime;
/*    */   }
/*    */ 
/*    */   public Integer getDcid()
/*    */   {
/* 43 */     return this.dcid;
/*    */   }
/*    */ 
/*    */   public void setDcid(Integer dcid) {
/* 47 */     this.dcid = dcid;
/*    */   }
/*    */ 
/*    */   public String getStucode() {
/* 51 */     return this.stucode;
/*    */   }
/*    */ 
/*    */   public void setStucode(String stucode) {
/* 55 */     this.stucode = stucode;
/*    */   }
/*    */ 
/*    */   public Integer getDbgid() {
/* 59 */     return this.dbgid;
/*    */   }
/*    */ 
/*    */   public void setDbgid(Integer dbgid) {
/* 63 */     this.dbgid = dbgid;
/*    */   }
/*    */ 
/*    */   public String getPingyu() {
/* 67 */     return this.pingyu;
/*    */   }
/*    */ 
/*    */   public void setPingyu(String pingyu) {
/* 71 */     this.pingyu = pingyu;
/*    */   }
/*    */ 
/*    */   public Date getPingyutime() {
/* 75 */     return this.pingyutime;
/*    */   }
/*    */ 
/*    */   public void setPingyutime(Date pingyutime) {
/* 79 */     this.pingyutime = pingyutime;
/*    */   }
/*    */ 
/*    */   public String getChengji() {
/* 83 */     return this.chengji;
/*    */   }
/*    */ 
/*    */   public void setChengji(String chengji) {
/* 87 */     this.chengji = chengji;
/*    */   }
/*    */ 
/*    */   public Date getChengjitime() {
/* 91 */     return this.chengjitime;
/*    */   }
/*    */ 
/*    */   public void setChengjitime(Date chengjitime) {
/* 95 */     this.chengjitime = chengjitime;
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.dabian.DabianChengji
 * JD-Core Version:    0.5.4
 */