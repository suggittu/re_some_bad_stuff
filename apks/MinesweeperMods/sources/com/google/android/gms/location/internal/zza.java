package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognition;
import com.google.android.gms.location.ActivityRecognitionApi;

/* loaded from: classes2.dex */
public class zza implements ActivityRecognitionApi {

    /* renamed from: com.google.android.gms.location.internal.zza$zza, reason: collision with other inner class name */
    abstract class AbstractC0176zza extends ActivityRecognition.zza {
        public AbstractC0176zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            return status;
        }
    }

    @Override // com.google.android.gms.location.ActivityRecognitionApi
    public PendingResult removeActivityUpdates(GoogleApiClient googleApiClient, final PendingIntent pendingIntent) {
        return googleApiClient.zzb(new AbstractC0176zza(googleApiClient) { // from class: com.google.android.gms.location.internal.zza.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzl zzlVar) {
                zzlVar.zza(pendingIntent);
                zza(Status.zzagC);
            }
        });
    }

    @Override // com.google.android.gms.location.ActivityRecognitionApi
    public PendingResult requestActivityUpdates(GoogleApiClient googleApiClient, final long j, final PendingIntent pendingIntent) {
        return googleApiClient.zzb(new AbstractC0176zza(googleApiClient) { // from class: com.google.android.gms.location.internal.zza.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzl zzlVar) {
                zzlVar.zza(j, pendingIntent);
                zza(Status.zzagC);
            }
        });
    }
}
