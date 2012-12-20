/*     */ package com.frame.struts.action.depart;
/*     */ 
/*     */ import com.entity.basedata.ClassList;
/*     */ import com.entity.basedata.ClassListDAO;
/*     */ import com.entity.basedata.CollegeList;
/*     */ import com.entity.basedata.CollegeListDAO;
/*     */ import com.entity.basedata.CollegeSetup;
/*     */ import com.entity.basedata.CollegeSetupDAO;
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
/*     */ import com.frame.struts.form.task.TaskForm;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.struts.action.Action;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionForward;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ import org.hibernate.Session;
/*     */ 
/*     */ public class TaskexportAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  56 */     TaskForm taskForm = (TaskForm)form;
/*  57 */     Integer taskid = Integer.valueOf(Integer.parseInt(request.getParameter("t")));
/*  58 */     Integer atid = Integer.valueOf(Integer.parseInt(request.getParameter("atid")));
/*  59 */     Task task = new Task();
/*  60 */     TaskDAO tdao = new TaskDAO();
/*  61 */     if (tdao.getSession().get(Task.class, taskid) != null) {
/*  62 */       task = (Task)tdao.getSession().get(Task.class, taskid);
/*     */     }
/*  64 */     request.setAttribute("Task", task);
/*     */ 
/*  66 */     String stucode = request.getParameter("s");
/*  67 */     Integer departid = task.getDepartid();
/*  68 */     Integer collegeid = task.getCollegeid();
/*  69 */     StuList stu = new StuList();
/*  70 */     StuListDAO studao = new StuListDAO();
/*  71 */     stu = studao.findById(stucode);
/*  72 */     DepartList depart = new DepartList();
/*  73 */     DepartListDAO departdao = new DepartListDAO();
/*  74 */     depart = departdao.findById(departid);
/*  75 */     request.setAttribute("StuList", stu);
/*  76 */     request.setAttribute("stuname", stu.getStuname());
/*  77 */     request.setAttribute("departname", depart.getDepartname());
/*  78 */     CollegeList college = new CollegeList();
/*  79 */     CollegeListDAO collegedao = new CollegeListDAO();
/*  80 */     college = collegedao.findById(collegeid);
/*  81 */     request.setAttribute("collegename", college.getCollegename());
/*  82 */     ClassList stuclass = new ClassList();
/*  83 */     ClassListDAO classdao = new ClassListDAO();
/*  84 */     stuclass = classdao.findById(stu.getClassid());
/*  85 */     request.setAttribute("classname", stuclass.getClassname());
/*     */ 
/*  87 */     request.setAttribute("yaoqiu", task.getYaoqiu());
/*  88 */     request.setAttribute("neirong", task.getNeirong());
/*  89 */     request.setAttribute("ziliao", task.getZiliao());
/*     */ 
/*  91 */     String datefagei = task.getDatefagei().substring(0, 4) + "年" + 
/*  92 */       task.getDatefagei().substring(5, 7) + "月" + 
/*  93 */       task.getDatefagei().substring(8, 10) + "日";
/*  94 */     request.setAttribute("datefagei", datefagei);
/*     */ 
/*  96 */     CollegeSetup cs = new CollegeSetup();
/*  97 */     CollegeSetupDAO csdao = new CollegeSetupDAO();
/*  98 */     cs = csdao.findById(collegeid);
/*  99 */     String dateover = "";
/* 100 */     String datestart = "";
/* 101 */     if (cs != null) {
/* 102 */       datestart = cs.getDatestart();
/* 103 */       dateover = cs.getDateover();
/*     */ 
/* 105 */       dateover = dateover.substring(0, 4) + "年" + 
/* 106 */         dateover.substring(5, 7) + "月" + 
/* 107 */         dateover.substring(8, 10) + "日";
/*     */ 
/* 109 */       datestart = datestart.substring(0, 4) + "年" + 
/* 110 */         datestart.substring(5, 7) + "月" + 
/* 111 */         datestart.substring(8, 10) + "日";
/*     */ 
/* 114 */       request.setAttribute("datestart", datestart);
/* 115 */       request.setAttribute("dateover", dateover);
/*     */     }
/*     */ 
/* 123 */     ApplyTec applytec = new ApplyTec();
/* 124 */     ApplyTecDAO atdao = new ApplyTecDAO();
/* 125 */     applytec = atdao.findById(atid);
/* 126 */     request.setAttribute("ApplyTec", applytec);
/* 127 */     request.setAttribute("title", applytec.getTitle());
/* 128 */     request.setAttribute("tecprof", applytec.getTecprof());
/*     */ 
/* 130 */     String teccode = applytec.getTeccode();
/* 131 */     TecList tec = new TecList();
/* 132 */     TecListDAO tecdao = new TecListDAO();
/* 133 */     tec = tecdao.findById(teccode);
/* 134 */     request.setAttribute("tecname", tec.getTecname());
/*     */ 
/* 136 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.TaskexportAction
 * JD-Core Version:    0.5.4
 */