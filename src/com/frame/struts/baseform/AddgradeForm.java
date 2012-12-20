/*     */ package com.frame.struts.baseform;
/*     */ 
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class AddgradeForm extends ActionForm
/*     */ {
/*     */   private Integer gradeid;
/*     */   private Integer collegeid;
/*     */   private Integer departid;
/*     */   private String gradename;
/*     */   private String op;
/*     */ 
/*     */   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*  50 */     return null;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public Integer getGradeid()
/*     */   {
/*  67 */     return this.gradeid;
/*     */   }
/*     */ 
/*     */   public void setGradeid(Integer gradeid)
/*     */   {
/*  75 */     this.gradeid = gradeid;
/*     */   }
/*     */ 
/*     */   public Integer getCollegeid()
/*     */   {
/*  83 */     return this.collegeid;
/*     */   }
/*     */ 
/*     */   public void setCollegeid(Integer collegeid)
/*     */   {
/*  91 */     this.collegeid = collegeid;
/*     */   }
/*     */ 
/*     */   public Integer getDepartid()
/*     */   {
/*  99 */     return this.departid;
/*     */   }
/*     */ 
/*     */   public void setDepartid(Integer departid)
/*     */   {
/* 107 */     this.departid = departid;
/*     */   }
/*     */ 
/*     */   public String getGradename()
/*     */   {
/* 115 */     return this.gradename;
/*     */   }
/*     */ 
/*     */   public void setGradename(String gradename)
/*     */   {
/* 123 */     this.gradename = gradename;
/*     */   }
/*     */ 
/*     */   public String getOp() {
/* 127 */     return this.op;
/*     */   }
/*     */ 
/*     */   public void setOp(String op) {
/* 131 */     this.op = op;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.baseform.AddgradeForm
 * JD-Core Version:    0.5.4
 */