/*     */ package com.frame.struts.action.college;
/*     */ 
/*     */ import com.entity.basedata.DepartList;
/*     */ import com.entity.basedata.DepartListDAO;
/*     */ import com.entity.basedata.DepartTec;
/*     */ import com.entity.basedata.TecListDAO;
/*     */ import com.frame.struts.baseform.DepartlistForm;
/*     */ import java.io.PrintStream;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.apache.struts.action.Action;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionForward;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ import org.hibernate.Session;
/*     */ import pub.Qdao;
/*     */ 
/*     */ public class DeparteditAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  45 */     HttpSession session = request.getSession();
/*  46 */     if (session.getAttribute("adminid") == null) {
/*  47 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  48 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  51 */     DepartlistForm departlistForm = (DepartlistForm)form;
/*     */ 
/*  55 */     if (request.getParameter("id") == null) {
/*  56 */       request.setAttribute("notice", "参数错误！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  57 */       return mapping.findForward("error");
/*     */     }
/*  59 */     Integer departid = Integer.valueOf(Integer.parseInt(request.getParameter("id").toString()));
/*     */ 
/*  61 */     DepartListDAO ddao = new DepartListDAO();
/*  62 */     DepartList depart = (DepartList)ddao.getSession().load(DepartList.class, departid);
/*  63 */     request.setAttribute("depart", depart);
/*     */ 
/*  66 */     Integer collegeid = Integer.valueOf(Integer.parseInt(session.getAttribute("collegeid").toString()));
/*  67 */     TecListDAO tdao = new TecListDAO();
/*  68 */     List teclist = tdao.findByCollegeid(collegeid);
/*  69 */     request.setAttribute("teclist", teclist);
/*     */ 
/*  73 */     Qdao qdao = new Qdao();
/*  74 */     String hql = "from DepartTec where departid=" + departid + " and tecrole=" + 2;
/*  75 */     List<DepartTec> dalist = qdao.query(hql);
/*     */ 
/*  77 */     Integer size = Integer.valueOf(dalist.size());
/*  78 */     System.out.println("数组长度：" + size);
/*  79 */     String[] departadmin = new String[size.intValue()];
/*  80 */     Integer j = Integer.valueOf(0);
/*  81 */     for (DepartTec ob : dalist) {
/*  82 */       departadmin[j.intValue()] = ob.getTeccode();
/*  83 */       j = Integer.valueOf(j.intValue() + 1);
/*     */     }
/*  85 */     departlistForm.setDepartadmin(departadmin);
/*     */ 
/*  88 */     hql = "from DepartTec where departid=" + departid + " and tecrole=" + 1;
/*  89 */     List<DepartTec> dtlist = qdao.query(hql);
/*     */ 
/*  91 */     size = Integer.valueOf(dtlist.size());
/*  92 */     System.out.println("数组长度：" + size);
/*  93 */     String[] departtec = new String[size.intValue()];
/*  94 */     j = Integer.valueOf(0);
/*  95 */     for (DepartTec ob : dtlist) {
/*  96 */       departtec[j.intValue()] = ob.getTeccode();
/*  97 */       j = Integer.valueOf(j.intValue() + 1);
/*     */     }
/*  99 */     departlistForm.setDeparttec(departtec);
/*     */ 
/* 101 */     request.setAttribute("DepartlistForm", departlistForm);
/*     */ 
/* 103 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.DeparteditAction
 * JD-Core Version:    0.5.4
 */