/*    */ package com.frame.struts.action.college;
/*    */ 
/*    */ import com.entity.basedata.DepartList;
/*    */ import com.entity.basedata.DepartListDAO;
/*    */ import com.frame.struts.baseform.AdddepartForm;
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
/*    */ import pub.toChi;
/*    */ 
/*    */ public class SavedepartAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 51 */     HttpSession session = request.getSession();
/* 52 */     if (session.getAttribute("adminid") == null) {
/* 53 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 54 */       return mapping.findForward("error");
/*    */     }
/* 56 */     AdddepartForm adddepartForm = (AdddepartForm)form;
/* 57 */     toChi tochi = new toChi();
/* 58 */     Integer collegeid = adddepartForm.getCollegeid();
/* 59 */     Integer departid = adddepartForm.getDepartid();
/* 60 */     String departname = tochi.toChinese(adddepartForm.getDepartname().trim());
/* 61 */     String op = adddepartForm.getOp();
/*    */ 
/* 63 */     if (departname.equals("")) {
/* 64 */       request.setAttribute("notice", "添加专业 " + departname + " 资料失败！！！<br>每一项都要填写！");
/* 65 */       return mapping.findForward("error");
/*    */     }
/*    */ 
/* 70 */     DepartList depart = new DepartList();
/* 71 */     DepartListDAO ddao = new DepartListDAO();
/*    */ 
/* 73 */     if (op.equals("gxin")) {
/* 74 */       depart = ddao.findById(departid);
/*    */     }
/* 76 */     depart.setCollegeid(collegeid);
/* 77 */     depart.setDepartname(departname);
/*    */ 
/* 79 */     Transaction ts = ddao.getSession().beginTransaction();
/*    */     try {
/* 81 */       ddao.getSession().saveOrUpdate(depart);
/* 82 */       ddao.getSession().flush();
/* 83 */       ts.commit();
/* 84 */       request.setAttribute("notice", "添加专业 " + departname + " 资料成功");
/*    */     } catch (RuntimeException re) {
/* 86 */       System.out.println("异常信息：" + re);
/* 87 */       ddao.getSession().clear();
/* 88 */       ts.rollback();
/* 89 */       request.setAttribute("notice", "添加专业 " + departname + " 资料失败！！！");
/* 90 */       return mapping.findForward("error");
/*    */     }
/* 92 */     return mapping.findForward("list");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.SavedepartAction
 * JD-Core Version:    0.5.4
 */