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
/*     */ public class PingyuTecDAO extends BaseHibernateDAO
/*     */ {
/*  25 */   private static final Log log = LogFactory.getLog(PingyuTecDAO.class);
/*     */   public static final String STUCODE = "stucode";
/*     */   public static final String TECCODE = "teccode";
/*     */   public static final String ATID = "atid";
/*     */   public static final String PINGYU = "pingyu";
/*     */   public static final String CHENGJI = "chengji";
/*     */ 
/*     */   public void save(PingyuTec transientInstance)
/*     */   {
/*  34 */     log.debug("saving PingyuTec instance");
/*     */     try {
/*  36 */       getSession().save(transientInstance);
/*  37 */       log.debug("save successful");
/*     */     } catch (RuntimeException re) {
/*  39 */       log.error("save failed", re);
/*  40 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void delete(PingyuTec persistentInstance) {
/*  45 */     log.debug("deleting PingyuTec instance");
/*     */     try {
/*  47 */       getSession().delete(persistentInstance);
/*  48 */       log.debug("delete successful");
/*     */     } catch (RuntimeException re) {
/*  50 */       log.error("delete failed", re);
/*  51 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public PingyuTec findById(Integer id) {
/*  56 */     log.debug("getting PingyuTec instance with id: " + id);
/*     */     try {
/*  58 */       PingyuTec instance = (PingyuTec)getSession().get(
/*  59 */         "com.entity.pingyue.PingyuTec", id);
/*  60 */       return instance;
/*     */     } catch (RuntimeException re) {
/*  62 */       log.error("get failed", re);
/*  63 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByExample(PingyuTec instance) {
/*  68 */     log.debug("finding PingyuTec instance by example");
/*     */     try {
/*  70 */       List results = getSession().createCriteria(
/*  71 */         "com.entity.pingyue.PingyuTec").add(
/*  72 */         Example.create(instance)).list();
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
/*  83 */     log.debug("finding PingyuTec instance with property: " + propertyName + 
/*  84 */       ", value: " + value);
/*     */     try {
/*  86 */       String queryString = "from PingyuTec as model where model." + 
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
/*     */   public List findByStucode(Object stucode) {
/*  98 */     return findByProperty("stucode", stucode);
/*     */   }
/*     */ 
/*     */   public List findByTeccode(Object teccode) {
/* 102 */     return findByProperty("teccode", teccode);
/*     */   }
/*     */ 
/*     */   public List findByAtid(Object atid) {
/* 106 */     return findByProperty("atid", atid);
/*     */   }
/*     */ 
/*     */   public List findByPingyu(Object pingyu) {
/* 110 */     return findByProperty("pingyu", pingyu);
/*     */   }
/*     */ 
/*     */   public List findByChengji(Object chengji) {
/* 114 */     return findByProperty("chengji", chengji);
/*     */   }
/*     */ 
/*     */   public List findAll() {
/* 118 */     log.debug("finding all PingyuTec instances");
/*     */     try {
/* 120 */       String queryString = "from PingyuTec";
/* 121 */       Query queryObject = getSession().createQuery(queryString);
/* 122 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/* 124 */       log.error("find all failed", re);
/* 125 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public PingyuTec merge(PingyuTec detachedInstance) {
/* 130 */     log.debug("merging PingyuTec instance");
/*     */     try {
/* 132 */       PingyuTec result = (PingyuTec)getSession().merge(detachedInstance);
/* 133 */       log.debug("merge successful");
/* 134 */       return result;
/*     */     } catch (RuntimeException re) {
/* 136 */       log.error("merge failed", re);
/* 137 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachDirty(PingyuTec instance) {
/* 142 */     log.debug("attaching dirty PingyuTec instance");
/*     */     try {
/* 144 */       getSession().saveOrUpdate(instance);
/* 145 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 147 */       log.error("attach failed", re);
/* 148 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachClean(PingyuTec instance) {
/* 153 */     log.debug("attaching clean PingyuTec instance");
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
 * Qualified Name:     com.entity.pingyue.PingyuTecDAO
 * JD-Core Version:    0.5.4
 */