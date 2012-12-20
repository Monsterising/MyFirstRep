/*    */ package com.frame.struts.baseform;
/*    */ 
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.apache.struts.action.ActionErrors;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ 
/*    */ public class CollegeForm extends ActionForm
/*    */ {
/*    */   private Integer collegeid;
/*    */   private String collegename;
/*    */ 
/*    */   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
/*    */   {
/* 43 */     return null;
/*    */   }
/*    */ 
/*    */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*    */   {
/*    */   }
/*    */ 
/*    */   public Integer getCollegeid()
/*    */   {
/* 60 */     return this.collegeid;
/*    */   }
/*    */ 
/*    */   public void setCollegeid(Integer collegeid)
/*    */   {
/* 68 */     this.collegeid = collegeid;
/*    */   }
/*    */ 
/*    */   public String getCollegename()
/*    */   {
/* 76 */     return this.collegename;
/*    */   }
/*    */ 
/*    */   public void setCollegename(String collegename)
/*    */   {
/* 84 */     this.collegename = collegename;
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.baseform.CollegeForm
 * JD-Core Version:    0.5.4
 */