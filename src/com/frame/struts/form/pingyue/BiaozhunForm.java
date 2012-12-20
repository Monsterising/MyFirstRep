/*     */ package com.frame.struts.form.pingyue;
/*     */ 
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class BiaozhunForm extends ActionForm
/*     */ {
/*     */   private Integer minnum;
/*     */   private String type;
/*     */   private Integer maxnum;
/*     */   private String content;
/*     */   private String grade;
/*     */   private Integer bzid;
/*     */   private String op;
/*     */ 
/*     */   public String getOp()
/*     */   {
/*  49 */     return this.op;
/*     */   }
/*     */ 
/*     */   public void setOp(String op) {
/*  53 */     this.op = op;
/*     */   }
/*     */ 
/*     */   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*  65 */     return null;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public Integer getMinnum()
/*     */   {
/*  82 */     return this.minnum;
/*     */   }
/*     */ 
/*     */   public void setMinnum(Integer minnum)
/*     */   {
/*  90 */     this.minnum = minnum;
/*     */   }
/*     */ 
/*     */   public String getType()
/*     */   {
/*  98 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setType(String type)
/*     */   {
/* 106 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public Integer getMaxnum()
/*     */   {
/* 114 */     return this.maxnum;
/*     */   }
/*     */ 
/*     */   public void setMaxnum(Integer maxnum)
/*     */   {
/* 122 */     this.maxnum = maxnum;
/*     */   }
/*     */ 
/*     */   public String getContent()
/*     */   {
/* 130 */     return this.content;
/*     */   }
/*     */ 
/*     */   public void setContent(String content)
/*     */   {
/* 138 */     this.content = content;
/*     */   }
/*     */ 
/*     */   public String getGrade()
/*     */   {
/* 146 */     return this.grade;
/*     */   }
/*     */ 
/*     */   public void setGrade(String grade)
/*     */   {
/* 154 */     this.grade = grade;
/*     */   }
/*     */ 
/*     */   public Integer getBzid()
/*     */   {
/* 162 */     return this.bzid;
/*     */   }
/*     */ 
/*     */   public void setBzid(Integer bzid)
/*     */   {
/* 170 */     this.bzid = bzid;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.form.pingyue.BiaozhunForm
 * JD-Core Version:    0.5.4
 */