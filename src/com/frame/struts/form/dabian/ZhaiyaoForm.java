/*     */ package com.frame.struts.form.dabian;
/*     */ 
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class ZhaiyaoForm extends ActionForm
/*     */ {
/*     */   private String stucode;
/*     */   private Integer zyid;
/*     */   private String keywords;
/*     */   private String content;
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
/*     */   public String getStucode()
/*     */   {
/*  66 */     return this.stucode;
/*     */   }
/*     */ 
/*     */   public void setStucode(String stucode)
/*     */   {
/*  74 */     this.stucode = stucode;
/*     */   }
/*     */ 
/*     */   public Integer getZyid()
/*     */   {
/*  82 */     return this.zyid;
/*     */   }
/*     */ 
/*     */   public void setZyid(Integer zyid)
/*     */   {
/*  90 */     this.zyid = zyid;
/*     */   }
/*     */ 
/*     */   public String getKeywords()
/*     */   {
/*  98 */     return this.keywords;
/*     */   }
/*     */ 
/*     */   public void setKeywords(String keywords)
/*     */   {
/* 106 */     this.keywords = keywords;
/*     */   }
/*     */ 
/*     */   public String getContent()
/*     */   {
/* 114 */     return this.content;
/*     */   }
/*     */ 
/*     */   public void setContent(String content)
/*     */   {
/* 122 */     this.content = content;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.form.dabian.ZhaiyaoForm
 * JD-Core Version:    0.5.4
 */