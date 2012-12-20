/*     */ package net.fiyu.edit;
/*     */ 
/*     */ import java.util.Calendar;
/*     */ import java.util.GregorianCalendar;
/*     */ 
/*     */ public class TimeStamp
/*     */ {
/*     */   private String am_pm;
/*     */   private Calendar c;
/*     */   private String date;
/*     */   private String day;
/*     */   private String hour;
/*     */   private String minute;
/*     */   private String month;
/*     */   private String nanos;
/*     */   private String second;
/*     */   private String year;
/*     */ 
/*     */   public TimeStamp()
/*     */   {
/*  31 */     this.c = new GregorianCalendar();
/*  32 */     this.year = Integer.toString(this.c.get(1));
/*  33 */     int i = this.c.get(2);
/*  34 */     ++i;
/*  35 */     this.month = Integer.toString(i);
/*  36 */     this.day = Integer.toString(this.c.get(5));
/*  37 */     int j = this.c.get(10);
/*  38 */     this.minute = Integer.toString(this.c.get(12));
/*  39 */     this.second = Integer.toString(this.c.get(13));
/*  40 */     this.nanos = Integer.toString(this.c.get(14));
/*  41 */     i = this.c.get(9);
/*  42 */     if (i == 1)
/*  43 */       this.hour += 12;
/*  44 */     this.hour = Integer.toString(j);
/*  45 */     this.am_pm = Integer.toString(i);
/*     */   }
/*     */ 
/*     */   public String Time_Article()
/*     */   {
/*  68 */     this.date = (add(this.year) + add(this.month) + add(this.day) + add(this.hour) + add(this.minute) + add(this.second) + add(this.nanos));
/*  69 */     return this.date;
/*     */   }
/*     */ 
/*     */   public String Time_Date()
/*     */   {
/*  56 */     this.date = (add(this.year) + "-" + add(this.month) + "-" + add(this.day) + " " + add(this.hour) + ":" + add(this.minute) + ":" + add(this.second));
/*  57 */     return this.date;
/*     */   }
/*     */ 
/*     */   public String Time_Stamp()
/*     */   {
/*  50 */     this.date = (add(this.year) + add(this.month) + add(this.day) + add(this.hour) + add(this.minute) + add(this.second) + add(this.nanos));
/*  51 */     return this.date;
/*     */   }
/*     */ 
/*     */   public String Time_YMD()
/*     */   {
/*  62 */     this.date = (add(this.year) + add(this.month) + add(this.day) + add(this.hour) + add(this.minute) + add(this.second));
/*  63 */     return this.date;
/*     */   }
/*     */ 
/*     */   public String add(String s)
/*     */   {
/* 114 */     int i = s.length();
/* 115 */     if (i == 1)
/* 116 */       s = "0" + s;
/* 117 */     return s;
/*     */   }
/*     */ 
/*     */   public String getAm_pm()
/*     */   {
/*  74 */     return add(this.am_pm);
/*     */   }
/*     */ 
/*     */   public String getDay()
/*     */   {
/*  79 */     return add(this.day);
/*     */   }
/*     */ 
/*     */   public String getHour()
/*     */   {
/*  84 */     return add(this.hour);
/*     */   }
/*     */ 
/*     */   public String getMinute()
/*     */   {
/*  89 */     return add(this.minute);
/*     */   }
/*     */ 
/*     */   public String getMonth()
/*     */   {
/*  94 */     return add(this.month);
/*     */   }
/*     */ 
/*     */   public String getNanos()
/*     */   {
/* 109 */     return add(this.nanos);
/*     */   }
/*     */ 
/*     */   public String getSecond()
/*     */   {
/*  99 */     return add(this.second);
/*     */   }
/*     */ 
/*     */   public String getYear()
/*     */   {
/* 104 */     return add(this.year);
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     net.fiyu.edit.TimeStamp
 * JD-Core Version:    0.5.4
 */