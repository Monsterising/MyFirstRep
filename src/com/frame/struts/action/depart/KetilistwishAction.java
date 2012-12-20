/*     */ package com.frame.struts.action.depart;
/*     */ 
/*     */ import com.entity.basedata.DepartTec;
/*     */ import com.entity.basedata.DepartTecDAO;
/*     */ import com.entity.basedata.StuList;
/*     */ import com.entity.basedata.StuListDAO;
/*     */ import com.entity.wish.ApplyNumGrade;
/*     */ import com.entity.wish.ApplyNumGradeDAO;
/*     */ import com.entity.wish.ApplyTec;
/*     */ import com.entity.wish.ApplyTecDAO;
/*     */ import com.entity.wish.ApplyTypeDAO;
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
/*     */ public class KetilistwishAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  60 */     HttpSession session = request.getSession();
/*  61 */     if (session.getAttribute("teccode") == null) {
/*  62 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  63 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  67 */     String teccode = (String)session.getAttribute("teccode");
/*  68 */     DepartTec departtec = new DepartTec();
/*  69 */     DepartTecDAO dao = new DepartTecDAO();
/*  70 */     List departteclist = dao.findByTeccode(teccode);
/*     */ 
/*  72 */     List departlist = new LinkedList();
/*  73 */     String departids = "";
/*  74 */     for (int i = 0; i < departteclist.size(); ++i) {
/*  75 */       if (((DepartTec)departteclist.get(i)).getTecrole().intValue() != 2)
/*     */         continue;
/*  77 */       session.setAttribute("userrole", Integer.valueOf(2));
/*  78 */       session.setAttribute("usershenfen", "专业负责人");
/*  79 */       departids = departids + ((DepartTec)departteclist.get(i)).getDepartid() + ",";
/*     */     }
/*     */ 
/*  83 */     if (departids.equals("")) {
/*  84 */       request.setAttribute("notice", "您没有该项权限！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  85 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  88 */     String departidstring = request.getParameter("departid");
/*  89 */     Integer departid = Integer.valueOf(0);
/*  90 */     Integer atid = Integer.valueOf(0);
/*  91 */     if (departidstring != null) {
/*  92 */       departid = Integer.valueOf(Integer.parseInt(departidstring));
/*     */     }
/*  94 */     if (request.getAttribute("departid") != null) {
/*  95 */       departid = Integer.valueOf(Integer.parseInt(request.getAttribute("departid").toString()));
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
/* 108 */       if (departid.intValue() != 0) {
/* 109 */         request.setAttribute("departid", departid);
/* 110 */         ApplyNumGradeDAO adao = new ApplyNumGradeDAO();
/* 111 */         ApplyNumGrade ang = new ApplyNumGrade();
/* 112 */         ang = adao.findById(departid);
/*     */ 
/* 116 */         String hql3 = "";
/* 117 */         hql3 = "select count(*) from StuList where gradeid=" + ang.getGradeid();
/* 118 */         request.setAttribute("stusum", qdao.count(hql3));
/*     */ 
/* 120 */         String hql2 = "select count(*) from ApplyTec where departid=" + departid + " and gradeid=" + ang.getGradeid() + 
/* 121 */           " and advice1='通过' and advice2='通过'";
/* 122 */         request.setAttribute("countcollege", qdao.count(hql2));
/*     */ 
/* 124 */         String hql4 = "";
/* 125 */         String stucodes = "";
/*     */ 
/* 127 */         StuListDAO sdao = new StuListDAO();
/* 128 */         List stulist = new LinkedList();
/* 129 */         hql = "from StuList where departid=" + departid + " and gradeid=" + ang.getGradeid();
/* 130 */         stulist.addAll(qdao.query(hql));
/* 131 */         if (stulist.size() == 0) {
/* 132 */           request.setAttribute("notice", "该专业尚无学生");
/* 133 */           return mapping.findForward("error");
/*     */         }
/* 135 */         for (int i = 0; i < stulist.size(); ++i) {
/* 136 */           stucodes = stucodes + "'" + ((StuList)stulist.get(i)).getStucode() + "',";
/*     */         }
/* 138 */         if (!stucodes.equals("")) {
/* 139 */           stucodes = stucodes.substring(0, stucodes.length() - 1);
/*     */         }
/* 141 */         hql4 = "select count(*) from Xuanti where stucode in(" + stucodes + ")";
/* 142 */         request.setAttribute("countwish", qdao.count(hql4));
/*     */ 
/* 148 */         DepartTec dt = new DepartTec();
/* 149 */         DepartTecDAO dtdao = new DepartTecDAO();
/* 150 */         List dtlist = new LinkedList();
/* 151 */         hql = "from DepartTec where departid=" + departid;
/* 152 */         dtlist.addAll(qdao.query(hql));
/* 153 */         String teccodes = "";
/* 154 */         for (int i = 0; i < dtlist.size(); ++i) {
/* 155 */           teccodes = teccodes + "'" + ((DepartTec)dtlist.get(i)).getTeccode() + "',";
/*     */         }
/* 157 */         if (!teccodes.equals("")) {
/* 158 */           teccodes = teccodes.substring(0, teccodes.length() - 1);
/*     */ 
/* 160 */           hql = "from TecList where teccode in (" + teccodes + ")";
/* 161 */           List teclist = new LinkedList();
/* 162 */           teclist.addAll(qdao.query(hql));
/* 163 */           request.setAttribute("teclist", teclist);
/*     */         }
/*     */ 
/* 169 */         ApplyTec applytec = new ApplyTec();
/* 170 */         ApplyTecDAO atdao = new ApplyTecDAO();
/* 171 */         List applylist = new LinkedList();
/* 172 */         if (request.getParameter("t") != null) {
/* 173 */           teccode = request.getParameter("t");
/*     */         }
/* 175 */         if ((teccode.equals("")) || (teccode.equals("0")))
/* 176 */           hql = "from ApplyTec where departid=" + departid + " and gradeid=" + ang.getGradeid() + " and advice1='通过' and advice2='通过' order by teccode";
/*     */         else {
/* 178 */           hql = "from ApplyTec where departid=" + departid + " and gradeid=" + ang.getGradeid() + "  and advice1='通过' and advice2='通过'  order by teccode";
/*     */         }
/* 180 */         applylist.addAll(qdao.query(hql));
/* 181 */         request.setAttribute("applylist", applylist);
/*     */ 
/* 184 */         ApplyTypeDAO typedao = new ApplyTypeDAO();
/* 185 */         List applytypelist = typedao.findAll();
/* 186 */         request.setAttribute("applytypelist", applytypelist);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 191 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.KetilistwishAction
 * JD-Core Version:    0.5.4
 */