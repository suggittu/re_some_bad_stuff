package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;

/* loaded from: classes2.dex */
public final class zzqy implements Moments {

    abstract class zza extends Plus.zza {
        private zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzbf, reason: merged with bridge method [inline-methods] */
        public Moments.LoadMomentsResult zzc(final Status status) {
            return new Moments.LoadMomentsResult() { // from class: com.google.android.gms.internal.zzqy.zza.1
                @Override // com.google.android.gms.plus.Moments.LoadMomentsResult
                public MomentBuffer getMomentBuffer() {
                    return null;
                }

                @Override // com.google.android.gms.plus.Moments.LoadMomentsResult
                public String getNextPageToken() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }

                @Override // com.google.android.gms.plus.Moments.LoadMomentsResult
                public String getUpdated() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Releasable
                public void release() {
                }
            };
        }
    }

    abstract class zzb extends Plus.zza {
        private zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            return status;
        }
    }

    abstract class zzc extends Plus.zza {
        private zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            return status;
        }
    }

    @Override // com.google.android.gms.plus.Moments
    @SuppressLint({"MissingRemoteException"})
    public final PendingResult load(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zza(googleApiClient) { // from class: com.google.android.gms.internal.zzqy.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(com.google.android.gms.plus.internal.zze zzeVar) {
                zzeVar.zzo(this);
            }
        });
    }

    @Override // com.google.android.gms.plus.Moments
    @SuppressLint({"MissingRemoteException"})
    public final PendingResult load(GoogleApiClient googleApiClient, final int i, final String str, final Uri uri, final String str2, final String str3) {
        return googleApiClient.zza(new zza(googleApiClient) { // from class: com.google.android.gms.internal.zzqy.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(com.google.android.gms.plus.internal.zze zzeVar) {
                zzeVar.zza(this, i, str, uri, str2, str3);
            }
        });
    }

    @Override // com.google.android.gms.plus.Moments
    @SuppressLint({"MissingRemoteException"})
    public final PendingResult remove(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.internal.zzqy.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(com.google.android.gms.plus.internal.zze zzeVar) {
                zzeVar.zzfG(str);
                zza(Status.zzagC);
            }
        });
    }

    @Override // com.google.android.gms.plus.Moments
    @SuppressLint({"MissingRemoteException"})
    public final PendingResult write(GoogleApiClient googleApiClient, final Moment moment) {
        return googleApiClient.zzb(new zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzqy.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(com.google.android.gms.plus.internal.zze zzeVar) {
                zzeVar.zza(this, moment);
            }
        });
    }
}
