/*    */ package com.frame.struts.action.stu;
/*    */ 
/*    */ import com.entity.wish.StuWish;
/*    */ import com.entity.wish.StuWishDAO;
/*    */ import com.frame.struts.form.wish.StuwishForm;
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
/*    */ public class StuapplysaveAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 48 */     HttpSession session = request.getSession();
/* 49 */     if (session.getAttribute("stucode") == null) {
/* 50 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 51 */       return mapping.findForward("error");
/* 53 */     }StuwishForm wform = (StuwishForm)form;
/* 54 */     StuWish stuwish = new StuWish();
/* 55 */     StuWishDAO wdao = new StuWishDAO();
/*    */ 
/* 57 */     String stucode = (String)session.getAttribute("stucode");
/* 58 */     toChi tochi = new toChi();
/* 59 */     Date date = new Date();
/* 60 */     stuwish.setStucode(stucode);
/* 61 */     stuwish.setTeccode(wform.getTeccode());
/* 62 */     stuwish.setPriority(wform.getPriority());
/* 63 */     stuwish.setDateup(date);
/* 64 */     stuwish.setWishstate("等待审核");
/* 65 */     stuwish.setAtid(wform.getAtid());
/* 66 */     Transaction ts = wdao.getSession().beginTransaction();
/*    */     ActionForward localActionForward;
/*    */     try {
/* 68 */       wdao.getSession().saveOrUpdate(stuwish);
/* 69 */       ts.commit();
/* 70 */       wdao.getSession().flush();
/* 71 */       System.out.println(stucode + "填报志愿");
/* 72 */       request.setAttribute("notice", "填报志愿成功！");
/* 73 */       System.out.println(stucode + "填报了课题" + wform.getAtid() + ",志愿级别为" + wform.getPriority());
/* 74 */       return mapping.findForward("success");
/*    */     } catch (RuntimeException re) {
/* 76 */       System.out.println("异常信息：" + re);
/* 77 */       wdao.getSession().clear();
/* 78 */       ts.rollback();
/* 79 */       request.setAttribute("notice", "填报志愿失败！！！");
/* 80 */       return mapping.findForward("error");
/*    */     } finally {
/* 82 */       wdao.getSession().close();
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.stu.StuapplysaveAction
 * JD-Core Version:    0.5.4
 */