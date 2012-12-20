/*    */ package com.frame.struts.action.depart;
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
/*    */ import com.entity.pingyue.PingyuTec;
/*    */ import com.entity.pingyue.PingyuTecDAO;
/*    */ import com.frame.struts.form.pingyue.PingyutecForm;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.apache.struts.action.Action;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ 
/*    */ public class PingyuteceditAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 55 */     PingyutecForm pingyutecForm = (PingyutecForm)form;
/* 56 */     HttpSession session = request.getSession();
/* 57 */     if (session.getAttribute("teccode") == null) {
/* 58 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 59 */       return mapping.findForward("error");
/*    */     }
/* 61 */     String teccode = session.getAttribute("teccode").toString();
/* 62 */     String stucode = request.getParameter("s").toString();
/* 63 */     PingyuTec pt = new PingyuTec();
/* 64 */     PingyuTecDAO pdao = new PingyuTecDAO();
/* 65 */     pt = (PingyuTec)pdao.findByStucode(stucode).get(0);
/* 66 */     request.setAttribute("pingyu", pt.getPingyu());
/* 67 */     request.setAttribute("pytid", pt.getPytid());
/* 68 */     request.setAttribute("chengji", pt.getChengji());
/* 69 */     request.setAttribute("departid", request.getParameter("departid").toString());
/*    */ 
/* 75 */     StuList stu = new StuList();
/* 76 */     StuListDAO studao = new StuListDAO();
/* 77 */     stu = studao.findById(stucode);
/* 78 */     DepartList depart = new DepartList();
/* 79 */     DepartListDAO departdao = new DepartListDAO();
/* 80 */     depart = departdao.findById(stu.getDepartid());
/* 81 */     request.setAttribute("StuList", stu);
/* 82 */     request.setAttribute("departname", depart.getDepartname());
/* 83 */     CollegeList college = new CollegeList();
/* 84 */     CollegeListDAO collegedao = new CollegeListDAO();
/* 85 */     college = collegedao.findById(stu.getCollegeid());
/* 86 */     request.setAttribute("collegename", college.getCollegename());
/* 87 */     ClassList stuclass = new ClassList();
/* 88 */     ClassListDAO classdao = new ClassListDAO();
/* 89 */     stuclass = classdao.findById(stu.getClassid());
/* 90 */     request.setAttribute("classname", stuclass.getClassname());
/* 91 */     GradeList grade = new GradeList();
/* 92 */     GradeListDAO gdao = new GradeListDAO();
/* 93 */     grade = gdao.findById(stu.getGradeid());
/* 94 */     request.setAttribute("gradename", grade.getGradename());
/* 95 */     request.setAttribute("stucode", stu.getStucode());
/*    */ 
/* 97 */     return mapping.findForward("display");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.PingyuteceditAction
 * JD-Core Version:    0.5.4
 */