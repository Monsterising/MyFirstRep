/*     */ package com.frame.struts.action.dabian;
/*     */ 
/*     */ import com.entity.dabian.DabianGroup;
/*     */ import com.entity.dabian.DabianGroupDAO;
/*     */ import com.entity.dabian.DabianGroupStu;
/*     */ import com.entity.dabian.DabianGroupStuDAO;
/*     */ import com.entity.dabian.DabianGroupTec;
/*     */ import com.entity.dabian.DabianGroupTecDAO;
/*     */ import com.frame.struts.form.dabian.DabiangroupForm;
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
/*     */ public class DabiangroupsaveAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  52 */     DabiangroupForm gform = (DabiangroupForm)form;
/*  53 */     HttpSession session = request.getSession();
/*  54 */     if (session.getAttribute("teccode") == null) {
/*  55 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  56 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  59 */     if (session.getAttribute("usershenfen") == null) {
/*  60 */       request.setAttribute("notice", "您没有该项权限！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  61 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  64 */     toChi tochi = new toChi();
/*  65 */     String[] stucodes = gform.getStucodes();
/*  66 */     String[] teccodes = gform.getTeccodes();
/*  67 */     Integer departid = gform.getDepartid();
/*  68 */     Integer gradeid = gform.getGradeid();
/*  69 */     Integer collegeid = gform.getCollegeid();
/*  70 */     String op = gform.getOp();
/*  71 */     String datetime = tochi.toChinese(gform.getDatetime());
/*  72 */     String place = tochi.toChinese(gform.getPlace());
/*     */ 
/*  76 */     DabianGroup dg = new DabianGroup();
/*  77 */     DabianGroupDAO dgdao = new DabianGroupDAO();
/*     */ 
/*  79 */     if ((op.equals("edit")) && (gform.getDbgid().intValue() != 0)) {
/*  80 */       dg = dgdao.findById(gform.getDbgid());
/*     */     }
/*     */ 
/*  84 */     dg.setChairman(gform.getChairman());
/*  85 */     dg.setCollegeid(collegeid);
/*  86 */     dg.setDepartid(departid);
/*  87 */     dg.setGradeid(gradeid);
/*  88 */     dg.setGroupname(tochi.toChinese(gform.getGroupname()));
/*  89 */     dg.setLeader(gform.getLeader());
/*  90 */     dg.setDatetime(datetime);
/*  91 */     dg.setPlace(place);
/*     */ 
/*  94 */     Transaction dgts = dgdao.getSession().beginTransaction();
/*  95 */     dgdao.getSession().saveOrUpdate(dg);
/*  96 */     dgdao.getSession().flush();
/*  97 */     dgts.commit();
/*     */ 
/* 100 */     Qdao qdao = new Qdao();
/* 101 */     String hql = "";
/* 102 */     hql = "delete DabianGroupTec where dbgid=" + dg.getDbgid();
/* 103 */     qdao.del(hql);
/*     */ 
/* 105 */     if (teccodes != null) {
/* 106 */       DabianGroupTecDAO tdao = new DabianGroupTecDAO();
/* 107 */       Transaction ts = tdao.getSession().beginTransaction();
/* 108 */       for (int i = 0; i < teccodes.length; ++i) {
/* 109 */         DabianGroupTec dgt = new DabianGroupTec();
/* 110 */         dgt.setDbgid(dg.getDbgid());
/* 111 */         dgt.setTeccode(teccodes[i]);
/* 112 */         tdao.getSession().save(dgt);
/* 113 */       }tdao.getSession().flush();
/* 114 */       tdao.getSession().clear();
/* 115 */       ts.commit();
/*     */     }
/*     */ 
/* 119 */     hql = "delete DabianGroupStu where dbgid=" + dg.getDbgid();
/* 120 */     qdao.del(hql);
/*     */ 
/* 122 */     if (stucodes != null) {
/* 123 */       DabianGroupStuDAO tdao = new DabianGroupStuDAO();
/* 124 */       Transaction ts = tdao.getSession().beginTransaction();
/* 125 */       for (int i = 0; i < stucodes.length; ++i) {
/* 126 */         DabianGroupStu dgt = new DabianGroupStu();
/* 127 */         dgt.setDbgid(dg.getDbgid());
/* 128 */         dgt.setStucode(stucodes[i]);
/* 129 */         tdao.getSession().save(dgt);
/* 130 */       }tdao.getSession().flush();
/* 131 */       tdao.getSession().clear();
/* 132 */       ts.commit();
/*     */     }
/* 134 */     request.setAttribute("departid", departid);
/* 135 */     return mapping.findForward("success");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.dabian.DabiangroupsaveAction
 * JD-Core Version:    0.5.4
 */