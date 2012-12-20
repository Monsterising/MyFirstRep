/*    */ package com.frame.struts.action.stu;
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
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.apache.struts.action.Action;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ import pub.Qdao;
/*    */ 
/*    */ public class StagetaskstuAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 56 */     HttpSession session = request.getSession();
/* 57 */     if (session.getAttribute("stucode") == null) {
/* 58 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 59 */       return mapping.findForward("error");
/*    */     }
/* 61 */     String stucode = session.getAttribute("stucode").toString();
/*    */ 
/* 64 */     StuList stu = new StuList();
/* 65 */     StuListDAO studao = new StuListDAO();
/* 66 */     stu = studao.findById(stucode);
/* 67 */     DepartList depart = new DepartList();
/* 68 */     DepartListDAO departdao = new DepartListDAO();
/* 69 */     depart = departdao.findById(stu.getDepartid());
/* 70 */     request.setAttribute("StuList", stu);
/* 71 */     request.setAttribute("departname", depart.getDepartname());
/* 72 */     CollegeList college = new CollegeList();
/* 73 */     CollegeListDAO collegedao = new CollegeListDAO();
/* 74 */     college = collegedao.findById(stu.getCollegeid());
/* 75 */     request.setAttribute("collegename", college.getCollegename());
/* 76 */     ClassList stuclass = new ClassList();
/* 77 */     ClassListDAO classdao = new ClassListDAO();
/* 78 */     stuclass = classdao.findById(stu.getClassid());
/* 79 */     request.setAttribute("classname", stuclass.getClassname());
/* 80 */     GradeList grade = new GradeList();
/* 81 */     GradeListDAO gdao = new GradeListDAO();
/* 82 */     grade = gdao.findById(stu.getGradeid());
/* 83 */     request.setAttribute("gradename", grade.getGradename());
/* 84 */     request.setAttribute("StuList", stu);
/*    */ 
/* 88 */     List stagetasklist = new LinkedList();
/* 89 */     Qdao qdao = new Qdao();
/* 90 */     String hql = "from Stagetask where stucode='" + stucode + "'";
/* 91 */     stagetasklist.addAll(qdao.query(hql));
/* 92 */     request.setAttribute("stagetasklist", stagetasklist);
/*    */ 
/* 94 */     request.setAttribute("stucode", stu.getStucode());
/*    */ 
/* 96 */     return mapping.findForward("display");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.stu.StagetaskstuAction
 * JD-Core Version:    0.5.4
 */