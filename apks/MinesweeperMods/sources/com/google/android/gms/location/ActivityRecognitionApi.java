package com.google.android.gms.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

/* loaded from: classes2.dex */
public interface ActivityRecognitionApi {
    PendingResult removeActivityUpdates(GoogleApiClient googleApiClient, PendingIntent pendingIntent);

    PendingResult requestActivityUpdates(GoogleApiClient googleApiClient, long j, PendingIntent pendingIntent);
}
