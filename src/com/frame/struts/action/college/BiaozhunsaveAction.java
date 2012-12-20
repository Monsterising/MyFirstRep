/*    */ package com.frame.struts.action.college;
/*    */ 
/*    */ import com.entity.pingyue.Biaozhun;
/*    */ import com.entity.pingyue.BiaozhunDAO;
/*    */ import com.frame.struts.form.pingyue.BiaozhunForm;
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
/*    */ public class BiaozhunsaveAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 45 */     BiaozhunForm bform = (BiaozhunForm)form;
/* 46 */     HttpSession session = request.getSession();
/* 47 */     if (session.getAttribute("adminid") == null) {
/* 48 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 49 */       return mapping.findForward("error");
/*    */     }
/*    */ 
/* 52 */     String op = bform.getOp();
/* 53 */     Biaozhun biaozhun = new Biaozhun();
/* 54 */     BiaozhunDAO bdao = new BiaozhunDAO();
/* 55 */     if (op.equals("edit")) {
/* 56 */       biaozhun = bdao.findById(bform.getBzid());
/*    */     }
/* 58 */     toChi tochi = new toChi();
/* 59 */     biaozhun.setContent(tochi.toChinese(bform.getContent()));
/* 60 */     biaozhun.setGrade(tochi.toChinese(bform.getGrade()));
/* 61 */     biaozhun.setMaxnum(bform.getMaxnum());
/* 62 */     biaozhun.setMinnum(bform.getMinnum());
/* 63 */     biaozhun.setType(tochi.toChinese(bform.getType()));
/* 64 */     Transaction ts = bdao.getSession().beginTransaction();
/*    */     try {
/* 66 */       bdao.getSession().saveOrUpdate(biaozhun);
/* 67 */       ts.commit();
/* 68 */       bdao.getSession().flush();
/* 69 */       request.setAttribute("notice", "操作评分标准成功！！！");
/* 70 */       return mapping.findForward("list");
/*    */     } catch (RuntimeException re) {
/* 72 */       System.out.println("异常信息：" + re);
/* 73 */       bdao.getSession().clear();
/* 74 */       ts.rollback();
/* 75 */       request.setAttribute("notice", "操作评分标准失败！！！");
/* 76 */     }return mapping.findForward("error");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.BiaozhunsaveAction
 * JD-Core Version:    0.5.4
 */