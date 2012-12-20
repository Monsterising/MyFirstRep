/*     */ package com.frame.struts.action.college;
/*     */ 
/*     */ import com.entity.basedata.ClassListDAO;
/*     */ import com.entity.basedata.CollegeList;
/*     */ import com.entity.basedata.CollegeListDAO;
/*     */ import com.entity.basedata.DepartListDAO;
/*     */ import com.entity.basedata.GradeListDAO;
/*     */ import com.frame.struts.baseform.AddclassForm;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.apache.struts.action.Action;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionForward;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class ClasslistAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  52 */     AddclassForm aform = (AddclassForm)form;
/*  53 */     HttpSession session = request.getSession();
/*  54 */     if (session.getAttribute("adminid") == null) {
/*  55 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  56 */       return mapping.findForward("error");
/*     */     }
/*  58 */     Integer collegeid = Integer.valueOf(Integer.parseInt(session.getAttribute("collegeid").toString()));
/*  59 */     CollegeList collegelist = new CollegeList();
/*  60 */     CollegeListDAO ccdao = new CollegeListDAO();
/*  61 */     collegelist = ccdao.findById(collegeid);
/*  62 */     request.setAttribute("CollegeList", collegelist);
/*     */ 
/*  66 */     DepartListDAO ddao = new DepartListDAO();
/*  67 */     List departlist = ddao.findByCollegeid(collegeid);
/*  68 */     request.setAttribute("collegeid", collegeid);
/*  69 */     request.setAttribute("departlist", departlist);
/*     */ 
/*  72 */     List classlist = null;
/*  73 */     ClassListDAO cdao = new ClassListDAO();
/*     */ 
/*  75 */     List gradelist = null;
/*  76 */     GradeListDAO gdao = new GradeListDAO();
/*     */ 
/*  79 */     String op = request.getParameter("op");
/*  80 */     if ((op == null) || (op.equals("list")))
/*     */     {
/*  82 */       classlist = cdao.findByCollegeid(collegeid);
/*  83 */       gradelist = gdao.findByCollegeid(collegeid);
/*  84 */       request.setAttribute("departid", Integer.valueOf(0));
/*  85 */     } else if (op.equals("edit"))
/*     */     {
/*  87 */       Integer departid = (Integer)request.getAttribute("departid");
/*  88 */       gradelist = gdao.findByDepartid(departid);
/*  89 */       classlist = cdao.findByDepartid(departid);
/*  90 */       request.setAttribute("departid", departid);
/*  91 */     } else if (op.equals("jump"))
/*     */     {
/*  93 */       Integer departid = Integer.valueOf(Integer.parseInt(request.getParameter("id")));
/*  94 */       if (departid.intValue() == 0) {
/*  95 */         gradelist = gdao.findByCollegeid(collegeid);
/*  96 */         classlist = cdao.findByCollegeid(collegeid);
/*     */       } else {
/*  98 */         gradelist = gdao.findByDepartid(departid);
/*  99 */         classlist = cdao.findByDepartid(departid);
/*     */       }
/* 101 */       request.setAttribute("departid", departid);
/*     */     }
/*     */     else
/*     */     {
/* 105 */       classlist = cdao.findByCollegeid(collegeid);
/* 106 */       gradelist = gdao.findByCollegeid(collegeid);
/* 107 */       request.setAttribute("departid", Integer.valueOf(0));
/*     */     }
/* 109 */     request.setAttribute("classlist", classlist);
/* 110 */     request.setAttribute("gradelist", gradelist);
/* 111 */     request.setAttribute("op", "ok");
/* 112 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.ClasslistAction
 * JD-Core Version:    0.5.4
 */