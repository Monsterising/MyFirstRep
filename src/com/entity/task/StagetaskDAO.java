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
/*     */ public class StagetaskDAO extends BaseHibernateDAO
/*     */ {
/*  25 */   private static final Log log = LogFactory.getLog(StagetaskDAO.class);
/*     */   public static final String ATID = "atid";
/*     */   public static final String STUCODE = "stucode";
/*     */   public static final String TECCODE = "teccode";
/*     */   public static final String DATESTART = "datestart";
/*     */   public static final String DATEOVER = "dateover";
/*     */   public static final String TASKNAME = "taskname";
/*     */   public static final String IS_FINISH = "isFinish";
/*     */   public static final String RESULT = "result";
/*     */   public static final String NOTES = "notes";
/*     */   public static final String IS_FUJIAN = "isFujian";
/*     */   public static final String IS_DAYI = "isDayi";
/*     */   public static final String GRADE = "grade";
/*     */   public static final String DATEFAGEI = "datefagei";
/*     */   public static final String GRADEID = "gradeid";
/*     */ 
/*     */   public void save(Stagetask transientInstance)
/*     */   {
/*  43 */     log.debug("saving Stagetask instance");
/*     */     try {
/*  45 */       getSession().save(transientInstance);
/*  46 */       log.debug("save successful");
/*     */     } catch (RuntimeException re) {
/*  48 */       log.error("save failed", re);
/*  49 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void delete(Stagetask persistentInstance) {
/*  54 */     log.debug("deleting Stagetask instance");
/*     */     try {
/*  56 */       getSession().delete(persistentInstance);
/*  57 */       log.debug("delete successful");
/*     */     } catch (RuntimeException re) {
/*  59 */       log.error("delete failed", re);
/*  60 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public Stagetask findById(Integer id) {
/*  65 */     log.debug("getting Stagetask instance with id: " + id);
/*     */     try {
/*  67 */       Stagetask instance = (Stagetask)getSession().get(
/*  68 */         "com.entity.task.Stagetask", id);
/*  69 */       return instance;
/*     */     } catch (RuntimeException re) {
/*  71 */       log.error("get failed", re);
/*  72 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByExample(Stagetask instance) {
/*  77 */     log.debug("finding Stagetask instance by example");
/*     */     try {
/*  79 */       List results = getSession().createCriteria(
/*  80 */         "com.entity.task.Stagetask").add(Example.create(instance))
/*  81 */         .list();
/*  82 */       log.debug("find by example successful, result size: " + 
/*  83 */         results.size());
/*  84 */       return results;
/*     */     } catch (RuntimeException re) {
/*  86 */       log.error("find by example failed", re);
/*  87 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByProperty(String propertyName, Object value) {
/*  92 */     log.debug("finding Stagetask instance with property: " + propertyName + 
/*  93 */       ", value: " + value);
/*     */     try {
/*  95 */       String queryString = "from Stagetask as model where model." + 
/*  96 */         propertyName + "= ?";
/*  97 */       Query queryObject = getSession().createQuery(queryString);
/*  98 */       queryObject.setParameter(0, value);
/*  99 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/* 101 */       log.error("find by property name failed", re);
/* 102 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByAtid(Object atid) {
/* 107 */     return findByProperty("atid", atid);
/*     */   }
/*     */ 
/*     */   public List findByStucode(Object stucode) {
/* 111 */     return findByProperty("stucode", stucode);
/*     */   }
/*     */ 
/*     */   public List findByTeccode(Object teccode) {
/* 115 */     return findByProperty("teccode", teccode);
/*     */   }
/*     */ 
/*     */   public List findByDatestart(Object datestart) {
/* 119 */     return findByProperty("datestart", datestart);
/*     */   }
/*     */ 
/*     */   public List findByDateover(Object dateover) {
/* 123 */     return findByProperty("dateover", dateover);
/*     */   }
/*     */ 
/*     */   public List findByTaskname(Object taskname) {
/* 127 */     return findByProperty("taskname", taskname);
/*     */   }
/*     */ 
/*     */   public List findByIsFinish(Object isFinish) {
/* 131 */     return findByProperty("isFinish", isFinish);
/*     */   }
/*     */ 
/*     */   public List findByResult(Object result) {
/* 135 */     return findByProperty("result", result);
/*     */   }
/*     */ 
/*     */   public List findByNotes(Object notes) {
/* 139 */     return findByProperty("notes", notes);
/*     */   }
/*     */ 
/*     */   public List findByIsFujian(Object isFujian) {
/* 143 */     return findByProperty("isFujian", isFujian);
/*     */   }
/*     */ 
/*     */   public List findByIsDayi(Object isDayi) {
/* 147 */     return findByProperty("isDayi", isDayi);
/*     */   }
/*     */ 
/*     */   public List findByGrade(Object grade) {
/* 151 */     return findByProperty("grade", grade);
/*     */   }
/*     */ 
/*     */   public List findByDatefagei(Object datefagei) {
/* 155 */     return findByProperty("datefagei", datefagei);
/*     */   }
/*     */ 
/*     */   public List findByGradeid(Object gradeid) {
/* 159 */     return findByProperty("gradeid", gradeid);
/*     */   }
/*     */ 
/*     */   public List findAll() {
/* 163 */     log.debug("finding all Stagetask instances");
/*     */     try {
/* 165 */       String queryString = "from Stagetask";
/* 166 */       Query queryObject = getSession().createQuery(queryString);
/* 167 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/* 169 */       log.error("find all failed", re);
/* 170 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public Stagetask merge(Stagetask detachedInstance) {
/* 175 */     log.debug("merging Stagetask instance");
/*     */     try {
/* 177 */       Stagetask result = (Stagetask)getSession().merge(detachedInstance);
/* 178 */       log.debug("merge successful");
/* 179 */       return result;
/*     */     } catch (RuntimeException re) {
/* 181 */       log.error("merge failed", re);
/* 182 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachDirty(Stagetask instance) {
/* 187 */     log.debug("attaching dirty Stagetask instance");
/*     */     try {
/* 189 */       getSession().saveOrUpdate(instance);
/* 190 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 192 */       log.error("attach failed", re);
/* 193 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachClean(Stagetask instance) {
/* 198 */     log.debug("attaching clean Stagetask instance");
/*     */     try {
/* 200 */       getSession().lock(instance, LockMode.NONE);
/* 201 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 203 */       log.error("attach failed", re);
/* 204 */       throw re;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.task.StagetaskDAO
 * JD-Core Version:    0.5.4
 */