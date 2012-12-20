/*     */ package com.entity.wish;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class StuWish
/*     */   implements Serializable
/*     */ {
/*     */   private Integer wishid;
/*     */   private String stucode;
/*     */   private Integer atid;
/*     */   private String teccode;
/*     */   private Integer priority;
/*     */   private Date dateup;
/*     */   private Date dateaccess;
/*     */   private String wishstate;
/*     */ 
/*     */   public StuWish()
/*     */   {
/*     */   }
/*     */ 
/*     */   public StuWish(String stucode, Integer atid, String teccode, Integer priority, Date dateup, Date dateaccess, String wishstate)
/*     */   {
/*  33 */     this.stucode = stucode;
/*  34 */     this.atid = atid;
/*  35 */     this.teccode = teccode;
/*  36 */     this.priority = priority;
/*  37 */     this.dateup = dateup;
/*  38 */     this.dateaccess = dateaccess;
/*  39 */     this.wishstate = wishstate;
/*     */   }
/*     */ 
/*     */   public Integer getWishid()
/*     */   {
/*  45 */     return this.wishid;
/*     */   }
/*     */ 
/*     */   public void setWishid(Integer wishid) {
/*  49 */     this.wishid = wishid;
/*     */   }
/*     */ 
/*     */   public String getStucode() {
/*  53 */     return this.stucode;
/*     */   }
/*     */ 
/*     */   public void setStucode(String stucode) {
/*  57 */     this.stucode = stucode;
/*     */   }
/*     */ 
/*     */   public Integer getAtid() {
/*  61 */     return this.atid;
/*     */   }
/*     */ 
/*     */   public void setAtid(Integer atid) {
/*  65 */     this.atid = atid;
/*     */   }
/*     */ 
/*     */   public String getTeccode() {
/*  69 */     return this.teccode;
/*     */   }
/*     */ 
/*     */   public void setTeccode(String teccode) {
/*  73 */     this.teccode = teccode;
/*     */   }
/*     */ 
/*     */   public Integer getPriority() {
/*  77 */     return this.priority;
/*     */   }
/*     */ 
/*     */   public void setPriority(Integer priority) {
/*  81 */     this.priority = priority;
/*     */   }
/*     */ 
/*     */   public Date getDateup() {
/*  85 */     return this.dateup;
/*     */   }
/*     */ 
/*     */   public void setDateup(Date dateup) {
/*  89 */     this.dateup = dateup;
/*     */   }
/*     */ 
/*     */   public Date getDateaccess() {
/*  93 */     return this.dateaccess;
/*     */   }
/*     */ 
/*     */   public void setDateaccess(Date dateaccess) {
/*  97 */     this.dateaccess = dateaccess;
/*     */   }
/*     */ 
/*     */   public String getWishstate() {
/* 101 */     return this.wishstate;
/*     */   }
/*     */ 
/*     */   public void setWishstate(String wishstate) {
/* 105 */     this.wishstate = wishstate;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.wish.StuWish
 * JD-Core Version:    0.5.4
 */