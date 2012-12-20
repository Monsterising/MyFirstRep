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
/*     */ public class CollegeListDAO extends BaseHibernateDAO
/*     */ {
/*  25 */   private static final Log log = LogFactory.getLog(CollegeListDAO.class);
/*     */   public static final String COLLEGENAME = "collegename";
/*     */ 
/*     */   public void save(CollegeList transientInstance)
/*     */   {
/*  30 */     log.debug("saving CollegeList instance");
/*     */     try {
/*  32 */       getSession().save(transientInstance);
/*  33 */       log.debug("save successful");
/*     */     } catch (RuntimeException re) {
/*  35 */       log.error("save failed", re);
/*  36 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void delete(CollegeList persistentInstance) {
/*  41 */     log.debug("deleting CollegeList instance");
/*     */     try {
/*  43 */       getSession().delete(persistentInstance);
/*  44 */       log.debug("delete successful");
/*     */     } catch (RuntimeException re) {
/*  46 */       log.error("delete failed", re);
/*  47 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public CollegeList findById(Integer id) {
/*  52 */     log.debug("getting CollegeList instance with id: " + id);
/*     */     try {
/*  54 */       CollegeList instance = (CollegeList)getSession().get(
/*  55 */         "com.entity.basedata.CollegeList", id);
/*  56 */       return instance;
/*     */     } catch (RuntimeException re) {
/*  58 */       log.error("get failed", re);
/*  59 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByExample(CollegeList instance) {
/*  64 */     log.debug("finding CollegeList instance by example");
/*     */     try {
/*  66 */       List results = getSession().createCriteria(
/*  67 */         "com.entity.basedata.CollegeList").add(
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
/*  79 */     log.debug("finding CollegeList instance with property: " + propertyName + 
/*  80 */       ", value: " + value);
/*     */     try {
/*  82 */       String queryString = "from CollegeList as model where model." + 
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
/*     */   public List findByCollegename(Object collegename) {
/*  94 */     return findByProperty("collegename", collegename);
/*     */   }
/*     */ 
/*     */   public List findAll() {
/*  98 */     log.debug("finding all CollegeList instances");
/*     */     try {
/* 100 */       String queryString = "from CollegeList";
/* 101 */       Query queryObject = getSession().createQuery(queryString);
/* 102 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/* 104 */       log.error("find all failed", re);
/* 105 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public CollegeList merge(CollegeList detachedInstance) {
/* 110 */     log.debug("merging CollegeList instance");
/*     */     try {
/* 112 */       CollegeList result = (CollegeList)getSession().merge(
/* 113 */         detachedInstance);
/* 114 */       log.debug("merge successful");
/* 115 */       return result;
/*     */     } catch (RuntimeException re) {
/* 117 */       log.error("merge failed", re);
/* 118 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachDirty(CollegeList instance) {
/* 123 */     log.debug("attaching dirty CollegeList instance");
/*     */     try {
/* 125 */       getSession().saveOrUpdate(instance);
/* 126 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 128 */       log.error("attach failed", re);
/* 129 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachClean(CollegeList instance) {
/* 134 */     log.debug("attaching clean CollegeList instance");
/*     */     try {
/* 136 */       getSession().lock(instance, LockMode.NONE);
/* 137 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 139 */       log.error("attach failed", re);
/* 140 */       throw re;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.basedata.CollegeListDAO
 * JD-Core Version:    0.5.4
 */