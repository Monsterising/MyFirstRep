/*    */ package com.frame.struts.action.task;
/*    */ 
/*    */ import com.entity.basedata.ClassList;
/*    */ import com.entity.basedata.ClassListDAO;
/*    */ import com.entity.basedata.DepartList;
/*    */ import com.entity.basedata.DepartListDAO;
/*    */ import com.entity.basedata.StuList;
/*    */ import com.entity.basedata.StuListDAO;
/*    */ import com.entity.basedata.TecList;
/*    */ import com.entity.basedata.TecListDAO;
/*    */ import com.entity.task.StagetaskdayiDAO;
/*    */ import com.entity.wish.ApplyTec;
/*    */ import com.entity.wish.ApplyTecDAO;
/*    */ import com.entity.wish.Xuanti;
/*    */ import com.entity.wish.XuantiDAO;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.apache.struts.action.Action;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ 
/*    */ public class DayiexportAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 57 */     HttpSession session = request.getSession();
/* 58 */     if (session.getAttribute("teccode") == null) {
/* 59 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/* 60 */       return mapping.findForward("error");
/*    */     }
/* 62 */     String teccode = session.getAttribute("teccode").toString();
/*    */ 
/* 65 */     String stucode = request.getParameter("s").toString();
/* 66 */     StuList stu = new StuList();
/* 67 */     StuListDAO sdao = new StuListDAO();
/* 68 */     stu = sdao.findById(stucode);
/*    */ 
/* 70 */     DepartList depart = new DepartList();
/* 71 */     DepartListDAO ddao = new DepartListDAO();
/* 72 */     depart = ddao.findById(stu.getDepartid());
/* 73 */     ClassList stuclass = new ClassList();
/* 74 */     ClassListDAO cdao = new ClassListDAO();
/* 75 */     stuclass = cdao.findById(stu.getClassid());
/* 76 */     Xuanti xuanti = new Xuanti();
/* 77 */     XuantiDAO xdao = new XuantiDAO();
/* 78 */     xuanti = xdao.findById(stucode);
/* 79 */     ApplyTec at = new ApplyTec();
/* 80 */     ApplyTecDAO atdao = new ApplyTecDAO();
/* 81 */     at = atdao.findById(xuanti.getAtid());
/* 82 */     request.setAttribute("stuname", stu.getStuname());
/* 83 */     request.setAttribute("departname", depart.getDepartname());
/* 84 */     request.setAttribute("classname", stuclass.getClassnameshort());
/* 85 */     request.setAttribute("title", at.getTitle());
/*    */ 
/* 87 */     TecList tec = new TecList();
/* 88 */     TecListDAO tecdao = new TecListDAO();
/* 89 */     tec = tecdao.findById(teccode);
/* 90 */     request.setAttribute("tecname", tec.getTecname());
/*    */ 
/* 93 */     StagetaskdayiDAO dayidao = new StagetaskdayiDAO();
/* 94 */     List dayilist = dayidao.findByStucode(stucode);
/* 95 */     request.setAttribute("dayilist", dayilist);
/*    */ 
/* 97 */     return mapping.findForward("display");
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.task.DayiexportAction
 * JD-Core Version:    0.5.4
 */