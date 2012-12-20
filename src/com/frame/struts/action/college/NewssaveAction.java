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
/*     */ import com.frame.struts.form.NewsForm;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Date;
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
/*     */ import org.hibernate.Transaction;
/*     */ import pub.Qdao;
/*     */ import pub.toChi;
/*     */ 
/*     */ public class NewssaveAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  56 */     NewsForm nform = (NewsForm)form;
/*     */ 
/*  58 */     HttpSession session = request.getSession();
/*  59 */     if ((session.getAttribute("adminid") == null) && (session.getAttribute("teccode") == null)) {
/*  60 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  61 */       return mapping.findForward("error");
/*     */     }
/*  63 */     String shenfen = "";
/*  64 */     if (session.getAttribute("adminid") != null) {
/*  65 */       Integer collegeid = Integer.valueOf(Integer.parseInt(session.getAttribute("collegeid").toString()));
/*  66 */       CollegeList collegelist = new CollegeList();
/*  67 */       CollegeListDAO cdao = new CollegeListDAO();
/*  68 */       collegelist = cdao.findById(collegeid);
/*  69 */       request.setAttribute("CollegeList", collegelist);
/*     */ 
/*  71 */       DepartList depart = new DepartList();
/*  72 */       DepartListDAO ddao = new DepartListDAO();
/*  73 */       List departlist = ddao.findByCollegeid(collegeid);
/*  74 */       request.setAttribute("departlist", departlist);
/*  75 */       shenfen = "college";
/*     */     }
/*     */     Qdao qdao;
/*  78 */     if (session.getAttribute("teccode") != null) {
/*  79 */       String teccode = (String)session.getAttribute("teccode");
/*  80 */       DepartTec departtec = new DepartTec();
/*  81 */       DepartTecDAO dao = new DepartTecDAO();
/*  82 */       List departteclist = dao.findByTeccode(teccode);
/*     */ 
/*  84 */       List departlist = new LinkedList();
/*  85 */       String departids = "";
/*  86 */       for (int i = 0; i < departteclist.size(); ++i) {
/*  87 */         if (((DepartTec)departteclist.get(i)).getTecrole().intValue() != 2)
/*     */           continue;
/*  89 */         session.setAttribute("userrole", "2");
/*  90 */         session.setAttribute("usershenfen", "depart");
/*  91 */         departids = departids + ((DepartTec)departteclist.get(i)).getDepartid() + ",";
/*     */       }
/*     */ 		String hql="";
/*  95 */       if (!departids.equals(""))
/*     */       {
/*  97 */         departids = departids.substring(0, departids.length() - 1);
/*  98 */         hql = "from DepartList where departid in (" + departids + ")";
/*  99 */         qdao = new Qdao();
/* 100 */         System.out.println("hql=" + hql);
/* 101 */         departlist.addAll(qdao.query(hql));
/* 102 */         request.setAttribute("departlist", departlist);
/* 103 */         request.setAttribute("usershenfen", "depart");
/* 104 */         shenfen = "depart";
/*     */       } else {
/* 106 */         request.setAttribute("notice", "超出权限！<br/><br/><a href='./index.do' target='_parent'>返回首页</a>");
/* 107 */         return mapping.findForward("error");
/*     */       }
/*     */     }
/*     */ 	  
/* 111 */     if ((shenfen.equals("college")) || (shenfen.equals("depart"))) {
/* 112 */       News news = new News();
/* 113 */       NewsDAO ndao = new NewsDAO();
/* 114 */       toChi tochi = new toChi();
/* 115 */       Date date = new Date();
/* 116 */       if (nform.getNewsid().intValue() != 0) {
/* 117 */         news = ndao.findById(nform.getNewsid());
/*     */       }
/* 119 */       news.setAdduser(session.getAttribute("userrealname").toString());
/* 120 */       news.setContent(tochi.toChinese(nform.getContent()));
/* 121 */       news.setDepartid(nform.getDepartid());
/* 122 */       news.setTitle(tochi.toChinese(nform.getTitle()));
/* 123 */       news.setUptime(date);
/* 124 */       Transaction ts = ndao.getSession().beginTransaction();
/*     */       try {
/* 126 */         ndao.getSession().saveOrUpdate(news);
/* 127 */         ts.commit();
/* 128 */         ndao.getSession().flush();
/* 129 */         request.setAttribute("notice", "保存信息成功！！！");
/* 130 */         if (shenfen.equals("college")) { 
					//qdao = mapping.findForward("list");
/*     */           return mapping.findForward("list"); }
/*     */ 
/* 131 */         if (shenfen.equals("depart")) { 
					//qdao = ;
/*     */ 
/* 139 */           return mapping.findForward("newsindexdepart"); }
/*     */ 
/*     */       }
/*     */       catch (RuntimeException re)
/*     */       {
/* 133 */         System.out.println("异常信息：" + re);
/* 134 */         ndao.getSession().clear();
/* 135 */         ts.rollback();
/* 136 */         request.setAttribute("notice", "保存资料失败！！！");
/* 137 */         return mapping.findForward("error");
/*     */       } finally {
/* 139 */         ndao.getSession().close(); } ndao.getSession().close();
/*     */     }
/*     */     else
/*     */     {
/* 143 */       request.setAttribute("notice", "超出权限，保存资料失败！！！");
/* 144 */       return mapping.findForward("error");
/*     */     }
/* 146 */     return mapping.findForward("error");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.NewssaveAction
 * JD-Core Version:    0.5.4
 */