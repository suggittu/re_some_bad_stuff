package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.appinvite.AppInvite;
import com.google.android.gms.appinvite.AppInviteApi;
import com.google.android.gms.appinvite.AppInviteInvitationResult;
import com.google.android.gms.appinvite.AppInviteReferral;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.internal.zzko;

/* loaded from: classes2.dex */
public class zzkl implements AppInviteApi {

    class zza extends zzko.zza {
        zza() {
        }

        @Override // com.google.android.gms.internal.zzko
        public void zza(Status status, Intent intent) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.android.gms.internal.zzko
        public void zzd(Status status) {
            throw new UnsupportedOperationException();
        }
    }

    abstract class zzb extends zza.AbstractC0036zza {
        public zzb(GoogleApiClient googleApiClient) {
            super(AppInvite.zzUI, googleApiClient);
        }
    }

    final class zzc extends zzb {
        private final String zzUO;

        public zzc(GoogleApiClient googleApiClient, String str) {
            super(googleApiClient);
            this.zzUO = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public final void zza(zzkm zzkmVar) {
            zzkmVar.zzb(new zza() { // from class: com.google.android.gms.internal.zzkl.zzc.1
                @Override // com.google.android.gms.internal.zzkl.zza, com.google.android.gms.internal.zzko
                public void zzd(Status status) {
                    zzc.this.zza(status);
                }
            }, this.zzUO);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public final Status zzc(Status status) {
            return status;
        }
    }

    final class zzd extends zzb {
        private final String zzUO;

        public zzd(GoogleApiClient googleApiClient, String str) {
            super(googleApiClient);
            this.zzUO = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public final void zza(zzkm zzkmVar) {
            zzkmVar.zza(new zza() { // from class: com.google.android.gms.internal.zzkl.zzd.1
                @Override // com.google.android.gms.internal.zzkl.zza, com.google.android.gms.internal.zzko
                public void zzd(Status status) {
                    zzd.this.zza(status);
                }
            }, this.zzUO);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public final Status zzc(Status status) {
            return status;
        }
    }

    final class zze extends zzb {
        private final Activity zzUS;
        private final boolean zzUT;
        private final Intent zzUU;

        public zze(GoogleApiClient googleApiClient, Activity activity, boolean z) {
            super(googleApiClient);
            this.zzUS = activity;
            this.zzUT = z;
            this.zzUU = this.zzUS != null ? this.zzUS.getIntent() : null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public final void zza(zzkm zzkmVar) {
            if (AppInviteReferral.hasReferral(this.zzUU)) {
                zza(new zzkn(Status.zzagC, this.zzUU));
            } else {
                zzkmVar.zza((zzko) new zza() { // from class: com.google.android.gms.internal.zzkl.zze.1
                    @Override // com.google.android.gms.internal.zzkl.zza, com.google.android.gms.internal.zzko
                    public void zza(Status status, Intent intent) {
                        zze.this.zza(new zzkn(status, intent));
                        if (AppInviteReferral.hasReferral(intent) && zze.this.zzUT && zze.this.zzUS != null) {
                            zze.this.zzUS.startActivity(intent);
                        }
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zze, reason: merged with bridge method [inline-methods] */
        public final AppInviteInvitationResult zzc(Status status) {
            return new zzkn(status, new Intent());
        }
    }

    @Override // com.google.android.gms.appinvite.AppInviteApi
    public PendingResult convertInvitation(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zza(new zzd(googleApiClient, str));
    }

    @Override // com.google.android.gms.appinvite.AppInviteApi
    public PendingResult getInvitation(GoogleApiClient googleApiClient, Activity activity, boolean z) {
        return googleApiClient.zza(new zze(googleApiClient, activity, z));
    }

    @Override // com.google.android.gms.appinvite.AppInviteApi
    public PendingResult updateInvitationOnInstall(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zza(new zzc(googleApiClient, str));
    }
}
