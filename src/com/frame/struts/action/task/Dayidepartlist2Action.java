/*     */ package com.frame.struts.action.task;
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
/*     */ public class Dayidepartlist2Action extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  67 */     HttpSession session = request.getSession();
/*  68 */     if (session.getAttribute("teccode") == null) {
/*  69 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  70 */       return mapping.findForward("error");
/*     */     }
/*  72 */     String departidstring = request.getParameter("departid");
/*  73 */     Integer departid = Integer.valueOf(0);
/*  74 */     Integer atid = Integer.valueOf(0);
/*  75 */     if (departidstring != null) {
/*  76 */       departid = Integer.valueOf(Integer.parseInt(departidstring));
/*     */     }
/*  78 */     if (request.getAttribute("departid") != null) {
/*  79 */       departid = Integer.valueOf(Integer.parseInt(request.getAttribute("departid").toString()));
/*     */     }
/*  81 */     if (request.getAttribute("atid") != null) {
/*  82 */       atid = Integer.valueOf(Integer.parseInt(request.getAttribute("atid").toString()));
/*     */     }
/*     */ 
/*  85 */     if (request.getParameter("atid") != null) {
/*  86 */       atid = Integer.valueOf(Integer.parseInt(request.getParameter("atid").toString()));
/*     */     }
/*  88 */     if ((request.getAttribute("op") != null) && 
/*  89 */       (request.getAttribute("op").equals("edit"))) {
/*  90 */       atid = Integer.valueOf(0);
/*     */     }
/*     */ 
/*  98 */     String teccode = (String)session.getAttribute("teccode");
/*  99 */     DepartTec departtec = new DepartTec();
/* 100 */     DepartTecDAO dao = new DepartTecDAO();
/* 101 */     List departteclist = dao.findByTeccode(teccode);
/*     */ 
/* 103 */     List departlist = new LinkedList();
/* 104 */     String departids = "";
/* 105 */     for (int i = 0; i < departteclist.size(); ++i) {
/* 106 */       if (((DepartTec)departteclist.get(i)).getTecrole().intValue() != 2)
/*     */         continue;
/* 108 */       departids = departids + ((DepartTec)departteclist.get(i)).getDepartid() + ",";
/*     */     }
/*     */ 
/* 111 */     if (departids.equals("")) {
/* 112 */       request.setAttribute("notice", "您暂无权限");
/* 113 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/* 117 */     if (!departids.equals(""))
/*     */     {
/* 119 */       departids = departids.substring(0, departids.length() - 1);
/* 120 */       String hql = "from DepartList where departid in (" + departids + ")";
/* 121 */       Qdao qdao = new Qdao();
/*     */ 
/* 123 */       departlist.addAll(qdao.query(hql));
/* 124 */       request.setAttribute("departlist", departlist);
/* 125 */       if (departid.intValue() != 0)
/*     */       {
/* 128 */         DepartTec dt = new DepartTec();
/* 129 */         DepartTecDAO dtdao = new DepartTecDAO();
/* 130 */         List dtlist = new LinkedList();
/* 131 */         hql = "from DepartTec where departid=" + departid;
/* 132 */         dtlist.addAll(qdao.query(hql));
/* 133 */         String teccodes = "";
/* 134 */         for (int i = 0; i < dtlist.size(); ++i) {
/* 135 */           teccodes = teccodes + "'" + ((DepartTec)dtlist.get(i)).getTeccode() + "',";
/*     */         }
/* 137 */         if (!teccodes.equals("")) {
/* 138 */           teccodes = teccodes.substring(0, teccodes.length() - 1);
/*     */ 
/* 140 */           hql = "from TecList where teccode in (" + teccodes + ")";
/* 141 */           List teclist = new LinkedList();
/* 142 */           teclist.addAll(qdao.query(hql));
/* 143 */           request.setAttribute("teclist", teclist);
/*     */         }
/*     */ 
/* 149 */         ApplyNumGradeDAO adao = new ApplyNumGradeDAO();
/*     */ 
/* 158 */         ApplyNumGrade ang = new ApplyNumGrade();
/* 159 */         ang = adao.findById(departid);
/* 160 */         GradeList grade = new GradeList();
/* 161 */         GradeListDAO gdao = new GradeListDAO();
/* 162 */         grade = gdao.findById(ang.getGradeid());
/* 163 */         request.setAttribute("gradename", grade.getGradename());
/*     */ 
/* 165 */         ApplyResultDAO ardao = new ApplyResultDAO();
/* 166 */         List applyresultlist = new LinkedList();
/* 167 */         hql = "from ApplyResult where departid in (" + departid + ")";
/* 168 */         applyresultlist.addAll(qdao.query(hql));
/*     */ 
/* 171 */         request.setAttribute("applyresultlist", applyresultlist);
/*     */ 
/* 173 */         request.setAttribute("teccode", teccode);
/*     */ 
/* 175 */         request.setAttribute("gradeid", ang.getGradeid());
/*     */ 
/* 178 */         ApplyTec apply = new ApplyTec();
/* 179 */         ApplyTecDAO apdao = new ApplyTecDAO();
/* 180 */         List applylist = new LinkedList();
/* 181 */         hql = "from ApplyTec where departid=" + departid + " and advice1='通过' and advice2='通过' and  gradeid=" + grade.getGradeid();
/* 182 */         applylist.addAll(qdao.query(hql));
/* 183 */         request.setAttribute("applylist", applylist);
/* 184 */         List wishlist = new LinkedList();
/* 185 */         List aslist = new LinkedList();
/* 186 */         if (atid.intValue() != 0)
/*     */         {
/* 188 */           StuWish stuwish = new StuWish();
/* 189 */           StuWishDAO wdao = new StuWishDAO();
/* 190 */           hql = "from StuWish where priority=1 and atid=" + atid + " order by teccode desc";
/* 191 */           if (qdao.query(hql) != null) {
/* 192 */             wishlist.addAll(qdao.query(hql));
/*     */           }
/*     */ 
/* 195 */           hql = "from ApplyState where atid=" + atid;
/* 196 */           if (qdao.query(hql) != null) {
/* 197 */             aslist.addAll(qdao.query(hql));
/*     */           }
/*     */ 
/* 200 */           hql = "from Task where atid in (" + atid + ")";
/* 201 */           List tasklist = new LinkedList();
/* 202 */           tasklist.addAll(qdao.query(hql));
/* 203 */           request.setAttribute("aslist", aslist);
/* 204 */           request.setAttribute("tasklist", tasklist);
/* 205 */           request.setAttribute("wishlist", wishlist);
/* 206 */           request.setAttribute("atid", atid);
/*     */         } else {
/* 208 */           String atids = "";
/* 209 */           for (int i = 0; i < applylist.size(); ++i) {
/* 210 */             atids = atids + ((ApplyTec)applylist.get(i)).getAtid() + ",";
/*     */           }
/* 212 */           if (!atids.equals("")) {
/* 213 */             atids = atids.substring(0, atids.length() - 1);
/*     */ 
/* 215 */             StuWish stuwish = new StuWish();
/* 216 */             StuWishDAO wdao = new StuWishDAO();
/* 217 */             hql = "from StuWish where priority=1 and wishstate='通过' and atid in (" + atids + ") order by teccode ";
/* 218 */             wishlist.addAll(qdao.query(hql));
/*     */ 
/* 220 */             hql = "from Task where atid in (" + atids + ")";
/* 221 */             List tasklist = new LinkedList();
/* 222 */             tasklist.addAll(qdao.query(hql));
/*     */ 
/* 224 */             hql = "from ApplyState where atid in (" + atids + ")";
/* 225 */             if (qdao.query(hql) != null) {
/* 226 */               aslist.addAll(qdao.query(hql));
/*     */             }
/* 228 */             request.setAttribute("aslist", aslist);
/* 229 */             request.setAttribute("tasklist", tasklist);
/*     */ 
/* 232 */             hql = "select count(*) from ApplyState where task='ok' and atid in(" + atids + ")";
/* 233 */             request.setAttribute("countcollege", qdao.count(hql));
/*     */           }
/*     */ 
/* 236 */           request.setAttribute("wishlist", wishlist);
/* 237 */           request.setAttribute("atid", atid);
/* 238 */           if (wishlist.size() == 0) {
/* 239 */             request.setAttribute("notice", "暂时没有信息！");
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/* 245 */         String hql3 = "";
/* 246 */         hql3 = "select count(*) from StuList where gradeid=" + ang.getGradeid();
/* 247 */         request.setAttribute("stusum", qdao.count(hql3));
/*     */ 
/* 249 */         String hql2 = "select count(*) from Stagetaskdayi where departid=" + departid + " and gradeid=" + ang.getGradeid();
/*     */ 
/* 251 */         request.setAttribute("countqs", qdao.count(hql2));
/*     */ 
/* 253 */         String hql4 = "";
/* 254 */         String stucodes = "";
/* 255 */         List stulist0 = new LinkedList();
/* 256 */         hql = "from StuList where departid=" + departid + " and gradeid=" + ang.getGradeid();
/* 257 */         stulist0.addAll(qdao.query(hql));
/* 258 */         if (stulist0.size() == 0) {
/* 259 */           request.setAttribute("notice", "该专业尚无学生");
/* 260 */           return mapping.findForward("error");
/*     */         }
/* 262 */         for (int i = 0; i < stulist0.size(); ++i) {
/* 263 */           stucodes = stucodes + "'" + ((StuList)stulist0.get(i)).getStucode() + "',";
/*     */         }
/* 265 */         if (!stucodes.equals("")) {
/* 266 */           stucodes = stucodes.substring(0, stucodes.length() - 1);
/*     */         }
/* 268 */         hql4 = "select count(*) from Stagetaskdayi where departid=" + departid + " and gradeid=" + ang.getGradeid() + 
/* 269 */           " and isok=1";
/* 270 */         request.setAttribute("countok", qdao.count(hql4));
/*     */ 
/* 273 */         stucodes = "";
/* 274 */         for (int i = 0; i < wishlist.size(); ++i) {
/* 275 */           stucodes = stucodes + "'" + ((StuWish)wishlist.get(i)).getStucode() + "'" + ",";
/*     */         }
/* 277 */         List stulist = new LinkedList();
/* 278 */         if (!stucodes.equals("")) {
/* 279 */           stucodes = stucodes.substring(0, stucodes.length() - 1);
/* 280 */           StuListDAO studao = new StuListDAO();
/* 281 */           hql = "from StuList where stucode in(" + stucodes + ")";
/* 282 */           stulist.addAll(qdao.query(hql));
/*     */         }
/* 284 */         request.setAttribute("stulist", stulist);
/*     */       }
/*     */ 
/* 287 */       request.setAttribute("departid", departid);
/* 288 */       request.setAttribute("op", "new");
/*     */     }
/*     */ 
/* 292 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.task.Dayidepartlist2Action
 * JD-Core Version:    0.5.4
 */