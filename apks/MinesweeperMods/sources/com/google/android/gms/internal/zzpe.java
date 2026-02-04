package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.fitness.RecordingApi;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.request.ListSubscriptionsRequest;
import com.google.android.gms.fitness.request.SubscribeRequest;
import com.google.android.gms.fitness.request.UnsubscribeRequest;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;
import com.google.android.gms.internal.zzod;
import com.google.android.gms.internal.zzor;

/* loaded from: classes2.dex */
public class zzpe implements RecordingApi {

    class zza extends zzor.zza {
        private final zza.zzb zzamC;

        private zza(zza.zzb zzbVar) {
            this.zzamC = zzbVar;
        }

        @Override // com.google.android.gms.internal.zzor
        public void zza(ListSubscriptionsResult listSubscriptionsResult) {
            this.zzamC.zzs(listSubscriptionsResult);
        }
    }

    private PendingResult zza(GoogleApiClient googleApiClient, final Subscription subscription) {
        return googleApiClient.zza(new zzod.zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzpe.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzod zzodVar) {
                ((zzoo) zzodVar.zzqJ()).zza(new SubscribeRequest(subscription, false, new zzph(this)));
            }
        });
    }

    @Override // com.google.android.gms.fitness.RecordingApi
    public PendingResult listSubscriptions(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zzod.zza(googleApiClient) { // from class: com.google.android.gms.internal.zzpe.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzM, reason: merged with bridge method [inline-methods] */
            public ListSubscriptionsResult zzc(Status status) {
                return ListSubscriptionsResult.zzT(status);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzod zzodVar) {
                ((zzoo) zzodVar.zzqJ()).zza(new ListSubscriptionsRequest(null, new zza(this)));
            }
        });
    }

    @Override // com.google.android.gms.fitness.RecordingApi
    public PendingResult listSubscriptions(GoogleApiClient googleApiClient, final DataType dataType) {
        return googleApiClient.zza(new zzod.zza(googleApiClient) { // from class: com.google.android.gms.internal.zzpe.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzM, reason: merged with bridge method [inline-methods] */
            public ListSubscriptionsResult zzc(Status status) {
                return ListSubscriptionsResult.zzT(status);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzod zzodVar) {
                ((zzoo) zzodVar.zzqJ()).zza(new ListSubscriptionsRequest(dataType, new zza(this)));
            }
        });
    }

    @Override // com.google.android.gms.fitness.RecordingApi
    public PendingResult subscribe(GoogleApiClient googleApiClient, DataSource dataSource) {
        return zza(googleApiClient, new Subscription.zza().zzb(dataSource).zzuz());
    }

    @Override // com.google.android.gms.fitness.RecordingApi
    public PendingResult subscribe(GoogleApiClient googleApiClient, DataType dataType) {
        return zza(googleApiClient, new Subscription.zza().zzb(dataType).zzuz());
    }

    @Override // com.google.android.gms.fitness.RecordingApi
    public PendingResult unsubscribe(GoogleApiClient googleApiClient, final DataSource dataSource) {
        return googleApiClient.zzb(new zzod.zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzpe.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzod zzodVar) {
                ((zzoo) zzodVar.zzqJ()).zza(new UnsubscribeRequest(null, dataSource, new zzph(this)));
            }
        });
    }

    @Override // com.google.android.gms.fitness.RecordingApi
    public PendingResult unsubscribe(GoogleApiClient googleApiClient, final DataType dataType) {
        return googleApiClient.zzb(new zzod.zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzpe.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzod zzodVar) {
                ((zzoo) zzodVar.zzqJ()).zza(new UnsubscribeRequest(dataType, null, new zzph(this)));
            }
        });
    }

    @Override // com.google.android.gms.fitness.RecordingApi
    public PendingResult unsubscribe(GoogleApiClient googleApiClient, Subscription subscription) {
        return subscription.getDataType() == null ? unsubscribe(googleApiClient, subscription.getDataSource()) : unsubscribe(googleApiClient, subscription.getDataType());
    }
}
