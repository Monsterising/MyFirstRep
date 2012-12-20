/*     */ package com.frame.struts.form.pingyue;
/*     */ 
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class PingyueshezhiForm extends ActionForm
/*     */ {
/*     */   private Integer gradeid;
/*     */   private String teccode;
/*     */   private Integer pygid;
/*     */   private Integer departid;
/*     */   private String[] stucodes;
/*     */   private String op;
/*     */ 
/*     */   public String getOp()
/*     */   {
/*  45 */     return this.op;
/*     */   }
/*     */ 
/*     */   public void setOp(String op) {
/*  49 */     this.op = op;
/*     */   }
/*     */ 
/*     */   public String[] getStucodes() {
/*  53 */     return this.stucodes;
/*     */   }
/*     */ 
/*     */   public void setStucodes(String[] stucodes) {
/*  57 */     this.stucodes = stucodes;
/*     */   }
/*     */ 
/*     */   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*  69 */     return null;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public Integer getGradeid()
/*     */   {
/*  86 */     return this.gradeid;
/*     */   }
/*     */ 
/*     */   public void setGradeid(Integer gradeid)
/*     */   {
/*  94 */     this.gradeid = gradeid;
/*     */   }
/*     */ 
/*     */   public String getTeccode()
/*     */   {
/* 102 */     return this.teccode;
/*     */   }
/*     */ 
/*     */   public void setTeccode(String teccode)
/*     */   {
/* 110 */     this.teccode = teccode;
/*     */   }
/*     */ 
/*     */   public Integer getPygid()
/*     */   {
/* 118 */     return this.pygid;
/*     */   }
/*     */ 
/*     */   public void setPygid(Integer pygid)
/*     */   {
/* 126 */     this.pygid = pygid;
/*     */   }
/*     */ 
/*     */   public Integer getDepartid()
/*     */   {
/* 134 */     return this.departid;
/*     */   }
/*     */ 
/*     */   public void setDepartid(Integer departid)
/*     */   {
/* 142 */     this.departid = departid;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.form.pingyue.PingyueshezhiForm
 * JD-Core Version:    0.5.4
 */