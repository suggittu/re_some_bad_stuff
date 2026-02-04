package com.google.android.gms.common.api;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.Strategy;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public final class Api {
    private final String mName;
    private final zzc zzaeE;
    private final zza zzafW;
    private final zze zzafX;
    private final zzf zzafY;

    public interface ApiOptions {

        public interface HasOptions extends ApiOptions {
        }

        public final class NoOptions implements NotRequiredOptions {
            private NoOptions() {
            }
        }

        public interface NotRequiredOptions extends ApiOptions {
        }

        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    public abstract class zza {
        public int getPriority() {
            return Strategy.TTL_SECONDS_INFINITE;
        }

        public abstract zzb zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, Object obj, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener);

        public List zzo(Object obj) {
            return Collections.emptyList();
        }
    }

    public interface zzb {
        void disconnect();

        void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

        boolean isConnected();

        void zza(GoogleApiClient.zza zzaVar);

        void zza(zzp zzpVar, Set set);

        boolean zzmE();

        boolean zznb();

        Intent zznc();

        IBinder zzoT();
    }

    public final class zzc {
    }

    public interface zzd {
        IInterface zzW(IBinder iBinder);

        void zza(int i, IInterface iInterface);

        String zzgu();

        String zzgv();
    }

    public interface zze {
        int getPriority();

        int zzoU();

        zzd zzq(Object obj);
    }

    public final class zzf {
    }

    public Api(String str, zza zzaVar, zzc zzcVar) {
        zzx.zzb(zzaVar, "Cannot construct an Api with a null ClientBuilder");
        zzx.zzb(zzcVar, "Cannot construct an Api with a null ClientKey");
        this.mName = str;
        this.zzafW = zzaVar;
        this.zzafX = null;
        this.zzaeE = zzcVar;
        this.zzafY = null;
    }

    public final String getName() {
        return this.mName;
    }

    public final zza zzoP() {
        zzx.zza(this.zzafW != null, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.zzafW;
    }

    public final zze zzoQ() {
        zzx.zza(this.zzafX != null, "This API was constructed with a ClientBuilder. Use getClientBuilder");
        return this.zzafX;
    }

    public final zzc zzoR() {
        zzx.zza(this.zzaeE != null, "This API was constructed with a SimpleClientKey. Use getSimpleClientKey");
        return this.zzaeE;
    }

    public final boolean zzoS() {
        return this.zzafY != null;
    }
}
