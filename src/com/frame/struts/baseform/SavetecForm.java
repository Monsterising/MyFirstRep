/*     */ package com.frame.struts.baseform;
/*     */ 
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class SavetecForm extends ActionForm
/*     */ {
/*     */   private String tecpass;
/*     */   private String teccode;
/*     */   private String tecedu;
/*     */   private String tecprof;
/*     */   private String tecemail;
/*     */   private String techonor;
/*     */   private String tecnotes;
/*     */   private String tecfield;
/*     */   private String tecqq;
/*     */   private String tectel2;
/*     */   private String tectel;
/*     */ 
/*     */   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*  69 */     return null;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getTeccode()
/*     */   {
/*  86 */     return this.teccode;
/*     */   }
/*     */ 
/*     */   public void setTeccode(String teccode)
/*     */   {
/*  94 */     this.teccode = teccode;
/*     */   }
/*     */ 
/*     */   public String getTecedu()
/*     */   {
/* 102 */     return this.tecedu;
/*     */   }
/*     */ 
/*     */   public void setTecedu(String tecedu)
/*     */   {
/* 110 */     this.tecedu = tecedu;
/*     */   }
/*     */ 
/*     */   public String getTecprof()
/*     */   {
/* 118 */     return this.tecprof;
/*     */   }
/*     */ 
/*     */   public void setTecprof(String tecprof)
/*     */   {
/* 126 */     this.tecprof = tecprof;
/*     */   }
/*     */ 
/*     */   public String getTecemail()
/*     */   {
/* 134 */     return this.tecemail;
/*     */   }
/*     */ 
/*     */   public void setTecemail(String tecemail)
/*     */   {
/* 142 */     this.tecemail = tecemail;
/*     */   }
/*     */ 
/*     */   public String getTechonor()
/*     */   {
/* 150 */     return this.techonor;
/*     */   }
/*     */ 
/*     */   public void setTechonor(String techonor)
/*     */   {
/* 158 */     this.techonor = techonor;
/*     */   }
/*     */ 
/*     */   public String getTecnotes()
/*     */   {
/* 166 */     return this.tecnotes;
/*     */   }
/*     */ 
/*     */   public void setTecnotes(String tecnotes)
/*     */   {
/* 174 */     this.tecnotes = tecnotes;
/*     */   }
/*     */ 
/*     */   public String getTecfield()
/*     */   {
/* 182 */     return this.tecfield;
/*     */   }
/*     */ 
/*     */   public void setTecfield(String tecfield)
/*     */   {
/* 190 */     this.tecfield = tecfield;
/*     */   }
/*     */ 
/*     */   public String getTecqq()
/*     */   {
/* 198 */     return this.tecqq;
/*     */   }
/*     */ 
/*     */   public void setTecqq(String tecqq)
/*     */   {
/* 206 */     this.tecqq = tecqq;
/*     */   }
/*     */ 
/*     */   public String getTectel2()
/*     */   {
/* 214 */     return this.tectel2;
/*     */   }
/*     */ 
/*     */   public void setTectel2(String tectel2)
/*     */   {
/* 222 */     this.tectel2 = tectel2;
/*     */   }
/*     */ 
/*     */   public String getTectel()
/*     */   {
/* 230 */     return this.tectel;
/*     */   }
/*     */ 
/*     */   public void setTectel(String tectel)
/*     */   {
/* 238 */     this.tectel = tectel;
/*     */   }
/*     */ 
/*     */   public String getTecpass() {
/* 242 */     return this.tecpass;
/*     */   }
/*     */ 
/*     */   public void setTecpass(String tecpass) {
/* 246 */     this.tecpass = tecpass;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.baseform.SavetecForm
 * JD-Core Version:    0.5.4
 */