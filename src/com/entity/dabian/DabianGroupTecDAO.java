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
/*     */ public class DabianGroupTecDAO extends BaseHibernateDAO
/*     */ {
/*  24 */   private static final Log log = LogFactory.getLog(DabianGroupTecDAO.class);
/*     */   public static final String DBGID = "dbgid";
/*     */   public static final String TECCODE = "teccode";
/*     */ 
/*     */   public void save(DabianGroupTec transientInstance)
/*     */   {
/*  30 */     log.debug("saving DabianGroupTec instance");
/*     */     try {
/*  32 */       getSession().save(transientInstance);
/*  33 */       log.debug("save successful");
/*     */     } catch (RuntimeException re) {
/*  35 */       log.error("save failed", re);
/*  36 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void delete(DabianGroupTec persistentInstance) {
/*  41 */     log.debug("deleting DabianGroupTec instance");
/*     */     try {
/*  43 */       getSession().delete(persistentInstance);
/*  44 */       log.debug("delete successful");
/*     */     } catch (RuntimeException re) {
/*  46 */       log.error("delete failed", re);
/*  47 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public DabianGroupTec findById(Integer id) {
/*  52 */     log.debug("getting DabianGroupTec instance with id: " + id);
/*     */     try {
/*  54 */       DabianGroupTec instance = (DabianGroupTec)getSession().get(
/*  55 */         "com.entity.dabian.DabianGroupTec", id);
/*  56 */       return instance;
/*     */     } catch (RuntimeException re) {
/*  58 */       log.error("get failed", re);
/*  59 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByExample(DabianGroupTec instance) {
/*  64 */     log.debug("finding DabianGroupTec instance by example");
/*     */     try {
/*  66 */       List results = getSession().createCriteria(
/*  67 */         "com.entity.dabian.DabianGroupTec").add(
/*  68 */         Example.create(instance)).list();
/*  69 */       log.debug("find by example successful, result size: " + 
/*  70 */         results.size());
/*  71 */       return results;
/*     */     } catch (RuntimeException re) {
/*  73 */       log.error("find by example failed", re);
/*  74 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByProperty(String propertyName, Object value) {
/*  79 */     log.debug("finding DabianGroupTec instance with property: " + 
/*  80 */       propertyName + ", value: " + value);
/*     */     try {
/*  82 */       String queryString = "from DabianGroupTec as model where model." + 
/*  83 */         propertyName + "= ?";
/*  84 */       Query queryObject = getSession().createQuery(queryString);
/*  85 */       queryObject.setParameter(0, value);
/*  86 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/*  88 */       log.error("find by property name failed", re);
/*  89 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByDbgid(Object dbgid) {
/*  94 */     return findByProperty("dbgid", dbgid);
/*     */   }
/*     */ 
/*     */   public List findByTeccode(Object teccode) {
/*  98 */     return findByProperty("teccode", teccode);
/*     */   }
/*     */ 
/*     */   public List findAll() {
/* 102 */     log.debug("finding all DabianGroupTec instances");
/*     */     try {
/* 104 */       String queryString = "from DabianGroupTec";
/* 105 */       Query queryObject = getSession().createQuery(queryString);
/* 106 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/* 108 */       log.error("find all failed", re);
/* 109 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public DabianGroupTec merge(DabianGroupTec detachedInstance) {
/* 114 */     log.debug("merging DabianGroupTec instance");
/*     */     try {
/* 116 */       DabianGroupTec result = (DabianGroupTec)getSession().merge(
/* 117 */         detachedInstance);
/* 118 */       log.debug("merge successful");
/* 119 */       return result;
/*     */     } catch (RuntimeException re) {
/* 121 */       log.error("merge failed", re);
/* 122 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachDirty(DabianGroupTec instance) {
/* 127 */     log.debug("attaching dirty DabianGroupTec instance");
/*     */     try {
/* 129 */       getSession().saveOrUpdate(instance);
/* 130 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 132 */       log.error("attach failed", re);
/* 133 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachClean(DabianGroupTec instance) {
/* 138 */     log.debug("attaching clean DabianGroupTec instance");
/*     */     try {
/* 140 */       getSession().lock(instance, LockMode.NONE);
/* 141 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 143 */       log.error("attach failed", re);
/* 144 */       throw re;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.dabian.DabianGroupTecDAO
 * JD-Core Version:    0.5.4
 */