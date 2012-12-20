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
/*     */ import com.entity.basedata.GradeList;
/*     */ import com.entity.basedata.GradeListDAO;
/*     */ import com.entity.basedata.StuList;
/*     */ import com.entity.basedata.StuListDAO;
/*     */ import com.entity.task.Task;
/*     */ import com.entity.task.TaskDAO;
/*     */ import com.entity.wish.ApplyNumGrade;
/*     */ import com.entity.wish.ApplyNumGradeDAO;
/*     */ import com.entity.wish.ApplyResultDAO;
/*     */ import com.entity.wish.ApplyTec;
/*     */ import com.entity.wish.ApplyTecDAO;
/*     */ import com.entity.wish.ApplyTecResult;
/*     */ import com.entity.wish.ApplyType;
/*     */ import com.entity.wish.ApplyTypeDAO;
/*     */ import com.frame.struts.form.wish.KetishenbaoForm;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.apache.struts.action.Action;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionForward;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ import org.hibernate.Session;
/*     */ import pub.Qdao;
/*     */ 
/*     */ public class TaskeditAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  73 */     HttpSession session = request.getSession();
/*  74 */     if (session.getAttribute("teccode") == null) {
/*  75 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  76 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  79 */     KetishenbaoForm kform = (KetishenbaoForm)form;
/*  80 */     Integer taskid = Integer.valueOf(Integer.parseInt(request.getParameter("t")));
/*  81 */     Integer atid = Integer.valueOf(Integer.parseInt(request.getParameter("atid")));
/*  82 */     Task task = new Task();
/*  83 */     TaskDAO tdao = new TaskDAO();
/*  84 */     if (tdao.getSession().get(Task.class, taskid) != null) {
/*  85 */       task = (Task)tdao.getSession().get(Task.class, taskid);
/*     */     }
/*  87 */     request.setAttribute("Task", task);
/*     */ 
/*  89 */     String stucode = request.getParameter("s");
/*  90 */     Integer departid = task.getDepartid();
/*  91 */     Integer collegeid = task.getCollegeid();
/*  92 */     StuList stu = new StuList();
/*  93 */     StuListDAO studao = new StuListDAO();
/*  94 */     stu = studao.findById(stucode);
/*  95 */     DepartList depart = new DepartList();
/*  96 */     DepartListDAO departdao = new DepartListDAO();
/*  97 */     depart = departdao.findById(departid);
/*  98 */     request.setAttribute("StuList", stu);
/*  99 */     request.setAttribute("departname", depart.getDepartname());
/* 100 */     CollegeList college = new CollegeList();
/* 101 */     CollegeListDAO collegedao = new CollegeListDAO();
/* 102 */     college = collegedao.findById(collegeid);
/* 103 */     request.setAttribute("collegename", college.getCollegename());
/* 104 */     ClassList stuclass = new ClassList();
/* 105 */     ClassListDAO classdao = new ClassListDAO();
/* 106 */     stuclass = classdao.findById(stu.getClassid());
/* 107 */     request.setAttribute("classname", stuclass.getClassname());
/*     */ 
/* 109 */     request.setAttribute("yaoqiu", task.getYaoqiu());
/* 110 */     request.setAttribute("neirong", task.getNeirong());
/* 111 */     request.setAttribute("ziliao", task.getZiliao());
/* 112 */     request.setAttribute("datefagei", task.getDatefagei());
/*     */ 
/* 114 */     CollegeSetup cs = new CollegeSetup();
/* 115 */     CollegeSetupDAO csdao = new CollegeSetupDAO();
/* 116 */     cs = csdao.findById(collegeid);
/* 117 */     if (cs != null) {
/* 118 */       request.setAttribute("datestart", cs.getDatestart());
/* 119 */       request.setAttribute("dateover", cs.getDateover());
/*     */     }
/*     */ 
/* 125 */     ApplyTec applytec = new ApplyTec();
/* 126 */     ApplyTecDAO atdao = new ApplyTecDAO();
/* 127 */     applytec = atdao.findById(atid);
/* 128 */     request.setAttribute("ApplyTec", applytec);
/*     */ 
/* 130 */     request.setAttribute("title", applytec.getTitle());
/*     */ 
/* 132 */     request.setAttribute("tecprof", applytec.getTecprof());
/*     */ 
/* 135 */     List atrlist = new LinkedList();
/* 136 */     String hql = "from ApplyTecResult where atid=" + atid;
/* 137 */     Qdao qdao = new Qdao();
/* 138 */     atrlist.addAll(qdao.query(hql));
/* 139 */     Integer[] resultids = new Integer[atrlist.size()];
/* 140 */     for (int k = 0; k < atrlist.size(); ++k) {
/* 141 */       resultids[k] = ((ApplyTecResult)atrlist.get(k)).getResultid();
/*     */     }
/* 143 */     kform.setResultids(resultids);
/* 144 */     request.setAttribute("KetishenbaoForm", kform);
/*     */ 
/* 146 */     ApplyType applytype = new ApplyType();
/* 147 */     ApplyTypeDAO typedao = new ApplyTypeDAO();
/* 148 */     List applytypelist = typedao.findByDepartid(departid);
/* 149 */     request.setAttribute("applytypelist", applytypelist);
/*     */ 
/* 151 */     ApplyNumGrade ang = new ApplyNumGrade();
/* 152 */     ApplyNumGradeDAO adao = new ApplyNumGradeDAO();
/* 153 */     ang = adao.findById(departid);
/* 154 */     GradeList grade = new GradeList();
/* 155 */     GradeListDAO gdao = new GradeListDAO();
/* 156 */     grade = gdao.findById(ang.getGradeid());
/* 157 */     request.setAttribute("gradename", grade.getGradename());
/*     */ 
/* 159 */     List departlist = departdao.findByCollegeid(collegeid);
/* 160 */     request.setAttribute("departlist", departlist);
/*     */ 
/* 162 */     request.setAttribute("disable", "disabled");
/*     */ 
/* 164 */     ApplyResultDAO ardao = new ApplyResultDAO();
/* 165 */     List applyresultlist = new LinkedList();
/* 166 */     hql = "from ApplyResult where departid in (" + departid + ")";
/* 167 */     applyresultlist.addAll(qdao.query(hql));
/* 168 */     request.setAttribute("applyresultlist", applyresultlist);
/*     */ 
/* 171 */     request.setAttribute("taskid", task.getTaskid());
/* 172 */     request.setAttribute("op", "taskedit");
/* 173 */     request.setAttribute("GradeList", grade);
/* 174 */     request.setAttribute("atid", atid);
/*     */ 
/* 176 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.TaskeditAction
 * JD-Core Version:    0.5.4
 */