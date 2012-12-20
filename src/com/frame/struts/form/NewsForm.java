/*     */ package com.frame.struts.form;
/*     */ 
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class NewsForm extends ActionForm
/*     */ {
/*     */   private String title;
/*     */   private String adduser;
/*     */   private String content;
/*     */   private Integer departid;
/*     */   private Integer click;
/*     */   private Integer newsid;
/*     */ 
/*     */   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*  55 */     return null;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getTitle()
/*     */   {
/*  72 */     return this.title;
/*     */   }
/*     */ 
/*     */   public void setTitle(String title)
/*     */   {
/*  80 */     this.title = title;
/*     */   }
/*     */ 
/*     */   public String getAdduser()
/*     */   {
/*  88 */     return this.adduser;
/*     */   }
/*     */ 
/*     */   public void setAdduser(String adduser)
/*     */   {
/*  96 */     this.adduser = adduser;
/*     */   }
/*     */ 
/*     */   public String getContent()
/*     */   {
/* 104 */     return this.content;
/*     */   }
/*     */ 
/*     */   public void setContent(String content)
/*     */   {
/* 112 */     this.content = content;
/*     */   }
/*     */ 
/*     */   public Integer getDepartid()
/*     */   {
/* 120 */     return this.departid;
/*     */   }
/*     */ 
/*     */   public void setDepartid(Integer departid)
/*     */   {
/* 128 */     this.departid = departid;
/*     */   }
/*     */ 
/*     */   public Integer getClick()
/*     */   {
/* 136 */     return this.click;
/*     */   }
/*     */ 
/*     */   public void setClick(Integer click)
/*     */   {
/* 144 */     this.click = click;
/*     */   }
/*     */ 
/*     */   public Integer getNewsid()
/*     */   {
/* 152 */     return this.newsid;
/*     */   }
/*     */ 
/*     */   public void setNewsid(Integer newsid)
/*     */   {
/* 160 */     this.newsid = newsid;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.form.NewsForm
 * JD-Core Version:    0.5.4
 */