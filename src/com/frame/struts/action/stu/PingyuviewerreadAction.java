/*    */ package com.frame.struts.action.stu;
/*    */ 
/*    */ import com.entity.basedata.StuList;
/*    */ import com.entity.basedata.StuListDAO;
/*    */ import com.entity.pingyue.PingyuViewer;
/*    */ import com.entity.pingyue.PingyuViewerDAO;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.apache.struts.action.Action;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ 
/*    */ public class PingyuviewerreadAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 47 */     HttpSession session = request.getSession();
/* 48 */     if (session.getAttribute("stucode") == null) {
/* 49 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 50 */       return mapping.findForward("error");
/* 51 */     }String stucode = session.getAttribute("stucode").toString();
/*    */ 
/* 54 */     StuList stu = new StuList();
/* 55 */     StuListDAO studao = new StuListDAO();
/* 56 */     stu = studao.findById(stucode);
/*    */ 
/* 58 */     PingyuViewer pytec = new PingyuViewer();
/* 59 */     PingyuViewerDAO pydao = new PingyuViewerDAO();
/* 60 */     if (pydao.findByStucode(stucode).size() != 0) {
/* 61 */       pytec = (PingyuViewer)pydao.findByStucode(stucode).get(0);
/* 62 */       request.setAttribute("PingyuViewer", pytec);
/*    */     } else {
/* 64 */       request.setAttribute("notice", "暂无评语");
/*    */     }
/*    */ 
/* 71 */     return mapping.findForward("display");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.stu.PingyuviewerreadAction
 * JD-Core Version:    0.5.4
 */