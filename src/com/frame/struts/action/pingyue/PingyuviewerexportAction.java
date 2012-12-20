/*     */ package com.frame.struts.action.pingyue;
/*     */ 
/*     */ import com.entity.basedata.ClassList;
/*     */ import com.entity.basedata.ClassListDAO;
/*     */ import com.entity.basedata.DepartList;
/*     */ import com.entity.basedata.DepartListDAO;
/*     */ import com.entity.basedata.StuList;
/*     */ import com.entity.basedata.StuListDAO;
/*     */ import com.entity.basedata.TecList;
/*     */ import com.entity.basedata.TecListDAO;
/*     */ import com.entity.pingyue.PingyuViewer;
/*     */ import com.entity.pingyue.PingyuViewerDAO;
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
/*     */ public class PingyuviewerexportAction extends Action
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
/*  89 */     PingyuViewer pyv = new PingyuViewer();
/*  90 */     PingyuViewerDAO pdao = new PingyuViewerDAO();
/*  91 */     pyv = (PingyuViewer)pdao.findByStucode(stucode).get(0);
/*  92 */     request.setAttribute("pingyu", pyv.getPingyu());
/*  93 */     SimpleDateFormat year = new SimpleDateFormat("yyyy年MM月dd日");
/*  94 */     request.setAttribute("uptime", year.format(pyv.getUptime()));
/*     */ 
/*  96 */     String pycode = pyv.getTeccode().trim();
/*  97 */     TecList py = new TecList();
/*  98 */     TecListDAO pydao = new TecListDAO();
/*  99 */     py = pydao.findById(pycode);
/* 100 */     request.setAttribute("pyname", py.getTecname());
/*     */ 
/* 102 */     return mapping.findForward("export");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.pingyue.PingyuviewerexportAction
 * JD-Core Version:    0.5.4
 */