package com.google.android.gms.location.places;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.maps.model.LatLngBounds;

/* loaded from: classes2.dex */
public interface GeoDataApi {
    PendingResult addPlace(GoogleApiClient googleApiClient, AddPlaceRequest addPlaceRequest);

    PendingResult getAutocompletePredictions(GoogleApiClient googleApiClient, String str, LatLngBounds latLngBounds, AutocompleteFilter autocompleteFilter);

    PendingResult getPlaceById(GoogleApiClient googleApiClient, String... strArr);

    PendingResult getPlacePhotos(GoogleApiClient googleApiClient, String str);
}
