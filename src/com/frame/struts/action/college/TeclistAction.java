/*     */ package com.frame.struts.action.college;
/*     */ 
/*     */ import com.entity.basedata.DepartListDAO;
/*     */ import com.entity.basedata.DepartTecDAO;
/*     */ import com.entity.basedata.TecListDAO;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.apache.struts.action.Action;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionForward;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class TeclistAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  53 */     HttpSession session = request.getSession();
/*  54 */     if (session.getAttribute("adminid") == null) {
/*  55 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  56 */       return mapping.findForward("error");
/*     */     }
/*  58 */     Integer userid = Integer.valueOf(Integer.parseInt(session.getAttribute("adminid").toString()));
/*  59 */     Integer collegeid = Integer.valueOf(Integer.parseInt(session.getAttribute("collegeid").toString()));
/*     */     Integer departid;
/*     */     
/*  63 */     if (request.getParameter("id") == null)
/*  64 */       departid = Integer.valueOf(0);
/*     */     else {
/*  66 */       departid = Integer.valueOf(Integer.parseInt(request.getParameter("id").toString()));
/*     */     }
/*     */ 
/*  70 */     DepartListDAO dao = new DepartListDAO();
/*  71 */     List departlist = dao.findByCollegeid(collegeid);
/*  72 */     request.setAttribute("departlist", departlist);
/*  73 */     request.setAttribute("departid", departid);
/*     */ 
/*  76 */     String op = "ok";
/*     */ 
/*  83 */     request.setAttribute("op", op);
/*     */ 
/*  87 */     TecListDAO cdao = new TecListDAO();
/*  88 */     List teclist = cdao.findByCollegeid(collegeid);
/*  89 */     DepartTecDAO dtdao = new DepartTecDAO();
/*  90 */     List dtlist = null;
/*  91 */     if (departid.intValue() == 0)
/*  92 */       dtlist = dtdao.findAll();
/*     */     else {
/*  94 */       dtlist = dtdao.findByDepartid(departid);
/*     */     }
/*  96 */     request.setAttribute("dtlist", dtlist);
/*  97 */     request.setAttribute("teclist", teclist);
/*     */ 
/* 103 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.TeclistAction
 * JD-Core Version:    0.5.4
 */