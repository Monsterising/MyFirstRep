/*     */ package com.entity.basedata;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ 
/*     */ public class TecExtra
/*     */   implements Serializable
/*     */ {
/*     */   private String teccode;
/*     */   private String tectel;
/*     */   private String tectel2;
/*     */   private String tecemail;
/*     */   private String tecqq;
/*     */   private String tecprof;
/*     */   private String tecedu;
/*     */   private String tecfield;
/*     */   private String techonor;
/*     */   private String tecnotes;
/*     */ 
/*     */   public TecExtra()
/*     */   {
/*     */   }
/*     */ 
/*     */   public TecExtra(String tectel, String tectel2, String tecemail, String tecqq, String tecprof, String tecedu, String tecfield, String techonor, String tecnotes)
/*     */   {
/*  34 */     this.tectel = tectel;
/*  35 */     this.tectel2 = tectel2;
/*  36 */     this.tecemail = tecemail;
/*  37 */     this.tecqq = tecqq;
/*  38 */     this.tecprof = tecprof;
/*  39 */     this.tecedu = tecedu;
/*  40 */     this.tecfield = tecfield;
/*  41 */     this.techonor = techonor;
/*  42 */     this.tecnotes = tecnotes;
/*     */   }
/*     */ 
/*     */   public String getTeccode()
/*     */   {
/*  48 */     return this.teccode;
/*     */   }
/*     */ 
/*     */   public void setTeccode(String teccode) {
/*  52 */     this.teccode = teccode;
/*     */   }
/*     */ 
/*     */   public String getTectel() {
/*  56 */     return this.tectel;
/*     */   }
/*     */ 
/*     */   public void setTectel(String tectel) {
/*  60 */     this.tectel = tectel;
/*     */   }
/*     */ 
/*     */   public String getTectel2() {
/*  64 */     return this.tectel2;
/*     */   }
/*     */ 
/*     */   public void setTectel2(String tectel2) {
/*  68 */     this.tectel2 = tectel2;
/*     */   }
/*     */ 
/*     */   public String getTecemail() {
/*  72 */     return this.tecemail;
/*     */   }
/*     */ 
/*     */   public void setTecemail(String tecemail) {
/*  76 */     this.tecemail = tecemail;
/*     */   }
/*     */ 
/*     */   public String getTecqq() {
/*  80 */     return this.tecqq;
/*     */   }
/*     */ 
/*     */   public void setTecqq(String tecqq) {
/*  84 */     this.tecqq = tecqq;
/*     */   }
/*     */ 
/*     */   public String getTecprof() {
/*  88 */     return this.tecprof;
/*     */   }
/*     */ 
/*     */   public void setTecprof(String tecprof) {
/*  92 */     this.tecprof = tecprof;
/*     */   }
/*     */ 
/*     */   public String getTecedu() {
/*  96 */     return this.tecedu;
/*     */   }
/*     */ 
/*     */   public void setTecedu(String tecedu) {
/* 100 */     this.tecedu = tecedu;
/*     */   }
/*     */ 
/*     */   public String getTecfield() {
/* 104 */     return this.tecfield;
/*     */   }
/*     */ 
/*     */   public void setTecfield(String tecfield) {
/* 108 */     this.tecfield = tecfield;
/*     */   }
/*     */ 
/*     */   public String getTechonor() {
/* 112 */     return this.techonor;
/*     */   }
/*     */ 
/*     */   public void setTechonor(String techonor) {
/* 116 */     this.techonor = techonor;
/*     */   }
/*     */ 
/*     */   public String getTecnotes() {
/* 120 */     return this.tecnotes;
/*     */   }
/*     */ 
/*     */   public void setTecnotes(String tecnotes) {
/* 124 */     this.tecnotes = tecnotes;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.basedata.TecExtra
 * JD-Core Version:    0.5.4
 */