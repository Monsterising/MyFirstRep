/*     */ package com.frame.struts.action.depart;
/*     */ 
/*     */ import com.entity.wish.ApplyState;
/*     */ import com.entity.wish.ApplyStateDAO;
/*     */ import com.entity.wish.ApplyTec;
/*     */ import com.entity.wish.ApplyTecDAO;
/*     */ import com.entity.wish.StuWish;
/*     */ import com.entity.wish.StuWishDAO;
/*     */ import com.entity.wish.Xuanti;
/*     */ import com.entity.wish.XuantiDAO;
/*     */ import java.io.PrintStream;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.apache.struts.action.Action;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionForward;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ import org.hibernate.Session;
/*     */ import org.hibernate.Transaction;
/*     */ import pub.Qdao;
/*     */ 
/*     */ public class CheckstuwishAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  57 */     HttpSession session = request.getSession();
/*  58 */     if (session.getAttribute("teccode") == null) {
/*  59 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  60 */       return mapping.findForward("error");
/*     */     }
/*  62 */     String teccode = session.getAttribute("teccode").toString();
/*  63 */     String check = request.getParameter("check");
/*  64 */     Integer atid = Integer.valueOf(Integer.parseInt(request.getParameter("id").toString()));
/*  65 */     Integer wishid = Integer.valueOf(Integer.parseInt(request.getParameter("w").toString()));
/*  66 */     String stucode = request.getParameter("s");
/*  67 */     System.out.println("接收的.stucode=" + stucode);
/*     */ 
/*  69 */     ApplyTec at = new ApplyTec();
/*  70 */     ApplyTecDAO adao = new ApplyTecDAO();
/*  71 */     at = adao.findById(atid);
/*     */ 
/*  73 */     Qdao qdao = new Qdao();
/*  74 */     String hql = "";
/*  75 */     Date date = new Date();
/*  76 */     SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*  77 */     String dateup = sf.format(date);
/*     */ 
/*  79 */     if (check.equals("t"))
/*     */     {
/*  81 */       hql = "update StuWish set wishstate='通过',dateaccess='" + dateup + "' where wishid=" + wishid;
/*  82 */       qdao.update(hql);
/*     */ 
/*  84 */       hql = "update StuWish set wishstate='作废',dateaccess='" + dateup + "' where stucode='" + stucode + "' and wishstate='等待审核'";
/*  85 */       qdao.update(hql);
/*     */ 
/*  87 */       Xuanti xuanti = new Xuanti();
/*  88 */       XuantiDAO xdao = new XuantiDAO();
/*  89 */       System.out.println("xuanti.stucode=" + stucode);
/*  90 */       xuanti.setStucode(stucode);
/*  91 */       xuanti.setAtid(atid);
/*  92 */       xuanti.setTeccode(teccode);
/*  93 */       xuanti.setDateaccess(date);
/*  94 */       Transaction ts = xdao.getSession().beginTransaction();
/*     */       try {
/*  96 */         xdao.getSession().saveOrUpdate(xuanti);
/*  97 */         ts.commit();
/*  98 */         xdao.getSession().flush();
/*     */ 
/* 100 */         request.setAttribute("notice", "已经同意该学生的志愿！");
/*     */       }
/*     */       catch (RuntimeException re) {
/* 103 */         System.out.println("异常信息：" + re);
/* 104 */         xdao.getSession().clear();
/* 105 */         ts.rollback();
/* 106 */         request.setAttribute("notice", "志愿审核操作！！！");
/* 107 */         return mapping.findForward("error");
/*     */       }
/*     */ 
/* 111 */       ApplyState as = new ApplyState();
/* 112 */       ApplyStateDAO asdao = new ApplyStateDAO();
/* 113 */       if (asdao.findById(atid) != null) {
/* 114 */         as = asdao.findById(atid);
/*     */       }
/* 116 */       as.setAdvice1("通过");
/* 117 */       as.setAdvice2("通过");
/* 118 */       as.setAtid(atid);
/* 119 */       as.setXuanti("ok");
/* 120 */       Transaction tsas = asdao.getSession().beginTransaction();
/*     */       try {
/* 122 */         asdao.getSession().saveOrUpdate(as);
/* 123 */         asdao.getSession().flush();
/* 124 */         tsas.commit();
/*     */       } catch (RuntimeException re) {
/* 126 */         System.out.println("异常信息：" + re);
/* 127 */         asdao.getSession().clear();
/* 128 */         tsas.rollback();
/* 129 */         request.setAttribute("notice", "编辑课题  资料失败！！！");
/* 130 */         return mapping.findForward("error");
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 136 */     if (check.equals("f"))
/*     */     {
/* 141 */       hql = "update StuWish set wishstate='驳回',priority=0,dateaccess='" + dateup + "' where wishid=" + wishid;
/* 142 */       qdao.update(hql);
/*     */ 
/* 144 */       hql = "update StuWish set priority=priority-1,dateup='" + dateup + "' where stucode='" + stucode + "' and wishstate='等待审核'";
/* 145 */       qdao.update(hql);
/*     */     }
/*     */ 
/* 151 */     Integer stusum = at.getStusum();
/*     */ 
/* 153 */     hql = "select count(*) from Xuanti where atid=" + at.getAtid();
/* 154 */     Long k = (Long)qdao.count(hql);
/*     */ 
/* 157 */     if (stusum.intValue() <= k.longValue())
/*     */     {
/* 159 */       hql = "delete StuWish where atid=" + atid + "and wishstate='等待审核' and (priority=2 or priority=3)";
/* 160 */       qdao.del(hql);
/*     */ 
/* 163 */       String stucodes = "";
/* 164 */       hql = "from StuWish where atid=" + atid + "and wishstate='等待审核' and priority=1";
/* 165 */       List wishlist = new LinkedList();
/* 166 */       StuWishDAO wdao = new StuWishDAO();
/* 167 */       wishlist.addAll(qdao.query(hql));
/* 168 */       for (int i = 0; i < wishlist.size(); ++i) {
/* 169 */         stucodes = stucodes + "'" + ((StuWish)wishlist.get(i)).getStucode() + "'" + ",";
/*     */       }
/* 171 */       if (!stucodes.equals("")) {
/* 172 */         stucodes = stucodes.substring(0, stucodes.length() - 1);
/* 173 */         hql = "update StuWish set wishstate='驳回',priority=0,dateup='" + dateup + "' where priority=1 and stucode in(" + stucodes + ")";
/* 174 */         qdao.update(hql);
/*     */ 
/* 176 */         hql = "update StuWish set priority=priority-1,dateup='" + dateup + "' where (priority=2 or priority=3) and stucode in(" + stucodes + ")";
/* 177 */         qdao.update(hql);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 184 */     request.setAttribute("departid", at.getDepartid());
/* 185 */     request.setAttribute("atid", at.getAtid());
/*     */ 
/* 188 */     return mapping.findForward("success");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.CheckstuwishAction
 * JD-Core Version:    0.5.4
 */