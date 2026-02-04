package com.google.android.gms.search;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;

/* loaded from: classes2.dex */
public interface SearchAuthApi {

    public interface GoogleNowAuthResult extends Result {
        GoogleNowAuthState getGoogleNowAuthState();
    }

    PendingResult clearToken(GoogleApiClient googleApiClient, String str);

    PendingResult getGoogleNowAuth(GoogleApiClient googleApiClient, String str);
}
