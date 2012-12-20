/*    */ package com.frame.struts.action.stu;
/*    */ 
/*    */ import com.entity.basedata.StuExtra;
/*    */ import com.entity.basedata.StuExtraDAO;
/*    */ import com.entity.basedata.StuList;
/*    */ import com.entity.basedata.StuListDAO;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.apache.struts.action.Action;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ import org.hibernate.Session;
/*    */ 
/*    */ public class StuinfoAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 44 */     HttpSession session = request.getSession();
/* 45 */     if ((session.getAttribute("stucode") == null) && (session.getAttribute("teccode") == null)) {
/* 46 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 47 */       return mapping.findForward("error");
/*    */     }
/*    */ 
/* 51 */     String stucode = "";
/* 52 */     if (session.getAttribute("stucode") != null) {
/* 53 */       stucode = (String)session.getAttribute("stucode");
/* 54 */       request.setAttribute("disable", "d");
/*    */     }
/* 56 */     if (request.getParameter("s") != null) {
/* 57 */       stucode = request.getParameter("s").toString();
/* 58 */       request.setAttribute("disable", "disabled");
/*    */     }
/*    */ 
/* 62 */     StuList stu = new StuList();
/* 63 */     StuListDAO studao = new StuListDAO();
/* 64 */     stu = (StuList)studao.getSession().get(StuList.class, stucode);
/* 65 */     request.setAttribute("StuList", stu);
/*    */ 
/* 68 */     StuExtra stuextra = new StuExtra();
/* 69 */     StuExtraDAO sdao = new StuExtraDAO();
/* 70 */     if (sdao.getSession().get(StuExtra.class, stu.getStucode()) == null) {
/* 71 */       request.setAttribute("notice", "还没有补充个人信息，请及时填写！");
/*    */     } else {
/* 73 */       stuextra = (StuExtra)sdao.getSession().get(StuExtra.class, stu.getStucode());
/* 74 */       request.setAttribute("StuExtra", stuextra);
/*    */     }
/*    */ 
/* 78 */     return mapping.findForward("display");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.stu.StuinfoAction
 * JD-Core Version:    0.5.4
 */