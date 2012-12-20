/*     */ package com.frame.struts.form.pingyue;
/*     */ 
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class PingyutecForm extends ActionForm
/*     */ {
/*     */   private String stucode;
/*     */   private Integer atid;
/*     */   private String teccode;
/*     */   private Integer pytid;
/*     */   private String chengji;
/*     */   private String pingyu;
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
/*     */   public String getStucode()
/*     */   {
/*  72 */     return this.stucode;
/*     */   }
/*     */ 
/*     */   public void setStucode(String stucode)
/*     */   {
/*  80 */     this.stucode = stucode;
/*     */   }
/*     */ 
/*     */   public Integer getAtid()
/*     */   {
/*  88 */     return this.atid;
/*     */   }
/*     */ 
/*     */   public void setAtid(Integer atid)
/*     */   {
/*  96 */     this.atid = atid;
/*     */   }
/*     */ 
/*     */   public String getTeccode()
/*     */   {
/* 104 */     return this.teccode;
/*     */   }
/*     */ 
/*     */   public void setTeccode(String teccode)
/*     */   {
/* 112 */     this.teccode = teccode;
/*     */   }
/*     */ 
/*     */   public Integer getPytid()
/*     */   {
/* 120 */     return this.pytid;
/*     */   }
/*     */ 
/*     */   public void setPytid(Integer pytid)
/*     */   {
/* 128 */     this.pytid = pytid;
/*     */   }
/*     */ 
/*     */   public String getChengji()
/*     */   {
/* 136 */     return this.chengji;
/*     */   }
/*     */ 
/*     */   public void setChengji(String chengji)
/*     */   {
/* 144 */     this.chengji = chengji;
/*     */   }
/*     */ 
/*     */   public String getPingyu()
/*     */   {
/* 152 */     return this.pingyu;
/*     */   }
/*     */ 
/*     */   public void setPingyu(String pingyu)
/*     */   {
/* 160 */     this.pingyu = pingyu;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.form.pingyue.PingyutecForm
 * JD-Core Version:    0.5.4
 */