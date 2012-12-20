/*     */ package com.frame.struts.action.college;
/*     */ 
/*     */ import com.entity.basedata.StuList;
/*     */ import com.entity.basedata.StuListDAO;
/*     */ import java.io.File;
/*     */ import java.io.PrintStream;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import jxl.Cell;
/*     */ import jxl.Sheet;
/*     */ import jxl.Workbook;
/*     */ import org.apache.struts.action.Action;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionForward;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ import org.hibernate.Session;
/*     */ import org.hibernate.Transaction;
/*     */ 
/*     */ public class ImportStusAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  50 */     HttpSession session = request.getSession();
/*  51 */     if (session.getAttribute("adminid") == null) {
/*  52 */       request.setAttribute("notice", "登录超时！<br/><br/><a href='./index.do' target='_parent'>返回</a>");
/*  53 */       return mapping.findForward("error");
/*     */     }
/*  55 */     System.out.println("开始导入");
/*  56 */     String filename = (String)request.getAttribute("filename");
/*  57 */     System.out.println(filename);
/*  58 */     Integer number = Integer.valueOf(0);
/*  59 */     String stucode = "";
/*  60 */     String stuname = "";
/*     */ 
/*  62 */     Integer collegeid = Integer.valueOf(Integer.parseInt(request.getAttribute("collegeid").toString()));
/*  63 */     Integer departid = Integer.valueOf(Integer.parseInt(request.getAttribute("departid").toString()));
/*  64 */     Integer gradeid = Integer.valueOf(Integer.parseInt(request.getAttribute("gradeid").toString()));
/*  65 */     Integer classid = Integer.valueOf(Integer.parseInt(request.getAttribute("classid").toString()));
/*     */     try
/*     */     {
/*  69 */       Workbook workbook = Workbook.getWorkbook(new File(filename));
/*  70 */       Sheet sheet = workbook.getSheet(0);
/*     */ 
/*  72 */       System.out.println("列数：" + sheet.getColumns());
/*  73 */       System.out.println("行数：" + sheet.getRows());
/*     */ 
/*  75 */       System.out.println("开始导入");
/*  76 */       //Byte isreg = Byte.valueOf(0);
/*  77 */       for (int i = 1; i < sheet.getRows(); ++i)
/*     */       {
/*  79 */         StuList studata = new StuList();
/*  80 */         studata.setCollegeid(collegeid);
/*  81 */         studata.setDepartid(departid);
/*  82 */         studata.setGradeid(gradeid);
/*  83 */         studata.setClassid(classid);
/*     */ 
/*  85 */         Cell cell = sheet.getCell(0, i);
/*  86 */         studata.setStucode(cell.getContents().trim());
/*     */ 
/*  88 */         stucode = cell.getContents().trim();
/*     */ 
/*  90 */         cell = sheet.getCell(1, i);
/*  91 */         studata.setStuname(cell.getContents().trim());
/*     */ 
/*  93 */         stuname = cell.getContents().trim();
/*     */ 
/*  95 */         cell = sheet.getCell(2, i);
/*  96 */         studata.setStusex(cell.getContents().trim());
/*     */ 
/*  99 */         cell = sheet.getCell(0, i);
/* 100 */         studata.setStupass(cell.getContents().trim());
/*     */ 
/* 103 */         StuListDAO dao = new StuListDAO();
/* 104 */         dao.getSession().flush();
/* 105 */         if (i % 20 == 0) {
/* 106 */           dao.getSession().flush();
/* 107 */           System.out.println("正在导入" + i + "条记录");
/* 108 */         }if (i + 1 == sheet.getRows()) {
/* 109 */           dao.getSession().flush();
/* 110 */           System.out.println("正在导入" + i + "条记录");
/*     */         }
/* 112 */         Transaction ts = dao.getSession().beginTransaction();
/*     */         try {
/* 114 */           dao.getSession().saveOrUpdate(studata);
/* 115 */           ts.commit();
/*     */         } catch (Exception e) {
/* 117 */           number = Integer.valueOf(i);
/*     */ 
/* 119 */           ts.rollback();
/* 120 */           throw e;
/*     */         } finally {
/* 122 */           dao.getSession().clear();
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 127 */       request.setAttribute("notice", "共导入" + (sheet.getRows() - 1) + "条记录。");
/* 128 */       return mapping.findForward("list");
/*     */     } catch (Exception re) {
/* 130 */       re.printStackTrace();
/* 131 */       request.setAttribute("notice", "文件已经上传，但导入数据库失败，请联系管理员！<br>序号：" + number + "<br>学号：" + stucode.toString() + "<br>姓名：" + stuname);
/* 132 */     }return mapping.findForward("fail");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.college.ImportStusAction
 * JD-Core Version:    0.5.4
 */