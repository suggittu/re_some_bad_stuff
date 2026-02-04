package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

/* loaded from: classes2.dex */
public final class zzqz implements People {

    abstract class zza extends Plus.zza {
        private zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzbg, reason: merged with bridge method [inline-methods] */
        public People.LoadPeopleResult zzc(final Status status) {
            return new People.LoadPeopleResult() { // from class: com.google.android.gms.internal.zzqz.zza.1
                @Override // com.google.android.gms.plus.People.LoadPeopleResult
                public String getNextPageToken() {
                    return null;
                }

                @Override // com.google.android.gms.plus.People.LoadPeopleResult
                public PersonBuffer getPersonBuffer() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }

                @Override // com.google.android.gms.common.api.Releasable
                public void release() {
                }
            };
        }
    }

    @Override // com.google.android.gms.plus.People
    public final Person getCurrentPerson(GoogleApiClient googleApiClient) {
        return Plus.zzf(googleApiClient, true).zzFa();
    }

    @Override // com.google.android.gms.plus.People
    @SuppressLint({"MissingRemoteException"})
    public final PendingResult load(GoogleApiClient googleApiClient, final Collection collection) {
        return googleApiClient.zza(new zza(googleApiClient) { // from class: com.google.android.gms.internal.zzqz.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(com.google.android.gms.plus.internal.zze zzeVar) {
                zzeVar.zza(this, collection);
            }
        });
    }

    @Override // com.google.android.gms.plus.People
    @SuppressLint({"MissingRemoteException"})
    public final PendingResult load(GoogleApiClient googleApiClient, final String... strArr) {
        return googleApiClient.zza(new zza(googleApiClient) { // from class: com.google.android.gms.internal.zzqz.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(com.google.android.gms.plus.internal.zze zzeVar) {
                zzeVar.zzd(this, strArr);
            }
        });
    }

    @Override // com.google.android.gms.plus.People
    @SuppressLint({"MissingRemoteException"})
    public final PendingResult loadConnected(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zza(googleApiClient) { // from class: com.google.android.gms.internal.zzqz.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(com.google.android.gms.plus.internal.zze zzeVar) {
                zzeVar.zzp(this);
            }
        });
    }

    @Override // com.google.android.gms.plus.People
    @SuppressLint({"MissingRemoteException"})
    public final PendingResult loadVisible(GoogleApiClient googleApiClient, final int i, final String str) {
        return googleApiClient.zza(new zza(googleApiClient) { // from class: com.google.android.gms.internal.zzqz.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(com.google.android.gms.plus.internal.zze zzeVar) {
                zza(zzeVar.zza(this, i, str));
            }
        });
    }

    @Override // com.google.android.gms.plus.People
    @SuppressLint({"MissingRemoteException"})
    public final PendingResult loadVisible(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zza(new zza(googleApiClient) { // from class: com.google.android.gms.internal.zzqz.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(com.google.android.gms.plus.internal.zze zzeVar) {
                zza(zzeVar.zzq(this, str));
            }
        });
    }
}
