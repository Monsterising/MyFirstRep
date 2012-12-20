/*     */ package com.entity.dabian;
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
/*     */ public class PingfenDAO extends BaseHibernateDAO
/*     */ {
/*  25 */   private static final Log log = LogFactory.getLog(PingfenDAO.class);
/*     */   public static final String STUCODE = "stucode";
/*     */   public static final String TYPE = "type";
/*     */   public static final String SCORE = "score";
/*     */ 
/*     */   public void save(Pingfen transientInstance)
/*     */   {
/*  32 */     log.debug("saving Pingfen instance");
/*     */     try {
/*  34 */       getSession().save(transientInstance);
/*  35 */       log.debug("save successful");
/*     */     } catch (RuntimeException re) {
/*  37 */       log.error("save failed", re);
/*  38 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void delete(Pingfen persistentInstance) {
/*  43 */     log.debug("deleting Pingfen instance");
/*     */     try {
/*  45 */       getSession().delete(persistentInstance);
/*  46 */       log.debug("delete successful");
/*     */     } catch (RuntimeException re) {
/*  48 */       log.error("delete failed", re);
/*  49 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public Pingfen findById(Integer id) {
/*  54 */     log.debug("getting Pingfen instance with id: " + id);
/*     */     try {
/*  56 */       Pingfen instance = (Pingfen)getSession().get(
/*  57 */         "com.entity.dabian.Pingfen", id);
/*  58 */       return instance;
/*     */     } catch (RuntimeException re) {
/*  60 */       log.error("get failed", re);
/*  61 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByExample(Pingfen instance) {
/*  66 */     log.debug("finding Pingfen instance by example");
/*     */     try {
/*  68 */       List results = getSession().createCriteria(
/*  69 */         "com.entity.dabian.Pingfen").add(Example.create(instance))
/*  70 */         .list();
/*  71 */       log.debug("find by example successful, result size: " + 
/*  72 */         results.size());
/*  73 */       return results;
/*     */     } catch (RuntimeException re) {
/*  75 */       log.error("find by example failed", re);
/*  76 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByProperty(String propertyName, Object value) {
/*  81 */     log.debug("finding Pingfen instance with property: " + propertyName + 
/*  82 */       ", value: " + value);
/*     */     try {
/*  84 */       String queryString = "from Pingfen as model where model." + 
/*  85 */         propertyName + "= ?";
/*  86 */       Query queryObject = getSession().createQuery(queryString);
/*  87 */       queryObject.setParameter(0, value);
/*  88 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/*  90 */       log.error("find by property name failed", re);
/*  91 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByStucode(Object stucode) {
/*  96 */     return findByProperty("stucode", stucode);
/*     */   }
/*     */ 
/*     */   public List findByType(Object type) {
/* 100 */     return findByProperty("type", type);
/*     */   }
/*     */ 
/*     */   public List findByScore(Object score) {
/* 104 */     return findByProperty("score", score);
/*     */   }
/*     */ 
/*     */   public List findAll() {
/* 108 */     log.debug("finding all Pingfen instances");
/*     */     try {
/* 110 */       String queryString = "from Pingfen";
/* 111 */       Query queryObject = getSession().createQuery(queryString);
/* 112 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/* 114 */       log.error("find all failed", re);
/* 115 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public Pingfen merge(Pingfen detachedInstance) {
/* 120 */     log.debug("merging Pingfen instance");
/*     */     try {
/* 122 */       Pingfen result = (Pingfen)getSession().merge(detachedInstance);
/* 123 */       log.debug("merge successful");
/* 124 */       return result;
/*     */     } catch (RuntimeException re) {
/* 126 */       log.error("merge failed", re);
/* 127 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachDirty(Pingfen instance) {
/* 132 */     log.debug("attaching dirty Pingfen instance");
/*     */     try {
/* 134 */       getSession().saveOrUpdate(instance);
/* 135 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 137 */       log.error("attach failed", re);
/* 138 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachClean(Pingfen instance) {
/* 143 */     log.debug("attaching clean Pingfen instance");
/*     */     try {
/* 145 */       getSession().lock(instance, LockMode.NONE);
/* 146 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 148 */       log.error("attach failed", re);
/* 149 */       throw re;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.dabian.PingfenDAO
 * JD-Core Version:    0.5.4
 */