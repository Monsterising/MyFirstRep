/*     */ package com.frame.struts.action.college;
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
/*     */ public class KetishenhesaveAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  50 */     KetishenbaoForm kform = (KetishenbaoForm)form;
/*  51 */     HttpSession session = request.getSession();
/*  52 */     if (session.getAttribute("adminid") == null) {
/*  53 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  54 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  58 */     toChi tochi = new toChi();
/*  59 */     String title = tochi.toChinese(kform.getTitle());
/*  60 */     Integer collegeid = Integer.valueOf(Integer.parseInt(session.getAttribute("collegeid").toString()));
/*  61 */     Integer departid = kform.getDepartid();
/*  62 */     Integer gradeid = kform.getGradeid();
/*  63 */     String tecprof = tochi.toChinese(kform.getTecprof());
/*  64 */     Integer stusum = kform.getStusum();
/*  65 */     String content = tochi.toChinese(kform.getContent());
/*  66 */     String preparework = tochi.toChinese(kform.getPreparework());
/*  67 */     Integer applytype = kform.getApplytype();
/*  68 */     String source = tochi.toChinese(kform.getSource());
/*  69 */     String kind = tochi.toChinese(kform.getKind());
/*  70 */     String practise = tochi.toChinese(kform.getPractise());
/*  71 */     String computer = tochi.toChinese(kform.getComputer());
/*  72 */     Integer[] resultids = kform.getResultids();
/*  73 */     String op = kform.getOp();
/*  74 */     Integer atid = kform.getAtid();
/*  75 */     String teccode = kform.getTeccode().trim();
/*  76 */     String advice2 = tochi.toChinese(kform.getAdvice2());
/*     */ 
/*  79 */     if (!op.equals("shenhe2")) {
/*  80 */       request.setAttribute("notice", "出错了！！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  81 */       return mapping.findForward("error");
/*  84 */     }
/*     */ ApplyTec applytec = new ApplyTec();
/*  85 */     ApplyTecDAO atdao = new ApplyTecDAO();
/*  86 */     applytec = atdao.findById(atid);
/*  87 */     Date applydate = new Date();
/*  88 */     applytec.setTitle(title);
/*  89 */     applytec.setDepartid(departid);
/*  90 */     applytec.setStusum(stusum);
/*  91 */     applytec.setTeccode(teccode);
/*  92 */     applytec.setTecprof(tecprof);
/*  93 */     applytec.setContent(content);
/*  94 */     applytec.setPreparework(preparework);
/*  95 */     applytec.setSource(source);
/*  96 */     applytec.setKind(kind);
/*  97 */     applytec.setPractise(practise);
/*  98 */     applytec.setComputer(computer);
/*  99 */     applytec.setCollegeid(collegeid);
/* 100 */     applytec.setApplydate(applydate);
/* 101 */     applytec.setApplytype(applytype);
/* 102 */     applytec.setGradeid(gradeid);
/* 103 */     applytec.setAdvice2(advice2);
/* 104 */     Date date2 = new Date();
/* 105 */     applytec.setDate2(date2);
/* 106 */     applytec.setSign2(session.getAttribute("userrealname").toString());
/*     */ 
/* 108 */     Transaction ts = atdao.getSession().beginTransaction();
/*     */     ActionForward localActionForward2;
/*     */     try {
/* 110 */       atdao.getSession().update(applytec);
/* 111 */       atdao.getSession().flush();
/* 112 */       ts.commit();
/* 113 */       request.setAttribute("notice", "审核课题 " + title + " 成功");
/* 114 */       request.setAttribute("departid", departid);
/*     */ 
/* 116 */       ApplyState as = new ApplyState();
/* 117 */       ApplyStateDAO asdao = new ApplyStateDAO();
/* 118 */       as = asdao.findById(atid);
/* 119 */       as.setAtid(applytec.getAtid());
/* 120 */       as.setAdvice2(advice2);
/* 121 */       Transaction tsas = asdao.getSession().beginTransaction();
/*     */       try {
/* 123 */         asdao.getSession().update(as);
/* 124 */         asdao.getSession().flush();
/* 125 */         tsas.commit();
/*     */       } catch (RuntimeException re) {
/* 127 */         System.out.println("异常信息：" + re);
/* 128 */         asdao.getSession().clear();
/* 129 */         tsas.rollback();
/* 130 */         request.setAttribute("notice", "编辑课题  " + title + " 资料失败！！！");
/* 131 */         ActionForward localActionForward1 = mapping.findForward("error");
/*     */ 
/* 133 */         asdao.getSession().clear();
/* 134 */         asdao.getSession().close();
/*     */ 
/* 131 */         return localActionForward1;
/*     */       } finally {
/* 133 */         asdao.getSession().clear();
/* 134 */         asdao.getSession().close();
/*     */       }
/*     */ 
/* 138 */       return mapping.findForward("success");
/*     */     } catch (RuntimeException re) {
/* 140 */       System.out.println("异常信息：" + re);
/* 141 */       atdao.getSession().clear();
/* 142 */       ts.rollback();
/* 143 */       request.setAttribute("notice", "审核课题  " + title + " 资料失败！！！");
/* 144 */       return mapping.findForward("error");
/*     */     } finally {
/* 146 */       atdao.getSession().clear();
/* 147 */       atdao.getSession().close();
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.KetishenhesaveAction
 * JD-Core Version:    0.5.4
 */