package com.ziroom.ziroomcustomer.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ListView;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.d;
import com.ziroom.ziroomcustomer.model.Server;
import com.ziroom.ziroomcustomer.model.ServerDetail;
import java.util.List;

public class AboutZiroomYuAcitivity
  extends BaseActivity
{
  private ListView a;
  private com.ziroom.ziroomcustomer.adapter.l b;
  private List<ServerDetail> c;
  private Handler d = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      AboutZiroomYuAcitivity.this.dismissProgress();
      com.ziroom.ziroomcustomer.e.l locall = (com.ziroom.ziroomcustomer.e.l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      if (locall.getSuccess().booleanValue())
      {
        paramAnonymousMessage = (Server)locall.getObject();
        AboutZiroomYuAcitivity.a(AboutZiroomYuAcitivity.this, paramAnonymousMessage.getList());
        AboutZiroomYuAcitivity.a(AboutZiroomYuAcitivity.this);
      }
      for (;;)
      {
        AboutZiroomYuAcitivity.this.dismissProgress();
        return;
        AboutZiroomYuAcitivity.this.showToast(locall.getMessage());
      }
    }
  };
  
  private void a()
  {
    this.b = new com.ziroom.ziroomcustomer.adapter.l(this, this.c);
    this.a.setAdapter(this.b);
  }
  
  public void back(View paramView)
  {
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904940);
    this.a = ((ListView)findViewById(2131696926));
    if (!checkNet(getApplicationContext()))
    {
      showToast("网络请求失败，请检查您的网络设置");
      return;
    }
    d.getFlatGuideList(this, this.d);
    showProgress("");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/AboutZiroomYuAcitivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */