/*     */ package com.frame.struts.action.college;
/*     */ 
/*     */ import com.entity.basedata.DepartTec;
/*     */ import com.entity.basedata.DepartTecDAO;
/*     */ import com.entity.basedata.TecList;
/*     */ import com.entity.basedata.TecListDAO;
/*     */ import com.frame.struts.baseform.AddtecForm;
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
/*     */ import pub.Qdao;
/*     */ import pub.toChi;
/*     */ 
/*     */ public class TecsaveAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  47 */     AddtecForm addtecForm = (AddtecForm)form;
/*  48 */     HttpSession session = request.getSession();
/*  49 */     if (session.getAttribute("adminid") == null) {
/*  50 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  51 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  54 */     toChi tochi = new toChi();
/*  55 */     Integer collegeid = addtecForm.getCollegeid();
/*  56 */     Integer tecrole = addtecForm.getTecrole();
/*  57 */     String teccode = tochi.toChinese(addtecForm.getTeccode().trim());
/*  58 */     String tecpass = tochi.toChinese(addtecForm.getTecpass().trim());
/*  59 */     String tecname = tochi.toChinese(addtecForm.getTecname().trim());
/*  60 */     String op = addtecForm.getOp();
/*  61 */     Integer[] departids = addtecForm.getDepartid();
/*     */ 
/*  64 */     if ((teccode.equals("")) || (tecpass.equals("")) || (tecname.equals(""))) {
/*  65 */       request.setAttribute("notice", "添加管理员 " + tecname + " 资料失败！！！<br>每一项都要填写！");
/*  66 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  71 */     TecList tec = new TecList();
/*  72 */     TecListDAO tdao = new TecListDAO();
/*     */ 
/*  74 */     if (op.equals("gxin")) {
/*  75 */       tec = tdao.findById(teccode);
/*     */     }
/*  77 */     tec.setCollegeid(collegeid);
/*  78 */     tec.setTeccode(teccode);
/*  79 */     tec.setTecname(tecname);
/*  80 */     tec.setTecpass(tecpass);
/*  81 */     tec.setTecrole(tecrole);
/*     */ 
/*  83 */     Transaction ts = tdao.getSession().beginTransaction();
/*     */     try {
/*  85 */       tdao.getSession().saveOrUpdate(tec);
/*  86 */       tdao.getSession().flush();
/*  87 */       ts.commit();
/*  88 */       teccode = tec.getTeccode();
/*     */ 
/*  90 */       System.out.println("添加成功！");
/*     */ 
/*  92 */       request.setAttribute("notice", "添加管理员 " + teccode + " 资料成功");
/*     */ 
/*  95 */       Qdao qdao = new Qdao();
/*  96 */       String hql = "delete DepartTec where teccode='" + teccode + "'";
/*  97 */       qdao.del(hql);
/*     */ 
/* 101 */       if (departids != null) {
/* 102 */         DepartTecDAO ccdao = new DepartTecDAO();
/* 103 */         Transaction cts = ccdao.getSession().beginTransaction();
/* 104 */         for (Integer j = Integer.valueOf(0); j.intValue() < departids.length; j = Integer.valueOf(j.intValue() + 1)) {
/* 105 */           Integer trole = Integer.valueOf(Integer.parseInt(request.getParameter(departids[j.intValue()].toString())));
/* 106 */           DepartTec departtec = new DepartTec();
/* 107 */           departtec.setDepartid(departids[j.intValue()]);
/* 108 */           departtec.setTeccode(teccode);
/* 109 */           departtec.setTecrole(trole);
/* 110 */           ccdao.getSession().save(departtec);
/* 111 */         }ccdao.getSession().flush();
/* 112 */         ccdao.getSession().clear();
/* 113 */         cts.commit();
/* 114 */         System.out.println("成功更新教师信息！");
/*     */       }
/*     */     }
/*     */     catch (RuntimeException re) {
/* 118 */       System.out.println("异常信息：" + re);
/* 119 */       tdao.getSession().clear();
/* 120 */       ts.rollback();
/* 121 */       request.setAttribute("notice", "添加jiaoshi  " + teccode + " 资料失败！！！");
/* 122 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/* 127 */     return mapping.findForward("list");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.TecsaveAction
 * JD-Core Version:    0.5.4
 */