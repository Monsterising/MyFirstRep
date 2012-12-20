/*     */ package com.frame.struts.form.task;
/*     */ 
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class TaskForm extends ActionForm
/*     */ {
/*     */   private String begintime;
/*     */   private String overtime;
/*     */   private String toyoutime;
/*     */   private String op;
/*     */   private String yaoqiu;
/*     */   private String stucode;
/*     */   private Integer atid;
/*     */   private String neirong;
/*     */   private String teccode;
/*     */   private Integer collegeid;
/*     */   private Integer departid;
/*     */   private Integer taskid;
/*     */   private String ziliao;
/*     */ 
/*     */   public String getOp()
/*     */   {
/*  64 */     return this.op;
/*     */   }
/*     */ 
/*     */   public void setOp(String op) {
/*  68 */     this.op = op;
/*     */   }
/*     */ 
/*     */   public String getBegintime()
/*     */   {
/*  80 */     return this.begintime;
/*     */   }
/*     */ 
/*     */   public void setBegintime(String begintime) {
/*  84 */     this.begintime = begintime;
/*     */   }
/*     */ 
/*     */   public String getOvertime() {
/*  88 */     return this.overtime;
/*     */   }
/*     */ 
/*     */   public void setOvertime(String overtime) {
/*  92 */     this.overtime = overtime;
/*     */   }
/*     */ 
/*     */   public String getToyoutime() {
/*  96 */     return this.toyoutime;
/*     */   }
/*     */ 
/*     */   public void setToyoutime(String toyoutime) {
/* 100 */     this.toyoutime = toyoutime;
/*     */   }
/*     */ 
/*     */   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/* 112 */     return null;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getYaoqiu()
/*     */   {
/* 129 */     return this.yaoqiu;
/*     */   }
/*     */ 
/*     */   public void setYaoqiu(String yaoqiu)
/*     */   {
/* 137 */     this.yaoqiu = yaoqiu;
/*     */   }
/*     */ 
/*     */   public String getStucode()
/*     */   {
/* 145 */     return this.stucode;
/*     */   }
/*     */ 
/*     */   public void setStucode(String stucode)
/*     */   {
/* 153 */     this.stucode = stucode;
/*     */   }
/*     */ 
/*     */   public Integer getAtid()
/*     */   {
/* 161 */     return this.atid;
/*     */   }
/*     */ 
/*     */   public void setAtid(Integer atid)
/*     */   {
/* 169 */     this.atid = atid;
/*     */   }
/*     */ 
/*     */   public String getNeirong()
/*     */   {
/* 182 */     return this.neirong;
/*     */   }
/*     */ 
/*     */   public void setNeirong(String neirong)
/*     */   {
/* 190 */     this.neirong = neirong;
/*     */   }
/*     */ 
/*     */   public String getTeccode()
/*     */   {
/* 198 */     return this.teccode;
/*     */   }
/*     */ 
/*     */   public void setTeccode(String teccode)
/*     */   {
/* 206 */     this.teccode = teccode;
/*     */   }
/*     */ 
/*     */   public Integer getCollegeid()
/*     */   {
/* 220 */     return this.collegeid;
/*     */   }
/*     */ 
/*     */   public void setCollegeid(Integer collegeid)
/*     */   {
/* 228 */     this.collegeid = collegeid;
/*     */   }
/*     */ 
/*     */   public Integer getDepartid()
/*     */   {
/* 236 */     return this.departid;
/*     */   }
/*     */ 
/*     */   public void setDepartid(Integer departid)
/*     */   {
/* 244 */     this.departid = departid;
/*     */   }
/*     */ 
/*     */   public Integer getTaskid()
/*     */   {
/* 252 */     return this.taskid;
/*     */   }
/*     */ 
/*     */   public void setTaskid(Integer taskid)
/*     */   {
/* 260 */     this.taskid = taskid;
/*     */   }
/*     */ 
/*     */   public String getZiliao()
/*     */   {
/* 268 */     return this.ziliao;
/*     */   }
/*     */ 
/*     */   public void setZiliao(String ziliao)
/*     */   {
/* 276 */     this.ziliao = ziliao;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.form.task.TaskForm
 * JD-Core Version:    0.5.4
 */