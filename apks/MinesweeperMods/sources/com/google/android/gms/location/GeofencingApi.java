package com.google.android.gms.location;

import android.app.PendingIntent;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import java.util.List;

/* loaded from: classes2.dex */
public interface GeofencingApi {
    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    PendingResult addGeofences(GoogleApiClient googleApiClient, GeofencingRequest geofencingRequest, PendingIntent pendingIntent);

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    @Deprecated
    PendingResult addGeofences(GoogleApiClient googleApiClient, List list, PendingIntent pendingIntent);

    PendingResult removeGeofences(GoogleApiClient googleApiClient, PendingIntent pendingIntent);

    PendingResult removeGeofences(GoogleApiClient googleApiClient, List list);
}
