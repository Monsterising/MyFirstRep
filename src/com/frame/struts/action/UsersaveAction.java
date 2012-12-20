/*     */ package com.frame.struts.action;
/*     */ 
/*     */ import com.entity.basedata.CollegeUser;
/*     */ import com.entity.basedata.CollegeUserDAO;
/*     */ import com.entity.basedata.Users;
/*     */ import com.entity.basedata.UsersDAO;
/*     */ import com.frame.struts.baseform.UseraddForm;
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
/*     */ public class UsersaveAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  47 */     HttpSession session = request.getSession();
/*  48 */     if (session.getAttribute("adminid") == null) {
/*  49 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  50 */       return mapping.findForward("error");
/*     */     }
/*  52 */     UseraddForm useraddForm = (UseraddForm)form;
/*  53 */     toChi tochi = new toChi();
/*  54 */     Integer collegeid = useraddForm.getCollegeid();
/*  55 */     Integer userrole = useraddForm.getUserrole();
/*  56 */     String username = tochi.toChinese(useraddForm.getUsername().trim());
/*  57 */     String userpass = tochi.toChinese(useraddForm.getUserpass().trim());
/*  58 */     String userrealname = tochi.toChinese(useraddForm.getUserrealname().trim());
/*  59 */     Integer userid = useraddForm.getUserid();
/*  60 */     String op = useraddForm.getOp();
/*  61 */     System.out.print("op=" + op);
/*     */ 
/*  64 */     if ((username.equals("")) || (userpass.equals("")) || (userrealname.equals(""))) {
/*  65 */       request.setAttribute("notice", "添加管理员 " + username + " 资料失败！！！<br>每一项都要填写！");
/*  66 */       return mapping.findForward("fail");
/*     */     }
/*     */ 
/*  71 */     Users users = new Users();
/*  72 */     UsersDAO udao = new UsersDAO();
/*     */ 
/*  74 */     if (op.equals("gxin")) {
/*  75 */       users = udao.findById(userid);
/*     */     }
/*  77 */     users.setUsername(username);
/*  78 */     users.setUserpass(userpass);
/*  79 */     users.setUserrealname(userrealname);
/*  80 */     users.setUserrole(userrole);
/*  81 */     Transaction ts = udao.getSession().beginTransaction();
/*     */     try {
/*  83 */       udao.getSession().saveOrUpdate(users);
/*  84 */       udao.getSession().flush();
/*  85 */       ts.commit();
/*  86 */       userid = users.getUserid();
/*  87 */       System.out.println("userid=" + users.getUserid());
/*  88 */       System.out.println("添加成功！");
/*     */ 
/*  90 */       request.setAttribute("notice", "添加管理员 " + username + " 资料成功");
/*     */ 
/*  93 */       CollegeUser cu = new CollegeUser();
/*  94 */       CollegeUserDAO cudao = new CollegeUserDAO();
/*  95 */       if (op.equals("gxin")) {
/*  96 */         cu = cudao.findById(userid);
/*     */       }
/*  98 */       cu.setCollegeid(collegeid);
/*  99 */       cu.setCurole(userrole);
/* 100 */       cu.setUserid(userid);
/* 101 */       Transaction uts = cudao.getSession().beginTransaction();
/*     */       try {
/* 103 */         cudao.getSession().saveOrUpdate(cu);
/* 104 */         cudao.getSession().flush();
/* 105 */         uts.commit();
/*     */       }
/*     */       catch (RuntimeException re) {
/* 108 */         System.out.println("异常信息：" + re);
/* 109 */         cudao.getSession().clear();
/* 110 */         uts.rollback();
/* 111 */         request.setAttribute("notice", "添加管理员 " + username + " 资料失败！！！");
/* 112 */         return mapping.findForward("error");
/*     */       }
/*     */     }
/*     */     catch (RuntimeException re) {
/* 116 */       System.out.println("异常信息：" + re);
/* 117 */       udao.getSession().clear();
/* 118 */       ts.rollback();
/* 119 */       request.setAttribute("notice", "添加管理员 " + username + " 资料失败！！！");
/* 120 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/* 125 */     return mapping.findForward("list");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.UsersaveAction
 * JD-Core Version:    0.5.4
 */