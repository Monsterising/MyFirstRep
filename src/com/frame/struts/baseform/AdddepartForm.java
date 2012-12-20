/*     */ package com.frame.struts.baseform;
/*     */ 
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class AdddepartForm extends ActionForm
/*     */ {
/*     */   private String op;
/*     */   private Integer collegeid;
/*     */   private Integer departid;
/*     */   private String departname;
/*     */ 
/*     */   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*  48 */     return null;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public Integer getCollegeid()
/*     */   {
/*  65 */     return this.collegeid;
/*     */   }
/*     */ 
/*     */   public void setCollegeid(Integer collegeid)
/*     */   {
/*  73 */     this.collegeid = collegeid;
/*     */   }
/*     */ 
/*     */   public Integer getDepartid()
/*     */   {
/*  81 */     return this.departid;
/*     */   }
/*     */ 
/*     */   public void setDepartid(Integer departid)
/*     */   {
/*  89 */     this.departid = departid;
/*     */   }
/*     */ 
/*     */   public String getDepartname()
/*     */   {
/*  97 */     return this.departname;
/*     */   }
/*     */ 
/*     */   public void setDepartname(String departname)
/*     */   {
/* 105 */     this.departname = departname;
/*     */   }
/*     */ 
/*     */   public String getOp() {
/* 109 */     return this.op;
/*     */   }
/*     */ 
/*     */   public void setOp(String op) {
/* 113 */     this.op = op;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.baseform.AdddepartForm
 * JD-Core Version:    0.5.4
 */