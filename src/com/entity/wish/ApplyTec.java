/*     */ package com.entity.wish;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class ApplyTec
/*     */   implements Serializable
/*     */ {
/*     */   private Integer atid;
/*     */   private String title;
/*     */   private String teccode;
/*     */   private Integer collegeid;
/*     */   private Integer departid;
/*     */   private Integer gradeid;
/*     */   private Integer classid;
/*     */   private String tecprof;
/*     */   private Integer stusum;
/*     */   private String content;
/*     */   private String preparework;
/*     */   private Integer applytype;
/*     */   private String applytypename;
/*     */   private String source;
/*     */   private String kind;
/*     */   private String practise;
/*     */   private String computer;
/*     */   private String advice1;
/*     */   private Date date1;
/*     */   private String sign1;
/*     */   private String advice2;
/*     */   private Date date2;
/*     */   private String sign2;
/*     */   private Date applydate;
/*     */ 
/*     */   public ApplyTec()
/*     */   {
/*     */   }
/*     */ 
/*     */   public ApplyTec(String title, String teccode, Integer collegeid, Integer departid, Integer gradeid, Integer classid, String tecprof, Integer stusum, String content, String preparework, Integer applytype, String applytypename, String source, String kind, String practise, String computer, String advice1, Date date1, String sign1, String advice2, Date date2, String sign2, Date applydate)
/*     */   {
/*  54 */     this.title = title;
/*  55 */     this.teccode = teccode;
/*  56 */     this.collegeid = collegeid;
/*  57 */     this.departid = departid;
/*  58 */     this.gradeid = gradeid;
/*  59 */     this.classid = classid;
/*  60 */     this.tecprof = tecprof;
/*  61 */     this.stusum = stusum;
/*  62 */     this.content = content;
/*  63 */     this.preparework = preparework;
/*  64 */     this.applytype = applytype;
/*  65 */     this.applytypename = applytypename;
/*  66 */     this.source = source;
/*  67 */     this.kind = kind;
/*  68 */     this.practise = practise;
/*  69 */     this.computer = computer;
/*  70 */     this.advice1 = advice1;
/*  71 */     this.date1 = date1;
/*  72 */     this.sign1 = sign1;
/*  73 */     this.advice2 = advice2;
/*  74 */     this.date2 = date2;
/*  75 */     this.sign2 = sign2;
/*  76 */     this.applydate = applydate;
/*     */   }
/*     */ 
/*     */   public Integer getAtid()
/*     */   {
/*  82 */     return this.atid;
/*     */   }
/*     */ 
/*     */   public void setAtid(Integer atid) {
/*  86 */     this.atid = atid;
/*     */   }
/*     */ 
/*     */   public String getTitle() {
/*  90 */     return this.title;
/*     */   }
/*     */ 
/*     */   public void setTitle(String title) {
/*  94 */     this.title = title;
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
/*     */   public Integer getCollegeid() {
/* 106 */     return this.collegeid;
/*     */   }
/*     */ 
/*     */   public void setCollegeid(Integer collegeid) {
/* 110 */     this.collegeid = collegeid;
/*     */   }
/*     */ 
/*     */   public Integer getDepartid() {
/* 114 */     return this.departid;
/*     */   }
/*     */ 
/*     */   public void setDepartid(Integer departid) {
/* 118 */     this.departid = departid;
/*     */   }
/*     */ 
/*     */   public Integer getGradeid() {
/* 122 */     return this.gradeid;
/*     */   }
/*     */ 
/*     */   public void setGradeid(Integer gradeid) {
/* 126 */     this.gradeid = gradeid;
/*     */   }
/*     */ 
/*     */   public Integer getClassid() {
/* 130 */     return this.classid;
/*     */   }
/*     */ 
/*     */   public void setClassid(Integer classid) {
/* 134 */     this.classid = classid;
/*     */   }
/*     */ 
/*     */   public String getTecprof() {
/* 138 */     return this.tecprof;
/*     */   }
/*     */ 
/*     */   public void setTecprof(String tecprof) {
/* 142 */     this.tecprof = tecprof;
/*     */   }
/*     */ 
/*     */   public Integer getStusum() {
/* 146 */     return this.stusum;
/*     */   }
/*     */ 
/*     */   public void setStusum(Integer stusum) {
/* 150 */     this.stusum = stusum;
/*     */   }
/*     */ 
/*     */   public String getContent() {
/* 154 */     return this.content;
/*     */   }
/*     */ 
/*     */   public void setContent(String content) {
/* 158 */     this.content = content;
/*     */   }
/*     */ 
/*     */   public String getPreparework() {
/* 162 */     return this.preparework;
/*     */   }
/*     */ 
/*     */   public void setPreparework(String preparework) {
/* 166 */     this.preparework = preparework;
/*     */   }
/*     */ 
/*     */   public Integer getApplytype() {
/* 170 */     return this.applytype;
/*     */   }
/*     */ 
/*     */   public void setApplytype(Integer applytype) {
/* 174 */     this.applytype = applytype;
/*     */   }
/*     */ 
/*     */   public String getApplytypename() {
/* 178 */     return this.applytypename;
/*     */   }
/*     */ 
/*     */   public void setApplytypename(String applytypename) {
/* 182 */     this.applytypename = applytypename;
/*     */   }
/*     */ 
/*     */   public String getSource() {
/* 186 */     return this.source;
/*     */   }
/*     */ 
/*     */   public void setSource(String source) {
/* 190 */     this.source = source;
/*     */   }
/*     */ 
/*     */   public String getKind() {
/* 194 */     return this.kind;
/*     */   }
/*     */ 
/*     */   public void setKind(String kind) {
/* 198 */     this.kind = kind;
/*     */   }
/*     */ 
/*     */   public String getPractise() {
/* 202 */     return this.practise;
/*     */   }
/*     */ 
/*     */   public void setPractise(String practise) {
/* 206 */     this.practise = practise;
/*     */   }
/*     */ 
/*     */   public String getComputer() {
/* 210 */     return this.computer;
/*     */   }
/*     */ 
/*     */   public void setComputer(String computer) {
/* 214 */     this.computer = computer;
/*     */   }
/*     */ 
/*     */   public String getAdvice1() {
/* 218 */     return this.advice1;
/*     */   }
/*     */ 
/*     */   public void setAdvice1(String advice1) {
/* 222 */     this.advice1 = advice1;
/*     */   }
/*     */ 
/*     */   public Date getDate1() {
/* 226 */     return this.date1;
/*     */   }
/*     */ 
/*     */   public void setDate1(Date date1) {
/* 230 */     this.date1 = date1;
/*     */   }
/*     */ 
/*     */   public String getSign1() {
/* 234 */     return this.sign1;
/*     */   }
/*     */ 
/*     */   public void setSign1(String sign1) {
/* 238 */     this.sign1 = sign1;
/*     */   }
/*     */ 
/*     */   public String getAdvice2() {
/* 242 */     return this.advice2;
/*     */   }
/*     */ 
/*     */   public void setAdvice2(String advice2) {
/* 246 */     this.advice2 = advice2;
/*     */   }
/*     */ 
/*     */   public Date getDate2() {
/* 250 */     return this.date2;
/*     */   }
/*     */ 
/*     */   public void setDate2(Date date2) {
/* 254 */     this.date2 = date2;
/*     */   }
/*     */ 
/*     */   public String getSign2() {
/* 258 */     return this.sign2;
/*     */   }
/*     */ 
/*     */   public void setSign2(String sign2) {
/* 262 */     this.sign2 = sign2;
/*     */   }
/*     */ 
/*     */   public Date getApplydate() {
/* 266 */     return this.applydate;
/*     */   }
/*     */ 
/*     */   public void setApplydate(Date applydate) {
/* 270 */     this.applydate = applydate;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.wish.ApplyTec
 * JD-Core Version:    0.5.4
 */