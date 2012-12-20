/*    */ package com.frame.struts.action.college;
/*    */ 
/*    */ import com.entity.basedata.GradeList;
/*    */ import com.entity.basedata.GradeListDAO;
/*    */ import com.frame.struts.baseform.AddgradeForm;
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
/*    */ public class SavegradeAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 45 */     AddgradeForm aform = (AddgradeForm)form;
/*    */ 
/* 47 */     HttpSession session = request.getSession();
/* 48 */     if (session.getAttribute("adminid") == null) {
/* 49 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 50 */       return mapping.findForward("error");
/*    */     }
/* 52 */     toChi tochi = new toChi();
/* 53 */     Integer collegeid = aform.getCollegeid();
/* 54 */     Integer departid = aform.getDepartid();
/* 55 */     String gradename = tochi.toChinese(aform.getGradename().trim());
/* 56 */     String op = aform.getOp();
/* 57 */     Integer gradeid = aform.getGradeid();
/*    */ 
/* 59 */     GradeList grade = new GradeList();
/* 60 */     GradeListDAO gdao = new GradeListDAO();
/*    */ 
/* 62 */     if (op.equals("gxin")) {
/* 63 */       grade = gdao.findById(gradeid);
/*    */     }
/* 65 */     grade.setCollegeid(collegeid);
/*    */ 
/* 67 */     grade.setDepartid(departid);
/*    */ 
/* 69 */     grade.setGradename(gradename);
/* 70 */     Transaction ts = gdao.getSession().beginTransaction();
/*    */     try {
/* 72 */       gdao.getSession().saveOrUpdate(grade);
/* 73 */       ts.commit();
/* 74 */       gdao.getSession().flush();
/* 75 */       request.setAttribute("departid", departid);
/* 76 */       request.setAttribute("notice", "设置年级 " + gradename + " 资料成功！！！");
/* 77 */       return mapping.findForward("list");
/*    */     } catch (RuntimeException re) {
/* 79 */       System.out.println("异常信息：" + re);
/* 80 */       gdao.getSession().clear();
/* 81 */       ts.rollback();
/* 82 */       request.setAttribute("notice", "为专业" + departid + "添加年级 " + gradename + " 资料失败！！！");
/* 83 */     }return mapping.findForward("error");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.SavegradeAction
 * JD-Core Version:    0.5.4
 */