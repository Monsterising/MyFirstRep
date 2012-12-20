/*    */ package com.frame.struts.action.college;
/*    */ 
/*    */ import com.entity.basedata.StuList;
/*    */ import com.entity.basedata.StuListDAO;
/*    */ import java.io.PrintStream;
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
/*    */ public class StudelAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 46 */     HttpSession session = request.getSession();
/* 47 */     if (session.getAttribute("adminid") == null) {
/* 48 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 49 */       return mapping.findForward("error");
/*    */     }
/*    */ 
/* 52 */     String userrole = session.getAttribute("userrole").toString();
/* 53 */     System.out.println("正在删除学生数据。用户角色数字：" + userrole);
/* 54 */     if ((!userrole.equals("4")) && (!userrole.equals("3"))) {
/* 55 */       request.setAttribute("notice", "您没有权限删除学生数据！");
/* 56 */       return mapping.findForward("error");
/*    */     }
/*    */ 
/* 60 */     String id = request.getParameter("stucode");
/* 61 */     StuListDAO dao = new StuListDAO();
/* 62 */     StuList stuentity = new StuList();
/* 63 */     stuentity = dao.findById(id);
/* 64 */     Transaction ts = dao.getSession().beginTransaction();
/*    */     ActionForward localActionForward;
/*    */     try
/*    */     {
/* 67 */       dao.delete(stuentity);
/* 68 */       ts.commit();
/* 69 */       request.setAttribute("notice", "成功删除学生数据！" + id);
/* 70 */       return mapping.findForward("list");
/*    */     } catch (RuntimeException re) {
/* 72 */       ts.rollback();
/* 73 */       request.setAttribute("notice", "删除学生数据失败！" + id);
/* 74 */       return mapping.findForward("error");
/*    */     } finally {
/* 76 */       dao.getSession().close();
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.StudelAction
 * JD-Core Version:    0.5.4
 */