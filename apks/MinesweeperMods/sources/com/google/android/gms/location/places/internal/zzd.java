package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.GeoDataApi;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.zzf;
import com.google.android.gms.location.places.zzl;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class zzd implements GeoDataApi {
    @Override // com.google.android.gms.location.places.GeoDataApi
    public PendingResult addPlace(GoogleApiClient googleApiClient, final AddPlaceRequest addPlaceRequest) {
        return googleApiClient.zzb(new zzl.zzc(Places.zzaPN, googleApiClient) { // from class: com.google.android.gms.location.places.internal.zzd.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zze zzeVar) {
                zzeVar.zza(new com.google.android.gms.location.places.zzl(this, zzeVar.getContext()), addPlaceRequest);
            }
        });
    }

    @Override // com.google.android.gms.location.places.GeoDataApi
    public PendingResult getAutocompletePredictions(GoogleApiClient googleApiClient, final String str, final LatLngBounds latLngBounds, final AutocompleteFilter autocompleteFilter) {
        return googleApiClient.zza(new zzl.zza(Places.zzaPN, googleApiClient) { // from class: com.google.android.gms.location.places.internal.zzd.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zze zzeVar) {
                zzeVar.zza(new com.google.android.gms.location.places.zzl(this), str, latLngBounds, autocompleteFilter);
            }
        });
    }

    @Override // com.google.android.gms.location.places.GeoDataApi
    public PendingResult getPlaceById(GoogleApiClient googleApiClient, final String... strArr) {
        zzx.zzac(strArr != null && strArr.length > 0);
        return googleApiClient.zza(new zzl.zzc(Places.zzaPN, googleApiClient) { // from class: com.google.android.gms.location.places.internal.zzd.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zze zzeVar) {
                zzeVar.zza(new com.google.android.gms.location.places.zzl(this, zzeVar.getContext()), Arrays.asList(strArr));
            }
        });
    }

    @Override // com.google.android.gms.location.places.GeoDataApi
    public PendingResult getPlacePhotos(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zza(new zzf.zzb(Places.zzaPN, googleApiClient) { // from class: com.google.android.gms.location.places.internal.zzd.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zze zzeVar) {
                zzeVar.zza(new com.google.android.gms.location.places.zzf(this), str);
            }
        });
    }
}
