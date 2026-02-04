package com.google.android.gms.nearby.sharing.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes2.dex */
public final class zzh implements com.google.android.gms.nearby.sharing.zzd {
    public static final Api.zzc zzUI = new Api.zzc();
    public static final Api.zza zzUJ = new Api.zza() { // from class: com.google.android.gms.nearby.sharing.internal.zzh.1
        @Override // com.google.android.gms.common.api.Api.zza
        /* renamed from: zzq, reason: merged with bridge method [inline-methods] */
        public final zze zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zze(context, looper, connectionCallbacks, onConnectionFailedListener, zzfVar);
        }
    };
}
