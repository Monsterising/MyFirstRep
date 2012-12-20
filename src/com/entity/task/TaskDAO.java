/*     */ package com.entity.task;
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
/*     */ public class TaskDAO extends BaseHibernateDAO
/*     */ {
/*  24 */   private static final Log log = LogFactory.getLog(TaskDAO.class);
/*     */   public static final String STUCODE = "stucode";
/*     */   public static final String TECCODE = "teccode";
/*     */   public static final String ATID = "atid";
/*     */   public static final String ZILIAO = "ziliao";
/*     */   public static final String YAOQIU = "yaoqiu";
/*     */   public static final String NEIRONG = "neirong";
/*     */   public static final String DATEFAGEI = "datefagei";
/*     */   public static final String DATESTART = "datestart";
/*     */   public static final String DATEOVER = "dateover";
/*     */   public static final String DEPARTID = "departid";
/*     */   public static final String COLLEGEID = "collegeid";
/*     */ 
/*     */   public void save(Task transientInstance)
/*     */   {
/*  39 */     log.debug("saving Task instance");
/*     */     try {
/*  41 */       getSession().save(transientInstance);
/*  42 */       log.debug("save successful");
/*     */     } catch (RuntimeException re) {
/*  44 */       log.error("save failed", re);
/*  45 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void delete(Task persistentInstance) {
/*  50 */     log.debug("deleting Task instance");
/*     */     try {
/*  52 */       getSession().delete(persistentInstance);
/*  53 */       log.debug("delete successful");
/*     */     } catch (RuntimeException re) {
/*  55 */       log.error("delete failed", re);
/*  56 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public Task findById(Integer id) {
/*  61 */     log.debug("getting Task instance with id: " + id);
/*     */     try {
/*  63 */       Task instance = (Task)getSession().get("com.entity.task.Task", id);
/*  64 */       return instance;
/*     */     } catch (RuntimeException re) {
/*  66 */       log.error("get failed", re);
/*  67 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByExample(Task instance) {
/*  72 */     log.debug("finding Task instance by example");
/*     */     try {
/*  74 */       List results = getSession().createCriteria("com.entity.task.Task")
/*  75 */         .add(Example.create(instance)).list();
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
/*  86 */     log.debug("finding Task instance with property: " + propertyName + 
/*  87 */       ", value: " + value);
/*     */     try {
/*  89 */       String queryString = "from Task as model where model." + 
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
/*     */   public List findByStucode(Object stucode) {
/* 101 */     return findByProperty("stucode", stucode);
/*     */   }
/*     */ 
/*     */   public List findByTeccode(Object teccode) {
/* 105 */     return findByProperty("teccode", teccode);
/*     */   }
/*     */ 
/*     */   public List findByAtid(Object atid) {
/* 109 */     return findByProperty("atid", atid);
/*     */   }
/*     */ 
/*     */   public List findByZiliao(Object ziliao) {
/* 113 */     return findByProperty("ziliao", ziliao);
/*     */   }
/*     */ 
/*     */   public List findByYaoqiu(Object yaoqiu) {
/* 117 */     return findByProperty("yaoqiu", yaoqiu);
/*     */   }
/*     */ 
/*     */   public List findByNeirong(Object neirong) {
/* 121 */     return findByProperty("neirong", neirong);
/*     */   }
/*     */ 
/*     */   public List findByDatefagei(Object datefagei) {
/* 125 */     return findByProperty("datefagei", datefagei);
/*     */   }
/*     */ 
/*     */   public List findByDatestart(Object datestart) {
/* 129 */     return findByProperty("datestart", datestart);
/*     */   }
/*     */ 
/*     */   public List findByDateover(Object dateover) {
/* 133 */     return findByProperty("dateover", dateover);
/*     */   }
/*     */ 
/*     */   public List findByDepartid(Object departid) {
/* 137 */     return findByProperty("departid", departid);
/*     */   }
/*     */ 
/*     */   public List findByCollegeid(Object collegeid) {
/* 141 */     return findByProperty("collegeid", collegeid);
/*     */   }
/*     */ 
/*     */   public List findAll() {
/* 145 */     log.debug("finding all Task instances");
/*     */     try {
/* 147 */       String queryString = "from Task";
/* 148 */       Query queryObject = getSession().createQuery(queryString);
/* 149 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/* 151 */       log.error("find all failed", re);
/* 152 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public Task merge(Task detachedInstance) {
/* 157 */     log.debug("merging Task instance");
/*     */     try {
/* 159 */       Task result = (Task)getSession().merge(detachedInstance);
/* 160 */       log.debug("merge successful");
/* 161 */       return result;
/*     */     } catch (RuntimeException re) {
/* 163 */       log.error("merge failed", re);
/* 164 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachDirty(Task instance) {
/* 169 */     log.debug("attaching dirty Task instance");
/*     */     try {
/* 171 */       getSession().saveOrUpdate(instance);
/* 172 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 174 */       log.error("attach failed", re);
/* 175 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachClean(Task instance) {
/* 180 */     log.debug("attaching clean Task instance");
/*     */     try {
/* 182 */       getSession().lock(instance, LockMode.NONE);
/* 183 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 185 */       log.error("attach failed", re);
/* 186 */       throw re;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.task.TaskDAO
 * JD-Core Version:    0.5.4
 */