package com.google.android.gms.internal;

import com.google.android.gms.internal.zzb;

/* loaded from: classes2.dex */
public class zzm {
    public final Object result;
    public final zzb.zza zzag;
    public final zzr zzah;
    public boolean zzai;

    public interface zza {
        void zze(zzr zzrVar);
    }

    public interface zzb {
        void zzb(Object obj);
    }

    private zzm(zzr zzrVar) {
        this.zzai = false;
        this.result = null;
        this.zzag = null;
        this.zzah = zzrVar;
    }

    private zzm(Object obj, zzb.zza zzaVar) {
        this.zzai = false;
        this.result = obj;
        this.zzag = zzaVar;
        this.zzah = null;
    }

    public static zzm zza(Object obj, zzb.zza zzaVar) {
        return new zzm(obj, zzaVar);
    }

    public static zzm zzd(zzr zzrVar) {
        return new zzm(zzrVar);
    }

    public boolean isSuccess() {
        return this.zzah == null;
    }
}
