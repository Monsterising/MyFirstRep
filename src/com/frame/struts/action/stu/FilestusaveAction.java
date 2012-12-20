/*     */ package com.frame.struts.action.stu;
/*     */ 
/*     */ import com.entity.basedata.StuList;
/*     */ import com.entity.basedata.StuListDAO;
/*     */ import com.entity.wish.ApplyTecResult;
/*     */ import com.entity.wish.ApplyTecResultDAO;
/*     */ import com.frame.struts.form.wish.FileForm;
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
/*     */ public class FilestusaveAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws IOException
/*     */   {
/*  60 */     FileForm sform = (FileForm)form;
/*  61 */     HttpSession session = request.getSession();
/*  62 */     if (session.getAttribute("stucode") == null) {
/*  63 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  64 */       return mapping.findForward("error");
/*     */     }
/*  66 */     String stucode = session.getAttribute("stucode").toString();
/*     */ 
/*  68 */     StuList stu = new StuList();
/*  69 */     StuListDAO studao = new StuListDAO();
/*  70 */     stu = studao.findById(stucode);
/*     */ 
/*  72 */     FormFile myfile = sform.getMyfile();
/*  73 */     String filename = myfile.getFileName();
/*     */ 
/*  75 */     String exname = filename.substring(filename.lastIndexOf(".") + 1);
/*  76 */     System.out.println("exname=" + exname);
/*  77 */     System.out.println("myfile.getFileSize()=" + myfile.getFileSize() / 1024);
/*  78 */     if (filename.indexOf(".") != filename.lastIndexOf(".")) {
/*  79 */       request.setAttribute("notice", "文件名中不能有多个“.”哦！<br/><br/><a href='javascript:history.go(-1);'>返回</a>");
/*  80 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  85 */     if ((((exname.equals("doc")) ? 0 : 1) & ((exname.equals("xls")) ? 0 : 1) & ((exname.equals("ppt")) ? 0 : 1) & (
/*  84 */       (exname.equals("rar")) ? 0 : 1) & ((exname.equals("jpg")) ? 0 : 1) & ((exname.equals("pdf")) ? 0 : 1) & (
/*  85 */       (exname.equals("docx")) ? 0 : 1) & ((exname.equals("xlsx")) ? 0 : 1) & ((exname.equals("pptx")) ? 0 : 1)) != 0) {
/*  86 */       request.setAttribute("notice", "文件类型不符！<br/><br/><a href='javascript:history.go(-1);'>返回</a>");
/*  87 */       return mapping.findForward("error");
/*     */     }
/*  89 */     if (myfile.getFileSize() / 1024 > 2048) {
/*  90 */       request.setAttribute("notice", "文件大小超过3MB，请压缩文档，比如文档中用到的图片可以小一点！<br/><br/><a href='javascript:history.go(-1);'>返回</a>");
/*  91 */       return mapping.findForward("error");
/*     */     }
/*     */ 
/*  94 */     String dir = request.getSession().getServletContext().getRealPath("/") + "wenjian/" + stu.getDepartid();
/*  95 */     Integer isFujian = Integer.valueOf(0);
/*  96 */     if (myfile != null) {
/*  97 */       File uploadFile = new File(dir);
/*  98 */       String path = uploadFile.getAbsolutePath();
/*  99 */       if ((!uploadFile.exists()) || (uploadFile == null))
/* 100 */         uploadFile.mkdirs();
/* 101 */       String filereal = path + "\\" + stucode + "-" + myfile.getFileName();
/* 102 */       request.setAttribute("filename", filereal);
/*     */       try
/*     */       {
/* 105 */         FileOutputStream fos = new FileOutputStream(path + "\\" + stucode + "-" + myfile.getFileName());
/* 106 */         fos.write(myfile.getFileData());
/* 107 */         fos.flush();
/* 108 */         fos.close();
/*     */       } catch (FileNotFoundException e) {
/* 110 */         request.setAttribute("notice", "上传文件失败！");
/* 111 */         e.printStackTrace();
/* 112 */         return mapping.findForward("error");
/*     */       }
/*     */       FileOutputStream fos;
/* 116 */       ApplyTecResult st = new ApplyTecResult();
/* 117 */       ApplyTecResultDAO stdao = new ApplyTecResultDAO();
/* 118 */       toChi tochi = new toChi();
/* 119 */       Date date = new Date();
/* 120 */       st = stdao.findById(sform.getAtrid());
/* 121 */       st.setIsok(Integer.valueOf(1));
/* 122 */       st.setUrl(stucode + "-" + myfile.getFileName());
/* 123 */       st.setStucode(stucode);
/* 124 */       st.setUptime(date);
/* 125 */       Transaction ts = stdao.getSession().beginTransaction();
/*     */       try {
/* 127 */         stdao.getSession().saveOrUpdate(st);
/* 128 */         stdao.getSession().flush();
/* 129 */         ts.commit();
/* 130 */         stdao.getSession().close();
/* 131 */         request.setAttribute("notice", "文件提交 成功");
/*     */       } catch (RuntimeException re) {
/* 133 */         System.out.println("异常信息：" + re);
/* 134 */         stdao.getSession().clear();
/* 135 */         ts.rollback();
/* 136 */         request.setAttribute("notice", "文件任务失败！！！");
/* 137 */         return mapping.findForward("error");
/*     */       }
/*     */ 
/* 141 */       return mapping.findForward("display");
/*     */     }
/* 143 */     request.setAttribute("notice", "请选择本地文件！");
/* 144 */     return mapping.findForward("error");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.stu.FilestusaveAction
 * JD-Core Version:    0.5.4
 */