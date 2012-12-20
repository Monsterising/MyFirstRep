/*     */ package com.frame.struts.action.depart;
/*     */ 
/*     */ import com.entity.basedata.DepartTec;
/*     */ import com.entity.basedata.DepartTecDAO;
/*     */ import com.entity.basedata.GradeList;
/*     */ import com.entity.basedata.GradeListDAO;
/*     */ import com.entity.basedata.StuList;
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
/*     */ public class StuwishlistdepartAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  64 */     HttpSession session = request.getSession();
/*  65 */     if (session.getAttribute("teccode") == null) {
/*  66 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  67 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  71 */     String teccode = (String)session.getAttribute("teccode");
/*  72 */     DepartTec departtec = new DepartTec();
/*  73 */     DepartTecDAO dao = new DepartTecDAO();
/*  74 */     List departteclist = dao.findByTeccode(teccode);
/*     */ 
/*  76 */     List departlist = new LinkedList();
/*  77 */     String departids = "";
/*  78 */     for (int i = 0; i < departteclist.size(); ++i) {
/*  79 */       if (((DepartTec)departteclist.get(i)).getTecrole().intValue() != 2)
/*     */         continue;
/*  81 */       session.setAttribute("userrole", Integer.valueOf(2));
/*  82 */       session.setAttribute("usershenfen", "专业负责人");
/*  83 */       departids = departids + ((DepartTec)departteclist.get(i)).getDepartid() + ",";
/*     */     }
/*     */ 
/*  89 */     if (departids.equals("")) {
/*  90 */       request.setAttribute("notice", "您没有该项权限！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  91 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  94 */     String departidstring = request.getParameter("departid");
/*  95 */     Integer departid = Integer.valueOf(0);
/*  96 */     Integer atid = Integer.valueOf(0);
/*  97 */     if (departidstring != null) {
/*  98 */       departid = Integer.valueOf(Integer.parseInt(departidstring));
/*     */     }
/* 100 */     if (request.getAttribute("departid") != null) {
/* 101 */       departid = Integer.valueOf(Integer.parseInt(request.getAttribute("departid").toString()));
/*     */     }
/*     */ 
/* 106 */     if (!departids.equals(""))
/*     */     {
/* 108 */       departids = departids.substring(0, departids.length() - 1);
/* 109 */       String hql = "from DepartList where departid in (" + departids + ")";
/* 110 */       Qdao qdao = new Qdao();
/*     */ 
/* 112 */       departlist.addAll(qdao.query(hql));
/* 113 */       request.setAttribute("departlist", departlist);
/* 114 */       if (departid.intValue() != 0)
/*     */       {
/* 117 */         DepartTec dt = new DepartTec();
/* 118 */         DepartTecDAO dtdao = new DepartTecDAO();
/* 119 */         List dtlist = new LinkedList();
/* 120 */         hql = "from DepartTec where departid=" + departid;
/* 121 */         dtlist.addAll(qdao.query(hql));
/* 122 */         String teccodes = "";
/* 123 */         for (int i = 0; i < dtlist.size(); ++i) {
/* 124 */           teccodes = teccodes + "'" + ((DepartTec)dtlist.get(i)).getTeccode() + "',";
/*     */         }
/* 126 */         if (!teccodes.equals("")) {
/* 127 */           teccodes = teccodes.substring(0, teccodes.length() - 1);
/*     */ 
/* 129 */           hql = "from TecList where teccode in (" + teccodes + ")";
/* 130 */           List teclist = new LinkedList();
/* 131 */           teclist.addAll(qdao.query(hql));
/* 132 */           request.setAttribute("teclist", teclist);
/*     */         }
/*     */ 
/* 137 */         ApplyNumGradeDAO adao = new ApplyNumGradeDAO();
/*     */ 
/* 140 */         ApplyTypeDAO atdao = new ApplyTypeDAO();
/* 141 */         List applytypelist = new LinkedList();
/* 142 */         hql = "from ApplyType where departid in (" + departid + ")";
/* 143 */         applytypelist.addAll(qdao.query(hql));
/*     */ 
/* 145 */         ApplyNumGrade ang = new ApplyNumGrade();
/* 146 */         ang = adao.findById(departid);
/*     */ 
/* 148 */         ApplyResultDAO ardao = new ApplyResultDAO();
/* 149 */         List applyresultlist = new LinkedList();
/* 150 */         hql = "from ApplyResult where departid in (" + departid + ")";
/* 151 */         applyresultlist.addAll(qdao.query(hql));
/*     */ 
/* 153 */         request.setAttribute("applytypelist", applytypelist);
/* 154 */         request.setAttribute("applyresultlist", applyresultlist);
/*     */ 
/* 165 */         request.setAttribute("gradeid", ang.getGradeid());
/* 166 */         GradeList grade = new GradeList();
/* 167 */         GradeListDAO gdao = new GradeListDAO();
/* 168 */         grade = gdao.findById(ang.getGradeid());
/* 169 */         request.setAttribute("gradename", grade.getGradename());
/*     */ 
/* 173 */         String hql3 = "";
/* 174 */         hql3 = "select count(*) from StuList where gradeid=" + ang.getGradeid();
/* 175 */         request.setAttribute("stusum", qdao.count(hql3));
/*     */ 
/* 177 */         String hql2 = "select count(*) from ApplyTec where departid=" + departid + " and gradeid=" + ang.getGradeid() + 
/* 178 */           " and advice1='通过' and advice2='通过'";
/* 179 */         request.setAttribute("countcollege", qdao.count(hql2));
/*     */ 
/* 181 */         String hql4 = "";
/* 182 */         String stucodes = "";
/* 183 */         StuListDAO sdao = new StuListDAO();
/* 184 */         List stulist0 = new LinkedList();
/* 185 */         hql = "from StuList where departid=" + departid + " and gradeid=" + ang.getGradeid();
/* 186 */         stulist0.addAll(qdao.query(hql));
/* 187 */         if (stulist0.size() == 0) {
/* 188 */           request.setAttribute("notice", "该专业尚无学生");
/* 189 */           return mapping.findForward("error");
/*     */         }
/* 191 */         for (int i = 0; i < stulist0.size(); ++i) {
/* 192 */           stucodes = stucodes + "'" + ((StuList)stulist0.get(i)).getStucode() + "',";
/*     */         }
/* 194 */         if (!stucodes.equals("")) {
/* 195 */           stucodes = stucodes.substring(0, stucodes.length() - 1);
/*     */         }
/* 197 */         hql4 = "select count(*) from Xuanti where stucode in(" + stucodes + ")";
/* 198 */         request.setAttribute("countwish", qdao.count(hql4));
/*     */ 
/* 200 */         ApplyTec apply = new ApplyTec();
/* 201 */         ApplyTecDAO apdao = new ApplyTecDAO();
/* 202 */         List applylist = new LinkedList();
/* 203 */         hql = "from ApplyTec where departid=" + departid + " and advice1='通过' and advice2='通过' and  gradeid=" + grade.getGradeid();
/* 204 */         applylist.addAll(qdao.query(hql));
/* 205 */         request.setAttribute("applylist", applylist);
/* 206 */         List wishlist = new LinkedList();
/*     */ 
/* 219 */         String atids = "";
/* 220 */         for (int i = 0; i < applylist.size(); ++i) {
/* 221 */           atids = atids + ((ApplyTec)applylist.get(i)).getAtid() + ",";
/*     */         }
/* 223 */         if (!atids.equals("")) {
/* 224 */           atids = atids.substring(0, atids.length() - 1);
/*     */ 
/* 226 */           StuWish stuwish = new StuWish();
/* 227 */           StuWishDAO wdao = new StuWishDAO();
/* 228 */           hql = "from StuWish where priority=1 and atid in (" + atids + ") order by teccode";
/* 229 */           wishlist.addAll(qdao.query(hql));
/*     */         }
/* 231 */         request.setAttribute("wishlist", wishlist);
/* 232 */         request.setAttribute("atid", atid);
/*     */ 
/* 235 */         stucodes = "";
/* 236 */         for (int i = 0; i < wishlist.size(); ++i) {
/* 237 */           stucodes = stucodes + "'" + ((StuWish)wishlist.get(i)).getStucode() + "'" + ",";
/*     */         }
/* 239 */         List stulist = new LinkedList();
/* 240 */         if (!stucodes.equals("")) {
/* 241 */           stucodes = stucodes.substring(0, stucodes.length() - 1);
/*     */ 
/* 243 */           StuListDAO studao = new StuListDAO();
/* 244 */           hql = "from StuList where stucode in(" + stucodes + ")";
/*     */ 
/* 246 */           stulist.addAll(qdao.query(hql));
/*     */         }
/*     */ 
/* 249 */         request.setAttribute("stulist", stulist);
/*     */       }
/*     */ 
/* 256 */       request.setAttribute("departid", departid);
/* 257 */       request.setAttribute("op", "new");
/*     */     }
/*     */ 
/* 261 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.StuwishlistdepartAction
 * JD-Core Version:    0.5.4
 */