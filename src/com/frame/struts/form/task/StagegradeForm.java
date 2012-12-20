/*     */ package com.frame.struts.form.task;
/*     */ 
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class StagegradeForm extends ActionForm
/*     */ {
/*     */   private String result;
/*     */   private String grade;
/*     */   private Integer stid;
/*     */ 
/*     */   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*  46 */     return null;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getResult()
/*     */   {
/*  63 */     return this.result;
/*     */   }
/*     */ 
/*     */   public void setResult(String result)
/*     */   {
/*  71 */     this.result = result;
/*     */   }
/*     */ 
/*     */   public String getGrade()
/*     */   {
/*  79 */     return this.grade;
/*     */   }
/*     */ 
/*     */   public void setGrade(String grade)
/*     */   {
/*  87 */     this.grade = grade;
/*     */   }
/*     */ 
/*     */   public Integer getStid()
/*     */   {
/*  95 */     return this.stid;
/*     */   }
/*     */ 
/*     */   public void setStid(Integer stid)
/*     */   {
/* 103 */     this.stid = stid;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.form.task.StagegradeForm
 * JD-Core Version:    0.5.4
 */