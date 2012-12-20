/*    */ package com.frame.struts.action.pingyue;
/*    */ 
/*    */ import com.entity.basedata.ClassList;
/*    */ import com.entity.basedata.ClassListDAO;
/*    */ import com.entity.basedata.CollegeList;
/*    */ import com.entity.basedata.CollegeListDAO;
/*    */ import com.entity.basedata.DepartList;
/*    */ import com.entity.basedata.DepartListDAO;
/*    */ import com.entity.basedata.GradeList;
/*    */ import com.entity.basedata.GradeListDAO;
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
/*    */ public class PingyuviewereditAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 53 */     HttpSession session = request.getSession();
/* 54 */     if (session.getAttribute("teccode") == null) {
/* 55 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 56 */       return mapping.findForward("error");
/*    */     }
/* 58 */     String teccode = session.getAttribute("teccode").toString();
/* 59 */     String stucode = request.getParameter("s").toString();
/* 60 */     PingyuViewer pv = new PingyuViewer();
/* 61 */     PingyuViewerDAO pdao = new PingyuViewerDAO();
/* 62 */     pv = (PingyuViewer)pdao.findByStucode(stucode).get(0);
/* 63 */     request.setAttribute("pingyu", pv.getPingyu());
/* 64 */     request.setAttribute("pyvid", pv.getPyvid());
/* 65 */     request.setAttribute("departid", request.getParameter("departid").toString());
/*    */ 
/* 70 */     StuList stu = new StuList();
/* 71 */     StuListDAO studao = new StuListDAO();
/* 72 */     stu = studao.findById(stucode);
/* 73 */     DepartList depart = new DepartList();
/* 74 */     DepartListDAO departdao = new DepartListDAO();
/* 75 */     depart = departdao.findById(stu.getDepartid());
/* 76 */     request.setAttribute("StuList", stu);
/* 77 */     request.setAttribute("departname", depart.getDepartname());
/* 78 */     CollegeList college = new CollegeList();
/* 79 */     CollegeListDAO collegedao = new CollegeListDAO();
/* 80 */     college = collegedao.findById(stu.getCollegeid());
/* 81 */     request.setAttribute("collegename", college.getCollegename());
/* 82 */     ClassList stuclass = new ClassList();
/* 83 */     ClassListDAO classdao = new ClassListDAO();
/* 84 */     stuclass = classdao.findById(stu.getClassid());
/* 85 */     request.setAttribute("classname", stuclass.getClassname());
/* 86 */     GradeList grade = new GradeList();
/* 87 */     GradeListDAO gdao = new GradeListDAO();
/* 88 */     grade = gdao.findById(stu.getGradeid());
/* 89 */     request.setAttribute("gradename", grade.getGradename());
/* 90 */     request.setAttribute("stucode", stu.getStucode());
/*    */ 
/* 92 */     return mapping.findForward("display");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.pingyue.PingyuviewereditAction
 * JD-Core Version:    0.5.4
 */