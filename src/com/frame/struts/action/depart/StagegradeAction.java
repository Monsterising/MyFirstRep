/*    */ package com.frame.struts.action.depart;
/*    */ 
/*    */ import com.entity.basedata.ClassList;
/*    */ import com.entity.basedata.ClassListDAO;
/*    */ import com.entity.basedata.CollegeList;
/*    */ import com.entity.basedata.CollegeListDAO;
/*    */ import com.entity.basedata.DepartList;
/*    */ import com.entity.basedata.DepartListDAO;
/*    */ import com.entity.basedata.GradeList;
/*    */ import com.entity.basedata.GradeListDAO;
/*    */ import com.entity.basedata.StuList;
/*    */ import com.entity.basedata.StuListDAO;
/*    */ import com.entity.task.Stagetask;
/*    */ import com.entity.task.StagetaskDAO;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.apache.struts.action.Action;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ 
/*    */ public class StagegradeAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 53 */     HttpSession session = request.getSession();
/* 54 */     if (session.getAttribute("teccode") == null) {
/* 55 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 56 */       return mapping.findForward("error");
/*    */     }
/* 58 */     String teccode = session.getAttribute("teccode").toString();
/* 59 */     Integer stid = Integer.valueOf(Integer.parseInt(request.getParameter("stid").toString()));
/*    */ 
/* 61 */     Stagetask stagetask = new Stagetask();
/* 62 */     StagetaskDAO sdao = new StagetaskDAO();
/* 63 */     stagetask = sdao.findById(stid);
/* 64 */     if (stagetask.getGrade().equals("0")) {
/* 65 */       request.setAttribute("result", stagetask.getNotes());
/*    */     } else {
/* 67 */       request.setAttribute("result", stagetask.getResult());
/* 68 */       request.setAttribute("grade", stagetask.getGrade());
/* 69 */     }request.setAttribute("stid", stagetask.getStid());
/*    */ 
/* 74 */     StuList stu = new StuList();
/* 75 */     StuListDAO studao = new StuListDAO();
/* 76 */     stu = studao.findById(stagetask.getStucode());
/* 77 */     DepartList depart = new DepartList();
/* 78 */     DepartListDAO departdao = new DepartListDAO();
/* 79 */     depart = departdao.findById(stu.getDepartid());
/* 80 */     request.setAttribute("StuList", stu);
/* 81 */     request.setAttribute("departname", depart.getDepartname());
/* 82 */     CollegeList college = new CollegeList();
/* 83 */     CollegeListDAO collegedao = new CollegeListDAO();
/* 84 */     college = collegedao.findById(stu.getCollegeid());
/* 85 */     request.setAttribute("collegename", college.getCollegename());
/* 86 */     ClassList stuclass = new ClassList();
/* 87 */     ClassListDAO classdao = new ClassListDAO();
/* 88 */     stuclass = classdao.findById(stu.getClassid());
/* 89 */     request.setAttribute("classname", stuclass.getClassname());
/* 90 */     GradeList grade = new GradeList();
/* 91 */     GradeListDAO gdao = new GradeListDAO();
/* 92 */     grade = gdao.findById(stu.getGradeid());
/* 93 */     request.setAttribute("gradename", grade.getGradename());
/*    */ 
/* 95 */     return mapping.findForward("display");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.StagegradeAction
 * JD-Core Version:    0.5.4
 */