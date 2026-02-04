package com.google.android.gms.internal;

import java.util.concurrent.TimeUnit;

@zzhb
/* loaded from: classes2.dex */
public class zzje implements zzjg {
    private final Object zzNc;
    private final zzjh zzNe = new zzjh();

    public zzje(Object obj) {
        this.zzNc = obj;
        this.zzNe.zzhK();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        return this.zzNc;
    }

    @Override // java.util.concurrent.Future
    public Object get(long j, TimeUnit timeUnit) {
        return this.zzNc;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }

    @Override // com.google.android.gms.internal.zzjg
    public void zzb(Runnable runnable) {
        this.zzNe.zzb(runnable);
    }
}
