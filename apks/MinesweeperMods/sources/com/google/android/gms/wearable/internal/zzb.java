package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;

/* loaded from: classes2.dex */
final class zzb extends zzi {
    private Object mListener;
    private com.google.android.gms.common.api.internal.zzq zzbbi;
    private zza zzbrA;

    interface zza {
        void zza(zzbp zzbpVar, zza.zzb zzbVar, Object obj, com.google.android.gms.common.api.internal.zzq zzqVar);
    }

    private zzb(GoogleApiClient googleApiClient, Object obj, com.google.android.gms.common.api.internal.zzq zzqVar, zza zzaVar) {
        super(googleApiClient);
        this.mListener = com.google.android.gms.common.internal.zzx.zzz(obj);
        this.zzbbi = (com.google.android.gms.common.api.internal.zzq) com.google.android.gms.common.internal.zzx.zzz(zzqVar);
        this.zzbrA = (zza) com.google.android.gms.common.internal.zzx.zzz(zzaVar);
    }

    static PendingResult zza(GoogleApiClient googleApiClient, zza zzaVar, Object obj) {
        return googleApiClient.zza(new zzb(googleApiClient, obj, googleApiClient.zzr(obj), zzaVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
    public final void zza(zzbp zzbpVar) {
        this.zzbrA.zza(zzbpVar, this, this.mListener, this.zzbbi);
        this.mListener = null;
        this.zzbbi = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.zzb
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final Status zzc(Status status) {
        this.mListener = null;
        this.zzbbi = null;
        return status;
    }
}
