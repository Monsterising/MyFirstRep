/*     */ package com.frame.struts.action.task;
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
/*     */ import com.frame.struts.form.task.StagetaskForm;
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
/*     */ public class StagetasklistAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  67 */     StagetaskForm sform = (StagetaskForm)form;
/*     */ 
/*  69 */     HttpSession session = request.getSession();
/*  70 */     if (session.getAttribute("teccode") == null) {
/*  71 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  72 */       return mapping.findForward("error");
/*     */     }
/*  74 */     String departidstring = request.getParameter("departid");
/*  75 */     Integer departid = Integer.valueOf(0);
/*  76 */     Integer atid = Integer.valueOf(0);
/*  77 */     if ((departidstring != null) && (!departidstring.equals(""))) {
/*  78 */       departid = Integer.valueOf(Integer.parseInt(departidstring));
/*     */     }
/*  80 */     if (request.getAttribute("departid") != null) {
/*  81 */       departid = Integer.valueOf(Integer.parseInt(request.getAttribute("departid").toString()));
/*     */     }
/*  83 */     if (request.getAttribute("atid") != null) {
/*  84 */       atid = Integer.valueOf(Integer.parseInt(request.getAttribute("atid").toString()));
/*     */     }
/*     */ 
/*  87 */     if ((request.getParameter("atid") != null) && (!request.getParameter("atid").equals(""))) {
/*  88 */       atid = Integer.valueOf(Integer.parseInt(request.getParameter("atid").toString()));
/*     */     }
/*  90 */     if ((request.getAttribute("op") != null) && 
/*  91 */       (request.getAttribute("op").equals("edit"))) {
/*  92 */       atid = Integer.valueOf(0);
/*     */     }
/*     */ 
/* 100 */     String teccode = (String)session.getAttribute("teccode");
/* 101 */     DepartTec departtec = new DepartTec();
/* 102 */     DepartTecDAO dao = new DepartTecDAO();
/* 103 */     List departteclist = dao.findByTeccode(teccode);
/*     */ 
/* 105 */     List departlist = new LinkedList();
/* 106 */     String departids = "";
/* 107 */     for (int i = 0; i < departteclist.size(); ++i) {
/* 108 */       if ((((DepartTec)departteclist.get(i)).getTecrole().intValue() != 2) && (((DepartTec)departteclist.get(i)).getTecrole().intValue() != 1))
/*     */         continue;
/* 110 */       departids = departids + ((DepartTec)departteclist.get(i)).getDepartid() + ",";
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
/* 123 */         ApplyNumGradeDAO adao = new ApplyNumGradeDAO();
/*     */ 
/* 126 */         ApplyTypeDAO atdao = new ApplyTypeDAO();
/* 127 */         List applytypelist = new LinkedList();
/* 128 */         hql = "from ApplyType where departid in (" + departid + ")";
/* 129 */         applytypelist.addAll(qdao.query(hql));
/*     */ 
/* 131 */         ApplyNumGrade ang = new ApplyNumGrade();
/* 132 */         ang = adao.findById(departid);
/* 133 */         GradeList grade = new GradeList();
/* 134 */         GradeListDAO gdao = new GradeListDAO();
/* 135 */         grade = gdao.findById(ang.getGradeid());
/* 136 */         request.setAttribute("gradename", grade.getGradename());
/*     */ 
/* 138 */         ApplyResultDAO ardao = new ApplyResultDAO();
/* 139 */         List applyresultlist = new LinkedList();
/* 140 */         hql = "from ApplyResult where departid in (" + departid + ")";
/* 141 */         applyresultlist.addAll(qdao.query(hql));
/*     */ 
/* 143 */         request.setAttribute("applytypelist", applytypelist);
/* 144 */         request.setAttribute("applyresultlist", applyresultlist);
/*     */ 
/* 146 */         request.setAttribute("teccode", teccode);
/*     */ 
/* 148 */         hql = "select count(*) from ApplyTec where teccode='" + teccode + "'";
/* 149 */         Long j = (Long)qdao.count(hql);
/* 150 */         hql = "select count(*) from ApplyTec where advice1='通过' and advice2='通过' and teccode='" + teccode + "'";
/* 151 */         Long k = (Long)qdao.count(hql);
/* 152 */         request.setAttribute("j", j);
/* 153 */         request.setAttribute("i", Long.valueOf(ang.getNum().intValue() - j.longValue()));
/* 154 */         request.setAttribute("k", k);
/* 155 */         request.setAttribute("gradeid", ang.getGradeid());
/*     */ 
/* 158 */         ApplyTec apply = new ApplyTec();
/* 159 */         ApplyTecDAO apdao = new ApplyTecDAO();
/* 160 */         List applylist = new LinkedList();
/* 161 */         hql = "from ApplyTec where teccode='" + teccode + "' and departid=" + departid + " and advice1='通过' and advice2='通过' and  gradeid=" + grade.getGradeid();
/* 162 */         applylist.addAll(qdao.query(hql));
/* 163 */         request.setAttribute("applylist", applylist);
/* 164 */         List wishlist = new LinkedList();
/* 165 */         List aslist = new LinkedList();
/* 166 */         if (atid.intValue() != 0)
/*     */         {
/* 168 */           StuWish stuwish = new StuWish();
/* 169 */           StuWishDAO wdao = new StuWishDAO();
/* 170 */           hql = "from StuWish where priority=1 and atid=" + atid;
/* 171 */           if (qdao.query(hql) != null) {
/* 172 */             wishlist.addAll(qdao.query(hql));
/*     */           }
/*     */ 
/* 175 */           hql = "from ApplyState where atid=" + atid;
/* 176 */           if (qdao.query(hql) != null) {
/* 177 */             aslist.addAll(qdao.query(hql));
/*     */           }
/*     */ 
/* 180 */           hql = "from Task where atid in (" + atid + ")";
/* 181 */           List tasklist = new LinkedList();
/* 182 */           tasklist.addAll(qdao.query(hql));
/* 183 */           request.setAttribute("aslist", aslist);
/* 184 */           request.setAttribute("tasklist", tasklist);
/* 185 */           request.setAttribute("wishlist", wishlist);
/* 186 */           request.setAttribute("atid", atid);
/*     */         } else {
/* 188 */           String atids = "";
/* 189 */           for (int i = 0; i < applylist.size(); ++i) {
/* 190 */             atids = atids + ((ApplyTec)applylist.get(i)).getAtid() + ",";
/*     */           }
/* 192 */           if (!atids.equals("")) {
/* 193 */             atids = atids.substring(0, atids.length() - 1);
/*     */ 
/* 195 */             StuWish stuwish = new StuWish();
/* 196 */             StuWishDAO wdao = new StuWishDAO();
/* 197 */             hql = "from StuWish where priority=1 and wishstate='通过' and atid in (" + atids + ")";
/* 198 */             wishlist.addAll(qdao.query(hql));
/*     */ 
/* 200 */             hql = "from Task where atid in (" + atids + ")";
/* 201 */             List tasklist = new LinkedList();
/* 202 */             tasklist.addAll(qdao.query(hql));
/*     */ 
/* 204 */             hql = "from ApplyState where atid in (" + atids + ")";
/* 205 */             if (qdao.query(hql) != null) {
/* 206 */               aslist.addAll(qdao.query(hql));
/*     */             }
/* 208 */             request.setAttribute("aslist", aslist);
/* 209 */             request.setAttribute("tasklist", tasklist);
/*     */           }
/* 211 */           request.setAttribute("wishlist", wishlist);
/* 212 */           request.setAttribute("atid", atid);
/* 213 */           if (wishlist.size() == 0) {
/* 214 */             request.setAttribute("notice", "暂时没有信息！");
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/* 222 */         String stucodes = "";
/* 223 */         for (int i = 0; i < wishlist.size(); ++i) {
/* 224 */           stucodes = stucodes + "'" + ((StuWish)wishlist.get(i)).getStucode() + "'" + ",";
/*     */         }
/* 226 */         List stulist = new LinkedList();
/* 227 */         if (!stucodes.equals("")) {
/* 228 */           stucodes = stucodes.substring(0, stucodes.length() - 1);
/* 229 */           StuListDAO studao = new StuListDAO();
/* 230 */           hql = "from StuList where stucode in(" + stucodes + ")";
/* 231 */           stulist.addAll(qdao.query(hql));
/*     */         }
/* 233 */         request.setAttribute("stulist", stulist);
/*     */       }
/*     */ 
/* 236 */       request.setAttribute("departid", departid);
/* 237 */       request.setAttribute("op", "new");
/*     */     }
/*     */ 
/* 240 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.task.StagetasklistAction
 * JD-Core Version:    0.5.4
 */