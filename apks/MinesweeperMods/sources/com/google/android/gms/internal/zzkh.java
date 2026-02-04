package com.google.android.gms.internal;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.appdatasearch.GetRecentContextCall;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.internal.zzkg;

/* loaded from: classes2.dex */
public abstract class zzkh extends zzkg.zza {
    protected zza.zzb zzUz;

    public zzkh(zza.zzb zzbVar) {
        this.zzUz = zzbVar;
    }

    @Override // com.google.android.gms.internal.zzkg
    public void zza(GetRecentContextCall.Response response) {
    }

    @Override // com.google.android.gms.internal.zzkg
    public void zza(Status status) {
    }

    @Override // com.google.android.gms.internal.zzkg
    public void zza(Status status, ParcelFileDescriptor parcelFileDescriptor) {
    }

    @Override // com.google.android.gms.internal.zzkg
    public void zza(Status status, boolean z) {
    }
}
