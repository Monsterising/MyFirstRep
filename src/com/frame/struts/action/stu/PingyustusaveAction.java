/*    */ package com.frame.struts.action.stu;
/*    */ 
/*    */ import com.entity.basedata.StuList;
/*    */ import com.entity.basedata.StuListDAO;
/*    */ import com.entity.pingyue.PingyuStu;
/*    */ import com.entity.pingyue.PingyuStuDAO;
/*    */ import com.frame.struts.form.pingyu.PingyustuForm;
/*    */ import java.io.PrintStream;
/*    */ import java.util.Date;
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
/*    */ public class PingyustusaveAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 50 */     PingyustuForm pform = (PingyustuForm)form;
/* 51 */     HttpSession session = request.getSession();
/* 52 */     if (session.getAttribute("stucode") == null) {
/* 53 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 54 */       return mapping.findForward("error");
/* 55 */     }String stucode = session.getAttribute("stucode").toString();
/*    */ 
/* 58 */     StuList stu = new StuList();
/* 59 */     StuListDAO studao = new StuListDAO();
/* 60 */     stu = studao.findById(stucode);
/*    */ 
/* 62 */     PingyuStu pystu = new PingyuStu();
/* 63 */     PingyuStuDAO dao = new PingyuStuDAO();
/* 64 */     if (dao.getSession().get(PingyuStu.class, stucode) != null) {
/* 65 */       pystu = dao.findById(stucode);
/*    */     }
/*    */ 
/* 68 */     toChi tochi = new toChi();
/* 69 */     Date date = new Date();
/*    */ 
/* 71 */     pystu.setAtid(pform.getAtid());
/* 72 */     pystu.setAttitude(tochi.toChinese(pform.getAttitude()));
/* 73 */     pystu.setBeijin(tochi.toChinese(pform.getBj()));
/* 74 */     pystu.setContent(tochi.toChinese(pform.getContent()));
/* 75 */     pystu.setResult(tochi.toChinese(pform.getResult()));
/* 76 */     pystu.setStucode(stucode);
/* 77 */     pystu.setUptime(date);
/* 78 */     Transaction ts = dao.getSession().beginTransaction();
/*    */     try {
/* 80 */       dao.getSession().saveOrUpdate(pystu);
/* 81 */       dao.getSession().flush();
/* 82 */       ts.commit();
/* 83 */       dao.getSession().close();
/* 84 */       request.setAttribute("notice", "提交 成功");
/*    */     } catch (RuntimeException re) {
/* 86 */       System.out.println("异常信息：" + re);
/* 87 */       dao.getSession().clear();
/* 88 */       ts.rollback();
/* 89 */       request.setAttribute("notice", "提交失败！！！");
/* 90 */       return mapping.findForward("error");
/*    */     }
/*    */ 
/* 94 */     return mapping.findForward("display");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.stu.PingyustusaveAction
 * JD-Core Version:    0.5.4
 */