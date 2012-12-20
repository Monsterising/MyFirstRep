/*    */ package com.frame.struts.action.college;
/*    */ 
/*    */ import com.entity.basedata.DepartList;
/*    */ import com.entity.basedata.DepartListDAO;
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
/*    */ 
/*    */ public class DeldepartAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 45 */     HttpSession session = request.getSession();
/* 46 */     if (session.getAttribute("adminid") == null) {
/* 47 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 48 */       return mapping.findForward("error");
/*    */     }
/*    */ 
/* 51 */     String userrole = session.getAttribute("userrole").toString();
/* 52 */     System.out.println("正在删除专业设置数据。用户角色数字：" + userrole);
/* 53 */     if ((!userrole.equals("4")) && (!userrole.equals("3"))) {
/* 54 */       request.setAttribute("notice", "您没有权限删除学院专业数据！");
/* 55 */       return mapping.findForward("error");
/*    */     }
/*    */ 
/* 58 */     String id = request.getParameter("did");
/* 59 */     DepartListDAO dao = new DepartListDAO();
/* 60 */     DepartList depart = new DepartList();
/* 61 */     depart = dao.findById(Integer.valueOf(Integer.parseInt(id)));
/* 62 */     Transaction ts = dao.getSession().beginTransaction();
/*    */     ActionForward localActionForward;
/*    */     try {
/* 65 */       dao.delete(depart);
/* 66 */       ts.commit();
/* 67 */       Qdao qdao = new Qdao();
/* 68 */       String hql = "delete DepartTec where departid=" + Integer.parseInt(id);
/* 69 */       qdao.del(hql);
/* 70 */       request.setAttribute("notice", "成功删除专业设置数据！");
/* 71 */       return mapping.findForward("list");
/*    */     } catch (RuntimeException re) {
/* 73 */       ts.rollback();
/* 74 */       request.setAttribute("notice", "删除专业设置数据失败！");
/* 75 */       return mapping.findForward("list");
/*    */     } finally {
/* 77 */       dao.getSession().close();
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.DeldepartAction
 * JD-Core Version:    0.5.4
 */