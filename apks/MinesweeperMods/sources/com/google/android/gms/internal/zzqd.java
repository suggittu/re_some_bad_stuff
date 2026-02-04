package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes2.dex */
public class zzqd implements com.google.android.gms.nearby.bootstrap.zza {
    public static final Api.zzc zzUI = new Api.zzc();
    public static final Api.zza zzUJ = new Api.zza() { // from class: com.google.android.gms.internal.zzqd.1
        @Override // com.google.android.gms.common.api.Api.zza
        /* renamed from: zzo, reason: merged with bridge method [inline-methods] */
        public final zzqc zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzqc(context, looper, connectionCallbacks, onConnectionFailedListener, zzfVar);
        }
    };
}
