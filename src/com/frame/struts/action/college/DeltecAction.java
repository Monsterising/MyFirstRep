/*    */ package com.frame.struts.action.college;
/*    */ 
/*    */ import com.entity.basedata.TecList;
/*    */ import com.entity.basedata.TecListDAO;
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
/*    */ public class DeltecAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 43 */     HttpSession session = request.getSession();
/* 44 */     if (session.getAttribute("adminid") == null) {
/* 45 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 46 */       return mapping.findForward("error");
/*    */     }
/*    */ 
/* 49 */     String teccode = request.getParameter("tid");
/* 50 */     if (teccode.equals("")) {
/* 51 */       request.setAttribute("notice", "删除 " + teccode + " 资料失败！！！<br>传入参数不合法！");
/* 52 */       return mapping.findForward("error");
/*    */     }
/*    */ 
/* 55 */     String userrole = session.getAttribute("userrole").toString();
/* 56 */     if ((!userrole.equals("3")) && (!userrole.equals("4"))) {
/* 57 */       request.setAttribute("notice", "您没有权限删除管理员数据！");
/* 58 */       return mapping.findForward("list");
/*    */     }
/*    */ 
/* 63 */     TecListDAO dao = new TecListDAO();
/* 64 */     TecList tec = new TecList();
/* 65 */     tec = dao.findById(teccode);
/* 66 */     Transaction ts = dao.getSession().beginTransaction();
/*    */     ActionForward localActionForward;
/*    */     try
/*    */     {
/* 68 */       dao.delete(tec);
/* 69 */       ts.commit();
/* 70 */       Qdao qdao = new Qdao();
/* 71 */       String hql = "delete DepartTec where teccode='" + teccode + "'";
/* 72 */       qdao.del(hql);
/*    */ 
/* 74 */       request.setAttribute("notice", "成功删除TecList数据！");
/*    */ 
/* 77 */       return mapping.findForward("list");
/*    */     } catch (RuntimeException re) {
/* 79 */       ts.rollback();
/* 80 */       request.setAttribute("notice", "删除TecList数据失败！");
/* 81 */       return mapping.findForward("list");
/*    */     } finally {
/* 83 */       dao.getSession().close();
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.DeltecAction
 * JD-Core Version:    0.5.4
 */