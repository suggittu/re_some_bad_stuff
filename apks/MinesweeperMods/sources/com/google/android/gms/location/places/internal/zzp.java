package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.zzf;

/* loaded from: classes2.dex */
public class zzp implements PlacePhotoMetadata {
    private int mIndex;
    private final int zzDF;
    private final int zzDG;
    private final String zzaQR;
    private final CharSequence zzaQS;

    public zzp(String str, int i, int i2, CharSequence charSequence, int i3) {
        this.zzaQR = str;
        this.zzDF = i;
        this.zzDG = i2;
        this.zzaQS = charSequence;
        this.mIndex = i3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzp)) {
            return false;
        }
        zzp zzpVar = (zzp) obj;
        return zzpVar.zzDF == this.zzDF && zzpVar.zzDG == this.zzDG && zzw.equal(zzpVar.zzaQR, this.zzaQR) && zzw.equal(zzpVar.zzaQS, this.zzaQS);
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public CharSequence getAttributions() {
        return this.zzaQS;
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public int getMaxHeight() {
        return this.zzDG;
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public int getMaxWidth() {
        return this.zzDF;
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public PendingResult getPhoto(GoogleApiClient googleApiClient) {
        return getScaledPhoto(googleApiClient, getMaxWidth(), getMaxHeight());
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public PendingResult getScaledPhoto(GoogleApiClient googleApiClient, final int i, final int i2) {
        return googleApiClient.zza(new zzf.zza(Places.zzaPN, googleApiClient) { // from class: com.google.android.gms.location.places.internal.zzp.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zze zzeVar) {
                zzeVar.zza(new com.google.android.gms.location.places.zzf(this), zzp.this.zzaQR, i, i2, zzp.this.mIndex);
            }
        });
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzDF), Integer.valueOf(this.zzDG), this.zzaQR, this.zzaQS);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzzz, reason: merged with bridge method [inline-methods] */
    public PlacePhotoMetadata freeze() {
        return this;
    }
}
