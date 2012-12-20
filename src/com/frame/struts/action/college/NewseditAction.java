/*     */ package com.frame.struts.action.college;
/*     */ 
/*     */ import com.entity.basedata.CollegeList;
/*     */ import com.entity.basedata.CollegeListDAO;
/*     */ import com.entity.basedata.DepartList;
/*     */ import com.entity.basedata.DepartListDAO;
/*     */ import com.entity.basedata.DepartTec;
/*     */ import com.entity.basedata.DepartTecDAO;
/*     */ import com.entity.basedata.News;
/*     */ import com.entity.basedata.NewsDAO;
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
/*     */ import pub.toChi;
/*     */ 
/*     */ public class NewseditAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  55 */     HttpSession session = request.getSession();
/*  56 */     if ((session.getAttribute("adminid") == null) && (session.getAttribute("teccode") == null)) {
/*  57 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  58 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  62 */     if (session.getAttribute("adminid") != null) {
/*  63 */       Integer collegeid = Integer.valueOf(Integer.parseInt(session.getAttribute("collegeid").toString()));
/*  64 */       CollegeList collegelist = new CollegeList();
/*  65 */       CollegeListDAO cdao = new CollegeListDAO();
/*  66 */       collegelist = cdao.findById(collegeid);
/*  67 */       request.setAttribute("CollegeList", collegelist);
/*     */ 
/*  70 */       DepartList depart = new DepartList();
/*  71 */       DepartListDAO ddao = new DepartListDAO();
/*  72 */       List departlist = ddao.findByCollegeid(collegeid);
/*  73 */       request.setAttribute("departlist", departlist);
/*     */     }
/*  75 */     if (session.getAttribute("teccode") != null) {
/*  76 */       String teccode = (String)session.getAttribute("teccode");
/*  77 */       DepartTec departtec = new DepartTec();
/*  78 */       DepartTecDAO dao = new DepartTecDAO();
/*  79 */       List departteclist = dao.findByTeccode(teccode);
/*     */ 
/*  81 */       List departlist = new LinkedList();
/*  82 */       String departids = "";
/*  83 */       for (int i = 0; i < departteclist.size(); ++i) {
/*  84 */         if (((DepartTec)departteclist.get(i)).getTecrole().intValue() != 2)
/*     */           continue;
/*  86 */         session.setAttribute("userrole", "2");
/*  87 */         session.setAttribute("usershenfen", "专业负责人");
/*  88 */         departids = departids + ((DepartTec)departteclist.get(i)).getDepartid() + ",";
/*     */       }
/*     */ 
/*  91 */       if (!departids.equals(""))
/*     */       {
/*  93 */         departids = departids.substring(0, departids.length() - 1);
/*  94 */         String hql = "from DepartList where departid in (" + departids + ")";
/*  95 */         Qdao qdao = new Qdao();
/*  96 */         System.out.println("hql=" + hql);
/*  97 */         departlist.addAll(qdao.query(hql));
/*  98 */         request.setAttribute("departlist", departlist);
/*     */       } else {
/* 100 */         request.setAttribute("notice", "超出权限！<br/><br/><a href='./index.do' target='_parent'>返回首页</a>");
/* 101 */         return mapping.findForward("error");
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 107 */     if (request.getParameter("id") == "") {
/* 108 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/* 111 */     News news = new News();
/* 112 */     NewsDAO ndao = new NewsDAO();
/* 113 */     toChi tochi = new toChi();
/* 114 */     news = ndao.findById(Integer.valueOf(Integer.parseInt(request.getParameter("id").toString())));
/* 115 */     request.setAttribute("News", news);
/*     */ 
/* 121 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.NewseditAction
 * JD-Core Version:    0.5.4
 */