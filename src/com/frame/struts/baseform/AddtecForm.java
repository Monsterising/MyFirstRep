/*     */ package com.frame.struts.baseform;
/*     */ 
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class AddtecForm extends ActionForm
/*     */ {
/*     */   private Integer[] departid;
/*     */   private Integer[] departids;
/*     */   private String op;
/*     */   private String tecsex;
/*     */   private Integer tecrole;
/*     */   private String teccode;
/*     */   private String tecpass;
/*     */   private Integer collegeid;
/*     */   private String tecname;
/*     */ 
/*     */   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*  61 */     return null;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getTecsex()
/*     */   {
/*  78 */     return this.tecsex;
/*     */   }
/*     */ 
/*     */   public void setTecsex(String tecsex)
/*     */   {
/*  86 */     this.tecsex = tecsex;
/*     */   }
/*     */ 
/*     */   public Integer getTecrole()
/*     */   {
/*  94 */     return this.tecrole;
/*     */   }
/*     */ 
/*     */   public void setTecrole(Integer tecrole)
/*     */   {
/* 102 */     this.tecrole = tecrole;
/*     */   }
/*     */ 
/*     */   public String getTeccode()
/*     */   {
/* 110 */     return this.teccode;
/*     */   }
/*     */ 
/*     */   public void setTeccode(String teccode)
/*     */   {
/* 118 */     this.teccode = teccode;
/*     */   }
/*     */ 
/*     */   public String getTecpass()
/*     */   {
/* 126 */     return this.tecpass;
/*     */   }
/*     */ 
/*     */   public void setTecpass(String tecpass)
/*     */   {
/* 134 */     this.tecpass = tecpass;
/*     */   }
/*     */ 
/*     */   public Integer getCollegeid()
/*     */   {
/* 142 */     return this.collegeid;
/*     */   }
/*     */ 
/*     */   public void setCollegeid(Integer collegeid)
/*     */   {
/* 150 */     this.collegeid = collegeid;
/*     */   }
/*     */ 
/*     */   public Integer[] getDepartid()
/*     */   {
/* 158 */     return this.departid;
/*     */   }
/*     */ 
/*     */   public void setDepartid(Integer[] departid)
/*     */   {
/* 166 */     this.departid = departid;
/*     */   }
/*     */ 
/*     */   public String getTecname()
/*     */   {
/* 174 */     return this.tecname;
/*     */   }
/*     */ 
/*     */   public void setTecname(String tecname)
/*     */   {
/* 182 */     this.tecname = tecname;
/*     */   }
/*     */ 
/*     */   public String getOp() {
/* 186 */     return this.op;
/*     */   }
/*     */ 
/*     */   public void setOp(String op) {
/* 190 */     this.op = op;
/*     */   }
/*     */ 
/*     */   public Integer[] getDepartids() {
/* 194 */     return this.departids;
/*     */   }
/*     */ 
/*     */   public void setDepartids(Integer[] departids) {
/* 198 */     this.departids = departids;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.baseform.AddtecForm
 * JD-Core Version:    0.5.4
 */