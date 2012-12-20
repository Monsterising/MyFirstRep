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
/*     */ public class StuDataDAO extends BaseHibernateDAO
/*     */ {
/*  24 */   private static final Log log = LogFactory.getLog(StuDataDAO.class);
/*     */   public static final String STUNAME = "stuname";
/*     */   public static final String STUCOLLEGE = "stucollege";
/*     */   public static final String STUDEPART = "studepart";
/*     */   public static final String STUGRADE = "stugrade";
/*     */   public static final String STUCLASS = "stuclass";
/*     */   public static final String STUSEX = "stusex";
/*     */ 
/*     */   public void save(StuData transientInstance)
/*     */   {
/*  34 */     log.debug("saving StuData instance");
/*     */     try {
/*  36 */       getSession().save(transientInstance);
/*  37 */       log.debug("save successful");
/*     */     } catch (RuntimeException re) {
/*  39 */       log.error("save failed", re);
/*  40 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void delete(StuData persistentInstance) {
/*  45 */     log.debug("deleting StuData instance");
/*     */     try {
/*  47 */       getSession().delete(persistentInstance);
/*  48 */       log.debug("delete successful");
/*     */     } catch (RuntimeException re) {
/*  50 */       log.error("delete failed", re);
/*  51 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public StuData findById(String id) {
/*  56 */     log.debug("getting StuData instance with id: " + id);
/*     */     try {
/*  58 */       StuData instance = (StuData)getSession().get(
/*  59 */         "com.entity.basedata.StuData", id);
/*  60 */       return instance;
/*     */     } catch (RuntimeException re) {
/*  62 */       log.error("get failed", re);
/*  63 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByExample(StuData instance) {
/*  68 */     log.debug("finding StuData instance by example");
/*     */     try {
/*  70 */       List results = getSession().createCriteria(
/*  71 */         "com.entity.basedata.StuData")
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
/*  83 */     log.debug("finding StuData instance with property: " + propertyName + 
/*  84 */       ", value: " + value);
/*     */     try {
/*  86 */       String queryString = "from StuData as model where model." + 
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
/*     */   public List findByStucollege(Object stucollege) {
/* 102 */     return findByProperty("stucollege", stucollege);
/*     */   }
/*     */ 
/*     */   public List findByStudepart(Object studepart) {
/* 106 */     return findByProperty("studepart", studepart);
/*     */   }
/*     */ 
/*     */   public List findByStugrade(Object stugrade) {
/* 110 */     return findByProperty("stugrade", stugrade);
/*     */   }
/*     */ 
/*     */   public List findByStuclass(Object stuclass) {
/* 114 */     return findByProperty("stuclass", stuclass);
/*     */   }
/*     */ 
/*     */   public List findByStusex(Object stusex) {
/* 118 */     return findByProperty("stusex", stusex);
/*     */   }
/*     */ 
/*     */   public List findAll() {
/* 122 */     log.debug("finding all StuData instances");
/*     */     try {
/* 124 */       String queryString = "from StuData";
/* 125 */       Query queryObject = getSession().createQuery(queryString);
/* 126 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/* 128 */       log.error("find all failed", re);
/* 129 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public StuData merge(StuData detachedInstance) {
/* 134 */     log.debug("merging StuData instance");
/*     */     try {
/* 136 */       StuData result = (StuData)getSession().merge(detachedInstance);
/* 137 */       log.debug("merge successful");
/* 138 */       return result;
/*     */     } catch (RuntimeException re) {
/* 140 */       log.error("merge failed", re);
/* 141 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachDirty(StuData instance) {
/* 146 */     log.debug("attaching dirty StuData instance");
/*     */     try {
/* 148 */       getSession().saveOrUpdate(instance);
/* 149 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 151 */       log.error("attach failed", re);
/* 152 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachClean(StuData instance) {
/* 157 */     log.debug("attaching clean StuData instance");
/*     */     try {
/* 159 */       getSession().lock(instance, LockMode.NONE);
/* 160 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 162 */       log.error("attach failed", re);
/* 163 */       throw re;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.basedata.StuDataDAO
 * JD-Core Version:    0.5.4
 */