package com.google.android.gms.drive;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public interface DriveContents {
    PendingResult commit(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet);

    PendingResult commit(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, ExecutionOptions executionOptions);

    void discard(GoogleApiClient googleApiClient);

    DriveId getDriveId();

    InputStream getInputStream();

    int getMode();

    OutputStream getOutputStream();

    ParcelFileDescriptor getParcelFileDescriptor();

    PendingResult reopenForWrite(GoogleApiClient googleApiClient);

    Contents zzsx();

    void zzsy();

    boolean zzsz();
}
