/*     */ package com.frame.struts.action.task;
/*     */ 
/*     */ import com.entity.basedata.StuList;
/*     */ import com.entity.basedata.StuListDAO;
/*     */ import com.entity.task.Stagetask;
/*     */ import com.entity.task.StagetaskDAO;
/*     */ import com.entity.task.Stagetaskfujian;
/*     */ import com.entity.task.StagetaskfujianDAO;
/*     */ import com.frame.struts.form.task.StagetaskForm;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Date;
/*     */ import javax.servlet.ServletContext;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.apache.struts.action.Action;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionForward;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ import org.apache.struts.upload.FormFile;
/*     */ import org.hibernate.Session;
/*     */ import org.hibernate.Transaction;
/*     */ import pub.toChi;
/*     */ 
/*     */ public class StagetaskstusaveAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws IOException
/*     */   {
/*  58 */     HttpSession session = request.getSession();
/*  59 */     if (session.getAttribute("stucode") == null) {
/*  60 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  61 */       return mapping.findForward("error");
/*     */     }
/*  63 */     String stucode = session.getAttribute("stucode").toString();
/*     */ 
/*  65 */     StuList stu = new StuList();
/*  66 */     StuListDAO studao = new StuListDAO();
/*  67 */     stu = studao.findById(stucode);
/*     */ 
/*  69 */     StagetaskForm sform = (StagetaskForm)form;
/*  70 */     FormFile myfile = sform.getMyfile();
/*  71 */     System.out.println("myfile=" + myfile);
/*  72 */     String filename = myfile.getFileName();
/*  73 */     String filereal = "";
/*  74 */     Integer isFujian = Integer.valueOf(0);
/*  75 */     if (!filename.equals("")) {
/*  76 */       isFujian = Integer.valueOf(1);
/*  77 */       String exname = filename.substring(filename.lastIndexOf(".") + 1);
/*  78 */       System.out.println("exname=" + exname);
/*  79 */       System.out.println("myfile.getFileSize()=" + myfile.getFileSize() / 1024);
/*  80 */       if (filename.indexOf(".") != filename.lastIndexOf(".")) {
/*  81 */         request.setAttribute("notice", "文件名中不能有多个“.”哦！<br/><br/><a href='javascript:history.go(-1);'>返回</a>");
/*  82 */         return mapping.findForward("error");
/*     */       }
/*     */ 
/*  85 */       if ((((exname.equals("doc")) ? 0 : 1) & ((exname.equals("xls")) ? 0 : 1) & ((exname.equals("ppt")) ? 0 : 1) & (
/*  85 */         (exname.equals("rar")) ? 0 : 1) & ((exname.equals("jpg")) ? 0 : 1) & ((exname.equals("pdf")) ? 0 : 1)) != 0) {
/*  86 */         request.setAttribute("notice", "文件类型不符！<br/><br/><a href='javascript:history.go(-1);'>返回</a>");
/*  87 */         return mapping.findForward("error");
/*     */       }
/*  89 */       if (myfile.getFileSize() / 1024 > 2048) {
/*  90 */         request.setAttribute("notice", "文件大小超过3MB，请压缩文档，比如文档中用到的图片可以小一点！<br/><br/><a href='javascript:history.go(-1);'>返回</a>");
/*  91 */         return mapping.findForward("error");
/*     */       }
/*  93 */       String dir = request.getSession().getServletContext().getRealPath("/") + "stagetask/" + stu.getDepartid();
/*  94 */       File uploadFile = new File(dir);
/*  95 */       String path = uploadFile.getAbsolutePath();
/*     */ 
/*  97 */       if ((!uploadFile.exists()) || (uploadFile == null)) {
/*  98 */         uploadFile.mkdirs();
/*     */       }
/* 100 */       filereal = path + "\\" + stucode + "-" + sform.getStid() + myfile.getFileName();
/*     */ 
/* 102 */       request.setAttribute("filename", filereal);
/*     */       try
/*     */       {
/* 106 */         FileOutputStream fos = new FileOutputStream(path + "\\" + stucode + "-" + sform.getStid() + myfile.getFileName());
/* 107 */         fos.write(myfile.getFileData());
/* 108 */         fos.flush();
/* 109 */         fos.close();
/*     */       } catch (FileNotFoundException e) {
/* 111 */         request.setAttribute("notice", "上传文件失败！");
/* 112 */         e.printStackTrace();
/* 113 */         return mapping.findForward("error");
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 120 */     Stagetask st = new Stagetask();
/* 121 */     StagetaskDAO stdao = new StagetaskDAO();
/* 122 */     toChi tochi = new toChi();
/* 123 */     Date date = new Date();
/* 124 */     st = stdao.findById(sform.getStid());
/* 125 */     st.setIsFinish(Integer.valueOf(1));
/* 126 */     st.setNotes(tochi.toChinese(sform.getNotes()));
/* 127 */     st.setIsFujian(isFujian);
/* 128 */     st.setFujiantime(date);
/* 129 */     Transaction ts = stdao.getSession().beginTransaction();
/*     */     try {
/* 131 */       stdao.getSession().saveOrUpdate(st);
/* 132 */       stdao.getSession().flush();
/* 133 */       ts.commit();
/* 134 */       stdao.getSession().close();
/* 135 */       request.setAttribute("notice", "阶段任务提交 成功");
/*     */     } catch (RuntimeException re) {
/* 137 */       System.out.println("异常信息：" + re);
/* 138 */       stdao.getSession().clear();
/* 139 */       ts.rollback();
/* 140 */       request.setAttribute("notice", "阶段任务失败！！！");
/* 141 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/* 144 */     if (isFujian.intValue() == 1)
/*     */     {
/* 146 */       Stagetaskfujian fujian = new Stagetaskfujian();
/* 147 */       StagetaskfujianDAO fjdao = new StagetaskfujianDAO();
/*     */ 
/* 149 */       if (sform.getFujianid().intValue() != 0) {
/* 150 */         fujian = fjdao.findById(sform.getFujianid());
/*     */       }
/*     */ 
/* 153 */       fujian.setName(stucode + "-" + sform.getStid() + filename);
/* 154 */       fujian.setStid(st.getStid());
/* 155 */       fujian.setStucode(stucode);
/* 156 */       fujian.setUptime(date);
/* 157 */       fujian.setUrl(filereal);
/* 158 */       Transaction ts2 = fjdao.getSession().beginTransaction();
/*     */       try {
/* 160 */         fjdao.getSession().saveOrUpdate(fujian);
/* 161 */         fjdao.getSession().flush();
/* 162 */         ts2.commit();
/* 163 */         fjdao.getSession().close();
/* 164 */         request.setAttribute("notice", "阶段任务提交 成功");
/*     */       } catch (RuntimeException re) {
/* 166 */         System.out.println("异常信息：" + re);
/* 167 */         fjdao.getSession().clear();
/* 168 */         ts2.rollback();
/* 169 */         request.setAttribute("notice", "阶段任务失败！！！");
/* 170 */         return mapping.findForward("error");
/*     */       }
/*     */     }
/* 173 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.task.StagetaskstusaveAction
 * JD-Core Version:    0.5.4
 */