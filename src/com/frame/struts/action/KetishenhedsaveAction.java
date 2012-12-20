/*     */ package com.frame.struts.action;
/*     */ 
/*     */ import com.entity.wish.ApplyState;
/*     */ import com.entity.wish.ApplyStateDAO;
/*     */ import com.entity.wish.ApplyTec;
/*     */ import com.entity.wish.ApplyTecDAO;
/*     */ import com.frame.struts.form.wish.KetishenbaoForm;
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
/*     */ public class KetishenhedsaveAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  51 */     KetishenbaoForm kform = (KetishenbaoForm)form;
/*  52 */     HttpSession session = request.getSession();
/*  53 */     if (session.getAttribute("teccode") == null) {
/*  54 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  55 */       return mapping.findForward("error");
/*     */     }
/*  57 */     if (session.getAttribute("userrole") != "2") {
/*  58 */       request.setAttribute("notice", "您没有该项权限！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  59 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  62 */     toChi tochi = new toChi();
/*  63 */     String title = tochi.toChinese(kform.getTitle());
/*  64 */     Integer collegeid = Integer.valueOf(Integer.parseInt(session.getAttribute("collegeid").toString()));
/*  65 */     Integer departid = kform.getDepartid();
/*  66 */     Integer gradeid = kform.getGradeid();
/*     */ 
/*  68 */     Integer stusum = kform.getStusum();
/*  69 */     String content = tochi.toChinese(kform.getContent());
/*  70 */     String preparework = tochi.toChinese(kform.getPreparework());
/*  71 */     Integer applytype = kform.getApplytype();
/*  72 */     String source = tochi.toChinese(kform.getSource());
/*  73 */     String kind = tochi.toChinese(kform.getKind());
/*  74 */     String practise = tochi.toChinese(kform.getPractise());
/*  75 */     String computer = tochi.toChinese(kform.getComputer());
/*  76 */     Integer[] resultids = kform.getResultids();
/*  77 */     String op = kform.getOp();
/*  78 */     Integer atid = kform.getAtid();
/*  79 */     String teccode = kform.getTeccode().trim();
/*  80 */     String advice1 = tochi.toChinese(kform.getAdvice1());
/*     */ 
/*  82 */     if (!op.equals("shenhe1")) {
/*  83 */       return mapping.findForward("error");
/*  86 */     }
/*     */ ApplyTec applytec = new ApplyTec();
/*  87 */     ApplyTecDAO atdao = new ApplyTecDAO();
/*  88 */     applytec = atdao.findById(atid);
/*  89 */     Date applydate = new Date();
/*  90 */     applytec.setTitle(title);
/*  91 */     applytec.setDepartid(departid);
/*  92 */     applytec.setStusum(stusum);
/*  93 */     applytec.setTeccode(teccode);
/*     */ 
/*  95 */     applytec.setContent(content);
/*  96 */     applytec.setPreparework(preparework);
/*  97 */     applytec.setSource(source);
/*  98 */     applytec.setKind(kind);
/*  99 */     applytec.setPractise(practise);
/* 100 */     applytec.setComputer(computer);
/* 101 */     applytec.setCollegeid(collegeid);
/* 102 */     applytec.setApplydate(applydate);
/* 103 */     applytec.setApplytype(applytype);
/* 104 */     applytec.setGradeid(gradeid);
/* 105 */     applytec.setAdvice1(advice1);
/* 106 */     Date date1 = new Date();
/* 107 */     applytec.setDate1(date1);
/* 108 */     applytec.setSign1(session.getAttribute("tecname").toString());
/*     */ 
/* 110 */     Transaction ts = atdao.getSession().beginTransaction();
/*     */     ActionForward localActionForward2;
/*     */     try {
/* 112 */       atdao.getSession().update(applytec);
/* 113 */       atdao.getSession().flush();
/* 114 */       ts.commit();
/* 115 */       atdao.getSession().close();
/* 116 */       request.setAttribute("notice", "审核课题 " + title + " 成功");
/* 117 */       request.setAttribute("departid", departid);
/*     */ 
/* 119 */       ApplyState as = new ApplyState();
/* 120 */       ApplyStateDAO asdao = new ApplyStateDAO();
/* 121 */       as = asdao.findById(atid);
/* 122 */       as.setAtid(applytec.getAtid());
/* 123 */       as.setAdvice1(advice1);
/* 124 */       Transaction tsas = asdao.getSession().beginTransaction();
/*     */       try {
/* 126 */         asdao.getSession().update(as);
/* 127 */         asdao.getSession().flush();
/* 128 */         tsas.commit();
/*     */       } catch (RuntimeException re) {
/* 130 */         System.out.println("异常信息：" + re);
/* 131 */         asdao.getSession().clear();
/* 132 */         tsas.rollback();
/* 133 */         request.setAttribute("notice", "编辑课题  " + title + " 资料失败！！！");
/* 134 */         ActionForward localActionForward1 = mapping.findForward("error");
/*     */ 
/* 136 */         asdao.getSession().clear();
/* 137 */         asdao.getSession().close();
/*     */ 
/* 134 */         return localActionForward1;
/*     */       } finally {
/* 136 */         asdao.getSession().clear();
/* 137 */         asdao.getSession().close();
/*     */       }
/*     */ 
/* 142 */       return mapping.findForward("success");
/*     */     } catch (RuntimeException re) {
/* 144 */       System.out.println("异常信息：" + re);
/* 145 */       atdao.getSession().clear();
/* 146 */       ts.rollback();
/* 147 */       request.setAttribute("notice", "审核课题  " + title + " 资料失败！！！");
/* 148 */       return mapping.findForward("error");
/*     */     } finally {
/* 150 */       atdao.getSession().clear();
/* 151 */       atdao.getSession().close();
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.KetishenhedsaveAction
 * JD-Core Version:    0.5.4
 */