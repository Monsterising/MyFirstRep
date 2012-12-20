/*    */ package com.frame.struts.action;
/*    */ 
/*    */ import com.entity.basedata.CollegeList;
/*    */ import com.entity.basedata.CollegeListDAO;
/*    */ import com.frame.struts.baseform.CollegeForm;
/*    */ import java.io.PrintStream;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.apache.log4j.Logger;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.Transaction;
/*    */ import pub.LogAction;
/*    */ import pub.toChi;
/*    */ 
/*    */ public class CollegesaveAction extends LogAction
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 50 */     CollegeForm cform = (CollegeForm)form;
/* 51 */     HttpSession session = request.getSession();
/*    */ 
/* 57 */     String collegename = cform.getCollegename().trim();
/* 58 */     toChi tochi = new toChi();
/* 59 */     collegename = tochi.toChinese(collegename);
/* 60 */     Integer collegeid = cform.getCollegeid();
/* 61 */     System.out.println("collegeid" + cform.getCollegeid());
/* 62 */     System.out.println("collegename" + collegename);
/* 63 */     CollegeList college = new CollegeList();
/* 64 */     CollegeListDAO cdao = new CollegeListDAO();
/* 65 */     if (collegeid != null) {
/* 66 */       college = cdao.findById(collegeid);
/*    */     }
/* 68 */     college.setCollegename(collegename);
/* 69 */     Transaction ts = cdao.getSession().beginTransaction();
/*    */     try {
/* 71 */       cdao.save(college);
/* 72 */       cdao.getSession().flush();
/* 73 */       ts.commit();
/* 74 */       request.setAttribute("notice", "学院名称修改成功！");
/* 75 */       return mapping.findForward("collegelist");
/*    */     } catch (RuntimeException ex) {
/* 77 */       logger.info("错误：修改学院名称出错");
/* 78 */       ts.rollback();
/* 79 */       cdao.getSession().clear();
/* 80 */       throw ex;
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.CollegesaveAction
 * JD-Core Version:    0.5.4
 */