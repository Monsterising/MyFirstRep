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
/*     */ public class TasklistdepartAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  63 */     HttpSession session = request.getSession();
/*  64 */     if (session.getAttribute("teccode") == null) {
/*  65 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  66 */       return mapping.findForward("error");
/*     */     }
/*  68 */     String departidstring = request.getParameter("departid");
/*  69 */     Integer departid = Integer.valueOf(0);
/*  70 */     Integer atid = Integer.valueOf(0);
/*  71 */     if (departidstring != null) {
/*  72 */       departid = Integer.valueOf(Integer.parseInt(departidstring));
/*     */     }
/*  74 */     if (request.getAttribute("departid") != null) {
/*  75 */       departid = Integer.valueOf(Integer.parseInt(request.getAttribute("departid").toString()));
/*     */     }
/*  77 */     if (request.getAttribute("atid") != null) {
/*  78 */       atid = Integer.valueOf(Integer.parseInt(request.getAttribute("atid").toString()));
/*     */     }
/*     */ 
/*  81 */     if (request.getParameter("atid") != null) {
/*  82 */       atid = Integer.valueOf(Integer.parseInt(request.getParameter("atid").toString()));
/*     */     }
/*  84 */     if ((request.getAttribute("op") != null) && 
/*  85 */       (request.getAttribute("op").equals("edit"))) {
/*  86 */       atid = Integer.valueOf(0);
/*     */     }
/*     */ 
/*  94 */     String teccode = (String)session.getAttribute("teccode");
/*  95 */     DepartTec departtec = new DepartTec();
/*  96 */     DepartTecDAO dao = new DepartTecDAO();
/*  97 */     List departteclist = dao.findByTeccode(teccode);
/*     */ 
/*  99 */     List departlist = new LinkedList();
/* 100 */     String departids = "";
/* 101 */     for (int i = 0; i < departteclist.size(); ++i) {
/* 102 */       if (((DepartTec)departteclist.get(i)).getTecrole().intValue() != 2)
/*     */         continue;
/* 104 */       departids = departids + ((DepartTec)departteclist.get(i)).getDepartid() + ",";
/*     */     }
/*     */ 
/* 107 */     if (departids.equals("")) {
/* 108 */       request.setAttribute("notice", "您暂无权限");
/* 109 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/* 113 */     if (!departids.equals(""))
/*     */     {
/* 115 */       departids = departids.substring(0, departids.length() - 1);
/* 116 */       String hql = "from DepartList where departid in (" + departids + ")";
/* 117 */       Qdao qdao = new Qdao();
/*     */ 
/* 119 */       departlist.addAll(qdao.query(hql));
/* 120 */       request.setAttribute("departlist", departlist);
/* 121 */       if (departid.intValue() != 0)
/*     */       {
/* 124 */         DepartTec dt = new DepartTec();
/* 125 */         DepartTecDAO dtdao = new DepartTecDAO();
/* 126 */         List dtlist = new LinkedList();
/* 127 */         hql = "from DepartTec where departid=" + departid;
/* 128 */         dtlist.addAll(qdao.query(hql));
/* 129 */         String teccodes = "";
/* 130 */         for (int i = 0; i < dtlist.size(); ++i) {
/* 131 */           teccodes = teccodes + "'" + ((DepartTec)dtlist.get(i)).getTeccode() + "',";
/*     */         }
/* 133 */         if (!teccodes.equals("")) {
/* 134 */           teccodes = teccodes.substring(0, teccodes.length() - 1);
/*     */ 
/* 136 */           hql = "from TecList where teccode in (" + teccodes + ")";
/* 137 */           List teclist = new LinkedList();
/* 138 */           teclist.addAll(qdao.query(hql));
/* 139 */           request.setAttribute("teclist", teclist);
/*     */         }
/*     */ 
/* 145 */         ApplyNumGradeDAO adao = new ApplyNumGradeDAO();
/*     */ 
/* 154 */         ApplyNumGrade ang = new ApplyNumGrade();
/* 155 */         ang = adao.findById(departid);
/* 156 */         GradeList grade = new GradeList();
/* 157 */         GradeListDAO gdao = new GradeListDAO();
/* 158 */         grade = gdao.findById(ang.getGradeid());
/* 159 */         request.setAttribute("gradename", grade.getGradename());
/*     */ 
/* 161 */         ApplyResultDAO ardao = new ApplyResultDAO();
/* 162 */         List applyresultlist = new LinkedList();
/* 163 */         hql = "from ApplyResult where departid in (" + departid + ")";
/* 164 */         applyresultlist.addAll(qdao.query(hql));
/*     */ 
/* 167 */         request.setAttribute("applyresultlist", applyresultlist);
/*     */ 
/* 169 */         request.setAttribute("teccode", teccode);
/*     */ 
/* 171 */         request.setAttribute("gradeid", ang.getGradeid());
/*     */ 
/* 174 */         ApplyTec apply = new ApplyTec();
/* 175 */         ApplyTecDAO apdao = new ApplyTecDAO();
/* 176 */         List applylist = new LinkedList();
/* 177 */         hql = "from ApplyTec where departid=" + departid + " and advice1='通过' and advice2='通过' and  gradeid=" + grade.getGradeid();
/* 178 */         applylist.addAll(qdao.query(hql));
/* 179 */         request.setAttribute("applylist", applylist);
/* 180 */         List wishlist = new LinkedList();
/* 181 */         List aslist = new LinkedList();
/* 182 */         if (atid.intValue() != 0)
/*     */         {
/* 184 */           StuWish stuwish = new StuWish();
/* 185 */           StuWishDAO wdao = new StuWishDAO();
/* 186 */           hql = "from StuWish where priority=1 and atid=" + atid + " order by teccode desc";
/* 187 */           if (qdao.query(hql) != null) {
/* 188 */             wishlist.addAll(qdao.query(hql));
/*     */           }
/*     */ 
/* 191 */           hql = "from ApplyState where atid=" + atid;
/* 192 */           if (qdao.query(hql) != null) {
/* 193 */             aslist.addAll(qdao.query(hql));
/*     */           }
/*     */ 
/* 196 */           hql = "from Task where atid in (" + atid + ")";
/* 197 */           List tasklist = new LinkedList();
/* 198 */           tasklist.addAll(qdao.query(hql));
/* 199 */           request.setAttribute("aslist", aslist);
/* 200 */           request.setAttribute("tasklist", tasklist);
/* 201 */           request.setAttribute("wishlist", wishlist);
/* 202 */           request.setAttribute("atid", atid);
/*     */         } else {
/* 204 */           String atids = "";
/* 205 */           for (int i = 0; i < applylist.size(); ++i) {
/* 206 */             atids = atids + ((ApplyTec)applylist.get(i)).getAtid() + ",";
/*     */           }
/* 208 */           if (!atids.equals("")) {
/* 209 */             atids = atids.substring(0, atids.length() - 1);
/*     */ 
/* 211 */             StuWish stuwish = new StuWish();
/* 212 */             StuWishDAO wdao = new StuWishDAO();
/* 213 */             hql = "from StuWish where priority=1 and wishstate='通过' and atid in (" + atids + ") order by teccode ";
/* 214 */             wishlist.addAll(qdao.query(hql));
/*     */ 
/* 216 */             hql = "from Task where atid in (" + atids + ")";
/* 217 */             List tasklist = new LinkedList();
/* 218 */             tasklist.addAll(qdao.query(hql));
/*     */ 
/* 220 */             hql = "from ApplyState where atid in (" + atids + ")";
/* 221 */             if (qdao.query(hql) != null) {
/* 222 */               aslist.addAll(qdao.query(hql));
/*     */             }
/* 224 */             request.setAttribute("aslist", aslist);
/* 225 */             request.setAttribute("tasklist", tasklist);
/*     */ 
/* 228 */             hql = "select count(*) from ApplyState where task='ok' and atid in(" + atids + ")";
/* 229 */             request.setAttribute("countcollege", qdao.count(hql));
/*     */           }
/*     */ 
/* 232 */           request.setAttribute("wishlist", wishlist);
/* 233 */           request.setAttribute("atid", atid);
/* 234 */           if (wishlist.size() == 0) {
/* 235 */             request.setAttribute("notice", "暂时没有信息！");
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/* 241 */         String hql3 = "";
/* 242 */         hql3 = "select count(*) from StuList where gradeid=" + ang.getGradeid();
/* 243 */         request.setAttribute("stusum", qdao.count(hql3));
/*     */ 
/* 247 */         String stucodes = "";
/* 248 */         for (int i = 0; i < wishlist.size(); ++i) {
/* 249 */           stucodes = stucodes + "'" + ((StuWish)wishlist.get(i)).getStucode() + "'" + ",";
/*     */         }
/* 251 */         List stulist = new LinkedList();
/* 252 */         if (!stucodes.equals("")) {
/* 253 */           stucodes = stucodes.substring(0, stucodes.length() - 1);
/* 254 */           StuListDAO studao = new StuListDAO();
/* 255 */           hql = "from StuList where stucode in(" + stucodes + ")";
/* 256 */           stulist.addAll(qdao.query(hql));
/*     */         }
/* 258 */         request.setAttribute("stulist", stulist);
/*     */       }
/*     */ 
/* 261 */       request.setAttribute("departid", departid);
/* 262 */       request.setAttribute("op", "new");
/*     */     }
/*     */ 
/* 265 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.TasklistdepartAction
 * JD-Core Version:    0.5.4
 */