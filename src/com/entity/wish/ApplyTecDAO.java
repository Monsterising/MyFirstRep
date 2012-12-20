/*     */ package com.entity.wish;
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
/*     */ public class ApplyTecDAO extends BaseHibernateDAO
/*     */ {
/*  25 */   private static final Log log = LogFactory.getLog(ApplyTecDAO.class);
/*     */   public static final String TITLE = "title";
/*     */   public static final String TECCODE = "teccode";
/*     */   public static final String COLLEGEID = "collegeid";
/*     */   public static final String DEPARTID = "departid";
/*     */   public static final String GRADEID = "gradeid";
/*     */   public static final String CLASSID = "classid";
/*     */   public static final String TECPROF = "tecprof";
/*     */   public static final String STUSUM = "stusum";
/*     */   public static final String CONTENT = "content";
/*     */   public static final String PREPAREWORK = "preparework";
/*     */   public static final String APPLYTYPE = "applytype";
/*     */   public static final String APPLYTYPENAME = "applytypename";
/*     */   public static final String SOURCE = "source";
/*     */   public static final String KIND = "kind";
/*     */   public static final String PRACTISE = "practise";
/*     */   public static final String COMPUTER = "computer";
/*     */   public static final String ADVICE1 = "advice1";
/*     */   public static final String SIGN1 = "sign1";
/*     */   public static final String ADVICE2 = "advice2";
/*     */   public static final String SIGN2 = "sign2";
/*     */ 
/*     */   public void save(ApplyTec transientInstance)
/*     */   {
/*  49 */     log.debug("saving ApplyTec instance");
/*     */     try {
/*  51 */       getSession().save(transientInstance);
/*  52 */       log.debug("save successful");
/*     */     } catch (RuntimeException re) {
/*  54 */       log.error("save failed", re);
/*  55 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void delete(ApplyTec persistentInstance) {
/*  60 */     log.debug("deleting ApplyTec instance");
/*     */     try {
/*  62 */       getSession().delete(persistentInstance);
/*  63 */       log.debug("delete successful");
/*     */     } catch (RuntimeException re) {
/*  65 */       log.error("delete failed", re);
/*  66 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public ApplyTec findById(Integer id) {
/*  71 */     log.debug("getting ApplyTec instance with id: " + id);
/*     */     try {
/*  73 */       ApplyTec instance = (ApplyTec)getSession().get(
/*  74 */         "com.entity.wish.ApplyTec", id);
/*  75 */       return instance;
/*     */     } catch (RuntimeException re) {
/*  77 */       log.error("get failed", re);
/*  78 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByExample(ApplyTec instance) {
/*  83 */     log.debug("finding ApplyTec instance by example");
/*     */     try {
/*  85 */       List results = getSession().createCriteria(
/*  86 */         "com.entity.wish.ApplyTec").add(Example.create(instance))
/*  87 */         .list();
/*  88 */       log.debug("find by example successful, result size: " + 
/*  89 */         results.size());
/*  90 */       return results;
/*     */     } catch (RuntimeException re) {
/*  92 */       log.error("find by example failed", re);
/*  93 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByProperty(String propertyName, Object value) {
/*  98 */     log.debug("finding ApplyTec instance with property: " + propertyName + 
/*  99 */       ", value: " + value);
/*     */     try {
/* 101 */       String queryString = "from ApplyTec as model where model." + 
/* 102 */         propertyName + "= ?";
/* 103 */       Query queryObject = getSession().createQuery(queryString);
/* 104 */       queryObject.setParameter(0, value);
/* 105 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/* 107 */       log.error("find by property name failed", re);
/* 108 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByTitle(Object title) {
/* 113 */     return findByProperty("title", title);
/*     */   }
/*     */ 
/*     */   public List findByTeccode(Object teccode) {
/* 117 */     return findByProperty("teccode", teccode);
/*     */   }
/*     */ 
/*     */   public List findByCollegeid(Object collegeid) {
/* 121 */     return findByProperty("collegeid", collegeid);
/*     */   }
/*     */ 
/*     */   public List findByDepartid(Object departid) {
/* 125 */     return findByProperty("departid", departid);
/*     */   }
/*     */ 
/*     */   public List findByGradeid(Object gradeid) {
/* 129 */     return findByProperty("gradeid", gradeid);
/*     */   }
/*     */ 
/*     */   public List findByClassid(Object classid) {
/* 133 */     return findByProperty("classid", classid);
/*     */   }
/*     */ 
/*     */   public List findByTecprof(Object tecprof) {
/* 137 */     return findByProperty("tecprof", tecprof);
/*     */   }
/*     */ 
/*     */   public List findByStusum(Object stusum) {
/* 141 */     return findByProperty("stusum", stusum);
/*     */   }
/*     */ 
/*     */   public List findByContent(Object content) {
/* 145 */     return findByProperty("content", content);
/*     */   }
/*     */ 
/*     */   public List findByPreparework(Object preparework) {
/* 149 */     return findByProperty("preparework", preparework);
/*     */   }
/*     */ 
/*     */   public List findByApplytype(Object applytype) {
/* 153 */     return findByProperty("applytype", applytype);
/*     */   }
/*     */ 
/*     */   public List findByApplytypename(Object applytypename) {
/* 157 */     return findByProperty("applytypename", applytypename);
/*     */   }
/*     */ 
/*     */   public List findBySource(Object source) {
/* 161 */     return findByProperty("source", source);
/*     */   }
/*     */ 
/*     */   public List findByKind(Object kind) {
/* 165 */     return findByProperty("kind", kind);
/*     */   }
/*     */ 
/*     */   public List findByPractise(Object practise) {
/* 169 */     return findByProperty("practise", practise);
/*     */   }
/*     */ 
/*     */   public List findByComputer(Object computer) {
/* 173 */     return findByProperty("computer", computer);
/*     */   }
/*     */ 
/*     */   public List findByAdvice1(Object advice1) {
/* 177 */     return findByProperty("advice1", advice1);
/*     */   }
/*     */ 
/*     */   public List findBySign1(Object sign1) {
/* 181 */     return findByProperty("sign1", sign1);
/*     */   }
/*     */ 
/*     */   public List findByAdvice2(Object advice2) {
/* 185 */     return findByProperty("advice2", advice2);
/*     */   }
/*     */ 
/*     */   public List findBySign2(Object sign2) {
/* 189 */     return findByProperty("sign2", sign2);
/*     */   }
/*     */ 
/*     */   public List findAll() {
/* 193 */     log.debug("finding all ApplyTec instances");
/*     */     try {
/* 195 */       String queryString = "from ApplyTec";
/* 196 */       Query queryObject = getSession().createQuery(queryString);
/* 197 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/* 199 */       log.error("find all failed", re);
/* 200 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public ApplyTec merge(ApplyTec detachedInstance) {
/* 205 */     log.debug("merging ApplyTec instance");
/*     */     try {
/* 207 */       ApplyTec result = (ApplyTec)getSession().merge(detachedInstance);
/* 208 */       log.debug("merge successful");
/* 209 */       return result;
/*     */     } catch (RuntimeException re) {
/* 211 */       log.error("merge failed", re);
/* 212 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachDirty(ApplyTec instance) {
/* 217 */     log.debug("attaching dirty ApplyTec instance");
/*     */     try {
/* 219 */       getSession().saveOrUpdate(instance);
/* 220 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 222 */       log.error("attach failed", re);
/* 223 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachClean(ApplyTec instance) {
/* 228 */     log.debug("attaching clean ApplyTec instance");
/*     */     try {
/* 230 */       getSession().lock(instance, LockMode.NONE);
/* 231 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 233 */       log.error("attach failed", re);
/* 234 */       throw re;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.wish.ApplyTecDAO
 * JD-Core Version:    0.5.4
 */