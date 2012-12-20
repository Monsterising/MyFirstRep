/*     */ package com.frame.struts.form.dabian;
/*     */ 
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class DabianchengjigradeForm extends ActionForm
/*     */ {
/*     */   private String zonghe;
/*     */   private String fanyi;
/*     */   private String dongshou;
/*     */   private String wentu;
/*     */   private String wenxian;
/*     */   private String guifan;
/*     */   private String stucode;
/*     */   private String dabian;
/*     */   private String chengji;
/*     */   private Integer dbgid;
/*     */   private Integer pfid;
/*     */ 
/*     */   public Integer getPfid()
/*     */   {
/*  51 */     return this.pfid;
/*     */   }
/*     */ 
/*     */   public void setPfid(Integer pfid)
/*     */   {
/*  57 */     this.pfid = pfid;
/*     */   }
/*     */ 
/*     */   public Integer getDbgid()
/*     */   {
/*  63 */     return this.dbgid;
/*     */   }
/*     */ 
/*     */   public void setDbgid(Integer dbgid)
/*     */   {
/*  69 */     this.dbgid = dbgid;
/*     */   }
/*     */ 
/*     */   public String getChengji() {
/*  73 */     return this.chengji;
/*     */   }
/*     */ 
/*     */   public void setChengji(String chengji) {
/*  77 */     this.chengji = chengji;
/*     */   }
/*     */ 
/*     */   public String getDabian() {
/*  81 */     return this.dabian;
/*     */   }
/*     */ 
/*     */   public void setDabian(String dabian) {
/*  85 */     this.dabian = dabian;
/*     */   }
/*     */ 
/*     */   public String getZonghe() {
/*  89 */     return this.zonghe;
/*     */   }
/*     */ 
/*     */   public void setZonghe(String zonghe) {
/*  93 */     this.zonghe = zonghe;
/*     */   }
/*     */ 
/*     */   public String getFanyi() {
/*  97 */     return this.fanyi;
/*     */   }
/*     */ 
/*     */   public void setFanyi(String fanyi) {
/* 101 */     this.fanyi = fanyi;
/*     */   }
/*     */ 
/*     */   public String getDongshou() {
/* 105 */     return this.dongshou;
/*     */   }
/*     */ 
/*     */   public void setDongshou(String dongshou) {
/* 109 */     this.dongshou = dongshou;
/*     */   }
/*     */ 
/*     */   public String getWentu() {
/* 113 */     return this.wentu;
/*     */   }
/*     */ 
/*     */   public void setWentu(String wentu) {
/* 117 */     this.wentu = wentu;
/*     */   }
/*     */ 
/*     */   public String getWenxian() {
/* 121 */     return this.wenxian;
/*     */   }
/*     */ 
/*     */   public void setWenxian(String wenxian) {
/* 125 */     this.wenxian = wenxian;
/*     */   }
/*     */ 
/*     */   public String getGuifan() {
/* 129 */     return this.guifan;
/*     */   }
/*     */ 
/*     */   public void setGuifan(String guifan) {
/* 133 */     this.guifan = guifan;
/*     */   }
/*     */ 
/*     */   public String getStucode() {
/* 137 */     return this.stucode;
/*     */   }
/*     */ 
/*     */   public void setStucode(String stucode) {
/* 141 */     this.stucode = stucode;
/*     */   }
/*     */ 
/*     */   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/* 153 */     return null;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.form.dabian.DabianchengjigradeForm
 * JD-Core Version:    0.5.4
 */