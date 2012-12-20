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
/*     */ public class DabianChengjiDAO extends BaseHibernateDAO
/*     */ {
/*  25 */   private static final Log log = LogFactory.getLog(DabianChengjiDAO.class);
/*     */   public static final String STUCODE = "stucode";
/*     */   public static final String DBGID = "dbgid";
/*     */   public static final String PINGYU = "pingyu";
/*     */   public static final String CHENGJI = "chengji";
/*     */ 
/*     */   public void save(DabianChengji transientInstance)
/*     */   {
/*  33 */     log.debug("saving DabianChengji instance");
/*     */     try {
/*  35 */       getSession().save(transientInstance);
/*  36 */       log.debug("save successful");
/*     */     } catch (RuntimeException re) {
/*  38 */       log.error("save failed", re);
/*  39 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void delete(DabianChengji persistentInstance) {
/*  44 */     log.debug("deleting DabianChengji instance");
/*     */     try {
/*  46 */       getSession().delete(persistentInstance);
/*  47 */       log.debug("delete successful");
/*     */     } catch (RuntimeException re) {
/*  49 */       log.error("delete failed", re);
/*  50 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public DabianChengji findById(Integer id) {
/*  55 */     log.debug("getting DabianChengji instance with id: " + id);
/*     */     try {
/*  57 */       DabianChengji instance = (DabianChengji)getSession().get(
/*  58 */         "com.entity.dabian.DabianChengji", id);
/*  59 */       return instance;
/*     */     } catch (RuntimeException re) {
/*  61 */       log.error("get failed", re);
/*  62 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByExample(DabianChengji instance) {
/*  67 */     log.debug("finding DabianChengji instance by example");
/*     */     try {
/*  69 */       List results = getSession().createCriteria(
/*  70 */         "com.entity.dabian.DabianChengji").add(
/*  71 */         Example.create(instance)).list();
/*  72 */       log.debug("find by example successful, result size: " + 
/*  73 */         results.size());
/*  74 */       return results;
/*     */     } catch (RuntimeException re) {
/*  76 */       log.error("find by example failed", re);
/*  77 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByProperty(String propertyName, Object value) {
/*  82 */     log.debug("finding DabianChengji instance with property: " + 
/*  83 */       propertyName + ", value: " + value);
/*     */     try {
/*  85 */       String queryString = "from DabianChengji as model where model." + 
/*  86 */         propertyName + "= ?";
/*  87 */       Query queryObject = getSession().createQuery(queryString);
/*  88 */       queryObject.setParameter(0, value);
/*  89 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/*  91 */       log.error("find by property name failed", re);
/*  92 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByStucode(Object stucode) {
/*  97 */     return findByProperty("stucode", stucode);
/*     */   }
/*     */ 
/*     */   public List findByDbgid(Object dbgid) {
/* 101 */     return findByProperty("dbgid", dbgid);
/*     */   }
/*     */ 
/*     */   public List findByPingyu(Object pingyu) {
/* 105 */     return findByProperty("pingyu", pingyu);
/*     */   }
/*     */ 
/*     */   public List findByChengji(Object chengji) {
/* 109 */     return findByProperty("chengji", chengji);
/*     */   }
/*     */ 
/*     */   public List findAll() {
/* 113 */     log.debug("finding all DabianChengji instances");
/*     */     try {
/* 115 */       String queryString = "from DabianChengji";
/* 116 */       Query queryObject = getSession().createQuery(queryString);
/* 117 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/* 119 */       log.error("find all failed", re);
/* 120 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public DabianChengji merge(DabianChengji detachedInstance) {
/* 125 */     log.debug("merging DabianChengji instance");
/*     */     try {
/* 127 */       DabianChengji result = (DabianChengji)getSession().merge(
/* 128 */         detachedInstance);
/* 129 */       log.debug("merge successful");
/* 130 */       return result;
/*     */     } catch (RuntimeException re) {
/* 132 */       log.error("merge failed", re);
/* 133 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachDirty(DabianChengji instance) {
/* 138 */     log.debug("attaching dirty DabianChengji instance");
/*     */     try {
/* 140 */       getSession().saveOrUpdate(instance);
/* 141 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 143 */       log.error("attach failed", re);
/* 144 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachClean(DabianChengji instance) {
/* 149 */     log.debug("attaching clean DabianChengji instance");
/*     */     try {
/* 151 */       getSession().lock(instance, LockMode.NONE);
/* 152 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 154 */       log.error("attach failed", re);
/* 155 */       throw re;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.dabian.DabianChengjiDAO
 * JD-Core Version:    0.5.4
 */