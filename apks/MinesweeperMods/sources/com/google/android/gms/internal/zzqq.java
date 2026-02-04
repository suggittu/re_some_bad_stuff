package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.internal.zzqo;
import com.google.android.gms.panorama.Panorama;
import com.google.android.gms.panorama.PanoramaApi;

/* loaded from: classes2.dex */
public class zzqq implements PanoramaApi {

    abstract class zza extends zzc {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzbd, reason: merged with bridge method [inline-methods] */
        public PanoramaApi.PanoramaResult zzc(Status status) {
            return new zzqs(status, null);
        }
    }

    final class zzb extends zzqo.zza {
        private final zza.zzb zzamC;

        public zzb(zza.zzb zzbVar) {
            this.zzamC = zzbVar;
        }

        @Override // com.google.android.gms.internal.zzqo
        public final void zza(int i, Bundle bundle, int i2, Intent intent) {
            this.zzamC.zzs(new zzqs(new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null), intent));
        }
    }

    abstract class zzc extends zza.AbstractC0036zza {
        protected zzc(GoogleApiClient googleApiClient) {
            super(Panorama.zzUI, googleApiClient);
        }

        protected abstract void zza(Context context, zzqp zzqpVar);

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public final void zza(zzqr zzqrVar) {
            zza(zzqrVar.getContext(), (zzqp) zzqrVar.zzqJ());
        }
    }

    private static void zza(Context context, Uri uri) {
        context.revokeUriPermission(uri, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(final Context context, zzqp zzqpVar, final zzqo zzqoVar, final Uri uri, Bundle bundle) throws RemoteException {
        context.grantUriPermission("com.google.android.gms", uri, 1);
        try {
            zzqpVar.zza(new zzqo.zza() { // from class: com.google.android.gms.internal.zzqq.3
                @Override // com.google.android.gms.internal.zzqo
                public final void zza(int i, Bundle bundle2, int i2, Intent intent) {
                    context.revokeUriPermission(uri, 1);
                    zzqoVar.zza(i, bundle2, i2, intent);
                }
            }, uri, bundle, true);
        } catch (RemoteException e) {
            context.revokeUriPermission(uri, 1);
            throw e;
        } catch (RuntimeException e2) {
            context.revokeUriPermission(uri, 1);
            throw e2;
        }
    }

    @Override // com.google.android.gms.panorama.PanoramaApi
    public PendingResult loadPanoramaInfo(GoogleApiClient googleApiClient, final Uri uri) {
        return googleApiClient.zza(new zza(googleApiClient) { // from class: com.google.android.gms.internal.zzqq.1
            @Override // com.google.android.gms.internal.zzqq.zzc
            protected void zza(Context context, zzqp zzqpVar) {
                zzqpVar.zza(new zzb(this), uri, null, false);
            }
        });
    }

    @Override // com.google.android.gms.panorama.PanoramaApi
    public PendingResult loadPanoramaInfoAndGrantAccess(GoogleApiClient googleApiClient, final Uri uri) {
        return googleApiClient.zza(new zza(googleApiClient) { // from class: com.google.android.gms.internal.zzqq.2
            @Override // com.google.android.gms.internal.zzqq.zzc
            protected void zza(Context context, zzqp zzqpVar) throws RemoteException {
                zzqq.zza(context, zzqpVar, new zzb(this), uri, null);
            }
        });
    }
}
