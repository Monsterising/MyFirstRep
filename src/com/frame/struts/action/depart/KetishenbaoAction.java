/*     */ package com.frame.struts.action.depart;
/*     */ 
/*     */ import com.entity.basedata.DepartTec;
/*     */ import com.entity.basedata.DepartTecDAO;
/*     */ import com.entity.basedata.GradeList;
/*     */ import com.entity.basedata.GradeListDAO;
/*     */ import com.entity.basedata.TecExtra;
/*     */ import com.entity.basedata.TecExtraDAO;
/*     */ import com.entity.wish.ApplyNumGrade;
/*     */ import com.entity.wish.ApplyNumGradeDAO;
/*     */ import com.entity.wish.ApplyResultDAO;
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
/*     */ import org.hibernate.Session;
/*     */ import pub.Qdao;
/*     */ 
/*     */ public class KetishenbaoAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  58 */     HttpSession session = request.getSession();
/*  59 */     if (session.getAttribute("teccode") == null) {
/*  60 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  61 */       return mapping.findForward("error");
/*     */     }
/*  63 */     String teccode = (String)session.getAttribute("teccode");
/*     */ 
/*  65 */     String departidstring = request.getParameter("departid");
/*  66 */     Integer departid = Integer.valueOf(0);
/*  67 */     if (departidstring != null) {
/*  68 */       departid = Integer.valueOf(Integer.parseInt(departidstring));
/*     */     }
/*     */ 
/*  71 */     TecExtraDAO exdao = new TecExtraDAO();
/*  72 */     if (exdao.getSession().get(TecExtra.class, teccode) == null) {
/*  73 */       request.setAttribute("notice", "您还没有完善个人资料，请先填写！<br/><br/><a href='./tecinfo.do' target='_self'>现在完善个人资料</a>");
/*  74 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  77 */     request.setAttribute("tecprof", exdao.findById(teccode).getTecprof().trim());
/*     */ 
/*  82 */     DepartTec departtec = new DepartTec();
/*  83 */     DepartTecDAO dao = new DepartTecDAO();
/*  84 */     List departteclist = dao.findByTeccode(teccode);
/*     */ 
/*  86 */     List departlist = new LinkedList();
/*  87 */     String departids = "";
/*  88 */     for (int i = 0; i < departteclist.size(); ++i) {
/*  89 */       if ((((DepartTec)departteclist.get(i)).getTecrole().intValue() != 2) && (((DepartTec)departteclist.get(i)).getTecrole().intValue() != 1))
/*     */         continue;
/*  91 */       departids = departids + ((DepartTec)departteclist.get(i)).getDepartid() + ",";
/*     */     }
/*     */ 
/*  95 */     if (!departids.equals(""))
/*     */     {
/*  97 */       departids = departids.substring(0, departids.length() - 1);
/*  98 */       String hql = "from DepartList where departid in (" + departids + ")";
/*  99 */       Qdao qdao = new Qdao();
/* 100 */       System.out.println("hql=" + hql);
/* 101 */       departlist.addAll(qdao.query(hql));
/* 102 */       request.setAttribute("departlist", departlist);
/*     */ 
/* 104 */       if (departid.intValue() != 0)
/*     */       {
/* 108 */         ApplyNumGradeDAO adao = new ApplyNumGradeDAO();
/* 109 */         List applynumgradelist = adao.findAll();
/*     */ 
/* 117 */         ApplyNumGrade ang = new ApplyNumGrade();
/* 118 */         ang = adao.findById(departid);
/*     */ 
/* 121 */         ApplyResultDAO ardao = new ApplyResultDAO();
/* 122 */         List applyresultlist = new LinkedList();
/* 123 */         hql = "from ApplyResult where departid in (" + departid + ")";
/* 124 */         applyresultlist.addAll(qdao.query(hql));
/* 125 */         request.setAttribute("applynumgradelist", applynumgradelist);
/*     */ 
/* 127 */         request.setAttribute("applyresultlist", applyresultlist);
/* 128 */         request.setAttribute("atid", "");
/* 129 */         request.setAttribute("teccode", teccode);
/*     */ 
/* 131 */         hql = "select count(*) from ApplyTec where teccode='" + teccode + "'";
/* 132 */         Long j = (Long)qdao.count(hql);
/* 133 */         request.setAttribute("j", j);
/* 134 */         request.setAttribute("i", Long.valueOf(ang.getNum().intValue() - j.longValue()));
/* 135 */         request.setAttribute("gradeid", ang.getGradeid());
/* 136 */         GradeList grade = new GradeList();
/* 137 */         GradeListDAO gdao = new GradeListDAO();
/* 138 */         grade = gdao.findById(ang.getGradeid());
/* 139 */         request.setAttribute("gradename", grade.getGradename());
/*     */       }
/* 141 */       request.setAttribute("departid", departid);
/*     */ 
/* 145 */       GradeListDAO gdao = new GradeListDAO();
/* 146 */       List gradelist = gdao.findAll();
/* 147 */       request.setAttribute("gradelist", gradelist);
/* 148 */       request.setAttribute("atid", Integer.valueOf(0));
/* 149 */       request.setAttribute("op", "new");
/*     */     }
/*     */ 
/* 158 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.KetishenbaoAction
 * JD-Core Version:    0.5.4
 */