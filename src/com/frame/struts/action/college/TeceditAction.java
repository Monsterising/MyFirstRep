/*     */ package com.frame.struts.action.college;
/*     */ 
/*     */ import com.entity.basedata.DepartListDAO;
/*     */ import com.entity.basedata.DepartTec;
/*     */ import com.entity.basedata.TecList;
/*     */ import com.entity.basedata.TecListDAO;
/*     */ import com.frame.struts.baseform.AddtecForm;
/*     */ import java.io.PrintStream;
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
/*     */ public class TeceditAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  51 */     AddtecForm addtecForm = (AddtecForm)form;
/*  52 */     HttpSession session = request.getSession();
/*  53 */     if (session.getAttribute("adminid") == null) {
/*  54 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  55 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  61 */     if (request.getParameter("id") == null) {
/*  62 */       request.setAttribute("notice", "参数错误！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  63 */       return mapping.findForward("error");
/*     */     }
/*  65 */     String teccode = request.getParameter("id").toString();
/*     */ 
/*  67 */     TecListDAO tdao = new TecListDAO();
/*  68 */     TecList tec = (TecList)tdao.getSession().get(TecList.class, teccode);
/*  69 */     request.setAttribute("TecList", tec);
/*  70 */     request.setAttribute("tecname", tec.getTecname());
/*     */ 
/*  73 */     Integer collegeid = Integer.valueOf(Integer.parseInt(session.getAttribute("collegeid").toString()));
/*  74 */     DepartListDAO ddao = new DepartListDAO();
/*  75 */     List departlist = ddao.findByCollegeid(collegeid);
/*  76 */     request.setAttribute("departlist", departlist);
/*     */ 
/*  80 */     Qdao qdao = new Qdao();
/*  81 */     String hql = "from DepartTec where teccode='" + teccode + "'";
/*  82 */     List<DepartTec> dalist = qdao.query(hql);
/*     */ 
/*  84 */     Integer size = Integer.valueOf(dalist.size());
/*  85 */     System.out.println("数组长度：" + size);
/*  86 */     Integer[] departids = new Integer[size.intValue()];
/*  87 */     Integer[] tecrole = new Integer[size.intValue()];
/*  88 */     Integer j = Integer.valueOf(0);
/*     */ 
/*  91 */     List dtlist = new LinkedList();
/*  92 */     for (DepartTec ob : dalist) {
/*  93 */       departids[j.intValue()] = ob.getDepartid();
/*     */ 
/*  96 */       System.out.println("j=" + j + ";" + tecrole[j.intValue()]);
/*  97 */       DepartTec departtec = new DepartTec();
/*  98 */       departtec.setDepartid(ob.getDepartid());
/*  99 */       departtec.setTecrole(ob.getTecrole());
/* 100 */       dtlist.add(departtec);
/*     */ 
/* 104 */       System.out.println("dtlist-departid" + ((DepartTec)dtlist.get(j.intValue())).getDepartid());
/* 105 */       System.out.println("dtlist-tecrole" + ((DepartTec)dtlist.get(j.intValue())).getTecrole());
/* 106 */       j = Integer.valueOf(j.intValue() + 1);
/*     */     }
/* 108 */     for (Integer i = Integer.valueOf(0); i.intValue() < dtlist.size(); i = Integer.valueOf(i.intValue() + 1)) {
/* 109 */       System.out.println("dtlist.departid=" + ((DepartTec)dtlist.get(i.intValue())).getDepartid());
/* 110 */       System.out.println("dtlist.tecrole=" + ((DepartTec)dtlist.get(i.intValue())).getTecrole());
/*     */     }
/* 112 */     System.out.println("dtlist.size=" + dtlist.size());
/* 113 */     addtecForm.setDepartid(departids);
/*     */ 
/* 116 */     request.setAttribute("dtlist", dtlist);
/*     */ 
/* 121 */     request.setAttribute("addtecForm", addtecForm);
/*     */ 
/* 123 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.TeceditAction
 * JD-Core Version:    0.5.4
 */