/*    */ package com.frame.struts.action.dabian;
/*    */ 
/*    */ import com.entity.dabian.DabianGroup;
/*    */ import com.entity.dabian.DabianGroupDAO;
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
/*    */ public class DabiangroupdelAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 45 */     HttpSession session = request.getSession();
/* 46 */     if (session.getAttribute("teccode") == null) {
/* 47 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 48 */       return mapping.findForward("error");
/*    */     }
/*    */ 
/* 51 */     if (session.getAttribute("usershenfen") == null) {
/* 52 */       request.setAttribute("notice", "您没有该项权限！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 53 */       return mapping.findForward("error");
/*    */     }
/*    */ 
/* 56 */     Integer departid = Integer.valueOf(Integer.parseInt(request.getParameter("departid").toString()));
/* 57 */     Integer gradeid = Integer.valueOf(Integer.parseInt(request.getParameter("gradeid").toString()));
/* 58 */     Integer dbgid = Integer.valueOf(Integer.parseInt(request.getParameter("id").toString()));
/*    */ 
/* 60 */     DabianGroup dbg = new DabianGroup();
/* 61 */     DabianGroupDAO dbgdao = new DabianGroupDAO();
/*    */ 
/* 63 */     if (dbgdao.getSession().get(DabianGroup.class, dbgid) != null) {
/* 64 */       dbg = (DabianGroup)dbgdao.getSession().get(DabianGroup.class, dbgid);
/* 65 */       Transaction ts = dbgdao.getSession().beginTransaction();
/*    */       try {
/* 67 */         dbgdao.delete(dbg);
/* 68 */         ts.commit();
/* 69 */         request.setAttribute("notice", "成功删除数据！");
/*    */       }
/*    */       catch (RuntimeException re) {
/* 72 */         ts.rollback();
/* 73 */         request.setAttribute("notice", "删除答辩小组数据失败！");
/* 74 */         return mapping.findForward("display");
/*    */       } finally {
/* 76 */         dbgdao.getSession().close();
/*    */       }
/*    */     }
/*    */ 
/* 80 */     Qdao qdao = new Qdao();
/* 81 */     qdao.del("delete DabianGroupTec where dbgid=" + dbgid);
/* 82 */     qdao.del("delete DabianGroupStu where dbgid=" + dbgid);
/*    */ 
/* 86 */     return mapping.findForward("display");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.dabian.DabiangroupdelAction
 * JD-Core Version:    0.5.4
 */