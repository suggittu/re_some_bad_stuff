package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.PlacePhotoMetadata;

/* loaded from: classes2.dex */
public class zzq extends zzt implements PlacePhotoMetadata {
    private final String zzaQR;

    public zzq(DataHolder dataHolder, int i) {
        super(dataHolder, i);
        this.zzaQR = getString("photo_fife_url");
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public CharSequence getAttributions() {
        return zzG("photo_attributions", null);
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public int getMaxHeight() {
        return zzz("photo_max_height", 0);
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public int getMaxWidth() {
        return zzz("photo_max_width", 0);
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public PendingResult getPhoto(GoogleApiClient googleApiClient) {
        return getScaledPhoto(googleApiClient, getMaxWidth(), getMaxHeight());
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public PendingResult getScaledPhoto(GoogleApiClient googleApiClient, int i, int i2) {
        return freeze().getScaledPhoto(googleApiClient, i, i2);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzzz, reason: merged with bridge method [inline-methods] */
    public PlacePhotoMetadata freeze() {
        return new zzp(this.zzaQR, getMaxWidth(), getMaxHeight(), getAttributions(), this.zzaje);
    }
}
