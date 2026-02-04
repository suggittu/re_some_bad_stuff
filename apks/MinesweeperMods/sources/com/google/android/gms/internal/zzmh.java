package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.internal.zzmi;

/* loaded from: classes2.dex */
public final class zzmh implements zzmg {

    class zza extends zzme {
        private final zza.zzb zzamC;

        public zza(zza.zzb zzbVar) {
            this.zzamC = zzbVar;
        }

        @Override // com.google.android.gms.internal.zzme, com.google.android.gms.internal.zzmk
        public void zzcb(int i) {
            this.zzamC.zzs(new Status(i));
        }
    }

    @Override // com.google.android.gms.internal.zzmg
    public final PendingResult zzf(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zzmi.zza(googleApiClient) { // from class: com.google.android.gms.internal.zzmh.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzmj zzmjVar) {
                ((zzml) zzmjVar.zzqJ()).zza(new zza(this));
            }
        });
    }
}
