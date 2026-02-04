package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzj;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public class zza {

    /* renamed from: com.google.android.gms.common.api.internal.zza$zza, reason: collision with other inner class name */
    public abstract class AbstractC0036zza extends com.google.android.gms.common.api.internal.zzb implements zzb, zzj.zze {
        private final Api.zzc zzaeE;
        private AtomicReference zzagH;

        public AbstractC0036zza(Api.zzc zzcVar, GoogleApiClient googleApiClient) {
            super((GoogleApiClient) com.google.android.gms.common.internal.zzx.zzb(googleApiClient, "GoogleApiClient must not be null"));
            this.zzagH = new AtomicReference();
            this.zzaeE = (Api.zzc) com.google.android.gms.common.internal.zzx.zzz(zzcVar);
        }

        private void zza(RemoteException remoteException) {
            zzw(new Status(8, remoteException.getLocalizedMessage(), null));
        }

        protected abstract void zza(Api.zzb zzbVar);

        @Override // com.google.android.gms.common.api.internal.zzj.zze
        public void zza(zzj.zzd zzdVar) {
            this.zzagH.set(zzdVar);
        }

        @Override // com.google.android.gms.common.api.internal.zzj.zze
        public final void zzb(Api.zzb zzbVar) throws DeadObjectException {
            try {
                zza(zzbVar);
            } catch (DeadObjectException e) {
                zza(e);
                throw e;
            } catch (RemoteException e2) {
                zza(e2);
            }
        }

        @Override // com.google.android.gms.common.api.internal.zzj.zze
        public final Api.zzc zzoR() {
            return this.zzaeE;
        }

        @Override // com.google.android.gms.common.api.internal.zzj.zze
        public void zzpe() {
            setResultCallback(null);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        protected void zzpf() {
            zzj.zzd zzdVar = (zzj.zzd) this.zzagH.getAndSet(null);
            if (zzdVar != null) {
                zzdVar.zzc(this);
            }
        }

        @Override // com.google.android.gms.common.api.internal.zza.zzb
        public /* synthetic */ void zzs(Object obj) {
            super.zza((Result) obj);
        }

        @Override // com.google.android.gms.common.api.internal.zza.zzb, com.google.android.gms.common.api.internal.zzj.zze
        public final void zzw(Status status) {
            com.google.android.gms.common.internal.zzx.zzb(!status.isSuccess(), "Failed result must not be success");
            zza(zzc(status));
        }
    }

    public interface zzb {
        void zzs(Object obj);

        void zzw(Status status);
    }
}
