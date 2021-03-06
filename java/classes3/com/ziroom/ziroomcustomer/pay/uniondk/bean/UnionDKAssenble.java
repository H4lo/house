package com.ziroom.ziroomcustomer.pay.uniondk.bean;

public class UnionDKAssenble
{
  private DataBean data;
  private String error_code;
  private String error_message;
  private String status;
  
  public DataBean getData()
  {
    return this.data;
  }
  
  public String getError_code()
  {
    return this.error_code;
  }
  
  public String getError_message()
  {
    return this.error_message;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public boolean isSuccess()
  {
    return this.status.equals("success");
  }
  
  public void setData(DataBean paramDataBean)
  {
    this.data = paramDataBean;
  }
  
  public void setError_code(String paramString)
  {
    this.error_code = paramString;
  }
  
  public void setError_message(String paramString)
  {
    this.error_message = paramString;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
  
  public class DataBean
  {
    private String originStr;
    
    public DataBean() {}
    
    public String getOriginStr()
    {
      return this.originStr;
    }
    
    public void setOriginStr(String paramString)
    {
      this.originStr = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/pay/uniondk/bean/UnionDKAssenble.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */