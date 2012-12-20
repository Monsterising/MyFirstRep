/*     */ package com.frame.struts.form.pingyu;
/*     */ 
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class PingyustuForm extends ActionForm
/*     */ {
/*     */   private String stucode;
/*     */   private String attitude;
/*     */   private Integer atid;
/*     */   private String result;
/*     */   private String content;
/*     */   private String bj;
/*     */ 
/*     */   public String getBj()
/*     */   {
/*  46 */     return this.bj;
/*     */   }
/*     */ 
/*     */   public void setBj(String bj) {
/*  50 */     this.bj = bj;
/*     */   }
/*     */ 
/*     */   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*  62 */     return null;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getStucode()
/*     */   {
/*  79 */     return this.stucode;
/*     */   }
/*     */ 
/*     */   public void setStucode(String stucode)
/*     */   {
/*  87 */     this.stucode = stucode;
/*     */   }
/*     */ 
/*     */   public String getAttitude()
/*     */   {
/*  95 */     return this.attitude;
/*     */   }
/*     */ 
/*     */   public void setAttitude(String attitude)
/*     */   {
/* 103 */     this.attitude = attitude;
/*     */   }
/*     */ 
/*     */   public Integer getAtid()
/*     */   {
/* 111 */     return this.atid;
/*     */   }
/*     */ 
/*     */   public void setAtid(Integer atid)
/*     */   {
/* 119 */     this.atid = atid;
/*     */   }
/*     */ 
/*     */   public String getResult()
/*     */   {
/* 127 */     return this.result;
/*     */   }
/*     */ 
/*     */   public void setResult(String result)
/*     */   {
/* 135 */     this.result = result;
/*     */   }
/*     */ 
/*     */   public String getContent()
/*     */   {
/* 143 */     return this.content;
/*     */   }
/*     */ 
/*     */   public void setContent(String content)
/*     */   {
/* 151 */     this.content = content;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.form.pingyu.PingyustuForm
 * JD-Core Version:    0.5.4
 */