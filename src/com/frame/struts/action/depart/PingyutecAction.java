/*     */ package com.frame.struts.action.depart;
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
/*     */ import com.entity.pingyue.PingyuStu;
/*     */ import com.entity.pingyue.PingyuStuDAO;
/*     */ import com.frame.struts.form.pingyue.PingyuviewergradeForm;
/*     */ import java.io.PrintStream;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.struts.action.Action;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionForward;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ import org.hibernate.Session;
/*     */ import pub.Qdao;
/*     */ 
/*     */ public class PingyutecAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  58 */     PingyuviewergradeForm vform = (PingyuviewergradeForm)form;
/*  59 */     Biaozhun biaozhun = new Biaozhun();
/*  60 */     BiaozhunDAO bdao = new BiaozhunDAO();
/*  61 */     List blist = new LinkedList();
/*  62 */     Qdao qdao = new Qdao();
/*  63 */     String hql = "";
/*     */ 
/*  65 */     System.out.println("vform.getWenxian()=" + vform.getWenxian());
/*  66 */     hql = "from Biaozhun where type='文献综述' and grade='" + vform.getWenxian() + "'";
/*  67 */     System.out.println(hql);
/*  68 */     blist.addAll(qdao.query(hql));
/*  69 */     request.setAttribute("wenxian", ((Biaozhun)blist.get(0)).getContent());
/*     */ 
/*  71 */     hql = "from Biaozhun where type='动手能力' and grade='" + vform.getDongshou() + "'";
/*  72 */     blist.addAll(1, qdao.query(hql));
/*  73 */     request.setAttribute("dongshou", ((Biaozhun)blist.get(1)).getContent());
/*     */ 
/*  75 */     hql = "from Biaozhun where type='综合能力' and grade='" + vform.getZonghe() + "'";
/*  76 */     blist.addAll(2, qdao.query(hql));
/*  77 */     request.setAttribute("zonghe", ((Biaozhun)blist.get(2)).getContent());
/*     */ 
/*  79 */     hql = "from Biaozhun where type='文图表达' and grade='" + vform.getWentu() + "'";
/*  80 */     blist.addAll(3, qdao.query(hql));
/*  81 */     request.setAttribute("wentu", ((Biaozhun)blist.get(3)).getContent());
/*     */ 
/*  83 */     hql = "from Biaozhun where type='规范要求' and grade='" + vform.getGuifan() + "'";
/*  84 */     blist.addAll(4, qdao.query(hql));
/*  85 */     request.setAttribute("guifan", ((Biaozhun)blist.get(4)).getContent());
/*  86 */     String pingyu = ((Biaozhun)blist.get(0)).getContent() + ((Biaozhun)blist.get(1)).getContent() + 
/*  87 */       ((Biaozhun)blist.get(2)).getContent() + ((Biaozhun)blist.get(3)).getContent() + ((Biaozhun)blist.get(4)).getContent();
/*     */ 
/*  89 */     PingyuStu pystu = new PingyuStu();
/*  90 */     PingyuStuDAO pystudao = new PingyuStuDAO();
/*  91 */     if (pystudao.getSession().get(PingyuStu.class, vform.getStucode()) != null) {
/*  92 */       pystu = pystudao.findById(vform.getStucode());
/*  93 */       pingyu = pystu.getBeijin() + pystu.getContent() + pystu.getAttitude() + pystu.getResult() + pingyu + "<br>";
/*     */     }
/*     */     else {
/*  96 */       request.setAttribute("notice", "该学生尚未自评!");
/*     */     }
/*     */ 
/* 102 */     StuList stu = new StuList();
/* 103 */     StuListDAO studao = new StuListDAO();
/* 104 */     stu = studao.findById(vform.getStucode());
/* 105 */     DepartList depart = new DepartList();
/* 106 */     DepartListDAO departdao = new DepartListDAO();
/* 107 */     depart = departdao.findById(stu.getDepartid());
/* 108 */     request.setAttribute("StuList", stu);
/* 109 */     request.setAttribute("departname", depart.getDepartname());
/* 110 */     CollegeList college = new CollegeList();
/* 111 */     CollegeListDAO collegedao = new CollegeListDAO();
/* 112 */     college = collegedao.findById(stu.getCollegeid());
/* 113 */     request.setAttribute("collegename", college.getCollegename());
/* 114 */     ClassList stuclass = new ClassList();
/* 115 */     ClassListDAO classdao = new ClassListDAO();
/* 116 */     stuclass = classdao.findById(stu.getClassid());
/* 117 */     request.setAttribute("classname", stuclass.getClassname());
/* 118 */     GradeList grade = new GradeList();
/* 119 */     GradeListDAO gdao = new GradeListDAO();
/* 120 */     grade = gdao.findById(stu.getGradeid());
/* 121 */     request.setAttribute("gradename", grade.getGradename());
/* 122 */     request.setAttribute("stucode", stu.getStucode());
/* 123 */     request.setAttribute("departid", depart.getDepartid());
/*     */ 
/* 125 */     pingyu = pingyu + "<br>" + "毕业答辩资料齐全，文献综述以及开题报告符合规定要求。" + 
/* 126 */       "综上所述，我认为" + stu.getStuname() + "同学的论文已达到本科毕业生水平，同意推荐参加论文答辩。";
/*     */ 
/* 128 */     request.setAttribute("pingyu", pingyu);
/* 129 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.PingyutecAction
 * JD-Core Version:    0.5.4
 */