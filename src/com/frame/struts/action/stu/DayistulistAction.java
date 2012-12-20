/*    */ package com.frame.struts.action.stu;
/*    */ 
/*    */ import com.entity.basedata.TecList;
/*    */ import com.entity.basedata.TecListDAO;
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
/*    */ public class DayistulistAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 52 */     HttpSession session = request.getSession();
/* 53 */     if (session.getAttribute("stucode") == null) {
/* 54 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 55 */       return mapping.findForward("error");
/*    */     }
/* 57 */     String stucode = session.getAttribute("stucode").toString();
/*    */ 
/* 61 */     List dayilist = new LinkedList();
/* 62 */     Qdao qdao = new Qdao();
/* 63 */     String hql = "";
/*    */ 
/* 65 */     hql = "from Stagetaskdayi where stucode='" + stucode + "'" + "order by isok";
/* 66 */     dayilist.addAll(qdao.query(hql));
/* 67 */     request.setAttribute("dayilist", dayilist);
/*    */ 
/* 70 */     XuantiDAO xdao = new XuantiDAO();
/* 71 */     Xuanti xuanti = new Xuanti();
/* 72 */     xuanti = xdao.findById(stucode);
/* 73 */     if (xuanti == null) {
/* 74 */       request.setAttribute("notice", "您暂且没有指导教师");
/*    */     } else {
/* 76 */       TecList tec = new TecList();
/* 77 */       TecListDAO tdao = new TecListDAO();
/* 78 */       tec = tdao.findById(xuanti.getTeccode());
/* 79 */       request.setAttribute("tecname", "你的指导教师是 " + tec.getTecname());
/*    */     }
/*    */ 
/* 82 */     if (dayilist.size() == 0) {
/* 83 */       request.setAttribute("notice", "暂无记录！");
/*    */     }
/*    */ 
/* 88 */     return mapping.findForward("display");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.stu.DayistulistAction
 * JD-Core Version:    0.5.4
 */