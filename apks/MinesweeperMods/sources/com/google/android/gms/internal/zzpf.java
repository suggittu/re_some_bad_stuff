package com.google.android.gms.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.fitness.SensorsApi;
import com.google.android.gms.fitness.data.zzl;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRegistrationRequest;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.request.SensorUnregistrationRequest;
import com.google.android.gms.fitness.result.DataSourcesResult;
import com.google.android.gms.internal.zzoe;
import com.google.android.gms.internal.zzoi;
import com.google.android.gms.internal.zzow;

/* loaded from: classes2.dex */
public class zzpf implements SensorsApi {

    interface zza {
        void zzuI();
    }

    class zzb extends zzoi.zza {
        private final zza.zzb zzamC;

        private zzb(zza.zzb zzbVar) {
            this.zzamC = zzbVar;
        }

        @Override // com.google.android.gms.internal.zzoi
        public void zza(DataSourcesResult dataSourcesResult) {
            this.zzamC.zzs(dataSourcesResult);
        }
    }

    class zzc extends zzow.zza {
        private final zza zzaAq;
        private final zza.zzb zzamC;

        private zzc(zza.zzb zzbVar, zza zzaVar) {
            this.zzamC = zzbVar;
            this.zzaAq = zzaVar;
        }

        @Override // com.google.android.gms.internal.zzow
        public void zzp(Status status) {
            if (this.zzaAq != null && status.isSuccess()) {
                this.zzaAq.zzuI();
            }
            this.zzamC.zzs(status);
        }
    }

    private PendingResult zza(GoogleApiClient googleApiClient, final com.google.android.gms.fitness.data.zzk zzkVar, final PendingIntent pendingIntent, final zza zzaVar) {
        return googleApiClient.zzb(new zzoe.zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzpf.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzoe zzoeVar) {
                ((zzop) zzoeVar.zzqJ()).zza(new SensorUnregistrationRequest(zzkVar, pendingIntent, new zzc(this, zzaVar)));
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzoe.zzc, com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzb */
            public Status zzc(Status status) {
                return status;
            }
        });
    }

    private PendingResult zza(GoogleApiClient googleApiClient, final SensorRequest sensorRequest, final com.google.android.gms.fitness.data.zzk zzkVar, final PendingIntent pendingIntent) {
        return googleApiClient.zza(new zzoe.zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzpf.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzoe zzoeVar) {
                ((zzop) zzoeVar.zzqJ()).zza(new SensorRegistrationRequest(sensorRequest, zzkVar, pendingIntent, new zzph(this)));
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzoe.zzc, com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzb */
            public Status zzc(Status status) {
                return status;
            }
        });
    }

    @Override // com.google.android.gms.fitness.SensorsApi
    public PendingResult add(GoogleApiClient googleApiClient, SensorRequest sensorRequest, PendingIntent pendingIntent) {
        return zza(googleApiClient, sensorRequest, (com.google.android.gms.fitness.data.zzk) null, pendingIntent);
    }

    @Override // com.google.android.gms.fitness.SensorsApi
    public PendingResult add(GoogleApiClient googleApiClient, SensorRequest sensorRequest, OnDataPointListener onDataPointListener) {
        return zza(googleApiClient, sensorRequest, zzl.zza.zzuu().zza(onDataPointListener), (PendingIntent) null);
    }

    @Override // com.google.android.gms.fitness.SensorsApi
    public PendingResult findDataSources(GoogleApiClient googleApiClient, final DataSourcesRequest dataSourcesRequest) {
        return googleApiClient.zza(new zzoe.zza(googleApiClient) { // from class: com.google.android.gms.internal.zzpf.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzN, reason: merged with bridge method [inline-methods] */
            public DataSourcesResult zzc(Status status) {
                return DataSourcesResult.zzR(status);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzoe zzoeVar) {
                ((zzop) zzoeVar.zzqJ()).zza(new DataSourcesRequest(dataSourcesRequest, new zzb(this)));
            }
        });
    }

    @Override // com.google.android.gms.fitness.SensorsApi
    public PendingResult remove(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return zza(googleApiClient, (com.google.android.gms.fitness.data.zzk) null, pendingIntent, (zza) null);
    }

    @Override // com.google.android.gms.fitness.SensorsApi
    public PendingResult remove(GoogleApiClient googleApiClient, final OnDataPointListener onDataPointListener) {
        com.google.android.gms.fitness.data.zzl zzlVarZzb = zzl.zza.zzuu().zzb(onDataPointListener);
        return zzlVarZzb == null ? PendingResults.zza(Status.zzagC, googleApiClient) : zza(googleApiClient, zzlVarZzb, (PendingIntent) null, new zza() { // from class: com.google.android.gms.internal.zzpf.3
            @Override // com.google.android.gms.internal.zzpf.zza
            public void zzuI() {
                zzl.zza.zzuu().zzc(onDataPointListener);
            }
        });
    }
}
