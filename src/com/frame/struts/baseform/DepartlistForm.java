/*     */ package com.frame.struts.baseform;
/*     */ 
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class DepartlistForm extends ActionForm
/*     */ {
/*     */   private String[] departadmin;
/*     */   private String[] departtec;
/*     */   private Integer departid;
/*     */   private String departname;
/*     */ 
/*     */   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*  51 */     return null;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String[] getDepartadmin()
/*     */   {
/*  68 */     return this.departadmin;
/*     */   }
/*     */ 
/*     */   public void setDepartadmin(String[] departadmin)
/*     */   {
/*  76 */     this.departadmin = departadmin;
/*     */   }
/*     */ 
/*     */   public Integer getDepartid()
/*     */   {
/*  84 */     return this.departid;
/*     */   }
/*     */ 
/*     */   public void setDepartid(Integer departid)
/*     */   {
/*  92 */     this.departid = departid;
/*     */   }
/*     */ 
/*     */   public String getDepartname()
/*     */   {
/* 100 */     return this.departname;
/*     */   }
/*     */ 
/*     */   public void setDepartname(String departname)
/*     */   {
/* 108 */     this.departname = departname;
/*     */   }
/*     */ 
/*     */   public String[] getDeparttec()
/*     */   {
/* 116 */     return this.departtec;
/*     */   }
/*     */ 
/*     */   public void setDeparttec(String[] departtec)
/*     */   {
/* 124 */     this.departtec = departtec;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.baseform.DepartlistForm
 * JD-Core Version:    0.5.4
 */