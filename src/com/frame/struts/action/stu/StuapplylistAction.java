/*    */ package com.frame.struts.action.stu;
/*    */ 
/*    */ import com.entity.basedata.DepartTec;
/*    */ import com.entity.basedata.DepartTecDAO;
/*    */ import com.entity.wish.ApplyTec;
/*    */ import com.entity.wish.ApplyTecDAO;
/*    */ import com.entity.wish.StuWish;
/*    */ import com.entity.wish.StuWishDAO;
/*    */ import com.entity.wish.Xuanti;
/*    */ import com.entity.wish.XuantiDAO;
/*    */ import com.frame.struts.form.wish.StuwishForm;
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.apache.struts.action.Action;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ import org.hibernate.Session;
/*    */ import pub.Qdao;
/*    */ 
/*    */ public class StuapplylistAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 54 */     StuwishForm wform = (StuwishForm)form;
/* 55 */     HttpSession session = request.getSession();
/* 56 */     if (session.getAttribute("stucode") == null) {
/* 57 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 58 */       return mapping.findForward("error");
/*    */     }
/* 60 */     StuWish stuwish = new StuWish();
/* 61 */     StuWishDAO wdao = new StuWishDAO();
/*    */ 
/* 63 */     String stucode = (String)session.getAttribute("stucode");
/* 64 */     Integer departid = (Integer)session.getAttribute("departid");
/* 65 */     List wishlist = wdao.findByStucode(stucode);
/* 66 */     request.setAttribute("wishlist", wishlist);
/*    */ 
/* 69 */     ApplyTec applytec = new ApplyTec();
/* 70 */     ApplyTecDAO atdao = new ApplyTecDAO();
/* 71 */     List applyteclist = atdao.findByDepartid(departid);
/* 72 */     request.setAttribute("applyteclist", applyteclist);
/*    */ 
/* 75 */     DepartTecDAO dtdao = new DepartTecDAO();
/* 76 */     Qdao qdao = new Qdao();
/* 77 */     List dtlist = dtdao.findByDepartid(departid);
/* 78 */     List teclist = new LinkedList();
/* 79 */     String teccodes = "";
/* 80 */     for (int i = 0; i < dtlist.size(); ++i) {
/* 81 */       teccodes = teccodes + "'" + ((DepartTec)dtlist.get(i)).getTeccode() + "',";
/*    */     }
/* 83 */     teccodes = teccodes.substring(0, teccodes.length() - 1);
/*    */ 
/* 86 */     String hql = "from TecList where teccode in(" + teccodes + ")";
/* 87 */     teclist.addAll(qdao.query(hql));
/* 88 */     request.setAttribute("teclist", teclist);
/*    */ 
/* 91 */     Xuanti xuanti = new Xuanti();
/* 92 */     XuantiDAO xdao = new XuantiDAO();
/* 93 */     if (xdao.getSession().get(Xuanti.class, stucode) != null)
/*    */     {
/* 95 */       request.setAttribute("wish", "ok");
/*    */     }
/*    */ 
/* 99 */     return mapping.findForward("display");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.stu.StuapplylistAction
 * JD-Core Version:    0.5.4
 */