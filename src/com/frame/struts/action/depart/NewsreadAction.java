/*    */ package com.frame.struts.action.depart;
/*    */ 
/*    */ import com.entity.basedata.News;
/*    */ import com.entity.basedata.NewsDAO;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.apache.struts.action.Action;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ import org.hibernate.Session;
/*    */ import pub.Qdao;
/*    */ 
/*    */ public class NewsreadAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 45 */     String id = request.getParameter("id");
/* 46 */     if ((id == null) || (id.equals(""))) {
/* 47 */       request.setAttribute("notice", "请输入正确的ID");
/* 48 */       return mapping.findForward("display");
/*    */     }
/* 50 */     Integer newsid = Integer.valueOf(Integer.parseInt(id));
/*    */ 
/* 53 */     NewsDAO dao = new NewsDAO();
/* 54 */     News news = new News();
/*    */ 
/* 57 */     dao.getSession().flush();
/* 58 */     news = (News)dao.getSession().get(News.class, newsid);
/* 59 */     Qdao qdao = new Qdao();
/* 60 */     String hql = "update News set click=click+1 where newsid=" + newsid;
/* 61 */     qdao.update(hql);
/*    */ 
/* 64 */     request.setAttribute("News", news);
/* 65 */     return mapping.findForward("display");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.NewsreadAction
 * JD-Core Version:    0.5.4
 */