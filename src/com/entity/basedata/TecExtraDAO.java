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
/*     */ public class TecExtraDAO extends BaseHibernateDAO
/*     */ {
/*  24 */   private static final Log log = LogFactory.getLog(TecExtraDAO.class);
/*     */   public static final String TECTEL = "tectel";
/*     */   public static final String TECTEL2 = "tectel2";
/*     */   public static final String TECEMAIL = "tecemail";
/*     */   public static final String TECQQ = "tecqq";
/*     */   public static final String TECPROF = "tecprof";
/*     */   public static final String TECEDU = "tecedu";
/*     */   public static final String TECFIELD = "tecfield";
/*     */   public static final String TECHONOR = "techonor";
/*     */   public static final String TECNOTES = "tecnotes";
/*     */ 
/*     */   public void save(TecExtra transientInstance)
/*     */   {
/*  37 */     log.debug("saving TecExtra instance");
/*     */     try {
/*  39 */       getSession().save(transientInstance);
/*  40 */       log.debug("save successful");
/*     */     } catch (RuntimeException re) {
/*  42 */       log.error("save failed", re);
/*  43 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void delete(TecExtra persistentInstance) {
/*  48 */     log.debug("deleting TecExtra instance");
/*     */     try {
/*  50 */       getSession().delete(persistentInstance);
/*  51 */       log.debug("delete successful");
/*     */     } catch (RuntimeException re) {
/*  53 */       log.error("delete failed", re);
/*  54 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public TecExtra findById(String id) {
/*  59 */     log.debug("getting TecExtra instance with id: " + id);
/*     */     try {
/*  61 */       TecExtra instance = (TecExtra)getSession().get(
/*  62 */         "com.entity.basedata.TecExtra", id);
/*  63 */       return instance;
/*     */     } catch (RuntimeException re) {
/*  65 */       log.error("get failed", re);
/*  66 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByExample(TecExtra instance) {
/*  71 */     log.debug("finding TecExtra instance by example");
/*     */     try {
/*  73 */       List results = getSession().createCriteria(
/*  74 */         "com.entity.basedata.TecExtra").add(
/*  75 */         Example.create(instance)).list();
/*  76 */       log.debug("find by example successful, result size: " + 
/*  77 */         results.size());
/*  78 */       return results;
/*     */     } catch (RuntimeException re) {
/*  80 */       log.error("find by example failed", re);
/*  81 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByProperty(String propertyName, Object value) {
/*  86 */     log.debug("finding TecExtra instance with property: " + propertyName + 
/*  87 */       ", value: " + value);
/*     */     try {
/*  89 */       String queryString = "from TecExtra as model where model." + 
/*  90 */         propertyName + "= ?";
/*  91 */       Query queryObject = getSession().createQuery(queryString);
/*  92 */       queryObject.setParameter(0, value);
/*  93 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/*  95 */       log.error("find by property name failed", re);
/*  96 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByTectel(Object tectel) {
/* 101 */     return findByProperty("tectel", tectel);
/*     */   }
/*     */ 
/*     */   public List findByTectel2(Object tectel2) {
/* 105 */     return findByProperty("tectel2", tectel2);
/*     */   }
/*     */ 
/*     */   public List findByTecemail(Object tecemail) {
/* 109 */     return findByProperty("tecemail", tecemail);
/*     */   }
/*     */ 
/*     */   public List findByTecqq(Object tecqq) {
/* 113 */     return findByProperty("tecqq", tecqq);
/*     */   }
/*     */ 
/*     */   public List findByTecprof(Object tecprof) {
/* 117 */     return findByProperty("tecprof", tecprof);
/*     */   }
/*     */ 
/*     */   public List findByTecedu(Object tecedu) {
/* 121 */     return findByProperty("tecedu", tecedu);
/*     */   }
/*     */ 
/*     */   public List findByTecfield(Object tecfield) {
/* 125 */     return findByProperty("tecfield", tecfield);
/*     */   }
/*     */ 
/*     */   public List findByTechonor(Object techonor) {
/* 129 */     return findByProperty("techonor", techonor);
/*     */   }
/*     */ 
/*     */   public List findByTecnotes(Object tecnotes) {
/* 133 */     return findByProperty("tecnotes", tecnotes);
/*     */   }
/*     */ 
/*     */   public List findAll() {
/* 137 */     log.debug("finding all TecExtra instances");
/*     */     try {
/* 139 */       String queryString = "from TecExtra";
/* 140 */       Query queryObject = getSession().createQuery(queryString);
/* 141 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/* 143 */       log.error("find all failed", re);
/* 144 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public TecExtra merge(TecExtra detachedInstance) {
/* 149 */     log.debug("merging TecExtra instance");
/*     */     try {
/* 151 */       TecExtra result = (TecExtra)getSession().merge(detachedInstance);
/* 152 */       log.debug("merge successful");
/* 153 */       return result;
/*     */     } catch (RuntimeException re) {
/* 155 */       log.error("merge failed", re);
/* 156 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachDirty(TecExtra instance) {
/* 161 */     log.debug("attaching dirty TecExtra instance");
/*     */     try {
/* 163 */       getSession().saveOrUpdate(instance);
/* 164 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 166 */       log.error("attach failed", re);
/* 167 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachClean(TecExtra instance) {
/* 172 */     log.debug("attaching clean TecExtra instance");
/*     */     try {
/* 174 */       getSession().lock(instance, LockMode.NONE);
/* 175 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 177 */       log.error("attach failed", re);
/* 178 */       throw re;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.basedata.TecExtraDAO
 * JD-Core Version:    0.5.4
 */