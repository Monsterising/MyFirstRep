/*    */ package com.frame.struts.action.dayi;
/*    */ 
/*    */ import com.entity.task.Stagetaskdayi;
/*    */ import com.entity.task.StagetaskdayiDAO;
/*    */ import com.frame.struts.form.task.DayiForm;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.apache.struts.action.Action;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ 
/*    */ public class DayiteceditAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 42 */     DayiForm dayiForm = (DayiForm)form;
/*    */     Integer dyid;
/* 44 */     if (request.getParameter("dyid") != null)
/* 45 */       dyid = Integer.valueOf(Integer.parseInt(request.getParameter("dyid").toString()));
/*    */     else
/* 47 */       return mapping.findForward("error");
/*    */    
/* 49 */     HttpSession session = request.getSession();
/* 50 */     if (session.getAttribute("teccode") == null) {
/* 51 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 52 */       return mapping.findForward("error");
/*    */     }
/* 54 */     String teccode = session.getAttribute("teccode").toString();
/* 55 */     request.setAttribute("teccode", teccode);
/*    */ 
/* 57 */     Stagetaskdayi dayi = new Stagetaskdayi();
/* 58 */     StagetaskdayiDAO ddao = new StagetaskdayiDAO();
/* 59 */     if (ddao.findById(dyid) != null) {
/* 60 */       dayi = ddao.findById(dyid);
/* 61 */       if (dayi.getTeccode().equals(teccode)) {
/* 62 */         request.setAttribute("Stagetaskdayi", dayi);
/* 63 */         return mapping.findForward("display");
/*    */       }
/* 65 */       return mapping.findForward("error");
/*    */     }
/*    */ 
/* 68 */     return mapping.findForward("error");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.dayi.DayiteceditAction
 * JD-Core Version:    0.5.4
 */