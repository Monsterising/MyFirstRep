/*     */ package com.frame.struts.form;
/*     */ 
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class DabianchengjiForm extends ActionForm
/*     */ {
/*     */   private String op;
/*     */   private String stucode;
/*     */   private String chengji;
/*     */   private Integer dbgid;
/*     */   private String pingyu;
/*     */   private Integer dcid;
/*     */ 
/*     */   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*  55 */     return null;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getOp()
/*     */   {
/*  72 */     return this.op;
/*     */   }
/*     */ 
/*     */   public void setOp(String op)
/*     */   {
/*  80 */     this.op = op;
/*     */   }
/*     */ 
/*     */   public String getStucode()
/*     */   {
/*  88 */     return this.stucode;
/*     */   }
/*     */ 
/*     */   public void setStucode(String stucode)
/*     */   {
/*  96 */     this.stucode = stucode;
/*     */   }
/*     */ 
/*     */   public String getChengji()
/*     */   {
/* 104 */     return this.chengji;
/*     */   }
/*     */ 
/*     */   public void setChengji(String chengji)
/*     */   {
/* 112 */     this.chengji = chengji;
/*     */   }
/*     */ 
/*     */   public Integer getDbgid()
/*     */   {
/* 120 */     return this.dbgid;
/*     */   }
/*     */ 
/*     */   public void setDbgid(Integer dbgid)
/*     */   {
/* 128 */     this.dbgid = dbgid;
/*     */   }
/*     */ 
/*     */   public String getPingyu()
/*     */   {
/* 136 */     return this.pingyu;
/*     */   }
/*     */ 
/*     */   public void setPingyu(String pingyu)
/*     */   {
/* 144 */     this.pingyu = pingyu;
/*     */   }
/*     */ 
/*     */   public Integer getDcid()
/*     */   {
/* 152 */     return this.dcid;
/*     */   }
/*     */ 
/*     */   public void setDcid(Integer dcid)
/*     */   {
/* 160 */     this.dcid = dcid;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.form.DabianchengjiForm
 * JD-Core Version:    0.5.4
 */