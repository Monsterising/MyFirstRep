/*     */ package com.frame.struts.action.depart;
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
/*     */ public class KetireadAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  61 */     HttpSession session = request.getSession();
/*  62 */     if (session.getAttribute("teccode") == null) {
/*  63 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  64 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  67 */     KetishenbaoForm kform = (KetishenbaoForm)form;
/*  68 */     Integer collegeid = Integer.valueOf(Integer.parseInt(session.getAttribute("collegeid").toString()));
/*  69 */     Integer atid = Integer.valueOf(Integer.parseInt(request.getParameter("atid").toString()));
/*  70 */     String stucode = (String)session.getAttribute("stucode");
/*     */ 
/*  73 */     ApplyTec applytec = new ApplyTec();
/*  74 */     ApplyTecDAO atdao = new ApplyTecDAO();
/*  75 */     applytec = atdao.findById(atid);
/*  76 */     Integer departid = applytec.getDepartid();
/*  77 */     request.setAttribute("ApplyTec", applytec);
/*  78 */     request.setAttribute("tecprof", applytec.getTecprof());
/*     */ 
/*  81 */     List atrlist = new LinkedList();
/*  82 */     String hql = "from ApplyTecResult where atid=" + applytec.getAtid();
/*     */ 
/*  84 */     Qdao qdao = new Qdao();
/*  85 */     atrlist.addAll(qdao.query(hql));
/*  86 */     Integer[] resultids = new Integer[atrlist.size()];
/*     */ 
/*  88 */     for (int k = 0; k < atrlist.size(); ++k)
/*     */     {
/*  90 */       resultids[k] = ((ApplyTecResult)atrlist.get(k)).getResultid();
/*     */     }
/*  92 */     kform.setResultids(resultids);
/*  93 */     request.setAttribute("KetishenbaoForm", kform);
/*     */ 
/*  95 */     ApplyType applytype = new ApplyType();
/*  96 */     ApplyTypeDAO typedao = new ApplyTypeDAO();
/*  97 */     List applytypelist = typedao.findByDepartid(departid);
/*  98 */     request.setAttribute("applytypelist", applytypelist);
/*     */ 
/* 101 */     ApplyNumGrade ang = new ApplyNumGrade();
/* 102 */     ApplyNumGradeDAO adao = new ApplyNumGradeDAO();
/* 103 */     ang = adao.findById(departid);
/* 104 */     GradeList grade = new GradeList();
/* 105 */     GradeListDAO gdao = new GradeListDAO();
/* 106 */     grade = gdao.findById(ang.getGradeid());
/* 107 */     request.setAttribute("gradename", grade.getGradename());
/* 108 */     request.setAttribute("departid", departid);
/*     */ 
/* 111 */     DepartListDAO departdao = new DepartListDAO();
/* 112 */     List departlist = departdao.findByCollegeid(collegeid);
/* 113 */     request.setAttribute("departlist", departlist);
/*     */ 
/* 115 */     request.setAttribute("disable", "disabled");
/*     */ 
/* 118 */     ApplyResultDAO ardao = new ApplyResultDAO();
/* 119 */     List applyresultlist = new LinkedList();
/* 120 */     hql = "from ApplyResult where departid in (" + departid + ")";
/* 121 */     applyresultlist.addAll(qdao.query(hql));
/* 122 */     request.setAttribute("applyresultlist", applyresultlist);
/* 123 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.KetireadAction
 * JD-Core Version:    0.5.4
 */