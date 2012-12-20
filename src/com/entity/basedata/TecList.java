/*    */ package com.entity.basedata;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class TecList
/*    */   implements Serializable
/*    */ {
/*    */   private String teccode;
/*    */   private String tecname;
/*    */   private String tecsex;
/*    */   private String tecpass;
/*    */   private Integer collegeid;
/*    */   private Integer tecrole;
/*    */ 
/*    */   public TecList()
/*    */   {
/*    */   }
/*    */ 
/*    */   public TecList(String teccode)
/*    */   {
/* 28 */     this.teccode = teccode;
/*    */   }
/*    */ 
/*    */   public TecList(String teccode, String tecname, String tecsex, String tecpass, Integer collegeid, Integer tecrole)
/*    */   {
/* 34 */     this.teccode = teccode;
/* 35 */     this.tecname = tecname;
/* 36 */     this.tecsex = tecsex;
/* 37 */     this.tecpass = tecpass;
/* 38 */     this.collegeid = collegeid;
/* 39 */     this.tecrole = tecrole;
/*    */   }
/*    */ 
/*    */   public String getTeccode()
/*    */   {
/* 45 */     return this.teccode;
/*    */   }
/*    */ 
/*    */   public void setTeccode(String teccode) {
/* 49 */     this.teccode = teccode;
/*    */   }
/*    */ 
/*    */   public String getTecname() {
/* 53 */     return this.tecname;
/*    */   }
/*    */ 
/*    */   public void setTecname(String tecname) {
/* 57 */     this.tecname = tecname;
/*    */   }
/*    */ 
/*    */   public String getTecsex() {
/* 61 */     return this.tecsex;
/*    */   }
/*    */ 
/*    */   public void setTecsex(String tecsex) {
/* 65 */     this.tecsex = tecsex;
/*    */   }
/*    */ 
/*    */   public String getTecpass() {
/* 69 */     return this.tecpass;
/*    */   }
/*    */ 
/*    */   public void setTecpass(String tecpass) {
/* 73 */     this.tecpass = tecpass;
/*    */   }
/*    */ 
/*    */   public Integer getCollegeid() {
/* 77 */     return this.collegeid;
/*    */   }
/*    */ 
/*    */   public void setCollegeid(Integer collegeid) {
/* 81 */     this.collegeid = collegeid;
/*    */   }
/*    */ 
/*    */   public Integer getTecrole() {
/* 85 */     return this.tecrole;
/*    */   }
/*    */ 
/*    */   public void setTecrole(Integer tecrole) {
/* 89 */     this.tecrole = tecrole;
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.basedata.TecList
 * JD-Core Version:    0.5.4
 */