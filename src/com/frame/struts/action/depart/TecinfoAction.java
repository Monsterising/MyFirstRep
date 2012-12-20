/*    */ package com.frame.struts.action.depart;
/*    */ 
/*    */ import com.entity.basedata.TecExtra;
/*    */ import com.entity.basedata.TecExtraDAO;
/*    */ import com.entity.basedata.TecList;
/*    */ import com.entity.basedata.TecListDAO;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.apache.struts.action.Action;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ import org.hibernate.Session;
/*    */ 
/*    */ public class TecinfoAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 45 */     HttpSession session = request.getSession();
/* 46 */     if ((session.getAttribute("stucode") == null) && (session.getAttribute("teccode") == null)) {
/* 47 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 48 */       return mapping.findForward("error");
/*    */     }
/*    */ 
/* 52 */     String teccode = (String)session.getAttribute("teccode");
/*    */ 
/* 54 */     if (session.getAttribute("teccode") != null) {
/* 55 */       teccode = (String)session.getAttribute("teccode");
/* 56 */       request.setAttribute("disable", "d");
/*    */     }
/* 58 */     if (request.getParameter("s") != null) {
/* 59 */       teccode = request.getParameter("s").toString();
/* 60 */       request.setAttribute("disable", "disabled");
/*    */     }
/*    */ 
/* 64 */     TecList tec = new TecList();
/* 65 */     TecListDAO tdao = new TecListDAO();
/* 66 */     tec = tdao.findById(teccode);
/* 67 */     request.setAttribute("TecList", tec);
/*    */ 
/* 70 */     TecExtra tecextra = new TecExtra();
/* 71 */     TecExtraDAO edao = new TecExtraDAO();
/*    */ 
/* 73 */     if (edao.getSession().get(TecExtra.class, teccode) == null) {
/* 74 */       request.setAttribute("notice", "您还没有补充个人信息，请及时填写！");
/*    */     } else {
/* 76 */       tecextra = (TecExtra)edao.getSession().get(TecExtra.class, teccode);
/* 77 */       request.setAttribute("TecExtra", tecextra);
/*    */     }
/*    */ 
/* 80 */     return mapping.findForward("display");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.TecinfoAction
 * JD-Core Version:    0.5.4
 */