package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.location.internal.zzl;

/* loaded from: classes2.dex */
public class ActivityRecognition {
    public static final String CLIENT_NAME = "activity_recognition";
    private static final Api.zzc zzUI = new Api.zzc();
    private static final Api.zza zzUJ = new Api.zza() { // from class: com.google.android.gms.location.ActivityRecognition.1
        @Override // com.google.android.gms.common.api.Api.zza
        /* renamed from: zzn, reason: merged with bridge method [inline-methods] */
        public final zzl zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzl(context, looper, connectionCallbacks, onConnectionFailedListener, ActivityRecognition.CLIENT_NAME);
        }
    };
    public static final Api API = new Api("ActivityRecognition.API", zzUJ, zzUI);
    public static final ActivityRecognitionApi ActivityRecognitionApi = new com.google.android.gms.location.internal.zza();

    public abstract class zza extends zza.AbstractC0036zza {
        public zza(GoogleApiClient googleApiClient) {
            super(ActivityRecognition.zzUI, googleApiClient);
        }
    }

    private ActivityRecognition() {
    }
}
