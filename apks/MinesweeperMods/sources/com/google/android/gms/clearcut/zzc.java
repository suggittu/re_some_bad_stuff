package com.google.android.gms.clearcut;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public interface zzc {
    PendingResult zza(GoogleApiClient googleApiClient, LogEventParcelable logEventParcelable);

    boolean zza(GoogleApiClient googleApiClient, long j, TimeUnit timeUnit);
}
