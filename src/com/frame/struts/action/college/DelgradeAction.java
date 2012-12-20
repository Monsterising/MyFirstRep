/*    */ package com.frame.struts.action.college;
/*    */ 
/*    */ import com.entity.basedata.GradeList;
/*    */ import com.entity.basedata.GradeListDAO;
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
/*    */ public class DelgradeAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 49 */     HttpSession session = request.getSession();
/* 50 */     if (session.getAttribute("adminid") == null) {
/* 51 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 52 */       return mapping.findForward("error");
/*    */     }
/*    */ 
/* 55 */     String userrole = session.getAttribute("userrole").toString();
/* 56 */     System.out.println("正在删除专业设置数据。用户角色数字：" + userrole);
/* 57 */     if ((!userrole.equals("4")) && (!userrole.equals("3"))) {
/* 58 */       request.setAttribute("notice", "您没有权限删除学院专业数据！");
/* 59 */       return mapping.findForward("error");
/*    */     }
/*    */ 
/* 63 */     String id = request.getParameter("gid");
/* 64 */     Integer did = Integer.valueOf(Integer.parseInt(request.getParameter("did").toString()));
/* 65 */     GradeListDAO dao = new GradeListDAO();
/* 66 */     GradeList grade = new GradeList();
/* 67 */     grade = dao.findById(Integer.valueOf(Integer.parseInt(id)));
/* 68 */     Transaction ts = dao.getSession().beginTransaction();
/*    */     ActionForward localActionForward;
/*    */     try
/*    */     {
/* 71 */       dao.delete(grade);
/* 72 */       ts.commit();
/* 73 */       request.setAttribute("departid", did);
/* 74 */       request.setAttribute("notice", "成功删除年级设置数据！");
/* 75 */       return mapping.findForward("list");
/*    */     } catch (RuntimeException re) {
/* 77 */       ts.rollback();
/* 78 */       request.setAttribute("notice", "删除年级设置数据失败！");
/* 79 */       return mapping.findForward("list");
/*    */     } finally {
/* 81 */       dao.getSession().close();
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.DelgradeAction
 * JD-Core Version:    0.5.4
 */