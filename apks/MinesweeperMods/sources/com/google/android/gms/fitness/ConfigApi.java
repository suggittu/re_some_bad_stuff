package com.google.android.gms.fitness;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;

/* loaded from: classes2.dex */
public interface ConfigApi {
    PendingResult createCustomDataType(GoogleApiClient googleApiClient, DataTypeCreateRequest dataTypeCreateRequest);

    PendingResult disableFit(GoogleApiClient googleApiClient);

    PendingResult readDataType(GoogleApiClient googleApiClient, String str);
}
