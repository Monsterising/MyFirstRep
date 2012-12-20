/*     */ package com.frame.struts.action.stu;
/*     */ 
/*     */ import com.entity.basedata.DepartTec;
/*     */ import com.entity.basedata.DepartTecDAO;
/*     */ import com.entity.basedata.StuList;
/*     */ import com.entity.wish.ApplyTec;
/*     */ import com.entity.wish.ApplyTecDAO;
/*     */ import com.entity.wish.ApplyTypeDAO;
/*     */ import com.entity.wish.StuWishDAO;
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
/*     */ public class KetiliststuAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  55 */     HttpSession session = request.getSession();
/*  56 */     if (session.getAttribute("stucode") == null) {
/*  57 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  58 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  61 */     String stucode = (String)session.getAttribute("stucode");
/*  62 */     System.out.println(stucode + " 查看可选择课题！");
/*     */ 
/*  64 */     StuList stu = (StuList)session.getAttribute("StuList");
/*  65 */     Integer collegeid = stu.getCollegeid();
/*  66 */     Integer departid = stu.getDepartid();
/*  67 */     Integer gradeid = stu.getGradeid();
/*     */ 
/*  69 */     ApplyTec applytec = new ApplyTec();
/*  70 */     ApplyTecDAO atdao = new ApplyTecDAO();
/*  71 */     Qdao qdao = new Qdao();
/*  72 */     List applylist = new LinkedList();
/*  73 */     String hql = "";
/*  74 */     String teccode = "";
/*  75 */     if (request.getParameter("t") != null) {
/*  76 */       teccode = request.getParameter("t");
/*     */     }
/*  78 */     if ((teccode.equals("")) || (teccode.equals("0")))
/*  79 */       hql = "from ApplyTec where collegeid=" + collegeid + " and departid=" + departid + " and gradeid=" + gradeid + " and advice1='通过' and advice2='通过' ";
/*     */     else {
/*  81 */       hql = "from ApplyTec where collegeid=" + collegeid + " and departid=" + departid + " and gradeid=" + gradeid + " and teccode='" + teccode + "' and advice1='通过' and advice2='通过'";
/*     */     }
/*  83 */     applylist.addAll(qdao.query(hql));
/*  84 */     request.setAttribute("applylist", applylist);
/*     */ 
/*  87 */     DepartTecDAO dtdao = new DepartTecDAO();
/*  88 */     List dtlist = dtdao.findByDepartid(departid);
/*  89 */     List teclist = new LinkedList();
/*  90 */     String teccodes = "";
/*  91 */     for (int i = 0; i < dtlist.size(); ++i) {
/*  92 */       teccodes = teccodes + "'" + ((DepartTec)dtlist.get(i)).getTeccode() + "',";
/*     */     }
/*  94 */     teccodes = teccodes.substring(0, teccodes.length() - 1);
/*  95 */     hql = "from TecList where teccode in(" + teccodes + ")";
/*     */ 
/*  97 */     teclist.addAll(qdao.query(hql));
/*     */ 
/*  99 */     request.setAttribute("teccode", teccode);
/* 100 */     request.setAttribute("teclist", teclist);
/*     */ 
/* 104 */     ApplyTypeDAO typedao = new ApplyTypeDAO();
/* 105 */     List applytypelist = typedao.findAll();
/* 106 */     request.setAttribute("applytypelist", applytypelist);
/*     */ 
/* 111 */     StuWishDAO wdao = new StuWishDAO();
/* 112 */     List wishlist = wdao.findByStucode(stucode);
/* 113 */     request.setAttribute("wishlist", wishlist);
/*     */ 
/* 115 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.stu.KetiliststuAction
 * JD-Core Version:    0.5.4
 */