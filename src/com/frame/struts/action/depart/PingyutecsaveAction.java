/*    */ package com.frame.struts.action.depart;
/*    */ 
/*    */ import com.entity.pingyue.PingyuTec;
/*    */ import com.entity.pingyue.PingyuTecDAO;
/*    */ import com.frame.struts.form.pingyue.PingyutecForm;
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
/*    */ public class PingyutecsaveAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 49 */     PingyutecForm pform = (PingyutecForm)form;
/* 50 */     HttpSession session = request.getSession();
/* 51 */     if (session.getAttribute("teccode") == null) {
/* 52 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 53 */       return mapping.findForward("error");
/*    */     }
/* 55 */     String teccode = session.getAttribute("teccode").toString();
/*    */ 
/* 57 */     PingyuTec pt = new PingyuTec();
/* 58 */     PingyuTecDAO ptdao = new PingyuTecDAO();
/* 59 */     if ((pform.getPytid() != null) && (pform.getPytid().intValue() != 0)) {
/* 60 */       pt = ptdao.findById(pform.getPytid());
/*    */     } else {
/* 62 */       Qdao qdao = new Qdao();
/* 63 */       String hql = "";
/* 64 */       hql = "delete PingyuTec where stucode='" + pform.getStucode() + "'";
/* 65 */       qdao.del(hql);
/*    */     }
/* 67 */     toChi tochi = new toChi();
/* 68 */     Date uptime = new Date();
/* 69 */     pt.setChengji(tochi.toChinese(pform.getChengji()));
/* 70 */     pt.setPingyu(tochi.toChinese(pform.getPingyu()));
/* 71 */     pt.setStucode(pform.getStucode());
/* 72 */     pt.setTeccode(teccode);
/* 73 */     pt.setUptime(uptime);
/* 74 */     Transaction ts = ptdao.getSession().beginTransaction();
/*    */     try {
/* 76 */       ptdao.getSession().saveOrUpdate(pt);
/* 77 */       ptdao.getSession().flush();
/* 78 */       ts.commit();
/* 79 */       ptdao.getSession().close();
/* 80 */       request.setAttribute("notice", "指导教师评语提交成功");
/* 81 */       return mapping.findForward("list");
/*    */     } catch (RuntimeException re) {
/* 83 */       System.out.println("异常信息：" + re);
/* 84 */       ptdao.getSession().clear();
/* 85 */       ts.rollback();
/* 86 */       request.setAttribute("notice", "指导教师评语 失败！！！");
/* 87 */     }return mapping.findForward("error");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.PingyutecsaveAction
 * JD-Core Version:    0.5.4
 */