/*     */ package com.entity.task;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class Stagetaskdayi
/*     */   implements Serializable
/*     */ {
/*     */   private Integer dyid;
/*     */   private String question;
/*     */   private Date qtime;
/*     */   private String answer;
/*     */   private Date atime;
/*     */   private String stucode;
/*     */   private String teccode;
/*     */   private Integer departid;
/*     */   private Integer gradeid;
/*     */   private Integer isok;
/*     */ 
/*     */   public Stagetaskdayi()
/*     */   {
/*     */   }
/*     */ 
/*     */   public Stagetaskdayi(String question, Date qtime, String answer, Date atime, String stucode, String teccode, Integer departid, Integer gradeid, Integer isok)
/*     */   {
/*  36 */     this.question = question;
/*  37 */     this.qtime = qtime;
/*  38 */     this.answer = answer;
/*  39 */     this.atime = atime;
/*  40 */     this.stucode = stucode;
/*  41 */     this.teccode = teccode;
/*  42 */     this.departid = departid;
/*  43 */     this.gradeid = gradeid;
/*  44 */     this.isok = isok;
/*     */   }
/*     */ 
/*     */   public Integer getDyid()
/*     */   {
/*  50 */     return this.dyid;
/*     */   }
/*     */ 
/*     */   public void setDyid(Integer dyid) {
/*  54 */     this.dyid = dyid;
/*     */   }
/*     */ 
/*     */   public String getQuestion() {
/*  58 */     return this.question;
/*     */   }
/*     */ 
/*     */   public void setQuestion(String question) {
/*  62 */     this.question = question;
/*     */   }
/*     */ 
/*     */   public Date getQtime() {
/*  66 */     return this.qtime;
/*     */   }
/*     */ 
/*     */   public void setQtime(Date qtime) {
/*  70 */     this.qtime = qtime;
/*     */   }
/*     */ 
/*     */   public String getAnswer() {
/*  74 */     return this.answer;
/*     */   }
/*     */ 
/*     */   public void setAnswer(String answer) {
/*  78 */     this.answer = answer;
/*     */   }
/*     */ 
/*     */   public Date getAtime() {
/*  82 */     return this.atime;
/*     */   }
/*     */ 
/*     */   public void setAtime(Date atime) {
/*  86 */     this.atime = atime;
/*     */   }
/*     */ 
/*     */   public String getStucode() {
/*  90 */     return this.stucode;
/*     */   }
/*     */ 
/*     */   public void setStucode(String stucode) {
/*  94 */     this.stucode = stucode;
/*     */   }
/*     */ 
/*     */   public String getTeccode() {
/*  98 */     return this.teccode;
/*     */   }
/*     */ 
/*     */   public void setTeccode(String teccode) {
/* 102 */     this.teccode = teccode;
/*     */   }
/*     */ 
/*     */   public Integer getDepartid() {
/* 106 */     return this.departid;
/*     */   }
/*     */ 
/*     */   public void setDepartid(Integer departid) {
/* 110 */     this.departid = departid;
/*     */   }
/*     */ 
/*     */   public Integer getGradeid() {
/* 114 */     return this.gradeid;
/*     */   }
/*     */ 
/*     */   public void setGradeid(Integer gradeid) {
/* 118 */     this.gradeid = gradeid;
/*     */   }
/*     */ 
/*     */   public Integer getIsok() {
/* 122 */     return this.isok;
/*     */   }
/*     */ 
/*     */   public void setIsok(Integer isok) {
/* 126 */     this.isok = isok;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.task.Stagetaskdayi
 * JD-Core Version:    0.5.4
 */