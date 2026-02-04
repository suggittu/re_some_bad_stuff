package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;

/* loaded from: classes2.dex */
public class zzbu extends zzd {
    private final zza.zzb zzamC;

    public zzbu(zza.zzb zzbVar) {
        this.zzamC = zzbVar;
    }

    @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzan
    public void onError(Status status) {
        this.zzamC.zzs(status);
    }

    @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzan
    public void onSuccess() {
        this.zzamC.zzs(Status.zzagC);
    }
}
