package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzma;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzmc;
import com.google.android.gms.internal.zzmd;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public abstract class zza {
    final C0038zza zzajO;
    protected int zzajQ;
    protected ImageManager.OnImageLoadedListener zzajS;
    protected int zzajW;
    protected int zzajP = 0;
    protected boolean zzajR = false;
    private boolean zzajT = true;
    private boolean zzajU = false;
    private boolean zzajV = true;

    /* renamed from: com.google.android.gms.common.images.zza$zza, reason: collision with other inner class name */
    final class C0038zza {
        public final Uri uri;

        public C0038zza(Uri uri) {
            this.uri = uri;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof C0038zza)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return zzw.equal(((C0038zza) obj).uri, this.uri);
        }

        public final int hashCode() {
            return zzw.hashCode(this.uri);
        }
    }

    public final class zzb extends zza {
        private WeakReference zzajX;

        public zzb(ImageView imageView, int i) {
            super(null, i);
            com.google.android.gms.common.internal.zzb.zzv(imageView);
            this.zzajX = new WeakReference(imageView);
        }

        public zzb(ImageView imageView, Uri uri) {
            super(uri, 0);
            com.google.android.gms.common.internal.zzb.zzv(imageView);
            this.zzajX = new WeakReference(imageView);
        }

        private void zza(ImageView imageView, Drawable drawable, boolean z, boolean z2, boolean z3) {
            boolean z4 = (z2 || z3) ? false : true;
            if (z4 && (imageView instanceof zzmc)) {
                int iZzqp = ((zzmc) imageView).zzqp();
                if (this.zzajQ != 0 && iZzqp == this.zzajQ) {
                    return;
                }
            }
            boolean zZzb = zzb(z, z2);
            Drawable drawableNewDrawable = (!this.zzajR || drawable == null) ? drawable : drawable.getConstantState().newDrawable();
            if (zZzb) {
                drawableNewDrawable = zza(imageView.getDrawable(), drawableNewDrawable);
            }
            imageView.setImageDrawable(drawableNewDrawable);
            if (imageView instanceof zzmc) {
                zzmc zzmcVar = (zzmc) imageView;
                zzmcVar.zzm(z3 ? this.zzajO.uri : null);
                zzmcVar.zzbO(z4 ? this.zzajQ : 0);
            }
            if (zZzb) {
                ((zzma) drawableNewDrawable).startTransition(250);
            }
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zzb)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ImageView imageView = (ImageView) this.zzajX.get();
            ImageView imageView2 = (ImageView) ((zzb) obj).zzajX.get();
            return (imageView2 == null || imageView == null || !zzw.equal(imageView2, imageView)) ? false : true;
        }

        public final int hashCode() {
            return 0;
        }

        @Override // com.google.android.gms.common.images.zza
        protected final void zza(Drawable drawable, boolean z, boolean z2, boolean z3) {
            ImageView imageView = (ImageView) this.zzajX.get();
            if (imageView != null) {
                zza(imageView, drawable, z, z2, z3);
            }
        }
    }

    public final class zzc extends zza {
        private WeakReference zzajY;

        public zzc(ImageManager.OnImageLoadedListener onImageLoadedListener, Uri uri) {
            super(uri, 0);
            com.google.android.gms.common.internal.zzb.zzv(onImageLoadedListener);
            this.zzajY = new WeakReference(onImageLoadedListener);
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zzc)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzc zzcVar = (zzc) obj;
            ImageManager.OnImageLoadedListener onImageLoadedListener = (ImageManager.OnImageLoadedListener) this.zzajY.get();
            ImageManager.OnImageLoadedListener onImageLoadedListener2 = (ImageManager.OnImageLoadedListener) zzcVar.zzajY.get();
            return onImageLoadedListener2 != null && onImageLoadedListener != null && zzw.equal(onImageLoadedListener2, onImageLoadedListener) && zzw.equal(zzcVar.zzajO, this.zzajO);
        }

        public final int hashCode() {
            return zzw.hashCode(this.zzajO);
        }

        @Override // com.google.android.gms.common.images.zza
        protected final void zza(Drawable drawable, boolean z, boolean z2, boolean z3) {
            ImageManager.OnImageLoadedListener onImageLoadedListener;
            if (z2 || (onImageLoadedListener = (ImageManager.OnImageLoadedListener) this.zzajY.get()) == null) {
                return;
            }
            onImageLoadedListener.onImageLoaded(this.zzajO.uri, drawable, z3);
        }
    }

    public zza(Uri uri, int i) {
        this.zzajQ = 0;
        this.zzajO = new C0038zza(uri);
        this.zzajQ = i;
    }

    private Drawable zza(Context context, zzmd zzmdVar, int i) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        if (this.zzajW <= 0) {
            return resources.getDrawable(i);
        }
        zzmd.zza zzaVar = new zzmd.zza(i, this.zzajW);
        Drawable drawable = (Drawable) zzmdVar.get(zzaVar);
        if (drawable != null) {
            return drawable;
        }
        Drawable drawable2 = resources.getDrawable(i);
        if ((this.zzajW & 1) != 0) {
            drawable2 = zza(resources, drawable2);
        }
        zzmdVar.put(zzaVar, drawable2);
        return drawable2;
    }

    protected Drawable zza(Resources resources, Drawable drawable) {
        return zzmb.zza(resources, drawable);
    }

    protected zzma zza(Drawable drawable, Drawable drawable2) {
        if (drawable == null) {
            drawable = null;
        } else if (drawable instanceof zzma) {
            drawable = ((zzma) drawable).zzqn();
        }
        return new zzma(drawable, drawable2);
    }

    void zza(Context context, Bitmap bitmap, boolean z) {
        com.google.android.gms.common.internal.zzb.zzv(bitmap);
        if ((this.zzajW & 1) != 0) {
            bitmap = zzmb.zzb(bitmap);
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
        if (this.zzajS != null) {
            this.zzajS.onImageLoaded(this.zzajO.uri, bitmapDrawable, true);
        }
        zza(bitmapDrawable, z, false, true);
    }

    void zza(Context context, zzmd zzmdVar) {
        if (this.zzajV) {
            zza(this.zzajP != 0 ? zza(context, zzmdVar, this.zzajP) : null, false, true, false);
        }
    }

    void zza(Context context, zzmd zzmdVar, boolean z) {
        Drawable drawableZza = this.zzajQ != 0 ? zza(context, zzmdVar, this.zzajQ) : null;
        if (this.zzajS != null) {
            this.zzajS.onImageLoaded(this.zzajO.uri, drawableZza, false);
        }
        zza(drawableZza, z, false, false);
    }

    protected abstract void zza(Drawable drawable, boolean z, boolean z2, boolean z3);

    protected boolean zzb(boolean z, boolean z2) {
        return this.zzajT && !z2 && (!z || this.zzajU);
    }

    public void zzbM(int i) {
        this.zzajQ = i;
    }
}
