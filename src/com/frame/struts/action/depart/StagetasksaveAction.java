/*    */ package com.frame.struts.action.depart;
/*    */ 
/*    */ import com.entity.task.Stagetask;
/*    */ import com.entity.task.StagetaskDAO;
/*    */ import com.frame.struts.form.task.StagetaskForm;
/*    */ import java.io.PrintStream;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.apache.struts.action.Action;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.Transaction;
/*    */ import pub.toChi;
/*    */ 
/*    */ public class StagetasksaveAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 45 */     StagetaskForm stform = (StagetaskForm)form;
/*    */ 
/* 47 */     Integer stid = null;
/* 48 */     if (stform.getStid().intValue() != 0) {
/* 49 */       stid = stform.getStid();
/*    */     }
/* 51 */     Stagetask stagetask = new Stagetask();
/* 52 */     StagetaskDAO tdao = new StagetaskDAO();
/* 53 */     if (stid != null) {
/* 54 */       stagetask = tdao.findById(stid);
/*    */     }
/* 56 */     toChi tochi = new toChi();
/* 57 */     stagetask.setDatefagei(stform.getDatefagei());
/* 58 */     stagetask.setDatestart(stform.getDatestart());
/* 59 */     stagetask.setDateover(stform.getDateover());
/* 60 */     stagetask.setTaskname(tochi.toChinese(stform.getTaskname()));
/* 61 */     stagetask.setStucode(stform.getStucode());
/* 62 */     stagetask.setTeccode(stform.getTeccode());
/* 63 */     stagetask.setGradeid(stform.getGradeid());
/* 64 */     stagetask.setAtid(stform.getAtid());
/* 65 */     stagetask.setGrade("0");
/*    */ 
/* 67 */     Transaction ts = tdao.getSession().beginTransaction();
/*    */     try {
/* 69 */       tdao.getSession().saveOrUpdate(stagetask);
/* 70 */       tdao.getSession().flush();
/* 71 */       ts.commit();
/* 72 */       tdao.getSession().close();
/* 73 */       request.setAttribute("notice", "阶段任务布置 成功");
/* 74 */       return mapping.findForward("list");
/*    */     } catch (RuntimeException re) {
/* 76 */       System.out.println("异常信息：" + re);
/* 77 */       tdao.getSession().clear();
/* 78 */       ts.rollback();
/* 79 */       request.setAttribute("notice", "阶段任务失败！！！");
/* 80 */     }return mapping.findForward("error");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.StagetasksaveAction
 * JD-Core Version:    0.5.4
 */