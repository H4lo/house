package com.ziroom.ziroomcustomer.payment.d;

import com.alibaba.fastjson.e;
import com.ziroom.commonlibrary.a.b;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class d<T>
  extends com.freelxl.baselibrary.d.f.a<T>
{
  protected Class<T> a;
  
  public d(Class<T> paramClass)
  {
    this.a = paramClass;
  }
  
  protected T parse(Response paramResponse)
    throws Exception
  {
    if (paramResponse.isSuccessful())
    {
      paramResponse = paramResponse.body().string();
      com.freelxl.baselibrary.f.d.e("yangxj+++++", paramResponse);
      paramResponse = e.parseObject(paramResponse);
      if (paramResponse != null)
      {
        if ("0".equals(paramResponse.get("error_code").toString()))
        {
          if (paramResponse.getString("data") == null) {}
          for (paramResponse = "";; paramResponse = paramResponse.get("data").toString()) {
            return (T)com.alibaba.fastjson.a.parseObject(paramResponse, this.a);
          }
        }
        throw new b(0, paramResponse.get("message").toString());
      }
      throw new b(0);
    }
    throw new com.freelxl.baselibrary.d.d.a(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/payment/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */