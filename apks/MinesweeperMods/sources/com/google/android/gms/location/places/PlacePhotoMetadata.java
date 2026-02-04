package com.google.android.gms.location.places;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.data.Freezable;

/* loaded from: classes2.dex */
public interface PlacePhotoMetadata extends Freezable {
    CharSequence getAttributions();

    int getMaxHeight();

    int getMaxWidth();

    PendingResult getPhoto(GoogleApiClient googleApiClient);

    PendingResult getScaledPhoto(GoogleApiClient googleApiClient, int i, int i2);
}
