/*     */ package com.frame.struts.baseform;
/*     */ 
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class StuinfoForm extends ActionForm
/*     */ {
/*     */   private String stucode;
/*     */   private String stunotes;
/*     */   private String stutel2;
/*     */   private String stuqq;
/*     */   private String stuskill;
/*     */   private String stuplan;
/*     */   private String stuhonor;
/*     */   private String stupass;
/*     */   private String stuemail;
/*     */   private String stutel;
/*     */ 
/*     */   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*  67 */     return null;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getStucode()
/*     */   {
/*  84 */     return this.stucode;
/*     */   }
/*     */ 
/*     */   public void setStucode(String stucode)
/*     */   {
/*  92 */     this.stucode = stucode;
/*     */   }
/*     */ 
/*     */   public String getStunotes()
/*     */   {
/* 100 */     return this.stunotes;
/*     */   }
/*     */ 
/*     */   public void setStunotes(String stunotes)
/*     */   {
/* 108 */     this.stunotes = stunotes;
/*     */   }
/*     */ 
/*     */   public String getStutel2()
/*     */   {
/* 116 */     return this.stutel2;
/*     */   }
/*     */ 
/*     */   public void setStutel2(String stutel2)
/*     */   {
/* 124 */     this.stutel2 = stutel2;
/*     */   }
/*     */ 
/*     */   public String getStuqq()
/*     */   {
/* 132 */     return this.stuqq;
/*     */   }
/*     */ 
/*     */   public void setStuqq(String stuqq)
/*     */   {
/* 140 */     this.stuqq = stuqq;
/*     */   }
/*     */ 
/*     */   public String getStuskill()
/*     */   {
/* 148 */     return this.stuskill;
/*     */   }
/*     */ 
/*     */   public void setStuskill(String stuskill)
/*     */   {
/* 156 */     this.stuskill = stuskill;
/*     */   }
/*     */ 
/*     */   public String getStuplan()
/*     */   {
/* 164 */     return this.stuplan;
/*     */   }
/*     */ 
/*     */   public void setStuplan(String stuplan)
/*     */   {
/* 172 */     this.stuplan = stuplan;
/*     */   }
/*     */ 
/*     */   public String getStuhonor()
/*     */   {
/* 180 */     return this.stuhonor;
/*     */   }
/*     */ 
/*     */   public void setStuhonor(String stuhonor)
/*     */   {
/* 188 */     this.stuhonor = stuhonor;
/*     */   }
/*     */ 
/*     */   public String getStupass()
/*     */   {
/* 196 */     return this.stupass;
/*     */   }
/*     */ 
/*     */   public void setStupass(String stupass)
/*     */   {
/* 204 */     this.stupass = stupass;
/*     */   }
/*     */ 
/*     */   public String getStuemail()
/*     */   {
/* 212 */     return this.stuemail;
/*     */   }
/*     */ 
/*     */   public void setStuemail(String stuemail)
/*     */   {
/* 220 */     this.stuemail = stuemail;
/*     */   }
/*     */ 
/*     */   public String getStutel()
/*     */   {
/* 228 */     return this.stutel;
/*     */   }
/*     */ 
/*     */   public void setStutel(String stutel)
/*     */   {
/* 236 */     this.stutel = stutel;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.baseform.StuinfoForm
 * JD-Core Version:    0.5.4
 */