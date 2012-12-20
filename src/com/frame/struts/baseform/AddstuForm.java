/*     */ package com.frame.struts.baseform;
/*     */ 
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class AddstuForm extends ActionForm
/*     */ {
/*     */   private String stucodehidden;
/*     */   private String op;
/*     */   private String stucode;
/*     */   private Integer gradeid;
/*     */   private String stusex;
/*     */   private Integer collegeid;
/*     */   private Integer departid;
/*     */   private String stuname;
/*     */   private String stupass;
/*     */   private Integer classid;
/*     */ 
/*     */   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*  64 */     return null;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getStucode()
/*     */   {
/*  81 */     return this.stucode;
/*     */   }
/*     */ 
/*     */   public void setStucode(String stucode)
/*     */   {
/*  89 */     this.stucode = stucode;
/*     */   }
/*     */ 
/*     */   public Integer getGradeid()
/*     */   {
/*  97 */     return this.gradeid;
/*     */   }
/*     */ 
/*     */   public void setGradeid(Integer gradeid)
/*     */   {
/* 105 */     this.gradeid = gradeid;
/*     */   }
/*     */ 
/*     */   public String getStusex()
/*     */   {
/* 113 */     return this.stusex;
/*     */   }
/*     */ 
/*     */   public void setStusex(String stusex)
/*     */   {
/* 121 */     this.stusex = stusex;
/*     */   }
/*     */ 
/*     */   public Integer getCollegeid()
/*     */   {
/* 129 */     return this.collegeid;
/*     */   }
/*     */ 
/*     */   public void setCollegeid(Integer collegeid)
/*     */   {
/* 137 */     this.collegeid = collegeid;
/*     */   }
/*     */ 
/*     */   public Integer getDepartid()
/*     */   {
/* 145 */     return this.departid;
/*     */   }
/*     */ 
/*     */   public void setDepartid(Integer departid)
/*     */   {
/* 153 */     this.departid = departid;
/*     */   }
/*     */ 
/*     */   public String getStuname()
/*     */   {
/* 161 */     return this.stuname;
/*     */   }
/*     */ 
/*     */   public void setStuname(String stuname)
/*     */   {
/* 169 */     this.stuname = stuname;
/*     */   }
/*     */ 
/*     */   public String getStupass()
/*     */   {
/* 177 */     return this.stupass;
/*     */   }
/*     */ 
/*     */   public void setStupass(String stupass)
/*     */   {
/* 185 */     this.stupass = stupass;
/*     */   }
/*     */ 
/*     */   public Integer getClassid()
/*     */   {
/* 193 */     return this.classid;
/*     */   }
/*     */ 
/*     */   public void setClassid(Integer classid)
/*     */   {
/* 201 */     this.classid = classid;
/*     */   }
/*     */ 
/*     */   public String getOp() {
/* 205 */     return this.op;
/*     */   }
/*     */ 
/*     */   public void setOp(String op) {
/* 209 */     this.op = op;
/*     */   }
/*     */ 
/*     */   public String getStucodehidden() {
/* 213 */     return this.stucodehidden;
/*     */   }
/*     */ 
/*     */   public void setStucodehidden(String stucodehidden) {
/* 217 */     this.stucodehidden = stucodehidden;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.baseform.AddstuForm
 * JD-Core Version:    0.5.4
 */