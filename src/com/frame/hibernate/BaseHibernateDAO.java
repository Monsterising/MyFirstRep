/*    */ package com.frame.hibernate;
/*    */ 
/*    */ import org.hibernate.Session;
/*    */ 
/*    */ public class BaseHibernateDAO
/*    */   implements IBaseHibernateDAO
/*    */ {
/*    */   public Session getSession()
/*    */   {
/* 16 */     return HibernateSessionFactory.getSession();
/*    */   }
/*    */   public void closeSession() {
/* 19 */     HibernateSessionFactory.closeSession();
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.hibernate.BaseHibernateDAO
 * JD-Core Version:    0.5.4
 */