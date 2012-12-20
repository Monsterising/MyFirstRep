/*     */ package com.frame.struts.action.dabian;
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
/*     */ public class DabianchengjilistTecAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  68 */     HttpSession session = request.getSession();
/*  69 */     if (session.getAttribute("teccode") == null) {
/*  70 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  71 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  74 */     String departidstring = request.getParameter("departid");
/*  75 */     Integer departid = Integer.valueOf(0);
/*  76 */     if (departidstring != null) {
/*  77 */       departid = Integer.valueOf(Integer.parseInt(departidstring));
/*     */     }
/*  79 */     if (request.getAttribute("departid") != null) {
/*  80 */       departid = Integer.valueOf(Integer.parseInt(request.getAttribute("departid").toString()));
/*     */     }
/*     */ 
/*  87 */     String teccode = (String)session.getAttribute("teccode");
/*  88 */     DepartTec departtec = new DepartTec();
/*  89 */     DepartTecDAO dao = new DepartTecDAO();
/*  90 */     List departteclist = dao.findByTeccode(teccode);
/*     */ 
/*  92 */     List departlist = new LinkedList();
/*  93 */     String departids = "";
/*  94 */     for (int i = 0; i < departteclist.size(); ++i) {
/*  95 */       if ((((DepartTec)departteclist.get(i)).getTecrole().intValue() != 2) && (((DepartTec)departteclist.get(i)).getTecrole().intValue() != 1))
/*     */         continue;
/*  97 */       departids = departids + ((DepartTec)departteclist.get(i)).getDepartid() + ",";
/*     */     }
/*     */ 
/* 100 */     if (!departids.equals(""))
/*     */     {
/* 102 */       departids = departids.substring(0, departids.length() - 1);
/* 103 */       String hql = "from DepartList where departid in (" + departids + ")";
/* 104 */       Qdao qdao = new Qdao();
/*     */ 
/* 106 */       departlist.addAll(qdao.query(hql));
/* 107 */       request.setAttribute("departlist", departlist);
/* 108 */       if (departid.intValue() != 0)
/*     */       {
/* 110 */         ApplyNumGradeDAO adao = new ApplyNumGradeDAO();
/* 111 */         ApplyNumGrade ang = new ApplyNumGrade();
/* 112 */         ang = adao.findById(departid);
/* 113 */         GradeList grade = new GradeList();
/* 114 */         GradeListDAO gdao = new GradeListDAO();
/* 115 */         grade = gdao.findById(ang.getGradeid());
/* 116 */         request.setAttribute("gradename", grade.getGradename());
/*     */ 
/* 118 */         ApplyResultDAO ardao = new ApplyResultDAO();
/* 119 */         List applyresultlist = new LinkedList();
/* 120 */         hql = "from ApplyResult where departid in (" + departid + ")";
/* 121 */         applyresultlist.addAll(qdao.query(hql));
/*     */ 
/* 123 */         request.setAttribute("applyresultlist", applyresultlist);
/* 124 */         request.setAttribute("teccode", teccode);
/*     */ 
/* 133 */         request.setAttribute("gradeid", ang.getGradeid());
/*     */ 
/* 136 */         ApplyTec apply = new ApplyTec();
/* 137 */         ApplyTecDAO apdao = new ApplyTecDAO();
/* 138 */         List applylist = new LinkedList();
/* 139 */         hql = "from ApplyTec where teccode='" + teccode + "' and departid=" + departid + " and advice1='通过' and advice2='通过' and  gradeid=" + grade.getGradeid();
/* 140 */         applylist.addAll(qdao.query(hql));
/* 141 */         request.setAttribute("applylist", applylist);
/* 142 */         List wishlist = new LinkedList();
/* 143 */         List aslist = new LinkedList();
/* 144 */         String atids = "";
/* 145 */         for (int i = 0; i < applylist.size(); ++i) {
/* 146 */           atids = atids + ((ApplyTec)applylist.get(i)).getAtid() + ",";
/*     */         }
/* 148 */         if (!atids.equals("")) {
/* 149 */           atids = atids.substring(0, atids.length() - 1);
/*     */ 
/* 151 */           StuWish stuwish = new StuWish();
/* 152 */           StuWishDAO wdao = new StuWishDAO();
/* 153 */           hql = "from StuWish where priority=1 and wishstate='通过' and atid in (" + atids + ")";
/* 154 */           wishlist.addAll(qdao.query(hql));
/*     */         }
/* 156 */         request.setAttribute("wishlist", wishlist);
/* 157 */         if (wishlist.size() == 0) {
/* 158 */           request.setAttribute("notice", "暂时没有选题信息！");
/*     */         }
/*     */ 
/* 161 */         String stucodes = "";
/* 162 */         for (int i = 0; i < wishlist.size(); ++i) {
/* 163 */           stucodes = stucodes + "'" + ((StuWish)wishlist.get(i)).getStucode() + "'" + ",";
/*     */         }
/* 165 */         List stulist = new LinkedList();
/* 166 */         if (!stucodes.equals("")) {
/* 167 */           stucodes = stucodes.substring(0, stucodes.length() - 1);
/* 168 */           StuListDAO studao = new StuListDAO();
/* 169 */           hql = "from StuList where stucode in(" + stucodes + ")";
/* 170 */           stulist.addAll(qdao.query(hql));
/*     */ 
/* 172 */           List chengjilist = new LinkedList();
/* 173 */           chengjilist.addAll(qdao.query("from DabianChengji where stucode in(" + stucodes + ")"));
/* 174 */           request.setAttribute("chengjilist", chengjilist);
/*     */         }
/* 176 */         request.setAttribute("stulist", stulist);
/*     */       }
/*     */ 
/* 179 */       request.setAttribute("departid", departid);
/* 180 */       request.setAttribute("op", "new");
/*     */     }
/*     */ 
/* 185 */     request.setAttribute("notice", "");
/* 186 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.dabian.DabianchengjilistTecAction
 * JD-Core Version:    0.5.4
 */