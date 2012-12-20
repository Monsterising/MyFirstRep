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
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.apache.struts.action.Action;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionForward;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ import pub.Qdao;
/*     */ 
/*     */ public class StagetaskliststuAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  58 */     HttpSession session = request.getSession();
/*  59 */     if (session.getAttribute("teccode") == null) {
/*  60 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  61 */       return mapping.findForward("error");
/*     */     }
/*  63 */     String teccode = session.getAttribute("teccode").toString();
/*  64 */     Integer atid = Integer.valueOf(Integer.parseInt(request.getParameter("atid").toString()));
/*  65 */     String stucode = request.getParameter("s").toString();
/*     */ 
/*  67 */     StuList stu = new StuList();
/*  68 */     StuListDAO studao = new StuListDAO();
/*  69 */     stu = studao.findById(stucode);
/*  70 */     DepartList depart = new DepartList();
/*  71 */     DepartListDAO departdao = new DepartListDAO();
/*  72 */     depart = departdao.findById(stu.getDepartid());
/*  73 */     request.setAttribute("StuList", stu);
/*  74 */     request.setAttribute("departname", depart.getDepartname());
/*  75 */     request.setAttribute("departid", depart.getDepartid());
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
/*  88 */     request.setAttribute("StuList", stu);
/*     */ 
/*  92 */     List stagetasklist = new LinkedList();
/*  93 */     Qdao qdao = new Qdao();
/*  94 */     String hql = "from Stagetask where atid=" + atid + " and stucode='" + stucode + "'";
/*  95 */     stagetasklist.addAll(qdao.query(hql));
/*  96 */     request.setAttribute("stagetasklist", stagetasklist);
/*     */ 
/*  99 */     List fujianlist = new LinkedList();
/* 100 */     hql = "from Stagetaskfujian where stucode='" + stucode + "'";
/* 101 */     fujianlist.addAll(qdao.query(hql));
/* 102 */     request.setAttribute("fujianlist", fujianlist);
/*     */ 
/* 104 */     request.setAttribute("stucode", stu.getStucode());
/* 105 */     request.setAttribute("atid", atid);
/*     */ 
/* 107 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.StagetaskliststuAction
 * JD-Core Version:    0.5.4
 */