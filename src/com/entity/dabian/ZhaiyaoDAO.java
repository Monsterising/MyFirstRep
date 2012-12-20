/*     */ package com.entity.dabian;
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
/*     */ public class ZhaiyaoDAO extends BaseHibernateDAO
/*     */ {
/*  25 */   private static final Log log = LogFactory.getLog(ZhaiyaoDAO.class);
/*     */   public static final String CONTENT = "content";
/*     */   public static final String KEYWORD = "keyword";
/*     */ 
/*     */   public void save(Zhaiyao transientInstance)
/*     */   {
/*  31 */     log.debug("saving Zhaiyao instance");
/*     */     try {
/*  33 */       getSession().save(transientInstance);
/*  34 */       log.debug("save successful");
/*     */     } catch (RuntimeException re) {
/*  36 */       log.error("save failed", re);
/*  37 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void delete(Zhaiyao persistentInstance) {
/*  42 */     log.debug("deleting Zhaiyao instance");
/*     */     try {
/*  44 */       getSession().delete(persistentInstance);
/*  45 */       log.debug("delete successful");
/*     */     } catch (RuntimeException re) {
/*  47 */       log.error("delete failed", re);
/*  48 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public Zhaiyao findById(String id) {
/*  53 */     log.debug("getting Zhaiyao instance with id: " + id);
/*     */     try {
/*  55 */       Zhaiyao instance = (Zhaiyao)getSession().get(
/*  56 */         "com.entity.dabian.Zhaiyao", id);
/*  57 */       return instance;
/*     */     } catch (RuntimeException re) {
/*  59 */       log.error("get failed", re);
/*  60 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByExample(Zhaiyao instance) {
/*  65 */     log.debug("finding Zhaiyao instance by example");
/*     */     try {
/*  67 */       List results = getSession().createCriteria(
/*  68 */         "com.entity.dabian.Zhaiyao").add(Example.create(instance))
/*  69 */         .list();
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
/*  80 */     log.debug("finding Zhaiyao instance with property: " + propertyName + 
/*  81 */       ", value: " + value);
/*     */     try {
/*  83 */       String queryString = "from Zhaiyao as model where model." + 
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
/*     */   public List findByContent(Object content) {
/*  95 */     return findByProperty("content", content);
/*     */   }
/*     */ 
/*     */   public List findByKeyword(Object keyword) {
/*  99 */     return findByProperty("keyword", keyword);
/*     */   }
/*     */ 
/*     */   public List findAll() {
/* 103 */     log.debug("finding all Zhaiyao instances");
/*     */     try {
/* 105 */       String queryString = "from Zhaiyao";
/* 106 */       Query queryObject = getSession().createQuery(queryString);
/* 107 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/* 109 */       log.error("find all failed", re);
/* 110 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public Zhaiyao merge(Zhaiyao detachedInstance) {
/* 115 */     log.debug("merging Zhaiyao instance");
/*     */     try {
/* 117 */       Zhaiyao result = (Zhaiyao)getSession().merge(detachedInstance);
/* 118 */       log.debug("merge successful");
/* 119 */       return result;
/*     */     } catch (RuntimeException re) {
/* 121 */       log.error("merge failed", re);
/* 122 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachDirty(Zhaiyao instance) {
/* 127 */     log.debug("attaching dirty Zhaiyao instance");
/*     */     try {
/* 129 */       getSession().saveOrUpdate(instance);
/* 130 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 132 */       log.error("attach failed", re);
/* 133 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachClean(Zhaiyao instance) {
/* 138 */     log.debug("attaching clean Zhaiyao instance");
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
 * Qualified Name:     com.entity.dabian.ZhaiyaoDAO
 * JD-Core Version:    0.5.4
 */