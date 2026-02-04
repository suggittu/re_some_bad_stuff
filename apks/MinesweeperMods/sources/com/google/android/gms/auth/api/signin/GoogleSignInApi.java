package com.google.android.gms.auth.api.signin;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;

/* loaded from: classes2.dex */
public interface GoogleSignInApi {
    Intent getSignInIntent(GoogleApiClient googleApiClient);

    GoogleSignInResult getSignInResultFromIntent(Intent intent);

    PendingResult revokeAccess(GoogleApiClient googleApiClient);

    PendingResult signOut(GoogleApiClient googleApiClient);

    OptionalPendingResult silentSignIn(GoogleApiClient googleApiClient);
}
