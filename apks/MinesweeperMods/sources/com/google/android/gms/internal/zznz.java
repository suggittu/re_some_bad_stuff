package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.internal.zzok;

/* loaded from: classes2.dex */
public class zznz extends zzny {

    abstract class zza extends zza.AbstractC0036zza {
        public zza(GoogleApiClient googleApiClient) {
            super(Fitness.zzavK, googleApiClient);
        }
    }

    public class zzb extends Api.zza {
        @Override // com.google.android.gms.common.api.Api.zza
        /* renamed from: zzg, reason: merged with bridge method [inline-methods] */
        public zznz zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zznz(context, looper, zzfVar, connectionCallbacks, onConnectionFailedListener);
        }
    }

    abstract class zzc extends zza {
        zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            com.google.android.gms.common.internal.zzx.zzac(!status.isSuccess());
            return status;
        }
    }

    public zznz(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 59, connectionCallbacks, onConnectionFailedListener, zzfVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* renamed from: zzbu, reason: merged with bridge method [inline-methods] */
    public zzok zzW(IBinder iBinder) {
        return zzok.zza.zzbF(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgu() {
        return "com.google.android.gms.fitness.BleApi";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgv() {
        return "com.google.android.gms.fitness.internal.IGoogleFitBleApi";
    }
}
