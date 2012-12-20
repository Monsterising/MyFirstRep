/*    */ package com.frame.struts.action.depart;
/*    */ 
/*    */ import com.entity.basedata.DepartTec;
/*    */ import com.entity.basedata.DepartTecDAO;
/*    */ import com.frame.struts.form.wish.SaveApplyResultForm;
/*    */ import java.io.PrintStream;
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
/*    */ public class AddApplyResultAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 49 */     SaveApplyResultForm saveApplyResultForm = (SaveApplyResultForm)form;
/* 50 */     HttpSession session = request.getSession();
/* 51 */     if (session.getAttribute("teccode") == null) {
/* 52 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 53 */       return mapping.findForward("error");
/*    */     }
/*    */ 
/* 57 */     String teccode = (String)session.getAttribute("teccode");
/* 58 */     DepartTec departtec = new DepartTec();
/* 59 */     DepartTecDAO dao = new DepartTecDAO();
/* 60 */     List departteclist = dao.findByTeccode(teccode);
/*    */ 
/* 62 */     List departlist = new LinkedList();
/* 63 */     String departids = "";
/* 64 */     for (int i = 0; i < departteclist.size(); ++i) {
/* 65 */       if (((DepartTec)departteclist.get(i)).getTecrole().intValue() != 2)
/*    */         continue;
/* 67 */       session.setAttribute("userrole", Integer.valueOf(2));
/* 68 */       session.setAttribute("usershenfen", "专业负责人");
/* 69 */       departids = departids + ((DepartTec)departteclist.get(i)).getDepartid() + ",";
/*    */     }
/*    */ 
/* 73 */     if (!departids.equals(""))
/*    */     {
/* 75 */       departids = departids.substring(0, departids.length() - 1);
/* 76 */       String hql = "from DepartList where departid in (" + departids + ")";
/* 77 */       Qdao qdao = new Qdao();
/* 78 */       System.out.println("hql=" + hql);
/* 79 */       departlist.addAll(qdao.query(hql));
/* 80 */       request.setAttribute("departlist", departlist);
/* 81 */       return mapping.findForward("display");
/*    */     }
/* 83 */     request.setAttribute("notice", "无对应权限");
/* 84 */     return mapping.findForward("error");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.AddApplyResultAction
 * JD-Core Version:    0.5.4
 */