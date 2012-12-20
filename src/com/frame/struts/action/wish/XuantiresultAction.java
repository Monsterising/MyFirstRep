/*     */ package com.frame.struts.action.wish;
/*     */ 
/*     */ import com.entity.basedata.DepartListDAO;
/*     */ import com.entity.basedata.DepartTec;
/*     */ import com.entity.basedata.DepartTecDAO;
/*     */ import com.entity.basedata.GradeList;
/*     */ import com.entity.basedata.GradeListDAO;
/*     */ import com.entity.basedata.StuList;
/*     */ import com.entity.basedata.StuListDAO;
/*     */ import com.entity.basedata.TecListDAO;
/*     */ import com.entity.wish.ApplyNumGrade;
/*     */ import com.entity.wish.ApplyNumGradeDAO;
/*     */ import com.entity.wish.ApplyTec;
/*     */ import com.entity.wish.ApplyTecDAO;
/*     */ import com.entity.wish.XuantiDAO;
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
/*     */ public class XuantiresultAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  62 */     HttpSession session = request.getSession();
/*  63 */     if ((session.getAttribute("adminid") == null) && (session.getAttribute("teccode") == null)) {
/*  64 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  65 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  69 */     String teccode = "";
/*  70 */     List departlist = new LinkedList();
/*  71 */     if (session.getAttribute("teccode") != null)
/*     */     {
/*  73 */       teccode = (String)session.getAttribute("teccode");
/*  74 */       DepartTec departtec = new DepartTec();
/*  75 */       DepartTecDAO dao = new DepartTecDAO();
/*  76 */       List departteclist = dao.findByTeccode(teccode);
/*     */ 
/*  78 */       String departids = "";
/*  79 */       for (int i = 0; i < departteclist.size(); ++i) {
/*  80 */         if (((DepartTec)departteclist.get(i)).getTecrole().intValue() != 2)
/*     */           continue;
/*  82 */         session.setAttribute("userrole", "2");
/*  83 */         session.setAttribute("usershenfen", "专业负责人");
/*  84 */         departids = departids + ((DepartTec)departteclist.get(i)).getDepartid() + ",";
/*     */       }
/*     */ 
/*  89 */       if (departids.equals("")) {
/*  90 */         request.setAttribute("notice", "您没有该项权限");
/*  91 */         return mapping.findForward("error");
/*     */       }
/*  93 */       departids = departids.substring(0, departids.length() - 1);
/*  94 */       String hql = "from DepartList where departid in (" + departids + ")";
/*  95 */       Qdao qdao = new Qdao();
/*  96 */       System.out.println("hql=" + hql);
/*  97 */       departlist.addAll(qdao.query(hql));
/*     */     }
/*     */ 
/* 101 */     Integer collegeid = Integer.valueOf(Integer.parseInt(session.getAttribute("collegeid").toString()));
/* 102 */     if (session.getAttribute("adminid") != null)
/*     */     {
/* 108 */       DepartListDAO ddao = new DepartListDAO();
/* 109 */       departlist.addAll(ddao.findByCollegeid(collegeid));
/*     */     }
/* 111 */     request.setAttribute("departlist", departlist);
/*     */ 
/* 116 */     String departidstring = request.getParameter("departid");
/* 117 */     Integer departid = Integer.valueOf(0);
/* 118 */     if (departidstring != null) {
/* 119 */       departid = Integer.valueOf(Integer.parseInt(departidstring));
/*     */     }
/* 121 */     if (request.getAttribute("departid") != null) {
/* 122 */       departid = Integer.valueOf(Integer.parseInt(request.getAttribute("departid").toString()));
/*     */     }
/*     */ 
/* 125 */     if (departid.intValue() != 0) {
/* 126 */       request.setAttribute("departid", departid);
/* 127 */       Qdao qdao = new Qdao();
/* 128 */       ApplyTec apply = new ApplyTec();
/* 129 */       ApplyTecDAO apdao = new ApplyTecDAO();
/* 130 */       List applylist = new LinkedList();
/* 131 */       ApplyNumGrade ang = new ApplyNumGrade();
/* 132 */       ApplyNumGradeDAO adao = new ApplyNumGradeDAO();
/* 133 */       if (adao.findById(departid) == null) {
/* 134 */         request.setAttribute("notice", "该专业没有设置有效年级！<a href='javascript:history.go(-1);'>返回</a>");
/* 135 */         return mapping.findForward("error");
/*     */       }
/* 137 */       ang = adao.findById(departid);
/* 138 */       GradeList grade = new GradeList();
/* 139 */       GradeListDAO gdao = new GradeListDAO();
/* 140 */       if (gdao.findById(ang.getGradeid()) == null) {
/* 141 */         request.setAttribute("notice", "该专业没有设置有效年级！<a href='javascript:history.go(-1);'>返回</a>");
/* 142 */         return mapping.findForward("error");
/*     */       }
/* 144 */       grade = gdao.findById(ang.getGradeid());
/* 145 */       request.setAttribute("gradename", grade.getGradename());
/*     */ 
/* 147 */       String hql = "from ApplyTec where departid=" + departid + " and gradeid=" + grade.getGradeid();
/* 148 */       applylist.addAll(qdao.query(hql));
/* 149 */       request.setAttribute("applylist", applylist);
/*     */ 
/* 151 */       StuListDAO sdao = new StuListDAO();
/* 152 */       List stulist = new LinkedList();
/* 153 */       hql = "from StuList where departid=" + departid + " and gradeid=" + grade.getGradeid();
/* 154 */       stulist.addAll(qdao.query(hql));
/* 155 */       request.setAttribute("stulist", stulist);
/*     */ 
/* 157 */       TecListDAO tdao = new TecListDAO();
/* 158 */       List teclist = new LinkedList();
/* 159 */       hql = "from TecList where collegeid=" + collegeid;
/* 160 */       teclist.addAll(qdao.query(hql));
/* 161 */       request.setAttribute("teclist", teclist);
/*     */ 
/* 163 */       if (stulist.size() == 0) {
/* 164 */         request.setAttribute("notice", "该专业尚无学生");
/* 165 */         return mapping.findForward("error");
/*     */       }
/* 167 */       String stucodes = "";
/* 168 */       for (int i = 0; i < stulist.size(); ++i) {
/* 169 */         stucodes = stucodes + "'" + ((StuList)stulist.get(i)).getStucode() + "',";
/*     */       }
/* 171 */       if (!stucodes.equals("")) {
/* 172 */         stucodes = stucodes.substring(0, stucodes.length() - 1);
/*     */       }
/* 174 */       XuantiDAO xdao = new XuantiDAO();
/* 175 */       List xlist = new LinkedList();
/* 176 */       hql = "from Xuanti where stucode in(" + stucodes + ")";
/* 177 */       xlist.addAll(qdao.query(hql));
/* 178 */       request.setAttribute("xlist", xlist);
/*     */ 
/* 183 */       String hql3 = "";
/* 184 */       hql3 = "select count(*) from StuList where gradeid=" + ang.getGradeid();
/* 185 */       request.setAttribute("stusum", qdao.count(hql3));
/*     */ 
/* 187 */       String hql2 = "select count(*) from ApplyTec where departid=" + departid + " and gradeid=" + ang.getGradeid() + 
/* 188 */         " and advice1='通过' and advice2='通过'";
/* 189 */       request.setAttribute("countcollege", qdao.count(hql2));
/*     */ 
/* 191 */       String hql4 = "";
/* 192 */       stucodes = "";
/*     */ 
/* 194 */       List stulist0 = new LinkedList();
/* 195 */       hql = "from StuList where departid=" + departid + " and gradeid=" + ang.getGradeid();
/* 196 */       stulist0.addAll(qdao.query(hql));
/* 197 */       if (stulist0.size() == 0) {
/* 198 */         request.setAttribute("notice", "该专业尚无学生");
/* 199 */         return mapping.findForward("error");
/*     */       }
/* 201 */       for (int i = 0; i < stulist0.size(); ++i) {
/* 202 */         stucodes = stucodes + "'" + ((StuList)stulist0.get(i)).getStucode() + "',";
/*     */       }
/* 204 */       if (!stucodes.equals("")) {
/* 205 */         stucodes = stucodes.substring(0, stucodes.length() - 1);
/*     */       }
/* 207 */       hql4 = "select count(*) from Xuanti where stucode in(" + stucodes + ")";
/* 208 */       request.setAttribute("countwish", qdao.count(hql4));
/*     */     }
/*     */     else
/*     */     {
/* 213 */       request.setAttribute("departid", "0");
/*     */     }
/* 215 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.wish.XuantiresultAction
 * JD-Core Version:    0.5.4
 */