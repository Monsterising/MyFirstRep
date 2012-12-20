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
/*     */ public class ApplyTypeDAO extends BaseHibernateDAO
/*     */ {
/*  24 */   private static final Log log = LogFactory.getLog(ApplyTypeDAO.class);
/*     */   public static final String DEPARTID = "departid";
/*     */   public static final String TYPENAME = "typename";
/*     */ 
/*     */   public void save(ApplyType transientInstance)
/*     */   {
/*  30 */     log.debug("saving ApplyType instance");
/*     */     try {
/*  32 */       getSession().save(transientInstance);
/*  33 */       log.debug("save successful");
/*     */     } catch (RuntimeException re) {
/*  35 */       log.error("save failed", re);
/*  36 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void delete(ApplyType persistentInstance) {
/*  41 */     log.debug("deleting ApplyType instance");
/*     */     try {
/*  43 */       getSession().delete(persistentInstance);
/*  44 */       log.debug("delete successful");
/*     */     } catch (RuntimeException re) {
/*  46 */       log.error("delete failed", re);
/*  47 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public ApplyType findById(Integer id) {
/*  52 */     log.debug("getting ApplyType instance with id: " + id);
/*     */     try {
/*  54 */       ApplyType instance = (ApplyType)getSession().get(
/*  55 */         "com.entity.wish.ApplyType", id);
/*  56 */       return instance;
/*     */     } catch (RuntimeException re) {
/*  58 */       log.error("get failed", re);
/*  59 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByExample(ApplyType instance) {
/*  64 */     log.debug("finding ApplyType instance by example");
/*     */     try {
/*  66 */       List results = getSession().createCriteria(
/*  67 */         "com.entity.wish.ApplyType").add(Example.create(instance))
/*  68 */         .list();
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
/*  79 */     log.debug("finding ApplyType instance with property: " + propertyName + 
/*  80 */       ", value: " + value);
/*     */     try {
/*  82 */       String queryString = "from ApplyType as model where model." + 
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
/*     */   public List findByDepartid(Object departid) {
/*  94 */     return findByProperty("departid", departid);
/*     */   }
/*     */ 
/*     */   public List findByTypename(Object typename) {
/*  98 */     return findByProperty("typename", typename);
/*     */   }
/*     */ 
/*     */   public List findAll() {
/* 102 */     log.debug("finding all ApplyType instances");
/*     */     try {
/* 104 */       String queryString = "from ApplyType";
/* 105 */       Query queryObject = getSession().createQuery(queryString);
/* 106 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/* 108 */       log.error("find all failed", re);
/* 109 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public ApplyType merge(ApplyType detachedInstance) {
/* 114 */     log.debug("merging ApplyType instance");
/*     */     try {
/* 116 */       ApplyType result = (ApplyType)getSession().merge(detachedInstance);
/* 117 */       log.debug("merge successful");
/* 118 */       return result;
/*     */     } catch (RuntimeException re) {
/* 120 */       log.error("merge failed", re);
/* 121 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachDirty(ApplyType instance) {
/* 126 */     log.debug("attaching dirty ApplyType instance");
/*     */     try {
/* 128 */       getSession().saveOrUpdate(instance);
/* 129 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 131 */       log.error("attach failed", re);
/* 132 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachClean(ApplyType instance) {
/* 137 */     log.debug("attaching clean ApplyType instance");
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
 * Qualified Name:     com.entity.wish.ApplyTypeDAO
 * JD-Core Version:    0.5.4
 */