/*     */ package net.fiyu.edit;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.dom4j.Attribute;
/*     */ import org.dom4j.Document;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class EditWebhelper
/*     */ {
/*     */   String[] aButtonCode;
/*     */   String[] aButtonHTML;
/*     */   Document document;
/*     */   Document document2;
/*     */   EditWebhelper ew;
/*     */   public String filename;
/*     */   public String filename2;
/*     */   String sStyleDir;
/*     */   int size;
/*     */ 
/*     */   public EditWebhelper()
/*     */   {
/*  21 */     this.size = 255;
/*  22 */     this.filename = "D:/style2.xml";
/*  23 */     this.filename2 = "D:/button2.xml";
/*  24 */     this.document = null;
/*  25 */     this.document2 = null;
/*  26 */     this.ew = null;
/*  27 */     this.sStyleDir = "blue";
/*  28 */     this.aButtonCode = new String[this.size]; this.aButtonHTML = new String[this.size];
/*     */   }
/*     */ 
/*     */   public String Code2HTML(String s_Code)
/*     */   {
/* 163 */     String CodeToHTML = "";
/* 164 */     for (int i = 0; i < this.size; ++i) {
/* 165 */       if (this.aButtonCode[i].equals(s_Code)) {
/* 166 */         CodeToHTML = this.aButtonHTML[i];
/* 167 */         return CodeToHTML;
/*     */       }
/*     */     }
/* 170 */     return CodeToHTML;
/*     */   }
/*     */ 
/*     */   public void InitButtonArray()
/*     */   {
/*     */     try
/*     */     {
/* 108 */       List list = this.document2.selectNodes("Edit_Button/bcode");
/* 109 */       List list2 = this.document2.selectNodes("Edit_Button/bcode/@name");
/* 110 */       Iterator it = list.iterator();
/* 111 */       Iterator it2 = list2.iterator();
/* 112 */       int i = 0;
/* 113 */       int option = 0;
/* 114 */       while (it.hasNext()) {
/* 115 */         Attribute attribute = (Attribute)it2.next();
/* 116 */         Element button = (Element)it.next();
/* 117 */         this.aButtonCode[i] = attribute.getValue();
/* 118 */         option = Integer.parseInt(memoString(button, "btype").getTextTrim());
/*     */ 
/* 120 */         switch (option)
/*     */         {
/*     */         case 0:
/* 122 */           this.aButtonHTML[i] = ("<DIV CLASS=\"" + memoString(button, "bclass").getTextTrim() + "\" TITLE=\"" + memoString(button, "btitle").getTextTrim() + "\" onclick=\"" + memoString(button, "bevent").getTextTrim() + "\"><IMG CLASS=\"Ico\" SRC=\"buttonimage/" + this.sStyleDir + "/" + memoString(button, "bimage").getTextTrim() + "\"></DIV>");
/*     */ 
/* 133 */           break;
/*     */         case 1:
/* 135 */           this.aButtonHTML[i] = ("<SELECT CLASS=\"" + memoString(button, "bclass").getTextTrim() + "\" onchange=\"" + memoString(button, "bevent").getTextTrim() + "\">" + memoString(button, "bhtml").getTextTrim() + "</SELECT>");
/*     */ 
/* 142 */           break;
/*     */         case 2:
/* 144 */           this.aButtonHTML[i] = ("<DIV CLASS=\"" + memoString(button, "bclass").getTextTrim() + "\">" + notNull(memoString(button, "bhtml").getTextTrim()) + "</DIV>");
/*     */         }
/*     */ 
/* 152 */         ++i;
/*     */       }
/*     */ 
/* 155 */       this.size = i;
/*     */     }
/*     */     catch (Exception e) {
/* 158 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public EditBean InitPara()
/*     */   {
/*  44 */     EditBean bean = new EditBean();
/*  45 */     String sToolBar = "";
/*     */     try {
/*  47 */       List list = this.document.selectNodes("Edit_Style/style");
/*  48 */       bean.setSAutoRemote(getNodeValue(list, "sautoremote"));
/*  49 */       bean.setSStyleName("standard");
/*  50 */       bean.setSBaseUrl(getNodeValue(list, "sbaseurl"));
/*  51 */       bean.setSDetectFromWord(getNodeValue(list, "sdetectfromword"));
/*  52 */       bean.setSInitMode(getNodeValue(list, "sinitmod"));
/*  53 */       bean.setSStyleID(getNodeValue(list, "sid"));
/*  54 */       bean.setSStyleDir(getNodeValue(list, "sdir"));
/*  55 */       bean.setNStateFlag(getNodeValue(list, "sstateflag"));
/*  56 */       this.sStyleDir = getNodeValue(list, "sdir");
/*     */ 
/*  59 */       InitButtonArray();
/*     */ 
/*  62 */       String[] aButton = getNodeValue(list, "stoolbar1").split("\\|");
/*  63 */       sToolBar = "<table border=0 cellpadding=0 cellspacing=0 width='100%' class='Toolbar' id='eWebEditor_Toolbar'>";
/*  64 */       sToolBar = sToolBar + "<tr><td><div class='yToolbar'>";
/*  65 */       for (int i = 0; i < aButton.length; ++i)
/*     */       {
/*  67 */         if (aButton[i].equalsIgnoreCase("MAXIMIZE"))
/*  68 */           aButton[i] = "Minimize";
/*  69 */         sToolBar = sToolBar + Code2HTML(aButton[i]);
/*     */       }
/*  71 */       sToolBar = sToolBar + "</div></td></tr>";
/*  72 */       String[] aButton2 = getNodeValue(list, "stoolbar2").split("\\|");
/*  73 */       sToolBar = sToolBar + "<tr><td><div class='yToolbar'>";
/*  74 */       for (int j = 0; j < aButton2.length; ++j) {
/*  75 */         if (aButton2[j].equalsIgnoreCase("MAXIMIZE"))
/*  76 */           aButton2[j] = "Minimize";
/*  77 */         sToolBar = sToolBar + Code2HTML(aButton2[j]);
/*     */       }
/*  79 */       sToolBar = sToolBar + "</div></td></tr></table>";
/*  80 */       bean.setSToolBar(sToolBar);
/*  81 */       bean.setSStyleName(getNodeValue(list, "sdir"));
/*  82 */       bean.setSStyleUploadDir(getNodeValue(list, "suploaddir"));
/*  83 */       bean.setSVersion("飞鱼修改版");
/*  84 */       bean.setSReleaseDate("2004-11-30");
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  89 */       System.out.println(e.getMessage());
/*     */     }
/*  91 */     this.document = null;
/*  92 */     return bean;
/*     */   }
/*     */ 
/*     */   public EditWebhelper getInstance()
/*     */   {
/*  31 */     EditWebhelper ew = new EditWebhelper();
/*     */     try {
/*  33 */       SAXReader saxReader = new SAXReader();
/*  34 */       this.document = saxReader.read(new File(this.filename));
/*  35 */       this.document2 = saxReader.read(new File(this.filename2));
/*     */     }
/*     */     catch (Exception e) {
/*  38 */       System.out.println(e.getMessage());
/*     */     }
/*  40 */     return ew;
/*     */   }
/*     */ 
/*     */   public String getNodeValue(List list, String Node)
/*     */   {
/* 182 */     Iterator it = list.iterator();
/* 183 */     if (it.hasNext()) {
/* 184 */       Element styleElement = (Element)it.next();
/*     */ 
/* 186 */       Iterator memo = styleElement.elementIterator(Node);
/* 187 */       if (memo.hasNext()) {
/* 188 */         Element memostring = (Element)memo.next();
/* 189 */         return memostring.getTextTrim();
/*     */       }
/*     */ 
/* 192 */       return "";
/*     */     }
/*     */ 
/* 196 */     return "";
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 201 */     EditWebhelper editWebhelper1 = new EditWebhelper();
/* 202 */     editWebhelper1.filename = "D:/style2.xml";
/* 203 */     editWebhelper1.getInstance();
/* 204 */     EditBean bean = editWebhelper1.InitPara();
/* 205 */     System.out.println(bean.getSToolBar());
/*     */   }
/*     */ 
/*     */   public Element memoString(Element button, String Node)
/*     */   {
/*  96 */     Iterator memo = button.elementIterator(Node);
/*  97 */     if (memo.hasNext()) {
/*  98 */       Element memostring = (Element)memo.next();
/*  99 */       return memostring;
/*     */     }
/*     */ 
/* 102 */     return null;
/*     */   }
/*     */ 
/*     */   public String notNull(String str)
/*     */   {
/* 174 */     String s = str;
/* 175 */     if (str == null) {
/* 176 */       return "";
/*     */     }
/* 178 */     return s;
/*     */   }
/*     */ }

/* Location:           E:\TDDOWNLOAD\Java\bysj\WEB-INF\classes\
 * Qualified Name:     net.fiyu.edit.EditWebhelper
 * JD-Core Version:    0.5.4
 */