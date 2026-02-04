package com.google.android.gms.safetynet;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzre;
import com.google.android.gms.internal.zzrf;
import com.google.android.gms.internal.zzrg;

/* loaded from: classes2.dex */
public final class SafetyNet {
    public static final Api.zzc zzUI = new Api.zzc();
    public static final Api.zza zzUJ = new Api.zza() { // from class: com.google.android.gms.safetynet.SafetyNet.1
        @Override // com.google.android.gms.common.api.Api.zza
        /* renamed from: zzs, reason: merged with bridge method [inline-methods] */
        public final zzrf zza(Context context, Looper looper, zzf zzfVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzrf(context, looper, zzfVar, connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final Api API = new Api("SafetyNet.API", zzUJ, zzUI);
    public static final SafetyNetApi SafetyNetApi = new zzre();
    public static final zzc zzbgw = new zzrg();

    private SafetyNet() {
    }
}
