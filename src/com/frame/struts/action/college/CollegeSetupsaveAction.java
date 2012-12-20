/*    */ package com.frame.struts.action.college;
/*    */ 
/*    */ import com.entity.basedata.CollegeList;
/*    */ import com.entity.basedata.CollegeListDAO;
/*    */ import com.entity.basedata.CollegeSetup;
/*    */ import com.entity.basedata.CollegeSetupDAO;
/*    */ import com.frame.struts.form.college.CollegeSetupForm;
/*    */ import java.io.PrintStream;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.apache.struts.action.Action;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.Transaction;
/*    */ 
/*    */ public class CollegeSetupsaveAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 46 */     CollegeSetupForm cform = (CollegeSetupForm)form;
/* 47 */     HttpSession session = request.getSession();
/* 48 */     if (session.getAttribute("adminid") == null) {
/* 49 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 50 */       return mapping.findForward("error");
/*    */     }
/* 52 */     Integer collegeid = Integer.valueOf(Integer.parseInt(session.getAttribute("collegeid").toString()));
/*    */ 
/* 54 */     CollegeList collegelist = new CollegeList();
/* 55 */     CollegeListDAO cdao = new CollegeListDAO();
/* 56 */     collegelist = cdao.findById(collegeid);
/*    */ 
/* 58 */     CollegeSetup cs = new CollegeSetup();
/* 59 */     CollegeSetupDAO csdao = new CollegeSetupDAO();
/* 60 */     if (csdao.findById(collegelist.getCollegeid()) != null) {
/* 61 */       cs = csdao.findById(collegelist.getCollegeid());
/* 63 */     }cs.setCollegeid(collegelist.getCollegeid());
/* 64 */     cs.setDateover(cform.getDateover());
/* 65 */     cs.setDatestart(cform.getDatestart());
/* 66 */     Transaction ts = csdao.getSession().beginTransaction();
/*    */     ActionForward localActionForward;
/*    */     try {
/* 68 */       csdao.getSession().saveOrUpdate(cs);
/* 69 */       ts.commit();
/* 70 */       csdao.getSession().flush();
/* 71 */       request.setAttribute("notice", "保存信息成功！！！");
/* 72 */       return mapping.findForward("success");
/*    */     } catch (RuntimeException re) {
/* 74 */       System.out.println("异常信息：" + re);
/* 75 */       csdao.getSession().clear();
/* 76 */       ts.rollback();
/* 77 */       request.setAttribute("notice", "保存资料失败！！！");
/* 78 */       return mapping.findForward("error");
/*    */     } finally {
/* 80 */       csdao.getSession().close();
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.CollegeSetupsaveAction
 * JD-Core Version:    0.5.4
 */