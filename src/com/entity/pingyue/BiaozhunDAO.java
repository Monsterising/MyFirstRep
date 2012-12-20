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
/*     */ public class BiaozhunDAO extends BaseHibernateDAO
/*     */ {
/*  24 */   private static final Log log = LogFactory.getLog(BiaozhunDAO.class);
/*     */   public static final String TYPE = "type";
/*     */   public static final String GRADE = "grade";
/*     */   public static final String MAXNUM = "maxnum";
/*     */   public static final String MINNUM = "minnum";
/*     */   public static final String CONTENT = "content";
/*     */ 
/*     */   public void save(Biaozhun transientInstance)
/*     */   {
/*  33 */     log.debug("saving Biaozhun instance");
/*     */     try {
/*  35 */       getSession().save(transientInstance);
/*  36 */       log.debug("save successful");
/*     */     } catch (RuntimeException re) {
/*  38 */       log.error("save failed", re);
/*  39 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void delete(Biaozhun persistentInstance) {
/*  44 */     log.debug("deleting Biaozhun instance");
/*     */     try {
/*  46 */       getSession().delete(persistentInstance);
/*  47 */       log.debug("delete successful");
/*     */     } catch (RuntimeException re) {
/*  49 */       log.error("delete failed", re);
/*  50 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public Biaozhun findById(Integer id) {
/*  55 */     log.debug("getting Biaozhun instance with id: " + id);
/*     */     try {
/*  57 */       Biaozhun instance = (Biaozhun)getSession().get(
/*  58 */         "com.entity.pingyue.Biaozhun", id);
/*  59 */       return instance;
/*     */     } catch (RuntimeException re) {
/*  61 */       log.error("get failed", re);
/*  62 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByExample(Biaozhun instance) {
/*  67 */     log.debug("finding Biaozhun instance by example");
/*     */     try {
/*  69 */       List results = getSession().createCriteria(
/*  70 */         "com.entity.pingyue.Biaozhun")
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
/*  82 */     log.debug("finding Biaozhun instance with property: " + propertyName + 
/*  83 */       ", value: " + value);
/*     */     try {
/*  85 */       String queryString = "from Biaozhun as model where model." + 
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
/*     */   public List findByType(Object type) {
/*  97 */     return findByProperty("type", type);
/*     */   }
/*     */ 
/*     */   public List findByGrade(Object grade) {
/* 101 */     return findByProperty("grade", grade);
/*     */   }
/*     */ 
/*     */   public List findByMaxnum(Object maxnum) {
/* 105 */     return findByProperty("maxnum", maxnum);
/*     */   }
/*     */ 
/*     */   public List findByMinnum(Object minnum) {
/* 109 */     return findByProperty("minnum", minnum);
/*     */   }
/*     */ 
/*     */   public List findByContent(Object content) {
/* 113 */     return findByProperty("content", content);
/*     */   }
/*     */ 
/*     */   public List findAll() {
/* 117 */     log.debug("finding all Biaozhun instances");
/*     */     try {
/* 119 */       String queryString = "from Biaozhun";
/* 120 */       Query queryObject = getSession().createQuery(queryString);
/* 121 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/* 123 */       log.error("find all failed", re);
/* 124 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public Biaozhun merge(Biaozhun detachedInstance) {
/* 129 */     log.debug("merging Biaozhun instance");
/*     */     try {
/* 131 */       Biaozhun result = (Biaozhun)getSession().merge(detachedInstance);
/* 132 */       log.debug("merge successful");
/* 133 */       return result;
/*     */     } catch (RuntimeException re) {
/* 135 */       log.error("merge failed", re);
/* 136 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachDirty(Biaozhun instance) {
/* 141 */     log.debug("attaching dirty Biaozhun instance");
/*     */     try {
/* 143 */       getSession().saveOrUpdate(instance);
/* 144 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 146 */       log.error("attach failed", re);
/* 147 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachClean(Biaozhun instance) {
/* 152 */     log.debug("attaching clean Biaozhun instance");
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
 * Qualified Name:     com.entity.pingyue.BiaozhunDAO
 * JD-Core Version:    0.5.4
 */