/*    */ package com.frame.struts.action.college;
/*    */ 
/*    */ import com.entity.basedata.ClassListDAO;
/*    */ import com.entity.basedata.CollegeList;
/*    */ import com.entity.basedata.CollegeListDAO;
/*    */ import com.entity.basedata.DepartListDAO;
/*    */ import com.entity.basedata.GradeListDAO;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.apache.struts.action.Action;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ 
/*    */ public class AddStusAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 50 */     HttpSession session = request.getSession();
/* 51 */     if (session.getAttribute("adminid") == null) {
/* 52 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 53 */       return mapping.findForward("error");
/*    */     }
/* 55 */     Integer collegeid = Integer.valueOf(Integer.parseInt(session.getAttribute("collegeid").toString()));
/* 56 */     CollegeList collegelist = new CollegeList();
/* 57 */     CollegeListDAO cdao = new CollegeListDAO();
/* 58 */     collegelist = cdao.findById(collegeid);
/* 59 */     request.setAttribute("CollegeList", collegelist);
/*    */ 
/* 62 */     DepartListDAO ddao = new DepartListDAO();
/* 63 */     List departlist = ddao.findByCollegeid(collegeid);
/* 64 */     request.setAttribute("departlist", departlist);
/*    */ 
/* 67 */     List gradelist = null;
/* 68 */     GradeListDAO gdao = new GradeListDAO();
/* 69 */     String id = request.getParameter("departid");
/* 70 */     if (id == null) {
/* 71 */       gradelist = null;
/* 72 */       request.setAttribute("departid", Integer.valueOf(0));
/*    */     } else {
/* 74 */       Integer departid = Integer.valueOf(Integer.parseInt(id));
/* 75 */       gradelist = gdao.findByDepartid(departid);
/* 76 */       request.setAttribute("departid", departid);
/* 77 */     }request.setAttribute("gradelist", gradelist);
/*    */ 
/* 80 */     List classlist = null;
/* 81 */     ClassListDAO classdao = new ClassListDAO();
/* 82 */     id = request.getParameter("gradeid");
/* 83 */     if (id == null) {
/* 84 */       classlist = null;
/* 85 */       request.setAttribute("gradeid", Integer.valueOf(0));
/*    */     } else {
/* 87 */       Integer gradeid = Integer.valueOf(Integer.parseInt(id));
/* 88 */       classlist = classdao.findByGradeid(gradeid);
/* 89 */       request.setAttribute("gradeid", gradeid);
/* 90 */     }request.setAttribute("classlist", classlist);
/*    */ 
/* 94 */     return mapping.findForward("display");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.AddStusAction
 * JD-Core Version:    0.5.4
 */