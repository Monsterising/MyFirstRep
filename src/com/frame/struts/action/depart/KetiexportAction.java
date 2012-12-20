/*     */ package com.frame.struts.action.depart;
/*     */ 
/*     */ import com.entity.basedata.DepartList;
/*     */ import com.entity.basedata.DepartListDAO;
/*     */ import com.entity.basedata.GradeList;
/*     */ import com.entity.basedata.GradeListDAO;
/*     */ import com.entity.basedata.TecExtra;
/*     */ import com.entity.basedata.TecExtraDAO;
/*     */ import com.entity.basedata.TecList;
/*     */ import com.entity.basedata.TecListDAO;
/*     */ import com.entity.wish.ApplyNumGrade;
/*     */ import com.entity.wish.ApplyNumGradeDAO;
/*     */ import com.entity.wish.ApplyTec;
/*     */ import com.entity.wish.ApplyTecDAO;
/*     */ import java.text.SimpleDateFormat;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.apache.struts.action.Action;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionForward;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ import org.hibernate.Session;
/*     */ 
/*     */ public class KetiexportAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  63 */     HttpSession session = request.getSession();
/*  64 */     String islogin = null;
/*  65 */     if ((session.getAttribute("teccode") == null) && (session.getAttribute("adminid") != null)) {
/*  66 */       islogin = session.getAttribute("adminid").toString();
/*     */     }
/*  68 */     if ((session.getAttribute("teccode") == null) && (session.getAttribute("adminid") == null) && (session.getAttribute("stucode") != null)) {
/*  69 */       islogin = session.getAttribute("stucode").toString();
/*     */     }
/*     */ 
/*  72 */     if ((session.getAttribute("teccode") == null) && (islogin == null)) {
/*  73 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  74 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  77 */     Integer id = Integer.valueOf(Integer.parseInt(request.getParameter("id")));
/*     */ 
/*  80 */     ApplyTec at = new ApplyTec();
/*  81 */     ApplyTecDAO dao = new ApplyTecDAO();
/*  82 */     at = (ApplyTec)dao.getSession().get(ApplyTec.class, id);
/*     */ 
/*  84 */     request.setAttribute("ApplyTec", at);
/*     */ 
/*  87 */     DepartList depart = new DepartList();
/*  88 */     DepartListDAO ddao = new DepartListDAO();
/*  89 */     depart = (DepartList)ddao.getSession().load(DepartList.class, at.getDepartid());
/*  90 */     request.setAttribute("Departname", depart.getDepartname());
/*     */ 
/*  92 */     TecList tec = new TecList();
/*  93 */     TecListDAO tdao = new TecListDAO();
/*  94 */     tec = (TecList)tdao.getSession().load(TecList.class, at.getTeccode().trim());
/*  95 */     request.setAttribute("Tecname", tec.getTecname());
/*     */ 
/*  97 */     TecExtra tecextra = new TecExtra();
/*  98 */     TecExtraDAO edao = new TecExtraDAO();
/*  99 */     if (edao.getSession().get(TecExtra.class, tec.getTeccode()) != null) {
/* 100 */       tecextra = edao.findById(tec.getTeccode());
/*     */     }
/* 102 */     if (at.getTecprof().equals(""))
/* 103 */       request.setAttribute("tecprof", tecextra.getTecprof());
/*     */     else {
/* 105 */       request.setAttribute("tecprof", at.getTecprof());
/*     */     }
/*     */ 
/* 115 */     ApplyNumGrade ang = new ApplyNumGrade();
/* 116 */     ApplyNumGradeDAO adao = new ApplyNumGradeDAO();
/* 117 */     ang = adao.findById(depart.getDepartid());
/* 118 */     GradeList grade = new GradeList();
/* 119 */     GradeListDAO gdao = new GradeListDAO();
/* 120 */     grade = gdao.findById(ang.getGradeid());
/* 121 */     request.setAttribute("gradename", grade.getGradename());
/*     */ 
/* 125 */     SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy年MM月dd日");
/* 126 */     String myTime = sdFormat.format(at.getApplydate());
/* 127 */     request.setAttribute("myTime", myTime);
/* 128 */     return mapping.findForward("export");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.KetiexportAction
 * JD-Core Version:    0.5.4
 */