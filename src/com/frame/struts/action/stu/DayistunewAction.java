/*    */ package com.frame.struts.action.stu;
/*    */ 
/*    */ import com.entity.basedata.TecList;
/*    */ import com.entity.basedata.TecListDAO;
/*    */ import com.entity.wish.Xuanti;
/*    */ import com.entity.wish.XuantiDAO;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.apache.struts.action.Action;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ 
/*    */ public class DayistunewAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 45 */     HttpSession session = request.getSession();
/* 46 */     if (session.getAttribute("stucode") == null) {
/* 47 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 48 */       return mapping.findForward("error");
/*    */     }
/* 50 */     String stucode = session.getAttribute("stucode").toString();
/* 51 */     request.setAttribute("stucode", stucode);
/*    */ 
/* 55 */     XuantiDAO xdao = new XuantiDAO();
/* 56 */     Xuanti xuanti = new Xuanti();
/* 57 */     xuanti = xdao.findById(stucode);
/* 58 */     if (xuanti == null) {
/* 59 */       request.setAttribute("notice", "您暂且没有指导教师");
/* 60 */       return mapping.findForward("error");
/*    */     }
/* 62 */     TecList tec = new TecList();
/* 63 */     TecListDAO tdao = new TecListDAO();
/* 64 */     tec = tdao.findById(xuanti.getTeccode());
/* 65 */     request.setAttribute("tecname", "你的指导教师是 " + tec.getTecname());
/* 66 */     request.setAttribute("isok", Integer.valueOf(0));
/*    */ 
/* 68 */     return mapping.findForward("display");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.stu.DayistunewAction
 * JD-Core Version:    0.5.4
 */