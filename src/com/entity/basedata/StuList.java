/*     */ package com.entity.basedata;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ 
/*     */ public class StuList
/*     */   implements Serializable
/*     */ {
/*     */   private String stucode;
/*     */   private String stuname;
/*     */   private String stupass;
/*     */   private Integer collegeid;
/*     */   private Integer departid;
/*     */   private Integer gradeid;
/*     */   private Integer classid;
/*     */   private String stusex;
/*     */ 
/*     */   public StuList()
/*     */   {
/*     */   }
/*     */ 
/*     */   public StuList(String stucode)
/*     */   {
/*  30 */     this.stucode = stucode;
/*     */   }
/*     */ 
/*     */   public StuList(String stucode, String stuname, String stupass, Integer collegeid, Integer departid, Integer gradeid, Integer classid, String stusex)
/*     */   {
/*  37 */     this.stucode = stucode;
/*  38 */     this.stuname = stuname;
/*  39 */     this.stupass = stupass;
/*  40 */     this.collegeid = collegeid;
/*  41 */     this.departid = departid;
/*  42 */     this.gradeid = gradeid;
/*  43 */     this.classid = classid;
/*  44 */     this.stusex = stusex;
/*     */   }
/*     */ 
/*     */   public String getStucode()
/*     */   {
/*  50 */     return this.stucode;
/*     */   }
/*     */ 
/*     */   public void setStucode(String stucode) {
/*  54 */     this.stucode = stucode;
/*     */   }
/*     */ 
/*     */   public String getStuname() {
/*  58 */     return this.stuname;
/*     */   }
/*     */ 
/*     */   public void setStuname(String stuname) {
/*  62 */     this.stuname = stuname;
/*     */   }
/*     */ 
/*     */   public String getStupass() {
/*  66 */     return this.stupass;
/*     */   }
/*     */ 
/*     */   public void setStupass(String stupass) {
/*  70 */     this.stupass = stupass;
/*     */   }
/*     */ 
/*     */   public Integer getCollegeid() {
/*  74 */     return this.collegeid;
/*     */   }
/*     */ 
/*     */   public void setCollegeid(Integer collegeid) {
/*  78 */     this.collegeid = collegeid;
/*     */   }
/*     */ 
/*     */   public Integer getDepartid() {
/*  82 */     return this.departid;
/*     */   }
/*     */ 
/*     */   public void setDepartid(Integer departid) {
/*  86 */     this.departid = departid;
/*     */   }
/*     */ 
/*     */   public Integer getGradeid() {
/*  90 */     return this.gradeid;
/*     */   }
/*     */ 
/*     */   public void setGradeid(Integer gradeid) {
/*  94 */     this.gradeid = gradeid;
/*     */   }
/*     */ 
/*     */   public Integer getClassid() {
/*  98 */     return this.classid;
/*     */   }
/*     */ 
/*     */   public void setClassid(Integer classid) {
/* 102 */     this.classid = classid;
/*     */   }
/*     */ 
/*     */   public String getStusex() {
/* 106 */     return this.stusex;
/*     */   }
/*     */ 
/*     */   public void setStusex(String stusex) {
/* 110 */     this.stusex = stusex;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.basedata.StuList
 * JD-Core Version:    0.5.4
 */