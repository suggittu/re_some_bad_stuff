package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.fitness.ConfigApi;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.DataTypeReadRequest;
import com.google.android.gms.fitness.request.DisableFitRequest;
import com.google.android.gms.fitness.result.DataTypeResult;
import com.google.android.gms.internal.zzoa;
import com.google.android.gms.internal.zzoj;

/* loaded from: classes2.dex */
public class zzpb implements ConfigApi {

    class zza extends zzoj.zza {
        private final zza.zzb zzamC;

        private zza(zza.zzb zzbVar) {
            this.zzamC = zzbVar;
        }

        @Override // com.google.android.gms.internal.zzoj
        public void zza(DataTypeResult dataTypeResult) {
            this.zzamC.zzs(dataTypeResult);
        }
    }

    @Override // com.google.android.gms.fitness.ConfigApi
    public PendingResult createCustomDataType(GoogleApiClient googleApiClient, final DataTypeCreateRequest dataTypeCreateRequest) {
        return googleApiClient.zzb(new zzoa.zza(googleApiClient) { // from class: com.google.android.gms.internal.zzpb.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzJ, reason: merged with bridge method [inline-methods] */
            public DataTypeResult zzc(Status status) {
                return DataTypeResult.zzS(status);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzoa zzoaVar) {
                ((zzol) zzoaVar.zzqJ()).zza(new DataTypeCreateRequest(dataTypeCreateRequest, new zza(this)));
            }
        });
    }

    @Override // com.google.android.gms.fitness.ConfigApi
    public PendingResult disableFit(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zzoa.zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzpb.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzoa zzoaVar) {
                ((zzol) zzoaVar.zzqJ()).zza(new DisableFitRequest(new zzph(this)));
            }
        });
    }

    @Override // com.google.android.gms.fitness.ConfigApi
    public PendingResult readDataType(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zza(new zzoa.zza(googleApiClient) { // from class: com.google.android.gms.internal.zzpb.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzJ, reason: merged with bridge method [inline-methods] */
            public DataTypeResult zzc(Status status) {
                return DataTypeResult.zzS(status);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzoa zzoaVar) {
                ((zzol) zzoaVar.zzqJ()).zza(new DataTypeReadRequest(str, new zza(this)));
            }
        });
    }
}
