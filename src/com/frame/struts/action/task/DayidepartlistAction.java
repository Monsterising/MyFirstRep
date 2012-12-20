/*     */ package com.frame.struts.action.task;
/*     */ 
/*     */ import com.entity.basedata.DepartTec;
/*     */ import com.entity.basedata.DepartTecDAO;
/*     */ import com.entity.basedata.StuList;
/*     */ import com.entity.basedata.StuListDAO;
/*     */ import com.entity.wish.ApplyNumGrade;
/*     */ import com.entity.wish.ApplyNumGradeDAO;
/*     */ import com.entity.wish.Xuanti;
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
/*     */ public class DayidepartlistAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  57 */     HttpSession session = request.getSession();
/*  58 */     if (session.getAttribute("teccode") == null) {
/*  59 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  60 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  65 */     String teccode = (String)session.getAttribute("teccode");
/*  66 */     DepartTec departtec = new DepartTec();
/*  67 */     DepartTecDAO dao = new DepartTecDAO();
/*  68 */     List departteclist = dao.findByTeccode(teccode);
/*     */ 
/*  70 */     List departlist = new LinkedList();
/*  71 */     String departids = "";
/*  72 */     for (int i = 0; i < departteclist.size(); ++i) {
/*  73 */       if (((DepartTec)departteclist.get(i)).getTecrole().intValue() != 2)
/*     */         continue;
/*  75 */       session.setAttribute("userrole", Integer.valueOf(2));
/*  76 */       session.setAttribute("usershenfen", "专业负责人");
/*  77 */       departids = departids + ((DepartTec)departteclist.get(i)).getDepartid() + ",";
/*     */     }
/*     */ 
/*  83 */     if (departids.equals("")) {
/*  84 */       request.setAttribute("notice", "您没有该项权限！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  85 */       return mapping.findForward("error");
/*     */     }
/*  87 */     departids = departids.substring(0, departids.length() - 1);
/*  88 */     String hql = "from DepartList where departid in (" + departids + ")";
/*  89 */     Qdao qdao = new Qdao();
/*     */ 
/*  91 */     departlist.addAll(qdao.query(hql));
/*  92 */     request.setAttribute("departlist", departlist);
/*     */ 
/*  96 */     String departidstring = request.getParameter("departid");
/*  97 */     String tec = request.getParameter("tec");
/*  98 */     Integer departid = Integer.valueOf(0);
/*  99 */     Integer atid = Integer.valueOf(0);
/* 100 */     if (departidstring != null) {
/* 101 */       departid = Integer.valueOf(Integer.parseInt(departidstring));
/*     */     }
/* 103 */     if (request.getAttribute("departid") != null) {
/* 104 */       departid = Integer.valueOf(Integer.parseInt(request.getAttribute("departid").toString()));
/*     */     }
/*     */ 
/* 109 */     if ((!departids.equals("")) && (departid.intValue() != 0)) {
/* 110 */       request.setAttribute("departid", departid);
/*     */ 
/* 113 */       String teccodestring = "";
/* 114 */       if (request.getParameter("t") != null) {
/* 115 */         teccodestring = request.getParameter("t").toString();
/*     */       }
/*     */ 
/* 119 */       List dayilist = new LinkedList();
/* 120 */      
/* 121 */      
/* 122 */       String sql = "";
/* 123 */       if (!teccodestring.equals("")) {
/* 124 */         sql = " and teccode='" + teccodestring + "'";
/* 125 */         request.setAttribute("teccode", teccodestring);
/*     */       }
/* 127 */       hql = "from Stagetaskdayi where departid=" + departid + " " + sql + " order by isok,qtime";
/* 128 */       dayilist.addAll(qdao.query(hql));
/* 129 */       request.setAttribute("dayilist", dayilist);
/*     */ 
/* 131 */       String stucode = "";
/* 132 */       if (request.getParameter("s") != null) {
/* 133 */         stucode = request.getParameter("s").toString();
/*     */       }
/*     */ 
/* 140 */       String stucodes = "";
/*     */ 
/* 142 */       if (!stucode.equals("")) {
/* 143 */         sql = " and stucode='" + stucode + "'";
/* 144 */         request.setAttribute("stucode", stucode);
/*     */       }
/* 146 */       hql = "from Stagetaskdayi where departid=" + departid + " " + sql + " order by isok,qtime";
/* 147 */       dayilist.clear();
/* 148 */       dayilist.addAll(qdao.query(hql));
/* 149 */       request.setAttribute("dayilist", dayilist);
/*     */ 
/* 153 */       DepartTec dt = new DepartTec();
/* 154 */       DepartTecDAO dtdao = new DepartTecDAO();
/* 155 */       List dtlist = new LinkedList();
/* 156 */       hql = "from DepartTec where departid=" + departid;
/* 157 */       dtlist.addAll(qdao.query(hql));
/* 158 */       String teccodes = "";
/* 159 */       for (int i = 0; i < dtlist.size(); ++i) {
/* 160 */         teccodes = teccodes + "'" + ((DepartTec)dtlist.get(i)).getTeccode() + "',";
/*     */       }
/* 162 */       if (!teccodes.equals("")) {
/* 163 */         teccodes = teccodes.substring(0, teccodes.length() - 1);
/*     */ 
/* 165 */         hql = "from TecList where teccode in (" + teccodes + ")";
/* 166 */         List teclist = new LinkedList();
/* 167 */         teclist.addAll(qdao.query(hql));
/* 168 */         request.setAttribute("teclist", teclist);
/*     */       }
/*     */ 
/* 175 */       List xlist = new LinkedList();
/* 176 */       hql = "from Xuanti where teccode in(" + teccodes + ")";
/* 177 */       xlist.addAll(qdao.query(hql));
/*     */ 
/* 179 */       if (xlist.size() != 0) {
/* 180 */         for (int i = 0; i < xlist.size(); ++i) {
/* 181 */           stucodes = stucodes + "'" + ((Xuanti)xlist.get(i)).getStucode() + "',";
/*     */         }
/* 183 */         List stulist = new LinkedList();
/* 184 */         stucodes = stucodes.substring(0, stucodes.length() - 1);
/* 185 */         hql = "from StuList where stucode in(" + stucodes + ")";
/* 186 */         stulist.addAll(qdao.query(hql));
/* 187 */         request.setAttribute("stulist", stulist);
/* 188 */         request.setAttribute("stusumtec", Integer.valueOf(stulist.size()));
/*     */       } else {
/* 190 */         request.setAttribute("notice", "您暂且没有指导学生");
/*     */       }
/* 192 */       if (dayilist.size() == 0) {
/* 193 */         request.setAttribute("notice", "暂无记录！");
/*     */       }
/*     */ 
/* 199 */       ApplyNumGradeDAO adao = new ApplyNumGradeDAO();
/* 200 */       ApplyNumGrade ang = new ApplyNumGrade();
/* 201 */       ang = adao.findById(departid);
/*     */ 
/* 203 */       String hql3 = "";
/* 204 */       hql3 = "select count(*) from StuList where gradeid=" + ang.getGradeid();
/* 205 */       request.setAttribute("stusum", qdao.count(hql3));
/*     */ 
/* 207 */       String hql2 = "select count(*) from Stagetaskdayi where teccode='" + teccodestring + "' and departid=" + departid + " and gradeid=" + ang.getGradeid();
/*     */ 
/* 209 */       request.setAttribute("countqs", qdao.count(hql2));
/*     */ 
/* 211 */       String hql4 = "";
/* 212 */       stucodes = "";
/* 213 */       StuListDAO sdao = new StuListDAO();
/* 214 */       List stulist0 = new LinkedList();
/* 215 */       hql = "from StuList where departid=" + departid + " and gradeid=" + ang.getGradeid();
/* 216 */       stulist0.addAll(qdao.query(hql));
/* 217 */       if (stulist0.size() == 0) {
/* 218 */         request.setAttribute("notice", "该专业尚无学生");
/* 219 */         return mapping.findForward("error");
/*     */       }
/* 221 */       for (int i = 0; i < stulist0.size(); ++i) {
/* 222 */         stucodes = stucodes + "'" + ((StuList)stulist0.get(i)).getStucode() + "',";
/*     */       }
/* 224 */       if (!stucodes.equals("")) {
/* 225 */         stucodes = stucodes.substring(0, stucodes.length() - 1);
/*     */       }
/* 227 */       hql4 = "select count(*) from Stagetaskdayi where teccode='" + teccodestring + "' and departid=" + departid + " and gradeid=" + ang.getGradeid() + 
/* 228 */         " and isok=1";
/* 229 */       request.setAttribute("countok", qdao.count(hql4));
/*     */     }
/*     */ 
/* 241 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.task.DayidepartlistAction
 * JD-Core Version:    0.5.4
 */