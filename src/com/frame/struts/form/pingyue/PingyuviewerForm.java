/*     */ package com.frame.struts.form.pingyue;
/*     */ 
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class PingyuviewerForm extends ActionForm
/*     */ {
/*     */   private String stucode;
/*     */   private Integer atid;
/*     */   private String teccode;
/*     */   private Integer pyvid;
/*     */   private String pingyu;
/*     */ 
/*     */   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*  52 */     return null;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getStucode()
/*     */   {
/*  69 */     return this.stucode;
/*     */   }
/*     */ 
/*     */   public void setStucode(String stucode)
/*     */   {
/*  77 */     this.stucode = stucode;
/*     */   }
/*     */ 
/*     */   public Integer getAtid()
/*     */   {
/*  85 */     return this.atid;
/*     */   }
/*     */ 
/*     */   public void setAtid(Integer atid)
/*     */   {
/*  93 */     this.atid = atid;
/*     */   }
/*     */ 
/*     */   public String getTeccode()
/*     */   {
/* 101 */     return this.teccode;
/*     */   }
/*     */ 
/*     */   public void setTeccode(String teccode)
/*     */   {
/* 109 */     this.teccode = teccode;
/*     */   }
/*     */ 
/*     */   public Integer getPyvid()
/*     */   {
/* 117 */     return this.pyvid;
/*     */   }
/*     */ 
/*     */   public void setPyvid(Integer pyvid)
/*     */   {
/* 125 */     this.pyvid = pyvid;
/*     */   }
/*     */ 
/*     */   public String getPingyu()
/*     */   {
/* 133 */     return this.pingyu;
/*     */   }
/*     */ 
/*     */   public void setPingyu(String pingyu)
/*     */   {
/* 141 */     this.pingyu = pingyu;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.form.pingyue.PingyuviewerForm
 * JD-Core Version:    0.5.4
 */