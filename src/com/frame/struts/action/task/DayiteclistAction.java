/*    */ package com.frame.struts.action.task;
/*    */ 
/*    */ import com.entity.wish.Xuanti;
/*    */ import com.entity.wish.XuantiDAO;
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.apache.struts.action.Action;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ import pub.Qdao;
/*    */ 
/*    */ public class DayiteclistAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 51 */     HttpSession session = request.getSession();
/* 52 */     if (session.getAttribute("teccode") == null) {
/* 53 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 54 */       return mapping.findForward("error");
/*    */     }
/* 56 */     String teccode = session.getAttribute("teccode").toString();
/*    */ 
/* 58 */     String stucode = "";
/* 59 */     if (request.getParameter("s") != null) {
/* 60 */       stucode = request.getParameter("s").toString();
/*    */     }
/*    */ 
/* 64 */     List dayilist = new LinkedList();
/* 65 */     Qdao qdao = new Qdao();
/* 66 */     String hql = "";
/* 67 */     String stucodes = "";
/* 68 */     String sql = "";
/* 69 */     if (!stucode.equals("")) {
/* 70 */       sql = " and stucode='" + stucode + "'";
/* 71 */       request.setAttribute("stucode", stucode);
/*    */     }
/* 73 */     hql = "from Stagetaskdayi where teccode='" + teccode + "' " + sql + " order by isok,qtime";
/* 74 */     dayilist.addAll(qdao.query(hql));
/* 75 */     request.setAttribute("dayilist", dayilist);
/*    */ 
/* 78 */     XuantiDAO xdao = new XuantiDAO();
/* 79 */     List xlist = xdao.findByTeccode(teccode);
/* 80 */     if (xlist.size() != 0) {
/* 81 */       for (int i = 0; i < xlist.size(); ++i) {
/* 82 */         stucodes = stucodes + "'" + ((Xuanti)xlist.get(i)).getStucode() + "',";
/*    */       }
/* 84 */       List stulist = new LinkedList();
/* 85 */       stucodes = stucodes.substring(0, stucodes.length() - 1);
/* 86 */       hql = "from StuList where stucode in(" + stucodes + ")";
/* 87 */       stulist.addAll(qdao.query(hql));
/* 88 */       request.setAttribute("stulist", stulist);
/*    */     } else {
/* 90 */       request.setAttribute("notice", "您暂且没有指导学生");
/*    */     }
/* 92 */     if (dayilist.size() == 0) {
/* 93 */       request.setAttribute("notice", "暂无记录！");
/*    */     }
/*    */ 
/* 98 */     return mapping.findForward("display");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.task.DayiteclistAction
 * JD-Core Version:    0.5.4
 */