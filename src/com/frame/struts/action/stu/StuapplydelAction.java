/*    */ package com.frame.struts.action.stu;
/*    */ 
/*    */ import com.entity.wish.StuWish;
/*    */ import com.entity.wish.StuWishDAO;
/*    */ import com.frame.hibernate.HibernateSessionFactory;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.apache.struts.action.Action;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ import org.hibernate.Query;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.Transaction;
/*    */ import pub.Qdao;
/*    */ 
/*    */ public class StuapplydelAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 52 */     HttpSession session = request.getSession();
/* 53 */     if (session.getAttribute("stucode") == null) {
/* 54 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 55 */       return mapping.findForward("error");
/*    */     }
/*    */ 
/* 58 */     String stucode = (String)session.getAttribute("stucode");
/* 59 */     Integer wishid = Integer.valueOf(Integer.parseInt(request.getParameter("id").toString()));
/* 60 */     StuWish stuwish = new StuWish();
/* 61 */     StuWishDAO wdao = new StuWishDAO();
/* 62 */     stuwish = wdao.findById(wishid);
/* 63 */     Integer priority = stuwish.getPriority();
/*    */ 
/* 65 */     if ((!stuwish.getStucode().equals(stucode)) || (stuwish.getWishstate().equals("通过"))) {
/* 66 */       request.setAttribute("notice", "您无权操作该志愿！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 67 */       return mapping.findForward("error");
/* 69 */     }Transaction ts = wdao.getSession().beginTransaction();
/*    */     ActionForward localActionForward;
/*    */     try {
/* 71 */       wdao.delete(stuwish);
/* 72 */       ts.commit();
/* 73 */       request.setAttribute("notice", "成功删除志愿！");
/*    */ 
/* 75 */       String genxin = request.getParameter("genxin");
/* 76 */       if ((genxin.equals("t")) && (priority.intValue() != 0))
/*    */       {
/* 78 */         Date date = new Date();
/* 79 */         SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 80 */         String dateup = sf.format(date);
/* 81 */         Qdao qdao = new Qdao();
/*    */ 
/* 83 */         String uhql = "update StuWish set priority=priority-1,dateup='" + dateup + "' where stucode='" + stucode + "' and priority>" + priority;
/*    */ 
/* 94 */         Transaction ts5 = HibernateSessionFactory.getSession().beginTransaction();
/* 95 */         Query queryObject5 = HibernateSessionFactory.getSession().createQuery(uhql);
/* 96 */         queryObject5.executeUpdate();
/* 97 */         ts5.commit();
/*    */       }
/*    */ 
/* 101 */       return mapping.findForward("success");
/*    */     } catch (RuntimeException re) {
/* 103 */       ts.rollback();
/* 104 */       request.setAttribute("notice", " 删除失败！");
/* 105 */       return mapping.findForward("error");
/*    */     } finally {
/* 107 */       wdao.getSession().close();
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.stu.StuapplydelAction
 * JD-Core Version:    0.5.4
 */