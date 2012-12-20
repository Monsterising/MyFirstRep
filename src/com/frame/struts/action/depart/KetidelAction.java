/*    */ package com.frame.struts.action.depart;
/*    */ 
/*    */ import com.entity.wish.ApplyState;
/*    */ import com.entity.wish.ApplyStateDAO;
/*    */ import com.entity.wish.ApplyTec;
/*    */ import com.entity.wish.ApplyTecDAO;
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
/*    */ public class KetidelAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 48 */     HttpSession session = request.getSession();
/* 49 */     if (session.getAttribute("teccode") == null) {
/* 50 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 51 */       return mapping.findForward("error");
/*    */     }
/*    */ 
/* 54 */     Integer id = Integer.valueOf(Integer.parseInt(request.getParameter("id")));
/* 55 */     Integer departid = Integer.valueOf(Integer.parseInt(request.getParameter("departid")));
/* 56 */     ApplyTec r = new ApplyTec();
/* 57 */     ApplyTecDAO rdao = new ApplyTecDAO();
/* 58 */     r = (ApplyTec)rdao.getSession().get(ApplyTec.class, id);
/*    */ 
/* 61 */     ApplyState as = new ApplyState();
/* 62 */     ApplyStateDAO asdao = new ApplyStateDAO();
/* 63 */     as = asdao.findById(id);
/* 64 */     Transaction tsas = asdao.getSession().beginTransaction();
/*    */     try {
/* 66 */       asdao.delete(as);
/* 67 */       tsas.commit();
/*    */     } catch (RuntimeException re) {
/* 69 */       System.out.println("异常信息：" + re);
/* 70 */       asdao.getSession().clear();
/* 71 */       tsas.rollback();
/* 72 */       request.setAttribute("notice", "编辑课题  资料失败！！！");
/* 73 */       return mapping.findForward("error");
/*    */     }
/*    */ 
/* 77 */     Transaction ts = rdao.getSession().beginTransaction();
/*    */     ActionForward localActionForward;
/*    */     try {
/* 79 */       rdao.delete(r);
/* 80 */       ts.commit();
/* 81 */       request.setAttribute("notice", "成功删除  数据！");
/* 82 */       request.setAttribute("departid", departid);
/* 83 */       return mapping.findForward("success");
/*    */     } catch (RuntimeException re) {
/* 85 */       ts.rollback();
/* 86 */       request.setAttribute("notice", " 删除失败！");
/* 87 */       return mapping.findForward("error");
/*    */     } finally {
/* 89 */       rdao.getSession().close();
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.KetidelAction
 * JD-Core Version:    0.5.4
 */