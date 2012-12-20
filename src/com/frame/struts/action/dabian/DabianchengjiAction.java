/*     */ package com.frame.struts.action.dabian;
/*     */ 
/*     */ import com.entity.basedata.ClassList;
/*     */ import com.entity.basedata.ClassListDAO;
/*     */ import com.entity.basedata.CollegeList;
/*     */ import com.entity.basedata.CollegeListDAO;
/*     */ import com.entity.basedata.DepartList;
/*     */ import com.entity.basedata.DepartListDAO;
/*     */ import com.entity.basedata.GradeList;
/*     */ import com.entity.basedata.GradeListDAO;
/*     */ import com.entity.basedata.StuList;
/*     */ import com.entity.basedata.StuListDAO;
/*     */ import com.entity.dabian.Pingfen;
/*     */ import com.entity.dabian.PingfenDAO;
/*     */ import com.entity.pingyue.Biaozhun;
/*     */ import com.entity.pingyue.BiaozhunDAO;
/*     */ import com.entity.pingyue.PingyuStu;
/*     */ import com.entity.pingyue.PingyuStuDAO;
/*     */ import com.frame.struts.form.dabian.DabianchengjigradeForm;
/*     */ import java.util.Date;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.struts.action.Action;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionForward;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ import org.hibernate.Session;
/*     */ import org.hibernate.Transaction;
/*     */ import pub.Qdao;
/*     */ import pub.toChi;
/*     */ 
/*     */ public class DabianchengjiAction extends Action
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  62 */     DabianchengjigradeForm vform = (DabianchengjigradeForm)form;
/*  63 */     Biaozhun biaozhun = new Biaozhun();
/*  64 */     BiaozhunDAO bdao = new BiaozhunDAO();
/*  65 */     List blist = new LinkedList();
/*  66 */     Qdao qdao = new Qdao();
/*  67 */     String hql = "";
/*     */ 
/*  69 */     hql = "from Biaozhun where type='文献综述' and " + vform.getWenxian() + ">=minnum/10 and " + vform.getWenxian() + "<=maxnum/10";
/*  70 */     blist.addAll(qdao.query(hql));
/*     */ 
/*  73 */     hql = "from Biaozhun where type='外文翻译' and " + vform.getFanyi() + ">=minnum/10 and " + vform.getFanyi() + "<=maxnum/10";
/*  74 */     blist.addAll(1, qdao.query(hql));
/*     */ 
/*  77 */     hql = "from Biaozhun where type='动手能力' and " + vform.getDongshou() + ">=minnum/4 and " + vform.getDongshou() + "<=maxnum/4";
/*  78 */     blist.addAll(2, qdao.query(hql));
/*     */ 
/*  81 */     hql = "from Biaozhun where type='综合能力' and " + vform.getZonghe() + ">=minnum/4 and " + vform.getZonghe() + "<=maxnum/4";
/*  82 */     blist.addAll(3, qdao.query(hql));
/*     */ 
/*  85 */     hql = "from Biaozhun where type='文图表达' and " + vform.getWentu() + ">=minnum/20 and " + vform.getWentu() + "<=maxnum/20";
/*  86 */     blist.addAll(4, qdao.query(hql));
/*     */ 
/*  89 */     hql = "from Biaozhun where type='规范要求' and " + vform.getGuifan() + ">=minnum/20 and " + vform.getGuifan() + "<=maxnum/20";
/*  90 */     blist.addAll(5, qdao.query(hql));
/*     */ 
/*  93 */     hql = "from Biaozhun where type='答辩情况' and " + vform.getDabian() + ">=minnum/5 and " + vform.getDabian() + "<=maxnum/5";
/*  94 */     blist.addAll(6, qdao.query(hql));
/*     */ 
/*  98 */     PingyuStu pystu = new PingyuStu();
/*  99 */     PingyuStuDAO pystudao = new PingyuStuDAO();
/* 100 */     String pingyuzi = "";
/* 101 */     if (pystudao.getSession().get(PingyuStu.class, vform.getStucode()) != null) {
/* 102 */       pystu = pystudao.findById(vform.getStucode());
/* 103 */       pingyuzi = pingyuzi + "<br>" + pystu.getBeijin() + pystu.getContent() + pystu.getAttitude() + pystu.getResult();
/*     */     }
/*     */     else {
/* 106 */       request.setAttribute("notice", "该学生尚未自评!");
/*     */     }
/*     */ 
/* 112 */     request.setAttribute("pingyu", pingyuzi + ((Biaozhun)blist.get(0)).getContent() + ((Biaozhun)blist.get(1)).getContent() + ((Biaozhun)blist.get(2)).getContent() + 
/* 113 */       ((Biaozhun)blist.get(3)).getContent() + ((Biaozhun)blist.get(4)).getContent() + ((Biaozhun)blist.get(5)).getContent() + ((Biaozhun)blist.get(6)).getContent());
/*     */ 
/* 115 */     toChi tochi = new toChi();
/* 116 */     request.setAttribute("chengji", tochi.toChinese(vform.getChengji().toString()));
/*     */ 
/* 119 */     request.setAttribute("dbgid", vform.getDbgid());
/*     */ 
/* 123 */     StuList stu = new StuList();
/* 124 */     StuListDAO studao = new StuListDAO();
/* 125 */     stu = studao.findById(vform.getStucode());
/* 126 */     DepartList depart = new DepartList();
/* 127 */     DepartListDAO departdao = new DepartListDAO();
/* 128 */     depart = departdao.findById(stu.getDepartid());
/* 129 */     request.setAttribute("StuList", stu);
/* 130 */     request.setAttribute("departname", depart.getDepartname());
/* 131 */     CollegeList college = new CollegeList();
/* 132 */     CollegeListDAO collegedao = new CollegeListDAO();
/* 133 */     college = collegedao.findById(stu.getCollegeid());
/* 134 */     request.setAttribute("collegename", college.getCollegename());
/* 135 */     ClassList stuclass = new ClassList();
/* 136 */     ClassListDAO classdao = new ClassListDAO();
/* 137 */     stuclass = classdao.findById(stu.getClassid());
/* 138 */     request.setAttribute("classname", stuclass.getClassname());
/* 139 */     GradeList grade = new GradeList();
/* 140 */     GradeListDAO gdao = new GradeListDAO();
/* 141 */     grade = gdao.findById(stu.getGradeid());
/* 142 */     request.setAttribute("gradename", grade.getGradename());
/* 143 */     request.setAttribute("stucode", stu.getStucode());
/* 144 */     request.setAttribute("departid", depart.getDepartid());
/*     */ 
/* 148 */     PingfenDAO pfdao = new PingfenDAO();
/*     */ 
/* 150 */     qdao.del("delete Pingfen where stucode='" + stu.getStucode() + "'");
/*     */ 
/* 152 */     String stucode = stu.getStucode();
/* 153 */     Transaction ts1 = pfdao.getSession().beginTransaction();
/* 154 */     Date checktime = new Date();
/* 155 */     Pingfen pf = new Pingfen();
/* 156 */     pf.setChecktime(checktime);
/* 157 */     pf.setScore(vform.getWenxian());
/* 158 */     pf.setStucode(stucode);
/* 159 */     pf.setType("文献综述");
/* 160 */     pfdao.getSession().save(pf);
/* 161 */     Pingfen pf2 = new Pingfen();
/* 162 */     pf2.setChecktime(checktime);
/* 163 */     pf2.setStucode(stucode);
/* 164 */     pf2.setScore(vform.getFanyi());
/* 165 */     pf2.setType("外文翻译");
/* 166 */     pfdao.getSession().save(pf2);
/* 167 */     Pingfen pf3 = new Pingfen();
/* 168 */     pf3.setChecktime(checktime);
/* 169 */     pf3.setStucode(stucode);
/* 170 */     pf3.setScore(vform.getDongshou());
/* 171 */     pf3.setType("动手能力");
/* 172 */     pfdao.getSession().save(pf3);
/* 173 */     Pingfen pf4 = new Pingfen();
/* 174 */     pf4.setChecktime(checktime);
/* 175 */     pf4.setStucode(stucode);
/* 176 */     pf4.setScore(vform.getZonghe());
/* 177 */     pf4.setType("综合能力");
/* 178 */     pfdao.getSession().save(pf4);
/* 179 */     Pingfen pf5 = new Pingfen();
/* 180 */     pf5.setChecktime(checktime);
/* 181 */     pf5.setStucode(stucode);
/* 182 */     pf5.setScore(vform.getWentu());
/* 183 */     pf5.setType("文图表达");
/* 184 */     pfdao.getSession().save(pf5);
/* 185 */     Pingfen pf6 = new Pingfen();
/* 186 */     pf6.setChecktime(checktime);
/* 187 */     pf6.setStucode(stucode);
/* 188 */     pf6.setScore(vform.getGuifan());
/* 189 */     pf6.setType("规范要求");
/* 190 */     pfdao.getSession().save(pf6);
/* 191 */     Pingfen pf7 = new Pingfen();
/* 192 */     pf7.setChecktime(checktime);
/* 193 */     pf7.setStucode(stucode);
/* 194 */     pf7.setScore(vform.getDabian());
/* 195 */     pf7.setType("答辩情况");
/* 196 */     pfdao.getSession().save(pf7);
/*     */ 
/* 198 */     ts1.commit();
/*     */ 
/* 200 */     return mapping.findForward("display");
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     com.frame.struts.action.dabian.DabianchengjiAction
 * JD-Core Version:    0.5.4
 */