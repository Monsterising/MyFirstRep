/*     */ package com.frame.struts.form.wish;
/*     */ 
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ import org.apache.struts.upload.FormFile;
/*     */ 
/*     */ public class FileForm extends ActionForm
/*     */ {
/*     */   private String stucode;
/*     */   private Integer atid;
/*     */   private Integer atrid;
/*     */   private Integer resultid;
/*     */   private FormFile myfile;
/*     */ 
/*     */   public FormFile getMyfile()
/*     */   {
/*  43 */     return this.myfile;
/*     */   }
/*     */ 
/*     */   public void setMyfile(FormFile myfile) {
/*  47 */     this.myfile = myfile;
/*     */   }
/*     */ 
/*     */   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*  59 */     return null;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getStucode()
/*     */   {
/*  76 */     return this.stucode;
/*     */   }
/*     */ 
/*     */   public void setStucode(String stucode)
/*     */   {
/*  84 */     this.stucode = stucode;
/*     */   }
/*     */ 
/*     */   public Integer getAtid()
/*     */   {
/*  92 */     return this.atid;
/*     */   }
/*     */ 
/*     */   public void setAtid(Integer atid)
/*     */   {
/* 100 */     this.atid = atid;
/*     */   }
/*     */ 
/*     */   public Integer getAtrid()
/*     */   {
/* 108 */     return this.atrid;
/*     */   }
/*     */ 
/*     */   public void setAtrid(Integer atrid)
/*     */   {
/* 116 */     this.atrid = atrid;
/*     */   }
/*     */ 
/*     */   public Integer getResultid()
/*     */   {
/* 124 */     return this.resultid;
/*     */   }
/*     */ 
/*     */   public void setResultid(Integer resultid)
/*     */   {
/* 132 */     this.resultid = resultid;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.form.wish.FileForm
 * JD-Core Version:    0.5.4
 */