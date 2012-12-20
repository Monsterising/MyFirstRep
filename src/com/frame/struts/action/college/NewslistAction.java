/*     */ package com.frame.struts.action.college;
/*     */ 
/*     */ import com.entity.basedata.CollegeList;
/*     */ import com.entity.basedata.CollegeListDAO;
/*     */ import com.entity.basedata.DepartList;
/*     */ import com.entity.basedata.DepartListDAO;
/*     */ import com.entity.basedata.News;
/*     */ import com.entity.basedata.NewsDAO;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.apache.struts.action.Action;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionForward;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ import pub.toChi;
/*     */ 
/*     */ public class NewslistAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  53 */     HttpSession session = request.getSession();
/*  54 */     if (session.getAttribute("adminid") == null) {
/*  55 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  56 */       return mapping.findForward("error");
/*     */     }
/*  58 */     Integer collegeid = Integer.valueOf(Integer.parseInt(session.getAttribute("collegeid").toString()));
/*  59 */     CollegeList collegelist = new CollegeList();
/*  60 */     CollegeListDAO cdao = new CollegeListDAO();
/*  61 */     collegelist = cdao.findById(collegeid);
/*  62 */     request.setAttribute("CollegeList", collegelist);
/*     */ 
/*  65 */     DepartList depart = new DepartList();
/*  66 */     DepartListDAO ddao = new DepartListDAO();
/*  67 */     List departlist = ddao.findByCollegeid(collegeid);
/*  68 */     request.setAttribute("departlist", departlist);
/*     */ 
/*  70 */     News news = new News();
/*  71 */     NewsDAO dao = new NewsDAO();
/*  72 */     String pageString = request.getParameter("page");
/*  73 */     String keywords = request.getParameter("keywords");
/*  74 */     toChi toChi = new toChi();
/*  75 */     keywords = toChi.toChinese(keywords);
/*  76 */     if ((pageString == null) || (pageString.length() == 0)) {
/*  77 */       pageString = "1";
/*     */     }
/*  79 */     int currentPage = 1;
/*     */     try {
/*  81 */       currentPage = Integer.parseInt(pageString); } catch (Exception localException) {
/*     */     }
/*  83 */     int pageSize = 20;
/*     */ 
/*  85 */     String nt = request.getParameter("t");
/*  86 */     if ((nt == null) || (nt.length() == 0)) {
/*  87 */       nt = "0";
/*     */     }
/*  89 */     Integer departid = Integer.valueOf(Integer.parseInt(nt));
/*     */ 
/* 101 */     List newslist = dao.findPageAll(Integer.valueOf(currentPage), Integer.valueOf(pageSize), departid);
/* 102 */     request.setAttribute("totalPage", dao.getTotalPage(Integer.valueOf(pageSize), departid, keywords));
/* 103 */     request.setAttribute("totalCount", dao.getTotalCount(departid, keywords));
/*     */ 
/* 105 */     request.setAttribute("newslist", newslist);
/* 106 */     request.setAttribute("currentPage", Integer.valueOf(currentPage));
/* 107 */     if (departid == null) departid = Integer.valueOf(0);
/* 108 */     request.setAttribute("departid", departid);
/* 109 */     request.setAttribute("pageSize", Integer.valueOf(pageSize));
/*     */ 
/* 112 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.NewslistAction
 * JD-Core Version:    0.5.4
 */