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
/*     */ public class GradeListDAO extends BaseHibernateDAO
/*     */ {
/*  24 */   private static final Log log = LogFactory.getLog(GradeListDAO.class);
/*     */   public static final String GRADENAME = "gradename";
/*     */   public static final String COLLEGEID = "collegeid";
/*     */   public static final String DEPARTID = "departid";
/*     */ 
/*     */   public void save(GradeList transientInstance)
/*     */   {
/*  31 */     log.debug("saving GradeList instance");
/*     */     try {
/*  33 */       getSession().save(transientInstance);
/*  34 */       log.debug("save successful");
/*     */     } catch (RuntimeException re) {
/*  36 */       log.error("save failed", re);
/*  37 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void delete(GradeList persistentInstance) {
/*  42 */     log.debug("deleting GradeList instance");
/*     */     try {
/*  44 */       getSession().delete(persistentInstance);
/*  45 */       log.debug("delete successful");
/*     */     } catch (RuntimeException re) {
/*  47 */       log.error("delete failed", re);
/*  48 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public GradeList findById(Integer id) {
/*  53 */     log.debug("getting GradeList instance with id: " + id);
/*     */     try {
/*  55 */       GradeList instance = (GradeList)getSession().get(
/*  56 */         "com.entity.basedata.GradeList", id);
/*  57 */       return instance;
/*     */     } catch (RuntimeException re) {
/*  59 */       log.error("get failed", re);
/*  60 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByExample(GradeList instance) {
/*  65 */     log.debug("finding GradeList instance by example");
/*     */     try {
/*  67 */       List results = getSession().createCriteria(
/*  68 */         "com.entity.basedata.GradeList").add(
/*  69 */         Example.create(instance)).list();
/*  70 */       log.debug("find by example successful, result size: " + 
/*  71 */         results.size());
/*  72 */       return results;
/*     */     } catch (RuntimeException re) {
/*  74 */       log.error("find by example failed", re);
/*  75 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByProperty(String propertyName, Object value) {
/*  80 */     log.debug("finding GradeList instance with property: " + propertyName + 
/*  81 */       ", value: " + value);
/*     */     try {
/*  83 */       String queryString = "from GradeList as model where model." + 
/*  84 */         propertyName + "= ?";
/*  85 */       Query queryObject = getSession().createQuery(queryString);
/*  86 */       queryObject.setParameter(0, value);
/*  87 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/*  89 */       log.error("find by property name failed", re);
/*  90 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByGradename(Object gradename) {
/*  95 */     return findByProperty("gradename", gradename);
/*     */   }
/*     */ 
/*     */   public List findByCollegeid(Object collegeid) {
/*  99 */     return findByProperty("collegeid", collegeid);
/*     */   }
/*     */ 
/*     */   public List findByDepartid(Object departid) {
/* 103 */     return findByProperty("departid", departid);
/*     */   }
/*     */ 
/*     */   public List findAll() {
/* 107 */     log.debug("finding all GradeList instances");
/*     */     try {
/* 109 */       String queryString = "from GradeList";
/* 110 */       Query queryObject = getSession().createQuery(queryString);
/* 111 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/* 113 */       log.error("find all failed", re);
/* 114 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public GradeList merge(GradeList detachedInstance) {
/* 119 */     log.debug("merging GradeList instance");
/*     */     try {
/* 121 */       GradeList result = (GradeList)getSession().merge(detachedInstance);
/* 122 */       log.debug("merge successful");
/* 123 */       return result;
/*     */     } catch (RuntimeException re) {
/* 125 */       log.error("merge failed", re);
/* 126 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachDirty(GradeList instance) {
/* 131 */     log.debug("attaching dirty GradeList instance");
/*     */     try {
/* 133 */       getSession().saveOrUpdate(instance);
/* 134 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 136 */       log.error("attach failed", re);
/* 137 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachClean(GradeList instance) {
/* 142 */     log.debug("attaching clean GradeList instance");
/*     */     try {
/* 144 */       getSession().lock(instance, LockMode.NONE);
/* 145 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 147 */       log.error("attach failed", re);
/* 148 */       throw re;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.basedata.GradeListDAO
 * JD-Core Version:    0.5.4
 */