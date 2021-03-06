package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.smtt.sdk.WebView;

public class v
{
  private static String a = null;
  private static String b = "GA";
  private static String c = "GE";
  private static String d = "9422";
  private static String e = "0";
  private static String f = "";
  private static boolean g = false;
  private static boolean h = false;
  private static boolean i = false;
  
  private static String a()
  {
    return " " + Build.MODEL.replaceAll("[ |\\/|\\_|\\&|\\|]", "") + " ";
  }
  
  public static String a(Context paramContext)
  {
    if (!TextUtils.isEmpty(a)) {
      return a;
    }
    a = a(paramContext, String.valueOf(WebView.getTbsSDKVersion(paramContext)), "0", b, c, d, e, f, g);
    return a;
  }
  
  private static String a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = b(paramContext) + "*" + c(paramContext);
    for (;;)
    {
      try
      {
        localObject1 = paramContext.getApplicationContext().getApplicationInfo();
        localObject3 = paramContext.getPackageManager().getPackageInfo(((ApplicationInfo)localObject1).packageName, 0);
        localObject1 = ((ApplicationInfo)localObject1).packageName;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException1)
      {
        Object localObject1;
        Object localObject3;
        boolean bool;
        paramString7 = null;
        localNameNotFoundException1.printStackTrace();
        localObject2 = null;
        continue;
        if (d(paramContext))
        {
          paramContext = "PAD";
          continue;
        }
      }
      try
      {
        bool = TextUtils.isEmpty(paramString7);
        if (bool) {
          continue;
        }
        localObject3 = localObject1;
        localObject1 = paramString7;
        paramString7 = (String)localObject3;
        localObject3 = a(paramString7);
        if (!"QB".equals(localObject3)) {
          continue;
        }
        if (!paramBoolean) {
          break label446;
        }
        paramContext = "PAD";
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException2)
      {
        paramString7 = (String)localObject2;
        localObject2 = localNameNotFoundException2;
        continue;
        paramContext = "PHONE";
        continue;
      }
      localStringBuilder.append("QV").append("=").append("3");
      a(localStringBuilder, "PL", "ADR");
      a(localStringBuilder, "PR", (String)localObject3);
      a(localStringBuilder, "PP", paramString7);
      a(localStringBuilder, "PPVN", (String)localObject1);
      if (!TextUtils.isEmpty(paramString1)) {
        a(localStringBuilder, "TBSVC", paramString1);
      }
      a(localStringBuilder, "CO", "SYS");
      if (!TextUtils.isEmpty(paramString2)) {
        a(localStringBuilder, "COVC", paramString2);
      }
      a(localStringBuilder, "PB", paramString4);
      a(localStringBuilder, "VE", paramString3);
      a(localStringBuilder, "DE", paramContext);
      paramContext = paramString6;
      if (TextUtils.isEmpty(paramString6)) {
        paramContext = "0";
      }
      a(localStringBuilder, "CHID", paramContext);
      a(localStringBuilder, "LCID", paramString5);
      paramContext = a();
      try
      {
        paramString1 = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
        paramContext = paramString1;
      }
      catch (Exception paramString1)
      {
        continue;
      }
      if (!TextUtils.isEmpty(paramContext)) {
        a(localStringBuilder, "MO", paramContext);
      }
      a(localStringBuilder, "RL", str);
      paramContext = Build.VERSION.RELEASE;
      try
      {
        paramString1 = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
        paramContext = paramString1;
      }
      catch (Exception paramString1)
      {
        continue;
      }
      if (!TextUtils.isEmpty(paramContext)) {
        a(localStringBuilder, "OS", paramContext);
      }
      a(localStringBuilder, "API", Build.VERSION.SDK_INT + "");
      return localStringBuilder.toString();
      paramString7 = ((PackageInfo)localObject3).versionName;
    }
  }
  
  private static String a(String paramString)
  {
    if (paramString.equals("com.tencent.mm")) {
      return "WX";
    }
    if (paramString.equals("com.tencent.mobileqq")) {
      return "QQ";
    }
    if (paramString.equals("com.qzone")) {
      return "QZ";
    }
    if (paramString.equals("com.tencent.mtt")) {
      return "QB";
    }
    return "TRD";
  }
  
  private static void a(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    paramStringBuilder.append("&").append(paramString1).append("=").append(paramString2);
  }
  
  private static int b(Context paramContext)
  {
    return ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
  }
  
  private static int c(Context paramContext)
  {
    return ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getHeight();
  }
  
  private static boolean d(Context paramContext)
  {
    if (h) {
      return i;
    }
    if (Math.min(b(paramContext), c(paramContext)) * 160 / e(paramContext) >= 700) {}
    for (boolean bool = true;; bool = false)
    {
      i = bool;
      h = true;
      return i;
    }
  }
  
  private static int e(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics.densityDpi;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/utils/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */