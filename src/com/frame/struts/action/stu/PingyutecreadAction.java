/*    */ package com.frame.struts.action.stu;
/*    */ 
/*    */ import com.entity.basedata.StuList;
/*    */ import com.entity.basedata.StuListDAO;
/*    */ import com.entity.pingyue.PingyuTec;
/*    */ import com.entity.pingyue.PingyuTecDAO;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.apache.struts.action.Action;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ 
/*    */ public class PingyutecreadAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 45 */     HttpSession session = request.getSession();
/* 46 */     if (session.getAttribute("stucode") == null) {
/* 47 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 48 */       return mapping.findForward("error");
/* 49 */     }String stucode = session.getAttribute("stucode").toString();
/*    */ 
/* 52 */     StuList stu = new StuList();
/* 53 */     StuListDAO studao = new StuListDAO();
/* 54 */     stu = studao.findById(stucode);
/*    */ 
/* 56 */     PingyuTec pytec = new PingyuTec();
/* 57 */     PingyuTecDAO pydao = new PingyuTecDAO();
/* 58 */     if (pydao.findByStucode(stucode).size() != 0) {
/* 59 */       pytec = (PingyuTec)pydao.findByStucode(stucode).get(0);
/* 60 */       request.setAttribute("PingyuTec", pytec);
/*    */     } else {
/* 62 */       request.setAttribute("notice", "暂无评语");
/*    */     }
/*    */ 
/* 69 */     return mapping.findForward("display");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.stu.PingyutecreadAction
 * JD-Core Version:    0.5.4
 */