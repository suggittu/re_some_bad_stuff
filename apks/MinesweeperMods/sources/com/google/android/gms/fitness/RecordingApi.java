package com.google.android.gms.fitness;

import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;

/* loaded from: classes2.dex */
public interface RecordingApi {
    PendingResult listSubscriptions(GoogleApiClient googleApiClient);

    PendingResult listSubscriptions(GoogleApiClient googleApiClient, DataType dataType);

    @RequiresPermission(anyOf = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.BODY_SENSORS"}, conditional = true)
    PendingResult subscribe(GoogleApiClient googleApiClient, DataSource dataSource);

    @RequiresPermission(anyOf = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.BODY_SENSORS"}, conditional = true)
    PendingResult subscribe(GoogleApiClient googleApiClient, DataType dataType);

    PendingResult unsubscribe(GoogleApiClient googleApiClient, DataSource dataSource);

    PendingResult unsubscribe(GoogleApiClient googleApiClient, DataType dataType);

    PendingResult unsubscribe(GoogleApiClient googleApiClient, Subscription subscription);
}
