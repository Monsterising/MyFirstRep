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
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.apache.struts.action.Action;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionForward;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class StagetaskaddAction extends Action
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
/*  85 */     Date date = new Date();
/*  86 */     SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
/*  87 */     String dateup = sf.format(date);
/*  88 */     request.setAttribute("datefagei", dateup);
/*  89 */     request.setAttribute("datestart", dateup);
/*  90 */     request.setAttribute("dateover", dateup);
/*     */ 
/*  92 */     request.setAttribute("teccode", teccode);
/*  93 */     request.setAttribute("collegeid", stu.getCollegeid());
/*  94 */     request.setAttribute("departid", stu.getDepartid());
/*  95 */     request.setAttribute("gradeid", stu.getGradeid());
/*  96 */     request.setAttribute("stucode", stu.getStucode());
/*  97 */     request.setAttribute("atid", atid);
/*  98 */     request.setAttribute("op", "addstagetask");
/*     */ 
/* 101 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.StagetaskaddAction
 * JD-Core Version:    0.5.4
 */