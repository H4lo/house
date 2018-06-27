package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class b
{
  public static String a = "";
  public static String b = "";
  public static String c = "";
  public static String d = "";
  public static String e = "";
  
  private static PackageInfo a(String paramString, int paramInt)
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject2 = Class.forName("android.content.pm.PackageParser");
        Object localObject1 = ((Class)localObject2).getDeclaredClasses();
        int j = localObject1.length;
        i = 0;
        if (i < j)
        {
          localMethod1 = localObject1[i];
          if (localMethod1.getName().compareTo("android.content.pm.PackageParser$Package") != 0) {
            break label345;
          }
          Object localObject3 = ((Class)localObject2).getConstructor(new Class[] { String.class });
          Method localMethod2 = ((Class)localObject2).getDeclaredMethod("parsePackage", new Class[] { File.class, String.class, DisplayMetrics.class, Integer.TYPE });
          localObject1 = ((Class)localObject2).getDeclaredMethod("collectCertificates", new Class[] { localMethod1, Integer.TYPE });
          localMethod1 = ((Class)localObject2).getDeclaredMethod("generatePackageInfo", new Class[] { localMethod1, int[].class, Integer.TYPE, Long.TYPE, Long.TYPE });
          ((Constructor)localObject3).setAccessible(true);
          localMethod2.setAccessible(true);
          ((Method)localObject1).setAccessible(true);
          localMethod1.setAccessible(true);
          localObject2 = ((Constructor)localObject3).newInstance(new Object[] { paramString });
          localObject3 = new DisplayMetrics();
          ((DisplayMetrics)localObject3).setToDefaults();
          paramString = localMethod2.invoke(localObject2, new Object[] { new File(paramString), paramString, localObject3, Integer.valueOf(0) });
          if (paramString == null) {
            return null;
          }
          if ((paramInt & 0x40) != 0) {
            ((Method)localObject1).invoke(localObject2, new Object[] { paramString, Integer.valueOf(0) });
          }
          paramString = (PackageInfo)localMethod1.invoke(null, new Object[] { paramString, null, Integer.valueOf(paramInt), Integer.valueOf(0), Integer.valueOf(0) });
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      Method localMethod1 = null;
      continue;
      label345:
      i += 1;
    }
  }
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_0
    //   4: aconst_null
    //   5: astore 4
    //   7: getstatic 20	com/tencent/smtt/utils/b:c	Ljava/lang/String;
    //   10: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifne +9 -> 22
    //   16: getstatic 20	com/tencent/smtt/utils/b:c	Ljava/lang/String;
    //   19: astore_2
    //   20: aload_2
    //   21: areturn
    //   22: new 128	java/io/InputStreamReader
    //   25: dup
    //   26: invokestatic 134	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   29: ldc -120
    //   31: invokevirtual 140	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   34: invokevirtual 146	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   37: invokespecial 149	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   40: astore_1
    //   41: aload_0
    //   42: astore_2
    //   43: aload_1
    //   44: astore_0
    //   45: new 151	java/io/BufferedReader
    //   48: dup
    //   49: aload_1
    //   50: invokespecial 154	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   53: astore_3
    //   54: aload_3
    //   55: invokevirtual 157	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   58: ldc -97
    //   60: invokevirtual 162	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   63: ifeq +34 -> 97
    //   66: ldc -92
    //   68: invokestatic 167	com/tencent/smtt/utils/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   71: astore_0
    //   72: aload_3
    //   73: ifnull +7 -> 80
    //   76: aload_3
    //   77: invokevirtual 170	java/io/BufferedReader:close	()V
    //   80: aload_0
    //   81: astore_2
    //   82: aload_1
    //   83: ifnull -63 -> 20
    //   86: aload_0
    //   87: astore_2
    //   88: aload_1
    //   89: invokevirtual 171	java/io/InputStreamReader:close	()V
    //   92: aload_0
    //   93: areturn
    //   94: astore_0
    //   95: aload_2
    //   96: areturn
    //   97: ldc -83
    //   99: invokestatic 178	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   102: invokestatic 167	com/tencent/smtt/utils/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   105: astore_0
    //   106: goto -34 -> 72
    //   109: astore_3
    //   110: aconst_null
    //   111: astore_1
    //   112: aload 4
    //   114: astore_2
    //   115: aload_1
    //   116: astore_0
    //   117: ldc -83
    //   119: invokestatic 178	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   122: invokestatic 167	com/tencent/smtt/utils/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   125: astore 5
    //   127: aload 4
    //   129: astore_2
    //   130: aload_1
    //   131: astore_0
    //   132: aload_3
    //   133: invokevirtual 179	java/lang/Throwable:printStackTrace	()V
    //   136: aload 4
    //   138: ifnull +8 -> 146
    //   141: aload 4
    //   143: invokevirtual 170	java/io/BufferedReader:close	()V
    //   146: aload 5
    //   148: astore_2
    //   149: aload_1
    //   150: ifnull -130 -> 20
    //   153: aload 5
    //   155: astore_2
    //   156: aload_1
    //   157: invokevirtual 171	java/io/InputStreamReader:close	()V
    //   160: aload 5
    //   162: areturn
    //   163: astore_3
    //   164: aconst_null
    //   165: astore_0
    //   166: aload_2
    //   167: ifnull +7 -> 174
    //   170: aload_2
    //   171: invokevirtual 170	java/io/BufferedReader:close	()V
    //   174: aload_0
    //   175: ifnull +7 -> 182
    //   178: aload_0
    //   179: invokevirtual 171	java/io/InputStreamReader:close	()V
    //   182: aload_3
    //   183: athrow
    //   184: astore_1
    //   185: goto -11 -> 174
    //   188: astore_0
    //   189: goto -7 -> 182
    //   192: astore_0
    //   193: goto -47 -> 146
    //   196: astore_2
    //   197: goto -117 -> 80
    //   200: astore_3
    //   201: goto -35 -> 166
    //   204: astore_0
    //   205: aload_3
    //   206: astore_2
    //   207: aload_0
    //   208: astore_3
    //   209: aload_1
    //   210: astore_0
    //   211: goto -45 -> 166
    //   214: astore_3
    //   215: goto -103 -> 112
    //   218: astore_0
    //   219: aload_3
    //   220: astore 4
    //   222: aload_0
    //   223: astore_3
    //   224: goto -112 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	90	0	localObject1	Object
    //   94	1	0	localIOException1	java.io.IOException
    //   105	74	0	localObject2	Object
    //   188	1	0	localIOException2	java.io.IOException
    //   192	1	0	localIOException3	java.io.IOException
    //   204	4	0	localObject3	Object
    //   210	1	0	localObject4	Object
    //   218	5	0	localThrowable1	Throwable
    //   40	117	1	localInputStreamReader	java.io.InputStreamReader
    //   184	26	1	localIOException4	java.io.IOException
    //   1	170	2	localObject5	Object
    //   196	1	2	localIOException5	java.io.IOException
    //   206	1	2	localObject6	Object
    //   53	24	3	localBufferedReader	java.io.BufferedReader
    //   109	24	3	localThrowable2	Throwable
    //   163	20	3	localObject7	Object
    //   200	6	3	localObject8	Object
    //   208	1	3	localObject9	Object
    //   214	6	3	localThrowable3	Throwable
    //   223	1	3	localThrowable4	Throwable
    //   5	216	4	localObject10	Object
    //   125	36	5	str	String
    // Exception table:
    //   from	to	target	type
    //   88	92	94	java/io/IOException
    //   156	160	94	java/io/IOException
    //   22	41	109	java/lang/Throwable
    //   22	41	163	finally
    //   170	174	184	java/io/IOException
    //   178	182	188	java/io/IOException
    //   141	146	192	java/io/IOException
    //   76	80	196	java/io/IOException
    //   45	54	200	finally
    //   117	127	200	finally
    //   132	136	200	finally
    //   54	72	204	finally
    //   97	106	204	finally
    //   45	54	214	java/lang/Throwable
    //   54	72	218	java/lang/Throwable
    //   97	106	218	java/lang/Throwable
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      String str = paramContext.getPackageName();
      paramContext = paramContext.getPackageManager().getPackageInfo(str, 0).versionName;
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static String a(Context paramContext, File paramFile)
  {
    Object localObject2 = a(paramContext, paramFile, false);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = a(paramFile);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = a(paramContext, paramFile, true);
    }
    return (String)localObject2;
  }
  
  private static String a(Context paramContext, File paramFile, boolean paramBoolean)
  {
    Object localObject = null;
    if (paramBoolean)
    {
      paramContext = a(paramFile.getAbsolutePath(), 65);
      if (paramContext == null) {
        break label79;
      }
      if ((paramContext.signatures == null) || (paramContext.signatures.length <= 0)) {
        break label72;
      }
    }
    label72:
    label79:
    for (paramContext = paramContext.signatures[0];; paramContext = null)
    {
      paramFile = (File)localObject;
      if (paramContext != null) {
        paramFile = paramContext.toCharsString();
      }
      return paramFile;
      paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramFile.getAbsolutePath(), 65);
      break;
      TbsLog.w("AppUtil", "[getSignatureFromApk] pkgInfo is not null BUT signatures is null!");
    }
  }
  
  /* Error */
  public static String a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 185	android/content/Context:getPackageName	()Ljava/lang/String;
    //   4: astore_2
    //   5: aload_0
    //   6: invokevirtual 189	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   9: aload_2
    //   10: sipush 128
    //   13: invokevirtual 236	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   16: getfield 242	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   19: aload_1
    //   20: invokevirtual 248	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   23: invokestatic 251	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   26: astore_0
    //   27: aload_0
    //   28: invokestatic 254	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   31: invokestatic 258	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   34: invokestatic 251	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   37: astore_1
    //   38: aload_1
    //   39: areturn
    //   40: astore_0
    //   41: aconst_null
    //   42: areturn
    //   43: astore_1
    //   44: aload_0
    //   45: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	paramContext	Context
    //   0	46	1	paramString	String
    //   4	6	2	str	String
    // Exception table:
    //   from	to	target	type
    //   0	27	40	java/lang/Exception
    //   27	38	43	java/lang/Exception
  }
  
  private static String a(File paramFile)
  {
    String str1;
    for (;;)
    {
      try
      {
        JarFile localJarFile = new JarFile(paramFile);
        paramFile = localJarFile.getJarEntry("AndroidManifest.xml");
        byte[] arrayOfByte = new byte[' '];
        str1 = a(a(localJarFile, paramFile, arrayOfByte)[0].getEncoded());
        Enumeration localEnumeration = localJarFile.entries();
        if (!localEnumeration.hasMoreElements()) {
          break;
        }
        paramFile = (JarEntry)localEnumeration.nextElement();
        String str2 = paramFile.getName();
        if (str2 == null) {
          continue;
        }
        paramFile = a(localJarFile, paramFile, arrayOfByte);
        if (paramFile != null)
        {
          paramFile = a(paramFile[0].getEncoded());
          if (paramFile == null)
          {
            if (str2.startsWith("META-INF/")) {
              continue;
            }
            return null;
          }
          boolean bool = paramFile.equals(str1);
          if (bool) {
            continue;
          }
          return null;
        }
      }
      catch (Exception paramFile)
      {
        paramFile.printStackTrace();
        return null;
      }
      paramFile = null;
    }
    return str1;
  }
  
  private static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    int k = paramArrayOfByte.length;
    char[] arrayOfChar = new char[k * 2];
    int i = 0;
    if (i < k)
    {
      int m = paramArrayOfByte[i];
      int j = m >> 4 & 0xF;
      if (j >= 10)
      {
        j = j + 97 - 10;
        label44:
        arrayOfChar[(i * 2)] = ((char)j);
        j = m & 0xF;
        if (j < 10) {
          break label97;
        }
        j = j + 97 - 10;
      }
      for (;;)
      {
        arrayOfChar[(i * 2 + 1)] = ((char)j);
        i += 1;
        break;
        j += 48;
        break label44;
        label97:
        j += 48;
      }
    }
    return new String(arrayOfChar);
  }
  
  private static Certificate[] a(JarFile paramJarFile, JarEntry paramJarEntry, byte[] paramArrayOfByte)
  {
    paramJarFile = paramJarFile.getInputStream(paramJarEntry);
    while (paramJarFile.read(paramArrayOfByte, 0, paramArrayOfByte.length) != -1) {}
    paramJarFile.close();
    if (paramJarEntry != null) {
      return paramJarEntry.getCertificates();
    }
    return null;
  }
  
  public static int b(Context paramContext)
  {
    try
    {
      String str = paramContext.getPackageName();
      int i = paramContext.getPackageManager().getPackageInfo(str, 0).versionCode;
      return i;
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public static String c(Context paramContext)
  {
    if (!TextUtils.isEmpty(a)) {
      return a;
    }
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  public static String d(Context paramContext)
  {
    if (!TextUtils.isEmpty(b)) {
      return b;
    }
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  public static String e(Context paramContext)
  {
    if (!TextUtils.isEmpty(d)) {
      return d;
    }
    do
    {
      try
      {
        paramContext = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
        if (paramContext == null) {
          paramContext = null;
        } else {
          paramContext = paramContext.getConnectionInfo();
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return "";
      }
      paramContext = paramContext.getMacAddress();
      return paramContext;
    } while (paramContext != null);
    return "";
  }
  
  public static String f(Context paramContext)
  {
    if (!TextUtils.isEmpty(e)) {
      return e;
    }
    try
    {
      e = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      return e;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/utils/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */