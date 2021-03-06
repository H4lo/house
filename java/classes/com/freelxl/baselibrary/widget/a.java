package com.freelxl.baselibrary.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.airbnb.lottie.LottieAnimationView;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.R.drawable;
import com.freelxl.baselibrary.R.id;
import com.freelxl.baselibrary.R.layout;
import com.freelxl.baselibrary.R.style;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.f;
import com.freelxl.baselibrary.f.h;
import com.growingio.android.sdk.agent.VdsAgent;
import java.io.File;

public class a
{
  private static int[] a = { R.drawable.loading_1, R.drawable.loading_2, R.drawable.loading_3, R.drawable.loading_4 };
  private static int[] b = { R.drawable.houseconfig_loading_1, R.drawable.houseconfig_loading_2, R.drawable.houseconfig_loading_3 };
  private static int c = 500;
  private static int d = 150;
  private static Dialog e = null;
  private static b f = null;
  private static Activity g = null;
  private static String h = "";
  private static SimpleDraweeView i;
  
  private static void a(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    paramString = new LinearLayout(paramContext);
    paramString.setGravity(17);
    Dialog localDialog = new Dialog(paramContext, R.style.loading_dialog);
    localDialog.setCancelable(paramBoolean1);
    View localView = View.inflate(paramContext, R.layout.loading_dialog, null);
    i = (SimpleDraweeView)localView.findViewById(R.id.loadingImageView);
    LottieAnimationView localLottieAnimationView = (LottieAnimationView)localView.findViewById(R.id.lav_loading);
    Object localObject = h.getPackageName(g);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      if ("com.ziroom.houseconfig".equals(localObject))
      {
        f = new b(i, b, d);
        paramString.addView(localView, localLayoutParams);
        paramContext = new LinearLayout.LayoutParams(-1, -1);
        paramString.setBackgroundResource(R.drawable.loading_dialog);
        localDialog.setContentView(paramString, paramContext);
        e = localDialog;
        paramContext = e;
        if ((paramContext instanceof Dialog)) {
          break label333;
        }
        paramContext.show();
      }
    }
    for (;;)
    {
      if (e != null) {
        e.setOnCancelListener(new DialogInterface.OnCancelListener()
        {
          public void onCancel(DialogInterface paramAnonymousDialogInterface) {}
        });
      }
      return;
      if ("com.ziroom.ziroomcustomer".equals(localObject))
      {
        if (f.notNull(h))
        {
          localObject = c.frescoFromFileController(new File(h));
          i.setController((DraweeController)localObject);
          h.loadLottieFromScCard(paramContext, localLottieAnimationView, h);
          break;
        }
        i.setController(c.frescoFromResourceController(R.drawable.zrr_efresh_image));
        localLottieAnimationView.setAnimation("defultloading.json");
        localLottieAnimationView.loop(true);
        localLottieAnimationView.playAnimation();
        break;
      }
      f = new b(i, a, c);
      break;
      f = new b(i, a, c);
      break;
      label333:
      VdsAgent.showDialog((Dialog)paramContext);
    }
  }
  
  public static void dismiss()
  {
    try
    {
      if ((e != null) && (g != null) && (!g.isFinishing()))
      {
        e.dismiss();
        if (f != null) {
          f.removeCallBacks();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      g = null;
      e = null;
      f = null;
    }
  }
  
  public static Dialog getDialog()
  {
    return e;
  }
  
  public static boolean isShowing()
  {
    return e.isShowing();
  }
  
  public static void setImageGif(String paramString)
  {
    h = paramString;
  }
  
  public static void show(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    g = paramActivity;
    if (!g.isFinishing()) {
      a(paramActivity, "", paramBoolean1, paramBoolean2);
    }
  }
  
  public static void show(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    g = (Activity)paramContext;
    if (g.isFinishing()) {}
    do
    {
      return;
      if (e == null)
      {
        a(paramContext, paramString, paramBoolean1, paramBoolean2);
        return;
      }
      Context localContext = e.getContext();
      if (((localContext instanceof Activity)) && (((Activity)localContext).isFinishing()))
      {
        e = null;
        a(paramContext, paramString, paramBoolean1, paramBoolean2);
        return;
      }
    } while (isShowing());
    paramContext = e;
    if (!(paramContext instanceof Dialog))
    {
      paramContext.show();
      return;
    }
    VdsAgent.showDialog((Dialog)paramContext);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/widget/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */