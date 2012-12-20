/*     */ package com.frame.struts.action.depart;
/*     */ 
/*     */ import com.entity.basedata.DepartTec;
/*     */ import com.entity.basedata.DepartTecDAO;
/*     */ import com.entity.wish.ApplyNumGrade;
/*     */ import com.entity.wish.ApplyNumGradeDAO;
/*     */ import com.entity.wish.ApplyTec;
/*     */ import com.entity.wish.ApplyTecDAO;
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
/*     */ public class PingyuteclistAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  56 */     HttpSession session = request.getSession();
/*  57 */     if (session.getAttribute("teccode") == null) {
/*  58 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  59 */       return mapping.findForward("error");
/*     */     }
/*  61 */     String teccode = (String)session.getAttribute("teccode");
/*     */ 
/*  63 */     String departidstring = request.getParameter("departid");
/*  64 */     Integer departid = Integer.valueOf(0);
/*  65 */     if ((departidstring != null) && (!departidstring.equals(""))) {
/*  66 */       departid = Integer.valueOf(Integer.parseInt(departidstring));
/*     */     }
/*  68 */     if (request.getAttribute("departid") != null) {
/*  69 */       departid = Integer.valueOf(Integer.parseInt(request.getAttribute("departid").toString()));
/*     */     }
/*     */ 
/*  73 */     DepartTec departtec = new DepartTec();
/*  74 */     DepartTecDAO dao = new DepartTecDAO();
/*  75 */     List departteclist = dao.findByTeccode(teccode);
/*     */ 
/*  77 */     List departlist = new LinkedList();
/*  78 */     String departids = "";
/*  79 */     for (int i = 0; i < departteclist.size(); ++i) {
/*  80 */       if ((((DepartTec)departteclist.get(i)).getTecrole().intValue() != 2) && (((DepartTec)departteclist.get(i)).getTecrole().intValue() != 1))
/*     */         continue;
/*  82 */       departids = departids + ((DepartTec)departteclist.get(i)).getDepartid() + ",";
/*     */     }
/*     */ 
/*  86 */     if (!departids.equals(""))
/*     */     {
/*  88 */       departids = departids.substring(0, departids.length() - 1);
/*  89 */       String hql = "from DepartList where departid in (" + departids + ")";
/*  90 */       Qdao qdao = new Qdao();
/*  91 */       departlist.addAll(qdao.query(hql));
/*  92 */       request.setAttribute("departlist", departlist);
/*  93 */       if (departid.intValue() != 0) {
/*  94 */         ApplyNumGrade ang = new ApplyNumGrade();
/*  95 */         ApplyNumGradeDAO adao = new ApplyNumGradeDAO();
/*  96 */         if (adao.findById(departid) == null) {
/*  97 */           request.setAttribute("notice", "年级信息没有初始化！");
/*  98 */           return mapping.findForward("error");
/*     */         }
/*     */ 
/* 102 */         ang = adao.findById(departid);
/*     */ 
/* 104 */         ApplyTec apply = new ApplyTec();
/* 105 */         ApplyTecDAO apdao = new ApplyTecDAO();
/* 106 */         List applylist = new LinkedList();
/* 107 */         hql = "from ApplyTec where teccode='" + teccode + "' and departid=" + departid + " and advice1='通过' and advice2='通过' and  gradeid=" + ang.getGradeid();
/* 108 */         applylist.addAll(qdao.query(hql));
/* 109 */         String atids = "";
/* 110 */         for (int i = 0; i < applylist.size(); ++i) {
/* 111 */           atids = atids + ((ApplyTec)applylist.get(i)).getAtid() + ",";
/*     */         }
/* 113 */         if (!atids.equals("")) {
/* 114 */           atids = atids.substring(0, atids.length() - 1);
/*     */ 
/* 116 */           hql = "from Xuanti where atid in (" + atids + ")";
/* 117 */           List xuantilist = new LinkedList();
/* 118 */           xuantilist.addAll(qdao.query(hql));
/* 119 */           request.setAttribute("xuantilist", xuantilist);
/* 120 */           request.setAttribute("departid", departid);
/*     */         }
/*     */ 
/* 125 */         hql = "from StuList where departid=" + departid + " and gradeid=" + ang.getGradeid();
/* 126 */         List stulist = new LinkedList();
/* 127 */         stulist.addAll(qdao.query(hql));
/* 128 */         request.setAttribute("stulist", stulist);
/* 129 */         request.setAttribute("gradeid", ang.getGradeid());
/*     */       }
/*     */ 
/* 132 */       return mapping.findForward("display");
/*     */     }
/* 134 */     request.setAttribute("notice", "你还没有分配专业！");
/* 135 */     return mapping.findForward("error");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.PingyuteclistAction
 * JD-Core Version:    0.5.4
 */