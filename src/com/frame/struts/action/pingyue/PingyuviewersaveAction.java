/*    */ package com.frame.struts.action.pingyue;
/*    */ 
/*    */ import com.entity.pingyue.PingyuViewer;
/*    */ import com.entity.pingyue.PingyuViewerDAO;
/*    */ import com.frame.struts.form.pingyue.PingyuviewerForm;
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
/*    */ import pub.Qdao;
/*    */ import pub.toChi;
/*    */ 
/*    */ public class PingyuviewersaveAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 51 */     PingyuviewerForm pform = (PingyuviewerForm)form;
/*    */ 
/* 53 */     HttpSession session = request.getSession();
/* 54 */     if (session.getAttribute("teccode") == null) {
/* 55 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 56 */       return mapping.findForward("error");
/*    */     }
/* 58 */     String teccode = session.getAttribute("teccode").toString();
/*    */ 
/* 62 */     PingyuViewer pv = new PingyuViewer();
/* 63 */     PingyuViewerDAO pvdao = new PingyuViewerDAO();
/* 64 */     if ((pform.getPyvid() != null) && (pform.getPyvid().intValue() != 0))
/*    */     {
/* 67 */       pv = pvdao.findById(pform.getPyvid());
/*    */     } else {
/* 69 */       Qdao qdao = new Qdao();
/* 70 */       String hql = "";
/* 71 */       hql = "delete PingyuViewer where stucode='" + pform.getStucode() + "' and teccode='" + teccode + "'";
/* 72 */       qdao.del(hql);
/*    */     }
/* 74 */     toChi tochi = new toChi();
/* 75 */     Date uptime = new Date();
/* 76 */     pv.setPingyu(tochi.toChinese(pform.getPingyu()));
/* 77 */     pv.setStucode(pform.getStucode());
/* 78 */     pv.setTeccode(teccode);
/* 79 */     pv.setUptime(uptime);
/*    */ 
/* 83 */     Transaction ts = pvdao.getSession().beginTransaction();
/*    */     try {
/* 85 */       pvdao.getSession().saveOrUpdate(pv);
/* 86 */       pvdao.getSession().flush();
/* 87 */       ts.commit();
/* 88 */       pvdao.getSession().close();
/* 89 */       request.setAttribute("notice", "评阅人评语提交成功");
/* 90 */       return mapping.findForward("list");
/*    */     } catch (RuntimeException re) {
/* 92 */       System.out.println("异常信息：" + re);
/* 93 */       pvdao.getSession().clear();
/* 94 */       ts.rollback();
/* 95 */       request.setAttribute("notice", "评阅人评语 失败！！！");
/* 96 */     }return mapping.findForward("error");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.pingyue.PingyuviewersaveAction
 * JD-Core Version:    0.5.4
 */