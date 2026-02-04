package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;

/* loaded from: classes2.dex */
public interface DrivePreferencesApi {

    public interface FileUploadPreferencesResult extends Result {
        FileUploadPreferences getFileUploadPreferences();
    }

    PendingResult getFileUploadPreferences(GoogleApiClient googleApiClient);

    PendingResult setFileUploadPreferences(GoogleApiClient googleApiClient, FileUploadPreferences fileUploadPreferences);
}
