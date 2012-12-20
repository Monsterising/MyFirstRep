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
/*     */ import com.frame.struts.form.dabian.DabiangroupForm;
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
/*     */ public class DabianshezhieditAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  63 */     DabiangroupForm dbgform = (DabiangroupForm)form;
/*  64 */     HttpSession session = request.getSession();
/*  65 */     if (session.getAttribute("teccode") == null) {
/*  66 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  67 */       return mapping.findForward("error");
/*     */     }
/*  69 */     String teccode = session.getAttribute("teccode").toString();
/*  70 */     Integer collegeid = Integer.valueOf(Integer.parseInt(session.getAttribute("collegeid").toString()));
/*  71 */     Integer dbgid = Integer.valueOf(Integer.parseInt(request.getParameter("id")));
/*     */ 
/*  74 */     DabianGroup dbg = new DabianGroup();
/*  75 */     DabianGroupDAO dbgdao = new DabianGroupDAO();
/*  76 */     dbg = dbgdao.findById(dbgid);
/*  77 */     request.setAttribute("departid", dbg.getDepartid());
/*  78 */     request.setAttribute("gradeid", dbg.getGradeid());
/*  79 */     request.setAttribute("groupname", dbg.getGroupname());
/*  80 */     request.setAttribute("leadercode", dbg.getLeader());
/*  81 */     request.setAttribute("dbgid", dbg.getDbgid());
/*  82 */     request.setAttribute("datetime", dbg.getDatetime());
/*  83 */     request.setAttribute("place", dbg.getPlace());
/*     */ 
/*  87 */     String departidstring = request.getParameter("departid");
/*  88 */     Integer departid = Integer.valueOf(0);
/*  89 */     if ((departidstring != null) && (!departidstring.equals(""))) {
/*  90 */       departid = Integer.valueOf(Integer.parseInt(departidstring));
/*     */     }
/*  92 */     if (request.getAttribute("departid") != null) {
/*  93 */       departid = Integer.valueOf(Integer.parseInt(request.getAttribute("departid").toString()));
/*     */     }
/*  95 */     CollegeList collegelist = new CollegeList();
/*  96 */     CollegeListDAO cdao = new CollegeListDAO();
/*  97 */     collegelist = cdao.findById(collegeid);
/*  98 */     request.setAttribute("CollegeList", collegelist);
/*     */ 
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
/* 114 */     if (!departids.equals(""))
/*     */     {
/* 116 */       departids = departids.substring(0, departids.length() - 1);
/* 117 */       String hql = "from DepartList where departid in (" + departids + ")";
/* 118 */       Qdao qdao = new Qdao();
/* 119 */       departlist.addAll(qdao.query(hql));
/* 120 */       request.setAttribute("departlist", departlist);
/*     */ 
/* 123 */       ApplyNumGrade ang = new ApplyNumGrade();
/* 124 */       ApplyNumGradeDAO adao = new ApplyNumGradeDAO();
/* 125 */       ang = adao.findById(departid);
/* 126 */       request.setAttribute("gradeid", ang.getGradeid());
/* 127 */       GradeList grade = new GradeList();
/* 128 */       GradeListDAO gdao = new GradeListDAO();
/* 129 */       grade = gdao.findById(ang.getGradeid());
/* 130 */       request.setAttribute("gradename", grade.getGradename());
/*     */ 
/* 133 */       DepartTec dt = new DepartTec();
/* 134 */       DepartTecDAO dtdao = new DepartTecDAO();
/* 135 */       List dtlist = new LinkedList();
/* 136 */       hql = "from DepartTec where departid=" + departid;
/* 137 */       dtlist.addAll(qdao.query(hql));
/* 138 */       String teccodes = "";
/* 139 */       for (int i = 0; i < dtlist.size(); ++i) {
/* 140 */         teccodes = teccodes + "'" + ((DepartTec)dtlist.get(i)).getTeccode() + "',";
/*     */       }
/* 142 */       if (!teccodes.equals("")) {
/* 143 */         teccodes = teccodes.substring(0, teccodes.length() - 1);
/*     */ 
/* 145 */         hql = "from TecList where teccode in (" + teccodes + ")";
/* 146 */         List leaderlist = new LinkedList();
/* 147 */         leaderlist.addAll(qdao.query(hql));
/* 148 */         request.setAttribute("leaderlist", leaderlist);
/* 149 */         request.setAttribute("departid", departid);
/*     */ 
/* 152 */         hql = "from TecList where teccode in (" + teccodes + ")";
/* 153 */         DabianGroupTecDAO dgtdao = new DabianGroupTecDAO();
/*     */ 
/* 155 */         DabianGroupDAO dgdao = new DabianGroupDAO();
/* 156 */         List dglist = dgdao.findByDepartid(departid);
/* 157 */         String dbgids = "";
/* 158 */         for (int i = 0; i < dglist.size(); ++i) {
/* 159 */           dbgids = dbgids + ((DabianGroup)dglist.get(i)).getDbgid() + ",";
/*     */         }
/* 161 */         if (!dbgids.equals("")) {
/* 162 */           dbgids = dbgids.substring(0, dbgids.length() - 1);
/* 163 */           List dgtlist = new LinkedList();
/* 164 */           String hql2 = "from DabianGroupTec where dbgid in(" + dbgids + ") and dbgid not in (" + dbgid + ")";
/* 165 */           System.out.println(hql2);
/* 166 */           dgtlist.addAll(qdao.query(hql2));
/* 167 */           String dgtcodes = "";
/* 168 */           for (int i = 0; i < dgtlist.size(); ++i) {
/* 169 */             dgtcodes = dgtcodes + "'" + ((DabianGroupTec)dgtlist.get(i)).getTeccode() + "',";
/*     */           }
/* 171 */           if (!dgtcodes.equals("")) {
/* 172 */             dgtcodes = dgtcodes.substring(0, dgtcodes.length() - 1);
/* 173 */             hql = hql + " and teccode not in(" + dgtcodes + ")";
/*     */           }
/*     */         }
/* 176 */         List teclist = new LinkedList();
/* 177 */         teclist.addAll(qdao.query(hql));
/* 178 */         request.setAttribute("teclist", teclist);
/*     */ 
/* 180 */         List dgtlist2 = new LinkedList();
/* 181 */         dgtlist2.addAll(qdao.query("from DabianGroupTec where dbgid=" + dbg.getDbgid()));
/* 182 */         String dgtcodes2 = "";
/* 183 */         for (int i = 0; i < dgtlist2.size(); ++i) {
/* 184 */           dgtcodes2 = dgtcodes2 + ((DabianGroupTec)dgtlist2.get(i)).getTeccode() + ",";
/*     */         }
/* 186 */         if (!dgtcodes2.equals("")) {
/* 187 */           dgtcodes2 = dgtcodes2.substring(0, dgtcodes2.length() - 1);
/* 188 */           String[] dgtcodes21 = dgtcodes2.split(",");
/* 189 */           dbgform.setTeccodes(dgtcodes21);
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 196 */       hql = "from StuList where departid=" + departid + " and gradeid=" + ang.getGradeid();
/* 197 */       DabianGroupStuDAO dgsdao = new DabianGroupStuDAO();
/* 198 */       List dgslist = new LinkedList();
/* 199 */       dgslist.addAll(qdao.query("from DabianGroupStu where dbgid!=" + dbg.getDbgid()));
/* 200 */       String dgscodes = "";
/* 201 */       for (int i = 0; i < dgslist.size(); ++i) {
/* 202 */         dgscodes = dgscodes + "'" + ((DabianGroupStu)dgslist.get(i)).getStucode() + "',";
/*     */       }
/* 204 */       if (!dgscodes.equals("")) {
/* 205 */         dgscodes = dgscodes.substring(0, dgscodes.length() - 1);
/* 206 */         hql = hql + " and stucode not in(" + dgscodes + ")";
/*     */       }
/* 208 */       List stulist = new LinkedList();
/* 209 */       stulist.addAll(qdao.query(hql));
/* 210 */       request.setAttribute("stulist", stulist);
/*     */ 
/* 212 */       List dgslist2 = new LinkedList();
/* 213 */       dgslist2.addAll(qdao.query("from DabianGroupStu where dbgid=" + dbg.getDbgid()));
/* 214 */       String dgscodes2 = "";
/* 215 */       for (int i = 0; i < dgslist2.size(); ++i) {
/* 216 */         dgscodes2 = dgscodes2 + ((DabianGroupStu)dgslist2.get(i)).getStucode() + ",";
/*     */       }
/* 218 */       if (!dgscodes2.equals("")) {
/* 219 */         dgscodes2 = dgscodes2.substring(0, dgscodes2.length() - 1);
/* 220 */         String[] dgscodes21 = dgscodes2.split(",");
/* 221 */         dbgform.setStucodes(dgscodes21);
/*     */       }
/*     */     }
/*     */ 
/* 225 */     request.setAttribute("departid", departid);
/* 226 */     request.setAttribute("op", "edit");
/*     */ 
/* 228 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.dabian.DabianshezhieditAction
 * JD-Core Version:    0.5.4
 */