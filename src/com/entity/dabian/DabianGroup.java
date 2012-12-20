/*     */ package com.entity.dabian;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ 
/*     */ public class DabianGroup
/*     */   implements Serializable
/*     */ {
/*     */   private Integer dbgid;
/*     */   private Integer collegeid;
/*     */   private Integer departid;
/*     */   private Integer gradeid;
/*     */   private String groupname;
/*     */   private String chairman;
/*     */   private String leader;
/*     */   private String datetime;
/*     */   private String place;
/*     */ 
/*     */   public DabianGroup()
/*     */   {
/*     */   }
/*     */ 
/*     */   public DabianGroup(Integer collegeid, Integer departid, Integer gradeid, String groupname, String chairman, String leader, String datetime, String place)
/*     */   {
/*  33 */     this.collegeid = collegeid;
/*  34 */     this.departid = departid;
/*  35 */     this.gradeid = gradeid;
/*  36 */     this.groupname = groupname;
/*  37 */     this.chairman = chairman;
/*  38 */     this.leader = leader;
/*  39 */     this.datetime = datetime;
/*  40 */     this.place = place;
/*     */   }
/*     */ 
/*     */   public Integer getDbgid()
/*     */   {
/*  46 */     return this.dbgid;
/*     */   }
/*     */ 
/*     */   public void setDbgid(Integer dbgid) {
/*  50 */     this.dbgid = dbgid;
/*     */   }
/*     */ 
/*     */   public Integer getCollegeid() {
/*  54 */     return this.collegeid;
/*     */   }
/*     */ 
/*     */   public void setCollegeid(Integer collegeid) {
/*  58 */     this.collegeid = collegeid;
/*     */   }
/*     */ 
/*     */   public Integer getDepartid() {
/*  62 */     return this.departid;
/*     */   }
/*     */ 
/*     */   public void setDepartid(Integer departid) {
/*  66 */     this.departid = departid;
/*     */   }
/*     */ 
/*     */   public Integer getGradeid() {
/*  70 */     return this.gradeid;
/*     */   }
/*     */ 
/*     */   public void setGradeid(Integer gradeid) {
/*  74 */     this.gradeid = gradeid;
/*     */   }
/*     */ 
/*     */   public String getGroupname() {
/*  78 */     return this.groupname;
/*     */   }
/*     */ 
/*     */   public void setGroupname(String groupname) {
/*  82 */     this.groupname = groupname;
/*     */   }
/*     */ 
/*     */   public String getChairman() {
/*  86 */     return this.chairman;
/*     */   }
/*     */ 
/*     */   public void setChairman(String chairman) {
/*  90 */     this.chairman = chairman;
/*     */   }
/*     */ 
/*     */   public String getLeader() {
/*  94 */     return this.leader;
/*     */   }
/*     */ 
/*     */   public void setLeader(String leader) {
/*  98 */     this.leader = leader;
/*     */   }
/*     */ 
/*     */   public String getDatetime() {
/* 102 */     return this.datetime;
/*     */   }
/*     */ 
/*     */   public void setDatetime(String datetime) {
/* 106 */     this.datetime = datetime;
/*     */   }
/*     */ 
/*     */   public String getPlace() {
/* 110 */     return this.place;
/*     */   }
/*     */ 
/*     */   public void setPlace(String place) {
/* 114 */     this.place = place;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.dabian.DabianGroup
 * JD-Core Version:    0.5.4
 */