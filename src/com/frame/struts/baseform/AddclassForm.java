/*     */ package com.frame.struts.baseform;
/*     */ 
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class AddclassForm extends ActionForm
/*     */ {
/*     */   private String op;
/*     */   private String classname;
/*     */   private Integer gradeid;
/*     */   private String classnameshort;
/*     */   private Integer departid;
/*     */   private Integer collegeid;
/*     */   private Integer classid;
/*     */ 
/*     */   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*  58 */     return null;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getClassname()
/*     */   {
/*  75 */     return this.classname;
/*     */   }
/*     */ 
/*     */   public void setClassname(String classname)
/*     */   {
/*  83 */     this.classname = classname;
/*     */   }
/*     */ 
/*     */   public Integer getGradeid()
/*     */   {
/*  91 */     return this.gradeid;
/*     */   }
/*     */ 
/*     */   public void setGradeid(Integer gradeid)
/*     */   {
/*  99 */     this.gradeid = gradeid;
/*     */   }
/*     */ 
/*     */   public String getClassnameshort()
/*     */   {
/* 107 */     return this.classnameshort;
/*     */   }
/*     */ 
/*     */   public void setClassnameshort(String classnameshort)
/*     */   {
/* 115 */     this.classnameshort = classnameshort;
/*     */   }
/*     */ 
/*     */   public Integer getDepartid()
/*     */   {
/* 123 */     return this.departid;
/*     */   }
/*     */ 
/*     */   public void setDepartid(Integer departid)
/*     */   {
/* 131 */     this.departid = departid;
/*     */   }
/*     */ 
/*     */   public Integer getCollegeid()
/*     */   {
/* 139 */     return this.collegeid;
/*     */   }
/*     */ 
/*     */   public void setCollegeid(Integer collegeid)
/*     */   {
/* 147 */     this.collegeid = collegeid;
/*     */   }
/*     */ 
/*     */   public Integer getClassid()
/*     */   {
/* 155 */     return this.classid;
/*     */   }
/*     */ 
/*     */   public void setClassid(Integer classid)
/*     */   {
/* 163 */     this.classid = classid;
/*     */   }
/*     */ 
/*     */   public String getOp() {
/* 167 */     return this.op;
/*     */   }
/*     */ 
/*     */   public void setOp(String op) {
/* 171 */     this.op = op;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.baseform.AddclassForm
 * JD-Core Version:    0.5.4
 */