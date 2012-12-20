/*    */ package com.frame.struts.action.college;
/*    */ 
/*    */ import com.entity.pingyue.Biaozhun;
/*    */ import com.entity.pingyue.BiaozhunDAO;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.apache.struts.action.Action;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ 
/*    */ public class BiaozhuneditAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 43 */     HttpSession session = request.getSession();
/* 44 */     if (session.getAttribute("adminid") == null) {
/* 45 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 46 */       return mapping.findForward("error");
/*    */     }
/*    */ 
/* 49 */     Integer bzid = Integer.valueOf(Integer.parseInt(request.getParameter("bzid").toString()));
/* 50 */     Biaozhun biaozhun = new Biaozhun();
/* 51 */     BiaozhunDAO bdao = new BiaozhunDAO();
/* 52 */     biaozhun = bdao.findById(bzid);
/*    */ 
/* 54 */     request.setAttribute("Biaozhun", biaozhun);
/* 55 */     request.setAttribute("grade", biaozhun.getGrade());
/* 56 */     request.setAttribute("op", "edit");
/*    */ 
/* 58 */     return mapping.findForward("display");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.BiaozhuneditAction
 * JD-Core Version:    0.5.4
 */