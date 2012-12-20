/*     */ package com.frame.struts.action.depart;
/*     */ 
/*     */ import com.entity.basedata.DepartTec;
/*     */ import com.entity.basedata.DepartTecDAO;
/*     */ import com.entity.basedata.GradeList;
/*     */ import com.entity.basedata.GradeListDAO;
/*     */ import com.entity.basedata.StuListDAO;
/*     */ import com.entity.wish.ApplyNumGrade;
/*     */ import com.entity.wish.ApplyNumGradeDAO;
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
/*     */ public class DabianteclistAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  65 */     HttpSession session = request.getSession();
/*  66 */     if (session.getAttribute("teccode") == null) {
/*  67 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  68 */       return mapping.findForward("error");
/*     */     }
/*  70 */     String departidstring = request.getParameter("departid");
/*  71 */     Integer departid = Integer.valueOf(0);
/*  72 */     Integer atid = Integer.valueOf(0);
/*  73 */     if (departidstring != null) {
/*  74 */       departid = Integer.valueOf(Integer.parseInt(departidstring));
/*     */     }
/*  76 */     if (request.getAttribute("departid") != null) {
/*  77 */       departid = Integer.valueOf(Integer.parseInt(request.getAttribute("departid").toString()));
/*     */     }
/*     */ 
/*  82 */     String teccode = (String)session.getAttribute("teccode");
/*  83 */     DepartTec departtec = new DepartTec();
/*  84 */     DepartTecDAO dao = new DepartTecDAO();
/*  85 */     List departteclist = dao.findByTeccode(teccode);
/*     */ 
/*  87 */     List departlist = new LinkedList();
/*  88 */     String departids = "";
/*  89 */     for (int i = 0; i < departteclist.size(); ++i) {
/*  90 */       if ((((DepartTec)departteclist.get(i)).getTecrole().intValue() != 2) && (((DepartTec)departteclist.get(i)).getTecrole().intValue() != 1))
/*     */         continue;
/*  92 */       departids = departids + ((DepartTec)departteclist.get(i)).getDepartid() + ",";
/*     */     }
/*     */ 
/*  95 */     if (!departids.equals(""))
/*     */     {
/*  97 */       departids = departids.substring(0, departids.length() - 1);
/*  98 */       String hql = "from DepartList where departid in (" + departids + ")";
/*  99 */       Qdao qdao = new Qdao();
/* 100 */       departlist.addAll(qdao.query(hql));
/* 101 */       request.setAttribute("departlist", departlist);
/* 102 */       if (departid.intValue() != 0)
/*     */       {
/* 104 */         ApplyNumGradeDAO adao = new ApplyNumGradeDAO();
/* 105 */         ApplyNumGrade ang = new ApplyNumGrade();
/* 106 */         ang = adao.findById(departid);
/* 107 */         GradeList grade = new GradeList();
/* 108 */         GradeListDAO gdao = new GradeListDAO();
/* 109 */         grade = gdao.findById(ang.getGradeid());
/* 110 */         request.setAttribute("gradename", grade.getGradename());
/*     */ 
/* 112 */         ApplyTec apply = new ApplyTec();
/* 113 */         ApplyTecDAO apdao = new ApplyTecDAO();
/* 114 */         List applylist = new LinkedList();
/* 115 */         hql = "from ApplyTec where teccode='" + teccode + "' and departid=" + departid + " and advice1='通过' and advice2='通过' and  gradeid=" + grade.getGradeid();
/* 116 */         applylist.addAll(qdao.query(hql));
/* 117 */         request.setAttribute("applylist", applylist);
/* 118 */         List wishlist = new LinkedList();
/* 119 */         List aslist = new LinkedList();
/*     */ 
/* 121 */         String atids = "";
/* 122 */         for (int i = 0; i < applylist.size(); ++i) {
/* 123 */           atids = atids + ((ApplyTec)applylist.get(i)).getAtid() + ",";
/*     */         }
/* 125 */         if (!atids.equals("")) {
/* 126 */           atids = atids.substring(0, atids.length() - 1);
/*     */ 
/* 128 */           StuWish stuwish = new StuWish();
/* 129 */           StuWishDAO wdao = new StuWishDAO();
/* 130 */           hql = "from StuWish where priority=1 and wishstate='通过' and atid in (" + atids + ")";
/* 131 */           wishlist.addAll(qdao.query(hql));
/*     */         }
/*     */ 
/* 134 */         request.setAttribute("wishlist", wishlist);
/* 135 */         if (wishlist.size() == 0) {
/* 136 */           request.setAttribute("notice", "暂时没有信息！");
/*     */         }
/*     */ 
/* 143 */         String stucodes = "";
/* 144 */         for (int i = 0; i < wishlist.size(); ++i) {
/* 145 */           stucodes = stucodes + "'" + ((StuWish)wishlist.get(i)).getStucode() + "'" + ",";
/*     */         }
/* 147 */         List stulist = new LinkedList();
/* 148 */         if (!stucodes.equals("")) {
/* 149 */           stucodes = stucodes.substring(0, stucodes.length() - 1);
/* 150 */           StuListDAO studao = new StuListDAO();
/* 151 */           hql = "from StuList where stucode in(" + stucodes + ")";
/* 152 */           stulist.addAll(qdao.query(hql));
/*     */ 
/* 154 */           request.setAttribute("stulist", stulist);
/*     */ 
/* 157 */           List chengjilist = new LinkedList();
/* 158 */           chengjilist.addAll(qdao.query("from DabianChengji where stucode in(" + stucodes + ")"));
/* 159 */           request.setAttribute("chengjilist", chengjilist);
/*     */         }
/*     */       }
/*     */ 
/* 163 */       request.setAttribute("departid", departid);
/*     */     }
/*     */ 
/* 167 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.DabianteclistAction
 * JD-Core Version:    0.5.4
 */