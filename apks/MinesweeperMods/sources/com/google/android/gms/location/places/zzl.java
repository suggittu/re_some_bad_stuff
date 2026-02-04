package com.google.android.gms.location.places;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzng;
import com.google.android.gms.location.places.internal.zzi;

/* loaded from: classes2.dex */
public class zzl extends zzi.zza {
    private static final String TAG = zzl.class.getSimpleName();
    private final Context mContext;
    private final zzd zzaPP;
    private final zza zzaPQ;
    private final zze zzaPR;
    private final zzf zzaPS;
    private final zzc zzaPT;

    public abstract class zza extends zzb {
        public zza(Api.zzc zzcVar, GoogleApiClient googleApiClient) {
            super(zzcVar, googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzaV, reason: merged with bridge method [inline-methods] */
        public AutocompletePredictionBuffer zzc(Status status) {
            return new AutocompletePredictionBuffer(DataHolder.zzbI(status.getStatusCode()));
        }
    }

    public abstract class zzb extends zza.AbstractC0036zza {
        public zzb(Api.zzc zzcVar, GoogleApiClient googleApiClient) {
            super(zzcVar, googleApiClient);
        }
    }

    public abstract class zzc extends zzb {
        public zzc(Api.zzc zzcVar, GoogleApiClient googleApiClient) {
            super(zzcVar, googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzaW, reason: merged with bridge method [inline-methods] */
        public PlaceBuffer zzc(Status status) {
            return new PlaceBuffer(DataHolder.zzbI(status.getStatusCode()), null);
        }
    }

    public abstract class zzd extends zzb {
        public zzd(Api.zzc zzcVar, GoogleApiClient googleApiClient) {
            super(zzcVar, googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzaX, reason: merged with bridge method [inline-methods] */
        public PlaceLikelihoodBuffer zzc(Status status) {
            return new PlaceLikelihoodBuffer(DataHolder.zzbI(status.getStatusCode()), 100, null);
        }
    }

    public abstract class zze extends zzb {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzaY, reason: merged with bridge method [inline-methods] */
        public com.google.android.gms.location.places.personalized.zzd zzc(Status status) {
            return com.google.android.gms.location.places.personalized.zzd.zzaZ(status);
        }
    }

    public abstract class zzf extends zzb {
        public zzf(Api.zzc zzcVar, GoogleApiClient googleApiClient) {
            super(zzcVar, googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            return status;
        }
    }

    public zzl(zza zzaVar) {
        this.zzaPP = null;
        this.zzaPQ = zzaVar;
        this.zzaPR = null;
        this.zzaPS = null;
        this.zzaPT = null;
        this.mContext = null;
    }

    public zzl(zzc zzcVar, Context context) {
        this.zzaPP = null;
        this.zzaPQ = null;
        this.zzaPR = null;
        this.zzaPS = null;
        this.zzaPT = zzcVar;
        this.mContext = context.getApplicationContext();
    }

    public zzl(zzd zzdVar, Context context) {
        this.zzaPP = zzdVar;
        this.zzaPQ = null;
        this.zzaPR = null;
        this.zzaPS = null;
        this.zzaPT = null;
        this.mContext = context.getApplicationContext();
    }

    public zzl(zzf zzfVar) {
        this.zzaPP = null;
        this.zzaPQ = null;
        this.zzaPR = null;
        this.zzaPS = zzfVar;
        this.zzaPT = null;
        this.mContext = null;
    }

    @Override // com.google.android.gms.location.places.internal.zzi
    public void zzaU(Status status) {
        this.zzaPS.zza(status);
    }

    @Override // com.google.android.gms.location.places.internal.zzi
    public void zzac(DataHolder dataHolder) {
        zzx.zza(this.zzaPP != null, "placeEstimator cannot be null");
        if (dataHolder != null) {
            Bundle bundleZzpZ = dataHolder.zzpZ();
            this.zzaPP.zza(new PlaceLikelihoodBuffer(dataHolder, bundleZzpZ == null ? 100 : PlaceLikelihoodBuffer.zzH(bundleZzpZ), this.mContext));
        } else {
            if (Log.isLoggable(TAG, 6)) {
                Log.e(TAG, "onPlaceEstimated received null DataHolder: " + zzng.zzso());
            }
            this.zzaPP.zzw(Status.zzagE);
        }
    }

    @Override // com.google.android.gms.location.places.internal.zzi
    public void zzad(DataHolder dataHolder) {
        if (dataHolder != null) {
            this.zzaPQ.zza(new AutocompletePredictionBuffer(dataHolder));
            return;
        }
        if (Log.isLoggable(TAG, 6)) {
            Log.e(TAG, "onAutocompletePrediction received null DataHolder: " + zzng.zzso());
        }
        this.zzaPQ.zzw(Status.zzagE);
    }

    @Override // com.google.android.gms.location.places.internal.zzi
    public void zzae(DataHolder dataHolder) {
        if (dataHolder != null) {
            this.zzaPR.zza(new com.google.android.gms.location.places.personalized.zzd(dataHolder));
            return;
        }
        if (Log.isLoggable(TAG, 6)) {
            Log.e(TAG, "onPlaceUserDataFetched received null DataHolder: " + zzng.zzso());
        }
        this.zzaPR.zzw(Status.zzagE);
    }

    @Override // com.google.android.gms.location.places.internal.zzi
    public void zzaf(DataHolder dataHolder) {
        this.zzaPT.zza(new PlaceBuffer(dataHolder, this.mContext));
    }
}
