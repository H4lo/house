package com.pgyersdk.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.TypedValue;
import android.widget.ImageButton;
import com.pgyersdk.i.c;

public class r
  extends ImageButton
{
  private Context a;
  
  public r(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    int i = (int)TypedValue.applyDimension(1, 2.0F, paramContext.getResources().getDisplayMetrics());
    ShapeDrawable localShapeDrawable1 = new ShapeDrawable(new OvalShape());
    localShapeDrawable1.getPaint().setColor(Color.parseColor("#f2f2f2"));
    localShapeDrawable1.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
    localShapeDrawable1.setBounds(0, 0, c.a(paramContext, 30.0F), c.a(paramContext, 30.0F));
    ShapeDrawable localShapeDrawable2 = new ShapeDrawable(new OvalShape());
    localShapeDrawable2.getPaint().setColor(Color.parseColor("#e0e0e0"));
    localShapeDrawable2.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
    localShapeDrawable2.setBounds(0, 0, c.a(paramContext, 30.0F), c.a(paramContext, 30.0F));
    setBackgroundDrawable(a(paramContext, localShapeDrawable1, localShapeDrawable2, localShapeDrawable2, localShapeDrawable1));
  }
  
  public static StateListDrawable a(Context paramContext, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    paramContext = new StateListDrawable();
    paramContext.addState(new int[] { 16842919, 16842910 }, paramDrawable2);
    paramContext.addState(new int[] { 16842910, 16842908 }, paramDrawable3);
    paramContext.addState(new int[] { 16842910 }, paramDrawable1);
    paramContext.addState(new int[] { 16842908 }, paramDrawable3);
    paramContext.addState(new int[] { 16842909 }, paramDrawable4);
    paramContext.addState(new int[0], paramDrawable1);
    return paramContext;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setColor(-16777216);
    localPaint.setStrokeWidth(2.0F);
    localPaint.getStyle();
    localPaint.setStyle(Paint.Style.STROKE);
    int i = c.a(this.a, 10.0F);
    paramCanvas.drawLine(i, i, getHeight() - i, getHeight() - i, localPaint);
    paramCanvas.drawLine(getHeight() - i, i, i, getHeight() - i, localPaint);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/views/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */