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
/*     */ public class DabianGroupDAO extends BaseHibernateDAO
/*     */ {
/*  24 */   private static final Log log = LogFactory.getLog(DabianGroupDAO.class);
/*     */   public static final String COLLEGEID = "collegeid";
/*     */   public static final String DEPARTID = "departid";
/*     */   public static final String GRADEID = "gradeid";
/*     */   public static final String GROUPNAME = "groupname";
/*     */   public static final String CHAIRMAN = "chairman";
/*     */   public static final String LEADER = "leader";
/*     */   public static final String DATETIME = "datetime";
/*     */   public static final String PLACE = "place";
/*     */ 
/*     */   public void save(DabianGroup transientInstance)
/*     */   {
/*  36 */     log.debug("saving DabianGroup instance");
/*     */     try {
/*  38 */       getSession().save(transientInstance);
/*  39 */       log.debug("save successful");
/*     */     } catch (RuntimeException re) {
/*  41 */       log.error("save failed", re);
/*  42 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void delete(DabianGroup persistentInstance) {
/*  47 */     log.debug("deleting DabianGroup instance");
/*     */     try {
/*  49 */       getSession().delete(persistentInstance);
/*  50 */       log.debug("delete successful");
/*     */     } catch (RuntimeException re) {
/*  52 */       log.error("delete failed", re);
/*  53 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public DabianGroup findById(Integer id) {
/*  58 */     log.debug("getting DabianGroup instance with id: " + id);
/*     */     try {
/*  60 */       DabianGroup instance = (DabianGroup)getSession().get(
/*  61 */         "com.entity.dabian.DabianGroup", id);
/*  62 */       return instance;
/*     */     } catch (RuntimeException re) {
/*  64 */       log.error("get failed", re);
/*  65 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByExample(DabianGroup instance) {
/*  70 */     log.debug("finding DabianGroup instance by example");
/*     */     try {
/*  72 */       List results = getSession().createCriteria(
/*  73 */         "com.entity.dabian.DabianGroup").add(
/*  74 */         Example.create(instance)).list();
/*  75 */       log.debug("find by example successful, result size: " + 
/*  76 */         results.size());
/*  77 */       return results;
/*     */     } catch (RuntimeException re) {
/*  79 */       log.error("find by example failed", re);
/*  80 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByProperty(String propertyName, Object value) {
/*  85 */     log.debug("finding DabianGroup instance with property: " + propertyName + 
/*  86 */       ", value: " + value);
/*     */     try {
/*  88 */       String queryString = "from DabianGroup as model where model." + 
/*  89 */         propertyName + "= ?";
/*  90 */       Query queryObject = getSession().createQuery(queryString);
/*  91 */       queryObject.setParameter(0, value);
/*  92 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/*  94 */       log.error("find by property name failed", re);
/*  95 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByCollegeid(Object collegeid) {
/* 100 */     return findByProperty("collegeid", collegeid);
/*     */   }
/*     */ 
/*     */   public List findByDepartid(Object departid) {
/* 104 */     return findByProperty("departid", departid);
/*     */   }
/*     */ 
/*     */   public List findByGradeid(Object gradeid) {
/* 108 */     return findByProperty("gradeid", gradeid);
/*     */   }
/*     */ 
/*     */   public List findByGroupname(Object groupname) {
/* 112 */     return findByProperty("groupname", groupname);
/*     */   }
/*     */ 
/*     */   public List findByChairman(Object chairman) {
/* 116 */     return findByProperty("chairman", chairman);
/*     */   }
/*     */ 
/*     */   public List findByLeader(Object leader) {
/* 120 */     return findByProperty("leader", leader);
/*     */   }
/*     */ 
/*     */   public List findByDatetime(Object datetime) {
/* 124 */     return findByProperty("datetime", datetime);
/*     */   }
/*     */ 
/*     */   public List findByPlace(Object place) {
/* 128 */     return findByProperty("place", place);
/*     */   }
/*     */ 
/*     */   public List findAll() {
/* 132 */     log.debug("finding all DabianGroup instances");
/*     */     try {
/* 134 */       String queryString = "from DabianGroup";
/* 135 */       Query queryObject = getSession().createQuery(queryString);
/* 136 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/* 138 */       log.error("find all failed", re);
/* 139 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public DabianGroup merge(DabianGroup detachedInstance) {
/* 144 */     log.debug("merging DabianGroup instance");
/*     */     try {
/* 146 */       DabianGroup result = (DabianGroup)getSession().merge(
/* 147 */         detachedInstance);
/* 148 */       log.debug("merge successful");
/* 149 */       return result;
/*     */     } catch (RuntimeException re) {
/* 151 */       log.error("merge failed", re);
/* 152 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachDirty(DabianGroup instance) {
/* 157 */     log.debug("attaching dirty DabianGroup instance");
/*     */     try {
/* 159 */       getSession().saveOrUpdate(instance);
/* 160 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 162 */       log.error("attach failed", re);
/* 163 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachClean(DabianGroup instance) {
/* 168 */     log.debug("attaching clean DabianGroup instance");
/*     */     try {
/* 170 */       getSession().lock(instance, LockMode.NONE);
/* 171 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 173 */       log.error("attach failed", re);
/* 174 */       throw re;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.dabian.DabianGroupDAO
 * JD-Core Version:    0.5.4
 */