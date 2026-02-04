package com.google.android.gms.auth.api.credentials.internal;

import android.content.Context;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zza;

/* loaded from: classes2.dex */
abstract class zze extends zza.AbstractC0036zza {
    zze(GoogleApiClient googleApiClient) {
        super(Auth.zzVu, googleApiClient);
    }

    protected abstract void zza(Context context, zzj zzjVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
    public final void zza(zzf zzfVar) {
        zza(zzfVar.getContext(), (zzj) zzfVar.zzqJ());
    }
}
