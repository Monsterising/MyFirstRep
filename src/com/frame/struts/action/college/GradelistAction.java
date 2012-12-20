/*    */ package com.frame.struts.action.college;
/*    */ 
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
/*    */ public class GradelistAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 48 */     HttpSession session = request.getSession();
/* 49 */     if (session.getAttribute("adminid") == null) {
/* 50 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 51 */       return mapping.findForward("error");
/*    */     }
/* 53 */     Integer collegeid = Integer.valueOf(Integer.parseInt(session.getAttribute("collegeid").toString()));
/*    */ 
/* 56 */     DepartListDAO ddao = new DepartListDAO();
/* 57 */     List departlist = ddao.findByCollegeid(collegeid);
/* 58 */     request.setAttribute("collegeid", collegeid);
/* 59 */     request.setAttribute("departlist", departlist);
/*    */ 
/* 62 */     GradeListDAO gdao = new GradeListDAO();
/* 63 */     List gradelist = null;
/*    */ 
/* 66 */     String id = request.getParameter("id");
/* 67 */     Integer did = (Integer)request.getAttribute("departid");
/*    */ 
/* 69 */     if ((id == null) && (did == null)) {
/* 70 */       gradelist = gdao.findByCollegeid(collegeid);
/* 71 */       request.setAttribute("departid", Integer.valueOf(0));
/* 72 */     } else if ((id == null) && (did != null)) {
/* 73 */       Integer departid = did;
/* 74 */       gradelist = gdao.findByDepartid(departid);
/* 75 */       request.setAttribute("departid", departid);
/* 76 */     } else if (id.equals("0")) {
/* 77 */       gradelist = gdao.findByCollegeid(collegeid);
/* 78 */       request.setAttribute("departid", Integer.valueOf(0));
/*    */     } else {
/* 80 */       Integer departid = Integer.valueOf(Integer.parseInt(request.getParameter("id").toString()));
/* 81 */       gradelist = gdao.findByDepartid(departid);
/* 82 */       request.setAttribute("departid", departid);
/*    */     }
/* 84 */     request.setAttribute("op", "ok");
/* 85 */     request.setAttribute("gradelist", gradelist);
/*    */ 
/* 87 */     return mapping.findForward("display");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.GradelistAction
 * JD-Core Version:    0.5.4
 */