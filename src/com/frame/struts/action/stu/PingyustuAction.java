/*    */ package com.frame.struts.action.stu;
/*    */ 
/*    */ import com.entity.basedata.StuList;
/*    */ import com.entity.basedata.StuListDAO;
/*    */ import com.entity.pingyue.PingyuStu;
/*    */ import com.entity.pingyue.PingyuStuDAO;
/*    */ import com.entity.wish.Xuanti;
/*    */ import com.entity.wish.XuantiDAO;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.apache.struts.action.Action;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ import org.hibernate.Session;
/*    */ 
/*    */ public class PingyustuAction extends Action
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
/* 58 */     Xuanti xuanti = new Xuanti();
/* 59 */     XuantiDAO xdao = new XuantiDAO();
/* 60 */     if (xdao.findById(stucode) == null) {
/* 61 */       request.setAttribute("notice", "您还未确定课题！");
/* 62 */       return mapping.findForward("error");
/*    */     }
/* 64 */     xuanti = xdao.findById(stucode);
/* 65 */     request.setAttribute("atid", xuanti.getAtid());
/*    */ 
/* 67 */     PingyuStu pystu = new PingyuStu();
/* 68 */     PingyuStuDAO dao = new PingyuStuDAO();
/* 69 */     if (dao.getSession().get(PingyuStu.class, stucode) != null) {
/* 70 */       pystu = dao.findById(stucode);
/* 71 */       request.setAttribute("PingyuStu", pystu);
/*    */     } else {
/* 73 */       request.setAttribute("notice", "您还没有填写评语");
/*    */     }
/*    */ 
/* 79 */     return mapping.findForward("display");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.stu.PingyustuAction
 * JD-Core Version:    0.5.4
 */