/*     */ package com.frame.struts.action.pingyue;
/*     */ 
/*     */ import com.entity.basedata.DepartTec;
/*     */ import com.entity.basedata.DepartTecDAO;
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
/*     */ public class PingyuviewerlistAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  53 */     HttpSession session = request.getSession();
/*  54 */     if (session.getAttribute("teccode") == null) {
/*  55 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  56 */       return mapping.findForward("error");
/*     */     }
/*  58 */     String teccode = (String)session.getAttribute("teccode");
/*     */ 
/*  60 */     String departidstring = request.getParameter("departid");
/*  61 */     Integer departid = Integer.valueOf(0);
/*  62 */     if ((departidstring != null) && (!departidstring.equals(""))) {
/*  63 */       departid = Integer.valueOf(Integer.parseInt(departidstring));
/*     */     }
/*  65 */     if (request.getAttribute("departid") != null) {
/*  66 */       departid = Integer.valueOf(Integer.parseInt(request.getAttribute("departid").toString()));
/*     */     }
/*     */ 
/*  70 */     DepartTec departtec = new DepartTec();
/*  71 */     DepartTecDAO dao = new DepartTecDAO();
/*  72 */     List departteclist = dao.findByTeccode(teccode);
/*     */ 
/*  74 */     List departlist = new LinkedList();
/*  75 */     String departids = "";
/*  76 */     for (int i = 0; i < departteclist.size(); ++i) {
/*  77 */       if ((((DepartTec)departteclist.get(i)).getTecrole().intValue() != 2) && (((DepartTec)departteclist.get(i)).getTecrole().intValue() != 1))
/*     */         continue;
/*  79 */       departids = departids + ((DepartTec)departteclist.get(i)).getDepartid() + ",";
/*     */     }
/*     */ 
/*  83 */     if (!departids.equals(""))
/*     */     {
/*  85 */       departids = departids.substring(0, departids.length() - 1);
/*  86 */       String hql = "from DepartList where departid in (" + departids + ")";
/*  87 */       Qdao qdao = new Qdao();
/*  88 */       departlist.addAll(qdao.query(hql));
/*  89 */       request.setAttribute("departlist", departlist);
/*  90 */       if (departid.intValue() != 0) {
/*  91 */         ApplyNumGrade ang = new ApplyNumGrade();
/*  92 */         ApplyNumGradeDAO adao = new ApplyNumGradeDAO();
/*  93 */         ang = adao.findById(departid);
/*     */ 
/*  95 */         hql = "from PingyuGroup where gradeid=" + ang.getGradeid() + " and departid=" + departid + " and teccode='" + teccode + "'";
/*  96 */         List grouplist = new LinkedList();
/*  97 */         grouplist.addAll(qdao.query(hql));
/*  98 */         request.setAttribute("grouplist", grouplist);
/*  99 */         request.setAttribute("departid", departid);
/*     */ 
/* 101 */         hql = "from StuList where departid=" + departid + " and gradeid=" + ang.getGradeid();
/* 102 */         List stulist = new LinkedList();
/* 103 */         stulist.addAll(qdao.query(hql));
/* 104 */         request.setAttribute("stulist", stulist);
/* 105 */         request.setAttribute("gradeid", ang.getGradeid());
/*     */       }
/*     */ 
/* 108 */       return mapping.findForward("display");
/*     */     }
/* 110 */     request.setAttribute("notice", "你还没有分配专业！");
/* 111 */     return mapping.findForward("error");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.pingyue.PingyuviewerlistAction
 * JD-Core Version:    0.5.4
 */