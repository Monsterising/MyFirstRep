/*     */ package com.frame.struts.action.pingyue;
/*     */ 
/*     */ import com.entity.basedata.DepartTec;
/*     */ import com.entity.basedata.DepartTecDAO;
/*     */ import com.entity.basedata.GradeList;
/*     */ import com.entity.basedata.GradeListDAO;
/*     */ import com.entity.wish.ApplyNumGrade;
/*     */ import com.entity.wish.ApplyNumGradeDAO;
/*     */ import com.entity.wish.ApplyTec;
/*     */ import com.entity.wish.ApplyTecDAO;
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
/*     */ public class PingyueshezhiAction extends Action
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
/*  99 */       Qdao qdao = new Qdao();
/* 100 */       ApplyTec apply = new ApplyTec();
/* 101 */       ApplyTecDAO apdao = new ApplyTecDAO();
/*     */ 
/* 103 */       List applylist = new LinkedList();
/* 104 */       ApplyNumGrade ang = new ApplyNumGrade();
/* 105 */       ApplyNumGradeDAO adao = new ApplyNumGradeDAO();
/* 106 */       ang = adao.findById(departid);
/* 107 */       GradeList grade = new GradeList();
/* 108 */       GradeListDAO gdao = new GradeListDAO();
/* 109 */       grade = gdao.findById(ang.getGradeid());
/* 110 */       request.setAttribute("gradename", grade.getGradename());
/* 111 */       String hql = "from ApplyTec where departid=" + departid + " and gradeid=" + grade.getGradeid();
/* 112 */       applylist.addAll(qdao.query(hql));
/* 113 */       request.setAttribute("applylist", applylist);
/*     */ 
/* 115 */       String teccodes = "";
/* 116 */       String atids = "";
/* 117 */       for (int i = 0; i < applylist.size(); ++i) {
/* 118 */         teccodes = teccodes + "'" + ((ApplyTec)applylist.get(i)).getTeccode() + "',";
/* 119 */         atids = atids + ((ApplyTec)applylist.get(i)).getAtid() + ",";
/*     */       }
/* 121 */       if (!teccodes.equals("")) teccodes = teccodes.substring(0, teccodes.length() - 1);
/* 122 */       if (!atids.equals("")) atids = atids.substring(0, atids.length() - 1);
/*     */ 
/* 124 */       List teclist = new LinkedList();
/* 125 */       if (teccodes.equals("")) {
/* 126 */         request.setAttribute("notice", "该专业尚无毕业课题！<br/><br/>");
/* 127 */         return mapping.findForward("error");
/*     */       }
/* 129 */       hql = "from TecList where teccode in (" + teccodes + ")";
/* 130 */       teclist.addAll(qdao.query(hql));
/* 131 */       request.setAttribute("teclist", teclist);
/* 132 */       request.setAttribute("departid", departid);
/* 133 */       request.setAttribute("atids", atids);
/* 134 */       request.setAttribute("gradeid", grade.getGradeid());
/*     */     }
/*     */ 
/* 141 */     if (!departids.equals(""))
/*     */     {
/* 143 */       departids = departids.substring(0, departids.length() - 1);
/* 144 */       String hql = "from DepartList where departid in (" + departids + ")";
/* 145 */       Qdao qdao = new Qdao();
/* 146 */       System.out.println("hql=" + hql);
/* 147 */       departlist.addAll(qdao.query(hql));
/* 148 */       request.setAttribute("departlist", departlist);
/*     */ 
/* 150 */       request.setAttribute("op", "ok");
/* 151 */       return mapping.findForward("display");
/*     */     }
/* 153 */     request.setAttribute("notice", "您暂时没有该项权限");
/* 154 */     return mapping.findForward("error");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.pingyue.PingyueshezhiAction
 * JD-Core Version:    0.5.4
 */