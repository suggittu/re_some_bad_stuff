package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.internal.zzow;

/* loaded from: classes2.dex */
public class zzph extends zzow.zza {
    private final zza.zzb zzamC;

    public zzph(zza.zzb zzbVar) {
        this.zzamC = zzbVar;
    }

    @Override // com.google.android.gms.internal.zzow
    public void zzp(Status status) {
        this.zzamC.zzs(status);
    }
}
