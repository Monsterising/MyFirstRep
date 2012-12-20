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
/*     */ public class CollegeSetupDAO extends BaseHibernateDAO
/*     */ {
/*  23 */   private static final Log log = LogFactory.getLog(CollegeSetupDAO.class);
/*     */   public static final String DATESTART = "datestart";
/*     */   public static final String DATEOVER = "dateover";
/*     */ 
/*     */   public void save(CollegeSetup transientInstance)
/*     */   {
/*  29 */     log.debug("saving CollegeSetup instance");
/*     */     try {
/*  31 */       getSession().save(transientInstance);
/*  32 */       log.debug("save successful");
/*     */     } catch (RuntimeException re) {
/*  34 */       log.error("save failed", re);
/*  35 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void delete(CollegeSetup persistentInstance) {
/*  40 */     log.debug("deleting CollegeSetup instance");
/*     */     try {
/*  42 */       getSession().delete(persistentInstance);
/*  43 */       log.debug("delete successful");
/*     */     } catch (RuntimeException re) {
/*  45 */       log.error("delete failed", re);
/*  46 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public CollegeSetup findById(Integer id) {
/*  51 */     log.debug("getting CollegeSetup instance with id: " + id);
/*     */     try {
/*  53 */       CollegeSetup instance = (CollegeSetup)getSession().get(
/*  54 */         "com.entity.basedata.CollegeSetup", id);
/*  55 */       return instance;
/*     */     } catch (RuntimeException re) {
/*  57 */       log.error("get failed", re);
/*  58 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByExample(CollegeSetup instance) {
/*  63 */     log.debug("finding CollegeSetup instance by example");
/*     */     try {
/*  65 */       List results = getSession().createCriteria(
/*  66 */         "com.entity.basedata.CollegeSetup").add(
/*  67 */         Example.create(instance)).list();
/*  68 */       log.debug("find by example successful, result size: " + 
/*  69 */         results.size());
/*  70 */       return results;
/*     */     } catch (RuntimeException re) {
/*  72 */       log.error("find by example failed", re);
/*  73 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByProperty(String propertyName, Object value) {
/*  78 */     log.debug("finding CollegeSetup instance with property: " + 
/*  79 */       propertyName + ", value: " + value);
/*     */     try {
/*  81 */       String queryString = "from CollegeSetup as model where model." + 
/*  82 */         propertyName + "= ?";
/*  83 */       Query queryObject = getSession().createQuery(queryString);
/*  84 */       queryObject.setParameter(0, value);
/*  85 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/*  87 */       log.error("find by property name failed", re);
/*  88 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByDatestart(Object datestart) {
/*  93 */     return findByProperty("datestart", datestart);
/*     */   }
/*     */ 
/*     */   public List findByDateover(Object dateover) {
/*  97 */     return findByProperty("dateover", dateover);
/*     */   }
/*     */ 
/*     */   public List findAll() {
/* 101 */     log.debug("finding all CollegeSetup instances");
/*     */     try {
/* 103 */       String queryString = "from CollegeSetup";
/* 104 */       Query queryObject = getSession().createQuery(queryString);
/* 105 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/* 107 */       log.error("find all failed", re);
/* 108 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public CollegeSetup merge(CollegeSetup detachedInstance) {
/* 113 */     log.debug("merging CollegeSetup instance");
/*     */     try {
/* 115 */       CollegeSetup result = (CollegeSetup)getSession().merge(
/* 116 */         detachedInstance);
/* 117 */       log.debug("merge successful");
/* 118 */       return result;
/*     */     } catch (RuntimeException re) {
/* 120 */       log.error("merge failed", re);
/* 121 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachDirty(CollegeSetup instance) {
/* 126 */     log.debug("attaching dirty CollegeSetup instance");
/*     */     try {
/* 128 */       getSession().saveOrUpdate(instance);
/* 129 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 131 */       log.error("attach failed", re);
/* 132 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachClean(CollegeSetup instance) {
/* 137 */     log.debug("attaching clean CollegeSetup instance");
/*     */     try {
/* 139 */       getSession().lock(instance, LockMode.NONE);
/* 140 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 142 */       log.error("attach failed", re);
/* 143 */       throw re;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.basedata.CollegeSetupDAO
 * JD-Core Version:    0.5.4
 */