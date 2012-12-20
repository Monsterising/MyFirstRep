/*     */ package com.entity.basedata;
/*     */ 
/*     */ import com.frame.hibernate.BaseHibernateDAO;
/*     */ import java.util.List;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.hibernate.Criteria;
/*     */ import org.hibernate.LockMode;
/*     */ import org.hibernate.Query;
/*     */ import org.hibernate.Session;
/*     */ import org.hibernate.criterion.Example;
/*     */ 
/*     */ public class StuExtraDAO extends BaseHibernateDAO
/*     */ {
/*  24 */   private static final Log log = LogFactory.getLog(StuExtraDAO.class);
/*     */   public static final String STUTEL = "stutel";
/*     */   public static final String STUTEL2 = "stutel2";
/*     */   public static final String STUEMAIL = "stuemail";
/*     */   public static final String STUQQ = "stuqq";
/*     */   public static final String STUSKILL = "stuskill";
/*     */   public static final String STUHONOR = "stuhonor";
/*     */   public static final String STUPLAN = "stuplan";
/*     */   public static final String STUNOTES = "stunotes";
/*     */ 
/*     */   public void save(StuExtra transientInstance)
/*     */   {
/*  36 */     log.debug("saving StuExtra instance");
/*     */     try {
/*  38 */       getSession().save(transientInstance);
/*  39 */       log.debug("save successful");
/*     */     } catch (RuntimeException re) {
/*  41 */       log.error("save failed", re);
/*  42 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void delete(StuExtra persistentInstance) {
/*  47 */     log.debug("deleting StuExtra instance");
/*     */     try {
/*  49 */       getSession().delete(persistentInstance);
/*  50 */       log.debug("delete successful");
/*     */     } catch (RuntimeException re) {
/*  52 */       log.error("delete failed", re);
/*  53 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public StuExtra findById(String id) {
/*  58 */     log.debug("getting StuExtra instance with id: " + id);
/*     */     try {
/*  60 */       StuExtra instance = (StuExtra)getSession().get(
/*  61 */         "com.entity.basedata.StuExtra", id);
/*  62 */       return instance;
/*     */     } catch (RuntimeException re) {
/*  64 */       log.error("get failed", re);
/*  65 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByExample(StuExtra instance) {
/*  70 */     log.debug("finding StuExtra instance by example");
/*     */     try {
/*  72 */       List results = getSession().createCriteria(
/*  73 */         "com.entity.basedata.StuExtra").add(
/*  74 */         Example.create(instance)).list();
/*  75 */       log.debug("find by example successful, result size: " + 
/*  76 */         results.size());
/*  77 */       return results;
/*     */     } catch (RuntimeException re) {
/*  79 */       log.error("find by example failed", re);
/*  80 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByProperty(String propertyName, Object value) {
/*  85 */     log.debug("finding StuExtra instance with property: " + propertyName + 
/*  86 */       ", value: " + value);
/*     */     try {
/*  88 */       String queryString = "from StuExtra as model where model." + 
/*  89 */         propertyName + "= ?";
/*  90 */       Query queryObject = getSession().createQuery(queryString);
/*  91 */       queryObject.setParameter(0, value);
/*  92 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/*  94 */       log.error("find by property name failed", re);
/*  95 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByStutel(Object stutel) {
/* 100 */     return findByProperty("stutel", stutel);
/*     */   }
/*     */ 
/*     */   public List findByStutel2(Object stutel2) {
/* 104 */     return findByProperty("stutel2", stutel2);
/*     */   }
/*     */ 
/*     */   public List findByStuemail(Object stuemail) {
/* 108 */     return findByProperty("stuemail", stuemail);
/*     */   }
/*     */ 
/*     */   public List findByStuqq(Object stuqq) {
/* 112 */     return findByProperty("stuqq", stuqq);
/*     */   }
/*     */ 
/*     */   public List findByStuskill(Object stuskill) {
/* 116 */     return findByProperty("stuskill", stuskill);
/*     */   }
/*     */ 
/*     */   public List findByStuhonor(Object stuhonor) {
/* 120 */     return findByProperty("stuhonor", stuhonor);
/*     */   }
/*     */ 
/*     */   public List findByStuplan(Object stuplan) {
/* 124 */     return findByProperty("stuplan", stuplan);
/*     */   }
/*     */ 
/*     */   public List findByStunotes(Object stunotes) {
/* 128 */     return findByProperty("stunotes", stunotes);
/*     */   }
/*     */ 
/*     */   public List findAll() {
/* 132 */     log.debug("finding all StuExtra instances");
/*     */     try {
/* 134 */       String queryString = "from StuExtra";
/* 135 */       Query queryObject = getSession().createQuery(queryString);
/* 136 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/* 138 */       log.error("find all failed", re);
/* 139 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public StuExtra merge(StuExtra detachedInstance) {
/* 144 */     log.debug("merging StuExtra instance");
/*     */     try {
/* 146 */       StuExtra result = (StuExtra)getSession().merge(detachedInstance);
/* 147 */       log.debug("merge successful");
/* 148 */       return result;
/*     */     } catch (RuntimeException re) {
/* 150 */       log.error("merge failed", re);
/* 151 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachDirty(StuExtra instance) {
/* 156 */     log.debug("attaching dirty StuExtra instance");
/*     */     try {
/* 158 */       getSession().saveOrUpdate(instance);
/* 159 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 161 */       log.error("attach failed", re);
/* 162 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachClean(StuExtra instance) {
/* 167 */     log.debug("attaching clean StuExtra instance");
/*     */     try {
/* 169 */       getSession().lock(instance, LockMode.NONE);
/* 170 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 172 */       log.error("attach failed", re);
/* 173 */       throw re;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.basedata.StuExtraDAO
 * JD-Core Version:    0.5.4
 */