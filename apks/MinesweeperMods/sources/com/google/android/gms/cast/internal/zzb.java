package com.google.android.gms.cast.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;

/* loaded from: classes2.dex */
public abstract class zzb extends zza.AbstractC0036zza {
    public zzb(GoogleApiClient googleApiClient) {
        super(zzk.zzUI, googleApiClient);
    }

    public void zzbj(int i) {
        zza(zzc(new Status(i)));
    }

    public void zze(int i, String str) {
        zza(zzc(new Status(i, str, null)));
    }
}
