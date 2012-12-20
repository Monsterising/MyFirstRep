/*     */ package com.entity.pingyue;
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
/*     */ public class PingyuGroupDAO extends BaseHibernateDAO
/*     */ {
/*  24 */   private static final Log log = LogFactory.getLog(PingyuGroupDAO.class);
/*     */   public static final String STUCODE = "stucode";
/*     */   public static final String TECCODE = "teccode";
/*     */   public static final String GRADEID = "gradeid";
/*     */   public static final String DEPARTID = "departid";
/*     */   public static final String CLASSID = "classid";
/*     */ 
/*     */   public void save(PingyuGroup transientInstance)
/*     */   {
/*  33 */     log.debug("saving PingyuGroup instance");
/*     */     try {
/*  35 */       getSession().save(transientInstance);
/*  36 */       log.debug("save successful");
/*     */     } catch (RuntimeException re) {
/*  38 */       log.error("save failed", re);
/*  39 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void delete(PingyuGroup persistentInstance) {
/*  44 */     log.debug("deleting PingyuGroup instance");
/*     */     try {
/*  46 */       getSession().delete(persistentInstance);
/*  47 */       log.debug("delete successful");
/*     */     } catch (RuntimeException re) {
/*  49 */       log.error("delete failed", re);
/*  50 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public PingyuGroup findById(Integer id) {
/*  55 */     log.debug("getting PingyuGroup instance with id: " + id);
/*     */     try {
/*  57 */       PingyuGroup instance = (PingyuGroup)getSession().get(
/*  58 */         "com.entity.pingyue.PingyuGroup", id);
/*  59 */       return instance;
/*     */     } catch (RuntimeException re) {
/*  61 */       log.error("get failed", re);
/*  62 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByExample(PingyuGroup instance) {
/*  67 */     log.debug("finding PingyuGroup instance by example");
/*     */     try {
/*  69 */       List results = getSession().createCriteria(
/*  70 */         "com.entity.pingyue.PingyuGroup").add(
/*  71 */         Example.create(instance)).list();
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
/*  82 */     log.debug("finding PingyuGroup instance with property: " + propertyName + 
/*  83 */       ", value: " + value);
/*     */     try {
/*  85 */       String queryString = "from PingyuGroup as model where model." + 
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
/*     */   public List findByStucode(Object stucode) {
/*  97 */     return findByProperty("stucode", stucode);
/*     */   }
/*     */ 
/*     */   public List findByTeccode(Object teccode) {
/* 101 */     return findByProperty("teccode", teccode);
/*     */   }
/*     */ 
/*     */   public List findByGradeid(Object gradeid) {
/* 105 */     return findByProperty("gradeid", gradeid);
/*     */   }
/*     */ 
/*     */   public List findByDepartid(Object departid) {
/* 109 */     return findByProperty("departid", departid);
/*     */   }
/*     */ 
/*     */   public List findByClassid(Object classid) {
/* 113 */     return findByProperty("classid", classid);
/*     */   }
/*     */ 
/*     */   public List findAll() {
/* 117 */     log.debug("finding all PingyuGroup instances");
/*     */     try {
/* 119 */       String queryString = "from PingyuGroup";
/* 120 */       Query queryObject = getSession().createQuery(queryString);
/* 121 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/* 123 */       log.error("find all failed", re);
/* 124 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public PingyuGroup merge(PingyuGroup detachedInstance) {
/* 129 */     log.debug("merging PingyuGroup instance");
/*     */     try {
/* 131 */       PingyuGroup result = (PingyuGroup)getSession().merge(
/* 132 */         detachedInstance);
/* 133 */       log.debug("merge successful");
/* 134 */       return result;
/*     */     } catch (RuntimeException re) {
/* 136 */       log.error("merge failed", re);
/* 137 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachDirty(PingyuGroup instance) {
/* 142 */     log.debug("attaching dirty PingyuGroup instance");
/*     */     try {
/* 144 */       getSession().saveOrUpdate(instance);
/* 145 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 147 */       log.error("attach failed", re);
/* 148 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachClean(PingyuGroup instance) {
/* 153 */     log.debug("attaching clean PingyuGroup instance");
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
 * Qualified Name:     com.entity.pingyue.PingyuGroupDAO
 * JD-Core Version:    0.5.4
 */