/*     */ package com.frame.struts.action.stu;
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
/*     */ import com.entity.task.Stagetaskfujian;
/*     */ import com.entity.task.StagetaskfujianDAO;
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
/*     */ public class StagetaskstureadAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  54 */     HttpSession session = request.getSession();
/*  55 */     if (session.getAttribute("stucode") == null) {
/*  56 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  57 */       return mapping.findForward("error");
/*     */     }
/*  59 */     String stucode = session.getAttribute("stucode").toString();
/*  60 */     Integer stid = Integer.valueOf(Integer.parseInt(request.getParameter("stid").toString()));
/*     */ 
/*  62 */     StuList stu = new StuList();
/*  63 */     StuListDAO studao = new StuListDAO();
/*  64 */     stu = studao.findById(stucode);
/*  65 */     DepartList depart = new DepartList();
/*  66 */     DepartListDAO departdao = new DepartListDAO();
/*  67 */     depart = departdao.findById(stu.getDepartid());
/*  68 */     request.setAttribute("StuList", stu);
/*  69 */     request.setAttribute("departname", depart.getDepartname());
/*  70 */     CollegeList college = new CollegeList();
/*  71 */     CollegeListDAO collegedao = new CollegeListDAO();
/*  72 */     college = collegedao.findById(stu.getCollegeid());
/*  73 */     request.setAttribute("collegename", college.getCollegename());
/*  74 */     ClassList stuclass = new ClassList();
/*  75 */     ClassListDAO classdao = new ClassListDAO();
/*  76 */     stuclass = classdao.findById(stu.getClassid());
/*  77 */     request.setAttribute("classname", stuclass.getClassname());
/*  78 */     GradeList grade = new GradeList();
/*  79 */     GradeListDAO gdao = new GradeListDAO();
/*  80 */     grade = gdao.findById(stu.getGradeid());
/*  81 */     request.setAttribute("gradename", grade.getGradename());
/*  82 */     request.setAttribute("StuList", stu);
/*     */ 
/*  85 */     Stagetask stask = new Stagetask();
/*  86 */     StagetaskDAO sdao = new StagetaskDAO();
/*  87 */     stask = sdao.findById(stid);
/*  88 */     request.setAttribute("Stagetask", stask);
/*  89 */     request.setAttribute("taskname", stask.getTaskname().trim());
/*  90 */     request.setAttribute("stid", stask.getStid());
/*  91 */     request.setAttribute("datefagei", stask.getDatefagei());
/*  92 */     request.setAttribute("datestart", stask.getDatestart());
/*  93 */     request.setAttribute("dateover", stask.getDateover());
/*  94 */     request.setAttribute("notes", stask.getNotes());
/*     */ 
/*  97 */     System.out.println("stask.getIsFujian()=" + stask.getIsFujian());
/*  98 */     if ((stask.getIsFujian() != null) && (stask.getIsFujian().intValue() == 1)) {
/*  99 */       Stagetaskfujian fujian = new Stagetaskfujian();
/* 100 */       StagetaskfujianDAO fdao = new StagetaskfujianDAO();
/* 101 */       fujian = (Stagetaskfujian)fdao.findByStid(stask.getStid()).get(0);
/* 102 */       request.setAttribute("fujianid", fujian.getFjid());
/* 103 */       request.setAttribute("fujianname", "<a href='/bysj/stagetask/" + stu.getDepartid() + "/" + fujian.getName() + "'>" + 
/* 104 */         fujian.getName() + "</a> <br>上传时间：" + fujian.getUptime() + " <br>将覆盖已有文件！");
/*     */     }
/*     */ 
/* 108 */     request.setAttribute("collegeid", stu.getCollegeid());
/* 109 */     request.setAttribute("departid", stu.getDepartid());
/* 110 */     request.setAttribute("gradeid", stu.getGradeid());
/* 111 */     request.setAttribute("stucode", stu.getStucode());
/* 112 */     request.setAttribute("op", "editstagetask");
/*     */ 
/* 115 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.stu.StagetaskstureadAction
 * JD-Core Version:    0.5.4
 */