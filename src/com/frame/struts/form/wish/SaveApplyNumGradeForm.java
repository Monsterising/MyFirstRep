/*     */ package com.frame.struts.form.wish;
/*     */ 
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class SaveApplyNumGradeForm extends ActionForm
/*     */ {
/*     */   private Integer num;
/*     */   private Integer gradeid;
/*     */   private Integer departid;
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
/*     */   public Integer getNum()
/*     */   {
/*  63 */     return this.num;
/*     */   }
/*     */ 
/*     */   public void setNum(Integer num)
/*     */   {
/*  71 */     this.num = num;
/*     */   }
/*     */ 
/*     */   public Integer getGradeid()
/*     */   {
/*  79 */     return this.gradeid;
/*     */   }
/*     */ 
/*     */   public void setGradeid(Integer gradeid)
/*     */   {
/*  87 */     this.gradeid = gradeid;
/*     */   }
/*     */ 
/*     */   public Integer getDepartid()
/*     */   {
/*  95 */     return this.departid;
/*     */   }
/*     */ 
/*     */   public void setDepartid(Integer departid)
/*     */   {
/* 103 */     this.departid = departid;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.form.wish.SaveApplyNumGradeForm
 * JD-Core Version:    0.5.4
 */