package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes2.dex */
public final class zzmf {
    public static final Api.zzc zzUI = new Api.zzc();
    private static final Api.zza zzUJ = new Api.zza() { // from class: com.google.android.gms.internal.zzmf.1
        @Override // com.google.android.gms.common.api.Api.zza
        /* renamed from: zzf, reason: merged with bridge method [inline-methods] */
        public final zzmj zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzmj(context, looper, zzfVar, connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final Api API = new Api("Common.API", zzUJ, zzUI);
    public static final zzmg zzamA = new zzmh();
}
