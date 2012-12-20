/*    */ package com.frame.struts.action;
/*    */ 
/*    */ import com.entity.basedata.CollegeListDAO;
/*    */ import com.frame.struts.baseform.CollegeForm;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.apache.struts.action.Action;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ 
/*    */ public class CollegelistAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 49 */     HttpSession session = request.getSession();
/*    */ 
/* 54 */     CollegeForm collegeForm = (CollegeForm)form;
/*    */ 
/* 56 */     CollegeListDAO dao = new CollegeListDAO();
/* 57 */     List collegelist = dao.findAll();
/* 58 */     request.setAttribute("collegelist", collegelist);
/* 59 */     return mapping.findForward("succ");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.CollegelistAction
 * JD-Core Version:    0.5.4
 */