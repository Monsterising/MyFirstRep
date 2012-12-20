/*     */ package com.frame.struts.baseform;
/*     */ 
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ import org.apache.struts.upload.FormFile;
/*     */ 
/*     */ public class UploadStusForm extends ActionForm
/*     */ {
/*     */   private String filetitle;
/*     */   private FormFile myfile;
/*     */   private Integer collegeid;
/*     */   private Integer departid;
/*     */   private Integer gradeid;
/*     */   private Integer classid;
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
/*     */   public String getFiletitle()
/*     */   {
/*  62 */     return this.filetitle;
/*     */   }
/*     */ 
/*     */   public void setFiletitle(String filetitle) {
/*  66 */     this.filetitle = filetitle;
/*     */   }
/*     */ 
/*     */   public FormFile getMyfile() {
/*  70 */     return this.myfile;
/*     */   }
/*     */ 
/*     */   public void setMyfile(FormFile myfile) {
/*  74 */     this.myfile = myfile;
/*     */   }
/*     */ 
/*     */   public Integer getCollegeid() {
/*  78 */     return this.collegeid;
/*     */   }
/*     */ 
/*     */   public void setCollegeid(Integer collegeid) {
/*  82 */     this.collegeid = collegeid;
/*     */   }
/*     */ 
/*     */   public Integer getDepartid() {
/*  86 */     return this.departid;
/*     */   }
/*     */ 
/*     */   public void setDepartid(Integer departid) {
/*  90 */     this.departid = departid;
/*     */   }
/*     */ 
/*     */   public Integer getGradeid() {
/*  94 */     return this.gradeid;
/*     */   }
/*     */ 
/*     */   public void setGradeid(Integer gradeid) {
/*  98 */     this.gradeid = gradeid;
/*     */   }
/*     */ 
/*     */   public Integer getClassid() {
/* 102 */     return this.classid;
/*     */   }
/*     */ 
/*     */   public void setClassid(Integer classid) {
/* 106 */     this.classid = classid;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.baseform.UploadStusForm
 * JD-Core Version:    0.5.4
 */