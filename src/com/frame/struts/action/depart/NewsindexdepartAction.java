/*     */ package com.frame.struts.action.depart;
/*     */ 
/*     */ import com.entity.basedata.DepartTec;
/*     */ import com.entity.basedata.DepartTecDAO;
/*     */ import java.text.ParseException;
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
/*     */ public class NewsindexdepartAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws ParseException
/*     */   {
/*  53 */     HttpSession session = request.getSession();
/*  54 */     if (session.getAttribute("teccode") == null) {
/*  55 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  56 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  60 */     String teccode = (String)session.getAttribute("teccode");
/*  61 */     DepartTecDAO dao = new DepartTecDAO();
/*  62 */     List departteclist = dao.findByTeccode(teccode);
/*     */ 
/*  64 */     String departids = "";
/*  65 */     String departids2 = "";
/*  66 */     List newslist = new LinkedList();
/*  67 */     List departlist = new LinkedList();
/*  68 */     List departlist2 = new LinkedList();
/*  69 */     for (int i = 0; i < departteclist.size(); ++i) {
/*  70 */       departids = departids + ((DepartTec)departteclist.get(i)).getDepartid() + ",";
/*  71 */       if (((DepartTec)departteclist.get(i)).getTecrole().intValue() == 2) {
/*  72 */         departids2 = departids2 + ((DepartTec)departteclist.get(i)).getDepartid() + ",";
/*     */       }
/*     */     }
/*  75 */     Qdao qdao = new Qdao();
/*  76 */     if (!departids.equals(""))
/*     */     {
/*  78 */       departids = departids + "0";
/*     */ 
/*  81 */       String hql = "from News where departid in (" + departids + ") order by newsid desc";
/*     */ 
/*  84 */       newslist.addAll(qdao.query(hql));
/*  85 */       request.setAttribute("newslist", newslist);
/*     */ 
/*  87 */       hql = "from DepartList where departid in(" + departids + ")";
/*  88 */       departlist.addAll(qdao.query(hql));
/*  89 */       request.setAttribute("departlist", departlist);
/*     */     }
/*     */ 
/*  92 */     if (!departids2.equals("")) {
/*  93 */       departids2 = departids2.substring(0, departids2.length() - 1);
/*  94 */       String hql = "";
/*  95 */       hql = "from DepartList where departid in(" + departids2 + ")";
/*  96 */       departlist2.addAll(qdao.query(hql));
/*  97 */       request.setAttribute("departlist2", departlist2);
/*     */     }
/*     */ 
/* 100 */     request.setAttribute("ia", Integer.valueOf(7));
/* 101 */     request.setAttribute("ib", Integer.valueOf(7));
/* 102 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.NewsindexdepartAction
 * JD-Core Version:    0.5.4
 */