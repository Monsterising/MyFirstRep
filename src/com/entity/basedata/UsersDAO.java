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
/*     */ public class UsersDAO extends BaseHibernateDAO
/*     */ {
/*  24 */   private static final Log log = LogFactory.getLog(UsersDAO.class);
/*     */   public static final String USERNAME = "username";
/*     */   public static final String USERPASS = "userpass";
/*     */   public static final String USERREALNAME = "userrealname";
/*     */   public static final String USERROLE = "userrole";
/*     */ 
/*     */   public void save(Users transientInstance)
/*     */   {
/*  32 */     log.debug("saving Users instance");
/*     */     try {
/*  34 */       getSession().save(transientInstance);
/*  35 */       log.debug("save successful");
/*     */     } catch (RuntimeException re) {
/*  37 */       log.error("save failed", re);
/*  38 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void delete(Users persistentInstance) {
/*  43 */     log.debug("deleting Users instance");
/*     */     try {
/*  45 */       getSession().delete(persistentInstance);
/*  46 */       log.debug("delete successful");
/*     */     } catch (RuntimeException re) {
/*  48 */       log.error("delete failed", re);
/*  49 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public Users findById(Integer id) {
/*  54 */     log.debug("getting Users instance with id: " + id);
/*     */     try {
/*  56 */       Users instance = (Users)getSession().get(
/*  57 */         "com.entity.basedata.Users", id);
/*  58 */       return instance;
/*     */     } catch (RuntimeException re) {
/*  60 */       log.error("get failed", re);
/*  61 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByExample(Users instance) {
/*  66 */     log.debug("finding Users instance by example");
/*     */     try {
/*  68 */       List results = getSession().createCriteria(
/*  69 */         "com.entity.basedata.Users").add(Example.create(instance))
/*  70 */         .list();
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
/*  81 */     log.debug("finding Users instance with property: " + propertyName + 
/*  82 */       ", value: " + value);
/*     */     try {
/*  84 */       String queryString = "from Users as model where model." + 
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
/*     */   public List findByUsername(Object username) {
/*  96 */     return findByProperty("username", username);
/*     */   }
/*     */ 
/*     */   public List findByUserpass(Object userpass) {
/* 100 */     return findByProperty("userpass", userpass);
/*     */   }
/*     */ 
/*     */   public List findByUserrealname(Object userrealname) {
/* 104 */     return findByProperty("userrealname", userrealname);
/*     */   }
/*     */ 
/*     */   public List findByUserrole(Object userrole) {
/* 108 */     return findByProperty("userrole", userrole);
/*     */   }
/*     */ 
/*     */   public List findAll() {
/* 112 */     log.debug("finding all Users instances");
/*     */     try {
/* 114 */       String queryString = "from Users";
/* 115 */       Query queryObject = getSession().createQuery(queryString);
/* 116 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/* 118 */       log.error("find all failed", re);
/* 119 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public Users merge(Users detachedInstance) {
/* 124 */     log.debug("merging Users instance");
/*     */     try {
/* 126 */       Users result = (Users)getSession().merge(detachedInstance);
/* 127 */       log.debug("merge successful");
/* 128 */       return result;
/*     */     } catch (RuntimeException re) {
/* 130 */       log.error("merge failed", re);
/* 131 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachDirty(Users instance) {
/* 136 */     log.debug("attaching dirty Users instance");
/*     */     try {
/* 138 */       getSession().saveOrUpdate(instance);
/* 139 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 141 */       log.error("attach failed", re);
/* 142 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachClean(Users instance) {
/* 147 */     log.debug("attaching clean Users instance");
/*     */     try {
/* 149 */       getSession().lock(instance, LockMode.NONE);
/* 150 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 152 */       log.error("attach failed", re);
/* 153 */       throw re;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.basedata.UsersDAO
 * JD-Core Version:    0.5.4
 */