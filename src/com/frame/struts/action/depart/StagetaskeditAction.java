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
/*     */ import com.entity.task.Stagetask;
/*     */ import com.entity.task.StagetaskDAO;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.apache.struts.action.Action;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionForward;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class StagetaskeditAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  53 */     HttpSession session = request.getSession();
/*  54 */     if (session.getAttribute("teccode") == null) {
/*  55 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  56 */       return mapping.findForward("error");
/*     */     }
/*  58 */     String teccode = session.getAttribute("teccode").toString();
/*  59 */     Integer atid = Integer.valueOf(Integer.parseInt(request.getParameter("atid").toString()));
/*  60 */     String stucode = request.getParameter("s").toString();
/*  61 */     Integer stid = Integer.valueOf(Integer.parseInt(request.getParameter("stid").toString()));
/*     */ 
/*  63 */     StuList stu = new StuList();
/*  64 */     StuListDAO studao = new StuListDAO();
/*  65 */     stu = studao.findById(stucode);
/*  66 */     DepartList depart = new DepartList();
/*  67 */     DepartListDAO departdao = new DepartListDAO();
/*  68 */     depart = departdao.findById(stu.getDepartid());
/*  69 */     request.setAttribute("StuList", stu);
/*  70 */     request.setAttribute("departname", depart.getDepartname());
/*  71 */     CollegeList college = new CollegeList();
/*  72 */     CollegeListDAO collegedao = new CollegeListDAO();
/*  73 */     college = collegedao.findById(stu.getCollegeid());
/*  74 */     request.setAttribute("collegename", college.getCollegename());
/*  75 */     ClassList stuclass = new ClassList();
/*  76 */     ClassListDAO classdao = new ClassListDAO();
/*  77 */     stuclass = classdao.findById(stu.getClassid());
/*  78 */     request.setAttribute("classname", stuclass.getClassname());
/*  79 */     GradeList grade = new GradeList();
/*  80 */     GradeListDAO gdao = new GradeListDAO();
/*  81 */     grade = gdao.findById(stu.getGradeid());
/*  82 */     request.setAttribute("gradename", grade.getGradename());
/*  83 */     request.setAttribute("StuList", stu);
/*     */ 
/*  86 */     Stagetask stask = new Stagetask();
/*  87 */     StagetaskDAO sdao = new StagetaskDAO();
/*  88 */     stask = sdao.findById(stid);
/*  89 */     request.setAttribute("Stagetask", stask);
/*  90 */     request.setAttribute("taskname", stask.getTaskname().trim());
/*  91 */     request.setAttribute("stid", stask.getStid());
/*  92 */     request.setAttribute("datefagei", stask.getDatefagei());
/*  93 */     request.setAttribute("datestart", stask.getDatestart());
/*  94 */     request.setAttribute("dateover", stask.getDateover());
/*     */ 
/*  97 */     request.setAttribute("teccode", teccode);
/*  98 */     request.setAttribute("collegeid", stu.getCollegeid());
/*  99 */     request.setAttribute("departid", stu.getDepartid());
/* 100 */     request.setAttribute("gradeid", stu.getGradeid());
/* 101 */     request.setAttribute("stucode", stu.getStucode());
/* 102 */     request.setAttribute("atid", atid);
/* 103 */     request.setAttribute("op", "editstagetask");
/*     */ 
/* 106 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.StagetaskeditAction
 * JD-Core Version:    0.5.4
 */