/*    */ package com.frame.struts.action.depart;
/*    */ 
/*    */ import com.entity.wish.ApplyNumGrade;
/*    */ import com.entity.wish.ApplyNumGradeDAO;
/*    */ import com.frame.struts.form.wish.SaveApplyNumGradeForm;
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
/*    */ public class SaveApplyNumGradeAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 43 */     SaveApplyNumGradeForm sform = (SaveApplyNumGradeForm)form;
/* 44 */     HttpSession session = request.getSession();
/* 45 */     if (session.getAttribute("teccode") == null) {
/* 46 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 47 */       return mapping.findForward("error");
/*    */     }
/*    */ 
/* 50 */     Integer num = sform.getNum();
/* 51 */     Integer departid = sform.getDepartid();
/* 52 */     Integer gradeid = sform.getGradeid();
/*    */ 
/* 54 */     ApplyNumGrade apply = new ApplyNumGrade();
/* 55 */     ApplyNumGradeDAO adao = new ApplyNumGradeDAO();
/*    */ 
/* 57 */     if (adao.getSession().get(ApplyNumGrade.class, departid) != null) {
/* 58 */       apply = (ApplyNumGrade)adao.getSession().get(ApplyNumGrade.class, departid);
/*    */     }
/* 60 */     apply.setDepartid(departid);
/* 61 */     apply.setGradeid(gradeid);
/* 62 */     apply.setNum(num);
/*    */ 
/* 64 */     Transaction ts = adao.getSession().beginTransaction();
/*    */     try {
/* 66 */       adao.getSession().saveOrUpdate(apply);
/* 67 */       ts.commit();
/* 68 */       adao.getSession().flush();
/* 69 */       request.setAttribute("notice", "设置 专业 资料成功！");
/* 70 */       return mapping.findForward("display");
/*    */     } catch (RuntimeException re) {
/* 72 */       System.out.println("异常信息：" + re);
/* 73 */       adao.getSession().clear();
/* 74 */       ts.rollback();
/* 75 */       request.setAttribute("notice", "设置专业失败！！！");
/* 76 */     }return mapping.findForward("error");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.SaveApplyNumGradeAction
 * JD-Core Version:    0.5.4
 */