package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.internal.zzr;
import com.google.android.gms.common.api.internal.zzv;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes2.dex */
public final class PendingResults {

    final class zza extends com.google.android.gms.common.api.internal.zzb {
        private final Result zzagx;

        public zza(Result result) {
            super(Looper.getMainLooper());
            this.zzagx = result;
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        protected final Result zzc(Status status) {
            if (status.getStatusCode() != this.zzagx.getStatus().getStatusCode()) {
                throw new UnsupportedOperationException("Creating failed results is not supported");
            }
            return this.zzagx;
        }
    }

    final class zzb extends com.google.android.gms.common.api.internal.zzb {
        private final Result zzagy;

        public zzb(GoogleApiClient googleApiClient, Result result) {
            super(googleApiClient);
            this.zzagy = result;
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        protected final Result zzc(Status status) {
            return this.zzagy;
        }
    }

    final class zzc extends com.google.android.gms.common.api.internal.zzb {
        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        protected final Result zzc(Status status) {
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    private PendingResults() {
    }

    public static PendingResult canceledPendingResult() {
        zzv zzvVar = new zzv(Looper.getMainLooper());
        zzvVar.cancel();
        return zzvVar;
    }

    public static PendingResult canceledPendingResult(Result result) {
        zzx.zzb(result, "Result must not be null");
        zzx.zzb(result.getStatus().getStatusCode() == 16, "Status code must be CommonStatusCodes.CANCELED");
        zza zzaVar = new zza(result);
        zzaVar.cancel();
        return zzaVar;
    }

    public static OptionalPendingResult immediatePendingResult(Result result) {
        zzx.zzb(result, "Result must not be null");
        zzc zzcVar = new zzc(null);
        zzcVar.zza(result);
        return new zzr(zzcVar);
    }

    public static PendingResult immediatePendingResult(Status status) {
        zzx.zzb(status, "Result must not be null");
        zzv zzvVar = new zzv(Looper.getMainLooper());
        zzvVar.zza(status);
        return zzvVar;
    }

    public static PendingResult zza(Result result, GoogleApiClient googleApiClient) {
        zzx.zzb(result, "Result must not be null");
        zzx.zzb(!result.getStatus().isSuccess(), "Status code must not be SUCCESS");
        zzb zzbVar = new zzb(googleApiClient, result);
        zzbVar.zza(result);
        return zzbVar;
    }

    public static PendingResult zza(Status status, GoogleApiClient googleApiClient) {
        zzx.zzb(status, "Result must not be null");
        zzv zzvVar = new zzv(googleApiClient);
        zzvVar.zza(status);
        return zzvVar;
    }

    public static OptionalPendingResult zzb(Result result, GoogleApiClient googleApiClient) {
        zzx.zzb(result, "Result must not be null");
        zzc zzcVar = new zzc(googleApiClient);
        zzcVar.zza(result);
        return new zzr(zzcVar);
    }
}
