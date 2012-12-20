/*     */ package com.frame.struts.action.dabian;
/*     */ 
/*     */ import com.entity.basedata.DepartTec;
/*     */ import com.entity.basedata.DepartTecDAO;
/*     */ import com.entity.basedata.GradeList;
/*     */ import com.entity.basedata.GradeListDAO;
/*     */ import com.entity.basedata.TecListDAO;
/*     */ import com.entity.dabian.DabianGroup;
/*     */ import com.entity.dabian.DabianGroupDAO;
/*     */ import com.entity.wish.ApplyNumGrade;
/*     */ import com.entity.wish.ApplyNumGradeDAO;
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
/*     */ public class DabianshezhiAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  58 */     HttpSession session = request.getSession();
/*  59 */     if (session.getAttribute("teccode") == null) {
/*  60 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  61 */       return mapping.findForward("error");
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
/*  82 */     if (departids.equals("")) {
/*  83 */       request.setAttribute("notice", "您没有该项权限");
/*  84 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  87 */     String departidstring = request.getParameter("departid");
/*  88 */     Integer departid = Integer.valueOf(0);
/*  89 */     if ((departidstring != null) && (!departidstring.equals(""))) {
/*  90 */       departid = Integer.valueOf(Integer.parseInt(departidstring));
/*     */     }
/*  92 */     if (request.getAttribute("departid") != null)
/*     */     {
/*  94 */       departid = Integer.valueOf(Integer.parseInt(request.getAttribute("departid").toString()));
/*     */     }
/*     */ 
/*  98 */     if (departid.intValue() != 0) {
/*  99 */       request.setAttribute("departid", departid);
/* 100 */       Qdao qdao = new Qdao();
/* 101 */       DabianGroup group = new DabianGroup();
/* 102 */       DabianGroupDAO dgdao = new DabianGroupDAO();
/* 103 */       List grouplist = new LinkedList();
/* 104 */       ApplyNumGrade ang = new ApplyNumGrade();
/* 105 */       ApplyNumGradeDAO adao = new ApplyNumGradeDAO();
/* 106 */       ang = adao.findById(departid);
/* 107 */       GradeList grade = new GradeList();
/* 108 */       GradeListDAO gdao = new GradeListDAO();
/* 109 */       grade = gdao.findById(ang.getGradeid());
/* 110 */       request.setAttribute("gradename", grade.getGradename());
/* 111 */       request.setAttribute("gradeid", grade.getGradeid());
/* 112 */       String hql = "";
/* 113 */       hql = "from DabianGroup where departid=" + departid + " and gradeid=" + grade.getGradeid();
/* 114 */       grouplist.addAll(qdao.query(hql));
/*     */ 
/* 117 */       TecListDAO tdao = new TecListDAO();
/* 118 */       Integer collegeid = (Integer)session.getAttribute("collegeid");
/* 119 */       List teclist = tdao.findByCollegeid(collegeid);
/* 120 */       request.setAttribute("teclist", teclist);
/* 121 */       request.setAttribute("grouplist", grouplist);
/*     */     }
/*     */ 
/* 124 */     if (!departids.equals(""))
/*     */     {
/* 126 */       departids = departids.substring(0, departids.length() - 1);
/* 127 */       String hql = "from DepartList where departid in (" + departids + ")";
/* 128 */       Qdao qdao = new Qdao();
/*     */ 
/* 130 */       departlist.addAll(qdao.query(hql));
/* 131 */       request.setAttribute("departlist", departlist);
/*     */ 
/* 133 */       request.setAttribute("op", "ok");
/* 134 */       return mapping.findForward("display");
/*     */     }
/* 136 */     request.setAttribute("notice", "您暂时没有该项权限");
/* 137 */     return mapping.findForward("error");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.dabian.DabianshezhiAction
 * JD-Core Version:    0.5.4
 */