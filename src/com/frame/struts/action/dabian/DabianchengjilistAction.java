/*     */ package com.frame.struts.action.dabian;
/*     */ 
/*     */ import com.entity.dabian.DabianGroup;
/*     */ import com.entity.dabian.DabianGroupDAO;
/*     */ import com.entity.dabian.DabianGroupStu;
/*     */ import com.entity.dabian.DabianGroupStuDAO;
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
/*     */ public class DabianchengjilistAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  63 */     HttpSession session = request.getSession();
/*  64 */     if (session.getAttribute("teccode") == null) {
/*  65 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  66 */       return mapping.findForward("error");
/*     */     }
/*  68 */     session.setAttribute("type", "");
/*     */ 
/*  70 */     String teccode = (String)session.getAttribute("teccode");
/*  71 */     DabianGroup group = new DabianGroup();
/*  72 */     DabianGroupDAO gdao = new DabianGroupDAO();
/*  73 */     List leaderlist = gdao.findByLeader(teccode);
/*     */ 
/*  81 */     if (leaderlist == null) {
/*  82 */       request.setAttribute("notice", "本项提供给答辩组长评分，您没有该项权限！");
/*  83 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  86 */     String dbgidstring = request.getParameter("dbgid");
/*  87 */     Integer dbgid = Integer.valueOf(0);
/*  88 */     if ((dbgidstring != null) && (!dbgidstring.equals(""))) {
/*  89 */       dbgid = Integer.valueOf(Integer.parseInt(dbgidstring));
/*     */     }
/*  91 */     if (request.getAttribute("dbgid") != null)
/*     */     {
/*  93 */       dbgid = Integer.valueOf(Integer.parseInt(request.getAttribute("dbgid").toString()));
/*     */     }
/*     */ 
/*  97 */     if (dbgid.intValue() != 0) {
/*  98 */       request.setAttribute("dbgid", dbgid);
/*  99 */       Qdao qdao = new Qdao();
/* 100 */       group = gdao.findById(dbgid);
/* 101 */       String stucodes = "";
/* 102 */       DabianGroupStuDAO dbgsdao = new DabianGroupStuDAO();
/* 103 */       List dbgstulist = dbgsdao.findByDbgid(dbgid);
/* 104 */       request.setAttribute("dbgstulist", dbgstulist);
/* 105 */       for (int i = 0; i < dbgstulist.size(); ++i) {
/* 106 */         stucodes = stucodes + "'" + ((DabianGroupStu)dbgstulist.get(i)).getStucode() + "',";
/*     */       }
/* 108 */       if (!stucodes.equals("")) {
/* 109 */         stucodes = stucodes.substring(0, stucodes.length() - 1);
/*     */ 
/* 111 */         List stulist = new LinkedList();
/* 112 */         stulist.addAll(qdao.query("from StuList where stucode in (" + stucodes + ")"));
/* 113 */         request.setAttribute("stulist", stulist);
/*     */ 
/* 115 */         List chengjilist = new LinkedList();
/* 116 */         chengjilist.addAll(qdao.query("from DabianChengji where stucode in(" + stucodes + ")"));
/* 117 */         request.setAttribute("chengjilist", chengjilist);
/*     */       }
/*     */     }
/* 120 */     request.setAttribute("dbgid", dbgid);
/* 121 */     request.setAttribute("leaderlist", leaderlist);
/* 122 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.dabian.DabianchengjilistAction
 * JD-Core Version:    0.5.4
 */