/*    */ package com.frame.struts.action.college;
/*    */ 
/*    */ import com.entity.basedata.CollegeList;
/*    */ import com.entity.basedata.CollegeListDAO;
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
/*    */ public class AddtecAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 47 */     HttpSession session = request.getSession();
/* 48 */     if (session.getAttribute("adminid") == null) {
/* 49 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 50 */       return mapping.findForward("error");
/*    */     }
/* 52 */     Integer collegeid = Integer.valueOf(Integer.parseInt(session.getAttribute("collegeid").toString()));
/* 53 */     CollegeList collegelist = new CollegeList();
/* 54 */     CollegeListDAO cdao = new CollegeListDAO();
/* 55 */     collegelist = cdao.findById(collegeid);
/*    */ 
/* 58 */     DepartListDAO ddao = new DepartListDAO();
/* 59 */     List departlist = ddao.findByCollegeid(collegeid);
/*    */ 
/* 61 */     request.setAttribute("CollegeList", collegelist);
/* 62 */     request.setAttribute("departlist", departlist);
/*    */ 
/* 64 */     return mapping.findForward("display");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.AddtecAction
 * JD-Core Version:    0.5.4
 */