/*    */ package com.frame.struts.action.task;
/*    */ 
/*    */ import com.entity.basedata.StuList;
/*    */ import com.entity.basedata.StuListDAO;
/*    */ import com.entity.task.Stagetaskdayi;
/*    */ import com.entity.task.StagetaskdayiDAO;
/*    */ import com.frame.struts.form.task.DayiForm;
/*    */ import java.io.PrintStream;
/*    */ import java.util.Date;
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
/*    */ public class DayitecsaveAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 49 */     DayiForm dform = (DayiForm)form;
/*    */ 
/* 51 */     HttpSession session = request.getSession();
/* 52 */     if (session.getAttribute("teccode") == null) {
/* 53 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 54 */       return mapping.findForward("error");
/*    */     }
/* 56 */     String teccode = session.getAttribute("teccode").toString();
/*    */ 
/* 59 */     StuList stu = new StuList();
/* 60 */     StuListDAO sdao = new StuListDAO();
/* 61 */     stu = sdao.findById(dform.getStucode());
/*    */ 
/* 63 */     toChi tochi = new toChi();
/* 64 */     Date date = new Date();
/* 65 */     Stagetaskdayi dayi = new Stagetaskdayi();
/* 66 */     StagetaskdayiDAO ddao = new StagetaskdayiDAO();
/* 67 */     if (dform.getDyid().intValue() != 0) {
/* 68 */       dayi = ddao.findById(dform.getDyid());
/*    */     }
/* 70 */     dayi.setAnswer(tochi.toChinese(dform.getAnswer()));
/* 71 */     dayi.setAtime(date);
/* 72 */     dayi.setStucode(dform.getStucode());
/* 73 */     dayi.setTeccode(teccode);
/* 74 */     dayi.setDepartid(stu.getDepartid());
/* 75 */     dayi.setGradeid(stu.getGradeid());
/* 76 */     dayi.setIsok(Integer.valueOf(1));
/*    */ 
/* 78 */     Transaction tsas = ddao.getSession().beginTransaction();
/*    */     try {
/* 80 */       ddao.getSession().saveOrUpdate(dayi);
/* 81 */       ddao.getSession().flush();
/* 82 */       tsas.commit();
/*    */     } catch (RuntimeException re) {
/* 84 */       System.out.println("异常信息：" + re);
/* 85 */       ddao.getSession().clear();
/* 86 */       tsas.rollback();
/* 87 */       request.setAttribute("notice", "保存失败！！！");
/* 88 */       return mapping.findForward("error");
/*    */     }
/*    */ 
/* 92 */     return mapping.findForward("list");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.task.DayitecsaveAction
 * JD-Core Version:    0.5.4
 */