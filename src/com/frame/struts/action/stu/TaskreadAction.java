/*     */ package com.frame.struts.action.stu;
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
/*     */ import com.entity.wish.Xuanti;
/*     */ import com.entity.wish.XuantiDAO;
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
/*     */ public class TaskreadAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  71 */     HttpSession session = request.getSession();
/*  72 */     if (session.getAttribute("stucode") == null) {
/*  73 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  74 */       return mapping.findForward("error");
/*     */     }
/*  76 */     KetishenbaoForm kform = (KetishenbaoForm)form;
/*  77 */     String stucode = session.getAttribute("stucode").toString();
/*     */ 
/*  82 */     Task task = new Task();
/*  83 */     TaskDAO tdao = new TaskDAO();
/*  84 */     if (tdao.findByStucode(stucode).size() == 0) {
/*  85 */       request.setAttribute("notice", "还未下达任务书！");
/*  86 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  89 */     task = (Task)tdao.findByStucode(stucode).get(0);
/*     */ 
/*  92 */     request.setAttribute("Task", task);
/*     */ 
/*  94 */     Integer departid = task.getDepartid();
/*  95 */     Integer collegeid = task.getCollegeid();
/*  96 */     StuList stu = new StuList();
/*  97 */     StuListDAO studao = new StuListDAO();
/*  98 */     stu = studao.findById(stucode);
/*  99 */     DepartList depart = new DepartList();
/* 100 */     DepartListDAO departdao = new DepartListDAO();
/* 101 */     depart = departdao.findById(departid);
/* 102 */     request.setAttribute("StuList", stu);
/* 103 */     request.setAttribute("departname", depart.getDepartname());
/* 104 */     CollegeList college = new CollegeList();
/* 105 */     CollegeListDAO collegedao = new CollegeListDAO();
/* 106 */     college = collegedao.findById(collegeid);
/* 107 */     request.setAttribute("collegename", college.getCollegename());
/* 108 */     ClassList stuclass = new ClassList();
/* 109 */     ClassListDAO classdao = new ClassListDAO();
/* 110 */     stuclass = classdao.findById(stu.getClassid());
/* 111 */     request.setAttribute("classname", stuclass.getClassname());
/*     */ 
/* 113 */     request.setAttribute("yaoqiu", task.getYaoqiu());
/* 114 */     request.setAttribute("neirong", task.getNeirong());
/* 115 */     request.setAttribute("ziliao", task.getZiliao());
/* 116 */     request.setAttribute("datefagei", task.getDatefagei());
/*     */ 
/* 118 */     CollegeSetup cs = new CollegeSetup();
/* 119 */     CollegeSetupDAO csdao = new CollegeSetupDAO();
/* 120 */     cs = csdao.findById(collegeid);
/* 121 */     if (cs != null) {
/* 122 */       request.setAttribute("datestart", cs.getDatestart());
/* 123 */       request.setAttribute("dateover", cs.getDateover());
/*     */     }
/*     */ 
/* 131 */     Integer atid = Integer.valueOf(0);
/* 132 */     XuantiDAO xdao = new XuantiDAO();
/* 133 */     if (xdao.getSession().get(Xuanti.class, stucode) != null) {
/* 134 */       atid = xdao.findById(stucode).getAtid();
/*     */     } else {
/* 136 */       request.setAttribute("notice", "您还没有确定毕业课题！");
/* 137 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/* 140 */     ApplyTec applytec = new ApplyTec();
/* 141 */     ApplyTecDAO atdao = new ApplyTecDAO();
/* 142 */     applytec = atdao.findById(atid);
/* 143 */     request.setAttribute("ApplyTec", applytec);
/*     */ 
/* 145 */     request.setAttribute("title", applytec.getTitle());
/* 146 */     request.setAttribute("tecprof", applytec.getTecprof());
/*     */ 
/* 149 */     List atrlist = new LinkedList();
/* 150 */     String hql = "from ApplyTecResult where atid=" + atid;
/* 151 */     Qdao qdao = new Qdao();
/* 152 */     atrlist.addAll(qdao.query(hql));
/* 153 */     Integer[] resultids = new Integer[atrlist.size()];
/* 154 */     for (int k = 0; k < atrlist.size(); ++k) {
/* 155 */       resultids[k] = ((ApplyTecResult)atrlist.get(k)).getResultid();
/*     */     }
/* 157 */     kform.setResultids(resultids);
/* 158 */     request.setAttribute("KetishenbaoForm", kform);
/*     */ 
/* 160 */     ApplyType applytype = new ApplyType();
/* 161 */     ApplyTypeDAO typedao = new ApplyTypeDAO();
/* 162 */     List applytypelist = typedao.findByDepartid(departid);
/* 163 */     request.setAttribute("applytypelist", applytypelist);
/*     */ 
/* 165 */     ApplyNumGrade ang = new ApplyNumGrade();
/* 166 */     ApplyNumGradeDAO adao = new ApplyNumGradeDAO();
/* 167 */     ang = adao.findById(departid);
/* 168 */     GradeList grade = new GradeList();
/* 169 */     GradeListDAO gdao = new GradeListDAO();
/* 170 */     grade = gdao.findById(ang.getGradeid());
/* 171 */     request.setAttribute("gradename", grade.getGradename());
/*     */ 
/* 173 */     List departlist = departdao.findByCollegeid(collegeid);
/* 174 */     request.setAttribute("departlist", departlist);
/*     */ 
/* 176 */     request.setAttribute("disable", "disabled");
/*     */ 
/* 178 */     ApplyResultDAO ardao = new ApplyResultDAO();
/* 179 */     List applyresultlist = new LinkedList();
/* 180 */     hql = "from ApplyResult where departid in (" + departid + ")";
/* 181 */     applyresultlist.addAll(qdao.query(hql));
/* 182 */     request.setAttribute("applyresultlist", applyresultlist);
/*     */ 
/* 186 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.stu.TaskreadAction
 * JD-Core Version:    0.5.4
 */