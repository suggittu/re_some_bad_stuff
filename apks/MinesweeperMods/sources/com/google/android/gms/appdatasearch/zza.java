package com.google.android.gms.appdatasearch;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzki;
import com.google.android.gms.internal.zzkk;

/* loaded from: classes2.dex */
public final class zza {
    public static final Api.zzc zzTy = new Api.zzc();
    private static final Api.zza zzTz = new Api.zza() { // from class: com.google.android.gms.appdatasearch.zza.1
        @Override // com.google.android.gms.common.api.Api.zza
        public final zzki zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzki(context, looper, zzfVar, connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final Api zzTA = new Api("AppDataSearch.LIGHTWEIGHT_API", zzTz, zzTy);
    public static final zzk zzTB = new zzkk();
}
