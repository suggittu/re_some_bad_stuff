package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.drive.events.ChangeListener;
import java.util.Set;

/* loaded from: classes2.dex */
public interface DriveResource {

    public interface MetadataResult extends Result {
        Metadata getMetadata();
    }

    PendingResult addChangeListener(GoogleApiClient googleApiClient, ChangeListener changeListener);

    PendingResult addChangeSubscription(GoogleApiClient googleApiClient);

    PendingResult delete(GoogleApiClient googleApiClient);

    DriveId getDriveId();

    PendingResult getMetadata(GoogleApiClient googleApiClient);

    PendingResult listParents(GoogleApiClient googleApiClient);

    PendingResult removeChangeListener(GoogleApiClient googleApiClient, ChangeListener changeListener);

    PendingResult removeChangeSubscription(GoogleApiClient googleApiClient);

    PendingResult setParents(GoogleApiClient googleApiClient, Set set);

    PendingResult trash(GoogleApiClient googleApiClient);

    PendingResult untrash(GoogleApiClient googleApiClient);

    PendingResult updateMetadata(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet);
}
