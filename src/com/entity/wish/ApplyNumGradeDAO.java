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
/*     */ public class ApplyNumGradeDAO extends BaseHibernateDAO
/*     */ {
/*  24 */   private static final Log log = LogFactory.getLog(ApplyNumGradeDAO.class);
/*     */   public static final String NUM = "num";
/*     */   public static final String GRADEID = "gradeid";
/*     */ 
/*     */   public void save(ApplyNumGrade transientInstance)
/*     */   {
/*  30 */     log.debug("saving ApplyNumGrade instance");
/*     */     try {
/*  32 */       getSession().save(transientInstance);
/*  33 */       log.debug("save successful");
/*     */     } catch (RuntimeException re) {
/*  35 */       log.error("save failed", re);
/*  36 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void delete(ApplyNumGrade persistentInstance) {
/*  41 */     log.debug("deleting ApplyNumGrade instance");
/*     */     try {
/*  43 */       getSession().delete(persistentInstance);
/*  44 */       log.debug("delete successful");
/*     */     } catch (RuntimeException re) {
/*  46 */       log.error("delete failed", re);
/*  47 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public ApplyNumGrade findById(Integer id) {
/*  52 */     log.debug("getting ApplyNumGrade instance with id: " + id);
/*     */     try {
/*  54 */       ApplyNumGrade instance = (ApplyNumGrade)getSession().get(
/*  55 */         "com.entity.wish.ApplyNumGrade", id);
/*  56 */       return instance;
/*     */     } catch (RuntimeException re) {
/*  58 */       log.error("get failed", re);
/*  59 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByExample(ApplyNumGrade instance) {
/*  64 */     log.debug("finding ApplyNumGrade instance by example");
/*     */     try {
/*  66 */       List results = getSession().createCriteria(
/*  67 */         "com.entity.wish.ApplyNumGrade").add(
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
/*  79 */     log.debug("finding ApplyNumGrade instance with property: " + 
/*  80 */       propertyName + ", value: " + value);
/*     */     try {
/*  82 */       String queryString = "from ApplyNumGrade as model where model." + 
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
/*     */   public List findByNum(Object num) {
/*  94 */     return findByProperty("num", num);
/*     */   }
/*     */ 
/*     */   public List findByGradeid(Object gradeid) {
/*  98 */     return findByProperty("gradeid", gradeid);
/*     */   }
/*     */ 
/*     */   public List findAll() {
/* 102 */     log.debug("finding all ApplyNumGrade instances");
/*     */     try {
/* 104 */       String queryString = "from ApplyNumGrade";
/* 105 */       Query queryObject = getSession().createQuery(queryString);
/* 106 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/* 108 */       log.error("find all failed", re);
/* 109 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public ApplyNumGrade merge(ApplyNumGrade detachedInstance) {
/* 114 */     log.debug("merging ApplyNumGrade instance");
/*     */     try {
/* 116 */       ApplyNumGrade result = (ApplyNumGrade)getSession().merge(
/* 117 */         detachedInstance);
/* 118 */       log.debug("merge successful");
/* 119 */       return result;
/*     */     } catch (RuntimeException re) {
/* 121 */       log.error("merge failed", re);
/* 122 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachDirty(ApplyNumGrade instance) {
/* 127 */     log.debug("attaching dirty ApplyNumGrade instance");
/*     */     try {
/* 129 */       getSession().saveOrUpdate(instance);
/* 130 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 132 */       log.error("attach failed", re);
/* 133 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachClean(ApplyNumGrade instance) {
/* 138 */     log.debug("attaching clean ApplyNumGrade instance");
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
 * Qualified Name:     com.entity.wish.ApplyNumGradeDAO
 * JD-Core Version:    0.5.4
 */