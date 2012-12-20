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
/*     */ public class ClassListDAO extends BaseHibernateDAO
/*     */ {
/*  23 */   private static final Log log = LogFactory.getLog(ClassListDAO.class);
/*     */   public static final String CLASSNAME = "classname";
/*     */   public static final String COLLEGEID = "collegeid";
/*     */   public static final String DEPARTID = "departid";
/*     */   public static final String GRADEID = "gradeid";
/*     */   public static final String CLASSNAMESHORT = "classnameshort";
/*     */ 
/*     */   public void save(ClassList transientInstance)
/*     */   {
/*  32 */     log.debug("saving ClassList instance");
/*     */     try {
/*  34 */       getSession().save(transientInstance);
/*  35 */       log.debug("save successful");
/*     */     } catch (RuntimeException re) {
/*  37 */       log.error("save failed", re);
/*  38 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void delete(ClassList persistentInstance) {
/*  43 */     log.debug("deleting ClassList instance");
/*     */     try {
/*  45 */       getSession().delete(persistentInstance);
/*  46 */       log.debug("delete successful");
/*     */     } catch (RuntimeException re) {
/*  48 */       log.error("delete failed", re);
/*  49 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public ClassList findById(Integer id) {
/*  54 */     log.debug("getting ClassList instance with id: " + id);
/*     */     try {
/*  56 */       ClassList instance = (ClassList)getSession().get(
/*  57 */         "com.entity.basedata.ClassList", id);
/*  58 */       return instance;
/*     */     } catch (RuntimeException re) {
/*  60 */       log.error("get failed", re);
/*  61 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByExample(ClassList instance) {
/*  66 */     log.debug("finding ClassList instance by example");
/*     */     try {
/*  68 */       List results = getSession().createCriteria(
/*  69 */         "com.entity.basedata.ClassList").add(
/*  70 */         Example.create(instance)).list();
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
/*  81 */     log.debug("finding ClassList instance with property: " + propertyName + 
/*  82 */       ", value: " + value);
/*     */     try {
/*  84 */       String queryString = "from ClassList as model where model." + 
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
/*     */   public List findByClassname(Object classname) {
/*  96 */     return findByProperty("classname", classname);
/*     */   }
/*     */ 
/*     */   public List findByCollegeid(Object collegeid) {
/* 100 */     return findByProperty("collegeid", collegeid);
/*     */   }
/*     */ 
/*     */   public List findByDepartid(Object departid) {
/* 104 */     return findByProperty("departid", departid);
/*     */   }
/*     */ 
/*     */   public List findByGradeid(Object gradeid) {
/* 108 */     return findByProperty("gradeid", gradeid);
/*     */   }
/*     */ 
/*     */   public List findByClassnameshort(Object classnameshort) {
/* 112 */     return findByProperty("classnameshort", classnameshort);
/*     */   }
/*     */ 
/*     */   public List findAll() {
/* 116 */     log.debug("finding all ClassList instances");
/*     */     try {
/* 118 */       String queryString = "from ClassList";
/* 119 */       Query queryObject = getSession().createQuery(queryString);
/* 120 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/* 122 */       log.error("find all failed", re);
/* 123 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public ClassList merge(ClassList detachedInstance) {
/* 128 */     log.debug("merging ClassList instance");
/*     */     try {
/* 130 */       ClassList result = (ClassList)getSession().merge(detachedInstance);
/* 131 */       log.debug("merge successful");
/* 132 */       return result;
/*     */     } catch (RuntimeException re) {
/* 134 */       log.error("merge failed", re);
/* 135 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachDirty(ClassList instance) {
/* 140 */     log.debug("attaching dirty ClassList instance");
/*     */     try {
/* 142 */       getSession().saveOrUpdate(instance);
/* 143 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 145 */       log.error("attach failed", re);
/* 146 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachClean(ClassList instance) {
/* 151 */     log.debug("attaching clean ClassList instance");
/*     */     try {
/* 153 */       getSession().lock(instance, LockMode.NONE);
/* 154 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 156 */       log.error("attach failed", re);
/* 157 */       throw re;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.basedata.ClassListDAO
 * JD-Core Version:    0.5.4
 */