/*    */ package com.frame.struts.action.stu;
/*    */ 
/*    */ import com.entity.basedata.StuList;
/*    */ import com.entity.basedata.StuListDAO;
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
/*    */ public class NewsindexstuAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 50 */     HttpSession session = request.getSession();
/* 51 */     if (session.getAttribute("stucode") == null) {
/* 52 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 53 */       return mapping.findForward("error");
/*    */     }
/*    */ 
/* 56 */     String stucode = (String)session.getAttribute("stucode");
/*    */ 
/* 58 */     StuList stu = new StuList();
/* 59 */     StuListDAO studao = new StuListDAO();
/* 60 */     stu = (StuList)studao.getSession().get(StuList.class, stucode);
/*    */ 
/* 62 */     List newslist = new LinkedList();
/* 63 */     String hql = "from News where departid=0 or departid = " + stu.getDepartid() + " order by newsid desc";
/* 64 */     Qdao qdao = new Qdao();
/* 65 */     newslist.addAll(qdao.query(hql));
/* 66 */     request.setAttribute("newslist", newslist);
/*    */ 
/* 69 */     List departlist = new LinkedList();
/* 70 */     hql = "from DepartList where departid =" + stu.getDepartid();
/* 71 */     departlist.addAll(qdao.query(hql));
/* 72 */     request.setAttribute("departlist", departlist);
/*    */ 
/* 74 */     return mapping.findForward("display");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.stu.NewsindexstuAction
 * JD-Core Version:    0.5.4
 */