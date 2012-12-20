/*    */ package com.frame.struts.action.college;
/*    */ 
/*    */ import com.entity.basedata.ClassList;
/*    */ import com.entity.basedata.ClassListDAO;
/*    */ import com.entity.basedata.CollegeList;
/*    */ import com.entity.basedata.CollegeListDAO;
/*    */ import com.entity.basedata.DepartListDAO;
/*    */ import com.entity.basedata.GradeListDAO;
/*    */ import com.frame.struts.baseform.AddclassForm;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.apache.struts.action.Action;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ 
/*    */ public class AddclassAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 52 */     HttpSession session = request.getSession();
/* 53 */     if (session.getAttribute("adminid") == null) {
/* 54 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 55 */       return mapping.findForward("error");
/*    */     }
/* 57 */     Integer collegeid = Integer.valueOf(Integer.parseInt(session.getAttribute("collegeid").toString()));
/* 58 */     CollegeList collegelist = new CollegeList();
/* 59 */     CollegeListDAO cdao = new CollegeListDAO();
/* 60 */     collegelist = cdao.findById(collegeid);
/* 61 */     request.setAttribute("CollegeList", collegelist);
/*    */ 
/* 64 */     DepartListDAO ddao = new DepartListDAO();
/* 65 */     List departlist = ddao.findByCollegeid(collegeid);
/* 66 */     request.setAttribute("departlist", departlist);
/*    */ 
/* 69 */     List gradelist = null;
/* 70 */     GradeListDAO gdao = new GradeListDAO();
/* 71 */     String id = request.getParameter("departid");
/* 72 */     if (id == null) {
/* 73 */       gradelist = null;
/* 74 */       request.setAttribute("departid", Integer.valueOf(0));
/*    */     } else {
/* 76 */       Integer departid = Integer.valueOf(Integer.parseInt(id));
/* 77 */       gradelist = gdao.findByDepartid(departid);
/* 78 */       request.setAttribute("departid", departid);
/* 79 */     }request.setAttribute("gradelist", gradelist);
/*    */ 
/* 81 */     String op = request.getParameter("op");
/* 82 */     if (op.equals("")) op = "tjia";
/* 83 */     if (op.equals("edit")) {
/* 84 */       AddclassForm aform = (AddclassForm)form;
/* 85 */       request.setAttribute("op", "edit");
/* 86 */       Integer classid = Integer.valueOf(Integer.parseInt(request.getParameter("cid")));
/* 87 */       ClassListDAO classdao = new ClassListDAO();
/* 88 */       ClassList classlist = new ClassList();
/* 89 */       classlist = classdao.findById(classid);
/* 90 */       request.setAttribute("departdisable", "disabled");
/* 91 */       request.setAttribute("ClassList", classlist);
/*    */     } else {
/* 93 */       request.setAttribute("op", "tjia");
/*    */     }
/*    */ 
/* 99 */     return mapping.findForward("display");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.AddclassAction
 * JD-Core Version:    0.5.4
 */