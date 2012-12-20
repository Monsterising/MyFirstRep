/*     */ package com.entity.basedata;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.hibernate.Criteria;
/*     */ import org.hibernate.LockMode;
/*     */ import org.hibernate.Query;
/*     */ import org.hibernate.Session;
/*     */ import org.hibernate.criterion.Example;
/*     */ 
/*     */ public class NewsDAO extends BaseHibernateDAO
/*     */ {
/*  24 */   private static final Log log = LogFactory.getLog(NewsDAO.class);
/*     */   public static final String TITLE = "title";
/*     */   public static final String CONTENT = "content";
/*     */   public static final String DEPARTID = "departid";
/*     */   public static final String CLICK = "click";
/*     */   public static final String ADDUSER = "adduser";
/*     */ 
/*     */   public Integer getTotalCount(Integer newstype, String keywords)
/*     */   {
/*  37 */     String hql = "select count(*) from News";
/*  38 */     if ((newstype.intValue() != 0) || (keywords.length() != 0)) {
/*  39 */       hql = hql + " where ";
/*  40 */       if (newstype.intValue() != 0)
/*  41 */         hql = hql + " departid=" + newstype;
/*  42 */       if ((newstype.intValue() != 0) && (keywords.length() != 0)) {
/*  43 */         hql = hql + "and";
/*     */       }
/*  45 */       if (keywords.length() != 0) {
/*  46 */         hql = hql + " newstitle like '%" + keywords + "%'";
/*     */       }
/*     */     }
/*  49 */     Query q = getSession().createQuery(hql);
/*  50 */     Long a = (Long)q.list().get(0);
/*     */ 
/*  52 */     return Integer.valueOf(a.intValue());
/*     */   }
/*     */ 
/*     */   public Integer getTotalPage(Integer pageSize, Integer newstype, String keywords) {
/*  56 */     Integer totalCount = getTotalCount(newstype, keywords);
/*  57 */     Integer totalPageCount = Integer.valueOf((totalCount.intValue() + pageSize.intValue() - 1) / pageSize.intValue());
/*  58 */     return totalPageCount;
/*     */   }
/*     */ 
/*     */   public Integer getTotalPages(Integer pageSize, Integer listSize)
/*     */   {
/*  63 */     Integer totalPageCount = Integer.valueOf((listSize.intValue() + pageSize.intValue() - 1) / pageSize.intValue());
/*  64 */     return totalPageCount;
/*     */   }
/*     */ 
/*     */   public List findPageAll(Integer currentPage, Integer pageSize, Integer newstype)
/*     */   {
/*  69 */     log.debug("分页查找");
/*     */     try {
/*  71 */       if (currentPage.intValue() == 0)
/*  72 */         currentPage = Integer.valueOf(1);
/*     */       String hql;
/*     */      
/*  75 */       if (newstype.intValue() == 0)
/*  76 */         hql = "from News order by newsid desc";
/*     */       else {
/*  78 */         hql = "from News where departid=" + newstype + "order by newsid desc";
/*     */       }
/*  80 */       Query q = getSession().createQuery(hql);
/*  81 */       q.setFirstResult((currentPage.intValue() - 1) * pageSize.intValue());
/*  82 */       q.setMaxResults(pageSize.intValue());
/*  83 */       return q.list();
/*     */     } catch (RuntimeException re) {
/*  85 */       log.error("分页查找失败", re);
/*  86 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void save(News transientInstance)
/*     */   {
/*  94 */     log.debug("saving News instance");
/*     */     try {
/*  96 */       getSession().save(transientInstance);
/*  97 */       log.debug("save successful");
/*     */     } catch (RuntimeException re) {
/*  99 */       log.error("save failed", re);
/* 100 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void delete(News persistentInstance) {
/* 105 */     log.debug("deleting News instance");
/*     */     try {
/* 107 */       getSession().delete(persistentInstance);
/* 108 */       log.debug("delete successful");
/*     */     } catch (RuntimeException re) {
/* 110 */       log.error("delete failed", re);
/* 111 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public News findById(Integer id) {
/* 116 */     log.debug("getting News instance with id: " + id);
/*     */     try {
/* 118 */       News instance = (News)getSession().get("com.entity.basedata.News", 
/* 119 */         id);
/* 120 */       return instance;
/*     */     } catch (RuntimeException re) {
/* 122 */       log.error("get failed", re);
/* 123 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByExample(News instance) {
/* 128 */     log.debug("finding News instance by example");
/*     */     try {
/* 130 */       List results = getSession().createCriteria(
/* 131 */         "com.entity.basedata.News").add(Example.create(instance))
/* 132 */         .list();
/* 133 */       log.debug("find by example successful, result size: " + 
/* 134 */         results.size());
/* 135 */       return results;
/*     */     } catch (RuntimeException re) {
/* 137 */       log.error("find by example failed", re);
/* 138 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByProperty(String propertyName, Object value) {
/* 143 */     log.debug("finding News instance with property: " + propertyName + 
/* 144 */       ", value: " + value);
/*     */     try {
/* 146 */       String queryString = "from News as model where model." + 
/* 147 */         propertyName + "= ?";
/* 148 */       Query queryObject = getSession().createQuery(queryString);
/* 149 */       queryObject.setParameter(0, value);
/* 150 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/* 152 */       log.error("find by property name failed", re);
/* 153 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public List findByTitle(Object title) {
/* 158 */     return findByProperty("title", title);
/*     */   }
/*     */ 
/*     */   public List findByContent(Object content) {
/* 162 */     return findByProperty("content", content);
/*     */   }
/*     */ 
/*     */   public List findByDepartid(Object departid) {
/* 166 */     return findByProperty("departid", departid);
/*     */   }
/*     */ 
/*     */   public List findByClick(Object click) {
/* 170 */     return findByProperty("click", click);
/*     */   }
/*     */ 
/*     */   public List findByAdduser(Object adduser) {
/* 174 */     return findByProperty("adduser", adduser);
/*     */   }
/*     */ 
/*     */   public List findAll() {
/* 178 */     log.debug("finding all News instances");
/*     */     try {
/* 180 */       String queryString = "from News";
/* 181 */       Query queryObject = getSession().createQuery(queryString);
/* 182 */       return queryObject.list();
/*     */     } catch (RuntimeException re) {
/* 184 */       log.error("find all failed", re);
/* 185 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public News merge(News detachedInstance) {
/* 190 */     log.debug("merging News instance");
/*     */     try {
/* 192 */       News result = (News)getSession().merge(detachedInstance);
/* 193 */       log.debug("merge successful");
/* 194 */       return result;
/*     */     } catch (RuntimeException re) {
/* 196 */       log.error("merge failed", re);
/* 197 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachDirty(News instance) {
/* 202 */     log.debug("attaching dirty News instance");
/*     */     try {
/* 204 */       getSession().saveOrUpdate(instance);
/* 205 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 207 */       log.error("attach failed", re);
/* 208 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attachClean(News instance) {
/* 213 */     log.debug("attaching clean News instance");
/*     */     try {
/* 215 */       getSession().lock(instance, LockMode.NONE);
/* 216 */       log.debug("attach successful");
/*     */     } catch (RuntimeException re) {
/* 218 */       log.error("attach failed", re);
/* 219 */       throw re;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.entity.basedata.NewsDAO
 * JD-Core Version:    0.5.4
 */