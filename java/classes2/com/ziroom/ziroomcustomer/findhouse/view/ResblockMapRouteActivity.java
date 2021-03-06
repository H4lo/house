package com.ziroom.ziroomcustomer.findhouse.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetBehavior.BottomSheetCallback;
import android.support.design.widget.CoordinatorLayout.LayoutParams;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.LatLngBounds.Builder;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.core.VehicleInfo;
import com.baidu.mapapi.search.route.BikingRouteLine;
import com.baidu.mapapi.search.route.BikingRoutePlanOption;
import com.baidu.mapapi.search.route.BikingRouteResult;
import com.baidu.mapapi.search.route.DrivingRouteLine;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
import com.baidu.mapapi.search.route.TransitRouteLine;
import com.baidu.mapapi.search.route.TransitRouteLine.TransitStep;
import com.baidu.mapapi.search.route.TransitRouteLine.TransitStep.TransitRouteStepType;
import com.baidu.mapapi.search.route.TransitRoutePlanOption;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.mapapi.search.route.WalkingRouteLine;
import com.baidu.mapapi.search.route.WalkingRoutePlanOption;
import com.baidu.mapapi.search.route.WalkingRouteResult;
import com.freelxl.baselibrary.f.g;
import com.google.android.flexbox.FlexboxLayout;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.b.o;
import com.ziroom.ziroomcustomer.findhouse.a.d;
import com.ziroom.ziroomcustomer.findhouse.model.MapPlanNode;
import com.ziroom.ziroomcustomer.findhouse.model.MapPlanNode.MapRoute;
import com.ziroom.ziroomcustomer.findhouse.widget.ResblockKeywordSearchDialog;
import com.ziroom.ziroomcustomer.findhouse.widget.ResblockKeywordSearchDialog.b;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ResblockMapRouteActivity
  extends FragmentActivity
{
  protected LocationClient a;
  private BottomSheetBehavior b;
  private RoutePlanSearch c = null;
  private List<WalkingRouteLine> d;
  private List<TransitRouteLine> e;
  private List<DrivingRouteLine> f;
  private List<BikingRouteLine> g;
  private com.ziroom.ziroomcustomer.util.b.b h = null;
  private b i;
  private int j = 1;
  private PlanNode k;
  private PlanNode l;
  private BaiduMap m;
  @BindView(2131691591)
  RelativeLayout mBottomSheet;
  @BindView(2131691592)
  FlexboxLayout mFlButtons;
  @BindView(2131689492)
  ImageView mIvBack;
  @BindView(2131691586)
  ImageView mIvBackUp;
  @BindView(2131691587)
  ImageView mIvSwitchAddress;
  @BindView(2131696451)
  LinearLayout mLlCurrentAddress;
  @BindView(2131690323)
  LinearLayout mLlHistory;
  @BindView(2131691588)
  LinearLayout mLlSearch;
  @BindView(2131692232)
  LinearLayout mLlShortcut;
  @BindView(2131689827)
  ListView mLvHistory;
  @BindView(2131691594)
  ListView mLvRoute;
  @BindView(2131690823)
  MapView mMapView;
  @BindView(2131690820)
  RadioButton mRbBike;
  @BindView(2131690819)
  RadioButton mRbDrive;
  @BindView(2131690818)
  RadioButton mRbTransit;
  @BindView(2131690821)
  RadioButton mRbWalk;
  @BindView(2131690817)
  RadioGroup mRgType;
  @BindView(2131690902)
  RelativeLayout mRlHeader;
  @BindView(2131693164)
  TextView mTvCompanyAddress;
  @BindView(2131696450)
  TextView mTvCompanySetting;
  @BindView(2131690822)
  TextView mTvEmpty;
  @BindView(2131691590)
  TextView mTvRouteEnd;
  @BindView(2131691589)
  TextView mTvRouteStart;
  private MapPlanNode n;
  private MapPlanNode o;
  private MapPlanNode p;
  private int q = 20;
  private List<MapPlanNode.MapRoute> r = new ArrayList();
  private d s;
  private BDLocation t;
  private a u;
  private Handler v = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 1: 
        ResblockMapRouteActivity.this.mLlHistory.setVisibility(8);
        return;
      }
      ResblockMapRouteActivity.this.mLlHistory.setVisibility(0);
      ResblockMapRouteActivity.a(ResblockMapRouteActivity.this, new d(ResblockMapRouteActivity.this, ResblockMapRouteActivity.a(ResblockMapRouteActivity.this)));
      ResblockMapRouteActivity.this.mLvHistory.setAdapter(ResblockMapRouteActivity.i(ResblockMapRouteActivity.this));
    }
  };
  private OnGetRoutePlanResultListener w = new OnGetRoutePlanResultListener()
  {
    public void onGetBikingRouteResult(BikingRouteResult paramAnonymousBikingRouteResult)
    {
      if (((paramAnonymousBikingRouteResult == null) || (paramAnonymousBikingRouteResult.error == SearchResult.ERRORNO.NO_ERROR)) || (paramAnonymousBikingRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR))
      {
        ResblockMapRouteActivity.j(ResblockMapRouteActivity.this).notifyDataSetChanged();
        ResblockMapRouteActivity.this.mLvRoute.setEmptyView(ResblockMapRouteActivity.this.mTvEmpty);
        return;
      }
      if (paramAnonymousBikingRouteResult.error == SearchResult.ERRORNO.NO_ERROR)
      {
        if (paramAnonymousBikingRouteResult.getRouteLines().size() >= 1)
        {
          ResblockMapRouteActivity.e(ResblockMapRouteActivity.this, paramAnonymousBikingRouteResult.getRouteLines());
          ResblockMapRouteActivity.j(ResblockMapRouteActivity.this).selectItem(0);
          ResblockMapRouteActivity.a(ResblockMapRouteActivity.this, ResblockMapRouteActivity.k(ResblockMapRouteActivity.this), null, null, (BikingRouteLine)paramAnonymousBikingRouteResult.getRouteLines().get(0), null);
          return;
        }
        ResblockMapRouteActivity.j(ResblockMapRouteActivity.this).notifyDataSetChanged();
        ResblockMapRouteActivity.this.mLvRoute.setEmptyView(ResblockMapRouteActivity.this.mTvEmpty);
        return;
      }
      ResblockMapRouteActivity.j(ResblockMapRouteActivity.this).notifyDataSetChanged();
      ResblockMapRouteActivity.this.mLvRoute.setEmptyView(ResblockMapRouteActivity.this.mTvEmpty);
    }
    
    public void onGetDrivingRouteResult(DrivingRouteResult paramAnonymousDrivingRouteResult)
    {
      if (((paramAnonymousDrivingRouteResult == null) || (paramAnonymousDrivingRouteResult.error == SearchResult.ERRORNO.NO_ERROR)) || (paramAnonymousDrivingRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR))
      {
        ResblockMapRouteActivity.j(ResblockMapRouteActivity.this).notifyDataSetChanged();
        ResblockMapRouteActivity.this.mLvRoute.setEmptyView(ResblockMapRouteActivity.this.mTvEmpty);
        return;
      }
      if (paramAnonymousDrivingRouteResult.error == SearchResult.ERRORNO.NO_ERROR)
      {
        if (paramAnonymousDrivingRouteResult.getRouteLines().size() >= 1)
        {
          ResblockMapRouteActivity.d(ResblockMapRouteActivity.this, paramAnonymousDrivingRouteResult.getRouteLines());
          ResblockMapRouteActivity.j(ResblockMapRouteActivity.this).selectItem(0);
          ResblockMapRouteActivity.a(ResblockMapRouteActivity.this, ResblockMapRouteActivity.k(ResblockMapRouteActivity.this), null, (DrivingRouteLine)paramAnonymousDrivingRouteResult.getRouteLines().get(0), null, null);
          return;
        }
        ResblockMapRouteActivity.j(ResblockMapRouteActivity.this).notifyDataSetChanged();
        ResblockMapRouteActivity.this.mLvRoute.setEmptyView(ResblockMapRouteActivity.this.mTvEmpty);
        return;
      }
      ResblockMapRouteActivity.j(ResblockMapRouteActivity.this).notifyDataSetChanged();
      ResblockMapRouteActivity.this.mLvRoute.setEmptyView(ResblockMapRouteActivity.this.mTvEmpty);
    }
    
    public void onGetTransitRouteResult(TransitRouteResult paramAnonymousTransitRouteResult)
    {
      if (((paramAnonymousTransitRouteResult == null) || (paramAnonymousTransitRouteResult.error == SearchResult.ERRORNO.NO_ERROR)) || (paramAnonymousTransitRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR))
      {
        ResblockMapRouteActivity.j(ResblockMapRouteActivity.this).notifyDataSetChanged();
        ResblockMapRouteActivity.this.mLvRoute.setEmptyView(ResblockMapRouteActivity.this.mTvEmpty);
        return;
      }
      if (paramAnonymousTransitRouteResult.error == SearchResult.ERRORNO.NO_ERROR)
      {
        if (paramAnonymousTransitRouteResult.getRouteLines().size() >= 1)
        {
          ResblockMapRouteActivity.c(ResblockMapRouteActivity.this, paramAnonymousTransitRouteResult.getRouteLines());
          ResblockMapRouteActivity.j(ResblockMapRouteActivity.this).selectItem(0);
          ResblockMapRouteActivity.a(ResblockMapRouteActivity.this, ResblockMapRouteActivity.k(ResblockMapRouteActivity.this), (TransitRouteLine)paramAnonymousTransitRouteResult.getRouteLines().get(0), null, null, null);
          ResblockMapRouteActivity.this.mLvRoute.setEmptyView(ResblockMapRouteActivity.this.mTvEmpty);
          return;
        }
        ResblockMapRouteActivity.j(ResblockMapRouteActivity.this).notifyDataSetChanged();
        ResblockMapRouteActivity.this.mLvRoute.setEmptyView(ResblockMapRouteActivity.this.mTvEmpty);
        return;
      }
      ResblockMapRouteActivity.j(ResblockMapRouteActivity.this).notifyDataSetChanged();
      ResblockMapRouteActivity.this.mLvRoute.setEmptyView(ResblockMapRouteActivity.this.mTvEmpty);
    }
    
    public void onGetWalkingRouteResult(WalkingRouteResult paramAnonymousWalkingRouteResult)
    {
      if (ResblockMapRouteActivity.this.isFinishing()) {
        return;
      }
      if (((paramAnonymousWalkingRouteResult == null) || (paramAnonymousWalkingRouteResult.error == SearchResult.ERRORNO.NO_ERROR)) || (paramAnonymousWalkingRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR))
      {
        ResblockMapRouteActivity.j(ResblockMapRouteActivity.this).notifyDataSetChanged();
        ResblockMapRouteActivity.this.mLvRoute.setEmptyView(ResblockMapRouteActivity.this.mTvEmpty);
        return;
      }
      if (paramAnonymousWalkingRouteResult.error == SearchResult.ERRORNO.NO_ERROR)
      {
        if (paramAnonymousWalkingRouteResult.getRouteLines().size() >= 1)
        {
          ResblockMapRouteActivity.b(ResblockMapRouteActivity.this, paramAnonymousWalkingRouteResult.getRouteLines());
          ResblockMapRouteActivity.j(ResblockMapRouteActivity.this).selectItem(0);
          ResblockMapRouteActivity.a(ResblockMapRouteActivity.this, ResblockMapRouteActivity.k(ResblockMapRouteActivity.this), null, null, null, (WalkingRouteLine)paramAnonymousWalkingRouteResult.getRouteLines().get(0));
          return;
        }
        ResblockMapRouteActivity.j(ResblockMapRouteActivity.this).notifyDataSetChanged();
        ResblockMapRouteActivity.this.mLvRoute.setEmptyView(ResblockMapRouteActivity.this.mTvEmpty);
        return;
      }
      ResblockMapRouteActivity.j(ResblockMapRouteActivity.this).notifyDataSetChanged();
      ResblockMapRouteActivity.this.mLvRoute.setEmptyView(ResblockMapRouteActivity.this.mTvEmpty);
    }
  };
  
  private void a()
  {
    this.n = ((MapPlanNode)getIntent().getParcelableExtra("start"));
    this.o = new MapPlanNode();
    this.p = ad.getResblockMapCompany(this);
    if ((this.p == null) || (TextUtils.isEmpty(this.p.getName()))) {
      this.p = null;
    }
    for (;;)
    {
      this.mTvRouteStart.setText(this.n.getName());
      b();
      this.b = BottomSheetBehavior.from(this.mBottomSheet);
      b(5);
      int i1 = getResources().getDisplayMetrics().heightPixels;
      CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)this.mBottomSheet.getLayoutParams();
      localLayoutParams.height = (i1 / 2);
      this.mBottomSheet.setLayoutParams(localLayoutParams);
      c();
      this.b.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback()
      {
        public void onSlide(View paramAnonymousView, float paramAnonymousFloat) {}
        
        public void onStateChanged(View paramAnonymousView, int paramAnonymousInt)
        {
          if (paramAnonymousInt == 4) {
            if (ResblockMapRouteActivity.this.mRlHeader.getVisibility() != 0)
            {
              ResblockMapRouteActivity.a(ResblockMapRouteActivity.this, ResblockMapRouteActivity.this.mRlHeader);
              ResblockMapRouteActivity.this.mIvBackUp.setVisibility(8);
            }
          }
          while ((paramAnonymousInt != 3) || (ResblockMapRouteActivity.this.mRlHeader.getVisibility() != 0)) {
            return;
          }
          ResblockMapRouteActivity.b(ResblockMapRouteActivity.this, ResblockMapRouteActivity.this.mRlHeader);
          ResblockMapRouteActivity.this.mIvBackUp.setVisibility(0);
        }
      });
      return;
      this.mTvCompanyAddress.setText(this.p.getName());
    }
  }
  
  private void a(int paramInt)
  {
    this.q = paramInt;
    if (this.q == 21)
    {
      this.mLlShortcut.setVisibility(8);
      this.mLlHistory.setVisibility(8);
      this.b.setPeekHeight(ah.dip2px(this, 140.0F));
      b(4);
      h();
      return;
    }
    this.mRlHeader.setVisibility(0);
    this.mLlShortcut.setVisibility(0);
    this.mLlHistory.setVisibility(0);
    b(5);
  }
  
  private void a(int paramInt, TransitRouteLine paramTransitRouteLine, DrivingRouteLine paramDrivingRouteLine, BikingRouteLine paramBikingRouteLine, WalkingRouteLine paramWalkingRouteLine)
  {
    this.m.clear();
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while (paramTransitRouteLine == null);
          paramDrivingRouteLine = new d(this.m);
          this.m.setOnMarkerClickListener(paramDrivingRouteLine);
          this.h = paramDrivingRouteLine;
          paramDrivingRouteLine.setData(paramTransitRouteLine);
          paramDrivingRouteLine.addToMap();
          paramDrivingRouteLine.zoomToSpan();
          return;
        } while (paramDrivingRouteLine == null);
        paramTransitRouteLine = new d(this.m);
        this.m.setOnMarkerClickListener(paramTransitRouteLine);
        this.h = paramTransitRouteLine;
        paramTransitRouteLine.setData(paramDrivingRouteLine);
        paramTransitRouteLine.addToMap();
        paramTransitRouteLine.zoomToSpan();
        return;
      } while (paramBikingRouteLine == null);
      paramTransitRouteLine = new d(this.m);
      this.m.setOnMarkerClickListener(paramTransitRouteLine);
      this.h = paramTransitRouteLine;
      paramTransitRouteLine.setData(paramBikingRouteLine);
      paramTransitRouteLine.addToMap();
      paramTransitRouteLine.zoomToSpan();
      return;
    } while (paramWalkingRouteLine == null);
    paramTransitRouteLine = new d(this.m);
    this.m.setOnMarkerClickListener(paramTransitRouteLine);
    this.h = paramTransitRouteLine;
    paramTransitRouteLine.setData(paramWalkingRouteLine);
    paramTransitRouteLine.addToMap();
    paramTransitRouteLine.zoomToSpan();
  }
  
  private void a(final View paramView)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { -paramView.getMeasuredHeight(), 0.0F });
    localObjectAnimator.setDuration(300L);
    localObjectAnimator.addListener(new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public void onAnimationEnd(Animator paramAnonymousAnimator) {}
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        paramView.setVisibility(0);
      }
    });
    localObjectAnimator.start();
  }
  
  private void a(MapPlanNode paramMapPlanNode, boolean paramBoolean)
  {
    if ((paramMapPlanNode == null) || (paramMapPlanNode.getLatlng() == null)) {
      return;
    }
    if ((this.n == null) || (this.n.getLatlng() == null))
    {
      this.n = paramMapPlanNode;
      this.mTvRouteStart.setText(paramMapPlanNode.getName());
    }
    for (;;)
    {
      i();
      return;
      if (paramBoolean)
      {
        this.n = paramMapPlanNode;
        this.mTvRouteStart.setText(paramMapPlanNode.getName());
      }
      else
      {
        this.o = paramMapPlanNode;
        this.mTvRouteEnd.setText(paramMapPlanNode.getName());
      }
    }
  }
  
  private void a(final boolean paramBoolean)
  {
    ResblockKeywordSearchDialog localResblockKeywordSearchDialog = ResblockKeywordSearchDialog.newInstance();
    localResblockKeywordSearchDialog.setOnSelectListener(new ResblockKeywordSearchDialog.b()
    {
      public void onSelect(MapPlanNode paramAnonymousMapPlanNode)
      {
        ResblockMapRouteActivity.a(ResblockMapRouteActivity.this, paramAnonymousMapPlanNode, paramBoolean);
      }
    });
    FragmentManager localFragmentManager = getSupportFragmentManager();
    if (!(localResblockKeywordSearchDialog instanceof DialogFragment))
    {
      localResblockKeywordSearchDialog.show(localFragmentManager, "keyword");
      return;
    }
    VdsAgent.showDialogFragment((DialogFragment)localResblockKeywordSearchDialog, localFragmentManager, "keyword");
  }
  
  private void b()
  {
    this.r.clear();
    new Thread(new Runnable()
    {
      public void run()
      {
        ResblockMapRouteActivity.a(ResblockMapRouteActivity.this, o.queryResblock(ResblockMapRouteActivity.this, 10));
        if ((ResblockMapRouteActivity.a(ResblockMapRouteActivity.this) == null) || (ResblockMapRouteActivity.a(ResblockMapRouteActivity.this).size() < 1))
        {
          ResblockMapRouteActivity.b(ResblockMapRouteActivity.this).sendEmptyMessage(1);
          return;
        }
        ResblockMapRouteActivity.b(ResblockMapRouteActivity.this).sendEmptyMessage(2);
      }
    }).start();
    this.mLvHistory.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousAdapterView = (MapPlanNode.MapRoute)paramAnonymousView.getTag();
        if ((paramAnonymousAdapterView == null) || (paramAnonymousAdapterView.getStartNode() == null) || (paramAnonymousAdapterView.getEndNode() == null)) {
          return;
        }
        ResblockMapRouteActivity.a(ResblockMapRouteActivity.this, paramAnonymousAdapterView.getStartNode());
        ResblockMapRouteActivity.b(ResblockMapRouteActivity.this, paramAnonymousAdapterView.getEndNode());
        ResblockMapRouteActivity.this.mTvRouteStart.setText(ResblockMapRouteActivity.c(ResblockMapRouteActivity.this).getName());
        ResblockMapRouteActivity.this.mTvRouteEnd.setText(ResblockMapRouteActivity.d(ResblockMapRouteActivity.this).getName());
        ResblockMapRouteActivity.e(ResblockMapRouteActivity.this);
        if (ResblockMapRouteActivity.c(ResblockMapRouteActivity.this).getLatlng().latitude == 0.0D) {
          ResblockMapRouteActivity.c(ResblockMapRouteActivity.this).setLatlng(new LatLng(ResblockMapRouteActivity.f(ResblockMapRouteActivity.this).getLatitude(), ResblockMapRouteActivity.f(ResblockMapRouteActivity.this).getLongitude()));
        }
        for (;;)
        {
          ResblockMapRouteActivity.a(ResblockMapRouteActivity.this, 21);
          ResblockMapRouteActivity.g(ResblockMapRouteActivity.this);
          ResblockMapRouteActivity.h(ResblockMapRouteActivity.this);
          ResblockMapRouteActivity.this.mRbTransit.setChecked(true);
          return;
          if (ResblockMapRouteActivity.d(ResblockMapRouteActivity.this).getLatlng().latitude == 0.0D) {
            ResblockMapRouteActivity.d(ResblockMapRouteActivity.this).setLatlng(new LatLng(ResblockMapRouteActivity.f(ResblockMapRouteActivity.this).getLatitude(), ResblockMapRouteActivity.f(ResblockMapRouteActivity.this).getLongitude()));
          }
        }
      }
    });
  }
  
  private void b(int paramInt)
  {
    if (5 == paramInt) {
      this.b.setHideable(true);
    }
    for (;;)
    {
      this.b.setState(paramInt);
      return;
      this.b.setHideable(false);
    }
  }
  
  private void b(final View paramView)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { 0.0F, -paramView.getMeasuredHeight() });
    localObjectAnimator.setDuration(300L);
    localObjectAnimator.addListener(new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        paramView.setVisibility(4);
      }
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    localObjectAnimator.start();
  }
  
  private void c()
  {
    this.m = this.mMapView.getMap();
    this.mMapView.showZoomControls(false);
    this.mMapView.showScaleControl(false);
    Object localObject = this.m.getUiSettings();
    ((UiSettings)localObject).setCompassEnabled(false);
    ((UiSettings)localObject).setOverlookingGesturesEnabled(false);
    ((UiSettings)localObject).setRotateGesturesEnabled(false);
    ((UiSettings)localObject).setScrollGesturesEnabled(true);
    this.u = new a(null);
    this.a = new LocationClient(this);
    this.a.registerLocationListener(this.u);
    localObject = new LocationClientOption();
    ((LocationClientOption)localObject).setOpenGps(true);
    ((LocationClientOption)localObject).setCoorType("bd09ll");
    ((LocationClientOption)localObject).setScanSpan(5000);
    ((LocationClientOption)localObject).setIsNeedAddress(true);
    this.a.setLocOption((LocationClientOption)localObject);
    this.a.start();
  }
  
  private void c(int paramInt)
  {
    int i1 = 0;
    if (i1 < this.mFlButtons.getChildCount())
    {
      if (i1 == paramInt) {
        this.mFlButtons.getChildAt(i1).setVisibility(0);
      }
      for (;;)
      {
        i1 += 1;
        break;
        this.mFlButtons.getChildAt(i1).setVisibility(4);
      }
    }
  }
  
  private String d(int paramInt)
  {
    if (paramInt < 60) {
      return "小于1分钟";
    }
    if ((paramInt >= 60) && (paramInt < 3600)) {
      return paramInt / 60 + "分钟";
    }
    return paramInt / 3600 + "小时" + paramInt % 3600 / 60 + "分钟";
  }
  
  private void d()
  {
    finish();
  }
  
  private String e(int paramInt)
  {
    if (paramInt > 1000)
    {
      DecimalFormat localDecimalFormat = new DecimalFormat(".0");
      return localDecimalFormat.format(paramInt / 1000.0F) + "公里";
    }
    return paramInt + "米";
  }
  
  private void e()
  {
    if ((this.t == null) || (this.t.getLatitude() == 0.0D) || (this.t.getLongitude() == 0.0D))
    {
      g.textToast(this, "定位失败，请检查定位设置！");
      return;
    }
    MapPlanNode localMapPlanNode = new MapPlanNode();
    localMapPlanNode.setName("我的位置");
    localMapPlanNode.setLatlng(new LatLng(0.0D, 0.0D));
    if ((this.n == null) || (this.n.getLatlng() == null))
    {
      this.n = localMapPlanNode;
      this.mTvRouteStart.setText("我的位置");
    }
    for (;;)
    {
      new Thread(new Runnable()
      {
        public void run()
        {
          o.sava(ResblockMapRouteActivity.this, ResblockMapRouteActivity.c(ResblockMapRouteActivity.this), ResblockMapRouteActivity.d(ResblockMapRouteActivity.this));
        }
      }).start();
      localMapPlanNode.setLatlng(new LatLng(this.t.getLatitude(), this.t.getLongitude()));
      a(21);
      k();
      l();
      this.mRbTransit.setChecked(true);
      return;
      this.o = localMapPlanNode;
      this.mTvRouteEnd.setText("我的位置");
    }
  }
  
  private void f()
  {
    ResblockKeywordSearchDialog localResblockKeywordSearchDialog = ResblockKeywordSearchDialog.newInstance();
    localResblockKeywordSearchDialog.setOnSelectListener(new ResblockKeywordSearchDialog.b()
    {
      public void onSelect(MapPlanNode paramAnonymousMapPlanNode)
      {
        if (paramAnonymousMapPlanNode == null) {
          return;
        }
        ad.setResblockMapCompany(ResblockMapRouteActivity.this, paramAnonymousMapPlanNode);
        ResblockMapRouteActivity.this.mTvCompanyAddress.setText(paramAnonymousMapPlanNode.getName());
        ResblockMapRouteActivity.this.mTvCompanyAddress.setTag(paramAnonymousMapPlanNode);
        ResblockMapRouteActivity.c(ResblockMapRouteActivity.this, paramAnonymousMapPlanNode);
      }
    });
    FragmentManager localFragmentManager = getSupportFragmentManager();
    if (!(localResblockKeywordSearchDialog instanceof DialogFragment))
    {
      localResblockKeywordSearchDialog.show(localFragmentManager, "keyword");
      return;
    }
    VdsAgent.showDialogFragment((DialogFragment)localResblockKeywordSearchDialog, localFragmentManager, "keyword");
  }
  
  private void g()
  {
    MapPlanNode localMapPlanNode = this.n;
    this.n = this.o;
    this.o = localMapPlanNode;
    this.mTvRouteStart.setText(this.n.getName());
    this.mTvRouteEnd.setText(this.o.getName());
    if ((this.n != null) && (this.n.getLatlng() != null) && (this.o != null) && (this.o.getLatlng() != null)) {
      i();
    }
  }
  
  private void h()
  {
    this.b.setState(4);
  }
  
  private void i()
  {
    if ((this.n == null) || (this.n.getLatlng() == null) || (this.o == null) || (this.o.getLatlng() == null)) {
      return;
    }
    j();
    a(21);
    k();
    l();
    this.mRbTransit.setChecked(true);
  }
  
  private void j()
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        o.sava(ResblockMapRouteActivity.this, ResblockMapRouteActivity.c(ResblockMapRouteActivity.this), ResblockMapRouteActivity.d(ResblockMapRouteActivity.this));
      }
    }).start();
  }
  
  private void k()
  {
    this.k = PlanNode.withLocation(this.n.getLatlng());
    this.l = PlanNode.withLocation(this.o.getLatlng());
    this.mRgType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
    {
      @Instrumented
      public void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
      {
        VdsAgent.onCheckedChanged(this, paramAnonymousRadioGroup, paramAnonymousInt);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          ResblockMapRouteActivity.h(ResblockMapRouteActivity.this);
          return;
          ResblockMapRouteActivity.b(ResblockMapRouteActivity.this, 1);
          ResblockMapRouteActivity.c(ResblockMapRouteActivity.this, 0);
          continue;
          ResblockMapRouteActivity.b(ResblockMapRouteActivity.this, 2);
          ResblockMapRouteActivity.c(ResblockMapRouteActivity.this, 1);
          continue;
          ResblockMapRouteActivity.b(ResblockMapRouteActivity.this, 3);
          ResblockMapRouteActivity.c(ResblockMapRouteActivity.this, 2);
          continue;
          ResblockMapRouteActivity.b(ResblockMapRouteActivity.this, 4);
          ResblockMapRouteActivity.c(ResblockMapRouteActivity.this, 3);
        }
      }
    });
  }
  
  private void l()
  {
    if (this.i == null)
    {
      this.i = new b(new c()
      {
        public void onRouteSeleced(int paramAnonymousInt, TransitRouteLine paramAnonymousTransitRouteLine, DrivingRouteLine paramAnonymousDrivingRouteLine, BikingRouteLine paramAnonymousBikingRouteLine, WalkingRouteLine paramAnonymousWalkingRouteLine)
        {
          ResblockMapRouteActivity.a(ResblockMapRouteActivity.this, paramAnonymousInt, paramAnonymousTransitRouteLine, paramAnonymousDrivingRouteLine, paramAnonymousBikingRouteLine, paramAnonymousWalkingRouteLine);
        }
      });
      this.mLvRoute.setAdapter(this.i);
    }
    for (;;)
    {
      if (this.c == null)
      {
        this.c = RoutePlanSearch.newInstance();
        this.c.setOnGetRoutePlanResultListener(this.w);
      }
      if ((this.k != null) && (this.l != null)) {
        this.m.clear();
      }
      switch (this.j)
      {
      default: 
        return;
        this.i.notifyDataSetChanged();
      }
    }
    this.c.transitSearch(new TransitRoutePlanOption().city(com.ziroom.ziroomcustomer.base.b.c + "市").from(this.k).to(this.l));
    return;
    this.c.drivingSearch(new DrivingRoutePlanOption().from(this.k).to(this.l));
    return;
    this.c.bikingSearch(new BikingRoutePlanOption().from(this.k).to(this.l));
    return;
    this.c.walkingSearch(new WalkingRoutePlanOption().from(this.k).to(this.l));
  }
  
  public void onBackPressed()
  {
    d();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903459);
    ButterKnife.bind(this);
    a();
  }
  
  protected void onDestroy()
  {
    if (this.c != null) {
      this.c.destroy();
    }
    if (this.mMapView != null) {
      this.mMapView.onDestroy();
    }
    this.a = null;
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    this.mMapView.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.mMapView.onResume();
  }
  
  @OnClick({2131691586, 2131689492, 2131691587, 2131691589, 2131691590, 2131693164, 2131696450, 2131696451})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131691586: 
      d();
      return;
    case 2131689492: 
      d();
      return;
    case 2131691587: 
      g();
      return;
    case 2131691589: 
      a(true);
      return;
    case 2131691590: 
      a(false);
      return;
    case 2131693164: 
      if (this.p == null)
      {
        f();
        return;
      }
      a(this.p, false);
      return;
    case 2131696450: 
      f();
      return;
    }
    e();
  }
  
  private class a
    implements BDLocationListener
  {
    private a() {}
    
    public void onReceiveLocation(BDLocation paramBDLocation)
    {
      VdsAgent.onReceiveLocation(this, paramBDLocation);
      if (ResblockMapRouteActivity.this.isFinishing()) {}
      while (paramBDLocation == null) {
        return;
      }
      ResblockMapRouteActivity.a(ResblockMapRouteActivity.this, paramBDLocation);
      ResblockMapRouteActivity.this.a.stop();
    }
  }
  
  private class b
    extends BaseAdapter
  {
    private int b;
    private ResblockMapRouteActivity.c c;
    private int d = Color.parseColor("#ffa000");
    private int e = Color.parseColor("#999999");
    private int f = Color.parseColor("#444444");
    
    public b(ResblockMapRouteActivity.c paramc)
    {
      this.c = paramc;
    }
    
    public int getCount()
    {
      switch (ResblockMapRouteActivity.k(ResblockMapRouteActivity.this))
      {
      }
      do
      {
        do
        {
          do
          {
            do
            {
              return 0;
            } while (ResblockMapRouteActivity.m(ResblockMapRouteActivity.this) == null);
            return ResblockMapRouteActivity.m(ResblockMapRouteActivity.this).size();
          } while (ResblockMapRouteActivity.n(ResblockMapRouteActivity.this) == null);
          return ResblockMapRouteActivity.n(ResblockMapRouteActivity.this).size();
        } while (ResblockMapRouteActivity.o(ResblockMapRouteActivity.this) == null);
        return ResblockMapRouteActivity.o(ResblockMapRouteActivity.this).size();
      } while (ResblockMapRouteActivity.p(ResblockMapRouteActivity.this) == null);
      return ResblockMapRouteActivity.p(ResblockMapRouteActivity.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      switch (ResblockMapRouteActivity.k(ResblockMapRouteActivity.this))
      {
      default: 
        return null;
      case 1: 
        return ResblockMapRouteActivity.m(ResblockMapRouteActivity.this).get(paramInt);
      case 2: 
        return ResblockMapRouteActivity.n(ResblockMapRouteActivity.this).get(paramInt);
      case 3: 
        return ResblockMapRouteActivity.o(ResblockMapRouteActivity.this).get(paramInt);
      }
      return ResblockMapRouteActivity.p(ResblockMapRouteActivity.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return ResblockMapRouteActivity.k(ResblockMapRouteActivity.this) << paramInt + 16;
    }
    
    public View getView(final int paramInt, View paramView, final ViewGroup paramViewGroup)
    {
      View localView;
      StringBuilder localStringBuilder;
      if (paramView == null)
      {
        localView = LayoutInflater.from(ResblockMapRouteActivity.this).inflate(2130904233, paramViewGroup, false);
        paramViewGroup = new a(null);
        paramViewGroup.a = ((CheckBox)localView.findViewById(2131694828));
        paramViewGroup.b = ((TextView)localView.findViewById(2131695069));
        paramViewGroup.c = ((TextView)localView.findViewById(2131690073));
        localView.setTag(paramViewGroup);
        localStringBuilder = new StringBuilder("");
        paramView = "";
        switch (ResblockMapRouteActivity.k(ResblockMapRouteActivity.this))
        {
        }
      }
      Object localObject1;
      for (;;)
      {
        if (!TextUtils.isEmpty(localStringBuilder))
        {
          localObject1 = new SpannableString(localStringBuilder);
          int i = 0;
          Object localObject2;
          for (;;)
          {
            i = localStringBuilder.indexOf("#arrow#", i);
            if (i <= 0) {
              break;
            }
            localObject2 = ResblockMapRouteActivity.this.getResources().getDrawable(2130840362);
            ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
            ((SpannableString)localObject1).setSpan(new ImageSpan((Drawable)localObject2, 1)
            {
              public void draw(Canvas paramAnonymousCanvas, CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, float paramAnonymousFloat, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, Paint paramAnonymousPaint)
              {
                Drawable localDrawable = getDrawable();
                paramAnonymousCanvas.save();
                int i = (int)(paramAnonymousInt5 - localDrawable.getBounds().bottom - paramViewGroup.b.getLineSpacingExtra());
                u.d("tag", "====start:" + paramAnonymousInt1 + ",end:" + paramAnonymousInt2 + ",x:" + paramAnonymousFloat + ",y:" + paramAnonymousInt4 + ",top:" + paramAnonymousInt3 + ",bottom:" + paramAnonymousInt5);
                u.d("tag", "====transY:" + i + ",b.getBounds().bottom:" + localDrawable.getBounds().bottom + ",finalVh.tvRoute.getLineSpacingExtra():" + paramViewGroup.b.getLineSpacingExtra());
                paramAnonymousInt2 = i;
                if (this.mVerticalAlignment == 1)
                {
                  paramAnonymousInt3 = paramAnonymousCharSequence.length();
                  paramAnonymousInt1 = 0;
                }
                for (;;)
                {
                  paramAnonymousInt2 = i;
                  if (paramAnonymousInt1 < paramAnonymousInt3)
                  {
                    if (Character.isLetterOrDigit(paramAnonymousCharSequence.charAt(paramAnonymousInt1))) {
                      paramAnonymousInt2 = i - paramAnonymousPaint.getFontMetricsInt().descent;
                    }
                  }
                  else
                  {
                    paramAnonymousCanvas.translate(paramAnonymousFloat, paramAnonymousInt2 + (int)(ResblockMapRouteActivity.this.getResources().getDisplayMetrics().density * 3.0F));
                    localDrawable.draw(paramAnonymousCanvas);
                    paramAnonymousCanvas.restore();
                    return;
                  }
                  paramAnonymousInt1 += 1;
                }
              }
            }, i, i + 7, 33);
            i += 6;
          }
          paramViewGroup = (a)paramView.getTag();
          localView = paramView;
          break;
          paramView = (TransitRouteLine)getItem(paramInt);
          localObject1 = paramView.getAllStep();
          int j = 0;
          int m = 0;
          i = 0;
          int k = 0;
          while (k < ((List)localObject1).size())
          {
            localObject2 = (TransitRouteLine.TransitStep)((List)localObject1).get(k);
            if (((TransitRouteLine.TransitStep)localObject2).getStepType() == TransitRouteLine.TransitStep.TransitRouteStepType.WAKLING)
            {
              j += ((TransitRouteLine.TransitStep)localObject2).getDistance();
              k += 1;
            }
            else
            {
              m += ((TransitRouteLine.TransitStep)localObject2).getVehicleInfo().getZonePrice();
              if (i != 0) {
                localStringBuilder.append("#arrow#");
              }
              for (;;)
              {
                localStringBuilder.append(((TransitRouteLine.TransitStep)localObject2).getVehicleInfo().getTitle());
                break;
                i = 1;
              }
            }
          }
          paramView = "约" + ResblockMapRouteActivity.d(ResblockMapRouteActivity.this, paramView.getDuration()) + "，约步行" + ResblockMapRouteActivity.e(ResblockMapRouteActivity.this, j);
          continue;
          paramView = (DrivingRouteLine)getItem(paramInt);
          localStringBuilder.append("方案" + (paramInt + 1));
          paramView = "行驶距离" + ResblockMapRouteActivity.e(ResblockMapRouteActivity.this, paramView.getDistance()) + "，大约需要" + ResblockMapRouteActivity.d(ResblockMapRouteActivity.this, paramView.getDuration()) + "，路过" + paramView.getLightNum() + "个红绿灯";
          continue;
          paramView = (BikingRouteLine)getItem(paramInt);
          localStringBuilder.append("方案" + (paramInt + 1));
          paramView = "距离" + ResblockMapRouteActivity.e(ResblockMapRouteActivity.this, paramView.getDistance()) + "，骑行大约需要" + ResblockMapRouteActivity.d(ResblockMapRouteActivity.this, paramView.getDuration());
          continue;
          paramView = (WalkingRouteLine)getItem(paramInt);
          localStringBuilder.append("方案" + (paramInt + 1));
          paramView = "距离" + ResblockMapRouteActivity.e(ResblockMapRouteActivity.this, paramView.getDistance()) + "，步行大约需要" + ResblockMapRouteActivity.d(ResblockMapRouteActivity.this, paramView.getDuration());
          continue;
          if (this.b != paramInt) {
            break label787;
          }
          paramViewGroup.b.setTextColor(this.d);
          paramViewGroup.c.setTextColor(this.f);
          paramViewGroup.a.setChecked(true);
        }
      }
      for (;;)
      {
        paramViewGroup.b.setText((CharSequence)localObject1);
        paramViewGroup.c.setText(paramView);
        localView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (ResblockMapRouteActivity.b.a(ResblockMapRouteActivity.b.this) != null) {
              switch (ResblockMapRouteActivity.k(ResblockMapRouteActivity.this))
              {
              }
            }
            for (;;)
            {
              ResblockMapRouteActivity.b.a(ResblockMapRouteActivity.b.this, paramInt);
              ResblockMapRouteActivity.b.this.notifyDataSetChanged();
              return;
              ResblockMapRouteActivity.b.a(ResblockMapRouteActivity.b.this).onRouteSeleced(1, (TransitRouteLine)ResblockMapRouteActivity.b.this.getItem(paramInt), null, null, null);
              continue;
              ResblockMapRouteActivity.b.a(ResblockMapRouteActivity.b.this).onRouteSeleced(2, null, (DrivingRouteLine)ResblockMapRouteActivity.b.this.getItem(paramInt), null, null);
              continue;
              ResblockMapRouteActivity.b.a(ResblockMapRouteActivity.b.this).onRouteSeleced(3, null, null, (BikingRouteLine)ResblockMapRouteActivity.b.this.getItem(paramInt), null);
              continue;
              ResblockMapRouteActivity.b.a(ResblockMapRouteActivity.b.this).onRouteSeleced(4, null, null, null, (WalkingRouteLine)ResblockMapRouteActivity.b.this.getItem(paramInt));
            }
          }
        });
        return localView;
        label787:
        paramViewGroup.b.setTextColor(this.e);
        paramViewGroup.c.setTextColor(this.e);
        paramViewGroup.a.setChecked(false);
      }
    }
    
    public void selectItem(int paramInt)
    {
      this.b = paramInt;
      notifyDataSetChanged();
      ResblockMapRouteActivity.this.mLvRoute.setEmptyView(ResblockMapRouteActivity.this.mTvEmpty);
    }
    
    private class a
    {
      CheckBox a;
      TextView b;
      TextView c;
      
      private a() {}
    }
  }
  
  public static abstract interface c
  {
    public abstract void onRouteSeleced(int paramInt, TransitRouteLine paramTransitRouteLine, DrivingRouteLine paramDrivingRouteLine, BikingRouteLine paramBikingRouteLine, WalkingRouteLine paramWalkingRouteLine);
  }
  
  private class d
    extends com.ziroom.ziroomcustomer.util.b.b
  {
    private RouteLine<RouteStep> b = null;
    
    public d(BaiduMap paramBaiduMap)
    {
      super();
    }
    
    public List<OverlayOptions> getOverlayOptions()
    {
      if (this.b == null) {
        return null;
      }
      ArrayList localArrayList1 = new ArrayList();
      if (this.b.getStarting() != null) {
        localArrayList1.add(new MarkerOptions().position(this.b.getStarting().getLocation()).icon(BitmapDescriptorFactory.fromResource(2130840344)).zIndex(10));
      }
      if (this.b.getTerminal() != null) {
        localArrayList1.add(new MarkerOptions().position(this.b.getTerminal().getLocation()).icon(BitmapDescriptorFactory.fromResource(2130840216)).zIndex(10));
      }
      if ((this.b.getAllStep() != null) && (this.b.getAllStep().size() > 0)) {}
      for (;;)
      {
        try
        {
          Iterator localIterator = this.b.getAllStep().iterator();
          Object localObject = null;
          if (localIterator.hasNext())
          {
            List localList = ((RouteStep)localIterator.next()).getWayPoints();
            if ((localList != null) && (localList.size() > 0))
            {
              ArrayList localArrayList2 = new ArrayList();
              if (localObject != null) {
                localArrayList2.add(localObject);
              }
              localArrayList2.addAll(localList);
              if (localArrayList2.size() > 1) {
                localArrayList1.add(new PolylineOptions().points(localArrayList2).width(10).color(Color.parseColor("#018eff")).zIndex(0));
              }
              localObject = (LatLng)localList.get(localList.size() - 1);
            }
          }
          else
          {
            return localArrayList1;
          }
        }
        catch (Exception localException)
        {
          return null;
        }
      }
    }
    
    public boolean onMarkerClick(Marker paramMarker)
    {
      return false;
    }
    
    public boolean onPolylineClick(Polyline paramPolyline)
    {
      return false;
    }
    
    public void setData(RouteLine paramRouteLine)
    {
      this.b = paramRouteLine;
    }
    
    public void zoomToSpan()
    {
      if ((ResblockMapRouteActivity.l(ResblockMapRouteActivity.this) == null) || (this.b == null) || (this.b.getStarting() == null) || (this.b.getTerminal() == null)) {
        return;
      }
      double d3 = Math.max(this.b.getStarting().getLocation().latitude, this.b.getTerminal().getLocation().latitude);
      double d1 = Math.min(this.b.getStarting().getLocation().latitude, this.b.getTerminal().getLocation().latitude);
      double d5 = Math.max(this.b.getStarting().getLocation().longitude, this.b.getTerminal().getLocation().longitude);
      double d2 = Math.min(this.b.getStarting().getLocation().longitude, this.b.getTerminal().getLocation().longitude);
      d3 += (d3 - d1) / 8.0D;
      double d4 = (d3 - d1) / 4.0D;
      d5 += (d5 - d2) / 8.0D;
      double d6 = (d5 - d2) / 8.0D;
      LatLngBounds localLatLngBounds = new LatLngBounds.Builder().include(new LatLng(d3, d5)).include(new LatLng(d1 - d4, d2 - d6)).build();
      ResblockMapRouteActivity.l(ResblockMapRouteActivity.this).setMapStatus(MapStatusUpdateFactory.newLatLngBounds(localLatLngBounds));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/view/ResblockMapRouteActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */