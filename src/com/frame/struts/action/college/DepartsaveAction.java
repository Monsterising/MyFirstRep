/*     */ package com.frame.struts.action.college;
/*     */ 
/*     */ import com.entity.basedata.DepartList;
/*     */ import com.entity.basedata.DepartListDAO;
/*     */ import com.entity.basedata.DepartTec;
/*     */ import com.entity.basedata.DepartTecDAO;
/*     */ import com.frame.struts.baseform.DepartlistForm;
/*     */ import java.io.PrintStream;
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
/*     */ public class DepartsaveAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  49 */     DepartlistForm dform = (DepartlistForm)form;
/*  50 */     HttpSession session = request.getSession();
/*  51 */     if (session.getAttribute("adminid") == null) {
/*  52 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  53 */       return mapping.findForward("error");
/*     */     }
/*  55 */     toChi tochi = new toChi();
/*  56 */     Integer departid = dform.getDepartid();
/*  57 */     String departname = tochi.toChinese(dform.getDepartname().trim());
/*  58 */     String[] departadmin = dform.getDepartadmin();
/*  59 */     String[] departtec = dform.getDeparttec();
/*     */ 
/*  64 */     if ((departname.equals("")) || (departadmin == null) || (departtec == null)) {
/*  65 */       request.setAttribute("notice", "修改专业 " + departname + " 资料失败！！！<br>每一项都不能为空！");
/*  66 */       return mapping.findForward("error");
/*     */     }
/*  68 */     DepartList depart = new DepartList();
/*  69 */     DepartListDAO ddao = new DepartListDAO();
/*  70 */     depart = ddao.findById(departid);
/*  71 */     depart.setDepartname(departname);
/*  72 */     Transaction ts = ddao.getSession().beginTransaction();
/*     */     try {
/*  74 */       ddao.getSession().saveOrUpdate(depart);
/*  75 */       ddao.getSession().flush();
/*  76 */       ts.commit();
/*  77 */       request.setAttribute("notice", "修改专业 " + departname + " 资料成功");
/*     */     } catch (RuntimeException re) {
/*  79 */       System.out.println("异常信息：" + re);
/*  80 */       ddao.getSession().clear();
/*  81 */       ts.rollback();
/*  82 */       request.setAttribute("notice", "修改专业 " + departname + " 资料失败！！！");
/*  83 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  89 */     Qdao qdao = new Qdao();
/*  90 */     String hql = "delete DepartTec where departid=" + departid;
/*  91 */     qdao.del(hql);
/*     */ 
/*  93 */     if ((departadmin != null) && (departtec != null)) {
/*  94 */       DepartTecDAO ccdao = new DepartTecDAO();
/*  95 */       Transaction cts = ccdao.getSession().beginTransaction();
/*  96 */       for (Integer j = Integer.valueOf(0); j.intValue() < departadmin.length; j = Integer.valueOf(j.intValue() + 1)) {
/*  97 */         String teccode = request.getParameter("admin" + departadmin[j.intValue()].toString());
/*  98 */         DepartTec departtec2 = new DepartTec();
/*  99 */         departtec2.setDepartid(departid);
/* 100 */         departtec2.setTeccode(teccode);
/* 101 */         departtec2.setTecrole(Integer.valueOf(2));
/* 102 */         ccdao.getSession().save(departtec2);
/*     */       }
/* 104 */       for (Integer j = Integer.valueOf(0); j.intValue() < departtec.length; j = Integer.valueOf(j.intValue() + 1)) {
/* 105 */         String teccode = request.getParameter("tec" + departtec[j.intValue()].toString());
/* 106 */         DepartTec departtec2 = new DepartTec();
/* 107 */         departtec2.setDepartid(departid);
/* 108 */         departtec2.setTeccode(teccode);
/* 109 */         departtec2.setTecrole(Integer.valueOf(1));
/* 110 */         ccdao.getSession().save(departtec2);
/*     */       }
/*     */ 
/* 113 */       ccdao.getSession().flush();
/* 114 */       ccdao.getSession().clear();
/* 115 */       cts.commit();
/* 116 */       System.out.println("成功更新专业负责人、指导教师，departid=" + departid);
/*     */     }
/*     */ 
/* 119 */     return mapping.findForward("list");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.DepartsaveAction
 * JD-Core Version:    0.5.4
 */