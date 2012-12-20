/*     */ package com.frame.struts.action.depart;
/*     */ 
/*     */ import com.entity.basedata.ClassList;
/*     */ import com.entity.basedata.ClassListDAO;
/*     */ import com.entity.basedata.DepartList;
/*     */ import com.entity.basedata.DepartListDAO;
/*     */ import com.entity.basedata.StuList;
/*     */ import com.entity.basedata.StuListDAO;
/*     */ import com.entity.basedata.TecList;
/*     */ import com.entity.basedata.TecListDAO;
/*     */ import com.entity.pingyue.PingyuTec;
/*     */ import com.entity.pingyue.PingyuTecDAO;
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
/*     */ public class PingyutecexportAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  58 */     HttpSession session = request.getSession();
/*  59 */     if (session.getAttribute("teccode") == null) {
/*  60 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  61 */       return mapping.findForward("error");
/*     */     }
/*  63 */     String teccode = session.getAttribute("teccode").toString();
/*     */ 
/*  66 */     String stucode = request.getParameter("s").toString();
/*     */ 
/*  69 */     StuList stu = new StuList();
/*  70 */     StuListDAO sdao = new StuListDAO();
/*  71 */     stu = sdao.findById(stucode);
/*  72 */     DepartList depart = new DepartList();
/*  73 */     DepartListDAO ddao = new DepartListDAO();
/*  74 */     depart = ddao.findById(stu.getDepartid());
/*  75 */     ClassList stuclass = new ClassList();
/*  76 */     ClassListDAO cdao = new ClassListDAO();
/*  77 */     stuclass = cdao.findById(stu.getClassid());
/*  78 */     Xuanti xuanti = new Xuanti();
/*  79 */     XuantiDAO xdao = new XuantiDAO();
/*  80 */     xuanti = xdao.findById(stucode);
/*  81 */     ApplyTec at = new ApplyTec();
/*  82 */     ApplyTecDAO atdao = new ApplyTecDAO();
/*  83 */     at = atdao.findById(xuanti.getAtid());
/*  84 */     request.setAttribute("stuname", stu.getStuname());
/*  85 */     request.setAttribute("departname", depart.getDepartname());
/*  86 */     request.setAttribute("classname", stuclass.getClassnameshort());
/*  87 */     request.setAttribute("title", at.getTitle());
/*     */ 
/*  89 */     PingyuTec pt = new PingyuTec();
/*  90 */     PingyuTecDAO pdao = new PingyuTecDAO();
/*  91 */     pt = (PingyuTec)pdao.findByStucode(stucode).get(0);
/*  92 */     request.setAttribute("pingyu", pt.getPingyu());
/*  93 */     request.setAttribute("chengji", pt.getChengji());
/*  94 */     TecList pter = new TecList();
/*  95 */     TecListDAO pterdao = new TecListDAO();
/*  96 */     pter = pterdao.findById(pt.getTeccode().trim());
/*  97 */     request.setAttribute("pter", pter.getTecname());
/*     */ 
/*  99 */     SimpleDateFormat year = new SimpleDateFormat("yyyy年MM月dd日");
/* 100 */     request.setAttribute("uptime", year.format(pt.getUptime()));
/*     */ 
/* 102 */     return mapping.findForward("export");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.PingyutecexportAction
 * JD-Core Version:    0.5.4
 */