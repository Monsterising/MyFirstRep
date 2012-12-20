/*     */ package com.entity.wish;
/*     */ 
/*     */ import com.entity.basedata.BaseHibernateDAO;
/*     */ import java.util.List;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.hibernate.Criteria;
/*     */ import org.hibernate.LockMode;
/*     */ import org.hibernate.Query;
/*     */ import org.hibernate.Session;
/*     */ import org.hibernate.criterion.Example;
/*     */ 
/*     */ public class StuWishDAO extends BaseHibernateDAO
/*     */ {
/*  25 */   private static final Log log = LogFactory.getLog(StuWishDAO.class);
/*     */   public static final String STUCODE = "stucode";
/*     */   public static final String ATID = "atid";
/*     */   public static final String TECCODE = "teccode";
/*     */   public static final String PRIORITY = "priority";
/*     */   public static final String WISHSTATE = "wishstate";
/*     */ 
/*     */   public void save(StuWish transientInstance)
/*     */   {
/*  34 */     log.debug("saving StuWish instance");
/*     */     try {
/*  36 */       getSession().save(transientInstance);
/*  37 */       log.debug("save successful");
/*     */     } catch (RuntimeException re) {
/*  39 */       log.error("save failed", re);
/*  40 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void delete(StuWish persistentInstance) {
/*  45 */     log.debug("deleting StuWish instance");
/*     */     try {
/*  47 */       getSession().delete(persistentInstance);
/*  48 */       log.debug("delete successful");
/*     */     } catch (RuntimeException re) {
/*  50 */       log.error("delete failed", re);
/*  51 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public StuWish findById(Integer id) {
/*  56 */     log.debug("getting StuWish instance with id: " + id);
/*     */     try {
/*  58 */       StuWish instance = (StuWish)getSession().get(
/*  59 */         "com.entity.wish.StuWish", id);
/*  60 */       return instance;
/*     */     } catch (RuntimeException re) {
/*  62 */       log.error("get failed", re);
/*  63 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByExample(StuWish instance) {
/*  68 */     log.debug("finding StuWish instance by example");
/*     */     try {
/*  70 */       List results = getSession().createCriteria(
/*  71 */         "com.entity.wish.StuWish").add(Example.create(instance))
/*  72 */         .list();
/*  73 */       log.debug("find by example successful, result size: " + 
/*  74 */         results.size());
/*  75 */       return results;
/*     */     } catch (RuntimeException re) {
/*  77 */       log.error("find by example failed", re);
/*  78 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByProperty(String propertyName, Object value) {
/*  83 */     log.debug("finding StuWish instance with property: " + propertyName + 
/*  84 */       ", value: " + value);
/*     */     try {
/*  86 */       String queryString = "from StuWish as model where model." + 
/*  87 */         propertyName + "= ?";
/*  88 */       Query queryObject = getSession().createQuery(queryString);
/*  89 */       queryObject.setParameter(0, value);
/*  90 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/*  92 */       log.error("find by property name failed", re);
/*  93 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByStucode(Object stucode) {
/*  98 */     return findByProperty("stucode", stucode);
/*     */   }
/*     */ 
/*     */   public List findByAtid(Object atid) {
/* 102 */     return findByProperty("atid", atid);
/*     */   }
/*     */ 
/*     */   public List findByTeccode(Object teccode) {
/* 106 */     return findByProperty("teccode", teccode);
/*     */   }
/*     */ 
/*     */   public List findByPriority(Object priority) {
/* 110 */     return findByProperty("priority", priority);
/*     */   }
/*     */ 
/*     */   public List findByWishstate(Object wishstate) {
/* 114 */     return findByProperty("wishstate", wishstate);
/*     */   }
/*     */ 
/*     */   public List findAll() {
/* 118 */     log.debug("finding all StuWish instances");
/*     */     try {
/* 120 */       String queryString = "from StuWish";
/* 121 */       Query queryObject = getSession().createQuery(queryString);
/* 122 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/* 124 */       log.error("find all failed", re);
/* 125 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public StuWish merge(StuWish detachedInstance) {
/* 130 */     log.debug("merging StuWish instance");
/*     */     try {
/* 132 */       StuWish result = (StuWish)getSession().merge(detachedInstance);
/* 133 */       log.debug("merge successful");
/* 134 */       return result;
/*     */     } catch (RuntimeException re) {
/* 136 */       log.error("merge failed", re);
/* 137 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachDirty(StuWish instance) {
/* 142 */     log.debug("attaching dirty StuWish instance");
/*     */     try {
/* 144 */       getSession().saveOrUpdate(instance);
/* 145 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 147 */       log.error("attach failed", re);
/* 148 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachClean(StuWish instance) {
/* 153 */     log.debug("attaching clean StuWish instance");
/*     */     try {
/* 155 */       getSession().lock(instance, LockMode.NONE);
/* 156 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 158 */       log.error("attach failed", re);
/* 159 */       throw re;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.wish.StuWishDAO
 * JD-Core Version:    0.5.4
 */