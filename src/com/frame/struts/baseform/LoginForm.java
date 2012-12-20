/*     */ package com.frame.struts.baseform;
/*     */ 
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class LoginForm extends ActionForm
/*     */ {
/*     */   private String userpass;
/*     */   private String userrole;
/*     */   private String username;
/*     */ 
/*     */   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*  46 */     return null;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getUserpass()
/*     */   {
/*  63 */     return this.userpass;
/*     */   }
/*     */ 
/*     */   public void setUserpass(String userpass)
/*     */   {
/*  71 */     this.userpass = userpass;
/*     */   }
/*     */ 
/*     */   public String getUserrole()
/*     */   {
/*  79 */     return this.userrole;
/*     */   }
/*     */ 
/*     */   public void setUserrole(String userrole)
/*     */   {
/*  87 */     this.userrole = userrole;
/*     */   }
/*     */ 
/*     */   public String getUsername()
/*     */   {
/*  95 */     return this.username;
/*     */   }
/*     */ 
/*     */   public void setUsername(String username)
/*     */   {
/* 103 */     this.username = username;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.baseform.LoginForm
 * JD-Core Version:    0.5.4
 */