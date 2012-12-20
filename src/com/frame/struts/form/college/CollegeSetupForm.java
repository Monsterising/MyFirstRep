/*     */ package com.frame.struts.form.college;
/*     */ 
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class CollegeSetupForm extends ActionForm
/*     */ {
/*     */   private String datestart;
/*     */   private Integer collegeid;
/*     */   private Integer id;
/*     */   private String dateover;
/*     */ 
/*     */   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*  49 */     return null;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getDatestart()
/*     */   {
/*  66 */     return this.datestart;
/*     */   }
/*     */ 
/*     */   public void setDatestart(String datestart)
/*     */   {
/*  74 */     this.datestart = datestart;
/*     */   }
/*     */ 
/*     */   public Integer getCollegeid()
/*     */   {
/*  82 */     return this.collegeid;
/*     */   }
/*     */ 
/*     */   public void setCollegeid(Integer collegeid)
/*     */   {
/*  90 */     this.collegeid = collegeid;
/*     */   }
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  98 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Integer id)
/*     */   {
/* 106 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getDateover()
/*     */   {
/* 114 */     return this.dateover;
/*     */   }
/*     */ 
/*     */   public void setDateover(String dateover)
/*     */   {
/* 122 */     this.dateover = dateover;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.form.college.CollegeSetupForm
 * JD-Core Version:    0.5.4
 */