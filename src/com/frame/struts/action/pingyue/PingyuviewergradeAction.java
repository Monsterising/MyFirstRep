/*     */ package com.frame.struts.action.pingyue;
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
/*     */ public class PingyuviewergradeAction extends Action
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
/*  64 */     Integer departid = Integer.valueOf(Integer.parseInt(request.getParameter("departid").toString()));
/*  65 */     Integer gradeid = Integer.valueOf(Integer.parseInt(request.getParameter("gradeid").toString()));
/*  66 */     request.setAttribute("stucode", stucode);
/*     */ 
/*  69 */     StuList stu = new StuList();
/*  70 */     StuListDAO studao = new StuListDAO();
/*  71 */     stu = studao.findById(stucode);
/*  72 */     DepartList depart = new DepartList();
/*  73 */     DepartListDAO departdao = new DepartListDAO();
/*  74 */     depart = departdao.findById(stu.getDepartid());
/*  75 */     request.setAttribute("StuList", stu);
/*  76 */     request.setAttribute("departname", depart.getDepartname());
/*  77 */     CollegeList college = new CollegeList();
/*  78 */     CollegeListDAO collegedao = new CollegeListDAO();
/*  79 */     college = collegedao.findById(stu.getCollegeid());
/*  80 */     request.setAttribute("collegename", college.getCollegename());
/*  81 */     ClassList stuclass = new ClassList();
/*  82 */     ClassListDAO classdao = new ClassListDAO();
/*  83 */     stuclass = classdao.findById(stu.getClassid());
/*  84 */     request.setAttribute("classname", stuclass.getClassname());
/*  85 */     GradeList grade = new GradeList();
/*  86 */     GradeListDAO gdao = new GradeListDAO();
/*  87 */     grade = gdao.findById(stu.getGradeid());
/*  88 */     request.setAttribute("gradename", grade.getGradename());
/*     */ 
/*  91 */     ApplyTecResult atr = new ApplyTecResult();
/*  92 */     ApplyTecResultDAO atrdao = new ApplyTecResultDAO();
/*     */ 
/*  94 */     if (atrdao.findByStucode(stucode).size() != 0) {
/*  95 */       List atrlist = atrdao.findByStucode(stucode);
/*  96 */       request.setAttribute("atrlist", atrlist);
/*  97 */       System.out.println("atrlist.size()=" + atrlist.size());
/*     */     } else {
/*  99 */       request.setAttribute("notice", "该学生暂未提交内容");
/*     */     }
/*     */ 
/* 102 */     ApplyResult ar = new ApplyResult();
/* 103 */     ApplyResultDAO ardao = new ApplyResultDAO();
/*     */ 
/* 105 */     if (ardao.findByDepartid(stu.getDepartid()).size() != 0) {
/* 106 */       List arlist = ardao.findByDepartid(stu.getDepartid());
/* 107 */       request.setAttribute("arlist", arlist);
/* 108 */       System.out.println("arlist.size()=" + arlist.size());
/*     */     }
/*     */ 
/* 112 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.pingyue.PingyuviewergradeAction
 * JD-Core Version:    0.5.4
 */