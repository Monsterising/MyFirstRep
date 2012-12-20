/*     */ package com.frame.struts.action.depart;
/*     */ 
/*     */ import com.entity.basedata.DepartTec;
/*     */ import com.entity.basedata.DepartTecDAO;
/*     */ import com.entity.basedata.GradeList;
/*     */ import com.entity.basedata.GradeListDAO;
/*     */ import com.entity.wish.ApplyNumGrade;
/*     */ import com.entity.wish.ApplyNumGradeDAO;
/*     */ import com.entity.wish.ApplyResultDAO;
/*     */ import com.entity.wish.ApplyTec;
/*     */ import com.entity.wish.ApplyTecDAO;
/*     */ import com.entity.wish.ApplyTecResult;
/*     */ import com.frame.struts.form.wish.KetishenbaoForm;
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
/*     */ public class KetieditAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  60 */     KetishenbaoForm kform = (KetishenbaoForm)form;
/*     */ 
/*  62 */     HttpSession session = request.getSession();
/*  63 */     Integer atid = Integer.valueOf(Integer.parseInt(request.getParameter("atid").toString()));
/*     */ 
/*  65 */     ApplyTec applytec = new ApplyTec();
/*  66 */     ApplyTecDAO atdao = new ApplyTecDAO();
/*  67 */     applytec = atdao.findById(atid);
/*  68 */     Integer departid = applytec.getDepartid();
/*  69 */     request.setAttribute("ApplyTec", applytec);
/*  70 */     request.setAttribute("tecprof", applytec.getTecprof());
/*     */ 
/*  73 */     List atrlist = new LinkedList();
/*  74 */     String hql = "from ApplyTecResult where atid=" + applytec.getAtid();
/*  75 */     System.out.println(hql);
/*  76 */     Qdao qdao = new Qdao();
/*  77 */     atrlist.addAll(qdao.query(hql));
/*  78 */     Integer[] resultids = new Integer[atrlist.size()];
/*  79 */     System.out.println("size=" + atrlist.size());
/*  80 */     for (int k = 0; k < atrlist.size(); ++k) {
/*  81 */       System.out.println(((ApplyTecResult)atrlist.get(k)).getResultid());
/*  82 */       resultids[k] = ((ApplyTecResult)atrlist.get(k)).getResultid();
/*     */     }
/*     */ 
/*  85 */     for (int k = 0; k < resultids.length; ++k) {
/*  86 */       System.out.println("resultids[" + k + "]=" + resultids[k]);
/*     */     }
/*  88 */     kform.setResultids(resultids);
/*  89 */     Integer[] rids = { Integer.valueOf(3), Integer.valueOf(4) };
/*     */ 
/*  91 */     request.setAttribute("KetishenbaoForm", kform);
/*     */ 
/* 100 */     ApplyNumGrade ang = new ApplyNumGrade();
/* 101 */     ApplyNumGradeDAO adao = new ApplyNumGradeDAO();
/* 102 */     ang = adao.findById(departid);
/* 103 */     GradeList grade = new GradeList();
/* 104 */     GradeListDAO gdao = new GradeListDAO();
/* 105 */     grade = gdao.findById(ang.getGradeid());
/* 106 */     request.setAttribute("gradename", grade.getGradename());
/* 107 */     request.setAttribute("departid", departid);
/* 108 */     String teccode = (String)session.getAttribute("teccode");
/* 109 */     DepartTecDAO dao = new DepartTecDAO();
/* 110 */     List departteclist = dao.findByTeccode(teccode);
/* 111 */     List departlist = new LinkedList();
/* 112 */     String departids = "";
/* 113 */     for (int i = 0; i < departteclist.size(); ++i) {
/* 114 */       if ((((DepartTec)departteclist.get(i)).getTecrole().intValue() != 2) && (((DepartTec)departteclist.get(i)).getTecrole().intValue() != 1))
/*     */         continue;
/* 116 */       departids = departids + ((DepartTec)departteclist.get(i)).getDepartid() + ",";
/*     */     }
/*     */ 
/* 121 */     departids = departids.substring(0, departids.length() - 1);
/* 122 */     hql = "from DepartList where departid in (" + departids + ")";
/* 123 */     System.out.println("hql=" + hql);
/* 124 */     departlist.addAll(qdao.query(hql));
/* 125 */     request.setAttribute("departlist", departlist);
/*     */ 
/* 127 */     request.setAttribute("disable", "disabled");
/*     */ 
/* 130 */     ApplyResultDAO ardao = new ApplyResultDAO();
/* 131 */     List applyresultlist = new LinkedList();
/* 132 */     hql = "from ApplyResult where departid in (" + departid + ")";
/* 133 */     applyresultlist.addAll(qdao.query(hql));
/* 134 */     request.setAttribute("applyresultlist", applyresultlist);
/*     */ 
/* 137 */     hql = "select count(*) from ApplyTec where teccode='" + teccode + "'";
/* 138 */     Long j = (Long)qdao.count(hql);
/* 139 */     request.setAttribute("j", j);
/* 140 */     request.setAttribute("i", Long.valueOf(ang.getNum().intValue() - j.longValue()));
/*     */ 
/* 143 */     request.setAttribute("op", "edit");
/* 144 */     request.setAttribute("teccode", teccode);
/* 145 */     request.setAttribute("gradeid", grade.getGradeid());
/* 146 */     request.setAttribute("atid", applytec.getAtid());
/* 147 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.KetieditAction
 * JD-Core Version:    0.5.4
 */