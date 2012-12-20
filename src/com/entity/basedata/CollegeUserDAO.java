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
/*     */ public class CollegeUserDAO extends BaseHibernateDAO
/*     */ {
/*  24 */   private static final Log log = LogFactory.getLog(CollegeUserDAO.class);
/*     */   public static final String COLLEGEID = "collegeid";
/*     */   public static final String USERID = "userid";
/*     */   public static final String CUROLE = "curole";
/*     */ 
/*     */   public void save(CollegeUser transientInstance)
/*     */   {
/*  31 */     log.debug("saving CollegeUser instance");
/*     */     try {
/*  33 */       getSession().save(transientInstance);
/*  34 */       log.debug("save successful");
/*     */     } catch (RuntimeException re) {
/*  36 */       log.error("save failed", re);
/*  37 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void delete(CollegeUser persistentInstance) {
/*  42 */     log.debug("deleting CollegeUser instance");
/*     */     try {
/*  44 */       getSession().delete(persistentInstance);
/*  45 */       log.debug("delete successful");
/*     */     } catch (RuntimeException re) {
/*  47 */       log.error("delete failed", re);
/*  48 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public CollegeUser findById(Integer id) {
/*  53 */     log.debug("getting CollegeUser instance with id: " + id);
/*     */     try {
/*  55 */       CollegeUser instance = (CollegeUser)getSession().get(
/*  56 */         "com.entity.basedata.CollegeUser", id);
/*  57 */       return instance;
/*     */     } catch (RuntimeException re) {
/*  59 */       log.error("get failed", re);
/*  60 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByExample(CollegeUser instance) {
/*  65 */     log.debug("finding CollegeUser instance by example");
/*     */     try {
/*  67 */       List results = getSession().createCriteria(
/*  68 */         "com.entity.basedata.CollegeUser").add(
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
/*  80 */     log.debug("finding CollegeUser instance with property: " + propertyName + 
/*  81 */       ", value: " + value);
/*     */     try {
/*  83 */       String queryString = "from CollegeUser as model where model." + 
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
/*     */   public List findByCollegeid(Object collegeid) {
/*  95 */     return findByProperty("collegeid", collegeid);
/*     */   }
/*     */ 
/*     */   public List findByUserid(Object userid) {
/*  99 */     return findByProperty("userid", userid);
/*     */   }
/*     */ 
/*     */   public List findByCurole(Object curole) {
/* 103 */     return findByProperty("curole", curole);
/*     */   }
/*     */ 
/*     */   public List findAll() {
/* 107 */     log.debug("finding all CollegeUser instances");
/*     */     try {
/* 109 */       String queryString = "from CollegeUser";
/* 110 */       Query queryObject = getSession().createQuery(queryString);
/* 111 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/* 113 */       log.error("find all failed", re);
/* 114 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public CollegeUser merge(CollegeUser detachedInstance) {
/* 119 */     log.debug("merging CollegeUser instance");
/*     */     try {
/* 121 */       CollegeUser result = (CollegeUser)getSession().merge(
/* 122 */         detachedInstance);
/* 123 */       log.debug("merge successful");
/* 124 */       return result;
/*     */     } catch (RuntimeException re) {
/* 126 */       log.error("merge failed", re);
/* 127 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachDirty(CollegeUser instance) {
/* 132 */     log.debug("attaching dirty CollegeUser instance");
/*     */     try {
/* 134 */       getSession().saveOrUpdate(instance);
/* 135 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 137 */       log.error("attach failed", re);
/* 138 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachClean(CollegeUser instance) {
/* 143 */     log.debug("attaching clean CollegeUser instance");
/*     */     try {
/* 145 */       getSession().lock(instance, LockMode.NONE);
/* 146 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 148 */       log.error("attach failed", re);
/* 149 */       throw re;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.basedata.CollegeUserDAO
 * JD-Core Version:    0.5.4
 */