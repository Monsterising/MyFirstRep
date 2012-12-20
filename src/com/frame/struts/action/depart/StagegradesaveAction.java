/*    */ package com.frame.struts.action.depart;
/*    */ 
/*    */ import com.entity.task.Stagetask;
/*    */ import com.entity.task.StagetaskDAO;
/*    */ import com.frame.struts.form.task.StagegradeForm;
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
/*    */ import pub.toChi;
/*    */ 
/*    */ public class StagegradesaveAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 45 */     StagegradeForm sform = (StagegradeForm)form;
/* 46 */     HttpSession session = request.getSession();
/* 47 */     if (session.getAttribute("teccode") == null) {
/* 48 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 49 */       return mapping.findForward("error");
/*    */     }
/* 51 */     String teccode = session.getAttribute("teccode").toString();
/* 52 */     Integer stid = sform.getStid();
/*    */ 
/* 54 */     Stagetask stagetask = new Stagetask();
/* 55 */     StagetaskDAO sdao = new StagetaskDAO();
/* 56 */     stagetask = sdao.findById(stid);
/* 57 */     toChi tochi = new toChi();
/* 58 */     stagetask.setGrade(sform.getGrade());
/* 59 */     stagetask.setResult(tochi.toChinese(sform.getResult()));
/*    */ 
/* 61 */     Transaction ts = sdao.getSession().beginTransaction();
/*    */     try {
/* 63 */       sdao.getSession().saveOrUpdate(stagetask);
/* 64 */       sdao.getSession().flush();
/* 65 */       ts.commit();
/* 66 */       sdao.getSession().close();
/* 67 */       request.setAttribute("notice", "阶段任务分数评定 成功");
/* 68 */       return mapping.findForward("list");
/*    */     } catch (RuntimeException re) {
/* 70 */       System.out.println("异常信息：" + re);
/* 71 */       sdao.getSession().clear();
/* 72 */       ts.rollback();
/* 73 */       request.setAttribute("notice", "阶段任务分数评定 失败！！！");
/* 74 */     }return mapping.findForward("error");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.StagegradesaveAction
 * JD-Core Version:    0.5.4
 */