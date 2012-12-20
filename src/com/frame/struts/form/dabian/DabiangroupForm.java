/*     */ package com.frame.struts.form.dabian;
/*     */ 
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class DabiangroupForm extends ActionForm
/*     */ {
/*     */   private String datetime;
/*     */   private String place;
/*     */   private String chairman;
/*     */   private String leader;
/*     */   private Integer gradeid;
/*     */   private Integer dbgid;
/*     */   private Integer collegeid;
/*     */   private Integer departid;
/*     */   private String groupname;
/*     */   private String[] stucodes;
/*     */   private String[] teccodes;
/*     */   private String op;
/*     */ 
/*     */   public String getDatetime()
/*     */   {
/*  61 */     return this.datetime;
/*     */   }
/*     */ 
/*     */   public void setDatetime(String datetime) {
/*  65 */     this.datetime = datetime;
/*     */   }
/*     */ 
/*     */   public String getPlace() {
/*  69 */     return this.place;
/*     */   }
/*     */ 
/*     */   public void setPlace(String place) {
/*  73 */     this.place = place;
/*     */   }
/*     */ 
/*     */   public String[] getStucodes() {
/*  77 */     return this.stucodes;
/*     */   }
/*     */ 
/*     */   public void setStucodes(String[] stucodes) {
/*  81 */     this.stucodes = stucodes;
/*     */   }
/*     */ 
/*     */   public String[] getTeccodes() {
/*  85 */     return this.teccodes;
/*     */   }
/*     */ 
/*     */   public void setTeccodes(String[] teccodes) {
/*  89 */     this.teccodes = teccodes;
/*     */   }
/*     */ 
/*     */   public String getOp() {
/*  93 */     return this.op;
/*     */   }
/*     */ 
/*     */   public void setOp(String op) {
/*  97 */     this.op = op;
/*     */   }
/*     */ 
/*     */   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/* 113 */     return null;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getChairman()
/*     */   {
/* 130 */     return this.chairman;
/*     */   }
/*     */ 
/*     */   public void setChairman(String chairman)
/*     */   {
/* 138 */     this.chairman = chairman;
/*     */   }
/*     */ 
/*     */   public String getLeader()
/*     */   {
/* 146 */     return this.leader;
/*     */   }
/*     */ 
/*     */   public void setLeader(String leader)
/*     */   {
/* 154 */     this.leader = leader;
/*     */   }
/*     */ 
/*     */   public Integer getGradeid()
/*     */   {
/* 162 */     return this.gradeid;
/*     */   }
/*     */ 
/*     */   public void setGradeid(Integer gradeid)
/*     */   {
/* 170 */     this.gradeid = gradeid;
/*     */   }
/*     */ 
/*     */   public Integer getDbgid()
/*     */   {
/* 178 */     return this.dbgid;
/*     */   }
/*     */ 
/*     */   public void setDbgid(Integer dbgid)
/*     */   {
/* 186 */     this.dbgid = dbgid;
/*     */   }
/*     */ 
/*     */   public Integer getCollegeid()
/*     */   {
/* 194 */     return this.collegeid;
/*     */   }
/*     */ 
/*     */   public void setCollegeid(Integer collegeid)
/*     */   {
/* 202 */     this.collegeid = collegeid;
/*     */   }
/*     */ 
/*     */   public Integer getDepartid()
/*     */   {
/* 210 */     return this.departid;
/*     */   }
/*     */ 
/*     */   public void setDepartid(Integer departid)
/*     */   {
/* 218 */     this.departid = departid;
/*     */   }
/*     */ 
/*     */   public String getGroupname()
/*     */   {
/* 226 */     return this.groupname;
/*     */   }
/*     */ 
/*     */   public void setGroupname(String groupname)
/*     */   {
/* 234 */     this.groupname = groupname;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.form.dabian.DabiangroupForm
 * JD-Core Version:    0.5.4
 */