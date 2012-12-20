/*    */ package com.frame.struts.action.depart;
/*    */ 
/*    */ import com.entity.wish.ApplyResult;
/*    */ import com.entity.wish.ApplyResultDAO;
/*    */ import com.frame.struts.form.wish.SaveApplyResultForm;
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
/*    */ public class SaveApplyResultAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 44 */     SaveApplyResultForm sform = (SaveApplyResultForm)form;
/*    */ 
/* 46 */     toChi tochi = new toChi();
/* 47 */     Integer departid = sform.getDepartid();
/* 48 */     Integer id = sform.getId();
/* 49 */     String resultname = tochi.toChinese(sform.getResultname().trim());
/*    */ 
/* 51 */     ApplyResult apply = new ApplyResult();
/* 52 */     ApplyResultDAO adao = new ApplyResultDAO();
/*    */ 
/* 55 */     if ((id != null) && (adao.getSession().get(ApplyResult.class, id) != null)) {
/* 56 */       apply = (ApplyResult)adao.getSession().get(ApplyResult.class, id);
/*    */     }
/*    */ 
/* 59 */     apply.setDepartid(departid);
/*    */ 
/* 61 */     apply.setResultname(resultname);
/*    */ 
/* 63 */     Transaction ts = adao.getSession().beginTransaction();
/*    */     try {
/* 65 */       adao.getSession().saveOrUpdate(apply);
/* 66 */       ts.commit();
/* 67 */       adao.getSession().flush();
/* 68 */       request.setAttribute("notice", "设置 专业 资料成功！");
/* 69 */       return mapping.findForward("display");
/*    */     } catch (RuntimeException re) {
/* 71 */       System.out.println("异常信息：" + re);
/* 72 */       adao.getSession().clear();
/* 73 */       ts.rollback();
/* 74 */       request.setAttribute("notice", "设置专业失败！！！");
/* 75 */     }return mapping.findForward("error");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.SaveApplyResultAction
 * JD-Core Version:    0.5.4
 */