/*    */ package com.frame.struts.action.stu;
/*    */ 
/*    */ import com.entity.dabian.Zhaiyao;
/*    */ import com.entity.dabian.ZhaiyaoDAO;
/*    */ import com.frame.struts.form.dabian.ZhaiyaoForm;
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
/*    */ public class ZhaiyaostusaveAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 45 */     ZhaiyaoForm zyform = (ZhaiyaoForm)form;
/* 46 */     HttpSession session = request.getSession();
/* 47 */     if (session.getAttribute("stucode") == null) {
/* 48 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 49 */       return mapping.findForward("error");
/*    */     }
/* 51 */     String stucode = session.getAttribute("stucode").toString();
/*    */ 
/* 54 */     toChi tochi = new toChi();
/* 55 */     Zhaiyao zy = new Zhaiyao();
/* 56 */     ZhaiyaoDAO zydao = new ZhaiyaoDAO();
/* 57 */     if (zydao.getSession().get(Zhaiyao.class, stucode) != null) {
/* 58 */       zy = zydao.findById(stucode);
/*    */     }
/* 60 */     zy.setStucode(stucode);
/* 61 */     zy.setContent(tochi.toChinese(zyform.getContent()));
/* 62 */     zy.setKeyword(tochi.toChinese(zyform.getKeywords()));
/*    */ 
/* 64 */     Transaction ts = zydao.getSession().beginTransaction();
/*    */     try {
/* 66 */       zydao.getSession().saveOrUpdate(zy);
/* 67 */       zydao.getSession().flush();
/* 68 */       ts.commit();
/* 69 */       zydao.getSession().close();
/* 70 */       request.setAttribute("notice", "提交 成功");
/*    */     } catch (RuntimeException re) {
/* 72 */       System.out.println("异常信息：" + re);
/* 73 */       zydao.getSession().clear();
/* 74 */       ts.rollback();
/* 75 */       request.setAttribute("notice", "提交失败！！！");
/* 76 */       return mapping.findForward("error");
/*    */     }
/* 78 */     return mapping.findForward("display");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.stu.ZhaiyaostusaveAction
 * JD-Core Version:    0.5.4
 */