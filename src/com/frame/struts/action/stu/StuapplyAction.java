/*     */ package com.frame.struts.action.stu;
/*     */ 
/*     */ import com.entity.basedata.DepartListDAO;
/*     */ import com.entity.basedata.GradeList;
/*     */ import com.entity.basedata.GradeListDAO;
/*     */ import com.entity.wish.ApplyNumGrade;
/*     */ import com.entity.wish.ApplyNumGradeDAO;
/*     */ import com.entity.wish.ApplyResultDAO;
/*     */ import com.entity.wish.ApplyTec;
/*     */ import com.entity.wish.ApplyTecDAO;
/*     */ import com.entity.wish.ApplyTecResult;
/*     */ import com.entity.wish.ApplyType;
/*     */ import com.entity.wish.ApplyTypeDAO;
/*     */ import com.entity.wish.StuWish;
/*     */ import com.entity.wish.StuWishDAO;
/*     */ import com.frame.struts.form.wish.KetishenbaoForm;
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
/*     */ public class StuapplyAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  62 */     HttpSession session = request.getSession();
/*  63 */     if (session.getAttribute("stucode") == null) {
/*  64 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  65 */       return mapping.findForward("error");
/*     */     }
/*  67 */     KetishenbaoForm kform = (KetishenbaoForm)form;
/*     */ 
/*  69 */     Integer collegeid = Integer.valueOf(Integer.parseInt(session.getAttribute("collegeid").toString()));
/*  70 */     Integer atid = Integer.valueOf(Integer.parseInt(request.getParameter("atid").toString()));
/*  71 */     String stucode = (String)session.getAttribute("stucode");
/*     */ 
/*  74 */     ApplyTec applytec = new ApplyTec();
/*  75 */     ApplyTecDAO atdao = new ApplyTecDAO();
/*  76 */     applytec = atdao.findById(atid);
/*  77 */     Integer departid = applytec.getDepartid();
/*  78 */     request.setAttribute("ApplyTec", applytec);
/*  79 */     request.setAttribute("tecprof", applytec.getTecprof());
/*     */ 
/*  82 */     List atrlist = new LinkedList();
/*  83 */     String hql = "from ApplyTecResult where atid=" + applytec.getAtid();
/*     */ 
/*  85 */     Qdao qdao = new Qdao();
/*  86 */     atrlist.addAll(qdao.query(hql));
/*  87 */     Integer[] resultids = new Integer[atrlist.size()];
/*     */ 
/*  89 */     for (int k = 0; k < atrlist.size(); ++k)
/*     */     {
/*  91 */       resultids[k] = ((ApplyTecResult)atrlist.get(k)).getResultid();
/*     */     }
/*  93 */     kform.setResultids(resultids);
/*  94 */     request.setAttribute("KetishenbaoForm", kform);
/*     */ 
/*  96 */     ApplyType applytype = new ApplyType();
/*  97 */     ApplyTypeDAO typedao = new ApplyTypeDAO();
/*  98 */     List applytypelist = typedao.findByDepartid(departid);
/*  99 */     request.setAttribute("applytypelist", applytypelist);
/*     */ 
/* 102 */     ApplyNumGrade ang = new ApplyNumGrade();
/* 103 */     ApplyNumGradeDAO adao = new ApplyNumGradeDAO();
/* 104 */     ang = adao.findById(departid);
/* 105 */     GradeList grade = new GradeList();
/* 106 */     GradeListDAO gdao = new GradeListDAO();
/* 107 */     grade = gdao.findById(ang.getGradeid());
/* 108 */     request.setAttribute("gradename", grade.getGradename());
/* 109 */     request.setAttribute("departid", departid);
/*     */ 
/* 112 */     DepartListDAO departdao = new DepartListDAO();
/* 113 */     List departlist = departdao.findByCollegeid(collegeid);
/* 114 */     request.setAttribute("departlist", departlist);
/*     */ 
/* 116 */     request.setAttribute("disable", "disabled");
/*     */ 
/* 119 */     ApplyResultDAO ardao = new ApplyResultDAO();
/* 120 */     List applyresultlist = new LinkedList();
/* 121 */     hql = "from ApplyResult where departid in (" + departid + ")";
/* 122 */     applyresultlist.addAll(qdao.query(hql));
/* 123 */     request.setAttribute("applyresultlist", applyresultlist);
/*     */ 
/* 126 */     request.setAttribute("op", "stuapply");
/* 127 */     request.setAttribute("gradeid", grade.getGradeid());
/* 128 */     request.setAttribute("atid", applytec.getAtid());
/*     */ 
/* 131 */     StuWish stuwish = new StuWish();
/* 132 */     StuWishDAO wdao = new StuWishDAO();
/* 133 */     List wishlist = null;
/* 134 */     if (wdao.findByStucode(stucode) != null) {
/* 135 */       wishlist = wdao.findByStucode(stucode);
/*     */     }
/* 137 */     request.setAttribute("wishlist", wishlist);
/*     */ 
/* 140 */     hql = "from Xuanti where stucode='" + stucode + "'";
/*     */ 
/* 142 */     if (qdao.query(hql).size() != 0) {
/* 143 */       request.setAttribute("xuantiok", "disabled");
/* 144 */       request.setAttribute("notice", "亲，你的志愿已经得到老师批准，不能再填报志愿了哦！");
/*     */     }
/*     */ 
/* 147 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.stu.StuapplyAction
 * JD-Core Version:    0.5.4
 */