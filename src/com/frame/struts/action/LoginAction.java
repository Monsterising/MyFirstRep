/*     */ package com.frame.struts.action;
/*     */ 
/*     */ import com.entity.basedata.CollegeUser;
/*     */ import com.entity.basedata.CollegeUserDAO;
/*     */ import com.entity.basedata.DepartList;
/*     */ import com.entity.basedata.DepartTec;
/*     */ import com.entity.basedata.DepartTecDAO;
/*     */ import com.entity.basedata.StuList;
/*     */ import com.entity.basedata.StuListDAO;
/*     */ import com.entity.basedata.TecList;
/*     */ import com.entity.basedata.TecListDAO;
/*     */ import com.entity.basedata.Users;
/*     */ import com.entity.basedata.UsersDAO;
/*     */ import com.frame.struts.baseform.LoginForm;
/*     */ import java.io.PrintStream;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.apache.struts.action.Action;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionForward;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ import org.hibernate.Session;
/*     */ import pub.Qdao;
/*     */ 
/*     */ public class LoginAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  61 */     LoginForm loginForm = (LoginForm)form;
/*  62 */     if (loginForm.getUserrole() == null) {
/*  63 */       return mapping.findForward("fail");
/*     */     }
/*     */ 
/*  66 */     String userrole = loginForm.getUserrole();
/*  67 */     String username = loginForm.getUsername().trim();
/*  68 */     String userpass = loginForm.getUserpass().trim();
/*  69 */     String notice = "";
/*  70 */     if ((username.equals("")) || (userpass.equals(""))) {
/*  71 */       notice = "用户名或者密码为空！";
/*  72 */       request.setAttribute("notice", notice);
/*  73 */       return mapping.findForward("fail");
/*     */     }
/*  75 */     if (userrole.equals("stu")) {
/*  76 */       StuListDAO stulistdao = new StuListDAO();
/*  77 */       if (stulistdao.getSession().get(StuList.class, username) == null) {
/*  78 */         notice = "用户名不存在！";
/*  79 */         request.setAttribute("notice", notice);
/*  80 */         return mapping.findForward("fail");
/*     */       }
/*  82 */       StuList stulist = (StuList)stulistdao.getSession().get(StuList.class, username);
/*  83 */       if (userpass.equals(stulist.getStupass())) {
/*  84 */         HttpSession session = request.getSession();
/*  85 */         session.setAttribute("stucode", stulist.getStucode());
/*  86 */         session.setAttribute("classid", stulist.getClassid());
/*  87 */         session.setAttribute("departid", stulist.getDepartid());
/*  88 */         session.setAttribute("gradeid", stulist.getGradeid());
/*  89 */         session.setAttribute("collegeid", stulist.getCollegeid());
/*  90 */         session.setAttribute("username", stulist.getStuname());
/*  91 */         request.setAttribute("StuList", stulist);
/*  92 */         session.setAttribute("StuList", stulist);
/*  93 */         System.out.println(stulist.getStuname() + " 学生登陆！");
/*     */ 
/*  96 */         List newslist = new LinkedList();
/*  97 */         String hql = "from News where departid = " + stulist.getDepartid();
/*  98 */         Qdao qdao = new Qdao();
/*  99 */         newslist.addAll(qdao.query(hql));
/* 100 */         request.setAttribute("newslist", newslist);
/* 101 */         return mapping.findForward("stu");
/*     */       }
/* 103 */       notice = "用户名密码不正确！";
/* 104 */       request.setAttribute("notice", notice);
/* 105 */       return mapping.findForward("fail");
/*     */     }
/*     */ 
/* 110 */     if (userrole.equals("tec")) {
/* 111 */       TecListDAO teclistdao = new TecListDAO();
/* 112 */       if (teclistdao.getSession().get(TecList.class, username) == null) {
/* 113 */         notice = "用户名不存在！";
/* 114 */         request.setAttribute("notice", notice);
/* 115 */         return mapping.findForward("fail");
/*     */       }
/* 117 */       TecList teclist = (TecList)teclistdao.getSession().get(TecList.class, username);
/* 118 */       if (!userpass.equals(teclist.getTecpass())) {
/* 119 */         notice = "用户名密码不正确！";
/* 120 */         request.setAttribute("notice", notice);
/* 121 */         return mapping.findForward("fail");
/*     */       }
/* 123 */       if (userpass.equals(teclist.getTecpass())) {
/* 124 */         HttpSession session = request.getSession();
/* 125 */         session.setAttribute("teccode", teclist.getTeccode());
/* 126 */         session.setAttribute("tecname", teclist.getTecname());
/* 127 */         session.setAttribute("collegeid", teclist.getCollegeid());
/* 128 */         session.setAttribute("username", teclist.getTecname() + " 老师");
/* 129 */         session.setAttribute("userrealname", teclist.getTecname());
/* 130 */         DepartTec departtec = new DepartTec();
/* 131 */         DepartTecDAO dao = new DepartTecDAO();
/* 132 */         List departteclist = dao.findByTeccode(username);
/* 133 */         if (departteclist.size() == 0) {
/* 134 */           notice = "您暂时没有分配专业！";
/* 135 */           request.setAttribute("notice", notice);
/* 136 */           return mapping.findForward("error");
/*     */         }
/* 138 */         System.out.println(teclist.getTecname().toString() + " 教师登陆！");
/*     */ 
/* 140 */         String departids = "";
/* 141 */         List newslist = new LinkedList();
/* 142 */         for (int i = 0; i < departteclist.size(); ++i) {
/* 143 */           departids = departids + ((DepartTec)departteclist.get(i)).getDepartid() + ",";
/*     */         }
/* 145 */         if (!departids.equals(""))
/*     */         {
/* 147 */           departids = departids.substring(0, departids.length() - 1);
/* 148 */           String hql = "from News where departid in (" + departids + ")";
/* 149 */           Qdao qdao = new Qdao();
/*     */ 
/* 151 */           newslist.addAll(qdao.query(hql));
/* 152 */           request.setAttribute("newslist", newslist);
/*     */         }
/* 154 */         String usershenfen = "";
/* 155 */         for (int i = 0; i < departteclist.size(); ++i) {
/* 156 */           if (((DepartTec)departteclist.get(i)).getTecrole().intValue() != 2) {
/*     */             continue;
/*     */           }
/*     */ 
/* 160 */           usershenfen = "depart";
/*     */         }
/*     */ 
/* 164 */         session.setAttribute("usershenfen", usershenfen);
/* 165 */         return mapping.findForward("depart");
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 184 */     if (userrole.equals("user"))
/*     */     {
/* 186 */       UsersDAO dao = new UsersDAO();
/* 187 */       List list = dao.findByUsername(username);
/* 188 */       if (list.size() == 0) {
/* 189 */         notice = "用户名不存在！";
/* 190 */         request.setAttribute("notice", notice);
/* 191 */         return mapping.findForward("fail");
/*     */       }
/* 193 */       Users user = new Users();
/* 194 */       user = (Users)list.get(0);
/* 195 */       if (!userpass.equals(user.getUserpass())) {
/* 196 */         notice = "用户名密码不正确！";
/* 197 */         request.setAttribute("notice", notice);
/* 198 */         return mapping.findForward("fail");
/*     */       }
/*     */ 
/* 201 */       if (userpass.equals(user.getUserpass())) {
/* 202 */         HttpSession session = request.getSession();
/* 203 */         session.setAttribute("adminid", user.getUserid());
/* 204 */         session.setAttribute("username", user.getUsername());
/* 205 */         session.setAttribute("userrealname", user.getUserrealname());
/* 206 */         session.setAttribute("username", user.getUserrealname() + " 管理员");
/*     */ 
/* 208 */         if (user.getUserrole().equals(Integer.valueOf(5)))
/*     */         {
/* 210 */           System.out.println(user.getUserrealname() + " 教务登录");
/* 211 */           session.setAttribute("userrole", user.getUserrole());
/* 212 */           session.setAttribute("usershenfen", "教务处管理员");
/* 213 */           return mapping.findForward("jiaowu");
/*     */         }
/*     */ 
/* 216 */         CollegeUser collegeuser = new CollegeUser();
/* 217 */         CollegeUserDAO cdao = new CollegeUserDAO();
/* 218 */         List clist = cdao.findByUserid(user.getUserid());
/* 219 */         if (clist.size() == 0) {
/* 220 */           notice = "您暂时没有分配学院！";
/* 221 */           request.setAttribute("notice", notice);
/* 222 */           return mapping.findForward("error");
/*     */         }
/*     */ 
/* 225 */         Integer collegeid = ((CollegeUser)clist.get(0)).getCollegeid();
/*     */ 
/* 227 */         String departids = "";
/* 228 */         List newslist = new LinkedList();
/* 229 */         List departlist = new LinkedList();
/* 230 */         Qdao qdao = new Qdao();
/* 231 */         departlist.addAll(qdao.query("from DepartList where collegeid=" + collegeid));
/* 232 */         for (int i = 0; i < departlist.size(); ++i) {
/* 233 */           departids = departids + ((DepartList)departlist.get(i)).getDepartid() + ",";
/*     */         }
/*     */ 
/* 236 */         if (!departids.equals(""))
/*     */         {
/* 238 */           departids = departids.substring(0, departids.length() - 1);
/* 239 */           String hql = "from News where departid in (" + departids + ")";
/* 240 */           newslist.addAll(qdao.query(hql));
/* 241 */           request.setAttribute("newslist", newslist);
/*     */         }
/* 243 */         request.setAttribute("title", "标题测试");
/*     */ 
/* 245 */         for (int i = 0; i < clist.size(); ++i) {
/* 246 */           if (((CollegeUser)clist.get(i)).getCurole().intValue() == 4)
/*     */           {
/* 248 */             session.setAttribute("collegeid", ((CollegeUser)clist.get(i)).getCollegeid());
/* 249 */             session.setAttribute("userrole", Integer.valueOf(4));
/* 250 */             session.setAttribute("usershenfen", "college");
/* 251 */             System.out.println(((CollegeUser)clist.get(i)).getUserid() + " 院长登陆");
/* 252 */             return mapping.findForward("college");
/*     */           }
/* 254 */           if (((CollegeUser)clist.get(i)).getCurole().intValue() == 3) {
/* 255 */             session.setAttribute("collegeid", ((CollegeUser)clist.get(i)).getCollegeid());
/* 256 */             session.setAttribute("userrole", Integer.valueOf(3));
/* 257 */             session.setAttribute("usershenfen", "mishu");
/* 258 */             System.out.println(((CollegeUser)clist.get(i)).getUserid() + " 教学秘书登陆");
/* 259 */             return mapping.findForward("mishu");
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 268 */     System.out.print("kong");
/*     */ 
/* 270 */     return mapping.findForward("fail");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.LoginAction
 * JD-Core Version:    0.5.4
 */