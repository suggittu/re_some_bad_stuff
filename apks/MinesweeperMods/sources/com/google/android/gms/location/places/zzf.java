package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.internal.zzh;
import com.google.android.gms.location.places.zzl;

/* loaded from: classes2.dex */
public class zzf extends zzh.zza {
    private final zzb zzaPw;
    private final zza zzaPx;

    public abstract class zza extends zzl.zzb {
        public zza(Api.zzc zzcVar, GoogleApiClient googleApiClient) {
            super(zzcVar, googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzaS, reason: merged with bridge method [inline-methods] */
        public PlacePhotoResult zzc(Status status) {
            return new PlacePhotoResult(status, null);
        }
    }

    public abstract class zzb extends zzl.zzb {
        public zzb(Api.zzc zzcVar, GoogleApiClient googleApiClient) {
            super(zzcVar, googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzaT, reason: merged with bridge method [inline-methods] */
        public PlacePhotoMetadataResult zzc(Status status) {
            return new PlacePhotoMetadataResult(status, null);
        }
    }

    public zzf(zza zzaVar) {
        this.zzaPw = null;
        this.zzaPx = zzaVar;
    }

    public zzf(zzb zzbVar) {
        this.zzaPw = zzbVar;
        this.zzaPx = null;
    }

    @Override // com.google.android.gms.location.places.internal.zzh
    public void zza(PlacePhotoMetadataResult placePhotoMetadataResult) {
        this.zzaPw.zza(placePhotoMetadataResult);
    }

    @Override // com.google.android.gms.location.places.internal.zzh
    public void zza(PlacePhotoResult placePhotoResult) {
        this.zzaPx.zza(placePhotoResult);
    }
}
