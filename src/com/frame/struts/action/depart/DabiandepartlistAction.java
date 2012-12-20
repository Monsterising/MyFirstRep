/*     */ package com.frame.struts.action.depart;
/*     */ 
/*     */ import com.entity.basedata.DepartTec;
/*     */ import com.entity.basedata.DepartTecDAO;
/*     */ import com.entity.basedata.GradeList;
/*     */ import com.entity.basedata.GradeListDAO;
/*     */ import com.entity.basedata.StuListDAO;
/*     */ import com.entity.dabian.DabianChengji;
/*     */ import com.entity.wish.ApplyNumGrade;
/*     */ import com.entity.wish.ApplyNumGradeDAO;
/*     */ import com.entity.wish.ApplyTec;
/*     */ import com.entity.wish.ApplyTecDAO;
/*     */ import com.entity.wish.StuWish;
/*     */ import com.entity.wish.StuWishDAO;
/*     */ import java.io.PrintStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.MathContext;
/*     */ import java.math.RoundingMode;
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
/*     */ public class DabiandepartlistAction extends Action
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
/*  90 */       if (((DepartTec)departteclist.get(i)).getTecrole().intValue() != 2)
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
/* 102 */       System.out.println(departid + "==departid");
/* 103 */       if (departid.intValue() != 0)
/*     */       {
/* 105 */         ApplyNumGradeDAO adao = new ApplyNumGradeDAO();
/* 106 */         ApplyNumGrade ang = new ApplyNumGrade();
/* 107 */         ang = adao.findById(departid);
/* 108 */         GradeList grade = new GradeList();
/* 109 */         GradeListDAO gdao = new GradeListDAO();
/* 110 */         grade = gdao.findById(ang.getGradeid());
/* 111 */         request.setAttribute("gradename", grade.getGradename());
/*     */ 
/* 113 */         ApplyTec apply = new ApplyTec();
/* 114 */         ApplyTecDAO apdao = new ApplyTecDAO();
/* 115 */         List applylist = new LinkedList();
/* 116 */         hql = "from ApplyTec where departid=" + departid + " and advice1='通过' and advice2='通过' and  gradeid=" + grade.getGradeid();
/* 117 */         applylist.addAll(qdao.query(hql));
/* 118 */         request.setAttribute("applylist", applylist);
/* 119 */         System.out.println("applylistsize==" + applylist.size());
/* 120 */         List wishlist = new LinkedList();
/* 121 */         List aslist = new LinkedList();
/*     */ 
/* 123 */         String atids = "";
/* 124 */         for (int i = 0; i < applylist.size(); ++i) {
/* 125 */           atids = atids + ((ApplyTec)applylist.get(i)).getAtid() + ",";
/*     */         }
/* 127 */         if (!atids.equals("")) {
/* 128 */           atids = atids.substring(0, atids.length() - 1);
/*     */ 
/* 130 */           StuWish stuwish = new StuWish();
/* 131 */           StuWishDAO wdao = new StuWishDAO();
/* 132 */           hql = "from StuWish where priority=1 and wishstate='通过' and atid in (" + atids + ")";
/* 133 */           wishlist.addAll(qdao.query(hql));
/*     */         }
/*     */ 
/* 136 */         request.setAttribute("wishlist", wishlist);
/* 137 */         if (wishlist.size() == 0) {
/* 138 */           request.setAttribute("notice", "暂时没有信息！");
/*     */         }
/*     */ 
/* 145 */         String stucodes = "";
/* 146 */         for (int i = 0; i < wishlist.size(); ++i) {
/* 147 */           stucodes = stucodes + "'" + ((StuWish)wishlist.get(i)).getStucode() + "'" + ",";
/*     */         }
/* 149 */         List stulist = new LinkedList();
/* 150 */         if (!stucodes.equals("")) {
/* 151 */           stucodes = stucodes.substring(0, stucodes.length() - 1);
/* 152 */           StuListDAO studao = new StuListDAO();
/* 153 */           hql = "from StuList where stucode in(" + stucodes + ")";
/* 154 */           stulist.addAll(qdao.query(hql));
/*     */ 
/* 156 */           request.setAttribute("stulist", stulist);
/*     */ 
/* 159 */           List chengjilist = new LinkedList();
/* 160 */           chengjilist.addAll(qdao.query("from DabianChengji where stucode in(" + stucodes + ")"));
/* 161 */           request.setAttribute("chengjilist", chengjilist);
/*     */ 
/* 163 */           request.setAttribute("stusum", Integer.valueOf(chengjilist.size()));
/*     */ 
/* 166 */           int you = 0;
/* 167 */           int liang = 0;
/* 168 */           int zhong = 0;
/* 169 */           int jige = 0;
/* 170 */           int bujige = 0;
/* 171 */           double stusum = chengjilist.size();
/* 172 */           for (int i = 0; i < chengjilist.size(); ++i) {
/* 173 */             if (((DabianChengji)chengjilist.get(i)).getChengji().equals("优")) ++you;
/* 174 */             if (((DabianChengji)chengjilist.get(i)).getChengji().equals("良")) ++liang;
/* 175 */             if (((DabianChengji)chengjilist.get(i)).getChengji().equals("中")) ++zhong;
/* 176 */             if (((DabianChengji)chengjilist.get(i)).getChengji().equals("及格")) ++jige;
/* 177 */             if (!((DabianChengji)chengjilist.get(i)).getChengji().equals("不及格")) continue; ++bujige;
/*     */           }
/*     */ 
/* 181 */           MathContext v = new MathContext(2, RoundingMode.HALF_DOWN);
/*     */ 
/* 183 */           if (stusum != 0.0D) {
/* 184 */             BigDecimal A = new BigDecimal(you / stusum, v);
/* 185 */             BigDecimal B = new BigDecimal(liang / stusum, v);
/* 186 */             BigDecimal C = new BigDecimal(zhong / stusum, v);
/* 187 */             BigDecimal D = new BigDecimal(jige / stusum, v);
/* 188 */             BigDecimal E = new BigDecimal(bujige / stusum, v);
/*     */ 
/* 191 */             request.setAttribute("you", Integer.valueOf(you));
/* 192 */             request.setAttribute("youlv", A);
/*     */ 
/* 194 */             request.setAttribute("liang", Integer.valueOf(liang));
/* 195 */             request.setAttribute("lianglv", B);
/*     */ 
/* 197 */             request.setAttribute("zhong", Integer.valueOf(zhong));
/* 198 */             request.setAttribute("zhonglv", C);
/*     */ 
/* 200 */             request.setAttribute("jige", Integer.valueOf(jige));
/* 201 */             request.setAttribute("jigelv", D);
/*     */ 
/* 203 */             request.setAttribute("bujige", Integer.valueOf(bujige));
/* 204 */             request.setAttribute("bujigelv", E);
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 211 */       request.setAttribute("departid", departid);
/*     */     }
/*     */ 
/* 215 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.DabiandepartlistAction
 * JD-Core Version:    0.5.4
 */