/*     */ package com.entity.basedata;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.hibernate.Criteria;
/*     */ import org.hibernate.LockMode;
/*     */ import org.hibernate.Query;
/*     */ import org.hibernate.Session;
/*     */ import org.hibernate.criterion.Example;
/*     */ 
/*     */ public class StuListDAO extends BaseHibernateDAO
/*     */ {
/*  23 */   private static final Log log = LogFactory.getLog(StuListDAO.class);
/*     */   public static final String STUNAME = "stuname";
/*     */   public static final String STUPASS = "stupass";
/*     */   public static final String COLLEGEID = "collegeid";
/*     */   public static final String DEPARTID = "departid";
/*     */   public static final String GRADEID = "gradeid";
/*     */   public static final String CLASSID = "classid";
/*     */   public static final String STUSEX = "stusex";
/*     */ 
/*     */   public void save(StuList transientInstance)
/*     */   {
/*  34 */     log.debug("saving StuList instance");
/*     */     try {
/*  36 */       getSession().save(transientInstance);
/*  37 */       log.debug("save successful");
/*     */     } catch (RuntimeException re) {
/*  39 */       log.error("save failed", re);
/*  40 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void delete(StuList persistentInstance) {
/*  45 */     log.debug("deleting StuList instance");
/*     */     try {
/*  47 */       getSession().delete(persistentInstance);
/*  48 */       log.debug("delete successful");
/*     */     } catch (RuntimeException re) {
/*  50 */       log.error("delete failed", re);
/*  51 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public StuList findById(String id) {
/*  56 */     log.debug("getting StuList instance with id: " + id);
/*     */     try {
/*  58 */       StuList instance = (StuList)getSession().get(
/*  59 */         "com.entity.basedata.StuList", id);
/*  60 */       return instance;
/*     */     } catch (RuntimeException re) {
/*  62 */       log.error("get failed", re);
/*  63 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByExample(StuList instance) {
/*  68 */     log.debug("finding StuList instance by example");
/*     */     try {
/*  70 */       List results = getSession().createCriteria(
/*  71 */         "com.entity.basedata.StuList")
/*  72 */         .add(Example.create(instance)).list();
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
/*  83 */     log.debug("finding StuList instance with property: " + propertyName + 
/*  84 */       ", value: " + value);
/*     */     try {
/*  86 */       String queryString = "from StuList as model where model." + 
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
/*     */   public List findByStuname(Object stuname) {
/*  98 */     return findByProperty("stuname", stuname);
/*     */   }
/*     */ 
/*     */   public List findByStupass(Object stupass) {
/* 102 */     return findByProperty("stupass", stupass);
/*     */   }
/*     */ 
/*     */   public List findByCollegeid(Object collegeid) {
/* 106 */     return findByProperty("collegeid", collegeid);
/*     */   }
/*     */ 
/*     */   public List findByDepartid(Object departid) {
/* 110 */     return findByProperty("departid", departid);
/*     */   }
/*     */ 
/*     */   public List findByGradeid(Object gradeid) {
/* 114 */     return findByProperty("gradeid", gradeid);
/*     */   }
/*     */ 
/*     */   public List findByClassid(Object classid) {
/* 118 */     return findByProperty("classid", classid);
/*     */   }
/*     */ 
/*     */   public List findByStusex(Object stusex) {
/* 122 */     return findByProperty("stusex", stusex);
/*     */   }
/*     */ 
/*     */   public List findAll() {
/* 126 */     log.debug("finding all StuList instances");
/*     */     try {
/* 128 */       String queryString = "from StuList";
/* 129 */       Query queryObject = getSession().createQuery(queryString);
/* 130 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/* 132 */       log.error("find all failed", re);
/* 133 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public StuList merge(StuList detachedInstance) {
/* 138 */     log.debug("merging StuList instance");
/*     */     try {
/* 140 */       StuList result = (StuList)getSession().merge(detachedInstance);
/* 141 */       log.debug("merge successful");
/* 142 */       return result;
/*     */     } catch (RuntimeException re) {
/* 144 */       log.error("merge failed", re);
/* 145 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachDirty(StuList instance) {
/* 150 */     log.debug("attaching dirty StuList instance");
/*     */     try {
/* 152 */       getSession().saveOrUpdate(instance);
/* 153 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 155 */       log.error("attach failed", re);
/* 156 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachClean(StuList instance) {
/* 161 */     log.debug("attaching clean StuList instance");
/*     */     try {
/* 163 */       getSession().lock(instance, LockMode.NONE);
/* 164 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 166 */       log.error("attach failed", re);
/* 167 */       throw re;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.basedata.StuListDAO
 * JD-Core Version:    0.5.4
 */