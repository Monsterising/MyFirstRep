/*     */ package com.frame.struts.action.depart;
/*     */ 
/*     */ import com.entity.basedata.DepartTec;
/*     */ import com.entity.basedata.DepartTecDAO;
/*     */ import com.entity.basedata.GradeList;
/*     */ import com.entity.basedata.GradeListDAO;
/*     */ import com.entity.basedata.StuListDAO;
/*     */ import com.entity.wish.ApplyNumGrade;
/*     */ import com.entity.wish.ApplyNumGradeDAO;
/*     */ import com.entity.wish.ApplyResultDAO;
/*     */ import com.entity.wish.ApplyTec;
/*     */ import com.entity.wish.ApplyTecDAO;
/*     */ import com.entity.wish.ApplyTypeDAO;
/*     */ import com.entity.wish.StuWish;
/*     */ import com.entity.wish.StuWishDAO;
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
/*     */ public class StuwishlistAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  62 */     HttpSession session = request.getSession();
/*  63 */     if (session.getAttribute("teccode") == null) {
/*  64 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  65 */       return mapping.findForward("error");
/*     */     }
/*  67 */     String departidstring = request.getParameter("departid");
/*  68 */     Integer departid = Integer.valueOf(0);
/*  69 */     Integer atid = Integer.valueOf(0);
/*  70 */     if (departidstring != null) {
/*  71 */       departid = Integer.valueOf(Integer.parseInt(departidstring));
/*     */     }
/*  73 */     if (request.getAttribute("departid") != null) {
/*  74 */       departid = Integer.valueOf(Integer.parseInt(request.getAttribute("departid").toString()));
/*     */     }
/*  76 */     if (request.getAttribute("atid") != null) {
/*  77 */       atid = Integer.valueOf(Integer.parseInt(request.getAttribute("atid").toString()));
/*     */     }
/*     */ 
/*  80 */     if (request.getParameter("atid") != null) {
/*  81 */       atid = Integer.valueOf(Integer.parseInt(request.getParameter("atid").toString()));
/*     */     }
/*     */ 
/*  84 */     String teccode = (String)session.getAttribute("teccode");
/*  85 */     DepartTec departtec = new DepartTec();
/*  86 */     DepartTecDAO dao = new DepartTecDAO();
/*  87 */     List departteclist = dao.findByTeccode(teccode);
/*     */ 
/*  89 */     List departlist = new LinkedList();
/*  90 */     String departids = "";
/*  91 */     for (int i = 0; i < departteclist.size(); ++i) {
/*  92 */       if ((((DepartTec)departteclist.get(i)).getTecrole().intValue() != 2) && (((DepartTec)departteclist.get(i)).getTecrole().intValue() != 1))
/*     */         continue;
/*  94 */       departids = departids + ((DepartTec)departteclist.get(i)).getDepartid() + ",";
/*     */     }
/*     */ 
/*  97 */     if (!departids.equals(""))
/*     */     {
/*  99 */       departids = departids.substring(0, departids.length() - 1);
/* 100 */       String hql = "from DepartList where departid in (" + departids + ")";
/* 101 */       Qdao qdao = new Qdao();
/*     */ 
/* 103 */       departlist.addAll(qdao.query(hql));
/* 104 */       request.setAttribute("departlist", departlist);
/* 105 */       if (departid.intValue() != 0)
/*     */       {
/* 107 */         ApplyNumGradeDAO adao = new ApplyNumGradeDAO();
/*     */ 
/* 110 */         ApplyTypeDAO atdao = new ApplyTypeDAO();
/* 111 */         List applytypelist = new LinkedList();
/* 112 */         hql = "from ApplyType where departid in (" + departid + ")";
/* 113 */         applytypelist.addAll(qdao.query(hql));
/*     */ 
/* 115 */         ApplyNumGrade ang = new ApplyNumGrade();
/* 116 */         ang = adao.findById(departid);
/*     */ 
/* 118 */         ApplyResultDAO ardao = new ApplyResultDAO();
/* 119 */         List applyresultlist = new LinkedList();
/* 120 */         hql = "from ApplyResult where departid in (" + departid + ")";
/* 121 */         applyresultlist.addAll(qdao.query(hql));
/*     */ 
/* 123 */         request.setAttribute("applytypelist", applytypelist);
/* 124 */         request.setAttribute("applyresultlist", applyresultlist);
/*     */ 
/* 126 */         request.setAttribute("teccode", teccode);
/*     */ 
/* 128 */         hql = "select count(*) from ApplyTec where teccode='" + teccode + "'";
/* 129 */         Long j = (Long)qdao.count(hql);
/* 130 */         hql = "select count(*) from ApplyTec where advice1='通过' and advice2='通过' and teccode='" + teccode + "'";
/* 131 */         Long k = (Long)qdao.count(hql);
/* 132 */         request.setAttribute("j", j);
/* 133 */         request.setAttribute("i", Long.valueOf(ang.getNum().intValue() - j.longValue()));
/* 134 */         request.setAttribute("k", k);
/* 135 */         request.setAttribute("gradeid", ang.getGradeid());
/* 136 */         GradeList grade = new GradeList();
/* 137 */         GradeListDAO gdao = new GradeListDAO();
/* 138 */         grade = gdao.findById(ang.getGradeid());
/* 139 */         request.setAttribute("gradename", grade.getGradename());
/*     */ 
/* 141 */         ApplyTec apply = new ApplyTec();
/* 142 */         ApplyTecDAO apdao = new ApplyTecDAO();
/* 143 */         List applylist = new LinkedList();
/* 144 */         hql = "from ApplyTec where teccode='" + teccode + "' and departid=" + departid + " and advice1='通过' and advice2='通过' and  gradeid=" + grade.getGradeid();
/* 145 */         applylist.addAll(qdao.query(hql));
/* 146 */         request.setAttribute("applylist", applylist);
/* 147 */         List wishlist = new LinkedList();
/* 148 */         if (atid.intValue() != 0)
/*     */         {
/* 150 */           StuWish stuwish = new StuWish();
/* 151 */           StuWishDAO wdao = new StuWishDAO();
/* 152 */           hql = "from StuWish where priority=1 and atid=" + atid;
/* 153 */           qdao.query(hql);
/* 154 */           if (qdao.query(hql) != null) {
/* 155 */             wishlist.addAll(qdao.query(hql));
/*     */           }
/* 157 */           request.setAttribute("wishlist", wishlist);
/* 158 */           request.setAttribute("atid", atid);
/*     */         } else {
/* 160 */           String atids = "";
/* 161 */           for (int i = 0; i < applylist.size(); ++i) {
/* 162 */             atids = atids + ((ApplyTec)applylist.get(i)).getAtid() + ",";
/*     */           }
/* 164 */           if (!atids.equals("")) {
/* 165 */             atids = atids.substring(0, atids.length() - 1);
/*     */ 
/* 167 */             StuWish stuwish = new StuWish();
/* 168 */             StuWishDAO wdao = new StuWishDAO();
/* 169 */             hql = "from StuWish where priority=1 and atid in (" + atids + ")";
/* 170 */             wishlist.addAll(qdao.query(hql));
/*     */           }
/* 172 */           request.setAttribute("wishlist", wishlist);
/* 173 */           request.setAttribute("atid", atid);
/*     */         }
/*     */ 
/* 176 */         String stucodes = "";
/* 177 */         for (int i = 0; i < wishlist.size(); ++i) {
/* 178 */           stucodes = stucodes + "'" + ((StuWish)wishlist.get(i)).getStucode() + "'" + ",";
/*     */         }
/* 180 */         List stulist = new LinkedList();
/* 181 */         if (!stucodes.equals("")) {
/* 182 */           stucodes = stucodes.substring(0, stucodes.length() - 1);
/*     */ 
/* 184 */           StuListDAO studao = new StuListDAO();
/* 185 */           hql = "from StuList where stucode in(" + stucodes + ")";
/*     */ 
/* 187 */           stulist.addAll(qdao.query(hql));
/*     */         }
/*     */ 
/* 190 */         request.setAttribute("stulist", stulist);
/*     */       }
/*     */ 
/* 197 */       request.setAttribute("departid", departid);
/* 198 */       request.setAttribute("op", "new");
/*     */     }
/*     */ 
/* 202 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.StuwishlistAction
 * JD-Core Version:    0.5.4
 */