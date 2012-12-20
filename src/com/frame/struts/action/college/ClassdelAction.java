/*    */ package com.frame.struts.action.college;
/*    */ 
/*    */ import com.entity.basedata.ClassList;
/*    */ import com.entity.basedata.ClassListDAO;
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
/*    */ public class ClassdelAction extends Action
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
/* 53 */     System.out.println("正在删除班级数据。用户角色数字：" + userrole);
/* 54 */     if ((!userrole.equals("4")) && (!userrole.equals("3"))) {
/* 55 */       request.setAttribute("notice", "您没有权限删除学院班级数据！");
/* 56 */       return mapping.findForward("error");
/*    */     }
/*    */ 
/* 60 */     String id = request.getParameter("cid");
/* 61 */     Integer did = Integer.valueOf(Integer.parseInt(request.getParameter("did").toString()));
/* 62 */     ClassListDAO dao = new ClassListDAO();
/* 63 */     ClassList classentity = new ClassList();
/* 64 */     classentity = dao.findById(Integer.valueOf(Integer.parseInt(id)));
/* 65 */     Transaction ts = dao.getSession().beginTransaction();
/*    */     ActionForward localActionForward;
/*    */     try
/*    */     {
/* 68 */       dao.delete(classentity);
/* 69 */       ts.commit();
/* 70 */       request.setAttribute("departid", did);
/* 71 */       request.setAttribute("notice", "成功删除班级设置数据！");
/* 72 */       return mapping.findForward("display");
/*    */     } catch (RuntimeException re) {
/* 74 */       ts.rollback();
/* 75 */       request.setAttribute("notice", "删除班级设置数据失败！");
/* 76 */       return mapping.findForward("error");
/*    */     } finally {
/* 78 */       dao.getSession().close();
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.ClassdelAction
 * JD-Core Version:    0.5.4
 */