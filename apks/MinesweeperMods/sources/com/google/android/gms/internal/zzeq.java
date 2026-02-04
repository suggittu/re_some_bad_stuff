package com.google.android.gms.internal;

import com.google.android.gms.internal.zzes;
import com.google.android.gms.internal.zzez;

@zzhb
/* loaded from: classes2.dex */
public final class zzeq extends zzez.zza {
    private zzes.zza zzCb;
    private zzep zzCc;
    private final Object zzpV = new Object();

    @Override // com.google.android.gms.internal.zzez
    public final void onAdClicked() {
        synchronized (this.zzpV) {
            if (this.zzCc != null) {
                this.zzCc.zzaY();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzez
    public final void onAdClosed() {
        synchronized (this.zzpV) {
            if (this.zzCc != null) {
                this.zzCc.zzaZ();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzez
    public final void onAdFailedToLoad(int i) {
        synchronized (this.zzpV) {
            if (this.zzCb != null) {
                this.zzCb.zzr(i == 3 ? 1 : 2);
                this.zzCb = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzez
    public final void onAdLeftApplication() {
        synchronized (this.zzpV) {
            if (this.zzCc != null) {
                this.zzCc.zzba();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzez
    public final void onAdLoaded() {
        synchronized (this.zzpV) {
            if (this.zzCb != null) {
                this.zzCb.zzr(0);
                this.zzCb = null;
            } else {
                if (this.zzCc != null) {
                    this.zzCc.zzbc();
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.zzez
    public final void onAdOpened() {
        synchronized (this.zzpV) {
            if (this.zzCc != null) {
                this.zzCc.zzbb();
            }
        }
    }

    public final void zza(zzep zzepVar) {
        synchronized (this.zzpV) {
            this.zzCc = zzepVar;
        }
    }

    public final void zza(zzes.zza zzaVar) {
        synchronized (this.zzpV) {
            this.zzCb = zzaVar;
        }
    }

    @Override // com.google.android.gms.internal.zzez
    public final void zza(zzfa zzfaVar) {
        synchronized (this.zzpV) {
            if (this.zzCb != null) {
                this.zzCb.zza(0, zzfaVar);
                this.zzCb = null;
            } else {
                if (this.zzCc != null) {
                    this.zzCc.zzbc();
                }
            }
        }
    }
}
