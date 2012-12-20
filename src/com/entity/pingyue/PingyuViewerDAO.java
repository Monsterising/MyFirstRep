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
/*     */ public class PingyuViewerDAO extends BaseHibernateDAO
/*     */ {
/*  25 */   private static final Log log = LogFactory.getLog(PingyuViewerDAO.class);
/*     */   public static final String STUCODE = "stucode";
/*     */   public static final String TECCODE = "teccode";
/*     */   public static final String ATID = "atid";
/*     */   public static final String PINGYU = "pingyu";
/*     */ 
/*     */   public void save(PingyuViewer transientInstance)
/*     */   {
/*  33 */     log.debug("saving PingyuViewer instance");
/*     */     try {
/*  35 */       getSession().save(transientInstance);
/*  36 */       log.debug("save successful");
/*     */     } catch (RuntimeException re) {
/*  38 */       log.error("save failed", re);
/*  39 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void delete(PingyuViewer persistentInstance) {
/*  44 */     log.debug("deleting PingyuViewer instance");
/*     */     try {
/*  46 */       getSession().delete(persistentInstance);
/*  47 */       log.debug("delete successful");
/*     */     } catch (RuntimeException re) {
/*  49 */       log.error("delete failed", re);
/*  50 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public PingyuViewer findById(Integer id) {
/*  55 */     log.debug("getting PingyuViewer instance with id: " + id);
/*     */     try {
/*  57 */       PingyuViewer instance = (PingyuViewer)getSession().get(
/*  58 */         "com.entity.pingyue.PingyuViewer", id);
/*  59 */       return instance;
/*     */     } catch (RuntimeException re) {
/*  61 */       log.error("get failed", re);
/*  62 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByExample(PingyuViewer instance) {
/*  67 */     log.debug("finding PingyuViewer instance by example");
/*     */     try {
/*  69 */       List results = getSession().createCriteria(
/*  70 */         "com.entity.pingyue.PingyuViewer").add(
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
/*  82 */     log.debug("finding PingyuViewer instance with property: " + 
/*  83 */       propertyName + ", value: " + value);
/*     */     try {
/*  85 */       String queryString = "from PingyuViewer as model where model." + 
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
/*     */   public List findByAtid(Object atid) {
/* 105 */     return findByProperty("atid", atid);
/*     */   }
/*     */ 
/*     */   public List findByPingyu(Object pingyu) {
/* 109 */     return findByProperty("pingyu", pingyu);
/*     */   }
/*     */ 
/*     */   public List findAll() {
/* 113 */     log.debug("finding all PingyuViewer instances");
/*     */     try {
/* 115 */       String queryString = "from PingyuViewer";
/* 116 */       Query queryObject = getSession().createQuery(queryString);
/* 117 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/* 119 */       log.error("find all failed", re);
/* 120 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public PingyuViewer merge(PingyuViewer detachedInstance) {
/* 125 */     log.debug("merging PingyuViewer instance");
/*     */     try {
/* 127 */       PingyuViewer result = (PingyuViewer)getSession().merge(
/* 128 */         detachedInstance);
/* 129 */       log.debug("merge successful");
/* 130 */       return result;
/*     */     } catch (RuntimeException re) {
/* 132 */       log.error("merge failed", re);
/* 133 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachDirty(PingyuViewer instance) {
/* 138 */     log.debug("attaching dirty PingyuViewer instance");
/*     */     try {
/* 140 */       getSession().saveOrUpdate(instance);
/* 141 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 143 */       log.error("attach failed", re);
/* 144 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachClean(PingyuViewer instance) {
/* 149 */     log.debug("attaching clean PingyuViewer instance");
/*     */     try {
/* 151 */       getSession().lock(instance, LockMode.NONE);
/* 152 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 154 */       log.error("attach failed", re);
/* 155 */       throw re;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.pingyue.PingyuViewerDAO
 * JD-Core Version:    0.5.4
 */