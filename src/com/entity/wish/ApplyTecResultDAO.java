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
/*     */ public class ApplyTecResultDAO extends BaseHibernateDAO
/*     */ {
/*  25 */   private static final Log log = LogFactory.getLog(ApplyTecResultDAO.class);
/*     */   public static final String ATID = "atid";
/*     */   public static final String RESULTID = "resultid";
/*     */   public static final String ISOK = "isok";
/*     */   public static final String URL = "url";
/*     */   public static final String STUCODE = "stucode";
/*     */ 
/*     */   public void save(ApplyTecResult transientInstance)
/*     */   {
/*  34 */     log.debug("saving ApplyTecResult instance");
/*     */     try {
/*  36 */       getSession().save(transientInstance);
/*  37 */       log.debug("save successful");
/*     */     } catch (RuntimeException re) {
/*  39 */       log.error("save failed", re);
/*  40 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void delete(ApplyTecResult persistentInstance) {
/*  45 */     log.debug("deleting ApplyTecResult instance");
/*     */     try {
/*  47 */       getSession().delete(persistentInstance);
/*  48 */       log.debug("delete successful");
/*     */     } catch (RuntimeException re) {
/*  50 */       log.error("delete failed", re);
/*  51 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public ApplyTecResult findById(Integer id) {
/*  56 */     log.debug("getting ApplyTecResult instance with id: " + id);
/*     */     try {
/*  58 */       ApplyTecResult instance = (ApplyTecResult)getSession().get(
/*  59 */         "com.entity.wish.ApplyTecResult", id);
/*  60 */       return instance;
/*     */     } catch (RuntimeException re) {
/*  62 */       log.error("get failed", re);
/*  63 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByExample(ApplyTecResult instance) {
/*  68 */     log.debug("finding ApplyTecResult instance by example");
/*     */     try {
/*  70 */       List results = getSession().createCriteria(
/*  71 */         "com.entity.wish.ApplyTecResult").add(
/*  72 */         Example.create(instance)).list();
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
/*  83 */     log.debug("finding ApplyTecResult instance with property: " + 
/*  84 */       propertyName + ", value: " + value);
/*     */     try {
/*  86 */       String queryString = "from ApplyTecResult as model where model." + 
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
/*     */   public List findByAtid(Object atid) {
/*  98 */     return findByProperty("atid", atid);
/*     */   }
/*     */ 
/*     */   public List findByResultid(Object resultid) {
/* 102 */     return findByProperty("resultid", resultid);
/*     */   }
/*     */ 
/*     */   public List findByIsok(Object isok) {
/* 106 */     return findByProperty("isok", isok);
/*     */   }
/*     */ 
/*     */   public List findByUrl(Object url) {
/* 110 */     return findByProperty("url", url);
/*     */   }
/*     */ 
/*     */   public List findByStucode(Object stucode) {
/* 114 */     return findByProperty("stucode", stucode);
/*     */   }
/*     */ 
/*     */   public List findAll() {
/* 118 */     log.debug("finding all ApplyTecResult instances");
/*     */     try {
/* 120 */       String queryString = "from ApplyTecResult";
/* 121 */       Query queryObject = getSession().createQuery(queryString);
/* 122 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/* 124 */       log.error("find all failed", re);
/* 125 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public ApplyTecResult merge(ApplyTecResult detachedInstance) {
/* 130 */     log.debug("merging ApplyTecResult instance");
/*     */     try {
/* 132 */       ApplyTecResult result = (ApplyTecResult)getSession().merge(
/* 133 */         detachedInstance);
/* 134 */       log.debug("merge successful");
/* 135 */       return result;
/*     */     } catch (RuntimeException re) {
/* 137 */       log.error("merge failed", re);
/* 138 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachDirty(ApplyTecResult instance) {
/* 143 */     log.debug("attaching dirty ApplyTecResult instance");
/*     */     try {
/* 145 */       getSession().saveOrUpdate(instance);
/* 146 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 148 */       log.error("attach failed", re);
/* 149 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachClean(ApplyTecResult instance) {
/* 154 */     log.debug("attaching clean ApplyTecResult instance");
/*     */     try {
/* 156 */       getSession().lock(instance, LockMode.NONE);
/* 157 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 159 */       log.error("attach failed", re);
/* 160 */       throw re;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.wish.ApplyTecResultDAO
 * JD-Core Version:    0.5.4
 */