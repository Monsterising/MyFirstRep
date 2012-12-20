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
/*     */ import com.entity.wish.StuWish;
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
/*     */ public class SturesultlistAction extends Action
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
/*  69 */     if (departidstring != null) {
/*  70 */       departid = Integer.valueOf(Integer.parseInt(departidstring));
/*     */     }
/*     */ 
/*  75 */     String teccode = (String)session.getAttribute("teccode");
/*  76 */     DepartTec departtec = new DepartTec();
/*  77 */     DepartTecDAO dao = new DepartTecDAO();
/*  78 */     List departteclist = dao.findByTeccode(teccode);
/*     */ 
/*  80 */     List departlist = new LinkedList();
/*  81 */     String departids = "";
/*  82 */     for (int i = 0; i < departteclist.size(); ++i) {
/*  83 */       if ((((DepartTec)departteclist.get(i)).getTecrole().intValue() != 2) && (((DepartTec)departteclist.get(i)).getTecrole().intValue() != 1))
/*     */         continue;
/*  85 */       departids = departids + ((DepartTec)departteclist.get(i)).getDepartid() + ",";
/*     */     }
/*     */ 
/*  88 */     if (departids.equals("")) {
/*  89 */       request.setAttribute("notice", "您暂无权限");
/*  90 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  93 */     request.setAttribute("departid", departid);
/*  94 */     if (!departids.equals(""))
/*     */     {
/*  96 */       departids = departids.substring(0, departids.length() - 1);
/*  97 */       String hql = "from DepartList where departid in (" + departids + ")";
/*  98 */       Qdao qdao = new Qdao();
/*  99 */       departlist.addAll(qdao.query(hql));
/* 100 */       request.setAttribute("departlist", departlist);
/* 101 */       if (departid.intValue() != 0)
/*     */       {
/* 104 */         DepartTec dt = new DepartTec();
/* 105 */         DepartTecDAO dtdao = new DepartTecDAO();
/* 106 */         List dtlist = new LinkedList();
/* 107 */         hql = "from DepartTec where departid=" + departid;
/* 108 */         dtlist.addAll(qdao.query(hql));
/* 109 */         String teccodes = "";
/* 110 */         for (int i = 0; i < dtlist.size(); ++i) {
/* 111 */           teccodes = teccodes + "'" + ((DepartTec)dtlist.get(i)).getTeccode() + "',";
/*     */         }
/* 113 */         if (!teccodes.equals("")) {
/* 114 */           teccodes = teccodes.substring(0, teccodes.length() - 1);
/*     */ 
/* 116 */           hql = "from TecList where teccode in (" + teccodes + ")";
/* 117 */           List teclist = new LinkedList();
/* 118 */           teclist.addAll(qdao.query(hql));
/* 119 */           request.setAttribute("teclist", teclist);
/*     */         }
/*     */ 
/* 123 */         ApplyNumGradeDAO adao = new ApplyNumGradeDAO();
/* 124 */         ApplyNumGrade ang = new ApplyNumGrade();
/* 125 */         ang = adao.findById(departid);
/* 126 */         GradeList grade = new GradeList();
/* 127 */         GradeListDAO gdao = new GradeListDAO();
/* 128 */         grade = gdao.findById(ang.getGradeid());
/* 129 */         request.setAttribute("gradename", grade.getGradename());
/* 130 */         ApplyResultDAO ardao = new ApplyResultDAO();
/* 131 */         List applyresultlist = new LinkedList();
/* 132 */         hql = "from ApplyResult where departid in (" + departid + ")";
/* 133 */         applyresultlist.addAll(qdao.query(hql));
/*     */ 
/* 135 */         request.setAttribute("applyresultlist", applyresultlist);
/* 136 */         request.setAttribute("teccode", teccode);
/* 137 */         request.setAttribute("gradeid", ang.getGradeid());
/*     */ 
/* 139 */         List applylist = new LinkedList();
/* 140 */         hql = "from ApplyTec where departid=" + departid + " and advice1='通过' and advice2='通过' and  gradeid=" + grade.getGradeid();
/* 141 */         applylist.addAll(qdao.query(hql));
/* 142 */         request.setAttribute("applylist", applylist);
/* 143 */         String atids = "";
/* 144 */         for (int i = 0; i < applylist.size(); ++i) {
/* 145 */           atids = atids + ((ApplyTec)applylist.get(i)).getAtid() + ",";
/*     */         }
/* 147 */         if (!atids.equals("")) {
/* 148 */           atids = atids.substring(0, atids.length() - 1);
/*     */         } else {
/* 150 */           request.setAttribute("notice", "暂无选题信息");
/* 151 */           return mapping.findForward("error");
/*     */         }
/*     */ 
/* 154 */         List wishlist = new LinkedList();
/* 155 */         String stucodes = "";
/* 156 */         hql = "from StuWish where priority=1 and wishstate='通过' and atid in (" + atids + ")  order by teccode ";
/* 157 */         wishlist.addAll(qdao.query(hql));
/* 158 */         for (int i = 0; i < wishlist.size(); ++i) {
/* 159 */           stucodes = stucodes + "'" + ((StuWish)wishlist.get(i)).getStucode() + "'" + ",";
/*     */         }
/* 161 */         List stulist = new LinkedList();
/* 162 */         if (!stucodes.equals("")) {
/* 163 */           stucodes = stucodes.substring(0, stucodes.length() - 1);
/* 164 */           StuListDAO studao = new StuListDAO();
/* 165 */           hql = "from StuList where stucode in(" + stucodes + ")";
/* 166 */           stulist.addAll(qdao.query(hql));
/*     */         }
/* 168 */         request.setAttribute("stulist", stulist);
/* 169 */         request.setAttribute("wishlist", wishlist);
/*     */ 
/* 171 */         List atrlist = new LinkedList();
/* 172 */         hql = "from ApplyTecResult where atid in(" + atids + ")";
/* 173 */         atrlist.addAll(qdao.query(hql));
/* 174 */         request.setAttribute("atrlist", atrlist);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 179 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.SturesultlistAction
 * JD-Core Version:    0.5.4
 */