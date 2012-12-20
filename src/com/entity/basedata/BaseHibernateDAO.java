/*    */ package com.entity.basedata;
/*    */ 
/*    */ import com.frame.hibernate.HibernateSessionFactory;
/*    */ import org.hibernate.Session;
/*    */ 
/*    */ public class BaseHibernateDAO
/*    */   implements IBaseHibernateDAO
/*    */ {
/*    */   public Session getSession()
/*    */   {
/* 14 */     return HibernateSessionFactory.getSession();
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.basedata.BaseHibernateDAO
 * JD-Core Version:    0.5.4
 */