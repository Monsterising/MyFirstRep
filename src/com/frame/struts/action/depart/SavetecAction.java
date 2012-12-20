/*    */ package com.frame.struts.action.depart;
/*    */ 
/*    */ import com.entity.basedata.TecExtra;
/*    */ import com.entity.basedata.TecExtraDAO;
/*    */ import com.frame.struts.baseform.SavetecForm;
/*    */ import java.io.PrintStream;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.apache.struts.action.Action;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.Transaction;
/*    */ import pub.Qdao;
/*    */ import pub.toChi;
/*    */ 
/*    */ public class SavetecAction extends Action
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 46 */     SavetecForm sform = (SavetecForm)form;
/* 47 */     toChi tochi = new toChi();
/* 48 */     String teccode = sform.getTeccode().trim();
/* 49 */     String tectel = sform.getTectel().trim();
/* 50 */     String tecemail = sform.getTecemail().trim();
/* 51 */     String tecqq = sform.getTecqq().trim();
/* 52 */     String tecprof = tochi.toChinese(sform.getTecprof().trim());
/* 53 */     String tecedu = tochi.toChinese(sform.getTecedu().trim());
/* 54 */     String tecfield = tochi.toChinese(sform.getTecfield());
/* 55 */     String techonor = tochi.toChinese(sform.getTechonor());
/* 56 */     String tecpass = sform.getTecpass().trim();
/*    */ 
/* 58 */     String hql = "";
/* 59 */     Qdao qdao = new Qdao();
/* 60 */     hql = "update TecList set tecpass='" + tecpass + "' where teccode='" + teccode + "'";
/* 61 */     qdao.update(hql);
/*    */ 
/* 64 */     TecExtra tecextra = new TecExtra();
/* 65 */     TecExtraDAO edao = new TecExtraDAO();
/*    */ 
/* 67 */     if (edao.getSession().get(TecExtra.class, teccode) != null) {
/* 68 */       tecextra = (TecExtra)edao.getSession().get(TecExtra.class, teccode);
/*    */     }
/*    */ 
/* 72 */     tecextra.setTeccode(teccode);
/* 73 */     tecextra.setTecedu(tecedu);
/* 74 */     tecextra.setTecemail(tecemail);
/* 75 */     tecextra.setTecfield(tecfield);
/* 76 */     tecextra.setTechonor(techonor);
/* 77 */     tecextra.setTecprof(tecprof);
/* 78 */     tecextra.setTecqq(tecqq);
/* 79 */     tecextra.setTectel(tectel);
/*    */ 
/* 82 */     Transaction ts = edao.getSession().beginTransaction();
/*    */     ActionForward localActionForward;
/*    */     try
/*    */     {
/* 85 */       edao.getSession().saveOrUpdate(tecextra);
/*    */ 
/* 87 */       ts.commit();
/* 88 */       edao.getSession().flush();
/* 89 */       request.setAttribute("notice", "设置教师个人资料成功！");
/* 90 */       return mapping.findForward("display");
/*    */     } catch (RuntimeException re) {
/* 92 */       System.out.println("异常信息：" + re);
/* 93 */       edao.getSession().clear();
/* 94 */       ts.rollback();
/* 95 */       request.setAttribute("notice", "设置个人信息失败！！！");
/* 96 */       return mapping.findForward("error");
/*    */     } finally {
/* 98 */       edao.getSession().close();
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.depart.SavetecAction
 * JD-Core Version:    0.5.4
 */