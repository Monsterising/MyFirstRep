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
/*     */ import com.entity.wish.ApplyResultDAO;
/*     */ import com.entity.wish.ApplyTecResultDAO;
/*     */ import com.entity.wish.Xuanti;
/*     */ import com.entity.wish.XuantiDAO;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.apache.struts.action.Action;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionForward;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class FileliststuAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  59 */     HttpSession session = request.getSession();
/*  60 */     if (session.getAttribute("stucode") == null) {
/*  61 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  62 */       return mapping.findForward("error");
/*  63 */     }String stucode = session.getAttribute("stucode").toString();
/*     */ 
/*  66 */     StuList stu = new StuList();
/*  67 */     StuListDAO studao = new StuListDAO();
/*  68 */     stu = studao.findById(stucode);
/*  69 */     DepartList depart = new DepartList();
/*  70 */     DepartListDAO departdao = new DepartListDAO();
/*  71 */     depart = departdao.findById(stu.getDepartid());
/*  72 */     request.setAttribute("StuList", stu);
/*  73 */     request.setAttribute("departname", depart.getDepartname());
/*  74 */     request.setAttribute("departid", stu.getDepartid());
/*  75 */     CollegeList college = new CollegeList();
/*  76 */     CollegeListDAO collegedao = new CollegeListDAO();
/*  77 */     college = collegedao.findById(stu.getCollegeid());
/*  78 */     request.setAttribute("collegename", college.getCollegename());
/*  79 */     ClassList stuclass = new ClassList();
/*  80 */     ClassListDAO classdao = new ClassListDAO();
/*  81 */     stuclass = classdao.findById(stu.getClassid());
/*  82 */     request.setAttribute("classname", stuclass.getClassname());
/*  83 */     GradeList grade = new GradeList();
/*  84 */     GradeListDAO gdao = new GradeListDAO();
/*  85 */     grade = gdao.findById(stu.getGradeid());
/*  86 */     request.setAttribute("gradename", grade.getGradename());
/*  87 */     request.setAttribute("StuList", stu);
/*     */ 
/*  90 */     Xuanti xuanti = new Xuanti();
/*  91 */     XuantiDAO xdao = new XuantiDAO();
/*  92 */     if (xdao.findById(stucode) == null) {
/*  93 */       request.setAttribute("notice", "您的课题尚未确定！");
/*  94 */       return mapping.findForward("error");
/*     */     }
/*  96 */     xuanti = xdao.findById(stucode);
/*     */ 
/*  99 */     ApplyTecResultDAO resultdao = new ApplyTecResultDAO();
/* 100 */     List resultlist = resultdao.findByAtid(xuanti.getAtid());
/* 101 */     request.setAttribute("resultlist", resultlist);
/*     */ 
/* 104 */     ApplyResultDAO ardao = new ApplyResultDAO();
/* 105 */     List arlist = ardao.findByDepartid(stu.getDepartid());
/* 106 */     request.setAttribute("arlist", arlist);
/*     */ 
/* 111 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.stu.FileliststuAction
 * JD-Core Version:    0.5.4
 */