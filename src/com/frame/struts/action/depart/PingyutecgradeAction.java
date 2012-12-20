/*     */ package com.frame.struts.action.depart;
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
/*     */ public class PingyutecgradeAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  56 */     HttpSession session = request.getSession();
/*  57 */     if (session.getAttribute("teccode") == null) {
/*  58 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  59 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  62 */     String stucode = request.getParameter("s").toString();
/*  63 */     Integer departid = Integer.valueOf(Integer.parseInt(request.getParameter("departid").toString()));
/*  64 */     Integer gradeid = Integer.valueOf(Integer.parseInt(request.getParameter("gradeid").toString()));
/*  65 */     request.setAttribute("stucode", stucode);
/*     */ 
/*  68 */     StuList stu = new StuList();
/*  69 */     StuListDAO studao = new StuListDAO();
/*  70 */     stu = studao.findById(stucode);
/*  71 */     DepartList depart = new DepartList();
/*  72 */     DepartListDAO departdao = new DepartListDAO();
/*  73 */     depart = departdao.findById(stu.getDepartid());
/*  74 */     request.setAttribute("StuList", stu);
/*  75 */     request.setAttribute("departname", depart.getDepartname());
/*  76 */     CollegeList college = new CollegeList();
/*  77 */     CollegeListDAO collegedao = new CollegeListDAO();
/*  78 */     college = collegedao.findById(stu.getCollegeid());
/*  79 */     request.setAttribute("collegename", college.getCollegename());
/*  80 */     ClassList stuclass = new ClassList();
/*  81 */     ClassListDAO classdao = new ClassListDAO();
/*  82 */     stuclass = classdao.findById(stu.getClassid());
/*  83 */     request.setAttribute("classname", stuclass.getClassname());
/*  84 */     GradeList grade = new GradeList();
/*  85 */     GradeListDAO gdao = new GradeListDAO();
/*  86 */     grade = gdao.findById(stu.getGradeid());
/*  87 */     request.setAttribute("gradename", grade.getGradename());
/*  88 */     request.setAttribute("stucode", stu.getStucode());
/*     */ 
/*  92 */     ApplyTecResult atr = new ApplyTecResult();
/*  93 */     ApplyTecResultDAO atrdao = new ApplyTecResultDAO();
/*     */ 
/*  95 */     if (atrdao.findByStucode(stucode).size() != 0) {
/*  96 */       List atrlist = atrdao.findByStucode(stucode);
/*  97 */       request.setAttribute("atrlist", atrlist);
/*  98 */       System.out.println("atrlist.size()=" + atrlist.size());
/*     */     } else {
/* 100 */       request.setAttribute("notice", "该学生暂未提交内容");
/*     */     }
/*     */ 
/* 103 */     ApplyResult ar = new ApplyResult();
/* 104 */     ApplyResultDAO ardao = new ApplyResultDAO();
/*     */ 
/* 106 */     if (ardao.findByDepartid(stu.getDepartid()).size() != 0) {
/* 107 */       List arlist = ardao.findByDepartid(stu.getDepartid());
/* 108 */       request.setAttribute("arlist", arlist);
/* 109 */       System.out.println("arlist.size()=" + arlist.size());
/*     */     }
/*     */ 
/* 116 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.PingyutecgradeAction
 * JD-Core Version:    0.5.4
 */