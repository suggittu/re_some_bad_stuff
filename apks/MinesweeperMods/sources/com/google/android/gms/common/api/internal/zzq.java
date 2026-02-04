package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes2.dex */
public final class zzq {
    private volatile Object mListener;
    private final zza zzaiw;

    final class zza extends Handler {
        public zza(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            com.google.android.gms.common.internal.zzx.zzac(message.what == 1);
            zzq.this.zzb((zzb) message.obj);
        }
    }

    public interface zzb {
        void zzpr();

        void zzt(Object obj);
    }

    zzq(Looper looper, Object obj) {
        this.zzaiw = new zza(looper);
        this.mListener = com.google.android.gms.common.internal.zzx.zzb(obj, "Listener must not be null");
    }

    public final void clear() {
        this.mListener = null;
    }

    public final void zza(zzb zzbVar) {
        com.google.android.gms.common.internal.zzx.zzb(zzbVar, "Notifier must not be null");
        this.zzaiw.sendMessage(this.zzaiw.obtainMessage(1, zzbVar));
    }

    final void zzb(zzb zzbVar) {
        Object obj = this.mListener;
        if (obj == null) {
            zzbVar.zzpr();
            return;
        }
        try {
            zzbVar.zzt(obj);
        } catch (RuntimeException e) {
            zzbVar.zzpr();
            throw e;
        }
    }
}
