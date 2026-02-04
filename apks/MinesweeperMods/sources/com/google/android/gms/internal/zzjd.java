package com.google.android.gms.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzhb
/* loaded from: classes2.dex */
public class zzjd implements zzjg {
    private final Object zzpV = new Object();
    private Object zzNc = null;
    private boolean zzNd = false;
    private boolean zzCy = false;
    private final zzjh zzNe = new zzjh();

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        boolean z2 = false;
        if (z) {
            synchronized (this.zzpV) {
                if (!this.zzNd) {
                    this.zzCy = true;
                    this.zzNd = true;
                    this.zzpV.notifyAll();
                    this.zzNe.zzhK();
                    z2 = true;
                }
            }
        }
        return z2;
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        Object obj;
        synchronized (this.zzpV) {
            if (!this.zzNd) {
                try {
                    this.zzpV.wait();
                } catch (InterruptedException e) {
                }
            }
            if (this.zzCy) {
                throw new CancellationException("CallbackFuture was cancelled.");
            }
            obj = this.zzNc;
        }
        return obj;
    }

    @Override // java.util.concurrent.Future
    public Object get(long j, TimeUnit timeUnit) {
        Object obj;
        synchronized (this.zzpV) {
            if (!this.zzNd) {
                try {
                    long millis = timeUnit.toMillis(j);
                    if (millis != 0) {
                        this.zzpV.wait(millis);
                    }
                } catch (InterruptedException e) {
                }
            }
            if (!this.zzNd) {
                throw new TimeoutException("CallbackFuture timed out.");
            }
            if (this.zzCy) {
                throw new CancellationException("CallbackFuture was cancelled.");
            }
            obj = this.zzNc;
        }
        return obj;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        boolean z;
        synchronized (this.zzpV) {
            z = this.zzCy;
        }
        return z;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        boolean z;
        synchronized (this.zzpV) {
            z = this.zzNd;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.zzjg
    public void zzb(Runnable runnable) {
        this.zzNe.zzb(runnable);
    }

    public void zzc(Runnable runnable) {
        this.zzNe.zzc(runnable);
    }

    public void zzg(Object obj) {
        synchronized (this.zzpV) {
            if (this.zzCy) {
                return;
            }
            if (this.zzNd) {
                throw new IllegalStateException("Provided CallbackFuture with multiple values.");
            }
            this.zzNd = true;
            this.zzNc = obj;
            this.zzpV.notifyAll();
            this.zzNe.zzhK();
        }
    }
}
