/*     */ package com.frame.struts.action.depart;
/*     */ 
/*     */ import com.entity.basedata.DepartTec;
/*     */ import com.entity.basedata.DepartTecDAO;
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
/*     */ public class KetishenhelistdAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  59 */     HttpSession session = request.getSession();
/*  60 */     if (session.getAttribute("teccode") == null) {
/*  61 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  62 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  65 */     String teccode = (String)session.getAttribute("teccode");
/*  66 */     DepartTec departtec = new DepartTec();
/*  67 */     DepartTecDAO dao = new DepartTecDAO();
/*  68 */     List departteclist = dao.findByTeccode(teccode);
/*     */ 
/*  70 */     List departlist = new LinkedList();
/*  71 */     String departids = "";
/*  72 */     for (int i = 0; i < departteclist.size(); ++i) {
/*  73 */       if (((DepartTec)departteclist.get(i)).getTecrole().intValue() != 2)
/*     */         continue;
/*  75 */       session.setAttribute("userrole", "2");
/*  76 */       session.setAttribute("usershenfen", "专业负责人");
/*  77 */       departids = departids + ((DepartTec)departteclist.get(i)).getDepartid() + ",";
/*     */     }
/*     */ 
/*  82 */     if (departids.equals("")) {
/*  83 */       request.setAttribute("notice", "您没有该项权限");
/*  84 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  87 */     String departidstring = request.getParameter("departid");
/*  88 */     Integer departid = Integer.valueOf(0);
/*  89 */     if (departidstring != null) {
/*  90 */       departid = Integer.valueOf(Integer.parseInt(departidstring));
/*     */     }
/*  92 */     if (request.getAttribute("departid") != null)
/*     */     {
/*  94 */       departid = Integer.valueOf(Integer.parseInt(request.getAttribute("departid").toString()));
/*     */     }
/*     */ 
/*  98 */     request.setAttribute("disable", "disabled");
/*  99 */     if (departid.intValue() != 0) {
/* 100 */       request.setAttribute("disable", "");
/* 101 */       Qdao qdao = new Qdao();
/* 102 */       ApplyTec apply = new ApplyTec();
/* 103 */       ApplyTecDAO apdao = new ApplyTecDAO();
/*     */ 
/* 105 */       List applylist = new LinkedList();
/* 106 */       ApplyNumGrade ang = new ApplyNumGrade();
/* 107 */       ApplyNumGradeDAO adao = new ApplyNumGradeDAO();
/* 108 */       ang = adao.findById(departid);
/* 109 */       GradeList grade = new GradeList();
/* 110 */       GradeListDAO gdao = new GradeListDAO();
/* 111 */       grade = gdao.findById(ang.getGradeid());
/* 112 */       request.setAttribute("gradename", grade.getGradename());
/* 113 */       String hql = "from ApplyTec where departid=" + departid + " and gradeid=" + grade.getGradeid();
/*     */ 
/* 115 */       if ((request.getParameter("zt") != null) && (!request.getParameter("zt").equals("0"))) {
/* 116 */         hql = hql + " and advice1='" + request.getParameter("zt").toString() + "'";
/* 117 */         System.out.println(hql);
/* 118 */         request.setAttribute("zt", request.getParameter("zt").toString());
/*     */       }
/* 120 */       applylist.addAll(qdao.query(hql));
/* 121 */       request.setAttribute("applylist", applylist);
/*     */ 
/* 123 */       hql = "select count(*) from ApplyTec where departid=" + departid + " and gradeid=" + grade.getGradeid();
/* 124 */       request.setAttribute("countall", qdao.count(hql));
/*     */ 
/* 126 */       String hql1 = ""; String hql2 = "";
/* 127 */       hql1 = hql + " and advice1='通过'";
/* 128 */       hql2 = hql + " and advice2='通过'";
/* 129 */       request.setAttribute("countdepart", qdao.count(hql1));
/* 130 */       request.setAttribute("countcollege", qdao.count(hql2));
/*     */ 
/* 132 */       String hql3 = "";
/* 133 */       hql3 = "select count(*) from StuList where gradeid=" + grade.getGradeid();
/* 134 */       request.setAttribute("stusum", qdao.count(hql3));
/*     */ 
/* 137 */       Integer collegeid = Integer.valueOf(Integer.parseInt(session.getAttribute("collegeid").toString()));
/* 138 */       List teclist = new LinkedList();
/* 139 */       hql = "from TecList where collegeid=" + collegeid;
/* 140 */       teclist.addAll(qdao.query(hql));
/* 141 */       request.setAttribute("teclist", teclist);
/*     */     }
/*     */ 
/* 149 */     if (!departids.equals(""))
/*     */     {
/* 151 */       departids = departids.substring(0, departids.length() - 1);
/* 152 */       String hql = "from DepartList where departid in (" + departids + ")";
/* 153 */       Qdao qdao = new Qdao();
/* 154 */       System.out.println("hql=" + hql);
/* 155 */       departlist.addAll(qdao.query(hql));
/* 156 */       request.setAttribute("departlist", departlist);
/*     */     }
/*     */ 
/* 190 */     request.setAttribute("departid", departid);
/*     */ 
/* 194 */     ApplyTec applytec = new ApplyTec();
/* 195 */     ApplyTecDAO applydao = new ApplyTecDAO();
/* 196 */     List applylist = new LinkedList();
/*     */ 
/* 201 */     request.setAttribute("op", "new");
/*     */ 
/* 205 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.KetishenhelistdAction
 * JD-Core Version:    0.5.4
 */