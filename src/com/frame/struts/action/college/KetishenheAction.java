/*     */ package com.frame.struts.action.college;
/*     */ 
/*     */ import com.entity.basedata.DepartListDAO;
/*     */ import com.entity.basedata.GradeList;
/*     */ import com.entity.basedata.GradeListDAO;
/*     */ import com.entity.wish.ApplyNumGrade;
/*     */ import com.entity.wish.ApplyNumGradeDAO;
/*     */ import com.entity.wish.ApplyResultDAO;
/*     */ import com.entity.wish.ApplyTec;
/*     */ import com.entity.wish.ApplyTecDAO;
/*     */ import com.entity.wish.ApplyTecResult;
/*     */ import com.entity.wish.ApplyType;
/*     */ import com.entity.wish.ApplyTypeDAO;
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
/*     */ public class KetishenheAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  60 */     KetishenbaoForm kform = (KetishenbaoForm)form;
/*  61 */     HttpSession session = request.getSession();
/*  62 */     if (session.getAttribute("adminid") == null) {
/*  63 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  64 */       return mapping.findForward("error");
/*     */     }
/*  66 */     Integer collegeid = Integer.valueOf(Integer.parseInt(session.getAttribute("collegeid").toString()));
/*  67 */     Integer atid = Integer.valueOf(Integer.parseInt(request.getParameter("atid").toString()));
/*     */ 
/*  69 */     ApplyTec applytec = new ApplyTec();
/*  70 */     ApplyTecDAO atdao = new ApplyTecDAO();
/*  71 */     applytec = atdao.findById(atid);
/*  72 */     Integer departid = applytec.getDepartid();
/*  73 */     request.setAttribute("ApplyTec", applytec);
/*  74 */     request.setAttribute("tecprof", applytec.getTecprof());
/*     */ 
/*  77 */     List atrlist = new LinkedList();
/*  78 */     String hql = "from ApplyTecResult where atid=" + applytec.getAtid();
/*  79 */     System.out.println(hql);
/*  80 */     Qdao qdao = new Qdao();
/*  81 */     atrlist.addAll(qdao.query(hql));
/*  82 */     Integer[] resultids = new Integer[atrlist.size()];
/*  83 */     System.out.println("size=" + atrlist.size());
/*  84 */     for (int k = 0; k < atrlist.size(); ++k) {
/*  85 */       System.out.println(((ApplyTecResult)atrlist.get(k)).getResultid());
/*  86 */       resultids[k] = ((ApplyTecResult)atrlist.get(k)).getResultid();
/*     */     }
/*  88 */     kform.setResultids(resultids);
/*  89 */     request.setAttribute("KetishenbaoForm", kform);
/*     */ 
/*  91 */     ApplyType applytype = new ApplyType();
/*  92 */     ApplyTypeDAO typedao = new ApplyTypeDAO();
/*  93 */     List applytypelist = typedao.findByDepartid(departid);
/*  94 */     request.setAttribute("applytypelist", applytypelist);
/*     */ 
/*  97 */     ApplyNumGrade ang = new ApplyNumGrade();
/*  98 */     ApplyNumGradeDAO adao = new ApplyNumGradeDAO();
/*  99 */     ang = adao.findById(departid);
/* 100 */     GradeList grade = new GradeList();
/* 101 */     GradeListDAO gdao = new GradeListDAO();
/* 102 */     grade = gdao.findById(ang.getGradeid());
/* 103 */     request.setAttribute("gradename", grade.getGradename());
/* 104 */     request.setAttribute("departid", departid);
/*     */ 
/* 107 */     DepartListDAO departdao = new DepartListDAO();
/* 108 */     List departlist = departdao.findByCollegeid(collegeid);
/* 109 */     request.setAttribute("departlist", departlist);
/*     */ 
/* 111 */     request.setAttribute("disable", "disabled");
/*     */ 
/* 114 */     ApplyResultDAO ardao = new ApplyResultDAO();
/* 115 */     List applyresultlist = new LinkedList();
/* 116 */     hql = "from ApplyResult where departid in (" + departid + ")";
/* 117 */     applyresultlist.addAll(qdao.query(hql));
/* 118 */     request.setAttribute("applyresultlist", applyresultlist);
/*     */ 
/* 123 */     request.setAttribute("op", "shenhe2");
/* 124 */     request.setAttribute("gradeid", grade.getGradeid());
/* 125 */     request.setAttribute("atid", applytec.getAtid());
/* 126 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.KetishenheAction
 * JD-Core Version:    0.5.4
 */