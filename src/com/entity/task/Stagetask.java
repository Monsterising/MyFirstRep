/*     */ package com.entity.task;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class Stagetask
/*     */   implements Serializable
/*     */ {
/*     */   private Integer stid;
/*     */   private Integer atid;
/*     */   private String stucode;
/*     */   private String teccode;
/*     */   private String datestart;
/*     */   private String dateover;
/*     */   private String taskname;
/*     */   private Integer isFinish;
/*     */   private String result;
/*     */   private String notes;
/*     */   private Integer isFujian;
/*     */   private Date fujiantime;
/*     */   private Byte isDayi;
/*     */   private Date dayitime;
/*     */   private String grade;
/*     */   private String datefagei;
/*     */   private Integer gradeid;
/*     */ 
/*     */   public Stagetask()
/*     */   {
/*     */   }
/*     */ 
/*     */   public Stagetask(Integer atid, String stucode, String teccode, String datestart, String dateover, String taskname, Integer isFinish, String result, String notes, Integer isFujian, Date fujiantime, Byte isDayi, Date dayitime, String grade, String datefagei, Integer gradeid)
/*     */   {
/*  45 */     this.atid = atid;
/*  46 */     this.stucode = stucode;
/*  47 */     this.teccode = teccode;
/*  48 */     this.datestart = datestart;
/*  49 */     this.dateover = dateover;
/*  50 */     this.taskname = taskname;
/*  51 */     this.isFinish = isFinish;
/*  52 */     this.result = result;
/*  53 */     this.notes = notes;
/*  54 */     this.isFujian = isFujian;
/*  55 */     this.fujiantime = fujiantime;
/*  56 */     this.isDayi = isDayi;
/*  57 */     this.dayitime = dayitime;
/*  58 */     this.grade = grade;
/*  59 */     this.datefagei = datefagei;
/*  60 */     this.gradeid = gradeid;
/*     */   }
/*     */ 
/*     */   public Integer getStid()
/*     */   {
/*  66 */     return this.stid;
/*     */   }
/*     */ 
/*     */   public void setStid(Integer stid) {
/*  70 */     this.stid = stid;
/*     */   }
/*     */ 
/*     */   public Integer getAtid() {
/*  74 */     return this.atid;
/*     */   }
/*     */ 
/*     */   public void setAtid(Integer atid) {
/*  78 */     this.atid = atid;
/*     */   }
/*     */ 
/*     */   public String getStucode() {
/*  82 */     return this.stucode;
/*     */   }
/*     */ 
/*     */   public void setStucode(String stucode) {
/*  86 */     this.stucode = stucode;
/*     */   }
/*     */ 
/*     */   public String getTeccode() {
/*  90 */     return this.teccode;
/*     */   }
/*     */ 
/*     */   public void setTeccode(String teccode) {
/*  94 */     this.teccode = teccode;
/*     */   }
/*     */ 
/*     */   public String getDatestart() {
/*  98 */     return this.datestart;
/*     */   }
/*     */ 
/*     */   public void setDatestart(String datestart) {
/* 102 */     this.datestart = datestart;
/*     */   }
/*     */ 
/*     */   public String getDateover() {
/* 106 */     return this.dateover;
/*     */   }
/*     */ 
/*     */   public void setDateover(String dateover) {
/* 110 */     this.dateover = dateover;
/*     */   }
/*     */ 
/*     */   public String getTaskname() {
/* 114 */     return this.taskname;
/*     */   }
/*     */ 
/*     */   public void setTaskname(String taskname) {
/* 118 */     this.taskname = taskname;
/*     */   }
/*     */ 
/*     */   public Integer getIsFinish() {
/* 122 */     return this.isFinish;
/*     */   }
/*     */ 
/*     */   public void setIsFinish(Integer isFinish) {
/* 126 */     this.isFinish = isFinish;
/*     */   }
/*     */ 
/*     */   public String getResult() {
/* 130 */     return this.result;
/*     */   }
/*     */ 
/*     */   public void setResult(String result) {
/* 134 */     this.result = result;
/*     */   }
/*     */ 
/*     */   public String getNotes() {
/* 138 */     return this.notes;
/*     */   }
/*     */ 
/*     */   public void setNotes(String notes) {
/* 142 */     this.notes = notes;
/*     */   }
/*     */ 
/*     */   public Integer getIsFujian() {
/* 146 */     return this.isFujian;
/*     */   }
/*     */ 
/*     */   public void setIsFujian(Integer isFujian) {
/* 150 */     this.isFujian = isFujian;
/*     */   }
/*     */ 
/*     */   public Date getFujiantime() {
/* 154 */     return this.fujiantime;
/*     */   }
/*     */ 
/*     */   public void setFujiantime(Date fujiantime) {
/* 158 */     this.fujiantime = fujiantime;
/*     */   }
/*     */ 
/*     */   public Byte getIsDayi() {
/* 162 */     return this.isDayi;
/*     */   }
/*     */ 
/*     */   public void setIsDayi(Byte isDayi) {
/* 166 */     this.isDayi = isDayi;
/*     */   }
/*     */ 
/*     */   public Date getDayitime() {
/* 170 */     return this.dayitime;
/*     */   }
/*     */ 
/*     */   public void setDayitime(Date dayitime) {
/* 174 */     this.dayitime = dayitime;
/*     */   }
/*     */ 
/*     */   public String getGrade() {
/* 178 */     return this.grade;
/*     */   }
/*     */ 
/*     */   public void setGrade(String grade) {
/* 182 */     this.grade = grade;
/*     */   }
/*     */ 
/*     */   public String getDatefagei() {
/* 186 */     return this.datefagei;
/*     */   }
/*     */ 
/*     */   public void setDatefagei(String datefagei) {
/* 190 */     this.datefagei = datefagei;
/*     */   }
/*     */ 
/*     */   public Integer getGradeid() {
/* 194 */     return this.gradeid;
/*     */   }
/*     */ 
/*     */   public void setGradeid(Integer gradeid) {
/* 198 */     this.gradeid = gradeid;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.task.Stagetask
 * JD-Core Version:    0.5.4
 */