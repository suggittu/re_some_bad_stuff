package com.google.android.gms.plus;

import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

/* loaded from: classes2.dex */
public interface Account {
    @Deprecated
    void clearDefaultAccount(GoogleApiClient googleApiClient);

    @RequiresPermission("android.permission.GET_ACCOUNTS")
    String getAccountName(GoogleApiClient googleApiClient);

    PendingResult revokeAccessAndDisconnect(GoogleApiClient googleApiClient);
}
