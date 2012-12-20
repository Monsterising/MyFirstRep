/*     */ package com.entity.basedata;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ 
/*     */ public class StuExtra
/*     */   implements Serializable
/*     */ {
/*     */   private String stucode;
/*     */   private String stutel;
/*     */   private String stutel2;
/*     */   private String stuemail;
/*     */   private String stuqq;
/*     */   private String stuskill;
/*     */   private String stuhonor;
/*     */   private String stuplan;
/*     */   private String stunotes;
/*     */ 
/*     */   public StuExtra()
/*     */   {
/*     */   }
/*     */ 
/*     */   public StuExtra(String stutel, String stutel2, String stuemail, String stuqq, String stuskill, String stuhonor, String stuplan, String stunotes)
/*     */   {
/*  33 */     this.stutel = stutel;
/*  34 */     this.stutel2 = stutel2;
/*  35 */     this.stuemail = stuemail;
/*  36 */     this.stuqq = stuqq;
/*  37 */     this.stuskill = stuskill;
/*  38 */     this.stuhonor = stuhonor;
/*  39 */     this.stuplan = stuplan;
/*  40 */     this.stunotes = stunotes;
/*     */   }
/*     */ 
/*     */   public String getStucode()
/*     */   {
/*  46 */     return this.stucode;
/*     */   }
/*     */ 
/*     */   public void setStucode(String stucode) {
/*  50 */     this.stucode = stucode;
/*     */   }
/*     */ 
/*     */   public String getStutel() {
/*  54 */     return this.stutel;
/*     */   }
/*     */ 
/*     */   public void setStutel(String stutel) {
/*  58 */     this.stutel = stutel;
/*     */   }
/*     */ 
/*     */   public String getStutel2() {
/*  62 */     return this.stutel2;
/*     */   }
/*     */ 
/*     */   public void setStutel2(String stutel2) {
/*  66 */     this.stutel2 = stutel2;
/*     */   }
/*     */ 
/*     */   public String getStuemail() {
/*  70 */     return this.stuemail;
/*     */   }
/*     */ 
/*     */   public void setStuemail(String stuemail) {
/*  74 */     this.stuemail = stuemail;
/*     */   }
/*     */ 
/*     */   public String getStuqq() {
/*  78 */     return this.stuqq;
/*     */   }
/*     */ 
/*     */   public void setStuqq(String stuqq) {
/*  82 */     this.stuqq = stuqq;
/*     */   }
/*     */ 
/*     */   public String getStuskill() {
/*  86 */     return this.stuskill;
/*     */   }
/*     */ 
/*     */   public void setStuskill(String stuskill) {
/*  90 */     this.stuskill = stuskill;
/*     */   }
/*     */ 
/*     */   public String getStuhonor() {
/*  94 */     return this.stuhonor;
/*     */   }
/*     */ 
/*     */   public void setStuhonor(String stuhonor) {
/*  98 */     this.stuhonor = stuhonor;
/*     */   }
/*     */ 
/*     */   public String getStuplan() {
/* 102 */     return this.stuplan;
/*     */   }
/*     */ 
/*     */   public void setStuplan(String stuplan) {
/* 106 */     this.stuplan = stuplan;
/*     */   }
/*     */ 
/*     */   public String getStunotes() {
/* 110 */     return this.stunotes;
/*     */   }
/*     */ 
/*     */   public void setStunotes(String stunotes) {
/* 114 */     this.stunotes = stunotes;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.basedata.StuExtra
 * JD-Core Version:    0.5.4
 */