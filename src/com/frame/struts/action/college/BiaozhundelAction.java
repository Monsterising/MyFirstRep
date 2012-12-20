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
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.Transaction;
/*    */ 
/*    */ public class BiaozhundelAction extends Action
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
/*    */ 
/* 54 */     if ((!userrole.equals("4")) && (!userrole.equals("3"))) {
/* 55 */       request.setAttribute("notice", "您没有权限删除学院专业数据！");
/* 56 */       return mapping.findForward("error");
/*    */     }
/*    */ 
/* 61 */     Integer bzid = Integer.valueOf(Integer.parseInt(request.getParameter("bzid").toString()));
/* 62 */     BiaozhunDAO bdao = new BiaozhunDAO();
/* 63 */     Biaozhun biaozhun = new Biaozhun();
/* 64 */     biaozhun = bdao.findById(bzid);
/* 65 */     Transaction ts = bdao.getSession().beginTransaction();
/*    */     ActionForward localActionForward;
/*    */     try
/*    */     {
/* 68 */       bdao.delete(biaozhun);
/* 69 */       ts.commit();
/* 70 */       request.setAttribute("notice", "成功删除评分标准数据！");
/* 71 */       return mapping.findForward("list");
/*    */     } catch (RuntimeException re) {
/* 73 */       ts.rollback();
/* 74 */       request.setAttribute("notice", "删除评分标准数据失败！！");
/* 75 */       return mapping.findForward("list");
/*    */     } finally {
/* 77 */       bdao.getSession().close();
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.BiaozhundelAction
 * JD-Core Version:    0.5.4
 */