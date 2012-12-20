/*     */ package com.frame.struts.form.wish;
/*     */ 
/*     */ import java.util.Date;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class KetishenbaoForm extends ActionForm
/*     */ {
/*     */   private String op;
/*     */   private Integer[] resultids;
/*     */   private Integer atid;
/*     */   private Integer stusum;
/*     */   private String sign1;
/*     */   private String practise;
/*     */   private String title;
/*     */   private String kind;
/*     */   private Integer applytype;
/*     */   private String applytypename;
/*     */   private String tecprof;
/*     */   private String sign2;
/*     */   private String advice2;
/*     */   private Integer collegeid;
/*     */   private String content;
/*     */   private Integer departid;
/*     */   private Date date2;
/*     */   private String advice1;
/*     */   private Integer classid;
/*     */   private Integer gradeid;
/*     */   private String computer;
/*     */   private String teccode;
/*     */   private Date date1;
/*     */   private Integer atrid;
/*     */   private String preparework;
/*     */   private String source;
/*     */ 
/*     */   public String getApplytypename()
/*     */   {
/* 105 */     return this.applytypename;
/*     */   }
/*     */ 
/*     */   public void setApplytypename(String applytypename) {
/* 109 */     this.applytypename = applytypename;
/*     */   }
/*     */ 
/*     */   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/* 121 */     return null;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public Integer getStusum()
/*     */   {
/* 138 */     return this.stusum;
/*     */   }
/*     */ 
/*     */   public void setStusum(Integer stusum)
/*     */   {
/* 146 */     this.stusum = stusum;
/*     */   }
/*     */ 
/*     */   public String getSign1()
/*     */   {
/* 154 */     return this.sign1;
/*     */   }
/*     */ 
/*     */   public void setSign1(String sign1)
/*     */   {
/* 162 */     this.sign1 = sign1;
/*     */   }
/*     */ 
/*     */   public String getPractise()
/*     */   {
/* 170 */     return this.practise;
/*     */   }
/*     */ 
/*     */   public void setPractise(String practise)
/*     */   {
/* 178 */     this.practise = practise;
/*     */   }
/*     */ 
/*     */   public String getTitle()
/*     */   {
/* 186 */     return this.title;
/*     */   }
/*     */ 
/*     */   public void setTitle(String title)
/*     */   {
/* 194 */     this.title = title;
/*     */   }
/*     */ 
/*     */   public String getKind()
/*     */   {
/* 202 */     return this.kind;
/*     */   }
/*     */ 
/*     */   public void setKind(String kind)
/*     */   {
/* 210 */     this.kind = kind;
/*     */   }
/*     */ 
/*     */   public void setApplytype(Integer applytype)
/*     */   {
/* 224 */     this.applytype = applytype;
/*     */   }
/*     */ 
/*     */   public String getTecprof()
/*     */   {
/* 232 */     return this.tecprof;
/*     */   }
/*     */ 
/*     */   public void setTecprof(String tecprof)
/*     */   {
/* 240 */     this.tecprof = tecprof;
/*     */   }
/*     */ 
/*     */   public String getSign2()
/*     */   {
/* 248 */     return this.sign2;
/*     */   }
/*     */ 
/*     */   public void setSign2(String sign2)
/*     */   {
/* 256 */     this.sign2 = sign2;
/*     */   }
/*     */ 
/*     */   public String getAdvice2()
/*     */   {
/* 264 */     return this.advice2;
/*     */   }
/*     */ 
/*     */   public void setAdvice2(String advice2)
/*     */   {
/* 272 */     this.advice2 = advice2;
/*     */   }
/*     */ 
/*     */   public Integer getCollegeid()
/*     */   {
/* 280 */     return this.collegeid;
/*     */   }
/*     */ 
/*     */   public void setCollegeid(Integer collegeid)
/*     */   {
/* 288 */     this.collegeid = collegeid;
/*     */   }
/*     */ 
/*     */   public String getContent()
/*     */   {
/* 296 */     return this.content;
/*     */   }
/*     */ 
/*     */   public void setContent(String content)
/*     */   {
/* 304 */     this.content = content;
/*     */   }
/*     */ 
/*     */   public Integer getDepartid()
/*     */   {
/* 312 */     return this.departid;
/*     */   }
/*     */ 
/*     */   public void setDepartid(Integer departid)
/*     */   {
/* 320 */     this.departid = departid;
/*     */   }
/*     */ 
/*     */   public Date getDate2()
/*     */   {
/* 328 */     return this.date2;
/*     */   }
/*     */ 
/*     */   public void setDate2(Date date2)
/*     */   {
/* 336 */     this.date2 = date2;
/*     */   }
/*     */ 
/*     */   public String getAdvice1()
/*     */   {
/* 344 */     return this.advice1;
/*     */   }
/*     */ 
/*     */   public void setAdvice1(String advice1)
/*     */   {
/* 352 */     this.advice1 = advice1;
/*     */   }
/*     */ 
/*     */   public Integer getClassid()
/*     */   {
/* 360 */     return this.classid;
/*     */   }
/*     */ 
/*     */   public void setClassid(Integer classid)
/*     */   {
/* 368 */     this.classid = classid;
/*     */   }
/*     */ 
/*     */   public Integer getGradeid()
/*     */   {
/* 376 */     return this.gradeid;
/*     */   }
/*     */ 
/*     */   public void setGradeid(Integer gradeid)
/*     */   {
/* 384 */     this.gradeid = gradeid;
/*     */   }
/*     */ 
/*     */   public String getComputer()
/*     */   {
/* 392 */     return this.computer;
/*     */   }
/*     */ 
/*     */   public void setComputer(String computer)
/*     */   {
/* 400 */     this.computer = computer;
/*     */   }
/*     */ 
/*     */   public String getTeccode()
/*     */   {
/* 408 */     return this.teccode;
/*     */   }
/*     */ 
/*     */   public void setTeccode(String teccode)
/*     */   {
/* 416 */     this.teccode = teccode;
/*     */   }
/*     */ 
/*     */   public Date getDate1()
/*     */   {
/* 424 */     return this.date1;
/*     */   }
/*     */ 
/*     */   public void setDate1(Date date1)
/*     */   {
/* 432 */     this.date1 = date1;
/*     */   }
/*     */ 
/*     */   public Integer getAtrid()
/*     */   {
/* 440 */     return this.atrid;
/*     */   }
/*     */ 
/*     */   public void setAtrid(Integer atrid)
/*     */   {
/* 448 */     this.atrid = atrid;
/*     */   }
/*     */ 
/*     */   public String getPreparework()
/*     */   {
/* 456 */     return this.preparework;
/*     */   }
/*     */ 
/*     */   public void setPreparework(String preparework)
/*     */   {
/* 464 */     this.preparework = preparework;
/*     */   }
/*     */ 
/*     */   public String getSource()
/*     */   {
/* 472 */     return this.source;
/*     */   }
/*     */ 
/*     */   public void setSource(String source)
/*     */   {
/* 480 */     this.source = source;
/*     */   }
/*     */ 
/*     */   public Integer getAtid() {
/* 484 */     return this.atid;
/*     */   }
/*     */ 
/*     */   public void setAtid(Integer atid) {
/* 488 */     this.atid = atid;
/*     */   }
/*     */ 
/*     */   public void setResultids(Integer[] resultids)
/*     */   {
/* 494 */     this.resultids = resultids;
/*     */   }
/*     */ 
/*     */   public Integer[] getResultids() {
/* 498 */     return this.resultids;
/*     */   }
/*     */ 
/*     */   public Integer getApplytype() {
/* 502 */     return this.applytype;
/*     */   }
/*     */ 
/*     */   public String getOp() {
/* 506 */     return this.op;
/*     */   }
/*     */ 
/*     */   public void setOp(String op) {
/* 510 */     this.op = op;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.form.wish.KetishenbaoForm
 * JD-Core Version:    0.5.4
 */