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
/*     */ public class KetishenhedAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  61 */     HttpSession session = request.getSession();
/*  62 */     if (session.getAttribute("teccode") == null) {
/*  63 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  64 */       return mapping.findForward("error");
/*     */     }
/*  66 */     if (session.getAttribute("userrole") != "2") {
/*  67 */       request.setAttribute("notice", "您没有该项权限！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  68 */       return mapping.findForward("error");
/*     */     }
/*  70 */     KetishenbaoForm kform = (KetishenbaoForm)form;
/*     */ 
/*  72 */     Integer atid = Integer.valueOf(Integer.parseInt(request.getParameter("atid").toString()));
/*     */ 
/*  74 */     ApplyTec applytec = new ApplyTec();
/*  75 */     ApplyTecDAO atdao = new ApplyTecDAO();
/*  76 */     applytec = atdao.findById(atid);
/*  77 */     Integer departid = applytec.getDepartid();
/*  78 */     request.setAttribute("ApplyTec", applytec);
/*  79 */     request.setAttribute("tecprof", applytec.getTecprof());
/*     */ 
/*  82 */     List atrlist = new LinkedList();
/*  83 */     String hql = "from ApplyTecResult where atid=" + applytec.getAtid();
/*  84 */     System.out.println(hql);
/*  85 */     Qdao qdao = new Qdao();
/*  86 */     atrlist.addAll(qdao.query(hql));
/*  87 */     Integer[] resultids = new Integer[atrlist.size()];
/*  88 */     System.out.println("size=" + atrlist.size());
/*  89 */     for (int k = 0; k < atrlist.size(); ++k) {
/*  90 */       System.out.println(((ApplyTecResult)atrlist.get(k)).getResultid());
/*  91 */       resultids[k] = ((ApplyTecResult)atrlist.get(k)).getResultid();
/*     */     }
/*     */ 
/*  94 */     for (int k = 0; k < resultids.length; ++k) {
/*  95 */       System.out.println("resultids[" + k + "]=" + resultids[k]);
/*     */     }
/*  97 */     kform.setResultids(resultids);
/*  98 */     Integer[] rids = { Integer.valueOf(3), Integer.valueOf(4) };
/*     */ 
/* 100 */     request.setAttribute("KetishenbaoForm", kform);
/*     */ 
/* 102 */     ApplyType applytype = new ApplyType();
/* 103 */     ApplyTypeDAO typedao = new ApplyTypeDAO();
/* 104 */     List applytypelist = typedao.findByDepartid(departid);
/* 105 */     request.setAttribute("applytypelist", applytypelist);
/*     */ 
/* 109 */     ApplyNumGrade ang = new ApplyNumGrade();
/* 110 */     ApplyNumGradeDAO adao = new ApplyNumGradeDAO();
/* 111 */     ang = adao.findById(departid);
/* 112 */     GradeList grade = new GradeList();
/* 113 */     GradeListDAO gdao = new GradeListDAO();
/* 114 */     grade = gdao.findById(ang.getGradeid());
/* 115 */     request.setAttribute("gradename", grade.getGradename());
/* 116 */     request.setAttribute("gradeid", grade.getGradeid());
/* 117 */     request.setAttribute("departid", departid);
/* 118 */     String teccode = (String)session.getAttribute("teccode");
/* 119 */     DepartTecDAO dao = new DepartTecDAO();
/* 120 */     List departteclist = dao.findByTeccode(teccode);
/* 121 */     List departlist = new LinkedList();
/* 122 */     String departids = "";
/* 123 */     for (int i = 0; i < departteclist.size(); ++i) {
/* 124 */       if ((((DepartTec)departteclist.get(i)).getTecrole().intValue() != 2) && (((DepartTec)departteclist.get(i)).getTecrole().intValue() != 1))
/*     */         continue;
/* 126 */       departids = departids + ((DepartTec)departteclist.get(i)).getDepartid() + ",";
/*     */     }
/*     */ 
/* 131 */     departids = departids.substring(0, departids.length() - 1);
/* 132 */     hql = "from DepartList where departid in (" + departids + ")";
/* 133 */     System.out.println("hql=" + hql);
/* 134 */     departlist.addAll(qdao.query(hql));
/* 135 */     request.setAttribute("departlist", departlist);
/*     */ 
/* 137 */     request.setAttribute("disable", "disabled");
/*     */ 
/* 140 */     ApplyResultDAO ardao = new ApplyResultDAO();
/* 141 */     List applyresultlist = new LinkedList();
/* 142 */     hql = "from ApplyResult where departid in (" + departid + ")";
/* 143 */     applyresultlist.addAll(qdao.query(hql));
/* 144 */     request.setAttribute("applyresultlist", applyresultlist);
/*     */ 
/* 149 */     request.setAttribute("op", "shenhe1");
/* 150 */     request.setAttribute("teccode", teccode);
/* 151 */     request.setAttribute("gradeid", grade.getGradeid());
/* 152 */     request.setAttribute("atid", applytec.getAtid());
/* 153 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.KetishenhedAction
 * JD-Core Version:    0.5.4
 */