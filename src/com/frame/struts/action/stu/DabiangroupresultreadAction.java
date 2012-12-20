/*     */ package com.frame.struts.action.stu;
/*     */ 
/*     */ import com.entity.basedata.StuList;
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
/*     */ public class DabiangroupresultreadAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  58 */     HttpSession session = request.getSession();
/*  59 */     if (session.getAttribute("stucode") == null) {
/*  60 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  61 */       return mapping.findForward("error");
/*  62 */     }String stucode = session.getAttribute("stucode").toString();
/*     */ 
/*  65 */     StuList stu = new StuList();
/*  66 */     StuListDAO studao = new StuListDAO();
/*  67 */     stu = studao.findById(stucode);
/*  68 */     Integer departid = stu.getDepartid();
/*  69 */     String hql = "";
/*  70 */     Qdao qdao = new Qdao();
/*     */ 
/*  73 */     if (departid.intValue() != 0)
/*     */     {
/*  75 */       ApplyNumGradeDAO adao = new ApplyNumGradeDAO();
/*  76 */       ApplyNumGrade ang = new ApplyNumGrade();
/*  77 */       ang = adao.findById(departid);
/*     */ 
/*  79 */       DabianGroup dbg = new DabianGroup();
/*  80 */       DabianGroupDAO dbgdao = new DabianGroupDAO();
/*  81 */       List grouplist = new LinkedList();
/*  82 */       hql = "from DabianGroup where departid=" + departid + " and gradeid=" + ang.getGradeid();
/*  83 */       grouplist.addAll(qdao.query(hql));
/*  84 */       request.setAttribute("grouplist", grouplist);
/*  85 */       if (grouplist.size() == 0) request.setAttribute("notice", "暂无分组信息");
/*     */ 
/*  87 */       DabianGroupTecDAO dbgtdao = new DabianGroupTecDAO();
/*  88 */       List dbgtlist = dbgtdao.findAll();
/*  89 */       request.setAttribute("dbgtlist", dbgtlist);
/*     */ 
/*  91 */       DabianGroupStuDAO dbgsdao = new DabianGroupStuDAO();
/*  92 */       List dbgslist = dbgsdao.findAll();
/*  93 */       request.setAttribute("dbgslist", dbgslist);
/*     */ 
/*  95 */       TecListDAO tecdao = new TecListDAO();
/*  96 */       List teclist = tecdao.findByCollegeid(stu.getCollegeid());
/*  97 */       StuListDAO studao2 = new StuListDAO();
/*  98 */       List stulist = studao2.findByGradeid(ang.getGradeid());
/*  99 */       request.setAttribute("teclist", teclist);
/* 100 */       request.setAttribute("stulist", stulist);
/*     */     }
/* 102 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.stu.DabiangroupresultreadAction
 * JD-Core Version:    0.5.4
 */