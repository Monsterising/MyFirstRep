/*    */ package com.entity.wish;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class ApplyState
/*    */   implements Serializable
/*    */ {
/*    */   private Integer atid;
/*    */   private String advice1;
/*    */   private String advice2;
/*    */   private String xuanti;
/*    */   private Integer xuantinum;
/*    */   private String task;
/*    */ 
/*    */   public ApplyState()
/*    */   {
/*    */   }
/*    */ 
/*    */   public ApplyState(Integer atid)
/*    */   {
/* 28 */     this.atid = atid;
/*    */   }
/*    */ 
/*    */   public ApplyState(Integer atid, String advice1, String advice2, String xuanti, Integer xuantinum, String task)
/*    */   {
/* 34 */     this.atid = atid;
/* 35 */     this.advice1 = advice1;
/* 36 */     this.advice2 = advice2;
/* 37 */     this.xuanti = xuanti;
/* 38 */     this.xuantinum = xuantinum;
/* 39 */     this.task = task;
/*    */   }
/*    */ 
/*    */   public Integer getAtid()
/*    */   {
/* 45 */     return this.atid;
/*    */   }
/*    */ 
/*    */   public void setAtid(Integer atid) {
/* 49 */     this.atid = atid;
/*    */   }
/*    */ 
/*    */   public String getAdvice1() {
/* 53 */     return this.advice1;
/*    */   }
/*    */ 
/*    */   public void setAdvice1(String advice1) {
/* 57 */     this.advice1 = advice1;
/*    */   }
/*    */ 
/*    */   public String getAdvice2() {
/* 61 */     return this.advice2;
/*    */   }
/*    */ 
/*    */   public void setAdvice2(String advice2) {
/* 65 */     this.advice2 = advice2;
/*    */   }
/*    */ 
/*    */   public String getXuanti() {
/* 69 */     return this.xuanti;
/*    */   }
/*    */ 
/*    */   public void setXuanti(String xuanti) {
/* 73 */     this.xuanti = xuanti;
/*    */   }
/*    */ 
/*    */   public Integer getXuantinum() {
/* 77 */     return this.xuantinum;
/*    */   }
/*    */ 
/*    */   public void setXuantinum(Integer xuantinum) {
/* 81 */     this.xuantinum = xuantinum;
/*    */   }
/*    */ 
/*    */   public String getTask() {
/* 85 */     return this.task;
/*    */   }
/*    */ 
/*    */   public void setTask(String task) {
/* 89 */     this.task = task;
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.wish.ApplyState
 * JD-Core Version:    0.5.4
 */