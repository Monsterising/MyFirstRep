/*     */ package com.frame.struts.action.college;
/*     */ 
/*     */ import com.entity.basedata.ClassListDAO;
/*     */ import com.entity.basedata.CollegeList;
/*     */ import com.entity.basedata.CollegeListDAO;
/*     */ import com.entity.basedata.DepartListDAO;
/*     */ import com.entity.basedata.GradeListDAO;
/*     */ import com.entity.basedata.StuListDAO;
/*     */ import com.frame.struts.baseform.AddstuForm;
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
/*     */ public class StulistAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  53 */     AddstuForm addstuForm = (AddstuForm)form;
/*  54 */     HttpSession session = request.getSession();
/*  55 */     if (session.getAttribute("adminid") == null) {
/*  56 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  57 */       return mapping.findForward("error");
/*     */     }
/*  59 */     Integer collegeid = Integer.valueOf(Integer.parseInt(session.getAttribute("collegeid").toString()));
/*  60 */     CollegeList collegelist = new CollegeList();
/*  61 */     CollegeListDAO cdao = new CollegeListDAO();
/*  62 */     collegelist = cdao.findById(collegeid);
/*  63 */     request.setAttribute("CollegeList", collegelist);
/*     */ 
/*  65 */     String op = "";
/*  66 */     Integer gradeid = Integer.valueOf(0);
/*  67 */     Integer departid = Integer.valueOf(0);
/*  68 */     Integer classid = Integer.valueOf(0);
/*     */ 
/*  70 */     if (!request.getParameter("op").equals("new")) {
/*  71 */       System.out.println("jump");
/*  72 */       if ((request.getAttribute("op") != null) && (request.getAttribute("op").equals("list"))) {
/*  73 */         System.out.println("jump-list");
/*  74 */         gradeid = Integer.valueOf(Integer.parseInt(request.getAttribute("gradeid").toString()));
/*  75 */         departid = Integer.valueOf(Integer.parseInt(request.getAttribute("departid").toString()));
/*  76 */         classid = Integer.valueOf(Integer.parseInt(request.getAttribute("classid").toString()));
/*     */       }
/*  78 */       if ((request.getParameter("op") != null) && (request.getParameter("op").equals("jumpclass"))) {
/*  79 */         System.out.println("jump-jump");
/*  80 */         gradeid = Integer.valueOf(Integer.parseInt(request.getParameter("gradeid").toString()));
/*  81 */         departid = Integer.valueOf(Integer.parseInt(request.getParameter("departid").toString()));
/*  82 */         classid = Integer.valueOf(Integer.parseInt(request.getParameter("classid").toString()));
/*     */       }
/*  84 */       if ((request.getParameter("op") != null) && (request.getParameter("op").equals("jumpdepart"))) {
/*  85 */         departid = Integer.valueOf(Integer.parseInt(request.getParameter("departid").toString()));
/*     */       }
/*  87 */       if ((request.getParameter("op") != null) && (request.getParameter("op").equals("jumpgrade"))) {
/*  88 */         departid = Integer.valueOf(Integer.parseInt(request.getParameter("departid").toString()));
/*  89 */         gradeid = Integer.valueOf(Integer.parseInt(request.getParameter("gradeid").toString()));
/*     */       }
/*     */ 
/*  94 */       DepartListDAO ddao = new DepartListDAO();
/*  95 */       List departlist = ddao.findByCollegeid(collegeid);
/*     */ 
/*  97 */       GradeListDAO gdao = new GradeListDAO();
/*  98 */       List gradelist = gdao.findByDepartid(departid);
/*     */ 
/* 102 */       ClassListDAO classdao = new ClassListDAO();
/* 103 */       List classlist = classdao.findByGradeid(gradeid);
/*     */ 
/* 105 */       StuListDAO studao = new StuListDAO();
/* 106 */       List stulist = studao.findByClassid(classid);
/*     */ 
/* 108 */       request.setAttribute("departlist", departlist);
/* 109 */       request.setAttribute("gradelist", gradelist);
/* 110 */       request.setAttribute("classlist", classlist);
/* 111 */       request.setAttribute("stulist", stulist);
/* 112 */       request.setAttribute("departid", departid);
/* 113 */       request.setAttribute("gradeid", gradeid);
/* 114 */       request.setAttribute("classid", classid);
/*     */     } else {
/* 116 */       System.out.println("new");
/* 117 */       DepartListDAO ddao = new DepartListDAO();
/* 118 */       List departlist = ddao.findByCollegeid(collegeid);
/* 119 */       request.setAttribute("departlist", departlist);
/* 120 */       departid = Integer.valueOf(0);
/* 121 */       gradeid = Integer.valueOf(0);
/* 122 */       classid = Integer.valueOf(0);
/* 123 */       request.setAttribute("departid", "0");
/* 124 */       request.setAttribute("gradeid", "0");
/* 125 */       request.setAttribute("classid", "0");
/*     */     }
/*     */ 
/* 128 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.StulistAction
 * JD-Core Version:    0.5.4
 */