package cn.sharesdk.framework.b.b;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.utils.e;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import java.util.ArrayList;
import java.util.HashMap;

public class f
  extends c
{
  private static int o;
  private static long p;
  public int a;
  public String b;
  public String c;
  public a d = new a();
  public String m;
  public String[] n;
  
  protected String a()
  {
    return "[SHR]";
  }
  
  protected void a(long paramLong)
  {
    p = paramLong;
  }
  
  protected int b()
  {
    return 5000;
  }
  
  protected int c()
  {
    return 30;
  }
  
  protected long d()
  {
    return o;
  }
  
  protected long e()
  {
    return p;
  }
  
  protected void f()
  {
    o += 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(super.toString());
    localStringBuilder.append('|').append(this.a);
    localStringBuilder.append('|').append(this.b);
    Object localObject2 = localStringBuilder.append('|');
    if (TextUtils.isEmpty(this.c)) {}
    for (Object localObject1 = "";; localObject1 = this.c)
    {
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject2 = "";
      localObject1 = localObject2;
      if (this.n != null)
      {
        localObject1 = localObject2;
        if (this.n.length > 0) {
          localObject1 = "[\"" + TextUtils.join("\",\"", this.n) + "\"]";
        }
      }
      localStringBuilder.append('|').append((String)localObject1);
      localStringBuilder.append('|');
      if (this.d != null) {
        localObject1 = this.d.toString();
      }
      try
      {
        localObject2 = Base64.encodeToString(Data.AES128Encode(this.f.substring(0, 16), (String)localObject1), 0);
        localObject1 = localObject2;
        if (((String)localObject2).contains("\n")) {
          localObject1 = ((String)localObject2).replace("\n", "");
        }
        localStringBuilder.append((String)localObject1);
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          e.b().d(localThrowable1);
        }
      }
      localStringBuilder.append('|');
      if (!TextUtils.isEmpty(this.l)) {
        localStringBuilder.append(this.l);
      }
      localStringBuilder.append('|');
      if (!TextUtils.isEmpty(this.m)) {}
      try
      {
        localObject2 = Base64.encodeToString(Data.AES128Encode(this.f.substring(0, 16), this.m), 0);
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = localObject2;
          if (((String)localObject2).contains("\n")) {
            localObject1 = ((String)localObject2).replace("\n", "");
          }
        }
        localStringBuilder.append((String)localObject1);
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          e.b().w(localThrowable2);
        }
      }
      return localStringBuilder.toString();
    }
  }
  
  public static class a
  {
    public String a = "";
    public String b;
    public ArrayList<String> c = new ArrayList();
    public ArrayList<String> d = new ArrayList();
    public ArrayList<String> e = new ArrayList();
    public ArrayList<Bitmap> f = new ArrayList();
    public HashMap<String, Object> g;
    
    public String toString()
    {
      HashMap localHashMap = new HashMap();
      if (!TextUtils.isEmpty(this.b))
      {
        this.b = this.b.trim().replaceAll("\r", "");
        this.b = this.b.trim().replaceAll("\n", "");
        this.b = this.b.trim().replaceAll("\r\n", "");
      }
      localHashMap.put("text", this.b);
      localHashMap.put("url", this.c);
      if ((this.d != null) && (this.d.size() > 0)) {
        localHashMap.put("imgs", this.d);
      }
      if (this.g != null) {
        localHashMap.put("attch", new Hashon().fromHashMap(this.g));
      }
      return new Hashon().fromHashMap(localHashMap);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/framework/b/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */