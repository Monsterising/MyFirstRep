/*    */ package com.frame.struts.action.college;
/*    */ 
/*    */ import com.entity.basedata.ClassList;
/*    */ import com.entity.basedata.ClassListDAO;
/*    */ import com.frame.struts.baseform.AddclassForm;
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
/*    */ public class SaveclassAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 45 */     AddclassForm aform = (AddclassForm)form;
/* 46 */     HttpSession session = request.getSession();
/* 47 */     if (session.getAttribute("adminid") == null) {
/* 48 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 49 */       return mapping.findForward("error");
/*    */     }
/*    */ 
/* 52 */     Integer collegeid = aform.getCollegeid();
/* 53 */     Integer departid = aform.getDepartid();
/* 54 */     Integer gradeid = aform.getGradeid();
/* 55 */     toChi tochi = new toChi();
/* 56 */     Integer classid = aform.getClassid();
/* 57 */     String classname = tochi.toChinese(aform.getClassname());
/* 58 */     String classnameshort = tochi.toChinese(aform.getClassnameshort());
/* 59 */     String op = aform.getOp();
/*    */ 
/* 61 */     ClassList classlist = new ClassList();
/* 62 */     ClassListDAO cdao = new ClassListDAO();
/* 63 */     if ((classid != null) && (op.equals("edit"))) {
/* 64 */       classlist = cdao.findById(classid);
/*    */     }
/* 66 */     classlist.setClassname(classname);
/* 67 */     classlist.setClassnameshort(classnameshort);
/* 68 */     classlist.setCollegeid(collegeid);
/* 69 */     classlist.setDepartid(departid);
/* 70 */     classlist.setGradeid(gradeid);
/*    */ 
/* 72 */     Transaction ts = cdao.getSession().beginTransaction();
/*    */     try {
/* 74 */       cdao.getSession().saveOrUpdate(classlist);
/* 75 */       ts.commit();
/* 76 */       cdao.getSession().flush();
/* 77 */       request.setAttribute("departid", departid);
/* 78 */       request.setAttribute("notice", "设置班级 " + classname + " 资料成功！！！");
/* 79 */       return mapping.findForward("list");
/*    */     } catch (RuntimeException re) {
/* 81 */       System.out.println("异常信息：" + re);
/* 82 */       cdao.getSession().clear();
/* 83 */       ts.rollback();
/* 84 */       request.setAttribute("notice", "添加班级 " + classname + " 资料失败！！！");
/* 85 */     }return mapping.findForward("error");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.SaveclassAction
 * JD-Core Version:    0.5.4
 */