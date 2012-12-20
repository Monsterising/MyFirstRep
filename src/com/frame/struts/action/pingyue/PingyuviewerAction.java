/*     */ package com.frame.struts.action.pingyue;
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
/*     */ import com.entity.pingyue.Biaozhun;
/*     */ import com.entity.pingyue.BiaozhunDAO;
/*     */ import com.frame.struts.form.pingyue.PingyuviewergradeForm;
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
/*     */ public class PingyuviewerAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  56 */     PingyuviewergradeForm vform = (PingyuviewergradeForm)form;
/*  57 */     Biaozhun biaozhun = new Biaozhun();
/*  58 */     BiaozhunDAO bdao = new BiaozhunDAO();
/*  59 */     List blist = new LinkedList();
/*  60 */     Qdao qdao = new Qdao();
/*  61 */     String hql = "";
/*     */ 
/*  63 */     hql = "from Biaozhun where type='文献综述' and grade='" + vform.getWenxian() + "'";
/*  64 */     blist.addAll(qdao.query(hql));
/*  65 */     request.setAttribute("wenxian", ((Biaozhun)blist.get(0)).getContent());
/*     */ 
/*  67 */     hql = "from Biaozhun where type='动手能力' and grade='" + vform.getDongshou() + "'";
/*  68 */     blist.addAll(1, qdao.query(hql));
/*  69 */     request.setAttribute("dongshou", ((Biaozhun)blist.get(1)).getContent());
/*     */ 
/*  71 */     hql = "from Biaozhun where type='综合能力' and grade='" + vform.getZonghe() + "'";
/*  72 */     blist.addAll(2, qdao.query(hql));
/*  73 */     request.setAttribute("zonghe", ((Biaozhun)blist.get(2)).getContent());
/*     */ 
/*  75 */     hql = "from Biaozhun where type='文图表达' and grade='" + vform.getWentu() + "'";
/*  76 */     blist.addAll(3, qdao.query(hql));
/*  77 */     request.setAttribute("wentu", ((Biaozhun)blist.get(3)).getContent());
/*     */ 
/*  79 */     hql = "from Biaozhun where type='规范要求' and grade='" + vform.getGuifan() + "'";
/*  80 */     blist.addAll(4, qdao.query(hql));
/*  81 */     request.setAttribute("guifan", ((Biaozhun)blist.get(4)).getContent());
/*  82 */     request.setAttribute("pingyu", ((Biaozhun)blist.get(0)).getContent() + ((Biaozhun)blist.get(1)).getContent() + 
/*  83 */       ((Biaozhun)blist.get(2)).getContent() + ((Biaozhun)blist.get(3)).getContent() + ((Biaozhun)blist.get(4)).getContent() + 
/*  84 */       "<br>毕业答辩资料齐全，同意指导教师的评语和给定的成绩。");
/*     */ 
/*  89 */     StuList stu = new StuList();
/*  90 */     StuListDAO studao = new StuListDAO();
/*  91 */     stu = studao.findById(vform.getStucode());
/*  92 */     DepartList depart = new DepartList();
/*  93 */     DepartListDAO departdao = new DepartListDAO();
/*  94 */     depart = departdao.findById(stu.getDepartid());
/*  95 */     request.setAttribute("StuList", stu);
/*  96 */     request.setAttribute("departname", depart.getDepartname());
/*  97 */     CollegeList college = new CollegeList();
/*  98 */     CollegeListDAO collegedao = new CollegeListDAO();
/*  99 */     college = collegedao.findById(stu.getCollegeid());
/* 100 */     request.setAttribute("collegename", college.getCollegename());
/* 101 */     ClassList stuclass = new ClassList();
/* 102 */     ClassListDAO classdao = new ClassListDAO();
/* 103 */     stuclass = classdao.findById(stu.getClassid());
/* 104 */     request.setAttribute("classname", stuclass.getClassname());
/* 105 */     GradeList grade = new GradeList();
/* 106 */     GradeListDAO gdao = new GradeListDAO();
/* 107 */     grade = gdao.findById(stu.getGradeid());
/* 108 */     request.setAttribute("gradename", grade.getGradename());
/* 109 */     request.setAttribute("stucode", stu.getStucode());
/* 110 */     request.setAttribute("departid", depart.getDepartid());
/*     */ 
/* 112 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.pingyue.PingyuviewerAction
 * JD-Core Version:    0.5.4
 */