/*    */ package com.frame.struts.action.college;
/*    */ 
/*    */ import com.entity.basedata.CollegeListDAO;
/*    */ import com.entity.basedata.CollegeUser;
/*    */ import com.entity.basedata.CollegeUserDAO;
/*    */ import com.entity.basedata.DepartListDAO;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.apache.struts.action.Action;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ 
/*    */ public class DepartlistAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 43 */     HttpSession session = request.getSession();
/* 44 */     if (session.getAttribute("adminid") == null) {
/* 45 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 46 */       return mapping.findForward("error");
/*    */     }
/* 48 */     Integer userid = Integer.valueOf(Integer.parseInt(session.getAttribute("adminid").toString()));
/*    */     Integer collegeid;
/*    */     
/* 52 */     if (request.getParameter("id") == null)
/* 53 */       collegeid = Integer.valueOf(Integer.parseInt(session.getAttribute("collegeid").toString()));
/*    */     else {
/* 55 */       collegeid = Integer.valueOf(Integer.parseInt(request.getParameter("id").toString()));
/*    */     }
/*    */ 
/* 59 */     DepartListDAO dao = new DepartListDAO();
/* 60 */     List departlist = dao.findByCollegeid(collegeid);
/* 61 */     request.setAttribute("departlist", departlist);
/* 62 */     request.setAttribute("collegeid", collegeid);
/*    */ 
/* 65 */     String op = "ok";
/* 66 */     CollegeUser cu = new CollegeUser();
/* 67 */     CollegeUserDAO cudao = new CollegeUserDAO();
/* 68 */     cu = (CollegeUser)cudao.findByUserid(userid).get(0);
/* 69 */     if (collegeid.compareTo(cu.getCollegeid()) != 0)
/*    */     {
/* 72 */       op = "no";
/* 73 */     }request.setAttribute("op", op);
/*    */ 
/* 78 */     CollegeListDAO cdao = new CollegeListDAO();
/* 79 */     List collegelist = cdao.findAll();
/* 80 */     request.setAttribute("collegelist", collegelist);
/*    */ 
/* 82 */     return mapping.findForward("display");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.DepartlistAction
 * JD-Core Version:    0.5.4
 */