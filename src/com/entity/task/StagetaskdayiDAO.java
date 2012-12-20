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
/*     */ public class StagetaskdayiDAO extends BaseHibernateDAO
/*     */ {
/*  25 */   private static final Log log = LogFactory.getLog(StagetaskdayiDAO.class);
/*     */   public static final String QUESTION = "question";
/*     */   public static final String ANSWER = "answer";
/*     */   public static final String STUCODE = "stucode";
/*     */   public static final String TECCODE = "teccode";
/*     */   public static final String DEPARTID = "departid";
/*     */   public static final String GRADEID = "gradeid";
/*     */   public static final String ISOK = "isok";
/*     */ 
/*     */   public void save(Stagetaskdayi transientInstance)
/*     */   {
/*  36 */     log.debug("saving Stagetaskdayi instance");
/*     */     try {
/*  38 */       getSession().save(transientInstance);
/*  39 */       log.debug("save successful");
/*     */     } catch (RuntimeException re) {
/*  41 */       log.error("save failed", re);
/*  42 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void delete(Stagetaskdayi persistentInstance) {
/*  47 */     log.debug("deleting Stagetaskdayi instance");
/*     */     try {
/*  49 */       getSession().delete(persistentInstance);
/*  50 */       log.debug("delete successful");
/*     */     } catch (RuntimeException re) {
/*  52 */       log.error("delete failed", re);
/*  53 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public Stagetaskdayi findById(Integer id) {
/*  58 */     log.debug("getting Stagetaskdayi instance with id: " + id);
/*     */     try {
/*  60 */       Stagetaskdayi instance = (Stagetaskdayi)getSession().get(
/*  61 */         "com.entity.task.Stagetaskdayi", id);
/*  62 */       return instance;
/*     */     } catch (RuntimeException re) {
/*  64 */       log.error("get failed", re);
/*  65 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByExample(Stagetaskdayi instance) {
/*  70 */     log.debug("finding Stagetaskdayi instance by example");
/*     */     try {
/*  72 */       List results = getSession().createCriteria(
/*  73 */         "com.entity.task.Stagetaskdayi").add(
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
/*  85 */     log.debug("finding Stagetaskdayi instance with property: " + 
/*  86 */       propertyName + ", value: " + value);
/*     */     try {
/*  88 */       String queryString = "from Stagetaskdayi as model where model." + 
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
/*     */   public List findByQuestion(Object question) {
/* 100 */     return findByProperty("question", question);
/*     */   }
/*     */ 
/*     */   public List findByAnswer(Object answer) {
/* 104 */     return findByProperty("answer", answer);
/*     */   }
/*     */ 
/*     */   public List findByStucode(Object stucode) {
/* 108 */     return findByProperty("stucode", stucode);
/*     */   }
/*     */ 
/*     */   public List findByTeccode(Object teccode) {
/* 112 */     return findByProperty("teccode", teccode);
/*     */   }
/*     */ 
/*     */   public List findByDepartid(Object departid) {
/* 116 */     return findByProperty("departid", departid);
/*     */   }
/*     */ 
/*     */   public List findByGradeid(Object gradeid) {
/* 120 */     return findByProperty("gradeid", gradeid);
/*     */   }
/*     */ 
/*     */   public List findByIsok(Object isok) {
/* 124 */     return findByProperty("isok", isok);
/*     */   }
/*     */ 
/*     */   public List findAll() {
/* 128 */     log.debug("finding all Stagetaskdayi instances");
/*     */     try {
/* 130 */       String queryString = "from Stagetaskdayi";
/* 131 */       Query queryObject = getSession().createQuery(queryString);
/* 132 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/* 134 */       log.error("find all failed", re);
/* 135 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public Stagetaskdayi merge(Stagetaskdayi detachedInstance) {
/* 140 */     log.debug("merging Stagetaskdayi instance");
/*     */     try {
/* 142 */       Stagetaskdayi result = (Stagetaskdayi)getSession().merge(
/* 143 */         detachedInstance);
/* 144 */       log.debug("merge successful");
/* 145 */       return result;
/*     */     } catch (RuntimeException re) {
/* 147 */       log.error("merge failed", re);
/* 148 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachDirty(Stagetaskdayi instance) {
/* 153 */     log.debug("attaching dirty Stagetaskdayi instance");
/*     */     try {
/* 155 */       getSession().saveOrUpdate(instance);
/* 156 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 158 */       log.error("attach failed", re);
/* 159 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachClean(Stagetaskdayi instance) {
/* 164 */     log.debug("attaching clean Stagetaskdayi instance");
/*     */     try {
/* 166 */       getSession().lock(instance, LockMode.NONE);
/* 167 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 169 */       log.error("attach failed", re);
/* 170 */       throw re;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.task.StagetaskdayiDAO
 * JD-Core Version:    0.5.4
 */