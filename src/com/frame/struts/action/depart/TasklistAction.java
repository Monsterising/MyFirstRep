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
/*     */ import com.frame.struts.form.task.TaskForm;
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
/*     */ public class TasklistAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  65 */     TaskForm tform = (TaskForm)form;
/*  66 */     HttpSession session = request.getSession();
/*  67 */     if (session.getAttribute("teccode") == null) {
/*  68 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  69 */       return mapping.findForward("error");
/*     */     }
/*  71 */     String departidstring = request.getParameter("departid");
/*  72 */     Integer departid = Integer.valueOf(0);
/*  73 */     Integer atid = Integer.valueOf(0);
/*  74 */     if (departidstring != null) {
/*  75 */       departid = Integer.valueOf(Integer.parseInt(departidstring));
/*     */     }
/*  77 */     if (request.getAttribute("departid") != null) {
/*  78 */       departid = Integer.valueOf(Integer.parseInt(request.getAttribute("departid").toString()));
/*     */     }
/*  80 */     if (request.getAttribute("atid") != null) {
/*  81 */       atid = Integer.valueOf(Integer.parseInt(request.getAttribute("atid").toString()));
/*     */     }
/*     */ 
/*  84 */     if (request.getParameter("atid") != null) {
/*  85 */       atid = Integer.valueOf(Integer.parseInt(request.getParameter("atid").toString()));
/*     */     }
/*  87 */     if ((request.getAttribute("op") != null) && 
/*  88 */       (request.getAttribute("op").equals("edit"))) {
/*  89 */       atid = Integer.valueOf(0);
/*     */     }
/*     */ 
/*  97 */     String teccode = (String)session.getAttribute("teccode");
/*  98 */     DepartTec departtec = new DepartTec();
/*  99 */     DepartTecDAO dao = new DepartTecDAO();
/* 100 */     List departteclist = dao.findByTeccode(teccode);
/*     */ 
/* 102 */     List departlist = new LinkedList();
/* 103 */     String departids = "";
/* 104 */     for (int i = 0; i < departteclist.size(); ++i) {
/* 105 */       if ((((DepartTec)departteclist.get(i)).getTecrole().intValue() != 2) && (((DepartTec)departteclist.get(i)).getTecrole().intValue() != 1))
/*     */         continue;
/* 107 */       departids = departids + ((DepartTec)departteclist.get(i)).getDepartid() + ",";
/*     */     }
/*     */ 
/* 110 */     if (!departids.equals(""))
/*     */     {
/* 112 */       departids = departids.substring(0, departids.length() - 1);
/* 113 */       String hql = "from DepartList where departid in (" + departids + ")";
/* 114 */       Qdao qdao = new Qdao();
/*     */ 
/* 116 */       departlist.addAll(qdao.query(hql));
/* 117 */       request.setAttribute("departlist", departlist);
/* 118 */       if (departid.intValue() != 0)
/*     */       {
/* 120 */         ApplyNumGradeDAO adao = new ApplyNumGradeDAO();
/*     */ 
/* 129 */         ApplyNumGrade ang = new ApplyNumGrade();
/* 130 */         ang = adao.findById(departid);
/* 131 */         GradeList grade = new GradeList();
/* 132 */         GradeListDAO gdao = new GradeListDAO();
/* 133 */         grade = gdao.findById(ang.getGradeid());
/* 134 */         request.setAttribute("gradename", grade.getGradename());
/*     */ 
/* 136 */         ApplyResultDAO ardao = new ApplyResultDAO();
/* 137 */         List applyresultlist = new LinkedList();
/* 138 */         hql = "from ApplyResult where departid in (" + departid + ")";
/* 139 */         applyresultlist.addAll(qdao.query(hql));
/*     */ 
/* 142 */         request.setAttribute("applyresultlist", applyresultlist);
/*     */ 
/* 144 */         request.setAttribute("teccode", teccode);
/*     */ 
/* 146 */         hql = "select count(*) from ApplyTec where teccode='" + teccode + "'";
/* 147 */         Long j = (Long)qdao.count(hql);
/* 148 */         hql = "select count(*) from ApplyTec where advice1='通过' and advice2='通过' and teccode='" + teccode + "'";
/* 149 */         Long k = (Long)qdao.count(hql);
/* 150 */         request.setAttribute("j", j);
/* 151 */         request.setAttribute("i", Long.valueOf(ang.getNum().intValue() - j.longValue()));
/* 152 */         request.setAttribute("k", k);
/* 153 */         request.setAttribute("gradeid", ang.getGradeid());
/*     */ 
/* 156 */         ApplyTec apply = new ApplyTec();
/* 157 */         ApplyTecDAO apdao = new ApplyTecDAO();
/* 158 */         List applylist = new LinkedList();
/* 159 */         hql = "from ApplyTec where teccode='" + teccode + "' and departid=" + departid + " and advice1='通过' and advice2='通过' and  gradeid=" + grade.getGradeid();
/* 160 */         applylist.addAll(qdao.query(hql));
/* 161 */         request.setAttribute("applylist", applylist);
/* 162 */         List wishlist = new LinkedList();
/* 163 */         List aslist = new LinkedList();
/* 164 */         if (atid.intValue() != 0)
/*     */         {
/* 166 */           StuWish stuwish = new StuWish();
/* 167 */           StuWishDAO wdao = new StuWishDAO();
/* 168 */           hql = "from StuWish where priority=1 and atid=" + atid;
/* 169 */           if (qdao.query(hql) != null) {
/* 170 */             wishlist.addAll(qdao.query(hql));
/*     */           }
/*     */ 
/* 173 */           hql = "from ApplyState where atid=" + atid;
/* 174 */           if (qdao.query(hql) != null) {
/* 175 */             aslist.addAll(qdao.query(hql));
/*     */           }
/*     */ 
/* 178 */           hql = "from Task where atid in (" + atid + ")";
/* 179 */           List tasklist = new LinkedList();
/* 180 */           tasklist.addAll(qdao.query(hql));
/* 181 */           request.setAttribute("aslist", aslist);
/* 182 */           request.setAttribute("tasklist", tasklist);
/* 183 */           request.setAttribute("wishlist", wishlist);
/* 184 */           request.setAttribute("atid", atid);
/*     */         } else {
/* 186 */           String atids = "";
/* 187 */           for (int i = 0; i < applylist.size(); ++i) {
/* 188 */             atids = atids + ((ApplyTec)applylist.get(i)).getAtid() + ",";
/*     */           }
/* 190 */           if (!atids.equals("")) {
/* 191 */             atids = atids.substring(0, atids.length() - 1);
/*     */ 
/* 193 */             StuWish stuwish = new StuWish();
/* 194 */             StuWishDAO wdao = new StuWishDAO();
/* 195 */             hql = "from StuWish where priority=1 and wishstate='通过' and atid in (" + atids + ")";
/* 196 */             wishlist.addAll(qdao.query(hql));
/*     */ 
/* 198 */             hql = "from Task where atid in (" + atids + ")";
/* 199 */             List tasklist = new LinkedList();
/* 200 */             tasklist.addAll(qdao.query(hql));
/*     */ 
/* 202 */             hql = "from ApplyState where atid in (" + atids + ")";
/* 203 */             if (qdao.query(hql) != null) {
/* 204 */               aslist.addAll(qdao.query(hql));
/*     */             }
/* 206 */             request.setAttribute("aslist", aslist);
/* 207 */             request.setAttribute("tasklist", tasklist);
/*     */           }
/* 209 */           request.setAttribute("wishlist", wishlist);
/* 210 */           request.setAttribute("atid", atid);
/* 211 */           if (wishlist.size() == 0) {
/* 212 */             request.setAttribute("notice", "暂时没有信息！");
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/* 220 */         String stucodes = "";
/* 221 */         for (int i = 0; i < wishlist.size(); ++i) {
/* 222 */           stucodes = stucodes + "'" + ((StuWish)wishlist.get(i)).getStucode() + "'" + ",";
/*     */         }
/* 224 */         List stulist = new LinkedList();
/* 225 */         if (!stucodes.equals("")) {
/* 226 */           stucodes = stucodes.substring(0, stucodes.length() - 1);
/* 227 */           StuListDAO studao = new StuListDAO();
/* 228 */           hql = "from StuList where stucode in(" + stucodes + ")";
/* 229 */           stulist.addAll(qdao.query(hql));
/*     */         }
/* 231 */         request.setAttribute("stulist", stulist);
/*     */       }
/*     */ 
/* 234 */       request.setAttribute("departid", departid);
/* 235 */       request.setAttribute("op", "new");
/*     */     }
/*     */ 
/* 238 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.TasklistAction
 * JD-Core Version:    0.5.4
 */