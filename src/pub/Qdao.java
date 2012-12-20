/*    */ package pub;
/*    */ 
/*    */ import com.frame.hibernate.BaseHibernateDAO;
/*    */ import java.io.PrintStream;
/*    */ import java.util.List;
/*    */ import org.hibernate.Query;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.Transaction;
/*    */ 
/*    */ public class Qdao extends BaseHibernateDAO
/*    */ {
/*    */   public List sql(String sql)
/*    */   {
/* 21 */     Query qq = getSession().createSQLQuery(sql);
/* 22 */     return qq.list();
/*    */   }
/*    */ 
/*    */   public List query(String hql)
/*    */   {
/* 27 */     Query queryObject = null;
/*    */ 
/* 30 */     getSession().clear();
/* 31 */     queryObject = getSession().createQuery(hql);
/*    */ 
/* 34 */     if (queryObject.equals(null)) {
/* 35 */       System.out.println("null,0-0-1");
/* 36 */       return null;
/*    */     }
/* 38 */     getSession().clear();
/*    */ 
/* 40 */     return queryObject.list();
/*    */   }
/*    */ 
/*    */   public Object count(String hql) {
/* 44 */     Query queryObject = null;
/* 45 */     getSession().clear();
/*    */ 
/* 47 */     queryObject = getSession().createQuery(hql);
/*    */ 
/* 49 */     getSession().clear();
/* 50 */     return queryObject.uniqueResult();
/*    */   }
/*    */ 
/*    */   public boolean del(String hql)
/*    */   {
/* 55 */     Transaction ts = getSession().beginTransaction();
/*    */     try {
/* 57 */       Query queryObject = getSession().createQuery(hql);
/* 58 */       queryObject.executeUpdate();
/* 59 */       ts.commit();
/*    */     }
/*    */     catch (RuntimeException re) {
/* 62 */       ts.rollback();
/* 63 */       throw re;
/*    */     }
/*    */     finally {
/* 66 */       getSession().clear();
/* 67 */       closeSession();
/*    */     }
/* 69 */     return true;
/*    */   }
/*    */ 
/*    */   public boolean update(String hql)
/*    */   {
/* 75 */     Transaction ts = getSession().beginTransaction();
/*    */     try
/*    */     {
/* 78 */       Query queryObject = getSession().createQuery(hql);
/* 79 */       queryObject.executeUpdate();
/* 80 */       ts.commit();
/*    */     }
/*    */     catch (RuntimeException re) {
/* 83 */       ts.rollback();
/* 84 */       throw re;
/*    */     }
/*    */     finally {
/* 87 */       getSession().clear();
/* 88 */       closeSession();
/*    */     }
/* 90 */     return true;
/*    */   }
/*    */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     pub.Qdao
 * JD-Core Version:    0.5.4
 */