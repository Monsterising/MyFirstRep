/*    */ package com.frame.struts.action.college;
/*    */ 
/*    */ import com.entity.basedata.StuList;
/*    */ import com.entity.basedata.StuListDAO;
/*    */ import com.frame.struts.baseform.AddstuForm;
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
/*    */ public class SavestuAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 47 */     AddstuForm aform = (AddstuForm)form;
/* 48 */     HttpSession session = request.getSession();
/* 49 */     if (session.getAttribute("adminid") == null) {
/* 50 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 51 */       return mapping.findForward("error");
/*    */     }
/*    */ 
/* 54 */     Integer collegeid = aform.getCollegeid();
/* 55 */     Integer departid = aform.getDepartid();
/* 56 */     Integer gradeid = aform.getGradeid();
/* 57 */     toChi tochi = new toChi();
/* 58 */     Integer classid = aform.getClassid();
/* 59 */     String stuname = tochi.toChinese(aform.getStuname());
/* 60 */     String stucode = tochi.toChinese(aform.getStucode());
/* 61 */     String stupass = tochi.toChinese(aform.getStupass());
/* 62 */     String stusex = tochi.toChinese(aform.getStusex());
/* 63 */     String op = aform.getOp();
/* 64 */     String stucodehidden = tochi.toChinese(aform.getStucodehidden());
/*    */ 
/* 66 */     StuList stulist = new StuList();
/* 67 */     StuListDAO cdao = new StuListDAO();
/* 68 */     if (op.equals("edit")) {
/* 69 */       stulist = cdao.findById(stucodehidden);
/*    */     }
/* 71 */     stulist.setCollegeid(collegeid);
/* 72 */     stulist.setDepartid(departid);
/* 73 */     stulist.setGradeid(gradeid);
/* 74 */     stulist.setClassid(classid);
/* 75 */     stulist.setStucode(stucode);
/* 76 */     stulist.setStuname(stuname);
/* 77 */     stulist.setStupass(stupass);
/* 78 */     stulist.setStusex(stusex);
/*    */ 
/* 80 */     Transaction ts = cdao.getSession().beginTransaction();
/*    */     try {
/* 82 */       cdao.getSession().saveOrUpdate(stulist);
/* 83 */       ts.commit();
/* 84 */       cdao.getSession().flush();
/* 85 */       request.setAttribute("departid", departid);
/* 86 */       request.setAttribute("gradeid", gradeid);
/* 87 */       request.setAttribute("classid", classid);
/* 88 */       request.setAttribute("op", "list");
/* 89 */       request.setAttribute("notice", "设置学生 " + stuname + " 资料成功！！！");
/* 90 */       return mapping.findForward("list");
/*    */     } catch (RuntimeException re) {
/* 92 */       System.out.println("异常信息：" + re);
/* 93 */       cdao.getSession().clear();
/* 94 */       ts.rollback();
/* 95 */       request.setAttribute("notice", "添加学生 " + stuname + " 资料失败！！！");
/* 96 */     }return mapping.findForward("error");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.SavestuAction
 * JD-Core Version:    0.5.4
 */