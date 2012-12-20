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
/*     */ import com.entity.dabian.Pingfen;
/*     */ import com.entity.dabian.PingfenDAO;
/*     */ import com.entity.wish.ApplyTec;
/*     */ import com.entity.wish.ApplyTecDAO;
/*     */ import com.entity.wish.Xuanti;
/*     */ import com.entity.wish.XuantiDAO;
/*     */ import java.text.SimpleDateFormat;
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
/*     */ public class PingfenexportAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  61 */     HttpSession session = request.getSession();
/*  62 */     if (session.getAttribute("teccode") == null) {
/*  63 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  64 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  69 */     String stucode = request.getParameter("s").toString();
/*     */ 
/*  72 */     StuList stu = new StuList();
/*  73 */     StuListDAO sdao = new StuListDAO();
/*  74 */     stu = sdao.findById(stucode);
/*  75 */     CollegeList college = new CollegeList();
/*  76 */     CollegeListDAO collegedao = new CollegeListDAO();
/*  77 */     college = collegedao.findById(stu.getCollegeid());
/*  78 */     DepartList depart = new DepartList();
/*  79 */     DepartListDAO ddao = new DepartListDAO();
/*  80 */     depart = ddao.findById(stu.getDepartid());
/*  81 */     ClassList stuclass = new ClassList();
/*  82 */     ClassListDAO cdao = new ClassListDAO();
/*  83 */     stuclass = cdao.findById(stu.getClassid());
/*  84 */     Xuanti xuanti = new Xuanti();
/*  85 */     XuantiDAO xdao = new XuantiDAO();
/*  86 */     xuanti = xdao.findById(stucode);
/*  87 */     ApplyTec at = new ApplyTec();
/*  88 */     ApplyTecDAO atdao = new ApplyTecDAO();
/*  89 */     at = atdao.findById(xuanti.getAtid());
/*  90 */     request.setAttribute("stuname", stu.getStuname());
/*  91 */     request.setAttribute("collegename", college.getCollegename());
/*  92 */     request.setAttribute("departname", depart.getDepartname());
/*  93 */     request.setAttribute("classname", stuclass.getClassnameshort());
/*  94 */     request.setAttribute("title", at.getTitle());
/*     */ 
/*  97 */     Pingfen pf = new Pingfen();
/*  98 */     PingfenDAO pfdao = new PingfenDAO();
/*  99 */     List pflist = new LinkedList();
/* 100 */     Qdao qdao = new Qdao();
/* 101 */     String hql = "";
/* 102 */     hql = "from Pingfen where stucode='" + stucode + "' and type='文献综述'";
/* 103 */     pflist.addAll(0, qdao.query(hql));
/* 104 */     hql = "from Pingfen where stucode='" + stucode + "' and type='外文翻译'";
/* 105 */     pflist.addAll(1, qdao.query(hql));
/* 106 */     hql = "from Pingfen where stucode='" + stucode + "' and type='动手能力'";
/* 107 */     pflist.addAll(2, qdao.query(hql));
/* 108 */     hql = "from Pingfen where stucode='" + stucode + "' and type='综合能力'";
/* 109 */     pflist.addAll(3, qdao.query(hql));
/* 110 */     hql = "from Pingfen where stucode='" + stucode + "' and type='文图表达'";
/* 111 */     pflist.addAll(4, qdao.query(hql));
/* 112 */     hql = "from Pingfen where stucode='" + stucode + "' and type='规范要求'";
/* 113 */     pflist.addAll(5, qdao.query(hql));
/* 114 */     hql = "from Pingfen where stucode='" + stucode + "' and type='答辩情况'";
/* 115 */     pflist.addAll(6, qdao.query(hql));
/*     */ 
/* 117 */     request.setAttribute("wenxian", ((Pingfen)pflist.get(0)).getScore());
/* 118 */     request.setAttribute("fanyi", ((Pingfen)pflist.get(1)).getScore());
/* 119 */     request.setAttribute("dongshou", ((Pingfen)pflist.get(2)).getScore());
/* 120 */     request.setAttribute("zonghe", ((Pingfen)pflist.get(3)).getScore());
/* 121 */     request.setAttribute("wentu", ((Pingfen)pflist.get(4)).getScore());
/* 122 */     request.setAttribute("guifan", ((Pingfen)pflist.get(5)).getScore());
/* 123 */     request.setAttribute("dabian", ((Pingfen)pflist.get(6)).getScore());
/*     */ 
/* 126 */     Integer score = Integer.valueOf(0);
/* 127 */     score = Integer.valueOf(Integer.parseInt(((Pingfen)pflist.get(0)).getScore()) + Integer.parseInt(((Pingfen)pflist.get(1)).getScore()) + Integer.parseInt(((Pingfen)pflist.get(2)).getScore()) + 
/* 128 */       Integer.parseInt(((Pingfen)pflist.get(3)).getScore()) + Integer.parseInt(((Pingfen)pflist.get(4)).getScore()) + 
/* 129 */       Integer.parseInt(((Pingfen)pflist.get(5)).getScore()) + Integer.parseInt(((Pingfen)pflist.get(6)).getScore()));
/*     */ 
/* 131 */     request.setAttribute("score", score);
/* 132 */     SimpleDateFormat year = new SimpleDateFormat("yyyy年MM月dd日");
/* 133 */     request.setAttribute("uptime", year.format(((Pingfen)pflist.get(0)).getChecktime()));
/*     */ 
/* 135 */     return mapping.findForward("export");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.dabian.PingfenexportAction
 * JD-Core Version:    0.5.4
 */