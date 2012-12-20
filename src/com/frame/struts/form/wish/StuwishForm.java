/*     */ package com.frame.struts.form.wish;
/*     */ 
/*     */ import java.util.Date;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class StuwishForm extends ActionForm
/*     */ {
/*     */   private String stucode;
/*     */   private Integer atid;
/*     */   private Integer wishstate;
/*     */   private String teccode;
/*     */   private Date dateaccess;
/*     */   private Date dateup;
/*     */   private Integer wishid;
/*     */   private Integer priority;
/*     */ 
/*     */   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*  62 */     return null;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getStucode()
/*     */   {
/*  79 */     return this.stucode;
/*     */   }
/*     */ 
/*     */   public void setStucode(String stucode)
/*     */   {
/*  87 */     this.stucode = stucode;
/*     */   }
/*     */ 
/*     */   public Integer getAtid()
/*     */   {
/*  95 */     return this.atid;
/*     */   }
/*     */ 
/*     */   public void setAtid(Integer atid)
/*     */   {
/* 103 */     this.atid = atid;
/*     */   }
/*     */ 
/*     */   public Integer getWishstate()
/*     */   {
/* 111 */     return this.wishstate;
/*     */   }
/*     */ 
/*     */   public void setWishstate(Integer wishstate)
/*     */   {
/* 119 */     this.wishstate = wishstate;
/*     */   }
/*     */ 
/*     */   public String getTeccode()
/*     */   {
/* 127 */     return this.teccode;
/*     */   }
/*     */ 
/*     */   public void setTeccode(String teccode)
/*     */   {
/* 135 */     this.teccode = teccode;
/*     */   }
/*     */ 
/*     */   public Date getDateaccess()
/*     */   {
/* 143 */     return this.dateaccess;
/*     */   }
/*     */ 
/*     */   public void setDateaccess(Date dateaccess)
/*     */   {
/* 151 */     this.dateaccess = dateaccess;
/*     */   }
/*     */ 
/*     */   public Date getDateup()
/*     */   {
/* 159 */     return this.dateup;
/*     */   }
/*     */ 
/*     */   public void setDateup(Date dateup)
/*     */   {
/* 167 */     this.dateup = dateup;
/*     */   }
/*     */ 
/*     */   public Integer getWishid()
/*     */   {
/* 175 */     return this.wishid;
/*     */   }
/*     */ 
/*     */   public void setWishid(Integer wishid)
/*     */   {
/* 183 */     this.wishid = wishid;
/*     */   }
/*     */ 
/*     */   public Integer getPriority()
/*     */   {
/* 191 */     return this.priority;
/*     */   }
/*     */ 
/*     */   public void setPriority(Integer priority)
/*     */   {
/* 199 */     this.priority = priority;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.form.wish.StuwishForm
 * JD-Core Version:    0.5.4
 */