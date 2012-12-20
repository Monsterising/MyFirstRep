/*    */ package net.fiyu.edit;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.PrintStream;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import org.dom4j.Document;
/*    */ import org.dom4j.Element;
/*    */ import org.dom4j.io.SAXReader;
/*    */ 
/*    */ public class UploadWebHelper
/*    */ {
/*    */   Document document;
/*    */   EditWebhelper ew;
/*    */   public String filename;
/*    */ 
/*    */   public UploadWebHelper()
/*    */   {
/* 20 */     this.filename = "D:/style2.xml";
/* 21 */     this.document = null;
/* 22 */     this.ew = null;
/*    */   }
/*    */ 
/*    */   public UploadBean InitPara()
/*    */   {
/* 37 */     UploadBean bean = new UploadBean();
/* 38 */     String sToolBar = "";
/*    */     try {
/* 40 */       List list = this.document.selectNodes("Edit_Style/style");
/* 41 */       bean.setSfileext(getNodeValue(list, "sfileext"));
/* 42 */       bean.setSfilesize(getNodeValue(list, "sfilesize"));
/* 43 */       bean.setSflashext(getNodeValue(list, "sflashext"));
/* 44 */       bean.setSflashsize(getNodeValue(list, "sflashsize"));
/* 45 */       bean.setSimageext(getNodeValue(list, "simageext"));
/* 46 */       bean.setSimagesize(getNodeValue(list, "simagesize"));
/* 47 */       bean.setSmediaext(getNodeValue(list, "smediaext"));
/* 48 */       bean.setSmediasize(getNodeValue(list, "smediasize"));
/* 49 */       bean.setSremoteext(getNodeValue(list, "sremoteext"));
/* 50 */       bean.setSremotesize(getNodeValue(list, "sremotesize"));
/* 51 */       bean.setSuploaddir(getNodeValue(list, "suploaddir"));
/*    */     }
/*    */     catch (Exception e) {
/* 54 */       System.out.println(e.getMessage());
/*    */     }
/* 56 */     this.document = null;
/* 57 */     return bean;
/*    */   }
/*    */ 
/*    */   public UploadWebHelper getInstance()
/*    */   {
/* 25 */     UploadWebHelper uw = new UploadWebHelper();
/*    */     try {
/* 27 */       SAXReader saxReader = new SAXReader();
/* 28 */       this.document = saxReader.read(new File(this.filename));
/*    */     }
/*    */     catch (Exception e) {
/* 31 */       System.out.println(e.getMessage());
/*    */     }
/* 33 */     return uw;
/*    */   }
/*    */ 
/*    */   public String getNodeValue(List list, String Node)
/*    */   {
/* 61 */     Iterator it = list.iterator();
/* 62 */     if (it.hasNext()) {
/* 63 */       Element styleElement = (Element)it.next();
/*    */ 
/* 65 */       Iterator memo = styleElement.elementIterator(Node);
/* 66 */       if (memo.hasNext()) {
/* 67 */         Element memostring = (Element)memo.next();
/* 68 */         return memostring.getTextTrim();
/*    */       }
/*    */ 
/* 71 */       return "";
/*    */     }
/*    */ 
/* 75 */     return "";
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/* 82 */     UploadWebHelper w = new UploadWebHelper();
/* 83 */     w.getInstance();
/* 84 */     UploadBean bean = w.InitPara();
/* 85 */     System.out.println(bean.getSfileext());
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     net.fiyu.edit.UploadWebHelper
 * JD-Core Version:    0.5.4
 */