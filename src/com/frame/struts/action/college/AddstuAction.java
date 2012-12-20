/*     */ package com.frame.struts.action.college;
/*     */ 
/*     */ import com.entity.basedata.ClassListDAO;
/*     */ import com.entity.basedata.CollegeList;
/*     */ import com.entity.basedata.CollegeListDAO;
/*     */ import com.entity.basedata.DepartListDAO;
/*     */ import com.entity.basedata.GradeListDAO;
/*     */ import com.entity.basedata.StuList;
/*     */ import com.entity.basedata.StuListDAO;
/*     */ import com.frame.struts.baseform.AddclassForm;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.apache.struts.action.Action;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionForward;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class AddstuAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  54 */     HttpSession session = request.getSession();
/*  55 */     if (session.getAttribute("adminid") == null) {
/*  56 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  57 */       return mapping.findForward("error");
/*     */     }
/*  59 */     Integer collegeid = Integer.valueOf(Integer.parseInt(session.getAttribute("collegeid").toString()));
/*  60 */     CollegeList collegelist = new CollegeList();
/*  61 */     CollegeListDAO cdao = new CollegeListDAO();
/*  62 */     collegelist = cdao.findById(collegeid);
/*  63 */     request.setAttribute("CollegeList", collegelist);
/*     */ 
/*  66 */     DepartListDAO ddao = new DepartListDAO();
/*  67 */     List departlist = ddao.findByCollegeid(collegeid);
/*  68 */     request.setAttribute("departlist", departlist);
/*     */ 
/*  71 */     List gradelist = null;
/*  72 */     GradeListDAO gdao = new GradeListDAO();
/*  73 */     String id = request.getParameter("departid");
/*  74 */     if (id == null) {
/*  75 */       gradelist = null;
/*  76 */       request.setAttribute("departid", Integer.valueOf(0));
/*     */     } else {
/*  78 */       Integer departid = Integer.valueOf(Integer.parseInt(id));
/*  79 */       gradelist = gdao.findByDepartid(departid);
/*  80 */       request.setAttribute("departid", departid);
/*  81 */     }request.setAttribute("gradelist", gradelist);
/*     */ 
/*  84 */     List classlist = null;
/*  85 */     ClassListDAO classdao = new ClassListDAO();
/*  86 */     id = request.getParameter("gradeid");
/*  87 */     if (id == null) {
/*  88 */       classlist = null;
/*  89 */       request.setAttribute("gradeid", Integer.valueOf(0));
/*     */     } else {
/*  91 */       Integer gradeid = Integer.valueOf(Integer.parseInt(id));
/*  92 */       classlist = classdao.findByGradeid(gradeid);
/*  93 */       request.setAttribute("gradeid", gradeid);
/*  94 */     }request.setAttribute("classlist", classlist);
/*     */ 
/*  97 */     String op = request.getParameter("op");
/*  98 */     if (op.equals(null)) op = "tjia";
/*  99 */     if (op.equals("edit")) {
/* 100 */       AddclassForm aform = (AddclassForm)form;
/* 101 */       request.setAttribute("op", "edit");
/* 102 */       String stucode = request.getParameter("stucode");
/* 103 */       StuListDAO sdao = new StuListDAO();
/* 104 */       StuList stu = new StuList();
/* 105 */       stu = sdao.findById(stucode);
/* 106 */       gradelist = gdao.findByDepartid(stu.getDepartid());
/* 107 */       classlist = classdao.findByGradeid(stu.getGradeid());
/*     */ 
/* 109 */       request.setAttribute("stucoderead", "readonly");
/* 110 */       request.setAttribute("stucodehidden", stu.getStucode());
/* 111 */       request.setAttribute("departid", stu.getDepartid());
/* 112 */       request.setAttribute("gradeid", stu.getGradeid());
/* 113 */       request.setAttribute("classid", stu.getClassid());
/* 114 */       request.setAttribute("gradelist", gradelist);
/* 115 */       request.setAttribute("departlist", departlist);
/* 116 */       request.setAttribute("classlist", classlist);
/* 117 */       request.setAttribute("StuList", stu);
/* 118 */       request.setAttribute("op", "edit");
/*     */     }
/*     */     else {
/* 121 */       request.setAttribute("op", "tjia");
/* 122 */       request.setAttribute("stucoderead", " ");
/*     */     }
/*     */ 
/* 125 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.AddstuAction
 * JD-Core Version:    0.5.4
 */