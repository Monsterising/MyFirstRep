/*    */ package com.frame.struts.form.college;
/*    */ 
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.apache.struts.action.ActionErrors;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ 
/*    */ public class QingkuForm extends ActionForm
/*    */ {
/*    */   private String[] departtec;
/*    */ 
/*    */   public String[] getDeparttec()
/*    */   {
/* 25 */     return this.departtec;
/*    */   }
/*    */ 
/*    */   public void setDeparttec(String[] departtec) {
/* 29 */     this.departtec = departtec;
/*    */   }
/*    */ 
/*    */   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
/*    */   {
/* 44 */     return null;
/*    */   }
/*    */ 
/*    */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*    */   {
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.form.college.QingkuForm
 * JD-Core Version:    0.5.4
 */