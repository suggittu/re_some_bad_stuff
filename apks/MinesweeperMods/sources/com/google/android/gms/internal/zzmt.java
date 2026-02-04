package com.google.android.gms.internal;

import android.os.SystemClock;

/* loaded from: classes2.dex */
public final class zzmt implements zzmq {
    private static zzmt zzaoa;

    public static synchronized zzmq zzsc() {
        if (zzaoa == null) {
            zzaoa = new zzmt();
        }
        return zzaoa;
    }

    @Override // com.google.android.gms.internal.zzmq
    public final long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    @Override // com.google.android.gms.internal.zzmq
    public final long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.gms.internal.zzmq
    public final long nanoTime() {
        return System.nanoTime();
    }
}
