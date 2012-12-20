/*    */ package com.frame.struts.action.depart;
/*    */ 
/*    */ import com.entity.wish.ApplyType;
/*    */ import com.entity.wish.ApplyTypeDAO;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.apache.struts.action.Action;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.Transaction;
/*    */ 
/*    */ public class DelApplyTypeAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 46 */     HttpSession session = request.getSession();
/* 47 */     if (session.getAttribute("teccode") == null) {
/* 48 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 49 */       return mapping.findForward("error");
/* 52 */     }
/*    */ Integer id = Integer.valueOf(Integer.parseInt(request.getParameter("id")));
/* 53 */     ApplyType r = new ApplyType();
/* 54 */     ApplyTypeDAO rdao = new ApplyTypeDAO();
/* 55 */     r = (ApplyType)rdao.getSession().get(ApplyType.class, id);
/*    */ 
/* 57 */     Transaction ts = rdao.getSession().beginTransaction();
/*    */     ActionForward localActionForward;
/*    */     try {
/* 59 */       rdao.delete(r);
/* 60 */       ts.commit();
/* 61 */       request.setAttribute("notice", "成功删除 毕业设计类型 数据！");
/* 62 */       return mapping.findForward("display");
/*    */     } catch (RuntimeException re) {
/* 64 */       ts.rollback();
/* 65 */       request.setAttribute("notice", "毕业设计类型 删除失败！");
/* 66 */       return mapping.findForward("error");
/*    */     } finally {
/* 68 */       rdao.getSession().close();
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.DelApplyTypeAction
 * JD-Core Version:    0.5.4
 */