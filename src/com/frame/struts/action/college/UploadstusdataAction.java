/*     */ package com.frame.struts.action.college;
/*     */ 
/*     */ import com.frame.struts.baseform.UploadStusForm;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import javax.servlet.ServletContext;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.apache.struts.action.Action;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionForward;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ import org.apache.struts.upload.FormFile;
/*     */ 
/*     */ public class UploadstusdataAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws IOException
/*     */   {
/*  47 */     System.out.println("upload 开始");
/*  48 */     UploadStusForm uform = (UploadStusForm)form;
/*  49 */     HttpSession session = request.getSession();
/*  50 */     if (session.getAttribute("adminid") == null) {
/*  51 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  52 */       return mapping.findForward("error");
/*     */     }
/*  54 */     request.setAttribute("collegeid", uform.getCollegeid());
/*  55 */     request.setAttribute("departid", uform.getDepartid());
/*  56 */     request.setAttribute("gradeid", uform.getGradeid());
/*  57 */     request.setAttribute("classid", uform.getClassid());
/*     */ 
/*  61 */     FormFile myfile = uform.getMyfile();
/*  62 */     String dir = request.getSession().getServletContext().getRealPath("/") + "importfiles";
/*     */ 
/*  65 */     if (myfile != null)
/*     */     {
/*  68 */       File uploadFile = new File(dir);
/*  69 */       String path = uploadFile.getAbsolutePath();
/*     */ 
/*  71 */       if ((!uploadFile.exists()) || (uploadFile == null)) {
/*  72 */         uploadFile.mkdirs();
/*     */       }
/*  74 */       String filereal = path + "\\" + myfile.getFileName();
/*  75 */       System.out.println(filereal);
/*  76 */       request.setAttribute("filename", filereal);
/*     */       try
/*     */       {
/*  80 */         FileOutputStream fos = new FileOutputStream(path + "\\" + myfile.getFileName());
/*  81 */         fos.write(myfile.getFileData());
/*  82 */         fos.flush();
/*  83 */         fos.close();
/*     */       }
/*     */       catch (FileNotFoundException e) {
/*  86 */         request.setAttribute("notice", "上传文件失败！");
/*  87 */         e.printStackTrace();
/*  88 */         return mapping.findForward("error");
/*     */       }
/*     */       FileOutputStream fos;
/*  98 */       System.out.println("即将转向：");
/*  99 */       return mapping.findForward("success");
/*     */     }
/* 101 */     request.setAttribute("notice", "请选择本地Excel文件！");
/* 102 */     return mapping.findForward("error");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.UploadstusdataAction
 * JD-Core Version:    0.5.4
 */