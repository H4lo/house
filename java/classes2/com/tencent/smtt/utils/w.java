package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

public class w
{
  private static w c = null;
  private Context a = null;
  private File b = null;
  private String d = "http://log.tbs.qq.com/ajax?c=pu&v=2&k=";
  private String e = "http://log.tbs.qq.com/ajax?c=pu&tk=";
  private String f = "http://wup.imtt.qq.com:8080";
  private String g = "http://log.tbs.qq.com/ajax?c=dl&k=";
  private String h = "http://cfg.imtt.qq.com/tbs?v=2&mk=";
  private String i = "http://log.tbs.qq.com/ajax?c=ul&v=2&k=";
  private String j = "http://mqqad.html5.qq.com/adjs";
  private String k = "http://log.tbs.qq.com/ajax?c=ucfu&k=";
  
  @TargetApi(11)
  private w(Context paramContext)
  {
    TbsLog.w("TbsCommonConfig", "TbsCommonConfig constructing...");
    this.a = paramContext.getApplicationContext();
    g();
  }
  
  public static w a()
  {
    try
    {
      w localw = c;
      return localw;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static w a(Context paramContext)
  {
    try
    {
      if (c == null) {
        c = new w(paramContext);
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: invokespecial 97	com/tencent/smtt/utils/w:h	()Ljava/io/File;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnonnull +25 -> 35
    //   13: ldc 69
    //   15: ldc 99
    //   17: invokestatic 101	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: iconst_0
    //   21: ifeq +11 -> 32
    //   24: new 103	java/lang/NullPointerException
    //   27: dup
    //   28: invokespecial 104	java/lang/NullPointerException:<init>	()V
    //   31: athrow
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: new 106	java/io/BufferedInputStream
    //   38: dup
    //   39: new 108	java/io/FileInputStream
    //   42: dup
    //   43: aload_2
    //   44: invokespecial 111	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   47: invokespecial 114	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   50: astore_2
    //   51: new 116	java/util/Properties
    //   54: dup
    //   55: invokespecial 117	java/util/Properties:<init>	()V
    //   58: astore_1
    //   59: aload_1
    //   60: aload_2
    //   61: invokevirtual 120	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   64: aload_1
    //   65: ldc 122
    //   67: ldc 124
    //   69: invokevirtual 128	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   72: astore_3
    //   73: ldc 124
    //   75: aload_3
    //   76: invokevirtual 134	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   79: ifne +8 -> 87
    //   82: aload_0
    //   83: aload_3
    //   84: putfield 39	com/tencent/smtt/utils/w:d	Ljava/lang/String;
    //   87: aload_1
    //   88: ldc -120
    //   90: ldc 124
    //   92: invokevirtual 128	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   95: astore_3
    //   96: ldc 124
    //   98: aload_3
    //   99: invokevirtual 134	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   102: ifne +8 -> 110
    //   105: aload_0
    //   106: aload_3
    //   107: putfield 47	com/tencent/smtt/utils/w:f	Ljava/lang/String;
    //   110: aload_1
    //   111: ldc -118
    //   113: ldc 124
    //   115: invokevirtual 128	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   118: astore_3
    //   119: ldc 124
    //   121: aload_3
    //   122: invokevirtual 134	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   125: ifne +8 -> 133
    //   128: aload_0
    //   129: aload_3
    //   130: putfield 51	com/tencent/smtt/utils/w:g	Ljava/lang/String;
    //   133: aload_1
    //   134: ldc -116
    //   136: ldc 124
    //   138: invokevirtual 128	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   141: astore_3
    //   142: ldc 124
    //   144: aload_3
    //   145: invokevirtual 134	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   148: ifne +8 -> 156
    //   151: aload_0
    //   152: aload_3
    //   153: putfield 55	com/tencent/smtt/utils/w:h	Ljava/lang/String;
    //   156: aload_1
    //   157: ldc -114
    //   159: ldc 124
    //   161: invokevirtual 128	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   164: astore_3
    //   165: ldc 124
    //   167: aload_3
    //   168: invokevirtual 134	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   171: ifne +8 -> 179
    //   174: aload_0
    //   175: aload_3
    //   176: putfield 59	com/tencent/smtt/utils/w:i	Ljava/lang/String;
    //   179: aload_1
    //   180: ldc -112
    //   182: ldc 124
    //   184: invokevirtual 128	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   187: astore_3
    //   188: ldc 124
    //   190: aload_3
    //   191: invokevirtual 134	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   194: ifne +8 -> 202
    //   197: aload_0
    //   198: aload_3
    //   199: putfield 63	com/tencent/smtt/utils/w:j	Ljava/lang/String;
    //   202: aload_1
    //   203: ldc -110
    //   205: ldc 124
    //   207: invokevirtual 128	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   210: astore_3
    //   211: ldc 124
    //   213: aload_3
    //   214: invokevirtual 134	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   217: ifne +8 -> 225
    //   220: aload_0
    //   221: aload_3
    //   222: putfield 67	com/tencent/smtt/utils/w:k	Ljava/lang/String;
    //   225: aload_1
    //   226: ldc -108
    //   228: ldc 124
    //   230: invokevirtual 128	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   233: astore_1
    //   234: ldc 124
    //   236: aload_1
    //   237: invokevirtual 134	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   240: ifne +8 -> 248
    //   243: aload_0
    //   244: aload_1
    //   245: putfield 43	com/tencent/smtt/utils/w:e	Ljava/lang/String;
    //   248: aload_2
    //   249: ifnull -217 -> 32
    //   252: aload_2
    //   253: invokevirtual 151	java/io/BufferedInputStream:close	()V
    //   256: goto -224 -> 32
    //   259: astore_1
    //   260: aload_1
    //   261: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   264: goto -232 -> 32
    //   267: astore_1
    //   268: aload_0
    //   269: monitorexit
    //   270: aload_1
    //   271: athrow
    //   272: astore_2
    //   273: new 156	java/io/StringWriter
    //   276: dup
    //   277: invokespecial 157	java/io/StringWriter:<init>	()V
    //   280: astore_3
    //   281: aload_2
    //   282: new 159	java/io/PrintWriter
    //   285: dup
    //   286: aload_3
    //   287: invokespecial 162	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   290: invokevirtual 165	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   293: ldc 69
    //   295: new 167	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   302: ldc -86
    //   304: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: aload_3
    //   308: invokevirtual 178	java/io/StringWriter:toString	()Ljava/lang/String;
    //   311: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokestatic 101	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   320: aload_1
    //   321: ifnull -289 -> 32
    //   324: aload_1
    //   325: invokevirtual 151	java/io/BufferedInputStream:close	()V
    //   328: goto -296 -> 32
    //   331: astore_1
    //   332: aload_1
    //   333: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   336: goto -304 -> 32
    //   339: astore_1
    //   340: aconst_null
    //   341: astore_2
    //   342: aload_2
    //   343: ifnull +7 -> 350
    //   346: aload_2
    //   347: invokevirtual 151	java/io/BufferedInputStream:close	()V
    //   350: aload_1
    //   351: athrow
    //   352: astore_2
    //   353: aload_2
    //   354: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   357: goto -7 -> 350
    //   360: astore_1
    //   361: aload_1
    //   362: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   365: goto -333 -> 32
    //   368: astore_1
    //   369: goto -27 -> 342
    //   372: astore_3
    //   373: aload_1
    //   374: astore_2
    //   375: aload_3
    //   376: astore_1
    //   377: goto -35 -> 342
    //   380: astore_3
    //   381: aload_2
    //   382: astore_1
    //   383: aload_3
    //   384: astore_2
    //   385: goto -112 -> 273
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	388	0	this	w
    //   3	242	1	localObject1	Object
    //   259	2	1	localIOException1	java.io.IOException
    //   267	58	1	localObject2	Object
    //   331	2	1	localIOException2	java.io.IOException
    //   339	12	1	localObject3	Object
    //   360	2	1	localIOException3	java.io.IOException
    //   368	6	1	localObject4	Object
    //   376	7	1	localObject5	Object
    //   8	245	2	localObject6	Object
    //   272	10	2	localThrowable1	Throwable
    //   341	6	2	localObject7	Object
    //   352	2	2	localIOException4	java.io.IOException
    //   374	11	2	localObject8	Object
    //   72	236	3	localObject9	Object
    //   372	4	3	localObject10	Object
    //   380	4	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   252	256	259	java/io/IOException
    //   24	32	267	finally
    //   252	256	267	finally
    //   260	264	267	finally
    //   324	328	267	finally
    //   332	336	267	finally
    //   346	350	267	finally
    //   350	352	267	finally
    //   353	357	267	finally
    //   361	365	267	finally
    //   4	9	272	java/lang/Throwable
    //   13	20	272	java/lang/Throwable
    //   35	51	272	java/lang/Throwable
    //   324	328	331	java/io/IOException
    //   4	9	339	finally
    //   13	20	339	finally
    //   35	51	339	finally
    //   346	350	352	java/io/IOException
    //   24	32	360	java/io/IOException
    //   51	87	368	finally
    //   87	110	368	finally
    //   110	133	368	finally
    //   133	156	368	finally
    //   156	179	368	finally
    //   179	202	368	finally
    //   202	225	368	finally
    //   225	248	368	finally
    //   273	320	372	finally
    //   51	87	380	java/lang/Throwable
    //   87	110	380	java/lang/Throwable
    //   110	133	380	java/lang/Throwable
    //   133	156	380	java/lang/Throwable
    //   156	179	380	java/lang/Throwable
    //   179	202	380	java/lang/Throwable
    //   202	225	380	java/lang/Throwable
    //   225	248	380	java/lang/Throwable
  }
  
  private File h()
  {
    try
    {
      if (this.b == null)
      {
        this.b = new File(j.a(this.a, 5));
        if ((this.b == null) || (!this.b.isDirectory())) {
          break label186;
        }
      }
      localFile = new File(this.b, "tbsnet.conf");
      if (!localFile.exists())
      {
        TbsLog.e("TbsCommonConfig", "Get file(" + localFile.getCanonicalPath() + ") failed!");
        return null;
      }
      try
      {
        TbsLog.w("TbsCommonConfig", "pathc:" + localFile.getCanonicalPath());
        return localFile;
      }
      catch (Throwable localThrowable1) {}
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        StringWriter localStringWriter;
        File localFile = null;
      }
    }
    localStringWriter = new StringWriter();
    localThrowable1.printStackTrace(new PrintWriter(localStringWriter));
    TbsLog.e("TbsCommonConfig", "exceptions occurred2:" + localStringWriter.toString());
    return localFile;
    label186:
    return null;
  }
  
  public String b()
  {
    return this.d;
  }
  
  public String c()
  {
    return this.g;
  }
  
  public String d()
  {
    return this.h;
  }
  
  public String e()
  {
    return this.i;
  }
  
  public String f()
  {
    return this.e;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/utils/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */