/*     */ package com.entity.task;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ 
/*     */ public class Task
/*     */   implements Serializable
/*     */ {
/*     */   private Integer taskid;
/*     */   private String stucode;
/*     */   private String teccode;
/*     */   private Integer atid;
/*     */   private String ziliao;
/*     */   private String yaoqiu;
/*     */   private String neirong;
/*     */   private String datefagei;
/*     */   private String datestart;
/*     */   private String dateover;
/*     */   private Integer departid;
/*     */   private Integer collegeid;
/*     */ 
/*     */   public Task()
/*     */   {
/*     */   }
/*     */ 
/*     */   public Task(String stucode, String teccode, Integer atid, String ziliao, String yaoqiu, String neirong, String datefagei, String datestart, String dateover, Integer departid, Integer collegeid)
/*     */   {
/*  36 */     this.stucode = stucode;
/*  37 */     this.teccode = teccode;
/*  38 */     this.atid = atid;
/*  39 */     this.ziliao = ziliao;
/*  40 */     this.yaoqiu = yaoqiu;
/*  41 */     this.neirong = neirong;
/*  42 */     this.datefagei = datefagei;
/*  43 */     this.datestart = datestart;
/*  44 */     this.dateover = dateover;
/*  45 */     this.departid = departid;
/*  46 */     this.collegeid = collegeid;
/*     */   }
/*     */ 
/*     */   public Integer getTaskid()
/*     */   {
/*  52 */     return this.taskid;
/*     */   }
/*     */ 
/*     */   public void setTaskid(Integer taskid) {
/*  56 */     this.taskid = taskid;
/*     */   }
/*     */ 
/*     */   public String getStucode() {
/*  60 */     return this.stucode;
/*     */   }
/*     */ 
/*     */   public void setStucode(String stucode) {
/*  64 */     this.stucode = stucode;
/*     */   }
/*     */ 
/*     */   public String getTeccode() {
/*  68 */     return this.teccode;
/*     */   }
/*     */ 
/*     */   public void setTeccode(String teccode) {
/*  72 */     this.teccode = teccode;
/*     */   }
/*     */ 
/*     */   public Integer getAtid() {
/*  76 */     return this.atid;
/*     */   }
/*     */ 
/*     */   public void setAtid(Integer atid) {
/*  80 */     this.atid = atid;
/*     */   }
/*     */ 
/*     */   public String getZiliao() {
/*  84 */     return this.ziliao;
/*     */   }
/*     */ 
/*     */   public void setZiliao(String ziliao) {
/*  88 */     this.ziliao = ziliao;
/*     */   }
/*     */ 
/*     */   public String getYaoqiu() {
/*  92 */     return this.yaoqiu;
/*     */   }
/*     */ 
/*     */   public void setYaoqiu(String yaoqiu) {
/*  96 */     this.yaoqiu = yaoqiu;
/*     */   }
/*     */ 
/*     */   public String getNeirong() {
/* 100 */     return this.neirong;
/*     */   }
/*     */ 
/*     */   public void setNeirong(String neirong) {
/* 104 */     this.neirong = neirong;
/*     */   }
/*     */ 
/*     */   public String getDatefagei() {
/* 108 */     return this.datefagei;
/*     */   }
/*     */ 
/*     */   public void setDatefagei(String datefagei) {
/* 112 */     this.datefagei = datefagei;
/*     */   }
/*     */ 
/*     */   public String getDatestart() {
/* 116 */     return this.datestart;
/*     */   }
/*     */ 
/*     */   public void setDatestart(String datestart) {
/* 120 */     this.datestart = datestart;
/*     */   }
/*     */ 
/*     */   public String getDateover() {
/* 124 */     return this.dateover;
/*     */   }
/*     */ 
/*     */   public void setDateover(String dateover) {
/* 128 */     this.dateover = dateover;
/*     */   }
/*     */ 
/*     */   public Integer getDepartid() {
/* 132 */     return this.departid;
/*     */   }
/*     */ 
/*     */   public void setDepartid(Integer departid) {
/* 136 */     this.departid = departid;
/*     */   }
/*     */ 
/*     */   public Integer getCollegeid() {
/* 140 */     return this.collegeid;
/*     */   }
/*     */ 
/*     */   public void setCollegeid(Integer collegeid) {
/* 144 */     this.collegeid = collegeid;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.task.Task
 * JD-Core Version:    0.5.4
 */