/*    */ package com.frame.struts.action.depart;
/*    */ 
/*    */ import com.entity.wish.ApplyType;
/*    */ import com.entity.wish.ApplyTypeDAO;
/*    */ import com.frame.struts.form.wish.SaveApplyTypeForm;
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
/*    */ public class SaveApplyTypeAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 43 */     SaveApplyTypeForm sform = (SaveApplyTypeForm)form;
/* 44 */     toChi tochi = new toChi();
/* 45 */     Integer departid = sform.getDepartid();
/* 46 */     Integer id = sform.getId();
/* 47 */     String typename = tochi.toChinese(sform.getTypename().trim());
/*    */ 
/* 49 */     ApplyType apply = new ApplyType();
/* 50 */     ApplyTypeDAO adao = new ApplyTypeDAO();
/*    */ 
/* 53 */     if ((id != null) && (adao.getSession().get(ApplyType.class, id) != null)) {
/* 54 */       apply = (ApplyType)adao.getSession().get(ApplyType.class, id);
/*    */     }
/*    */ 
/* 57 */     apply.setDepartid(departid);
/*    */ 
/* 59 */     apply.setTypename(typename);
/*    */ 
/* 61 */     Transaction ts = adao.getSession().beginTransaction();
/*    */     try {
/* 63 */       adao.getSession().saveOrUpdate(apply);
/* 64 */       ts.commit();
/* 65 */       adao.getSession().flush();
/* 66 */       request.setAttribute("notice", "设置 内容性质 资料成功！");
/* 67 */       return mapping.findForward("display");
/*    */     } catch (RuntimeException re) {
/* 69 */       System.out.println("异常信息：" + re);
/* 70 */       adao.getSession().clear();
/* 71 */       ts.rollback();
/* 72 */       request.setAttribute("notice", "设置内容性质失败！！！");
/* 73 */     }return mapping.findForward("error");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.SaveApplyTypeAction
 * JD-Core Version:    0.5.4
 */