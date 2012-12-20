/*    */ package pub;
/*    */ 
/*    */ public class toChi
/*    */ {
/*    */   public String toChinese(String strvalue)
/*    */   {
/*    */     try
/*    */     {
/*  7 */       if (strvalue == null) {
/*  8 */         return "";
/*    */       }
/* 10 */       strvalue = new String(strvalue.getBytes("ISO8859_1"), "GBK").trim();
/* 11 */       return strvalue;
/*    */     } catch (Exception e) {
/*    */     }
/* 14 */     return "";
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     pub.toChi
 * JD-Core Version:    0.5.4
 */