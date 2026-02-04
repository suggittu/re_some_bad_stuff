package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.internal.zzl;
import com.google.android.gms.location.internal.zzq;

/* loaded from: classes2.dex */
public class LocationServices {
    private static final Api.zzc zzUI = new Api.zzc();
    private static final Api.zza zzUJ = new Api.zza() { // from class: com.google.android.gms.location.LocationServices.1
        @Override // com.google.android.gms.common.api.Api.zza
        /* renamed from: zzn, reason: merged with bridge method [inline-methods] */
        public final zzl zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzl(context, looper, connectionCallbacks, onConnectionFailedListener, "locationServices", zzfVar);
        }
    };
    public static final Api API = new Api("LocationServices.API", zzUJ, zzUI);
    public static final FusedLocationProviderApi FusedLocationApi = new com.google.android.gms.location.internal.zzd();
    public static final GeofencingApi GeofencingApi = new com.google.android.gms.location.internal.zzf();
    public static final SettingsApi SettingsApi = new zzq();

    public abstract class zza extends zza.AbstractC0036zza {
        public zza(GoogleApiClient googleApiClient) {
            super(LocationServices.zzUI, googleApiClient);
        }
    }

    private LocationServices() {
    }

    public static zzl zzi(GoogleApiClient googleApiClient) {
        zzx.zzb(googleApiClient != null, "GoogleApiClient parameter is required.");
        zzl zzlVar = (zzl) googleApiClient.zza(zzUI);
        zzx.zza(zzlVar != null, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return zzlVar;
    }
}
