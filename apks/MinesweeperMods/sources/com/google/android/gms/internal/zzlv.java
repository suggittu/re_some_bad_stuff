package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.internal.zzlx;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class zzlv implements com.google.android.gms.clearcut.zzc {
    private static final Object zzafn = new Object();
    private static final zze zzafo = new zze();
    private static final long zzafp = TimeUnit.MILLISECONDS.convert(2, TimeUnit.MINUTES);
    private GoogleApiClient zzaaj;
    private final zza zzafq;
    private final Object zzafr;
    private long zzafs;
    private final long zzaft;
    private ScheduledFuture zzafu;
    private final Runnable zzafv;
    private final zzmq zzqW;

    public interface zza {
    }

    public class zzb implements zza {
    }

    abstract class zzc extends zza.AbstractC0036zza {
        public zzc(GoogleApiClient googleApiClient) {
            super(com.google.android.gms.clearcut.zzb.zzUI, googleApiClient);
        }
    }

    final class zzd extends zzc {
        private final LogEventParcelable zzafx;

        zzd(LogEventParcelable logEventParcelable, GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzafx = logEventParcelable;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof zzd) {
                return this.zzafx.equals(((zzd) obj).zzafx);
            }
            return false;
        }

        public final String toString() {
            return "MethodImpl(" + this.zzafx + ")";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public final void zza(zzlw zzlwVar) {
            zzlx.zza zzaVar = new zzlx.zza() { // from class: com.google.android.gms.internal.zzlv.zzd.1
                @Override // com.google.android.gms.internal.zzlx
                public void zzv(Status status) {
                    zzd.this.zza(status);
                }
            };
            try {
                zzlv.zza(this.zzafx);
                zzlwVar.zza(zzaVar, this.zzafx);
            } catch (Throwable th) {
                Log.e("ClearcutLoggerApiImpl", "MessageNanoProducer " + this.zzafx.zzafl.toString() + " threw: " + th.toString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public final Status zzc(Status status) {
            return status;
        }
    }

    final class zze {
        private int mSize;

        private zze() {
            this.mSize = 0;
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x000f, code lost:
        
            r0 = true;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean zza(long r8, java.util.concurrent.TimeUnit r10) {
            /*
                r7 = this;
                long r2 = java.lang.System.currentTimeMillis()
                java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MILLISECONDS
                long r0 = r0.convert(r8, r10)
                monitor-enter(r7)
            Lb:
                int r4 = r7.mSize     // Catch: java.lang.Throwable -> L25
                if (r4 != 0) goto L12
                r0 = 1
                monitor-exit(r7)     // Catch: java.lang.Throwable -> L25
            L11:
                return r0
            L12:
                r4 = 0
                int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r4 > 0) goto L1b
                r0 = 0
                monitor-exit(r7)
                goto L11
            L1b:
                r7.wait(r0)     // Catch: java.lang.Throwable -> L25
                long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L25
                long r4 = r4 - r2
                long r0 = r0 - r4
                goto Lb
            L25:
                r0 = move-exception
                monitor-exit(r7)     // Catch: java.lang.Throwable -> L25
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzlv.zze.zza(long, java.util.concurrent.TimeUnit):boolean");
        }

        public final synchronized void zzoH() {
            this.mSize++;
        }

        public final synchronized void zzoI() {
            if (this.mSize == 0) {
                throw new RuntimeException("too many decrements");
            }
            this.mSize--;
            if (this.mSize == 0) {
                notifyAll();
            }
        }
    }

    public zzlv() {
        this(new zzmt(), zzafp, new zzb());
    }

    public zzlv(zzmq zzmqVar, long j, zza zzaVar) {
        this.zzafr = new Object();
        this.zzafs = 0L;
        this.zzafu = null;
        this.zzaaj = null;
        this.zzafv = new Runnable() { // from class: com.google.android.gms.internal.zzlv.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (zzlv.this.zzafr) {
                    if (zzlv.this.zzafs <= zzlv.this.zzqW.elapsedRealtime() && zzlv.this.zzaaj != null) {
                        Log.i("ClearcutLoggerApiImpl", "disconnect managed GoogleApiClient");
                        zzlv.this.zzaaj.disconnect();
                        zzlv.this.zzaaj = null;
                    }
                }
            }
        };
        this.zzqW = zzmqVar;
        this.zzaft = j;
        this.zzafq = zzaVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(LogEventParcelable logEventParcelable) {
        if (logEventParcelable.zzafl != null && logEventParcelable.zzafk.zzbuY.length == 0) {
            logEventParcelable.zzafk.zzbuY = logEventParcelable.zzafl.zzoF();
        }
        if (logEventParcelable.zzafm != null && logEventParcelable.zzafk.zzbvf.length == 0) {
            logEventParcelable.zzafk.zzbvf = logEventParcelable.zzafm.zzoF();
        }
        logEventParcelable.zzafi = zzsu.toByteArray(logEventParcelable.zzafk);
    }

    private zzd zzb(GoogleApiClient googleApiClient, LogEventParcelable logEventParcelable) {
        zzafo.zzoH();
        zzd zzdVar = new zzd(logEventParcelable, googleApiClient);
        zzdVar.zza(new PendingResult.zza() { // from class: com.google.android.gms.internal.zzlv.2
            @Override // com.google.android.gms.common.api.PendingResult.zza
            public void zzu(Status status) {
                zzlv.zzafo.zzoI();
            }
        });
        return zzdVar;
    }

    @Override // com.google.android.gms.clearcut.zzc
    public PendingResult zza(GoogleApiClient googleApiClient, LogEventParcelable logEventParcelable) {
        zza(logEventParcelable);
        return googleApiClient.zza(zzb(googleApiClient, logEventParcelable));
    }

    @Override // com.google.android.gms.clearcut.zzc
    public boolean zza(GoogleApiClient googleApiClient, long j, TimeUnit timeUnit) {
        try {
            return zzafo.zza(j, timeUnit);
        } catch (InterruptedException e) {
            Log.e("ClearcutLoggerApiImpl", "flush interrupted");
            Thread.currentThread().interrupt();
            return false;
        }
    }
}
