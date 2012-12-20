/*     */ package com.frame.struts.baseform;
/*     */ 
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class UseraddForm extends ActionForm
/*     */ {
/*     */   private String op;
/*     */   private Integer userid;
/*     */   private String userpass;
/*     */   private Integer userrole;
/*     */   private String username;
/*     */   private Integer collegeid;
/*     */   private String userrealname;
/*     */ 
/*     */   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*  58 */     return null;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getUserpass()
/*     */   {
/*  75 */     return this.userpass;
/*     */   }
/*     */ 
/*     */   public void setUserpass(String userpass)
/*     */   {
/*  83 */     this.userpass = userpass;
/*     */   }
/*     */ 
/*     */   public Integer getUserrole()
/*     */   {
/*  91 */     return this.userrole;
/*     */   }
/*     */ 
/*     */   public void setUserrole(Integer userrole)
/*     */   {
/*  99 */     this.userrole = userrole;
/*     */   }
/*     */ 
/*     */   public String getUsername()
/*     */   {
/* 107 */     return this.username;
/*     */   }
/*     */ 
/*     */   public void setUsername(String username)
/*     */   {
/* 115 */     this.username = username;
/*     */   }
/*     */ 
/*     */   public Integer getCollegeid()
/*     */   {
/* 123 */     return this.collegeid;
/*     */   }
/*     */ 
/*     */   public void setCollegeid(Integer collegeid)
/*     */   {
/* 131 */     this.collegeid = collegeid;
/*     */   }
/*     */ 
/*     */   public String getUserrealname()
/*     */   {
/* 139 */     return this.userrealname;
/*     */   }
/*     */ 
/*     */   public void setUserrealname(String userrealname)
/*     */   {
/* 147 */     this.userrealname = userrealname;
/*     */   }
/*     */ 
/*     */   public Integer getUserid() {
/* 151 */     return this.userid;
/*     */   }
/*     */ 
/*     */   public void setUserid(Integer userid) {
/* 155 */     this.userid = userid;
/*     */   }
/*     */ 
/*     */   public String getOp() {
/* 159 */     return this.op;
/*     */   }
/*     */ 
/*     */   public void setOp(String op) {
/* 163 */     this.op = op;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.baseform.UseraddForm
 * JD-Core Version:    0.5.4
 */