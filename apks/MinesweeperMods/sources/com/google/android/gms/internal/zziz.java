package com.google.android.gms.internal;

@zzhb
/* loaded from: classes2.dex */
public class zziz {
    private long zzMJ;
    private long zzMK = Long.MIN_VALUE;
    private Object zzpV = new Object();

    public zziz(long j) {
        this.zzMJ = j;
    }

    public boolean tryAcquire() {
        boolean z;
        synchronized (this.zzpV) {
            long jElapsedRealtime = com.google.android.gms.ads.internal.zzr.zzbG().elapsedRealtime();
            if (this.zzMK + this.zzMJ > jElapsedRealtime) {
                z = false;
            } else {
                this.zzMK = jElapsedRealtime;
                z = true;
            }
        }
        return z;
    }
}
