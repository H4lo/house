package com.ziroom.datacenter.remote.responsebody.financial.chat;

public class h
{
  private int a;
  private String b;
  private String c;
  private String d;
  
  public h() {}
  
  public h(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.a = paramInt;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
  }
  
  public String getFormName()
  {
    return this.c;
  }
  
  public int getFormType()
  {
    return this.a;
  }
  
  public String getFormUrl()
  {
    return this.b;
  }
  
  public String getImageUrl()
  {
    return this.d;
  }
  
  public void setFormName(String paramString)
  {
    this.c = paramString;
  }
  
  public void setFormType(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setFormUrl(String paramString)
  {
    this.b = paramString;
  }
  
  public void setImageUrl(String paramString)
  {
    this.d = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/responsebody/financial/chat/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */