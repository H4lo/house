package com.tencent.smtt.sdk;

import com.tencent.smtt.sdk.a.d;

class bc
  implements android.webkit.DownloadListener
{
  bc(WebView paramWebView, DownloadListener paramDownloadListener) {}
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    if (this.a == null)
    {
      d.a(WebView.a(this.b), paramString1, null, null);
      return;
    }
    this.a.onDownloadStart(paramString1, paramString2, paramString3, paramString4, paramLong);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */