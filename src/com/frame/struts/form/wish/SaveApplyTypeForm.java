/*     */ package com.frame.struts.form.wish;
/*     */ 
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class SaveApplyTypeForm extends ActionForm
/*     */ {
/*     */   private Integer departid;
/*     */   private String typename;
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
/*     */   public Integer getDepartid()
/*     */   {
/*  63 */     return this.departid;
/*     */   }
/*     */ 
/*     */   public void setDepartid(Integer departid)
/*     */   {
/*  71 */     this.departid = departid;
/*     */   }
/*     */ 
/*     */   public String getTypename()
/*     */   {
/*  79 */     return this.typename;
/*     */   }
/*     */ 
/*     */   public void setTypename(String typename)
/*     */   {
/*  87 */     this.typename = typename;
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
 * Qualified Name:     com.frame.struts.form.wish.SaveApplyTypeForm
 * JD-Core Version:    0.5.4
 */