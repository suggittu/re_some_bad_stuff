package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.location.places.PlaceDetectionApi;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.zzl;

/* loaded from: classes2.dex */
public class zzj implements PlaceDetectionApi {
    @Override // com.google.android.gms.location.places.PlaceDetectionApi
    public PendingResult getCurrentPlace(GoogleApiClient googleApiClient, final PlaceFilter placeFilter) {
        return googleApiClient.zza(new zzl.zzd(Places.zzaPO, googleApiClient) { // from class: com.google.android.gms.location.places.internal.zzj.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzk zzkVar) {
                zzkVar.zza(new com.google.android.gms.location.places.zzl(this, zzkVar.getContext()), placeFilter);
            }
        });
    }

    @Override // com.google.android.gms.location.places.PlaceDetectionApi
    public PendingResult reportDeviceAtPlace(GoogleApiClient googleApiClient, final PlaceReport placeReport) {
        return googleApiClient.zzb(new zzl.zzf(Places.zzaPO, googleApiClient) { // from class: com.google.android.gms.location.places.internal.zzj.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzk zzkVar) {
                zzkVar.zza(new com.google.android.gms.location.places.zzl(this), placeReport);
            }
        });
    }
}
