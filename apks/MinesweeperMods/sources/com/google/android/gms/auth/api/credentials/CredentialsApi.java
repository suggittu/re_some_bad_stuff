package com.google.android.gms.auth.api.credentials;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

/* loaded from: classes2.dex */
public interface CredentialsApi {
    public static final int ACTIVITY_RESULT_ADD_ACCOUNT = 1000;
    public static final int ACTIVITY_RESULT_OTHER_ACCOUNT = 1001;
    public static final int CREDENTIAL_PICKER_REQUEST_CODE = 2000;

    PendingResult delete(GoogleApiClient googleApiClient, Credential credential);

    PendingResult disableAutoSignIn(GoogleApiClient googleApiClient);

    PendingIntent getHintPickerIntent(GoogleApiClient googleApiClient, HintRequest hintRequest);

    PendingResult request(GoogleApiClient googleApiClient, CredentialRequest credentialRequest);

    PendingResult save(GoogleApiClient googleApiClient, Credential credential);
}
