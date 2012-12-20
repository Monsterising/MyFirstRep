/*     */ package com.frame.struts.form.wish;
/*     */ 
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class SaveApplyResultForm extends ActionForm
/*     */ {
/*     */   private String resultname;
/*     */   private Integer departid;
/*     */   private Integer id;
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
/*     */   public String getResultname()
/*     */   {
/*  63 */     return this.resultname;
/*     */   }
/*     */ 
/*     */   public void setResultname(String resultname)
/*     */   {
/*  71 */     this.resultname = resultname;
/*     */   }
/*     */ 
/*     */   public Integer getDepartid()
/*     */   {
/*  79 */     return this.departid;
/*     */   }
/*     */ 
/*     */   public void setDepartid(Integer departid)
/*     */   {
/*  87 */     this.departid = departid;
/*     */   }
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  95 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Integer id)
/*     */   {
/* 103 */     this.id = id;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.form.wish.SaveApplyResultForm
 * JD-Core Version:    0.5.4
 */