package com.google.android.gms.location.places;

import android.support.annotation.Nullable;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

/* loaded from: classes2.dex */
public interface PlaceDetectionApi {
    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    PendingResult getCurrentPlace(GoogleApiClient googleApiClient, @Nullable PlaceFilter placeFilter);

    PendingResult reportDeviceAtPlace(GoogleApiClient googleApiClient, PlaceReport placeReport);
}
