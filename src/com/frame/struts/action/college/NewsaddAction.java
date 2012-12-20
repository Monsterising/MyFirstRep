/*     */ package com.frame.struts.action.college;
/*     */ 
/*     */ import com.entity.basedata.CollegeList;
/*     */ import com.entity.basedata.CollegeListDAO;
/*     */ import com.entity.basedata.DepartList;
/*     */ import com.entity.basedata.DepartListDAO;
/*     */ import com.entity.basedata.DepartTec;
/*     */ import com.entity.basedata.DepartTecDAO;
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
/*     */ public class NewsaddAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  51 */     HttpSession session = request.getSession();
/*  52 */     if ((session.getAttribute("teccode") == null) && (session.getAttribute("adminid") == null)) {
/*  53 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  54 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  58 */     if (session.getAttribute("adminid") != null) {
/*  59 */       Integer collegeid = Integer.valueOf(Integer.parseInt(session.getAttribute("collegeid").toString()));
/*  60 */       CollegeList collegelist = new CollegeList();
/*  61 */       CollegeListDAO cdao = new CollegeListDAO();
/*  62 */       collegelist = cdao.findById(collegeid);
/*  63 */       request.setAttribute("CollegeList", collegelist);
/*     */ 
/*  66 */       DepartList depart = new DepartList();
/*  67 */       DepartListDAO ddao = new DepartListDAO();
/*  68 */       List departlist = ddao.findByCollegeid(collegeid);
/*  69 */       request.setAttribute("departlist", departlist);
/*     */     }
/*  71 */     if (session.getAttribute("teccode") != null) {
/*  72 */       String teccode = (String)session.getAttribute("teccode");
/*  73 */       DepartTec departtec = new DepartTec();
/*  74 */       DepartTecDAO dao = new DepartTecDAO();
/*  75 */       List departteclist = dao.findByTeccode(teccode);
/*     */ 
/*  77 */       List departlist = new LinkedList();
/*  78 */       String departids = "";
/*  79 */       for (int i = 0; i < departteclist.size(); ++i) {
/*  80 */         if (((DepartTec)departteclist.get(i)).getTecrole().intValue() != 2)
/*     */           continue;
/*  82 */         session.setAttribute("userrole", "2");
/*  83 */         session.setAttribute("usershenfen", "depart");
/*  84 */         departids = departids + ((DepartTec)departteclist.get(i)).getDepartid() + ",";
/*     */       }
/*     */ 
/*  88 */       if (!departids.equals(""))
/*     */       {
/*  90 */         departids = departids.substring(0, departids.length() - 1);
/*  91 */         String hql = "from DepartList where departid in (" + departids + ")";
/*  92 */         Qdao qdao = new Qdao();
/*  93 */         System.out.println("hql=" + hql);
/*  94 */         departlist.addAll(qdao.query(hql));
/*  95 */         request.setAttribute("departlist", departlist);
/*  96 */         request.setAttribute("usershenfen", "depart");
/*     */       } else {
/*  98 */         request.setAttribute("notice", "超出权限！<br/><br/><a href='./index.do' target='_parent'>返回首页</a>");
/*  99 */         return mapping.findForward("error");
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 104 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.NewsaddAction
 * JD-Core Version:    0.5.4
 */