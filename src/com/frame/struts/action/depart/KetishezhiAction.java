/*     */ package com.frame.struts.action.depart;
/*     */ 
/*     */ import com.entity.basedata.DepartTec;
/*     */ import com.entity.basedata.DepartTecDAO;
/*     */ import com.entity.basedata.GradeListDAO;
/*     */ import com.entity.wish.ApplyNumGradeDAO;
/*     */ import com.entity.wish.ApplyResultDAO;
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
/*     */ public class KetishezhiAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  59 */     HttpSession session = request.getSession();
/*  60 */     if (session.getAttribute("teccode") == null) {
/*  61 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  62 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  66 */     String teccode = (String)session.getAttribute("teccode");
/*  67 */     DepartTec departtec = new DepartTec();
/*  68 */     DepartTecDAO dao = new DepartTecDAO();
/*  69 */     List departteclist = dao.findByTeccode(teccode);
/*     */ 
/*  71 */     List departlist = new LinkedList();
/*  72 */     String departids = "";
/*  73 */     for (int i = 0; i < departteclist.size(); ++i) {
/*  74 */       if (((DepartTec)departteclist.get(i)).getTecrole().intValue() != 2)
/*     */         continue;
/*  76 */       session.setAttribute("userrole", Integer.valueOf(2));
/*  77 */       session.setAttribute("usershenfen", "专业负责人");
/*  78 */       departids = departids + ((DepartTec)departteclist.get(i)).getDepartid() + ",";
/*     */     }
/*     */ 
/*  82 */     if (!departids.equals(""))
/*     */     {
/*  84 */       departids = departids.substring(0, departids.length() - 1);
/*  85 */       String hql = "from DepartList where departid in (" + departids + ")";
/*  86 */       Qdao qdao = new Qdao();
/*     */ 
/*  88 */       departlist.addAll(qdao.query(hql));
/*  89 */       request.setAttribute("departlist", departlist);
/*     */ 
/*  91 */       ApplyNumGradeDAO adao = new ApplyNumGradeDAO();
/*  92 */       List applynumgradelist = adao.findAll();
/*     */ 
/* 101 */       ApplyResultDAO ardao = new ApplyResultDAO();
/* 102 */       List applyresultlist = new LinkedList();
/* 103 */       hql = "from ApplyResult where departid in (" + departids + ")";
/* 104 */       applyresultlist.addAll(qdao.query(hql));
/*     */ 
/* 106 */       request.setAttribute("applynumgradelist", applynumgradelist);
/*     */ 
/* 108 */       request.setAttribute("applyresultlist", applyresultlist);
/*     */ 
/* 111 */       GradeListDAO gdao = new GradeListDAO();
/* 112 */       List gradelist = gdao.findAll();
/* 113 */       request.setAttribute("gradelist", gradelist);
/* 114 */       request.setAttribute("op", "ok");
/* 115 */       return mapping.findForward("display");
/*     */     }
/* 117 */     request.setAttribute("notice", "您暂时没有该项权限");
/* 118 */     return mapping.findForward("error");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.KetishezhiAction
 * JD-Core Version:    0.5.4
 */