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
/*     */ public class TecListDAO extends BaseHibernateDAO
/*     */ {
/*  24 */   private static final Log log = LogFactory.getLog(TecListDAO.class);
/*     */   public static final String TECNAME = "tecname";
/*     */   public static final String TECSEX = "tecsex";
/*     */   public static final String TECPASS = "tecpass";
/*     */   public static final String COLLEGEID = "collegeid";
/*     */   public static final String TECROLE = "tecrole";
/*     */ 
/*     */   public void save(TecList transientInstance)
/*     */   {
/*  33 */     log.debug("saving TecList instance");
/*     */     try {
/*  35 */       getSession().save(transientInstance);
/*  36 */       log.debug("save successful");
/*     */     } catch (RuntimeException re) {
/*  38 */       log.error("save failed", re);
/*  39 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void delete(TecList persistentInstance) {
/*  44 */     log.debug("deleting TecList instance");
/*     */     try {
/*  46 */       getSession().delete(persistentInstance);
/*  47 */       log.debug("delete successful");
/*     */     } catch (RuntimeException re) {
/*  49 */       log.error("delete failed", re);
/*  50 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public TecList findById(String id) {
/*  55 */     log.debug("getting TecList instance with id: " + id);
/*     */     try {
/*  57 */       TecList instance = (TecList)getSession().get(
/*  58 */         "com.entity.basedata.TecList", id);
/*  59 */       return instance;
/*     */     } catch (RuntimeException re) {
/*  61 */       log.error("get failed", re);
/*  62 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByExample(TecList instance) {
/*  67 */     log.debug("finding TecList instance by example");
/*     */     try {
/*  69 */       List results = getSession().createCriteria(
/*  70 */         "com.entity.basedata.TecList")
/*  71 */         .add(Example.create(instance)).list();
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
/*  82 */     log.debug("finding TecList instance with property: " + propertyName + 
/*  83 */       ", value: " + value);
/*     */     try {
/*  85 */       String queryString = "from TecList as model where model." + 
/*  86 */         propertyName + "= ? order by teccode";
/*  87 */       Query queryObject = getSession().createQuery(queryString);
/*  88 */       queryObject.setParameter(0, value);
/*  89 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/*  91 */       log.error("find by property name failed", re);
/*  92 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByTecname(Object tecname) {
/*  97 */     return findByProperty("tecname", tecname);
/*     */   }
/*     */ 
/*     */   public List findByTecsex(Object tecsex) {
/* 101 */     return findByProperty("tecsex", tecsex);
/*     */   }
/*     */ 
/*     */   public List findByTecpass(Object tecpass) {
/* 105 */     return findByProperty("tecpass", tecpass);
/*     */   }
/*     */ 
/*     */   public List findByCollegeid(Object collegeid) {
/* 109 */     return findByProperty("collegeid", collegeid);
/*     */   }
/*     */ 
/*     */   public List findByTecrole(Object tecrole) {
/* 113 */     return findByProperty("tecrole", tecrole);
/*     */   }
/*     */ 
/*     */   public List findAll() {
/* 117 */     log.debug("finding all TecList instances");
/*     */     try {
/* 119 */       String queryString = "from TecList";
/* 120 */       Query queryObject = getSession().createQuery(queryString);
/* 121 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/* 123 */       log.error("find all failed", re);
/* 124 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public TecList merge(TecList detachedInstance) {
/* 129 */     log.debug("merging TecList instance");
/*     */     try {
/* 131 */       TecList result = (TecList)getSession().merge(detachedInstance);
/* 132 */       log.debug("merge successful");
/* 133 */       return result;
/*     */     } catch (RuntimeException re) {
/* 135 */       log.error("merge failed", re);
/* 136 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachDirty(TecList instance) {
/* 141 */     log.debug("attaching dirty TecList instance");
/*     */     try {
/* 143 */       getSession().saveOrUpdate(instance);
/* 144 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 146 */       log.error("attach failed", re);
/* 147 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachClean(TecList instance) {
/* 152 */     log.debug("attaching clean TecList instance");
/*     */     try {
/* 154 */       getSession().lock(instance, LockMode.NONE);
/* 155 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 157 */       log.error("attach failed", re);
/* 158 */       throw re;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.basedata.TecListDAO
 * JD-Core Version:    0.5.4
 */