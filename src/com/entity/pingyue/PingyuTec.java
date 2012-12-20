/*     */ package com.entity.pingyue;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class PingyuTec
/*     */   implements Serializable
/*     */ {
/*     */   private Integer pytid;
/*     */   private String stucode;
/*     */   private String teccode;
/*     */   private Integer atid;
/*     */   private String pingyu;
/*     */   private Date uptime;
/*     */   private String chengji;
/*     */ 
/*     */   public PingyuTec()
/*     */   {
/*     */   }
/*     */ 
/*     */   public PingyuTec(Integer pytid)
/*     */   {
/*  31 */     this.pytid = pytid;
/*     */   }
/*     */ 
/*     */   public PingyuTec(Integer pytid, String stucode, String teccode, Integer atid, String pingyu, Date uptime, String chengji)
/*     */   {
/*  37 */     this.pytid = pytid;
/*  38 */     this.stucode = stucode;
/*  39 */     this.teccode = teccode;
/*  40 */     this.atid = atid;
/*  41 */     this.pingyu = pingyu;
/*  42 */     this.uptime = uptime;
/*  43 */     this.chengji = chengji;
/*     */   }
/*     */ 
/*     */   public Integer getPytid()
/*     */   {
/*  49 */     return this.pytid;
/*     */   }
/*     */ 
/*     */   public void setPytid(Integer pytid) {
/*  53 */     this.pytid = pytid;
/*     */   }
/*     */ 
/*     */   public String getStucode() {
/*  57 */     return this.stucode;
/*     */   }
/*     */ 
/*     */   public void setStucode(String stucode) {
/*  61 */     this.stucode = stucode;
/*     */   }
/*     */ 
/*     */   public String getTeccode() {
/*  65 */     return this.teccode;
/*     */   }
/*     */ 
/*     */   public void setTeccode(String teccode) {
/*  69 */     this.teccode = teccode;
/*     */   }
/*     */ 
/*     */   public Integer getAtid() {
/*  73 */     return this.atid;
/*     */   }
/*     */ 
/*     */   public void setAtid(Integer atid) {
/*  77 */     this.atid = atid;
/*     */   }
/*     */ 
/*     */   public String getPingyu() {
/*  81 */     return this.pingyu;
/*     */   }
/*     */ 
/*     */   public void setPingyu(String pingyu) {
/*  85 */     this.pingyu = pingyu;
/*     */   }
/*     */ 
/*     */   public Date getUptime() {
/*  89 */     return this.uptime;
/*     */   }
/*     */ 
/*     */   public void setUptime(Date uptime) {
/*  93 */     this.uptime = uptime;
/*     */   }
/*     */ 
/*     */   public String getChengji() {
/*  97 */     return this.chengji;
/*     */   }
/*     */ 
/*     */   public void setChengji(String chengji) {
/* 101 */     this.chengji = chengji;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.pingyue.PingyuTec
 * JD-Core Version:    0.5.4
 */