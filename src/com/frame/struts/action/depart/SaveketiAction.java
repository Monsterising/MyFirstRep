/*     */ package com.frame.struts.action.depart;
/*     */ 
/*     */ import com.entity.wish.ApplyState;
/*     */ import com.entity.wish.ApplyStateDAO;
/*     */ import com.entity.wish.ApplyTec;
/*     */ import com.entity.wish.ApplyTecDAO;
/*     */ import com.entity.wish.ApplyTecResult;
/*     */ import com.entity.wish.ApplyTecResultDAO;
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
/*     */ import pub.Qdao;
/*     */ import pub.toChi;
/*     */ 
/*     */ public class SaveketiAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  54 */     KetishenbaoForm kform = (KetishenbaoForm)form;
/*     */ 
/*  56 */     HttpSession session = request.getSession();
/*  57 */     if (session.getAttribute("teccode") == null) {
/*  58 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  59 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  62 */     toChi tochi = new toChi();
/*  63 */     String title = tochi.toChinese(kform.getTitle());
/*  64 */     Integer collegeid = Integer.valueOf(Integer.parseInt(session.getAttribute("collegeid").toString()));
/*  65 */     Integer departid = kform.getDepartid();
/*  66 */     Integer gradeid = kform.getGradeid();
/*  67 */     String tecprof = tochi.toChinese(kform.getTecprof());
/*  68 */     Integer stusum = kform.getStusum();
/*  69 */     String content = tochi.toChinese(kform.getContent());
/*  70 */     String preparework = tochi.toChinese(kform.getPreparework());
/*  71 */     String applytypename = tochi.toChinese(kform.getApplytypename());
/*  72 */     String source = tochi.toChinese(kform.getSource());
/*  73 */     String kind = tochi.toChinese(kform.getKind());
/*  74 */     String practise = tochi.toChinese(kform.getPractise());
/*  75 */     String computer = tochi.toChinese(kform.getComputer());
/*  76 */     Integer[] resultids = kform.getResultids();
/*  77 */     String op = kform.getOp();
/*  78 */     Integer atid = kform.getAtid();
/*  79 */     String teccode = kform.getTeccode().trim();
/*     */ 
/*  88 */     ApplyTec applytec = new ApplyTec();
/*  89 */     ApplyTecDAO atdao = new ApplyTecDAO();
/*  90 */     if (op.equals("edit")) {
/*  91 */       applytec = atdao.findById(atid);
/*     */     }
/*  93 */     Date applydate = new Date();
/*  94 */     applytec.setTitle(title);
/*  95 */     applytec.setDepartid(departid);
/*  96 */     applytec.setStusum(stusum);
/*  97 */     applytec.setTeccode(teccode);
/*  98 */     applytec.setTecprof(tecprof);
/*  99 */     applytec.setContent(content);
/* 100 */     applytec.setPreparework(preparework);
/* 101 */     applytec.setSource(source);
/* 102 */     applytec.setKind(kind);
/* 103 */     applytec.setPractise(practise);
/* 104 */     applytec.setComputer(computer);
/* 105 */     applytec.setCollegeid(collegeid);
/* 106 */     applytec.setApplydate(applydate);
/* 107 */     applytec.setApplytypename(applytypename);
/* 108 */     applytec.setGradeid(gradeid);
/* 109 */     applytec.setAdvice1("等待审核");
/* 110 */     applytec.setAdvice2("等待审核");
/*     */ 
/* 115 */     Transaction ts = atdao.getSession().beginTransaction();
/*     */     try {
/* 117 */       atdao.getSession().saveOrUpdate(applytec);
/* 118 */       atdao.getSession().flush();
/* 119 */       ts.commit();
/*     */ 
/* 121 */       ApplyState as = new ApplyState();
/* 122 */       ApplyStateDAO asdao = new ApplyStateDAO();
/*     */ 
/* 124 */       if ((op.equals("edit")) && 
/* 125 */         (asdao.findById(atid) != null)) {
/* 126 */         as = asdao.findById(atid);
/*     */       }
/*     */ 
/* 129 */       as.setAtid(applytec.getAtid());
/* 130 */       as.setAdvice1("等待审核");
/* 131 */       as.setAdvice2("等待审核");
/* 132 */       Transaction tsas = asdao.getSession().beginTransaction();
/*     */       try
/*     */       {
/* 135 */         asdao.getSession().saveOrUpdate(as);
/* 136 */         asdao.getSession().flush();
/* 137 */         tsas.commit();
/*     */       } catch (RuntimeException re) {
/* 139 */         System.out.println("异常信息：" + re);
/* 140 */         asdao.getSession().clear();
/* 141 */         tsas.rollback();
/* 142 */         request.setAttribute("notice", "编辑课题  " + title + " 资料失败！！！");
/* 143 */         return mapping.findForward("error");
/*     */       }
/*     */ 
/* 149 */       if (op.equals("edit")) {
/* 150 */         atid = applytec.getAtid();
/* 151 */         String hql = "delete ApplyTecResult where atid=" + atid;
/* 152 */         Qdao qdao = new Qdao();
/* 153 */         qdao.del(hql);
/*     */       }
/*     */ 
/* 158 */       if ((op.equals("new")) || (op.equals("edit"))) {
/* 159 */         atid = applytec.getAtid();
/* 160 */         ApplyTecResultDAO atrdao = new ApplyTecResultDAO();
/* 161 */         Transaction ats = atrdao.getSession().beginTransaction();
/* 162 */         for (int i = 0; i < resultids.length; ++i) {
/* 163 */           ApplyTecResult atr = new ApplyTecResult();
/* 164 */           atr.setAtid(atid);
/* 165 */           atr.setResultid(resultids[i]);
/* 166 */           atrdao.getSession().save(atr);
/*     */         }
/* 168 */         atrdao.getSession().flush();
/* 169 */         ats.commit();
/*     */       }
/*     */ 
/* 177 */       request.setAttribute("notice", "编辑课题 " + title + " 资料成功");
/* 178 */       request.setAttribute("departid", departid);
/* 179 */       return mapping.findForward("success");
/*     */     }
/*     */     catch (RuntimeException re)
/*     */     {
/* 190 */       System.out.println("异常信息：" + re);
/* 191 */       atdao.getSession().clear();
/* 192 */       ts.rollback();
/* 193 */       request.setAttribute("notice", "编辑课题  " + title + " 资料失败！！！");
/* 194 */     }return mapping.findForward("error");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.SaveketiAction
 * JD-Core Version:    0.5.4
 */