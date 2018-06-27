package com.e.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.ViewConfiguration;
import android.view.WindowManager;

public class c
{
  private final boolean a;
  private final boolean b;
  private final int c;
  private final int d;
  private final boolean e;
  private final int f;
  private final int g;
  private final boolean h;
  private final float i;
  
  private c(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    Resources localResources = paramActivity.getResources();
    if (localResources.getConfiguration().orientation == 1)
    {
      bool1 = true;
      this.h = bool1;
      this.i = a(paramActivity);
      this.c = a(localResources, "status_bar_height");
      this.d = a(paramActivity);
      this.f = b(paramActivity);
      this.g = c(paramActivity);
      if (this.f <= 0) {
        break label116;
      }
    }
    label116:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.e = bool1;
      this.a = paramBoolean1;
      this.b = paramBoolean2;
      return;
      bool1 = false;
      break;
    }
  }
  
  @SuppressLint({"NewApi"})
  private float a(Activity paramActivity)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    if (Build.VERSION.SDK_INT >= 16) {
      paramActivity.getWindowManager().getDefaultDisplay().getRealMetrics(localDisplayMetrics);
    }
    for (;;)
    {
      return Math.min(localDisplayMetrics.widthPixels / localDisplayMetrics.density, localDisplayMetrics.heightPixels / localDisplayMetrics.density);
      paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    }
  }
  
  @TargetApi(14)
  private int a(Context paramContext)
  {
    int j = 0;
    if (Build.VERSION.SDK_INT >= 14)
    {
      TypedValue localTypedValue = new TypedValue();
      paramContext.getTheme().resolveAttribute(16843499, localTypedValue, true);
      j = TypedValue.complexToDimensionPixelSize(localTypedValue.data, paramContext.getResources().getDisplayMetrics());
    }
    return j;
  }
  
  private int a(Resources paramResources, String paramString)
  {
    int j = 0;
    int k = paramResources.getIdentifier(paramString, "dimen", "android");
    if (k > 0) {
      j = paramResources.getDimensionPixelSize(k);
    }
    return j;
  }
  
  @TargetApi(14)
  private int b(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    int k = 0;
    int j = k;
    if (Build.VERSION.SDK_INT >= 14)
    {
      j = k;
      if (d(paramContext)) {
        if (!this.h) {
          break label48;
        }
      }
    }
    label48:
    for (paramContext = "navigation_bar_height";; paramContext = "navigation_bar_height_landscape")
    {
      j = a(localResources, paramContext);
      return j;
    }
  }
  
  @TargetApi(14)
  private int c(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    int k = 0;
    int j = k;
    if (Build.VERSION.SDK_INT >= 14)
    {
      j = k;
      if (d(paramContext)) {
        j = a(localResources, "navigation_bar_width");
      }
    }
    return j;
  }
  
  @TargetApi(14)
  private boolean d(Context paramContext)
  {
    boolean bool = true;
    Resources localResources = paramContext.getResources();
    int j = localResources.getIdentifier("config_showNavigationBar", "bool", "android");
    if (j != 0)
    {
      bool = localResources.getBoolean(j);
      if ("1".equals(a.a())) {
        return false;
      }
      if ("0".equals(a.a())) {
        return true;
      }
    }
    else
    {
      if (!ViewConfiguration.get(paramContext).hasPermanentMenuKey()) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
    }
    return bool;
  }
  
  public boolean a()
  {
    return (this.i >= 600.0F) || (this.h);
  }
  
  public int b()
  {
    return this.c;
  }
  
  public boolean c()
  {
    return this.e;
  }
  
  public int d()
  {
    return this.f;
  }
  
  public int e()
  {
    return this.g;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/e/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */