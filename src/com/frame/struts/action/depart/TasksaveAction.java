/*     */ package com.frame.struts.action.depart;
/*     */ 
/*     */ import com.entity.task.Task;
/*     */ import com.entity.task.TaskDAO;
/*     */ import com.entity.wish.ApplyState;
/*     */ import com.entity.wish.ApplyStateDAO;
/*     */ import com.frame.struts.form.task.TaskForm;
/*     */ import java.io.PrintStream;
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
/*     */ public class TasksaveAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  48 */     TaskForm tform = (TaskForm)form;
/*     */ 
/*  50 */     HttpSession session = request.getSession();
/*  51 */     if (session.getAttribute("teccode") == null) {
/*  52 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  53 */       return mapping.findForward("error");
/*     */     }
/*  55 */     toChi tochi = new toChi();
/*  56 */     Integer taskid = null;
/*  57 */     if (tform.getTaskid().intValue() != 0) {
/*  58 */       taskid = tform.getTaskid();
/*     */     }
/*  60 */     Task task = new Task();
/*  61 */     TaskDAO tdao = new TaskDAO();
/*  62 */     if (taskid != null) {
/*  63 */       task = tdao.findById(taskid);
/*     */     }
/*  65 */     task.setAtid(tform.getAtid());
/*  66 */     task.setCollegeid(tform.getCollegeid());
/*  67 */     task.setNeirong(tochi.toChinese(tform.getNeirong().trim()));
/*  68 */     task.setDepartid(tform.getDepartid());
/*  69 */     task.setStucode(tform.getStucode());
/*  70 */     task.setTeccode(tform.getTeccode());
/*  71 */     task.setYaoqiu(tochi.toChinese(tform.getYaoqiu()));
/*  72 */     task.setZiliao(tochi.toChinese(tform.getZiliao()));
/*     */ 
/*  77 */     task.setDatefagei(tform.getToyoutime());
/*  78 */     task.setDateover(tform.getOvertime());
/*  79 */     task.setDatestart(tform.getBegintime());
/*  80 */     Transaction ts = tdao.getSession().beginTransaction();
/*     */     try {
/*  82 */       tdao.getSession().saveOrUpdate(task);
/*  83 */       tdao.getSession().flush();
/*  84 */       ts.commit();
/*  85 */       tdao.getSession().close();
/*  86 */       request.setAttribute("departid", tform.getDepartid());
/*  87 */       request.setAttribute("atid", tform.getAtid());
/*  88 */       request.setAttribute("notice", "填报任务书 成功");
/*     */ 
/*  90 */       ApplyState as = new ApplyState();
/*  91 */       ApplyStateDAO asdao = new ApplyStateDAO();
/*  92 */       as = asdao.findById(tform.getAtid());
/*  93 */       as.setAtid(tform.getAtid());
/*  94 */       as.setTask("ok");
/*  95 */       Transaction tsas = asdao.getSession().beginTransaction();
/*     */       try {
/*  97 */         asdao.getSession().saveOrUpdate(as);
/*  98 */         asdao.getSession().flush();
/*  99 */         tsas.commit();
/*     */       } catch (RuntimeException re) {
/* 101 */         System.out.println("异常信息：" + re);
/* 102 */         asdao.getSession().clear();
/* 103 */         tsas.rollback();
/* 104 */         request.setAttribute("notice", "编辑课题  资料失败！！！");
/* 105 */         return mapping.findForward("error");
/*     */       }
/*     */ 
/* 108 */       if (tform.getOp().equals("taskedit")) {
/* 109 */         request.setAttribute("op", "edit");
/*     */       }
/*     */ 
/* 113 */       return mapping.findForward("success");
/*     */     } catch (RuntimeException re) {
/* 115 */       System.out.println("异常信息：" + re);
/* 116 */       tdao.getSession().clear();
/* 117 */       ts.rollback();
/* 118 */       request.setAttribute("notice", "填报任务书 资料失败！！！");
/* 119 */     }return mapping.findForward("error");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.TasksaveAction
 * JD-Core Version:    0.5.4
 */