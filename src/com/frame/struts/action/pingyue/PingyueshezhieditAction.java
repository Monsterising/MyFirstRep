/*     */ package com.frame.struts.action.pingyue;
/*     */ 
/*     */ import com.entity.basedata.TecList;
/*     */ import com.entity.basedata.TecListDAO;
/*     */ import com.entity.pingyue.PingyuGroup;
/*     */ import com.entity.wish.ApplyTec;
/*     */ import com.entity.wish.StuWish;
/*     */ import com.frame.struts.form.pingyue.PingyueshezhiForm;
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
/*     */ public class PingyueshezhieditAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  53 */     HttpSession session = request.getSession();
/*  54 */     if (session.getAttribute("teccode") == null) {
/*  55 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  56 */       return mapping.findForward("error");
/*     */     }
/*  58 */     Integer departid = Integer.valueOf(Integer.parseInt(request.getParameter("departid").toString()));
/*  59 */     String teccode = request.getParameter("t").toString();
/*  60 */     Integer gradeid = Integer.valueOf(Integer.parseInt(request.getParameter("gradeid").toString()));
/*     */ 
/*  62 */     TecList tec = new TecList();
/*  63 */     TecListDAO tecdao = new TecListDAO();
/*  64 */     tec = tecdao.findById(teccode);
/*  65 */     request.setAttribute("TecList", tec);
/*     */ 
/*  69 */     Qdao qdao = new Qdao();
/*  70 */     String hql = "";
/*     */ 
/*  74 */     List applylist = new LinkedList();
/*  75 */     hql = "from ApplyTec where departid=" + departid + " and gradeid=" + gradeid;
/*  76 */     applylist.addAll(qdao.query(hql));
/*  77 */     String atids = "";
/*  78 */     String teccodes = "";
/*  79 */     for (int i = 0; i < applylist.size(); ++i) {
/*  80 */       atids = atids + ((ApplyTec)applylist.get(i)).getAtid() + ",";
/*  81 */       teccodes = teccodes + "'" + ((ApplyTec)applylist.get(i)).getTeccode() + "',";
/*     */     }
/*  83 */     if (!atids.equals("")) atids = atids.substring(0, atids.length() - 1);
/*     */ 
/*  85 */     List stulistwish = new LinkedList();
/*  86 */     hql = "from StuWish where wishstate='通过' and teccode='" + teccode + "' and atid in(" + atids + ")";
/*  87 */     stulistwish.addAll(qdao.query(hql));
/*     */ 
/*  89 */     String stucodeswis = "";
/*  90 */     for (int i = 0; i < stulistwish.size(); ++i) {
/*  91 */       stucodeswis = stucodeswis + "'" + ((StuWish)stulistwish.get(i)).getStucode() + "',";
/*     */     }
/*  93 */     if (!stucodeswis.equals("")) stucodeswis = stucodeswis.substring(0, stucodeswis.length() - 1);
/*     */ 
/*  96 */     List stulistping = new LinkedList();
/*  97 */     hql = "from PingyuGroup where departid=" + departid + " and gradeid=" + gradeid + " and teccode not in('" + teccode + "')";
/*  98 */     stulistping.addAll(qdao.query(hql));
/*  99 */     String stucodesping = "";
/* 100 */     for (int i = 0; i < stulistping.size(); ++i) {
/* 101 */       stucodesping = stucodesping + "'" + ((PingyuGroup)stulistping.get(i)).getStucode() + "',";
/*     */     }
/* 103 */     if (!stucodesping.equals("")) stucodesping = stucodesping.substring(0, stucodesping.length() - 1);
/*     */ 
/* 106 */     String hql2 = "";
/* 107 */     if (!stucodeswis.equals("")) hql2 = " and stucode not in(" + stucodeswis + ")";
/* 108 */     if (!stucodesping.equals("")) hql2 = hql2 + " and stucode not in(" + stucodesping + ")";
/* 109 */     List stulistall = new LinkedList();
/* 110 */     hql = "from StuList where departid=" + departid + " and gradeid=" + gradeid + hql2;
/* 111 */     stulistall.addAll(qdao.query(hql));
/*     */ 
/* 115 */     List stulistpingtec = new LinkedList();
/* 116 */     hql = "from PingyuGroup where departid=" + departid + " and gradeid=" + gradeid + " and teccode ='" + teccode + "'";
/* 117 */     stulistpingtec.addAll(qdao.query(hql));
/* 118 */     String stucodesping2 = "";
/* 119 */     for (int i = 0; i < stulistpingtec.size(); ++i) {
/* 120 */       stucodesping2 = stucodesping2 + ((PingyuGroup)stulistpingtec.get(i)).getStucode() + ",";
/*     */     }
/*     */ 
/* 123 */     if (!stucodesping2.equals("")) {
/* 124 */       stucodesping2 = stucodesping2.substring(0, stucodesping2.length() - 1);
/* 125 */       String[] stucodepingtec = stucodesping2.split(",");
/* 126 */       PingyueshezhiForm pform = (PingyueshezhiForm)form;
/* 127 */       pform.setStucodes(stucodepingtec);
/*     */     }
/*     */ 
/* 138 */     List teclist = new LinkedList();
/* 139 */     hql = "from TecList where teccode in('" + teccode + "')";
/* 140 */     teclist.addAll(qdao.query(hql));
/*     */ 
/* 143 */     request.setAttribute("departid", departid);
/* 144 */     request.setAttribute("gradeid", gradeid);
/* 145 */     request.setAttribute("stulist", stulistall);
/* 146 */     request.setAttribute("stuwishlist", stulistwish);
/* 147 */     request.setAttribute("teclist", teclist);
/* 148 */     request.setAttribute("teccode", teccode);
/*     */ 
/* 150 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.pingyue.PingyueshezhieditAction
 * JD-Core Version:    0.5.4
 */