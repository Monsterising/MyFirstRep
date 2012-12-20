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
/*     */ public class DepartTecDAO extends BaseHibernateDAO
/*     */ {
/*  24 */   private static final Log log = LogFactory.getLog(DepartTecDAO.class);
/*     */   public static final String DEPARTID = "departid";
/*     */   public static final String TECCODE = "teccode";
/*     */   public static final String TECROLE = "tecrole";
/*     */ 
/*     */   public void save(DepartTec transientInstance)
/*     */   {
/*  31 */     log.debug("saving DepartTec instance");
/*     */     try {
/*  33 */       getSession().save(transientInstance);
/*  34 */       log.debug("save successful");
/*     */     } catch (RuntimeException re) {
/*  36 */       log.error("save failed", re);
/*  37 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void delete(DepartTec persistentInstance) {
/*  42 */     log.debug("deleting DepartTec instance");
/*     */     try {
/*  44 */       getSession().delete(persistentInstance);
/*  45 */       log.debug("delete successful");
/*     */     } catch (RuntimeException re) {
/*  47 */       log.error("delete failed", re);
/*  48 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public DepartTec findById(Integer id) {
/*  53 */     log.debug("getting DepartTec instance with id: " + id);
/*     */     try {
/*  55 */       DepartTec instance = (DepartTec)getSession().get(
/*  56 */         "com.entity.basedata.DepartTec", id);
/*  57 */       return instance;
/*     */     } catch (RuntimeException re) {
/*  59 */       log.error("get failed", re);
/*  60 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByExample(DepartTec instance) {
/*  65 */     log.debug("finding DepartTec instance by example");
/*     */     try {
/*  67 */       List results = getSession().createCriteria(
/*  68 */         "com.entity.basedata.DepartTec").add(
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
/*  80 */     log.debug("finding DepartTec instance with property: " + propertyName + 
/*  81 */       ", value: " + value);
/*     */     try {
/*  83 */       String queryString = "from DepartTec as model where model." + 
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
/*     */   public List findByDepartid(Object departid) {
/*  95 */     return findByProperty("departid", departid);
/*     */   }
/*     */ 
/*     */   public List findByTeccode(Object teccode) {
/*  99 */     return findByProperty("teccode", teccode);
/*     */   }
/*     */ 
/*     */   public List findByTecrole(Object tecrole) {
/* 103 */     return findByProperty("tecrole", tecrole);
/*     */   }
/*     */ 
/*     */   public List findAll() {
/* 107 */     log.debug("finding all DepartTec instances");
/*     */     try {
/* 109 */       String queryString = "from DepartTec";
/* 110 */       Query queryObject = getSession().createQuery(queryString);
/* 111 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/* 113 */       log.error("find all failed", re);
/* 114 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public DepartTec merge(DepartTec detachedInstance) {
/* 119 */     log.debug("merging DepartTec instance");
/*     */     try {
/* 121 */       DepartTec result = (DepartTec)getSession().merge(detachedInstance);
/* 122 */       log.debug("merge successful");
/* 123 */       return result;
/*     */     } catch (RuntimeException re) {
/* 125 */       log.error("merge failed", re);
/* 126 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachDirty(DepartTec instance) {
/* 131 */     log.debug("attaching dirty DepartTec instance");
/*     */     try {
/* 133 */       getSession().saveOrUpdate(instance);
/* 134 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 136 */       log.error("attach failed", re);
/* 137 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachClean(DepartTec instance) {
/* 142 */     log.debug("attaching clean DepartTec instance");
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
 * Qualified Name:     com.entity.basedata.DepartTecDAO
 * JD-Core Version:    0.5.4
 */