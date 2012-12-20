/*    */ package com.frame.struts.action.pingyue;
/*    */ 
/*    */ import com.entity.pingyue.PingyuGroup;
/*    */ import com.entity.pingyue.PingyuGroupDAO;
/*    */ import com.frame.struts.form.pingyue.PingyueshezhiForm;
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
/*    */ 
/*    */ public class PingyueshezhisaveAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 45 */     PingyueshezhiForm pform = (PingyueshezhiForm)form;
/* 46 */     HttpSession session = request.getSession();
/* 47 */     if (session.getAttribute("teccode") == null) {
/* 48 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 49 */       return mapping.findForward("error");
/*    */     }
/*    */ 
/* 52 */     if (session.getAttribute("usershenfen") == null) {
/* 53 */       request.setAttribute("notice", "您没有该项权限！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 54 */       return mapping.findForward("error");
/*    */     }
/*    */ 
/* 57 */     String[] stucodes = pform.getStucodes();
/* 58 */     String teccode = pform.getTeccode();
/* 59 */     Integer departid = pform.getDepartid();
/* 60 */     Integer gradeid = pform.getGradeid();
/*    */ 
/* 63 */     Qdao qdao = new Qdao();
/* 64 */     String hql = "";
/* 65 */     hql = "delete PingyuGroup where teccode='" + teccode + "' and gradeid=" + gradeid;
/* 66 */     qdao.del(hql);
/*    */ 
/* 70 */     if (stucodes != null) {
/* 71 */       PingyuGroupDAO pdao = new PingyuGroupDAO();
/* 72 */       Transaction ts = pdao.getSession().beginTransaction();
/* 73 */       for (int i = 0; i < stucodes.length; ++i) {
/* 74 */         PingyuGroup pyg = new PingyuGroup();
/* 75 */         pyg.setDepartid(departid);
/* 76 */         pyg.setGradeid(gradeid);
/* 77 */         pyg.setStucode(stucodes[i]);
/* 78 */         pyg.setTeccode(teccode);
/* 79 */         pdao.getSession().save(pyg);
/* 80 */       }pdao.getSession().flush();
/* 81 */       pdao.getSession().clear();
/* 82 */       ts.commit();
/*    */     }
/*    */ 
/* 85 */     return mapping.findForward("success");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.pingyue.PingyueshezhisaveAction
 * JD-Core Version:    0.5.4
 */