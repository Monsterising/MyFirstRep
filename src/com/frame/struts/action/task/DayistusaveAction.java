/*     */ package com.frame.struts.action.task;
/*     */ 
/*     */ import com.entity.basedata.StuList;
/*     */ import com.entity.basedata.StuListDAO;
/*     */ import com.entity.basedata.TecList;
/*     */ import com.entity.basedata.TecListDAO;
/*     */ import com.entity.task.Stagetaskdayi;
/*     */ import com.entity.task.StagetaskdayiDAO;
/*     */ import com.entity.wish.Xuanti;
/*     */ import com.entity.wish.XuantiDAO;
/*     */ import com.frame.struts.form.task.DayiForm;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Date;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.apache.struts.action.Action;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionForward;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ import org.hibernate.Session;
/*     */ import org.hibernate.Transaction;
/*     */ import pub.toChi;
/*     */ 
/*     */ public class DayistusaveAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  53 */     DayiForm dform = (DayiForm)form;
/*  54 */     HttpSession session = request.getSession();
/*  55 */     if (session.getAttribute("stucode") == null) {
/*  56 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  57 */       return mapping.findForward("error");
/*     */     }
/*  59 */     String stucode = session.getAttribute("stucode").toString();
/*  60 */     request.setAttribute("stucode", stucode);
/*     */ 
/*  63 */     StuList stu = new StuList();
/*  64 */     StuListDAO sdao = new StuListDAO();
/*  65 */     stu = sdao.findById(stucode);
/*     */ 
/*  68 */     XuantiDAO xdao = new XuantiDAO();
/*  69 */     Xuanti xuanti = new Xuanti();
/*  70 */     xuanti = xdao.findById(stucode);
/*  71 */     if (xuanti == null) {
/*  72 */       request.setAttribute("notice", "您暂且没有指导教师");
/*  73 */       return mapping.findForward("error");
/*     */     }
/*  75 */     TecList tec = new TecList();
/*  76 */     TecListDAO tdao = new TecListDAO();
/*  77 */     tec = tdao.findById(xuanti.getTeccode());
/*     */ 
/*  81 */     toChi tochi = new toChi();
/*  82 */     Date date = new Date();
/*  83 */     Stagetaskdayi dayi = new Stagetaskdayi();
/*  84 */     dayi.setQuestion(tochi.toChinese(dform.getQuestion()));
/*  85 */     dayi.setQtime(date);
/*  86 */     dayi.setStucode(stucode);
/*  87 */     dayi.setTeccode(xuanti.getTeccode());
/*  88 */     dayi.setDepartid(stu.getDepartid());
/*  89 */     dayi.setGradeid(stu.getGradeid());
/*  90 */     dayi.setIsok(Integer.valueOf(0));
/*  91 */     StagetaskdayiDAO ddao = new StagetaskdayiDAO();
/*  92 */     Transaction tsas = ddao.getSession().beginTransaction();
/*     */     try {
/*  94 */       ddao.getSession().saveOrUpdate(dayi);
/*  95 */       ddao.getSession().flush();
/*  96 */       tsas.commit();
/*     */     } catch (RuntimeException re) {
/*  98 */       System.out.println("异常信息：" + re);
/*  99 */       ddao.getSession().clear();
/* 100 */       tsas.rollback();
/* 101 */       request.setAttribute("notice", "保存失败！！！");
/* 102 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/* 106 */     return mapping.findForward("list");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.task.DayistusaveAction
 * JD-Core Version:    0.5.4
 */