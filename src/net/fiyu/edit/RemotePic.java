/*    */ package net.fiyu.edit;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.InputStream;
/*    */ import java.io.PrintStream;
/*    */ import java.net.HttpURLConnection;
/*    */ import java.net.URL;
/*    */ import java.net.URLConnection;
/*    */ 
/*    */ public class RemotePic
/*    */ {
/*    */   public String picurl;
/*    */   public String savepath;
/*    */ 
/*    */   public boolean download()
/*    */   {
/* 27 */     String s = this.picurl;
/* 28 */     String s1 = this.savepath;
/*    */     try
/*    */     {
/* 31 */       URL url = new URL(s);
/* 32 */       URLConnection urlconnection = url.openConnection();
/* 33 */       urlconnection.connect();
/* 34 */       HttpURLConnection httpurlconnection = (HttpURLConnection)urlconnection;
/* 35 */       int i = httpurlconnection.getResponseCode();
/* 36 */       if (i != 200)
/*    */       {
/* 38 */         System.out.println("Connect to " + s + " failed,return code:" + i);
/* 39 */         return false;
/*    */       }
/* 41 */       int j = urlconnection.getContentLength();
/* 42 */       InputStream inputstream = urlconnection.getInputStream();
/* 43 */       byte[] abyte0 = new byte[1024];
/* 44 */       File file = new File(s1);
/* 45 */       if (!file.exists())
/* 46 */         file.createNewFile();
/* 47 */       FileOutputStream fileoutputstream = new FileOutputStream(file);
/* 48 */       int k = 0;
/* 49 */       if (j < 0)
/*    */       {
/* 51 */         while (k > -1)
/*    */         {
/* 53 */           k = inputstream.read(abyte0);
/* 54 */           if (k > 0)
/* 55 */             fileoutputstream.write(abyte0, 0, k);
/*    */         }
/*    */       }
/*    */       else
/*    */       {
/* 60 */         for (int l = 0; (l < j) && (k != -1); )
/*    */         {
/* 62 */           k = inputstream.read(abyte0);
/* 63 */           if (k <= 0)
/*    */             continue;
/* 65 */           fileoutputstream.write(abyte0, 0, k);
/* 66 */           l += k;
/*    */         }
/*    */ 
///* 70 */         if (l< j)
///*    */         {
///* 72 */           System.out.println("download error");
///* 73 */           inputstream.close();
///* 74 */           fileoutputstream.close();
///* 75 */           file.delete();
///* 76 */           return false;
///*    */         }
/*    */       }
/* 79 */       fileoutputstream.flush();
/* 80 */       fileoutputstream.close();
/* 81 */       inputstream.close();
/*    */     }
/*    */     catch (Exception exception)
/*    */     {
/* 85 */       exception.printStackTrace();
/* 86 */       return false;
/*    */     }
/* 88 */     return true;
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     net.fiyu.edit.RemotePic
 * JD-Core Version:    0.5.4
 */