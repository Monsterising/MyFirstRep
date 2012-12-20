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
/*     */ import com.entity.wish.ApplyTypeDAO;
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
/*     */ public class KetilistAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  58 */     System.out.println("ketilist页面");
/*     */ 
/*  60 */     HttpSession session = request.getSession();
/*  61 */     if (session.getAttribute("teccode") == null) {
/*  62 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  63 */       return mapping.findForward("error");
/*     */     }
/*  65 */     String departidstring = request.getParameter("departid");
/*     */ 
/*  68 */     Integer departid = Integer.valueOf(0);
/*  69 */     if (departidstring != null) {
/*  70 */       departid = Integer.valueOf(Integer.parseInt(departidstring));
/*     */     }
/*  72 */     if (request.getAttribute("departid") != null)
/*     */     {
/*  74 */       departid = Integer.valueOf(Integer.parseInt(request.getAttribute("departid").toString()));
/*     */     }
/*     */ 
/*  78 */     String teccode = (String)session.getAttribute("teccode");
/*  79 */     DepartTec departtec = new DepartTec();
/*  80 */     DepartTecDAO dao = new DepartTecDAO();
/*  81 */     List departteclist = dao.findByTeccode(teccode);
/*     */ 
/*  83 */     List departlist = new LinkedList();
/*  84 */     String departids = "";
/*  85 */     for (int i = 0; i < departteclist.size(); ++i) {
/*  86 */       if ((((DepartTec)departteclist.get(i)).getTecrole().intValue() != 2) && (((DepartTec)departteclist.get(i)).getTecrole().intValue() != 1))
/*     */         continue;
/*  88 */       departids = departids + ((DepartTec)departteclist.get(i)).getDepartid() + ",";
/*     */     }
/*     */ 
/*  92 */     if (!departids.equals(""))
/*     */     {
/*  94 */       departids = departids.substring(0, departids.length() - 1);
/*  95 */       String hql = "from DepartList where departid in (" + departids + ")";
/*  96 */       Qdao qdao = new Qdao();
/*  97 */       System.out.println("hql=" + hql);
/*  98 */       departlist.addAll(qdao.query(hql));
/*  99 */       request.setAttribute("departlist", departlist);
/* 100 */       if (departid.intValue() != 0)
/*     */       {
/* 102 */         ApplyNumGradeDAO adao = new ApplyNumGradeDAO();
/*     */ 
/* 105 */         ApplyTypeDAO atdao = new ApplyTypeDAO();
/* 106 */         List applytypelist = new LinkedList();
/* 107 */         hql = "from ApplyType where departid in (" + departid + ")";
/* 108 */         applytypelist.addAll(qdao.query(hql));
/*     */ 
/* 110 */         ApplyNumGrade ang = new ApplyNumGrade();
/* 111 */         ang = adao.findById(departid);
/* 112 */         if (ang == null) {
/* 113 */           request.setAttribute("notice", "专业负责人尚未进行初始化操作！<br/><br/>");
/* 114 */           return mapping.findForward("error");
/*     */         }
/*     */ 
/* 117 */         ApplyResultDAO ardao = new ApplyResultDAO();
/* 118 */         List applyresultlist = new LinkedList();
/* 119 */         hql = "from ApplyResult where departid in (" + departid + ")";
/* 120 */         applyresultlist.addAll(qdao.query(hql));
/*     */ 
/* 122 */         request.setAttribute("applytypelist", applytypelist);
/* 123 */         request.setAttribute("applyresultlist", applyresultlist);
/* 124 */         request.setAttribute("atid", "");
/* 125 */         request.setAttribute("teccode", teccode);
/*     */ 
/* 127 */         hql = "select count(*) from ApplyTec where teccode='" + teccode + "'";
/* 128 */         Long j = (Long)qdao.count(hql);
/* 129 */         request.setAttribute("j", j);
/* 130 */         request.setAttribute("i", Long.valueOf(ang.getNum().intValue() - j.longValue()));
/* 131 */         request.setAttribute("gradeid", ang.getGradeid());
/* 132 */         GradeList grade = new GradeList();
/* 133 */         GradeListDAO gdao = new GradeListDAO();
/* 134 */         grade = gdao.findById(ang.getGradeid());
/* 135 */         request.setAttribute("gradename", grade.getGradename());
/*     */ 
/* 137 */         ApplyTec apply = new ApplyTec();
/* 138 */         ApplyTecDAO apdao = new ApplyTecDAO();
/* 139 */         List applylist = new LinkedList();
/* 140 */         hql = "from ApplyTec where teccode='" + teccode + "' and departid=" + departid + " and gradeid=" + grade.getGradeid();
/* 141 */         applylist.addAll(qdao.query(hql));
/* 142 */         request.setAttribute("applylist", applylist);
/*     */       }
/*     */ 
/* 150 */       request.setAttribute("departid", departid);
/* 151 */       request.setAttribute("op", "new");
/*     */     }
/*     */ 
/* 155 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.KetilistAction
 * JD-Core Version:    0.5.4
 */