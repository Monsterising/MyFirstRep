/*     */ package com.frame.struts.form.task;
/*     */ 
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ import org.apache.struts.upload.FormFile;
/*     */ 
/*     */ public class StagetaskForm extends ActionForm
/*     */ {
/*     */   private Integer fujianid;
/*     */   private FormFile myfile;
/*     */   private String stucode;
/*     */   private Integer gradeid;
/*     */   private String datestart;
/*     */   private String datefagei;
/*     */   private Integer isFujian;
/*     */   private Integer isDayi;
/*     */   private String notes;
/*     */   private String taskname;
/*     */   private String dateover;
/*     */   private Integer atid;
/*     */   private String teccode;
/*     */   private Integer isFinish;
/*     */   private String result;
/*     */   private String dayitime;
/*     */   private Integer stid;
/*     */   private String fujiantime;
/*     */ 
/*     */   public Integer getFujianid()
/*     */   {
/*  76 */     return this.fujianid;
/*     */   }
/*     */ 
/*     */   public void setFujianid(Integer fujianid) {
/*  80 */     this.fujianid = fujianid;
/*     */   }
/*     */ 
/*     */   public FormFile getMyfile() {
/*  84 */     return this.myfile;
/*     */   }
/*     */ 
/*     */   public void setMyfile(FormFile myfile) {
/*  88 */     this.myfile = myfile;
/*     */   }
/*     */ 
/*     */   public Integer getGradeid() {
/*  92 */     return this.gradeid;
/*     */   }
/*     */ 
/*     */   public void setGradeid(Integer gradeid) {
/*  96 */     this.gradeid = gradeid;
/*     */   }
/*     */ 
/*     */   public String getDatefagei() {
/* 100 */     return this.datefagei;
/*     */   }
/*     */ 
/*     */   public void setDatefagei(String datefagei) {
/* 104 */     this.datefagei = datefagei;
/*     */   }
/*     */ 
/*     */   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/* 116 */     return null;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getStucode()
/*     */   {
/* 133 */     return this.stucode;
/*     */   }
/*     */ 
/*     */   public void setStucode(String stucode)
/*     */   {
/* 141 */     this.stucode = stucode;
/*     */   }
/*     */ 
/*     */   public String getDatestart()
/*     */   {
/* 149 */     return this.datestart;
/*     */   }
/*     */ 
/*     */   public void setDatestart(String datestart)
/*     */   {
/* 157 */     this.datestart = datestart;
/*     */   }
/*     */ 
/*     */   public Integer getIsFujian()
/*     */   {
/* 165 */     return this.isFujian;
/*     */   }
/*     */ 
/*     */   public void setIsFujian(Integer isFujian)
/*     */   {
/* 173 */     this.isFujian = isFujian;
/*     */   }
/*     */ 
/*     */   public Integer getIsDayi()
/*     */   {
/* 181 */     return this.isDayi;
/*     */   }
/*     */ 
/*     */   public void setIsDayi(Integer isDayi)
/*     */   {
/* 189 */     this.isDayi = isDayi;
/*     */   }
/*     */ 
/*     */   public String getNotes()
/*     */   {
/* 197 */     return this.notes;
/*     */   }
/*     */ 
/*     */   public void setNotes(String notes)
/*     */   {
/* 205 */     this.notes = notes;
/*     */   }
/*     */ 
/*     */   public String getTaskname()
/*     */   {
/* 213 */     return this.taskname;
/*     */   }
/*     */ 
/*     */   public void setTaskname(String taskname)
/*     */   {
/* 221 */     this.taskname = taskname;
/*     */   }
/*     */ 
/*     */   public String getDateover()
/*     */   {
/* 229 */     return this.dateover;
/*     */   }
/*     */ 
/*     */   public void setDateover(String dateover)
/*     */   {
/* 237 */     this.dateover = dateover;
/*     */   }
/*     */ 
/*     */   public Integer getAtid()
/*     */   {
/* 245 */     return this.atid;
/*     */   }
/*     */ 
/*     */   public void setAtid(Integer atid)
/*     */   {
/* 253 */     this.atid = atid;
/*     */   }
/*     */ 
/*     */   public String getTeccode()
/*     */   {
/* 261 */     return this.teccode;
/*     */   }
/*     */ 
/*     */   public void setTeccode(String teccode)
/*     */   {
/* 269 */     this.teccode = teccode;
/*     */   }
/*     */ 
/*     */   public Integer getIsFinish()
/*     */   {
/* 277 */     return this.isFinish;
/*     */   }
/*     */ 
/*     */   public void setIsFinish(Integer isFinish)
/*     */   {
/* 285 */     this.isFinish = isFinish;
/*     */   }
/*     */ 
/*     */   public String getResult()
/*     */   {
/* 293 */     return this.result;
/*     */   }
/*     */ 
/*     */   public void setResult(String result)
/*     */   {
/* 301 */     this.result = result;
/*     */   }
/*     */ 
/*     */   public String getDayitime()
/*     */   {
/* 309 */     return this.dayitime;
/*     */   }
/*     */ 
/*     */   public void setDayitime(String dayitime)
/*     */   {
/* 317 */     this.dayitime = dayitime;
/*     */   }
/*     */ 
/*     */   public Integer getStid()
/*     */   {
/* 325 */     return this.stid;
/*     */   }
/*     */ 
/*     */   public void setStid(Integer stid)
/*     */   {
/* 333 */     this.stid = stid;
/*     */   }
/*     */ 
/*     */   public String getFujiantime()
/*     */   {
/* 341 */     return this.fujiantime;
/*     */   }
/*     */ 
/*     */   public void setFujiantime(String fujiantime)
/*     */   {
/* 349 */     this.fujiantime = fujiantime;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.form.task.StagetaskForm
 * JD-Core Version:    0.5.4
 */