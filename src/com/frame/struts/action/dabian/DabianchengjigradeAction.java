/*     */ package com.frame.struts.action.dabian;
/*     */ 
/*     */ import com.entity.basedata.ClassList;
/*     */ import com.entity.basedata.ClassListDAO;
/*     */ import com.entity.basedata.CollegeList;
/*     */ import com.entity.basedata.CollegeListDAO;
/*     */ import com.entity.basedata.DepartList;
/*     */ import com.entity.basedata.DepartListDAO;
/*     */ import com.entity.basedata.GradeList;
/*     */ import com.entity.basedata.GradeListDAO;
/*     */ import com.entity.basedata.StuList;
/*     */ import com.entity.basedata.StuListDAO;
/*     */ import com.entity.wish.ApplyResult;
/*     */ import com.entity.wish.ApplyResultDAO;
/*     */ import com.entity.wish.ApplyTecResult;
/*     */ import com.entity.wish.ApplyTecResultDAO;
/*     */ import java.io.PrintStream;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.apache.struts.action.Action;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionForward;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class DabianchengjigradeAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  57 */     HttpSession session = request.getSession();
/*  58 */     if (session.getAttribute("teccode") == null) {
/*  59 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  60 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  63 */     String stucode = request.getParameter("s").toString();
/*     */ 
/*  66 */     request.setAttribute("stucode", stucode);
/*  67 */     if (request.getParameter("type") != null) {
/*  68 */       session.setAttribute("type", request.getParameter("type"));
/*     */     }
/*     */ 
/*  73 */     StuList stu = new StuList();
/*  74 */     StuListDAO studao = new StuListDAO();
/*  75 */     stu = studao.findById(stucode);
/*  76 */     DepartList depart = new DepartList();
/*  77 */     DepartListDAO departdao = new DepartListDAO();
/*  78 */     depart = departdao.findById(stu.getDepartid());
/*  79 */     request.setAttribute("StuList", stu);
/*  80 */     request.setAttribute("departname", depart.getDepartname());
/*  81 */     CollegeList college = new CollegeList();
/*  82 */     CollegeListDAO collegedao = new CollegeListDAO();
/*  83 */     college = collegedao.findById(stu.getCollegeid());
/*  84 */     request.setAttribute("collegename", college.getCollegename());
/*  85 */     ClassList stuclass = new ClassList();
/*  86 */     ClassListDAO classdao = new ClassListDAO();
/*  87 */     stuclass = classdao.findById(stu.getClassid());
/*  88 */     request.setAttribute("classname", stuclass.getClassname());
/*  89 */     GradeList grade = new GradeList();
/*  90 */     GradeListDAO gdao = new GradeListDAO();
/*  91 */     grade = gdao.findById(stu.getGradeid());
/*  92 */     request.setAttribute("gradename", grade.getGradename());
/*     */ 
/*  94 */     request.setAttribute("dbgid", request.getParameter("dbgid"));
/*     */ 
/* 101 */     ApplyTecResult atr = new ApplyTecResult();
/* 102 */     ApplyTecResultDAO atrdao = new ApplyTecResultDAO();
/*     */ 
/* 104 */     if (atrdao.findByStucode(stucode).size() != 0) {
/* 105 */       List atrlist = atrdao.findByStucode(stucode);
/* 106 */       request.setAttribute("atrlist", atrlist);
/* 107 */       System.out.println("atrlist.size()=" + atrlist.size());
/*     */     } else {
/* 109 */       request.setAttribute("notice", "该学生暂未提交内容");
/*     */     }
/*     */ 
/* 112 */     ApplyResult ar = new ApplyResult();
/* 113 */     ApplyResultDAO ardao = new ApplyResultDAO();
/*     */ 
/* 115 */     if (ardao.findByDepartid(stu.getDepartid()).size() != 0) {
/* 116 */       List arlist = ardao.findByDepartid(stu.getDepartid());
/* 117 */       request.setAttribute("arlist", arlist);
/* 118 */       System.out.println("arlist.size()=" + arlist.size());
/*     */     }
/*     */ 
/* 122 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.dabian.DabianchengjigradeAction
 * JD-Core Version:    0.5.4
 */