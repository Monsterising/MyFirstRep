/*     */ package com.frame.struts.action.college;
/*     */ 
/*     */ import com.entity.basedata.DepartListDAO;
/*     */ import com.entity.basedata.GradeList;
/*     */ import com.entity.basedata.GradeListDAO;
/*     */ import com.entity.wish.ApplyNumGrade;
/*     */ import com.entity.wish.ApplyNumGradeDAO;
/*     */ import com.entity.wish.ApplyTec;
/*     */ import com.entity.wish.ApplyTecDAO;
/*     */ import java.io.PrintStream;
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
/*     */ public class KetishenhelistAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  57 */     HttpSession session = request.getSession();
/*  58 */     if (session.getAttribute("adminid") == null) {
/*  59 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  60 */       return mapping.findForward("error");
/*     */     }
/*  62 */     Integer collegeid = Integer.valueOf(Integer.parseInt(session.getAttribute("collegeid").toString()));
/*     */ 
/*  66 */     DepartListDAO ddao = new DepartListDAO();
/*  67 */     List departlist = ddao.findByCollegeid(collegeid);
/*  68 */     request.setAttribute("departlist", departlist);
/*     */ 
/*  71 */     String departidstring = request.getParameter("departid");
/*  72 */     Integer departid = Integer.valueOf(0);
/*  73 */     if (departidstring != null) {
/*  74 */       departid = Integer.valueOf(Integer.parseInt(departidstring));
/*     */     }
/*  76 */     if (request.getAttribute("departid") != null) {
/*  77 */       departid = Integer.valueOf(Integer.parseInt(request.getAttribute("departid").toString()));
/*     */     }
/*     */ 
/*  80 */     request.setAttribute("disable", "disabled");
/*  81 */     if (departid.intValue() != 0) {
/*  82 */       request.setAttribute("disable", "");
/*  83 */       request.setAttribute("departid", departid);
/*  84 */       Qdao qdao = new Qdao();
/*  85 */       ApplyTec apply = new ApplyTec();
/*  86 */       ApplyTecDAO apdao = new ApplyTecDAO();
/*  87 */       List applylist = new LinkedList();
/*  88 */       ApplyNumGrade ang = new ApplyNumGrade();
/*  89 */       ApplyNumGradeDAO adao = new ApplyNumGradeDAO();
/*  90 */       if (adao.findById(departid) == null) {
/*  91 */         request.setAttribute("notice", "该专业没有设置有效年级！<a href='javascript:history.go(-1);'>返回</a>");
/*  92 */         return mapping.findForward("error");
/*     */       }
/*  94 */       ang = adao.findById(departid);
/*  95 */       GradeList grade = new GradeList();
/*  96 */       GradeListDAO gdao = new GradeListDAO();
/*  97 */       if (gdao.findById(ang.getGradeid()) == null) {
/*  98 */         request.setAttribute("notice", "该专业没有设置有效年级！<a href='javascript:history.go(-1);'>返回</a>");
/*  99 */         return mapping.findForward("error");
/*     */       }
/* 101 */       grade = gdao.findById(ang.getGradeid());
/* 102 */       request.setAttribute("gradename", grade.getGradename());
/* 103 */       String hql = "from ApplyTec where departid=" + departid + " and gradeid=" + grade.getGradeid();
/*     */ 
/* 106 */       if ((request.getParameter("zt") != null) && (!request.getParameter("zt").equals("0"))) {
/* 107 */         hql = hql + " and advice2='" + request.getParameter("zt").toString() + "'";
/* 108 */         System.out.println(hql);
/* 109 */         request.setAttribute("zt", request.getParameter("zt").toString());
/*     */       }
/*     */ 
/* 112 */       applylist.addAll(qdao.query(hql));
/* 113 */       request.setAttribute("applylist", applylist);
/*     */     }
/* 115 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.KetishenhelistAction
 * JD-Core Version:    0.5.4
 */