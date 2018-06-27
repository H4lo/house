package com.ziroom.ziroomcustomer.newclean.periodclean.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.PeriodGeneralStatusBean;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import java.util.List;

public class e
  extends BaseAdapter
{
  private Context a;
  private List<PeriodGeneralStatusBean> b;
  
  public e(Context paramContext, List<PeriodGeneralStatusBean> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  private void a(SpannableString paramSpannableString, final String paramString, int paramInt)
  {
    paramSpannableString.setSpan(new ClickableSpan()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (!TextUtils.isEmpty(paramString)) {
          ah.callPhone(e.a(e.this), paramString);
        }
        e.a(e.this, paramAnonymousView);
      }
      
      public void updateDrawState(TextPaint paramAnonymousTextPaint)
      {
        super.updateDrawState(paramAnonymousTextPaint);
        paramAnonymousTextPaint.setColor(40960);
      }
    }, paramInt, paramString.length() + paramInt, 0);
  }
  
  private void a(View paramView)
  {
    if ((paramView instanceof TextView)) {
      ((TextView)paramView).setHighlightColor(this.a.getResources().getColor(17170445));
    }
  }
  
  public int getCount()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject2;
    Object localObject1;
    if (paramView == null)
    {
      localView = View.inflate(this.a, 2130904210, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((ImageView)localView.findViewById(2131694874));
      paramViewGroup.b = ((TextView)localView.findViewById(2131695039));
      paramViewGroup.c = ((TextView)localView.findViewById(2131694876));
      paramViewGroup.d = localView.findViewById(2131690678);
      localView.setTag(paramViewGroup);
      localObject2 = (PeriodGeneralStatusBean)this.b.get(paramInt);
      localObject1 = ((PeriodGeneralStatusBean)localObject2).getStatusName() + "·";
      paramView = ((PeriodGeneralStatusBean)localObject2).getContent();
      if ((!TextUtils.isEmpty(((PeriodGeneralStatusBean)localObject2).getStatusName())) || (TextUtils.isEmpty(((PeriodGeneralStatusBean)localObject2).getContent()))) {
        break label320;
      }
    }
    for (;;)
    {
      label152:
      boolean bool = j.isIncludeTelNum(paramView);
      label178:
      label212:
      SpannableString localSpannableString;
      if (TextUtils.isEmpty(((PeriodGeneralStatusBean)localObject2).getOptTime()))
      {
        paramViewGroup.c.setVisibility(8);
        if (this.b.size() > 0)
        {
          if (this.b.size() != 1) {
            break label419;
          }
          paramViewGroup.d.setVisibility(8);
        }
        if (((PeriodGeneralStatusBean)localObject2).getStatus() != 1) {
          break label636;
        }
        paramViewGroup.a.setBackgroundResource(2130839519);
        localSpannableString = new SpannableString(paramView);
        if ((!TextUtils.isEmpty(((PeriodGeneralStatusBean)localObject2).getStatusName())) || (TextUtils.isEmpty(((PeriodGeneralStatusBean)localObject2).getContent()))) {
          break label457;
        }
        localSpannableString.setSpan(new ForegroundColorSpan(-12303292), 0, localSpannableString.length(), 34);
        label284:
        paramViewGroup.b.setText(localSpannableString);
        paramViewGroup.b.setMovementMethod(LinkMovementMethod.getInstance());
      }
      label320:
      label419:
      label457:
      label636:
      do
      {
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
        break;
        if ((!TextUtils.isEmpty(((PeriodGeneralStatusBean)localObject2).getStatusName())) && (TextUtils.isEmpty(((PeriodGeneralStatusBean)localObject2).getContent())))
        {
          paramView = ((PeriodGeneralStatusBean)localObject2).getStatusName();
          break label152;
        }
        if ((TextUtils.isEmpty(((PeriodGeneralStatusBean)localObject2).getStatusName())) || (TextUtils.isEmpty(((PeriodGeneralStatusBean)localObject2).getContent()))) {
          break label883;
        }
        paramView = (String)localObject1 + paramView;
        break label152;
        paramViewGroup.c.setVisibility(0);
        paramViewGroup.c.setText(((PeriodGeneralStatusBean)localObject2).getOptTime());
        break label178;
        if (paramInt == this.b.size() - 1)
        {
          paramViewGroup.d.setVisibility(8);
          break label212;
        }
        paramViewGroup.d.setVisibility(0);
        break label212;
        if ((!TextUtils.isEmpty(((PeriodGeneralStatusBean)localObject2).getStatusName())) && (TextUtils.isEmpty(((PeriodGeneralStatusBean)localObject2).getContent())))
        {
          localSpannableString.setSpan(new ForegroundColorSpan(-12303292), 0, localSpannableString.length(), 34);
          break label284;
        }
        if ((TextUtils.isEmpty(((PeriodGeneralStatusBean)localObject2).getStatusName())) || (TextUtils.isEmpty(((PeriodGeneralStatusBean)localObject2).getContent()))) {
          break label284;
        }
        localObject2 = new ForegroundColorSpan(-12303292);
        ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(-6710887);
        localSpannableString.setSpan(localObject2, 0, ((String)localObject1).length(), 34);
        localSpannableString.setSpan(localForegroundColorSpan, ((String)localObject1).length(), localSpannableString.length(), 34);
        if (!bool) {
          break label284;
        }
        localObject1 = j.getTelnum(paramView);
        paramInt = paramView.indexOf((String)localObject1);
        u.d("sdjkgjkd", "=======    " + paramInt);
        a(localSpannableString, (String)localObject1, paramInt);
        break label284;
        if (((PeriodGeneralStatusBean)localObject2).getStatus() == 2)
        {
          paramViewGroup.a.setBackgroundResource(2130839520);
          localObject1 = new SpannableString(paramView);
          ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(40960), 0, ((SpannableString)localObject1).length(), 34);
          if (bool)
          {
            localObject2 = j.getTelnum(paramView);
            paramInt = paramView.indexOf((String)localObject2);
            u.d("sdjkgjkd", "=======    " + paramInt);
            a((SpannableString)localObject1, (String)localObject2, paramInt);
          }
          paramViewGroup.b.setText((CharSequence)localObject1);
          paramViewGroup.b.setMovementMethod(LinkMovementMethod.getInstance());
          return localView;
        }
      } while (((PeriodGeneralStatusBean)localObject2).getStatus() != 3);
      paramViewGroup.a.setBackgroundResource(2130839518);
      localObject1 = new SpannableString(paramView);
      ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(-6710887), 0, ((SpannableString)localObject1).length(), 34);
      if (bool)
      {
        localObject2 = j.getTelnum(paramView);
        paramInt = paramView.indexOf((String)localObject2);
        u.d("sdjkgjkd", "=======    " + paramInt);
        a((SpannableString)localObject1, (String)localObject2, paramInt);
      }
      paramViewGroup.b.setText((CharSequence)localObject1);
      paramViewGroup.b.setMovementMethod(LinkMovementMethod.getInstance());
      return localView;
      label883:
      paramView = "";
    }
  }
  
  public class a
  {
    public ImageView a;
    public TextView b;
    public TextView c;
    public View d;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/periodclean/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */