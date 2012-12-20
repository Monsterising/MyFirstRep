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
/*     */ public class ApplyStateDAO extends BaseHibernateDAO
/*     */ {
/*  24 */   private static final Log log = LogFactory.getLog(ApplyStateDAO.class);
/*     */   public static final String ADVICE1 = "advice1";
/*     */   public static final String ADVICE2 = "advice2";
/*     */   public static final String XUANTI = "xuanti";
/*     */   public static final String XUANTINUM = "xuantinum";
/*     */   public static final String TASK = "task";
/*     */ 
/*     */   public void save(ApplyState transientInstance)
/*     */   {
/*  33 */     log.debug("saving ApplyState instance");
/*     */     try {
/*  35 */       getSession().save(transientInstance);
/*  36 */       log.debug("save successful");
/*     */     } catch (RuntimeException re) {
/*  38 */       log.error("save failed", re);
/*  39 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void delete(ApplyState persistentInstance) {
/*  44 */     log.debug("deleting ApplyState instance");
/*     */     try {
/*  46 */       getSession().delete(persistentInstance);
/*  47 */       log.debug("delete successful");
/*     */     } catch (RuntimeException re) {
/*  49 */       log.error("delete failed", re);
/*  50 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public ApplyState findById(Integer id) {
/*  55 */     log.debug("getting ApplyState instance with id: " + id);
/*     */     try {
/*  57 */       ApplyState instance = (ApplyState)getSession().get(
/*  58 */         "com.entity.wish.ApplyState", id);
/*  59 */       return instance;
/*     */     } catch (RuntimeException re) {
/*  61 */       log.error("get failed", re);
/*  62 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByExample(ApplyState instance) {
/*  67 */     log.debug("finding ApplyState instance by example");
/*     */     try {
/*  69 */       List results = getSession().createCriteria(
/*  70 */         "com.entity.wish.ApplyState").add(Example.create(instance))
/*  71 */         .list();
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
/*  82 */     log.debug("finding ApplyState instance with property: " + propertyName + 
/*  83 */       ", value: " + value);
/*     */     try {
/*  85 */       String queryString = "from ApplyState as model where model." + 
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
/*     */   public List findByAdvice1(Object advice1) {
/*  97 */     return findByProperty("advice1", advice1);
/*     */   }
/*     */ 
/*     */   public List findByAdvice2(Object advice2) {
/* 101 */     return findByProperty("advice2", advice2);
/*     */   }
/*     */ 
/*     */   public List findByXuanti(Object xuanti) {
/* 105 */     return findByProperty("xuanti", xuanti);
/*     */   }
/*     */ 
/*     */   public List findByXuantinum(Object xuantinum) {
/* 109 */     return findByProperty("xuantinum", xuantinum);
/*     */   }
/*     */ 
/*     */   public List findByTask(Object task) {
/* 113 */     return findByProperty("task", task);
/*     */   }
/*     */ 
/*     */   public List findAll() {
/* 117 */     log.debug("finding all ApplyState instances");
/*     */     try {
/* 119 */       String queryString = "from ApplyState";
/* 120 */       Query queryObject = getSession().createQuery(queryString);
/* 121 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/* 123 */       log.error("find all failed", re);
/* 124 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public ApplyState merge(ApplyState detachedInstance) {
/* 129 */     log.debug("merging ApplyState instance");
/*     */     try {
/* 131 */       ApplyState result = (ApplyState)getSession().merge(
/* 132 */         detachedInstance);
/* 133 */       log.debug("merge successful");
/* 134 */       return result;
/*     */     } catch (RuntimeException re) {
/* 136 */       log.error("merge failed", re);
/* 137 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachDirty(ApplyState instance) {
/* 142 */     log.debug("attaching dirty ApplyState instance");
/*     */     try {
/* 144 */       getSession().saveOrUpdate(instance);
/* 145 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 147 */       log.error("attach failed", re);
/* 148 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachClean(ApplyState instance) {
/* 153 */     log.debug("attaching clean ApplyState instance");
/*     */     try {
/* 155 */       getSession().lock(instance, LockMode.NONE);
/* 156 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 158 */       log.error("attach failed", re);
/* 159 */       throw re;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.wish.ApplyStateDAO
 * JD-Core Version:    0.5.4
 */