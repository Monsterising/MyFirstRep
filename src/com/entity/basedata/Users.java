/*    */ package com.entity.basedata;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class Users
/*    */   implements Serializable
/*    */ {
/*    */   private Integer userid;
/*    */   private String username;
/*    */   private String userpass;
/*    */   private String userrealname;
/*    */   private Integer userrole;
/*    */ 
/*    */   public Users()
/*    */   {
/*    */   }
/*    */ 
/*    */   public Users(String username, String userpass, String userrealname, Integer userrole)
/*    */   {
/* 28 */     this.username = username;
/* 29 */     this.userpass = userpass;
/* 30 */     this.userrealname = userrealname;
/* 31 */     this.userrole = userrole;
/*    */   }
/*    */ 
/*    */   public Integer getUserid()
/*    */   {
/* 37 */     return this.userid;
/*    */   }
/*    */ 
/*    */   public void setUserid(Integer userid) {
/* 41 */     this.userid = userid;
/*    */   }
/*    */ 
/*    */   public String getUsername() {
/* 45 */     return this.username;
/*    */   }
/*    */ 
/*    */   public void setUsername(String username) {
/* 49 */     this.username = username;
/*    */   }
/*    */ 
/*    */   public String getUserpass() {
/* 53 */     return this.userpass;
/*    */   }
/*    */ 
/*    */   public void setUserpass(String userpass) {
/* 57 */     this.userpass = userpass;
/*    */   }
/*    */ 
/*    */   public String getUserrealname() {
/* 61 */     return this.userrealname;
/*    */   }
/*    */ 
/*    */   public void setUserrealname(String userrealname) {
/* 65 */     this.userrealname = userrealname;
/*    */   }
/*    */ 
/*    */   public Integer getUserrole() {
/* 69 */     return this.userrole;
/*    */   }
/*    */ 
/*    */   public void setUserrole(Integer userrole) {
/* 73 */     this.userrole = userrole;
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.basedata.Users
 * JD-Core Version:    0.5.4
 */