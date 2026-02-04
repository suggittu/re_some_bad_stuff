package com.google.android.gms.location.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.SettingsApi;

/* loaded from: classes2.dex */
public class zzq implements SettingsApi {
    @Override // com.google.android.gms.location.SettingsApi
    public PendingResult checkLocationSettings(GoogleApiClient googleApiClient, LocationSettingsRequest locationSettingsRequest) {
        return zza(googleApiClient, locationSettingsRequest, null);
    }

    public PendingResult zza(GoogleApiClient googleApiClient, final LocationSettingsRequest locationSettingsRequest, final String str) {
        return googleApiClient.zza(new LocationServices.zza(googleApiClient) { // from class: com.google.android.gms.location.internal.zzq.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzl zzlVar) {
                zzlVar.zza(locationSettingsRequest, this, str);
            }

            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzaR, reason: merged with bridge method [inline-methods] */
            public LocationSettingsResult zzc(Status status) {
                return new LocationSettingsResult(status);
            }
        });
    }
}
