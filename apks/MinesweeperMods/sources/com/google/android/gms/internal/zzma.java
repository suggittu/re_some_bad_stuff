package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;

/* loaded from: classes2.dex */
public final class zzma extends Drawable implements Drawable.Callback {
    private int mFrom;
    private long zzRD;
    private boolean zzajT;
    private int zzaka;
    private int zzakb;
    private int zzakc;
    private int zzakd;
    private int zzake;
    private boolean zzakf;
    private zzb zzakg;
    private Drawable zzakh;
    private Drawable zzaki;
    private boolean zzakj;
    private boolean zzakk;
    private boolean zzakl;
    private int zzakm;

    final class zza extends Drawable {
        private static final zza zzakn = new zza();
        private static final C0128zza zzako = new C0128zza();

        /* renamed from: com.google.android.gms.internal.zzma$zza$zza, reason: collision with other inner class name */
        final class C0128zza extends Drawable.ConstantState {
            private C0128zza() {
            }

            @Override // android.graphics.drawable.Drawable.ConstantState
            public final int getChangingConfigurations() {
                return 0;
            }

            @Override // android.graphics.drawable.Drawable.ConstantState
            public final Drawable newDrawable() {
                return zza.zzakn;
            }
        }

        private zza() {
        }

        @Override // android.graphics.drawable.Drawable
        public final void draw(Canvas canvas) {
        }

        @Override // android.graphics.drawable.Drawable
        public final Drawable.ConstantState getConstantState() {
            return zzako;
        }

        @Override // android.graphics.drawable.Drawable
        public final int getOpacity() {
            return -2;
        }

        @Override // android.graphics.drawable.Drawable
        public final void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public final void setColorFilter(ColorFilter colorFilter) {
        }
    }

    final class zzb extends Drawable.ConstantState {
        int zzakp;
        int zzakq;

        zzb(zzb zzbVar) {
            if (zzbVar != null) {
                this.zzakp = zzbVar.zzakp;
                this.zzakq = zzbVar.zzakq;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return this.zzakp;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            return new zzma(this);
        }
    }

    public zzma(Drawable drawable, Drawable drawable2) {
        this(null);
        drawable = drawable == null ? zza.zzakn : drawable;
        this.zzakh = drawable;
        drawable.setCallback(this);
        this.zzakg.zzakq |= drawable.getChangingConfigurations();
        drawable2 = drawable2 == null ? zza.zzakn : drawable2;
        this.zzaki = drawable2;
        drawable2.setCallback(this);
        this.zzakg.zzakq |= drawable2.getChangingConfigurations();
    }

    zzma(zzb zzbVar) {
        this.zzaka = 0;
        this.zzakc = 255;
        this.zzake = 0;
        this.zzajT = true;
        this.zzakg = new zzb(zzbVar);
    }

    public final boolean canConstantState() {
        if (!this.zzakj) {
            this.zzakk = (this.zzakh.getConstantState() == null || this.zzaki.getConstantState() == null) ? false : true;
            this.zzakj = true;
        }
        return this.zzakk;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        boolean z = false;
        switch (this.zzaka) {
            case 1:
                this.zzRD = SystemClock.uptimeMillis();
                this.zzaka = 2;
                break;
            case 2:
                if (this.zzRD >= 0) {
                    float fUptimeMillis = (SystemClock.uptimeMillis() - this.zzRD) / this.zzakd;
                    z = fUptimeMillis >= 1.0f;
                    if (z) {
                        this.zzaka = 0;
                    }
                    this.zzake = (int) ((Math.min(fUptimeMillis, 1.0f) * (this.zzakb - this.mFrom)) + this.mFrom);
                }
            default:
                z = z;
                break;
        }
        int i = this.zzake;
        boolean z2 = this.zzajT;
        Drawable drawable = this.zzakh;
        Drawable drawable2 = this.zzaki;
        if (z) {
            if (!z2 || i == 0) {
                drawable.draw(canvas);
            }
            if (i == this.zzakc) {
                drawable2.setAlpha(this.zzakc);
                drawable2.draw(canvas);
                return;
            }
            return;
        }
        if (z2) {
            drawable.setAlpha(this.zzakc - i);
        }
        drawable.draw(canvas);
        if (z2) {
            drawable.setAlpha(this.zzakc);
        }
        if (i > 0) {
            drawable2.setAlpha(i);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.zzakc);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.zzakg.zzakp | this.zzakg.zzakq;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (!canConstantState()) {
            return null;
        }
        this.zzakg.zzakp = getChangingConfigurations();
        return this.zzakg;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return Math.max(this.zzakh.getIntrinsicHeight(), this.zzaki.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.max(this.zzakh.getIntrinsicWidth(), this.zzaki.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        if (!this.zzakl) {
            this.zzakm = Drawable.resolveOpacity(this.zzakh.getOpacity(), this.zzaki.getOpacity());
            this.zzakl = true;
        }
        return this.zzakm;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    @TargetApi(11)
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback;
        if (!zzne.zzsd() || (callback = getCallback()) == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        if (!this.zzakf && super.mutate() == this) {
            if (!canConstantState()) {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
            this.zzakh.mutate();
            this.zzaki.mutate();
            this.zzakf = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected final void onBoundsChange(Rect rect) {
        this.zzakh.setBounds(rect);
        this.zzaki.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    @TargetApi(11)
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback;
        if (!zzne.zzsd() || (callback = getCallback()) == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        if (this.zzake == this.zzakc) {
            this.zzake = i;
        }
        this.zzakc = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.zzakh.setColorFilter(colorFilter);
        this.zzaki.setColorFilter(colorFilter);
    }

    public final void startTransition(int i) {
        this.mFrom = 0;
        this.zzakb = this.zzakc;
        this.zzake = 0;
        this.zzakd = i;
        this.zzaka = 1;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    @TargetApi(11)
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback;
        if (!zzne.zzsd() || (callback = getCallback()) == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public final Drawable zzqn() {
        return this.zzaki;
    }
}
