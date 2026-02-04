package com.google.android.gms.safetynet;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import java.util.List;

/* loaded from: classes2.dex */
public interface SafetyNetApi {

    public interface AttestationResult extends Result {
        String getJwsResult();
    }

    public interface SafeBrowsingResult extends Result {
        String getMetadata();
    }

    PendingResult attest(GoogleApiClient googleApiClient, byte[] bArr);

    PendingResult lookupUri(GoogleApiClient googleApiClient, List list, String str);
}
