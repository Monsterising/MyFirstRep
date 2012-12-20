/*     */ package com.frame.struts.form.task;
/*     */ 
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class DayiForm extends ActionForm
/*     */ {
/*     */   private String stucode;
/*     */   private Integer gradeid;
/*     */   private String teccode;
/*     */   private Integer isok;
/*     */   private String answer;
/*     */   private Integer departid;
/*     */   private Integer dyid;
/*     */   private String question;
/*     */ 
/*     */   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*  61 */     return null;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getStucode()
/*     */   {
/*  78 */     return this.stucode;
/*     */   }
/*     */ 
/*     */   public void setStucode(String stucode)
/*     */   {
/*  86 */     this.stucode = stucode;
/*     */   }
/*     */ 
/*     */   public Integer getGradeid()
/*     */   {
/*  94 */     return this.gradeid;
/*     */   }
/*     */ 
/*     */   public void setGradeid(Integer gradeid)
/*     */   {
/* 102 */     this.gradeid = gradeid;
/*     */   }
/*     */ 
/*     */   public String getTeccode()
/*     */   {
/* 110 */     return this.teccode;
/*     */   }
/*     */ 
/*     */   public void setTeccode(String teccode)
/*     */   {
/* 118 */     this.teccode = teccode;
/*     */   }
/*     */ 
/*     */   public Integer getIsok()
/*     */   {
/* 126 */     return this.isok;
/*     */   }
/*     */ 
/*     */   public void setIsok(Integer isok)
/*     */   {
/* 134 */     this.isok = isok;
/*     */   }
/*     */ 
/*     */   public String getAnswer()
/*     */   {
/* 142 */     return this.answer;
/*     */   }
/*     */ 
/*     */   public void setAnswer(String answer)
/*     */   {
/* 150 */     this.answer = answer;
/*     */   }
/*     */ 
/*     */   public Integer getDepartid()
/*     */   {
/* 158 */     return this.departid;
/*     */   }
/*     */ 
/*     */   public void setDepartid(Integer departid)
/*     */   {
/* 166 */     this.departid = departid;
/*     */   }
/*     */ 
/*     */   public Integer getDyid()
/*     */   {
/* 174 */     return this.dyid;
/*     */   }
/*     */ 
/*     */   public void setDyid(Integer dyid)
/*     */   {
/* 182 */     this.dyid = dyid;
/*     */   }
/*     */ 
/*     */   public String getQuestion()
/*     */   {
/* 190 */     return this.question;
/*     */   }
/*     */ 
/*     */   public void setQuestion(String question)
/*     */   {
/* 198 */     this.question = question;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.form.task.DayiForm
 * JD-Core Version:    0.5.4
 */