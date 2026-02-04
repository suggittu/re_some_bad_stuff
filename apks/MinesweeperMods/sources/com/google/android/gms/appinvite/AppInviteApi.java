package com.google.android.gms.appinvite;

import android.app.Activity;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

/* loaded from: classes2.dex */
public interface AppInviteApi {
    PendingResult convertInvitation(@NonNull GoogleApiClient googleApiClient, String str);

    PendingResult getInvitation(@NonNull GoogleApiClient googleApiClient, Activity activity, boolean z);

    @Deprecated
    PendingResult updateInvitationOnInstall(@NonNull GoogleApiClient googleApiClient, String str);
}
