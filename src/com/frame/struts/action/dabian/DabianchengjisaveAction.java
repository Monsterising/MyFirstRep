/*    */ package com.frame.struts.action.dabian;
/*    */ 
/*    */ import com.entity.dabian.DabianChengji;
/*    */ import com.entity.dabian.DabianChengjiDAO;
/*    */ import com.frame.struts.form.DabianchengjiForm;
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
/*    */ public class DabianchengjisaveAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 51 */     DabianchengjiForm pform = (DabianchengjiForm)form;
/* 52 */     HttpSession session = request.getSession();
/* 53 */     if (session.getAttribute("teccode") == null) {
/* 54 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 55 */       return mapping.findForward("error");
/*    */     }
/* 57 */     String teccode = session.getAttribute("teccode").toString();
/*    */ 
/* 60 */     Qdao qdao = new Qdao();
/* 61 */     qdao.del("delete DabianChengji where stucode='" + pform.getStucode() + "'");
/*    */ 
/* 63 */     DabianChengji pv = new DabianChengji();
/* 64 */     DabianChengjiDAO pvdao = new DabianChengjiDAO();
/* 65 */     toChi tochi = new toChi();
/* 66 */     Date uptime = new Date();
/* 67 */     pv.setPingyu(tochi.toChinese(pform.getPingyu()));
/* 68 */     pv.setStucode(pform.getStucode());
/* 69 */     pv.setChengji(tochi.toChinese(pform.getChengji()));
/* 70 */     pv.setChengjitime(uptime);
/* 71 */     pv.setDbgid(pform.getDbgid());
/* 72 */     pv.setPingyutime(uptime);
/* 73 */     pv.setDbgid(pform.getDbgid());
/*    */ 
/* 77 */     Transaction ts = pvdao.getSession().beginTransaction();
/*    */     try {
/* 79 */       pvdao.getSession().save(pv);
/* 80 */       pvdao.getSession().flush();
/* 81 */       ts.commit();
/* 82 */       pvdao.getSession().close();
/* 83 */       request.setAttribute("notice", "答辩评语及成绩提交成功");
/* 84 */       if (session.getAttribute("type").equals("tec")) {
/* 85 */         return mapping.findForward("tec");
/*    */       }
/*    */ 
/* 88 */       return mapping.findForward("list");
/*    */     } catch (RuntimeException re) {
/* 90 */       System.out.println("异常信息：" + re);
/* 91 */       pvdao.getSession().clear();
/* 92 */       ts.rollback();
/* 93 */       request.setAttribute("notice", "答辩评语及成绩 失败！！！");
/* 94 */     }return mapping.findForward("error");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.dabian.DabianchengjisaveAction
 * JD-Core Version:    0.5.4
 */