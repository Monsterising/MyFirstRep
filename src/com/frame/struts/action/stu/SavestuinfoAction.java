/*    */ package com.frame.struts.action.stu;
/*    */ 
/*    */ import com.entity.basedata.StuExtra;
/*    */ import com.entity.basedata.StuExtraDAO;
/*    */ import com.frame.struts.baseform.StuinfoForm;
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
/*    */ import pub.Qdao;
/*    */ import pub.toChi;
/*    */ 
/*    */ public class SavestuinfoAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 47 */     StuinfoForm sform = (StuinfoForm)form;
/* 48 */     HttpSession session = request.getSession();
/* 49 */     if (session.getAttribute("stucode") == null) {
/* 50 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 51 */       return mapping.findForward("error");
/*    */     }
/*    */ 
/* 54 */     String stucode = (String)session.getAttribute("stucode");
/*    */ 
/* 56 */     String hql = "";
/* 57 */     hql = "update StuList set stupass='" + sform.getStupass().trim() + "' where stucode='" + stucode + "'";
/* 58 */     Qdao qdao = new Qdao();
/* 59 */     qdao.update(hql);
/*    */ 
/* 62 */     toChi tochi = new toChi();
/* 63 */     StuExtra stuextra = new StuExtra();
/* 64 */     StuExtraDAO sdao = new StuExtraDAO();
/* 65 */     if (sdao.getSession().get(StuExtra.class, stucode) != null) {
/* 66 */       stuextra = (StuExtra)sdao.getSession().get(StuExtra.class, stucode);
/*    */     }
/* 68 */     stuextra.setStucode(stucode);
/* 69 */     stuextra.setStuemail(sform.getStuemail());
/* 70 */     stuextra.setStuhonor(tochi.toChinese(sform.getStuhonor()));
/* 71 */     stuextra.setStuplan(tochi.toChinese(sform.getStuplan()));
/* 72 */     stuextra.setStuqq(sform.getStuqq());
/* 73 */     stuextra.setStuskill(tochi.toChinese(sform.getStuskill()));
/* 74 */     stuextra.setStutel(sform.getStutel());
/* 75 */     stuextra.setStutel2(sform.getStutel2());
/*    */ 
/* 77 */     Transaction ts = sdao.getSession().beginTransaction();
/*    */     ActionForward localActionForward;
/*    */     try {
/* 80 */       sdao.getSession().saveOrUpdate(stuextra);
/*    */ 
/* 82 */       ts.commit();
/* 83 */       sdao.getSession().flush();
/* 84 */       request.setAttribute("notice", "设置个人资料成功！");
/* 85 */       return mapping.findForward("success");
/*    */     } catch (RuntimeException re) {
/* 87 */       System.out.println("异常信息：" + re);
/* 88 */       sdao.getSession().clear();
/* 89 */       ts.rollback();
/* 90 */       request.setAttribute("notice", "设置个人信息失败！！！");
/* 91 */       return mapping.findForward("error");
/*    */     } finally {
/* 93 */       sdao.getSession().close();
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.stu.SavestuinfoAction
 * JD-Core Version:    0.5.4
 */