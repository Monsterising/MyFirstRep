/*     */ package com.frame.struts.action.college;
/*     */ 
/*     */ import com.entity.basedata.DepartTec;
/*     */ import com.entity.basedata.DepartTecDAO;
/*     */ import com.entity.basedata.TecList;
/*     */ import com.entity.basedata.TecListDAO;
/*     */ import com.frame.struts.baseform.AddtecForm;
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
/*     */ public class TeceditsaveAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  49 */     HttpSession session = request.getSession();
/*  50 */     if (session.getAttribute("adminid") == null) {
/*  51 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  52 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  55 */     AddtecForm aform = (AddtecForm)form;
/*     */ 
/*  57 */     toChi tochi = new toChi();
/*  58 */     String teccode = aform.getTeccode();
/*  59 */     String tecname = tochi.toChinese(aform.getTecname().trim());
/*  60 */     String tecpass = aform.getTecpass().trim();
/*  61 */     Integer[] departid = aform.getDepartid();
/*  62 */     if ((tecname.equals("")) || (departid == null)) {
/*  63 */       request.setAttribute("notice", "修改教师信息 " + teccode + " 资料失败！！！<br>每一项都不能为空！");
/*  64 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  67 */     TecList tec = new TecList();
/*  68 */     TecListDAO tdao = new TecListDAO();
/*  69 */     tec = tdao.findById(teccode);
/*  70 */     tec.setTecname(tecname);
/*  71 */     tec.setTecpass(tecpass);
/*  72 */     Transaction ts = tdao.getSession().beginTransaction();
/*     */     try {
/*  74 */       tdao.getSession().saveOrUpdate(tec);
/*  75 */       tdao.getSession().flush();
/*  76 */       ts.commit();
/*  77 */       request.setAttribute("notice", "修改教师信息 " + teccode + " 成功");
/*     */     } catch (RuntimeException re) {
/*  79 */       System.out.println("异常信息：" + re);
/*  80 */       tdao.getSession().clear();
/*  81 */       ts.rollback();
/*  82 */       request.setAttribute("notice", "修改教师信息 " + teccode + " 资料失败！！！");
/*  83 */       return mapping.findForward("error");
/*     */     } finally {
/*  85 */       tdao.getSession().close();
/*     */     }
/*     */ 
/*  90 */     Qdao qdao = new Qdao();
/*  91 */     String hql = "delete DepartTec where teccode='" + teccode + "'";
/*  92 */     qdao.del(hql);
/*     */ 
/*  94 */     if (departid != null) {
/*  95 */       DepartTecDAO ccdao = new DepartTecDAO();
/*  96 */       Transaction cts = ccdao.getSession().beginTransaction();
/*  97 */       for (Integer j = Integer.valueOf(0); j.intValue() < departid.length; j = Integer.valueOf(j.intValue() + 1)) {
/*  98 */         Integer tecrole = Integer.valueOf(Integer.parseInt(request.getParameter(departid[j.intValue()].toString())));
/*  99 */         DepartTec departtec2 = new DepartTec();
/* 100 */         departtec2.setDepartid(departid[j.intValue()]);
/* 101 */         departtec2.setTeccode(teccode);
/* 102 */         departtec2.setTecrole(tecrole);
/* 103 */         ccdao.getSession().save(departtec2);
/*     */       }
/* 105 */       ccdao.getSession().flush();
/* 106 */       ccdao.getSession().clear();
/* 107 */       cts.commit();
/* 108 */       System.out.println("成功更新专业负责人、指导教师，teccode=" + teccode);
/*     */     }
/*     */ 
/* 111 */     return mapping.findForward("list");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.TeceditsaveAction
 * JD-Core Version:    0.5.4
 */