package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.nearby.messages.internal.zze;

/* loaded from: classes2.dex */
final class zzp extends zze.zza {
    private final zza.zzb zzbcS;

    private zzp(zza.zzb zzbVar) {
        this.zzbcS = zzbVar;
    }

    static zzp zzn(zza.zzb zzbVar) {
        return new zzp(zzbVar);
    }

    @Override // com.google.android.gms.nearby.messages.internal.zze
    public final void zzbb(Status status) {
        this.zzbcS.zzs(status);
    }
}
