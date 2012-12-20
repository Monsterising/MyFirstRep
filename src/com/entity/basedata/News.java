/*    */ package com.entity.basedata;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class News
/*    */   implements Serializable
/*    */ {
/*    */   private Integer newsid;
/*    */   private String title;
/*    */   private String content;
/*    */   private Integer departid;
/*    */   private Date uptime;
/*    */   private Integer click;
/*    */   private String adduser;
/*    */ 
/*    */   public News()
/*    */   {
/*    */   }
/*    */ 
/*    */   public News(String title, String content, Integer departid, Date uptime, Integer click, String adduser)
/*    */   {
/* 32 */     this.title = title;
/* 33 */     this.content = content;
/* 34 */     this.departid = departid;
/* 35 */     this.uptime = uptime;
/* 36 */     this.click = click;
/* 37 */     this.adduser = adduser;
/*    */   }
/*    */ 
/*    */   public Integer getNewsid()
/*    */   {
/* 43 */     return this.newsid;
/*    */   }
/*    */ 
/*    */   public void setNewsid(Integer newsid) {
/* 47 */     this.newsid = newsid;
/*    */   }
/*    */ 
/*    */   public String getTitle() {
/* 51 */     return this.title;
/*    */   }
/*    */ 
/*    */   public void setTitle(String title) {
/* 55 */     this.title = title;
/*    */   }
/*    */ 
/*    */   public String getContent() {
/* 59 */     return this.content;
/*    */   }
/*    */ 
/*    */   public void setContent(String content) {
/* 63 */     this.content = content;
/*    */   }
/*    */ 
/*    */   public Integer getDepartid() {
/* 67 */     return this.departid;
/*    */   }
/*    */ 
/*    */   public void setDepartid(Integer departid) {
/* 71 */     this.departid = departid;
/*    */   }
/*    */ 
/*    */   public Date getUptime() {
/* 75 */     return this.uptime;
/*    */   }
/*    */ 
/*    */   public void setUptime(Date uptime) {
/* 79 */     this.uptime = uptime;
/*    */   }
/*    */ 
/*    */   public Integer getClick() {
/* 83 */     return this.click;
/*    */   }
/*    */ 
/*    */   public void setClick(Integer click) {
/* 87 */     this.click = click;
/*    */   }
/*    */ 
/*    */   public String getAdduser() {
/* 91 */     return this.adduser;
/*    */   }
/*    */ 
/*    */   public void setAdduser(String adduser) {
/* 95 */     this.adduser = adduser;
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.basedata.News
 * JD-Core Version:    0.5.4
 */