package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import android.view.Display;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlq;
import com.google.android.gms.internal.zzlr;

/* loaded from: classes2.dex */
public final class CastRemoteDisplay {
    private static final Api.zzc zzUI = new Api.zzc();
    private static final Api.zza zzUJ = new Api.zza() { // from class: com.google.android.gms.cast.CastRemoteDisplay.1
        @Override // com.google.android.gms.common.api.Api.zza
        public final zzlr zza(Context context, Looper looper, zzf zzfVar, CastRemoteDisplayOptions castRemoteDisplayOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzlr(context, looper, zzfVar, castRemoteDisplayOptions.zzZL, castRemoteDisplayOptions.zzaad, connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final Api API = new Api("CastRemoteDisplay.API", zzUJ, zzUI);
    public static final CastRemoteDisplayApi CastRemoteDisplayApi = new zzlq(zzUI);

    public final class CastRemoteDisplayOptions implements Api.ApiOptions.HasOptions {
        final CastDevice zzZL;
        final CastRemoteDisplaySessionCallbacks zzaad;

        public final class Builder {
            CastDevice zzZO;
            CastRemoteDisplaySessionCallbacks zzaae;

            public Builder(CastDevice castDevice, CastRemoteDisplaySessionCallbacks castRemoteDisplaySessionCallbacks) {
                zzx.zzb(castDevice, "CastDevice parameter cannot be null");
                this.zzZO = castDevice;
                this.zzaae = castRemoteDisplaySessionCallbacks;
            }

            public final CastRemoteDisplayOptions build() {
                return new CastRemoteDisplayOptions(this);
            }
        }

        private CastRemoteDisplayOptions(Builder builder) {
            this.zzZL = builder.zzZO;
            this.zzaad = builder.zzaae;
        }
    }

    public interface CastRemoteDisplaySessionCallbacks {
        void onRemoteDisplayEnded(Status status);
    }

    public interface CastRemoteDisplaySessionResult extends Result {
        Display getPresentationDisplay();
    }

    private CastRemoteDisplay() {
    }
}
