/*    */ package com.frame.struts.action.college;
/*    */ 
/*    */ import com.entity.pingyue.BiaozhunDAO;
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.apache.struts.action.Action;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ import pub.toChi;
/*    */ 
/*    */ public class BiaozhunlistAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */     throws UnsupportedEncodingException
/*    */   {
/* 48 */     HttpSession session = request.getSession();
/* 49 */     if (session.getAttribute("adminid") == null) {
/* 50 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 51 */       return mapping.findForward("error");
/*    */     }
/* 53 */     String type = "";
/* 54 */     BiaozhunDAO bdao = new BiaozhunDAO();
/*    */ 
/* 56 */     toChi tochi = new toChi();
/*    */     List blist;
/* 60 */     if ((request.getParameter("type") != null) && (!request.getParameter("type").equals(""))) {
/* 61 */       type = request.getParameter("type");
/*    */ 
/* 63 */       blist = bdao.findByType(type);
/* 64 */       request.setAttribute("type", type);
/*    */     } else {
/* 66 */       blist = bdao.findAll();
/*    */     }
/* 68 */     request.setAttribute("blist", blist);
/*    */ 
/* 71 */     return mapping.findForward("display");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.BiaozhunlistAction
 * JD-Core Version:    0.5.4
 */