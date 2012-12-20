/*    */ package com.frame.struts.action.college;
/*    */ 
/*    */ import com.entity.basedata.CollegeList;
/*    */ import com.entity.basedata.CollegeListDAO;
/*    */ import com.entity.basedata.CollegeSetup;
/*    */ import com.entity.basedata.CollegeSetupDAO;
/*    */ import com.frame.struts.form.college.CollegeSetupForm;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.apache.struts.action.Action;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ 
/*    */ public class CollegeSetupAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 44 */     CollegeSetupForm cform = (CollegeSetupForm)form;
/* 45 */     HttpSession session = request.getSession();
/* 46 */     if (session.getAttribute("adminid") == null) {
/* 47 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 48 */       return mapping.findForward("error");
/*    */     }
/* 50 */     Integer collegeid = Integer.valueOf(Integer.parseInt(session.getAttribute("collegeid").toString()));
/* 51 */     CollegeList collegelist = new CollegeList();
/* 52 */     CollegeListDAO cdao = new CollegeListDAO();
/* 53 */     collegelist = cdao.findById(collegeid);
/* 54 */     request.setAttribute("collegeid", collegelist.getCollegeid());
/* 55 */     request.setAttribute("collegename", collegelist.getCollegename());
/*    */ 
/* 58 */     CollegeSetup cs = new CollegeSetup();
/* 59 */     CollegeSetupDAO csdao = new CollegeSetupDAO();
/* 60 */     cs = csdao.findById(collegelist.getCollegeid());
/* 61 */     if (cs != null) {
/* 62 */       request.setAttribute("datestart", cs.getDatestart());
/* 63 */       request.setAttribute("dateover", cs.getDateover());
/*    */     }
/*    */ 
/* 67 */     return mapping.findForward("display");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.CollegeSetupAction
 * JD-Core Version:    0.5.4
 */