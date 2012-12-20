/*     */ package com.frame.struts.form.pingyue;
/*     */ 
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class PingyuviewergradeForm extends ActionForm
/*     */ {
/*     */   private String zonghe;
/*     */   private String fanyi;
/*     */   private String dongshou;
/*     */   private String wentu;
/*     */   private String wenxian;
/*     */   private String guifan;
/*     */   private String stucode;
/*     */ 
/*     */   public String getStucode()
/*     */   {
/*  49 */     return this.stucode;
/*     */   }
/*     */ 
/*     */   public void setStucode(String stucode) {
/*  53 */     this.stucode = stucode;
/*     */   }
/*     */ 
/*     */   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*  65 */     return null;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getZonghe()
/*     */   {
/*  82 */     return this.zonghe;
/*     */   }
/*     */ 
/*     */   public void setZonghe(String zonghe)
/*     */   {
/*  90 */     this.zonghe = zonghe;
/*     */   }
/*     */ 
/*     */   public String getFanyi()
/*     */   {
/*  98 */     return this.fanyi;
/*     */   }
/*     */ 
/*     */   public void setFanyi(String fanyi)
/*     */   {
/* 106 */     this.fanyi = fanyi;
/*     */   }
/*     */ 
/*     */   public String getDongshou()
/*     */   {
/* 114 */     return this.dongshou;
/*     */   }
/*     */ 
/*     */   public void setDongshou(String dongshou)
/*     */   {
/* 122 */     this.dongshou = dongshou;
/*     */   }
/*     */ 
/*     */   public String getWentu()
/*     */   {
/* 130 */     return this.wentu;
/*     */   }
/*     */ 
/*     */   public void setWentu(String wentu)
/*     */   {
/* 138 */     this.wentu = wentu;
/*     */   }
/*     */ 
/*     */   public String getWenxian()
/*     */   {
/* 146 */     return this.wenxian;
/*     */   }
/*     */ 
/*     */   public void setWenxian(String wenxian)
/*     */   {
/* 154 */     this.wenxian = wenxian;
/*     */   }
/*     */ 
/*     */   public String getGuifan()
/*     */   {
/* 162 */     return this.guifan;
/*     */   }
/*     */ 
/*     */   public void setGuifan(String guifan)
/*     */   {
/* 170 */     this.guifan = guifan;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.form.pingyue.PingyuviewergradeForm
 * JD-Core Version:    0.5.4
 */