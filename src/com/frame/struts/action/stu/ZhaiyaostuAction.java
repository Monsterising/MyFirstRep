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
/*    */ import com.entity.dabian.Zhaiyao;
/*    */ import com.entity.dabian.ZhaiyaoDAO;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.apache.struts.action.Action;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ import org.hibernate.Session;
/*    */ 
/*    */ public class ZhaiyaostuAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 52 */     HttpSession session = request.getSession();
/* 53 */     if (session.getAttribute("stucode") == null) {
/* 54 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 55 */       return mapping.findForward("error");
/*    */     }
/* 57 */     String stucode = session.getAttribute("stucode").toString();
/*    */ 
/* 59 */     StuList stu = new StuList();
/* 60 */     StuListDAO studao = new StuListDAO();
/* 61 */     stu = studao.findById(stucode);
/* 62 */     DepartList depart = new DepartList();
/* 63 */     DepartListDAO departdao = new DepartListDAO();
/* 64 */     depart = departdao.findById(stu.getDepartid());
/* 65 */     request.setAttribute("StuList", stu);
/* 66 */     request.setAttribute("departname", depart.getDepartname());
/* 67 */     CollegeList college = new CollegeList();
/* 68 */     CollegeListDAO collegedao = new CollegeListDAO();
/* 69 */     college = collegedao.findById(stu.getCollegeid());
/* 70 */     request.setAttribute("collegename", college.getCollegename());
/* 71 */     ClassList stuclass = new ClassList();
/* 72 */     ClassListDAO classdao = new ClassListDAO();
/* 73 */     stuclass = classdao.findById(stu.getClassid());
/* 74 */     request.setAttribute("classname", stuclass.getClassname());
/* 75 */     GradeList grade = new GradeList();
/* 76 */     GradeListDAO gdao = new GradeListDAO();
/* 77 */     grade = gdao.findById(stu.getGradeid());
/* 78 */     request.setAttribute("gradename", grade.getGradename());
/* 79 */     request.setAttribute("StuList", stu);
/*    */ 
/* 82 */     Zhaiyao zy = new Zhaiyao();
/* 83 */     ZhaiyaoDAO zydao = new ZhaiyaoDAO();
/* 84 */     if (zydao.getSession().get(Zhaiyao.class, stucode) != null) {
/* 85 */       zy = zydao.findById(stucode);
/* 86 */       request.setAttribute("content", zy.getContent());
/* 87 */       request.setAttribute("keywords", zy.getKeyword());
/*    */     }
/*    */     else {
/* 90 */       request.setAttribute("notice", "暂无内容");
/*    */     }
/*    */ 
/* 95 */     return mapping.findForward("display");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.stu.ZhaiyaostuAction
 * JD-Core Version:    0.5.4
 */