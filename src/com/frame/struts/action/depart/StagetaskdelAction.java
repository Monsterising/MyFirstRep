/*    */ package com.frame.struts.action.depart;
/*    */ 
/*    */ import com.entity.task.Stagetask;
/*    */ import com.entity.task.StagetaskDAO;
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
/*    */ public class StagetaskdelAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 44 */     HttpSession session = request.getSession();
/* 45 */     if (session.getAttribute("teccode") == null) {
/* 46 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 47 */       return mapping.findForward("error");
/*    */     }
/* 49 */     String teccode = session.getAttribute("teccode").toString();
/* 50 */     String stucode = request.getParameter("s").toString();
/* 51 */     Integer stid = Integer.valueOf(Integer.parseInt(request.getParameter("stid").toString()));
/* 52 */     Integer atid = Integer.valueOf(Integer.parseInt(request.getParameter("atid").toString()));
/*    */ 
/* 54 */     Stagetask stask = new Stagetask();
/* 55 */     StagetaskDAO sdao = new StagetaskDAO();
/* 56 */     stask = sdao.findById(stid);
/* 57 */     if (stask.getTeccode().equals(teccode)) { sdao.delete(stask);
/* 59 */       Transaction ts = sdao.getSession().beginTransaction();
/*    */       ActionForward localActionForward;
/*    */       try {
/* 61 */         sdao.delete(stask);
/* 62 */         ts.commit();
/* 63 */         request.setAttribute("stucode", stucode);
/* 64 */         request.setAttribute("atid", atid);
/* 65 */         request.setAttribute("notice", "成功删除数据！");
/* 66 */         return mapping.findForward("list");
/*    */       } catch (RuntimeException re) {
/* 68 */         ts.rollback();
/* 69 */         request.setAttribute("notice", "删除阶段任务数据失败！");
/* 70 */         return mapping.findForward("list");
/*    */       } finally {
/* 72 */         sdao.getSession().close();
/*    */       }
/*    */  }
/*    */ 
/*    */ 
/* 77 */     request.setAttribute("notice", "删除阶段任务数据失败！");
/* 78 */     return mapping.findForward("error");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.StagetaskdelAction
 * JD-Core Version:    0.5.4
 */