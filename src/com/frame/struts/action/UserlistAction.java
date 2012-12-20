/*    */ package com.frame.struts.action;
/*    */ 
/*    */ import com.entity.basedata.CollegeListDAO;
/*    */ import com.entity.basedata.CollegeUser;
/*    */ import com.entity.basedata.CollegeUserDAO;
/*    */ import com.entity.basedata.Users;
/*    */ import com.entity.basedata.UsersDAO;
/*    */ import com.frame.struts.baseform.UseraddForm;
/*    */ import java.io.PrintStream;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.apache.struts.action.Action;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ 
/*    */ public class UserlistAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 49 */     UseraddForm useraddForm = (UseraddForm)form;
/* 50 */     HttpSession session = request.getSession();
/* 51 */     if (session.getAttribute("adminid") == null) {
/* 52 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 53 */       return mapping.findForward("error");
/*    */     }
/* 55 */     Integer adminid = Integer.valueOf(Integer.parseInt(session.getAttribute("adminid").toString()));
/* 56 */     System.out.println("session中adminid=" + adminid);
/* 57 */     Users users = new Users();
/* 58 */     UsersDAO udao = new UsersDAO();
/* 59 */     List userlist = udao.findAll();
/* 60 */     users = udao.findById(adminid);
/*    */ 
/* 62 */     CollegeUser cu = new CollegeUser();
/* 63 */     CollegeUserDAO cudao = new CollegeUserDAO();
/* 64 */     List culist = cudao.findAll();
/* 65 */     System.out.println("culist.userid=" + ((CollegeUser)culist.get(0)).getUserid());
/* 66 */     List culist2 = cudao.findByUserid(adminid);
/*    */ 
/* 75 */     CollegeListDAO cdao = new CollegeListDAO();
/* 76 */     List collegelist = cdao.findAll();
/*    */ 
/* 78 */     request.setAttribute("collegeuser", cu);
/* 79 */     request.setAttribute("Users", users);
/* 80 */     request.setAttribute("userlist", userlist);
/* 81 */     request.setAttribute("culist", culist);
/* 82 */     request.setAttribute("collegelist", collegelist);
/* 83 */     request.setAttribute("userrole", session.getAttribute("userrole"));
/*    */ 
/* 87 */     return mapping.findForward("display");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.UserlistAction
 * JD-Core Version:    0.5.4
 */