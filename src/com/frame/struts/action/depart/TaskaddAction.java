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
/*     */ import com.entity.wish.ApplyNumGrade;
/*     */ import com.entity.wish.ApplyNumGradeDAO;
/*     */ import com.entity.wish.ApplyResultDAO;
/*     */ import com.entity.wish.ApplyTec;
/*     */ import com.entity.wish.ApplyTecDAO;
/*     */ import com.entity.wish.ApplyTecResult;
/*     */ import com.entity.wish.ApplyType;
/*     */ import com.entity.wish.ApplyTypeDAO;
/*     */ import com.frame.struts.form.wish.KetishenbaoForm;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.struts.action.Action;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionForward;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ import pub.Qdao;
/*     */ 
/*     */ public class TaskaddAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  69 */     KetishenbaoForm kform = (KetishenbaoForm)form;
/*     */ 
/*  71 */     Integer atid = Integer.valueOf(Integer.parseInt(request.getParameter("atid").toString()));
/*  72 */     String stucode = request.getParameter("s").toString();
/*     */ 
/*  75 */     ApplyTec applytec = new ApplyTec();
/*  76 */     ApplyTecDAO atdao = new ApplyTecDAO();
/*  77 */     applytec = atdao.findById(atid);
/*  78 */     Integer departid = applytec.getDepartid();
/*  79 */     Integer collegeid = applytec.getCollegeid();
/*  80 */     request.setAttribute("ApplyTec", applytec);
/*     */ 
/*  82 */     request.setAttribute("title", applytec.getTitle());
/*  83 */     request.setAttribute("yaoqiu", applytec.getPreparework());
/*  84 */     request.setAttribute("neirong", applytec.getContent());
/*  85 */     request.setAttribute("tecprof", applytec.getTecprof());
/*     */ 
/*  88 */     request.setAttribute("ziliao", 
/*  89 */       "原始资料：是指导教师给学生推荐的参考文献（一般不少于5篇，其中英文原文参考文献至少2篇）、设计标准等。");
/*  90 */     request.setAttribute("yaoqiu", 
/*  91 */       "设计或论文要求：指导教师应为学生指明本课题要解决的主要问题和大体上可从哪几个方面去研究和论述该主要问题。表述要明确、具体，要具有引导性、启发性，并应给学生留下独立思考和创造的余地。");
/*  92 */     request.setAttribute("neirong", 
/*  93 */       "设计或论文内容：A设计图纸（总平面规划图、规划设计分析图、建筑群体方案图……）、设计说明书等；B 演示软件（光盘）、程序清单、设计说明书（论文）；C 论文（2万字以上）。");
/*     */ 
/*  97 */     CollegeSetup cs = new CollegeSetup();
/*  98 */     CollegeSetupDAO csdao = new CollegeSetupDAO();
/*  99 */     cs = csdao.findById(collegeid);
/* 100 */     if (cs != null) {
/* 101 */       request.setAttribute("datestart", cs.getDatestart());
/* 102 */       request.setAttribute("dateover", cs.getDateover());
/*     */     }
/* 104 */     Date date = new Date();
/* 105 */     SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 106 */     String dateup = sf.format(date);
/* 107 */     request.setAttribute("datefagei", dateup);
/*     */ 
/* 112 */     StuList stu = new StuList();
/* 113 */     StuListDAO studao = new StuListDAO();
/* 114 */     stu = studao.findById(stucode);
/* 115 */     DepartList depart = new DepartList();
/* 116 */     DepartListDAO departdao = new DepartListDAO();
/* 117 */     depart = departdao.findById(departid);
/* 118 */     request.setAttribute("StuList", stu);
/* 119 */     request.setAttribute("departname", depart.getDepartname());
/* 120 */     CollegeList college = new CollegeList();
/* 121 */     CollegeListDAO collegedao = new CollegeListDAO();
/* 122 */     college = collegedao.findById(collegeid);
/* 123 */     request.setAttribute("collegename", college.getCollegename());
/* 124 */     ClassList stuclass = new ClassList();
/* 125 */     ClassListDAO classdao = new ClassListDAO();
/* 126 */     stuclass = classdao.findById(stu.getClassid());
/* 127 */     request.setAttribute("classname", stuclass.getClassname());
/*     */ 
/* 131 */     List atrlist = new LinkedList();
/* 132 */     String hql = "from ApplyTecResult where atid=" + applytec.getAtid();
/* 133 */     Qdao qdao = new Qdao();
/* 134 */     atrlist.addAll(qdao.query(hql));
/* 135 */     Integer[] resultids = new Integer[atrlist.size()];
/* 136 */     for (int k = 0; k < atrlist.size(); ++k) {
/* 137 */       resultids[k] = ((ApplyTecResult)atrlist.get(k)).getResultid();
/*     */     }
/* 139 */     kform.setResultids(resultids);
/* 140 */     request.setAttribute("KetishenbaoForm", kform);
/*     */ 
/* 142 */     ApplyType applytype = new ApplyType();
/* 143 */     ApplyTypeDAO typedao = new ApplyTypeDAO();
/* 144 */     List applytypelist = typedao.findByDepartid(departid);
/* 145 */     request.setAttribute("applytypelist", applytypelist);
/*     */ 
/* 147 */     ApplyNumGrade ang = new ApplyNumGrade();
/* 148 */     ApplyNumGradeDAO adao = new ApplyNumGradeDAO();
/* 149 */     ang = adao.findById(departid);
/* 150 */     GradeList grade = new GradeList();
/* 151 */     GradeListDAO gdao = new GradeListDAO();
/* 152 */     grade = gdao.findById(ang.getGradeid());
/* 153 */     request.setAttribute("gradename", grade.getGradename());
/*     */ 
/* 155 */     List departlist = departdao.findByCollegeid(collegeid);
/* 156 */     request.setAttribute("departlist", departlist);
/*     */ 
/* 158 */     request.setAttribute("disable", "disabled");
/*     */ 
/* 160 */     ApplyResultDAO ardao = new ApplyResultDAO();
/* 161 */     List applyresultlist = new LinkedList();
/* 162 */     hql = "from ApplyResult where departid in (" + departid + ")";
/* 163 */     applyresultlist.addAll(qdao.query(hql));
/* 164 */     request.setAttribute("applyresultlist", applyresultlist);
/*     */ 
/* 170 */     request.setAttribute("taskid", Integer.valueOf(0));
/* 171 */     request.setAttribute("op", "taskadd");
/* 172 */     request.setAttribute("GradeList", grade);
/* 173 */     request.setAttribute("atid", applytec.getAtid());
/*     */ 
/* 179 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.TaskaddAction
 * JD-Core Version:    0.5.4
 */