/*     */ package com.frame.struts.action.dabian;
/*     */ 
/*     */ import com.entity.basedata.CollegeList;
/*     */ import com.entity.basedata.CollegeListDAO;
/*     */ import com.entity.basedata.DepartTec;
/*     */ import com.entity.basedata.DepartTecDAO;
/*     */ import com.entity.basedata.GradeList;
/*     */ import com.entity.basedata.GradeListDAO;
/*     */ import com.entity.dabian.DabianGroup;
/*     */ import com.entity.dabian.DabianGroupDAO;
/*     */ import com.entity.dabian.DabianGroupStu;
/*     */ import com.entity.dabian.DabianGroupStuDAO;
/*     */ import com.entity.dabian.DabianGroupTec;
/*     */ import com.entity.dabian.DabianGroupTecDAO;
/*     */ import com.entity.wish.ApplyNumGrade;
/*     */ import com.entity.wish.ApplyNumGradeDAO;
/*     */ import java.io.PrintStream;
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
/*     */ public class DabiangroupnewAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  66 */     HttpSession session = request.getSession();
/*  67 */     if (session.getAttribute("teccode") == null) {
/*  68 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  69 */       return mapping.findForward("error");
/*     */     }
/*  71 */     String teccode = session.getAttribute("teccode").toString();
/*  72 */     Integer collegeid = Integer.valueOf(Integer.parseInt(session.getAttribute("collegeid").toString()));
/*     */ 
/*  74 */     String departidstring = request.getParameter("departid");
/*  75 */     Integer departid = Integer.valueOf(0);
/*  76 */     if ((departidstring != null) && (!departidstring.equals(""))) {
/*  77 */       departid = Integer.valueOf(Integer.parseInt(departidstring));
/*     */     }
/*  79 */     if (request.getAttribute("departid") != null) {
/*  80 */       departid = Integer.valueOf(Integer.parseInt(request.getAttribute("departid").toString()));
/*     */     }
/*     */ 
/*  83 */     CollegeList collegelist = new CollegeList();
/*  84 */     CollegeListDAO cdao = new CollegeListDAO();
/*  85 */     collegelist = cdao.findById(collegeid);
/*  86 */     request.setAttribute("CollegeList", collegelist);
/*     */ 
/*  90 */     DepartTec departtec = new DepartTec();
/*  91 */     DepartTecDAO dao = new DepartTecDAO();
/*  92 */     List departteclist = dao.findByTeccode(teccode);
/*     */ 
/*  94 */     List departlist = new LinkedList();
/*  95 */     String departids = "";
/*  96 */     for (int i = 0; i < departteclist.size(); ++i) {
/*  97 */       if ((((DepartTec)departteclist.get(i)).getTecrole().intValue() != 2) && (((DepartTec)departteclist.get(i)).getTecrole().intValue() != 1))
/*     */         continue;
/*  99 */       departids = departids + ((DepartTec)departteclist.get(i)).getDepartid() + ",";
/*     */     }
/*     */ 
/* 104 */     if (!departids.equals(""))
/*     */     {
/* 106 */       departids = departids.substring(0, departids.length() - 1);
/* 107 */       String hql = "from DepartList where departid in (" + departids + ")";
/* 108 */       Qdao qdao = new Qdao();
/* 109 */       departlist.addAll(qdao.query(hql));
/* 110 */       request.setAttribute("departlist", departlist);
/* 111 */       if (departid.intValue() != 0) {
/* 112 */         ApplyNumGrade ang = new ApplyNumGrade();
/* 113 */         ApplyNumGradeDAO adao = new ApplyNumGradeDAO();
/* 114 */         ang = adao.findById(departid);
/* 115 */         request.setAttribute("gradeid", ang.getGradeid());
/* 116 */         GradeList grade = new GradeList();
/* 117 */         GradeListDAO gdao = new GradeListDAO();
/* 118 */         grade = gdao.findById(ang.getGradeid());
/* 119 */         request.setAttribute("gradename", grade.getGradename());
/*     */ 
/* 121 */         DepartTec dt = new DepartTec();
/* 122 */         DepartTecDAO dtdao = new DepartTecDAO();
/* 123 */         List dtlist = new LinkedList();
/* 124 */         hql = "from DepartTec where departid=" + departid;
/* 125 */         dtlist.addAll(qdao.query(hql));
/* 126 */         String teccodes = "";
/* 127 */         for (int i = 0; i < dtlist.size(); ++i) {
/* 128 */           teccodes = teccodes + "'" + ((DepartTec)dtlist.get(i)).getTeccode() + "',";
/*     */         }
/* 130 */         if (!teccodes.equals("")) {
/* 131 */           teccodes = teccodes.substring(0, teccodes.length() - 1);
/*     */ 
/* 133 */           hql = "from TecList where teccode in (" + teccodes + ")";
/* 134 */           List leaderlist = new LinkedList();
/* 135 */           leaderlist.addAll(qdao.query(hql));
/* 136 */           request.setAttribute("leaderlist", leaderlist);
/* 137 */           request.setAttribute("departid", departid);
/*     */ 
/* 140 */           hql = "from TecList where teccode in (" + teccodes + ")";
/* 141 */           DabianGroupTecDAO dgtdao = new DabianGroupTecDAO();
/*     */ 
/* 143 */           DabianGroupDAO dgdao = new DabianGroupDAO();
/* 144 */           List dglist = dgdao.findByDepartid(departid);
/* 145 */           String dbgids = "";
/* 146 */           for (int i = 0; i < dglist.size(); ++i) {
/* 147 */             dbgids = dbgids + ((DabianGroup)dglist.get(i)).getDbgid() + ",";
/*     */           }
/* 149 */           if (!dbgids.equals("")) {
/* 150 */             dbgids = dbgids.substring(0, dbgids.length() - 1);
/* 151 */             List dgtlist = new LinkedList();
/* 152 */             String hql2 = "from DabianGroupTec where dbgid in(" + dbgids + ")";
/* 153 */             System.out.println(hql2);
/* 154 */             dgtlist.addAll(qdao.query(hql2));
/*     */ 
/* 157 */             String dgtcodes = "";
/* 158 */             for (int i = 0; i < dgtlist.size(); ++i) {
/* 159 */               dgtcodes = dgtcodes + "'" + ((DabianGroupTec)dgtlist.get(i)).getTeccode() + "',";
/*     */             }
/* 161 */             if (!dgtcodes.equals("")) {
/* 162 */               dgtcodes = dgtcodes.substring(0, dgtcodes.length() - 1);
/* 163 */               hql = hql + " and teccode not in(" + dgtcodes + ")";
/*     */             }
/*     */           }
/* 166 */           List teclist = new LinkedList();
/* 167 */           teclist.addAll(qdao.query(hql));
/* 168 */           request.setAttribute("teclist", teclist);
/*     */         }
/*     */ 
/* 172 */         hql = "from StuList where departid=" + departid + " and gradeid=" + ang.getGradeid();
/* 173 */         DabianGroupStuDAO dgsdao = new DabianGroupStuDAO();
/* 174 */         List dgslist = dgsdao.findAll();
/* 175 */         String dgscodes = "";
/* 176 */         for (int i = 0; i < dgslist.size(); ++i) {
/* 177 */           dgscodes = dgscodes + "'" + ((DabianGroupStu)dgslist.get(i)).getStucode() + "',";
/*     */         }
/* 179 */         if (!dgscodes.equals("")) {
/* 180 */           dgscodes = dgscodes.substring(0, dgscodes.length() - 1);
/* 181 */           hql = hql + " and stucode not in(" + dgscodes + ")";
/*     */         }
/* 183 */         List stulist = new LinkedList();
/* 184 */         stulist.addAll(qdao.query(hql));
/* 185 */         request.setAttribute("stulist", stulist);
/*     */       }
/* 187 */       request.setAttribute("departid", departid);
/* 188 */       request.setAttribute("op", "new");
/*     */ 
/* 197 */       return mapping.findForward("display");
/*     */     }
/* 199 */     request.setAttribute("notice", "你还没有分配专业！");
/* 200 */     return mapping.findForward("error");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.dabian.DabiangroupnewAction
 * JD-Core Version:    0.5.4
 */