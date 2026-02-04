package com.google.android.gms.common.images;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.util.LruCache;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.images.zza;
import com.google.android.gms.internal.zzmd;
import com.google.android.gms.internal.zzne;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public final class ImageManager {
    private static ImageManager zzajB;
    private static ImageManager zzajC;
    private final Context mContext;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final ExecutorService zzajD = Executors.newFixedThreadPool(4);
    private final zzb zzajE;
    private final zzmd zzajF;
    private final Map zzajG;
    private final Map zzajH;
    private final Map zzajI;
    private static final Object zzajz = new Object();
    private static HashSet zzajA = new HashSet();

    @KeepName
    final class ImageReceiver extends ResultReceiver {
        private final Uri mUri;
        private final ArrayList zzajJ;

        ImageReceiver(Uri uri) {
            super(new Handler(Looper.getMainLooper()));
            this.mUri = uri;
            this.zzajJ = new ArrayList();
        }

        @Override // android.os.ResultReceiver
        public final void onReceiveResult(int i, Bundle bundle) {
            ImageManager.this.zzajD.execute(ImageManager.this.new zzc(this.mUri, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }

        public final void zzb(com.google.android.gms.common.images.zza zzaVar) {
            com.google.android.gms.common.internal.zzb.zzcD("ImageReceiver.addImageRequest() must be called in the main thread");
            this.zzajJ.add(zzaVar);
        }

        public final void zzc(com.google.android.gms.common.images.zza zzaVar) {
            com.google.android.gms.common.internal.zzb.zzcD("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.zzajJ.remove(zzaVar);
        }

        public final void zzqm() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            ImageManager.this.mContext.sendBroadcast(intent);
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    @TargetApi(11)
    final class zza {
        static int zza(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    final class zzb extends LruCache {
        public zzb(Context context) {
            super(zzas(context));
        }

        @TargetApi(11)
        private static int zzas(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            return (int) (((((context.getApplicationInfo().flags & 1048576) != 0) && zzne.zzsd()) ? zza.zza(activityManager) : activityManager.getMemoryClass()) * 1048576 * 0.33f);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v4.util.LruCache
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public final int sizeOf(zza.C0038zza c0038zza, Bitmap bitmap) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v4.util.LruCache
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public final void entryRemoved(boolean z, zza.C0038zza c0038zza, Bitmap bitmap, Bitmap bitmap2) {
            super.entryRemoved(z, c0038zza, bitmap, bitmap2);
        }
    }

    final class zzc implements Runnable {
        private final Uri mUri;
        private final ParcelFileDescriptor zzajL;

        public zzc(Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.mUri = uri;
            this.zzajL = parcelFileDescriptor;
        }

        @Override // java.lang.Runnable
        public final void run() throws InterruptedException, IOException {
            com.google.android.gms.common.internal.zzb.zzcE("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            boolean z = false;
            Bitmap bitmapDecodeFileDescriptor = null;
            if (this.zzajL != null) {
                try {
                    bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(this.zzajL.getFileDescriptor());
                } catch (OutOfMemoryError e) {
                    Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.mUri, e);
                    z = true;
                }
                try {
                    this.zzajL.close();
                } catch (IOException e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ImageManager.this.mHandler.post(ImageManager.this.new zzf(this.mUri, bitmapDecodeFileDescriptor, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e3) {
                Log.w("ImageManager", "Latch interrupted while posting " + this.mUri);
            }
        }
    }

    final class zzd implements Runnable {
        private final com.google.android.gms.common.images.zza zzajM;

        public zzd(com.google.android.gms.common.images.zza zzaVar) {
            this.zzajM = zzaVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.google.android.gms.common.internal.zzb.zzcD("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.zzajG.get(this.zzajM);
            if (imageReceiver != null) {
                ImageManager.this.zzajG.remove(this.zzajM);
                imageReceiver.zzc(this.zzajM);
            }
            zza.C0038zza c0038zza = this.zzajM.zzajO;
            if (c0038zza.uri == null) {
                this.zzajM.zza(ImageManager.this.mContext, ImageManager.this.zzajF, true);
                return;
            }
            Bitmap bitmapZza = ImageManager.this.zza(c0038zza);
            if (bitmapZza != null) {
                this.zzajM.zza(ImageManager.this.mContext, bitmapZza, true);
                return;
            }
            Long l = (Long) ImageManager.this.zzajI.get(c0038zza.uri);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                    this.zzajM.zza(ImageManager.this.mContext, ImageManager.this.zzajF, true);
                    return;
                }
                ImageManager.this.zzajI.remove(c0038zza.uri);
            }
            this.zzajM.zza(ImageManager.this.mContext, ImageManager.this.zzajF);
            ImageReceiver imageReceiver2 = (ImageReceiver) ImageManager.this.zzajH.get(c0038zza.uri);
            if (imageReceiver2 == null) {
                imageReceiver2 = ImageManager.this.new ImageReceiver(c0038zza.uri);
                ImageManager.this.zzajH.put(c0038zza.uri, imageReceiver2);
            }
            imageReceiver2.zzb(this.zzajM);
            if (!(this.zzajM instanceof zza.zzc)) {
                ImageManager.this.zzajG.put(this.zzajM, imageReceiver2);
            }
            synchronized (ImageManager.zzajz) {
                if (!ImageManager.zzajA.contains(c0038zza.uri)) {
                    ImageManager.zzajA.add(c0038zza.uri);
                    imageReceiver2.zzqm();
                }
            }
        }
    }

    @TargetApi(14)
    final class zze implements ComponentCallbacks2 {
        private final zzb zzajE;

        public zze(zzb zzbVar) {
            this.zzajE = zzbVar;
        }

        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration configuration) {
        }

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
            this.zzajE.evictAll();
        }

        @Override // android.content.ComponentCallbacks2
        public final void onTrimMemory(int i) {
            if (i >= 60) {
                this.zzajE.evictAll();
            } else if (i >= 20) {
                this.zzajE.trimToSize(this.zzajE.size() / 2);
            }
        }
    }

    final class zzf implements Runnable {
        private final Bitmap mBitmap;
        private final Uri mUri;
        private boolean zzajN;
        private final CountDownLatch zzpJ;

        public zzf(Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.mUri = uri;
            this.mBitmap = bitmap;
            this.zzajN = z;
            this.zzpJ = countDownLatch;
        }

        private void zza(ImageReceiver imageReceiver, boolean z) {
            ArrayList arrayList = imageReceiver.zzajJ;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                com.google.android.gms.common.images.zza zzaVar = (com.google.android.gms.common.images.zza) arrayList.get(i);
                if (z) {
                    zzaVar.zza(ImageManager.this.mContext, this.mBitmap, false);
                } else {
                    ImageManager.this.zzajI.put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                    zzaVar.zza(ImageManager.this.mContext, ImageManager.this.zzajF, false);
                }
                if (!(zzaVar instanceof zza.zzc)) {
                    ImageManager.this.zzajG.remove(zzaVar);
                }
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.google.android.gms.common.internal.zzb.zzcD("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.mBitmap != null;
            if (ImageManager.this.zzajE != null) {
                if (this.zzajN) {
                    ImageManager.this.zzajE.evictAll();
                    System.gc();
                    this.zzajN = false;
                    ImageManager.this.mHandler.post(this);
                    return;
                }
                if (z) {
                    ImageManager.this.zzajE.put(new zza.C0038zza(this.mUri), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.zzajH.remove(this.mUri);
            if (imageReceiver != null) {
                zza(imageReceiver, z);
            }
            this.zzpJ.countDown();
            synchronized (ImageManager.zzajz) {
                ImageManager.zzajA.remove(this.mUri);
            }
        }
    }

    private ImageManager(Context context, boolean z) {
        this.mContext = context.getApplicationContext();
        if (z) {
            this.zzajE = new zzb(this.mContext);
            if (zzne.zzsg()) {
                zzqj();
            }
        } else {
            this.zzajE = null;
        }
        this.zzajF = new zzmd();
        this.zzajG = new HashMap();
        this.zzajH = new HashMap();
        this.zzajI = new HashMap();
    }

    public static ImageManager create(Context context) {
        return zzc(context, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap zza(zza.C0038zza c0038zza) {
        if (this.zzajE == null) {
            return null;
        }
        return (Bitmap) this.zzajE.get(c0038zza);
    }

    public static ImageManager zzc(Context context, boolean z) {
        if (z) {
            if (zzajC == null) {
                zzajC = new ImageManager(context, true);
            }
            return zzajC;
        }
        if (zzajB == null) {
            zzajB = new ImageManager(context, false);
        }
        return zzajB;
    }

    @TargetApi(14)
    private void zzqj() {
        this.mContext.registerComponentCallbacks(new zze(this.zzajE));
    }

    public final void loadImage(ImageView imageView, int i) {
        zza(new zza.zzb(imageView, i));
    }

    public final void loadImage(ImageView imageView, Uri uri) {
        zza(new zza.zzb(imageView, uri));
    }

    public final void loadImage(ImageView imageView, Uri uri, int i) {
        zza.zzb zzbVar = new zza.zzb(imageView, uri);
        zzbVar.zzbM(i);
        zza(zzbVar);
    }

    public final void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri) {
        zza(new zza.zzc(onImageLoadedListener, uri));
    }

    public final void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri, int i) {
        zza.zzc zzcVar = new zza.zzc(onImageLoadedListener, uri);
        zzcVar.zzbM(i);
        zza(zzcVar);
    }

    public final void zza(com.google.android.gms.common.images.zza zzaVar) {
        com.google.android.gms.common.internal.zzb.zzcD("ImageManager.loadImage() must be called in the main thread");
        new zzd(zzaVar).run();
    }
}
