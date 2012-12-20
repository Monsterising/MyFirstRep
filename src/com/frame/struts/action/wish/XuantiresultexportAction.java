/*     */ package com.frame.struts.action.wish;
/*     */ 
/*     */ import com.entity.basedata.DepartList;
/*     */ import com.entity.basedata.DepartListDAO;
/*     */ import com.entity.basedata.GradeList;
/*     */ import com.entity.basedata.GradeListDAO;
/*     */ import com.entity.basedata.StuList;
/*     */ import com.entity.basedata.StuListDAO;
/*     */ import com.entity.basedata.TecList;
/*     */ import com.entity.basedata.TecListDAO;
/*     */ import com.entity.wish.ApplyNumGrade;
/*     */ import com.entity.wish.ApplyNumGradeDAO;
/*     */ import com.entity.wish.ApplyTec;
/*     */ import com.entity.wish.ApplyTecDAO;
/*     */ import com.entity.wish.XuantiDAO;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
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
/*     */ public class XuantiresultexportAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  63 */     HttpSession session = request.getSession();
/*  64 */     if ((session.getAttribute("adminid") == null) && (session.getAttribute("userrole") == null))
/*     */     {
/*  66 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  67 */       return mapping.findForward("error");
/*     */     }
/*  69 */     Integer collegeid = Integer.valueOf(Integer.parseInt(session.getAttribute("collegeid").toString()));
/*     */ 
/*  75 */     String departidstring = request.getParameter("departid");
/*  76 */     Integer departid = Integer.valueOf(0);
/*  77 */     if (departidstring != null) {
/*  78 */       departid = Integer.valueOf(Integer.parseInt(departidstring));
/*     */     }
/*  80 */     if (request.getAttribute("departid") != null) {
/*  81 */       departid = Integer.valueOf(Integer.parseInt(request.getAttribute("departid").toString()));
/*     */     }
/*     */ 
/*  84 */     if (departid.intValue() != 0) {
/*  85 */       request.setAttribute("departid", departid);
/*  86 */       Qdao qdao = new Qdao();
/*  87 */       ApplyTec apply = new ApplyTec();
/*  88 */       ApplyTecDAO apdao = new ApplyTecDAO();
/*  89 */       List applylist = new LinkedList();
/*  90 */       ApplyNumGrade ang = new ApplyNumGrade();
/*  91 */       ApplyNumGradeDAO adao = new ApplyNumGradeDAO();
/*  92 */       if (adao.findById(departid) == null) {
/*  93 */         request.setAttribute("notice", "该专业没有设置有效年级！<a href='javascript:history.go(-1);'>返回</a>");
/*  94 */         return mapping.findForward("error");
/*     */       }
/*  96 */       ang = adao.findById(departid);
/*  97 */       GradeList grade = new GradeList();
/*  98 */       GradeListDAO gdao = new GradeListDAO();
/*  99 */       if (gdao.findById(ang.getGradeid()) == null) {
/* 100 */         request.setAttribute("notice", "该专业没有设置有效年级！<a href='javascript:history.go(-1);'>返回</a>");
/* 101 */         return mapping.findForward("error");
/*     */       }
/* 103 */       grade = gdao.findById(ang.getGradeid());
/* 104 */       request.setAttribute("gradename", grade.getGradename());
/*     */ 
/* 106 */       String hql = "from ApplyTec where departid=" + departid + " and gradeid=" + grade.getGradeid();
/* 107 */       applylist.addAll(qdao.query(hql));
/* 108 */       request.setAttribute("applylist", applylist);
/*     */ 
/* 110 */       StuListDAO sdao = new StuListDAO();
/* 111 */       List stulist = new LinkedList();
/* 112 */       hql = "from StuList where departid=" + departid + " and gradeid=" + grade.getGradeid();
/* 113 */       stulist.addAll(qdao.query(hql));
/* 114 */       request.setAttribute("stulist", stulist);
/*     */ 
/* 116 */       TecListDAO tdao = new TecListDAO();
/* 117 */       List teclist = new LinkedList();
/* 118 */       hql = "from TecList where collegeid=" + collegeid;
/* 119 */       teclist.addAll(qdao.query(hql));
/* 120 */       request.setAttribute("teclist", teclist);
/*     */ 
/* 122 */       List tecexlist = new LinkedList();
/* 123 */       String teccodes = "";
/* 124 */       for (int i = 0; i < teclist.size(); ++i) {
/* 125 */         teccodes = teccodes + "'" + ((TecList)teclist.get(i)).getTeccode() + "',";
/*     */       }
/* 127 */       teccodes = teccodes.substring(0, teccodes.length() - 1);
/* 128 */       hql = "from TecExtra where teccode in(" + teccodes + ")";
/* 129 */       tecexlist.addAll(qdao.query(hql));
/* 130 */       request.setAttribute("tecexlist", tecexlist);
/*     */ 
/* 133 */       if (stulist.size() == 0) {
/* 134 */         request.setAttribute("notice", "该专业尚无学生");
/* 135 */         return mapping.findForward("error");
/*     */       }
/* 137 */       String stucodes = "";
/* 138 */       for (int i = 0; i < stulist.size(); ++i) {
/* 139 */         stucodes = stucodes + "'" + ((StuList)stulist.get(i)).getStucode() + "',";
/*     */       }
/* 141 */       if (!stucodes.equals("")) {
/* 142 */         stucodes = stucodes.substring(0, stucodes.length() - 1);
/*     */       }
/* 144 */       XuantiDAO xdao = new XuantiDAO();
/* 145 */       List xlist = new LinkedList();
/* 146 */       hql = "from Xuanti where stucode in(" + stucodes + ")";
/* 147 */       xlist.addAll(qdao.query(hql));
/* 148 */       request.setAttribute("xlist", xlist);
/*     */ 
/* 151 */       List departlist = new LinkedList();
/* 152 */       hql = "from DepartList where collegeid=" + collegeid;
/* 153 */       departlist.addAll(qdao.query(hql));
/*     */ 
/* 155 */       List classlist = new LinkedList();
/* 156 */       hql = "from ClassList where collegeid=" + collegeid;
/* 157 */       classlist.addAll(qdao.query(hql));
/* 158 */       request.setAttribute("departlist", departlist);
/* 159 */       request.setAttribute("classlist", classlist);
/*     */ 
/* 162 */       DepartList depart = new DepartList();
/* 163 */       DepartListDAO departdao = new DepartListDAO();
/* 164 */       depart = departdao.findById(departid);
/* 165 */       request.setAttribute("departname", depart.getDepartname());
/* 166 */       Date date = new Date();
/* 167 */       SimpleDateFormat year = new SimpleDateFormat("yyyy");
/* 168 */       SimpleDateFormat MM = new SimpleDateFormat("MM");
/* 169 */       Integer y2 = Integer.valueOf(Integer.parseInt(year.format(date).toString()));
/* 170 */       if (Integer.parseInt(MM.format(date).toString()) > 8) y2 = Integer.valueOf(y2.intValue() + 1);
/* 171 */       request.setAttribute("y2", y2);
/*     */     }
/*     */ 
/* 175 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.wish.XuantiresultexportAction
 * JD-Core Version:    0.5.4
 */