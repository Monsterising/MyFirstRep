/*     */ package com.frame.struts.action.dabian;
/*     */ 
/*     */ import com.entity.basedata.DepartTec;
/*     */ import com.entity.basedata.DepartTecDAO;
/*     */ import com.entity.basedata.StuListDAO;
/*     */ import com.entity.basedata.TecListDAO;
/*     */ import com.entity.dabian.DabianGroup;
/*     */ import com.entity.dabian.DabianGroupDAO;
/*     */ import com.entity.dabian.DabianGroupStuDAO;
/*     */ import com.entity.dabian.DabianGroupTecDAO;
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
/*     */ public class DabiangroupresultAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  61 */     HttpSession session = request.getSession();
/*  62 */     if (session.getAttribute("teccode") == null) {
/*  63 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  64 */       return mapping.findForward("error");
/*     */     }
/*  66 */     String teccode = session.getAttribute("teccode").toString();
/*  67 */     Integer collegeid = Integer.valueOf(Integer.parseInt(session.getAttribute("collegeid").toString()));
/*     */ 
/*  69 */     String departidstring = request.getParameter("departid");
/*  70 */     Integer departid = Integer.valueOf(0);
/*  71 */     if (departidstring != null) {
/*  72 */       departid = Integer.valueOf(Integer.parseInt(departidstring));
/*     */     }
/*     */ 
/*  75 */     DepartTec departtec = new DepartTec();
/*  76 */     DepartTecDAO dao = new DepartTecDAO();
/*  77 */     List departteclist = dao.findByTeccode(teccode);
/*     */ 
/*  79 */     List departlist = new LinkedList();
/*  80 */     String departids = "";
/*  81 */     for (int i = 0; i < departteclist.size(); ++i) {
/*  82 */       if ((((DepartTec)departteclist.get(i)).getTecrole().intValue() != 2) && (((DepartTec)departteclist.get(i)).getTecrole().intValue() != 1))
/*     */         continue;
/*  84 */       departids = departids + ((DepartTec)departteclist.get(i)).getDepartid() + ",";
/*     */     }
/*     */ 
/*  88 */     if (!departids.equals(""))
/*     */     {
/*  90 */       departids = departids.substring(0, departids.length() - 1);
/*  91 */       String hql = "from DepartList where departid in (" + departids + ")";
/*  92 */       Qdao qdao = new Qdao();
/*  93 */       departlist.addAll(qdao.query(hql));
/*  94 */       request.setAttribute("departlist", departlist);
/*  95 */       if (departid.intValue() != 0)
/*     */       {
/*  97 */         ApplyNumGradeDAO adao = new ApplyNumGradeDAO();
/*  98 */         ApplyNumGrade ang = new ApplyNumGrade();
/*  99 */         ang = adao.findById(departid);
/*     */ 
/* 101 */         DabianGroup dbg = new DabianGroup();
/* 102 */         DabianGroupDAO dbgdao = new DabianGroupDAO();
/* 103 */         List grouplist = new LinkedList();
/* 104 */         hql = "from DabianGroup where departid=" + departid + " and gradeid=" + ang.getGradeid();
/* 105 */         grouplist.addAll(qdao.query(hql));
/* 106 */         request.setAttribute("grouplist", grouplist);
/*     */ 
/* 108 */         DabianGroupTecDAO dbgtdao = new DabianGroupTecDAO();
/* 109 */         List dbgtlist = dbgtdao.findAll();
/* 110 */         request.setAttribute("dbgtlist", dbgtlist);
/*     */ 
/* 112 */         DabianGroupStuDAO dbgsdao = new DabianGroupStuDAO();
/* 113 */         List dbgslist = dbgsdao.findAll();
/* 114 */         request.setAttribute("dbgslist", dbgslist);
/*     */ 
/* 116 */         TecListDAO tecdao = new TecListDAO();
/* 117 */         List teclist = tecdao.findByCollegeid(collegeid);
/* 118 */         StuListDAO studao = new StuListDAO();
/* 119 */         List stulist = studao.findByGradeid(ang.getGradeid());
/* 120 */         request.setAttribute("teclist", teclist);
/* 121 */         request.setAttribute("stulist", stulist);
/*     */       }
/*     */     }
/* 124 */     request.setAttribute("departid", departid);
/* 125 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.dabian.DabiangroupresultAction
 * JD-Core Version:    0.5.4
 */