/*     */ package com.frame.struts.action.depart;
/*     */ 
/*     */ import com.entity.basedata.ClassList;
/*     */ import com.entity.basedata.ClassListDAO;
/*     */ import com.entity.basedata.DepartList;
/*     */ import com.entity.basedata.DepartListDAO;
/*     */ import com.entity.basedata.StuList;
/*     */ import com.entity.basedata.StuListDAO;
/*     */ import com.entity.basedata.TecList;
/*     */ import com.entity.basedata.TecListDAO;
/*     */ import com.entity.task.Task;
/*     */ import com.entity.task.TaskDAO;
/*     */ import com.entity.wish.ApplyTec;
/*     */ import com.entity.wish.ApplyTecDAO;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.apache.struts.action.Action;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionForward;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ import pub.Qdao;
/*     */ 
/*     */ public class StagetaskexportAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  62 */     HttpSession session = request.getSession();
/*  63 */     if (session.getAttribute("teccode") == null) {
/*  64 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  65 */       return mapping.findForward("error");
/*     */     }
/*  67 */     String teccode = session.getAttribute("teccode").toString();
/*     */ 
/*  70 */     String stucode = request.getParameter("s").toString();
/*  71 */     Integer atid = Integer.valueOf(Integer.parseInt(request.getParameter("atid").toString()));
/*     */ 
/*  73 */     StuList stu = new StuList();
/*  74 */     StuListDAO sdao = new StuListDAO();
/*  75 */     stu = sdao.findById(stucode);
/*  76 */     DepartList depart = new DepartList();
/*  77 */     DepartListDAO ddao = new DepartListDAO();
/*  78 */     depart = ddao.findById(stu.getDepartid());
/*  79 */     Task task = new Task();
/*  80 */     TaskDAO tdao = new TaskDAO();
/*  81 */     task = (Task)tdao.findByStucode(stucode).get(0);
/*  82 */     ApplyTec at = new ApplyTec();
/*  83 */     ApplyTecDAO atdao = new ApplyTecDAO();
/*  84 */     at = atdao.findById(atid);
/*  85 */     TecList tec = new TecList();
/*  86 */     TecListDAO tecdao = new TecListDAO();
/*  87 */     tec = tecdao.findById(teccode);
/*  88 */     ClassList stuclass = new ClassList();
/*  89 */     ClassListDAO stuclassdao = new ClassListDAO();
/*  90 */     stuclass = stuclassdao.findById(stu.getClassid());
/*     */ 
/*  92 */     Date date = new Date();
/*  93 */     SimpleDateFormat year = new SimpleDateFormat("yyyy");
/*  94 */     SimpleDateFormat datenow = new SimpleDateFormat("yyyy年MM月dd日");
/*  95 */     request.setAttribute("departname", depart.getDepartname());
/*  96 */     request.setAttribute("year", year.format(date));
/*  97 */     request.setAttribute("classname", stuclass.getClassnameshort());
/*  98 */     request.setAttribute("stuname", stu.getStuname());
/*  99 */     String datestart = task.getDatestart().substring(0, 4) + "年" + 
/* 100 */       task.getDatestart().substring(5, 7) + "月" + 
/* 101 */       task.getDatestart().substring(8, 10) + "日";
/* 102 */     request.setAttribute("datestart", datestart);
/* 103 */     String dateover = task.getDateover().substring(0, 4) + "年" + 
/* 104 */       task.getDateover().substring(5, 7) + "月" + 
/* 105 */       task.getDateover().substring(8, 10) + "日";
/* 106 */     request.setAttribute("dateover", dateover);
/*     */ 
/* 109 */     int weeks = 0;
/* 110 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
/*     */     try
/*     */     {
/* 114 */       Date dateStart = sdf.parse(task.getDatestart());
/* 115 */       Date dateEnd = sdf.parse(task.getDateover());
/* 116 */       weeks = (int)(1L + (dateEnd.getTime() - dateStart.getTime()) / 86400000L / 7L);
/*     */     }
/*     */     catch (ParseException e) {
/* 119 */       e.printStackTrace();
/* 120 */       request.setAttribute("notice", "计算日期出错！");
/* 121 */       return mapping.findForward("error");
/*     */     }
/*     */     Date dateEnd;
/*     */     Date dateStart;
/* 123 */     request.setAttribute("weeks", Integer.valueOf(weeks));
/*     */ 
/* 127 */     request.setAttribute("title", at.getTitle());
/* 128 */     request.setAttribute("tecname", tec.getTecname());
/* 129 */     request.setAttribute("datenow", datenow.format(date));
/*     */ 
/* 132 */     List stagetasklist = new LinkedList();
/* 133 */     Qdao qdao = new Qdao();
/* 134 */     String hql = "from Stagetask where atid=" + atid + " and stucode='" + stucode + "'";
/* 135 */     stagetasklist.addAll(qdao.query(hql));
/* 136 */     request.setAttribute("stagetasklist", stagetasklist);
/*     */ 
/* 138 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.StagetaskexportAction
 * JD-Core Version:    0.5.4
 */