/*    */ package com.frame.struts.action;
/*    */ 
/*    */ import com.entity.basedata.Users;
/*    */ import com.entity.basedata.UsersDAO;
/*    */ import com.frame.struts.baseform.UseraddForm;
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
/*    */ import pub.Qdao;
/*    */ import pub.toChi;
/*    */ 
/*    */ public class DeluserdataAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 48 */     UseraddForm useraddForm = (UseraddForm)form;
/* 49 */     HttpSession session = request.getSession();
/* 50 */     if (session.getAttribute("adminid") == null) {
/* 51 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 52 */       return mapping.findForward("error");
/*    */     }
/*    */ 
/* 55 */     String userrole = session.getAttribute("userrole").toString();
/* 56 */     System.out.println("正在删除管理员数据。用户角色数字：" + userrole);
/* 57 */     if (!userrole.equals("5")) {
/* 58 */       request.setAttribute("notice", "您没有权限删除学院管理员数据！");
/* 59 */       return mapping.findForward("list");
/*    */     }
/*    */ 
/* 62 */     toChi tochi = new toChi();
/* 63 */     String id = request.getParameter("id");
/* 64 */     UsersDAO dao = new UsersDAO();
/* 65 */     Users admin = new Users();
/* 66 */     admin = dao.findById(Integer.valueOf(Integer.parseInt(id)));
/* 67 */     Transaction ts = dao.getSession().beginTransaction();
/*    */     ActionForward localActionForward;
/*    */     try
/*    */     {
/* 71 */       dao.delete(admin);
/* 72 */       ts.commit();
/* 73 */       Qdao qdao = new Qdao();
/* 74 */       String hql = "delete CollegeUser where userid=" + Integer.parseInt(id);
/* 75 */       qdao.del(hql);
/* 76 */       request.setAttribute("notice", "成功删除管理员数据！");
/* 77 */       return mapping.findForward("list");
/*    */     } catch (RuntimeException re) {
/* 79 */       ts.rollback();
/* 80 */       request.setAttribute("notice", "删除管理员数据失败！");
/* 81 */       return mapping.findForward("list");
/*    */     } finally {
/* 83 */       dao.getSession().close();
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.DeluserdataAction
 * JD-Core Version:    0.5.4
 */