/*     */ package com.frame.struts.action.dabian;
/*     */ 
/*     */ import com.entity.basedata.ClassList;
/*     */ import com.entity.basedata.ClassListDAO;
/*     */ import com.entity.basedata.CollegeList;
/*     */ import com.entity.basedata.CollegeListDAO;
/*     */ import com.entity.basedata.DepartList;
/*     */ import com.entity.basedata.DepartListDAO;
/*     */ import com.entity.basedata.StuList;
/*     */ import com.entity.basedata.StuListDAO;
/*     */ import com.entity.dabian.DabianChengji;
/*     */ import com.entity.dabian.DabianChengjiDAO;
/*     */ import com.entity.wish.ApplyTec;
/*     */ import com.entity.wish.ApplyTecDAO;
/*     */ import com.entity.wish.Xuanti;
/*     */ import com.entity.wish.XuantiDAO;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.apache.struts.action.Action;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionForward;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class ChengjiexportAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  59 */     HttpSession session = request.getSession();
/*  60 */     if (session.getAttribute("teccode") == null) {
/*  61 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  62 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  67 */     String stucode = request.getParameter("s").toString();
/*     */ 
/*  70 */     StuList stu = new StuList();
/*  71 */     StuListDAO sdao = new StuListDAO();
/*  72 */     stu = sdao.findById(stucode);
/*  73 */     CollegeList college = new CollegeList();
/*  74 */     CollegeListDAO collegedao = new CollegeListDAO();
/*  75 */     college = collegedao.findById(stu.getCollegeid());
/*  76 */     DepartList depart = new DepartList();
/*  77 */     DepartListDAO ddao = new DepartListDAO();
/*  78 */     depart = ddao.findById(stu.getDepartid());
/*  79 */     ClassList stuclass = new ClassList();
/*  80 */     ClassListDAO cdao = new ClassListDAO();
/*  81 */     stuclass = cdao.findById(stu.getClassid());
/*  82 */     Xuanti xuanti = new Xuanti();
/*  83 */     XuantiDAO xdao = new XuantiDAO();
/*  84 */     xuanti = xdao.findById(stucode);
/*  85 */     ApplyTec at = new ApplyTec();
/*  86 */     ApplyTecDAO atdao = new ApplyTecDAO();
/*  87 */     at = atdao.findById(xuanti.getAtid());
/*  88 */     request.setAttribute("stuname", stu.getStuname());
/*  89 */     request.setAttribute("collegename", college.getCollegename());
/*  90 */     request.setAttribute("departname", depart.getDepartname());
/*  91 */     request.setAttribute("classname", stuclass.getClassnameshort());
/*  92 */     request.setAttribute("title", at.getTitle());
/*     */ 
/*  94 */     DabianChengji pyv = new DabianChengji();
/*  95 */     DabianChengjiDAO pdao = new DabianChengjiDAO();
/*  96 */     pyv = (DabianChengji)pdao.findByStucode(stucode).get(0);
/*  97 */     request.setAttribute("pingyu", pyv.getPingyu());
/*  98 */     request.setAttribute("chengji", pyv.getChengji());
/*     */ 
/* 100 */     SimpleDateFormat year = new SimpleDateFormat("yyyy年MM月dd日");
/* 101 */     request.setAttribute("uptime", year.format(pyv.getChengjitime()));
/*     */ 
/* 103 */     return mapping.findForward("export");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.dabian.ChengjiexportAction
 * JD-Core Version:    0.5.4
 */