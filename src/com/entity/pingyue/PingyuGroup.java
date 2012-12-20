/*    */ package com.entity.pingyue;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class PingyuGroup
/*    */   implements Serializable
/*    */ {
/*    */   private Integer pygid;
/*    */   private String stucode;
/*    */   private String teccode;
/*    */   private Integer gradeid;
/*    */   private Integer departid;
/*    */   private Integer classid;
/*    */ 
/*    */   public PingyuGroup()
/*    */   {
/*    */   }
/*    */ 
/*    */   public PingyuGroup(String stucode, String teccode, Integer gradeid, Integer departid, Integer classid)
/*    */   {
/* 29 */     this.stucode = stucode;
/* 30 */     this.teccode = teccode;
/* 31 */     this.gradeid = gradeid;
/* 32 */     this.departid = departid;
/* 33 */     this.classid = classid;
/*    */   }
/*    */ 
/*    */   public Integer getPygid()
/*    */   {
/* 39 */     return this.pygid;
/*    */   }
/*    */ 
/*    */   public void setPygid(Integer pygid) {
/* 43 */     this.pygid = pygid;
/*    */   }
/*    */ 
/*    */   public String getStucode() {
/* 47 */     return this.stucode;
/*    */   }
/*    */ 
/*    */   public void setStucode(String stucode) {
/* 51 */     this.stucode = stucode;
/*    */   }
/*    */ 
/*    */   public String getTeccode() {
/* 55 */     return this.teccode;
/*    */   }
/*    */ 
/*    */   public void setTeccode(String teccode) {
/* 59 */     this.teccode = teccode;
/*    */   }
/*    */ 
/*    */   public Integer getGradeid() {
/* 63 */     return this.gradeid;
/*    */   }
/*    */ 
/*    */   public void setGradeid(Integer gradeid) {
/* 67 */     this.gradeid = gradeid;
/*    */   }
/*    */ 
/*    */   public Integer getDepartid() {
/* 71 */     return this.departid;
/*    */   }
/*    */ 
/*    */   public void setDepartid(Integer departid) {
/* 75 */     this.departid = departid;
/*    */   }
/*    */ 
/*    */   public Integer getClassid() {
/* 79 */     return this.classid;
/*    */   }
/*    */ 
/*    */   public void setClassid(Integer classid) {
/* 83 */     this.classid = classid;
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.pingyue.PingyuGroup
 * JD-Core Version:    0.5.4
 */