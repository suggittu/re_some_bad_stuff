package com.google.android.gms.cast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

/* loaded from: classes2.dex */
public interface CastRemoteDisplayApi {
    PendingResult startRemoteDisplay(GoogleApiClient googleApiClient, String str);

    PendingResult stopRemoteDisplay(GoogleApiClient googleApiClient);
}
