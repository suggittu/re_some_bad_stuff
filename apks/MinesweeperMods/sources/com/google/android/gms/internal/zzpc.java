package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.fitness.HistoryApi;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DailyTotalRequest;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataInsertRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.DataUpdateRequest;
import com.google.android.gms.fitness.result.DailyTotalResult;
import com.google.android.gms.fitness.result.DataReadResult;
import com.google.android.gms.internal.zzob;
import com.google.android.gms.internal.zzog;
import com.google.android.gms.internal.zzoh;

/* loaded from: classes2.dex */
public class zzpc implements HistoryApi {

    class zza extends zzoh.zza {
        private int zzaAc;
        private DataReadResult zzaAd;
        private final zza.zzb zzamC;

        private zza(zza.zzb zzbVar) {
            this.zzaAc = 0;
            this.zzaAd = null;
            this.zzamC = zzbVar;
        }

        @Override // com.google.android.gms.internal.zzoh
        public void zza(DataReadResult dataReadResult) {
            synchronized (this) {
                if (Log.isLoggable("Fitness", 2)) {
                    Log.v("Fitness", "Received batch result " + this.zzaAc);
                }
                if (this.zzaAd == null) {
                    this.zzaAd = dataReadResult;
                } else {
                    this.zzaAd.zzb(dataReadResult);
                }
                this.zzaAc++;
                if (this.zzaAc == this.zzaAd.zzvj()) {
                    this.zzamC.zzs(this.zzaAd);
                }
            }
        }
    }

    private PendingResult zza(GoogleApiClient googleApiClient, final DataSet dataSet, final boolean z) {
        com.google.android.gms.common.internal.zzx.zzb(dataSet, "Must set the data set");
        com.google.android.gms.common.internal.zzx.zza(!dataSet.getDataPoints().isEmpty(), "Cannot use an empty data set");
        com.google.android.gms.common.internal.zzx.zzb(dataSet.getDataSource().zzum(), "Must set the app package name for the data source");
        return googleApiClient.zza(new zzob.zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzpc.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzob zzobVar) {
                ((zzom) zzobVar.zzqJ()).zza(new DataInsertRequest(dataSet, new zzph(this), z));
            }
        });
    }

    @Override // com.google.android.gms.fitness.HistoryApi
    public PendingResult deleteData(GoogleApiClient googleApiClient, final DataDeleteRequest dataDeleteRequest) {
        return googleApiClient.zza(new zzob.zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzpc.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzob zzobVar) {
                ((zzom) zzobVar.zzqJ()).zza(new DataDeleteRequest(dataDeleteRequest, new zzph(this)));
            }
        });
    }

    @Override // com.google.android.gms.fitness.HistoryApi
    public PendingResult insertData(GoogleApiClient googleApiClient, DataSet dataSet) {
        return zza(googleApiClient, dataSet, false);
    }

    @Override // com.google.android.gms.fitness.HistoryApi
    public PendingResult readDailyTotal(GoogleApiClient googleApiClient, final DataType dataType) {
        return googleApiClient.zza(new zzob.zza(googleApiClient) { // from class: com.google.android.gms.internal.zzpc.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzL, reason: merged with bridge method [inline-methods] */
            public DailyTotalResult zzc(Status status) {
                return DailyTotalResult.zza(status, dataType);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzob zzobVar) {
                ((zzom) zzobVar.zzqJ()).zza(new DailyTotalRequest(new zzog.zza() { // from class: com.google.android.gms.internal.zzpc.5.1
                    @Override // com.google.android.gms.internal.zzog
                    public void zza(DailyTotalResult dailyTotalResult) {
                        zza(dailyTotalResult);
                    }
                }, dataType));
            }
        });
    }

    @Override // com.google.android.gms.fitness.HistoryApi
    public PendingResult readData(GoogleApiClient googleApiClient, final DataReadRequest dataReadRequest) {
        return googleApiClient.zza(new zzob.zza(googleApiClient) { // from class: com.google.android.gms.internal.zzpc.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzK, reason: merged with bridge method [inline-methods] */
            public DataReadResult zzc(Status status) {
                return DataReadResult.zza(status, dataReadRequest);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzob zzobVar) {
                ((zzom) zzobVar.zzqJ()).zza(new DataReadRequest(dataReadRequest, new zza(this)));
            }
        });
    }

    @Override // com.google.android.gms.fitness.HistoryApi
    public PendingResult updateData(GoogleApiClient googleApiClient, final DataUpdateRequest dataUpdateRequest) {
        com.google.android.gms.common.internal.zzx.zzb(dataUpdateRequest.getDataSet(), "Must set the data set");
        com.google.android.gms.common.internal.zzx.zza(dataUpdateRequest.zzlO(), "Must set a non-zero value for startTimeMillis/startTime");
        com.google.android.gms.common.internal.zzx.zza(dataUpdateRequest.zzud(), "Must set a non-zero value for endTimeMillis/endTime");
        return googleApiClient.zza(new zzob.zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzpc.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzob zzobVar) {
                ((zzom) zzobVar.zzqJ()).zza(new DataUpdateRequest(dataUpdateRequest, new zzph(this)));
            }
        });
    }
}
