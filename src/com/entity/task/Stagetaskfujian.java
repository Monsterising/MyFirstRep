/*    */ package com.entity.task;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class Stagetaskfujian
/*    */   implements Serializable
/*    */ {
/*    */   private Integer fjid;
/*    */   private Integer stid;
/*    */   private String name;
/*    */   private String url;
/*    */   private Date uptime;
/*    */   private String stucode;
/*    */ 
/*    */   public Stagetaskfujian()
/*    */   {
/*    */   }
/*    */ 
/*    */   public Stagetaskfujian(Integer stid, String name, String url, Date uptime, String stucode)
/*    */   {
/* 31 */     this.stid = stid;
/* 32 */     this.name = name;
/* 33 */     this.url = url;
/* 34 */     this.uptime = uptime;
/* 35 */     this.stucode = stucode;
/*    */   }
/*    */ 
/*    */   public Integer getFjid()
/*    */   {
/* 41 */     return this.fjid;
/*    */   }
/*    */ 
/*    */   public void setFjid(Integer fjid) {
/* 45 */     this.fjid = fjid;
/*    */   }
/*    */ 
/*    */   public Integer getStid() {
/* 49 */     return this.stid;
/*    */   }
/*    */ 
/*    */   public void setStid(Integer stid) {
/* 53 */     this.stid = stid;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 57 */     return this.name;
/*    */   }
/*    */ 
/*    */   public void setName(String name) {
/* 61 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String getUrl() {
/* 65 */     return this.url;
/*    */   }
/*    */ 
/*    */   public void setUrl(String url) {
/* 69 */     this.url = url;
/*    */   }
/*    */ 
/*    */   public Date getUptime() {
/* 73 */     return this.uptime;
/*    */   }
/*    */ 
/*    */   public void setUptime(Date uptime) {
/* 77 */     this.uptime = uptime;
/*    */   }
/*    */ 
/*    */   public String getStucode() {
/* 81 */     return this.stucode;
/*    */   }
/*    */ 
/*    */   public void setStucode(String stucode) {
/* 85 */     this.stucode = stucode;
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.task.Stagetaskfujian
 * JD-Core Version:    0.5.4
 */