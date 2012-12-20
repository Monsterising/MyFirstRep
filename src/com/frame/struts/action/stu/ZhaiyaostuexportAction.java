/*     */ package com.frame.struts.action.stu;
/*     */ 
/*     */ import com.entity.basedata.ClassList;
/*     */ import com.entity.basedata.ClassListDAO;
/*     */ import com.entity.basedata.CollegeList;
/*     */ import com.entity.basedata.CollegeListDAO;
/*     */ import com.entity.basedata.DepartList;
/*     */ import com.entity.basedata.DepartListDAO;
/*     */ import com.entity.basedata.GradeList;
/*     */ import com.entity.basedata.GradeListDAO;
/*     */ import com.entity.basedata.StuList;
/*     */ import com.entity.basedata.StuListDAO;
/*     */ import com.entity.basedata.TecList;
/*     */ import com.entity.basedata.TecListDAO;
/*     */ import com.entity.dabian.Zhaiyao;
/*     */ import com.entity.dabian.ZhaiyaoDAO;
/*     */ import com.entity.wish.ApplyTec;
/*     */ import com.entity.wish.ApplyTecDAO;
/*     */ import com.entity.wish.Xuanti;
/*     */ import com.entity.wish.XuantiDAO;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.apache.struts.action.Action;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionForward;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ import org.hibernate.Session;
/*     */ import pub.toChi;
/*     */ 
/*     */ public class ZhaiyaostuexportAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  61 */     HttpSession session = request.getSession();
/*  62 */     if (session.getAttribute("stucode") == null) {
/*  63 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  64 */       return mapping.findForward("error");
/*     */     }
/*  66 */     String stucode = session.getAttribute("stucode").toString();
/*     */ 
/*  68 */     Xuanti xuanti = new Xuanti();
/*  69 */     XuantiDAO xdao = new XuantiDAO();
/*  70 */     if (xdao.getSession().get(Xuanti.class, stucode) == null) {
/*  71 */       request.setAttribute("notice", "你尚未确定选题");
/*  72 */       return mapping.findForward("error");
/*     */     }
/*  74 */     xuanti = xdao.findById(stucode);
/*  75 */     ApplyTec at = new ApplyTec();
/*  76 */     ApplyTecDAO atdao = new ApplyTecDAO();
/*  77 */     at = atdao.findById(xuanti.getAtid());
/*  78 */     request.setAttribute("title", at.getTitle());
/*     */ 
/*  83 */     toChi tochi = new toChi();
/*  84 */     Zhaiyao zy = new Zhaiyao();
/*  85 */     ZhaiyaoDAO zydao = new ZhaiyaoDAO();
/*  86 */     if (zydao.getSession().get(Zhaiyao.class, stucode) != null) {
/*  87 */       zy = zydao.findById(stucode);
/*  88 */       request.setAttribute("zhaiyao", zy.getContent());
/*  89 */       if (!zy.getKeyword().equals("")) {
/*  90 */         String keywords = zy.getKeyword();
/*  91 */         keywords = keywords.replace("；", "&nbsp;&nbsp;");
/*  92 */         request.setAttribute("keywords", keywords);
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/*  97 */       request.setAttribute("notice", "你尚未填写摘要");
/*  98 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/* 102 */     StuList stu = new StuList();
/* 103 */     StuListDAO studao = new StuListDAO();
/* 104 */     stu = studao.findById(stucode);
/* 105 */     DepartList depart = new DepartList();
/* 106 */     DepartListDAO departdao = new DepartListDAO();
/* 107 */     depart = departdao.findById(stu.getDepartid());
/* 108 */     request.setAttribute("departname", depart.getDepartname());
/* 109 */     CollegeList college = new CollegeList();
/* 110 */     CollegeListDAO collegedao = new CollegeListDAO();
/* 111 */     college = collegedao.findById(stu.getCollegeid());
/* 112 */     request.setAttribute("collegename", college.getCollegename());
/* 113 */     ClassList stuclass = new ClassList();
/* 114 */     ClassListDAO classdao = new ClassListDAO();
/* 115 */     stuclass = classdao.findById(stu.getClassid());
/* 116 */     request.setAttribute("classname", stuclass.getClassname());
/* 117 */     GradeList grade = new GradeList();
/* 118 */     GradeListDAO gdao = new GradeListDAO();
/* 119 */     grade = gdao.findById(stu.getGradeid());
/* 120 */     request.setAttribute("gradename", grade.getGradename());
/* 121 */     request.setAttribute("stuname", stu.getStuname());
/*     */ 
/* 124 */     TecList tec = new TecList();
/* 125 */     TecListDAO tdao = new TecListDAO();
/* 126 */     tec = tdao.findById(xuanti.getTeccode());
/* 127 */     request.setAttribute("tecname", tec.getTecname());
/*     */ 
/* 133 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.stu.ZhaiyaostuexportAction
 * JD-Core Version:    0.5.4
 */