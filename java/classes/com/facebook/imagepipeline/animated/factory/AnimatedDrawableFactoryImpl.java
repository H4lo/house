package com.facebook.imagepipeline.animated.factory;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.facebook.common.time.MonotonicClock;
import com.facebook.imagepipeline.animated.base.AnimatedDrawable;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableOptions;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableCachingBackendImplProvider;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableDiagnosticsImpl;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableDiagnosticsNoop;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.concurrent.ScheduledExecutorService;

public class AnimatedDrawableFactoryImpl
  implements AnimatedDrawableFactory
{
  private final AnimatedDrawableBackendProvider mAnimatedDrawableBackendProvider;
  private final AnimatedDrawableCachingBackendImplProvider mAnimatedDrawableCachingBackendProvider;
  private final AnimatedDrawableUtil mAnimatedDrawableUtil;
  private final MonotonicClock mMonotonicClock;
  private final Resources mResources;
  private final ScheduledExecutorService mScheduledExecutorServiceForUiThread;
  
  public AnimatedDrawableFactoryImpl(AnimatedDrawableBackendProvider paramAnimatedDrawableBackendProvider, AnimatedDrawableCachingBackendImplProvider paramAnimatedDrawableCachingBackendImplProvider, AnimatedDrawableUtil paramAnimatedDrawableUtil, ScheduledExecutorService paramScheduledExecutorService, Resources paramResources)
  {
    this.mAnimatedDrawableBackendProvider = paramAnimatedDrawableBackendProvider;
    this.mAnimatedDrawableCachingBackendProvider = paramAnimatedDrawableCachingBackendImplProvider;
    this.mAnimatedDrawableUtil = paramAnimatedDrawableUtil;
    this.mScheduledExecutorServiceForUiThread = paramScheduledExecutorService;
    this.mMonotonicClock = new MonotonicClock()
    {
      public long now()
      {
        return SystemClock.uptimeMillis();
      }
    };
    this.mResources = paramResources;
  }
  
  private AnimatedDrawable create(AnimatedImageResult paramAnimatedImageResult, AnimatedDrawableOptions paramAnimatedDrawableOptions)
  {
    Object localObject = paramAnimatedImageResult.getImage();
    localObject = new Rect(0, 0, ((AnimatedImage)localObject).getWidth(), ((AnimatedImage)localObject).getHeight());
    return createAnimatedDrawable(paramAnimatedDrawableOptions, this.mAnimatedDrawableBackendProvider.get(paramAnimatedImageResult, (Rect)localObject));
  }
  
  private AnimatedDrawable createAnimatedDrawable(AnimatedDrawableOptions paramAnimatedDrawableOptions, AnimatedDrawableBackend paramAnimatedDrawableBackend)
  {
    DisplayMetrics localDisplayMetrics = this.mResources.getDisplayMetrics();
    paramAnimatedDrawableBackend = this.mAnimatedDrawableCachingBackendProvider.get(paramAnimatedDrawableBackend, paramAnimatedDrawableOptions);
    if (paramAnimatedDrawableOptions.enableDebugging) {}
    for (paramAnimatedDrawableOptions = new AnimatedDrawableDiagnosticsImpl(this.mAnimatedDrawableUtil, localDisplayMetrics);; paramAnimatedDrawableOptions = AnimatedDrawableDiagnosticsNoop.getInstance()) {
      return new AnimatedDrawable(this.mScheduledExecutorServiceForUiThread, paramAnimatedDrawableBackend, paramAnimatedDrawableOptions, this.mMonotonicClock);
    }
  }
  
  private AnimatedImageResult getImageIfCloseableAnimatedImage(CloseableImage paramCloseableImage)
  {
    if ((paramCloseableImage instanceof CloseableAnimatedImage)) {
      return ((CloseableAnimatedImage)paramCloseableImage).getImageResult();
    }
    return null;
  }
  
  public Drawable create(CloseableImage paramCloseableImage)
  {
    if ((paramCloseableImage instanceof CloseableAnimatedImage)) {
      return create(((CloseableAnimatedImage)paramCloseableImage).getImageResult(), AnimatedDrawableOptions.DEFAULTS);
    }
    throw new UnsupportedOperationException("Unrecognized image class: " + paramCloseableImage);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/animated/factory/AnimatedDrawableFactoryImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */