/*    */ package com.frame.struts.action.college;
/*    */ 
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.apache.struts.action.Action;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ import pub.Qdao;
/*    */ 
/*    */ public class NewsdelAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 45 */     HttpSession session = request.getSession();
/* 46 */     if ((session.getAttribute("adminid") == null) && (session.getAttribute("teccode") == null)) {
/* 47 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 48 */       return mapping.findForward("error");
/*    */     }
/* 50 */     if ((!session.getAttribute("usershenfen").equals("depart")) && (!session.getAttribute("usershenfen").equals("college")) && (!session.getAttribute("usershenfen").equals("mishu"))) {
/* 51 */       request.setAttribute("notice", "超出权限！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 52 */       return mapping.findForward("error");
/*    */     }
/*    */ 
/* 56 */     String id = request.getParameter("id");
/* 57 */     if ((id == null) || (id.equals(""))) {
/* 58 */       request.setAttribute("notice", "请输入正确的ID");
/* 59 */       return mapping.findForward("display");
/*    */     }
/* 61 */     Integer newsid = Integer.valueOf(Integer.parseInt(id));
/*    */ 
/* 65 */     Qdao qdao = new Qdao();
/* 66 */     String hql = "delete News where newsid=" + newsid;
/* 67 */     qdao.del(hql);
/* 68 */     if (session.getAttribute("usershenfen").equals("depart")) {
/* 69 */       return mapping.findForward("newsindexdepart");
/*    */     }
/*    */ 
/* 72 */     return mapping.findForward("list");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.NewsdelAction
 * JD-Core Version:    0.5.4
 */