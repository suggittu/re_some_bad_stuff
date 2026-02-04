package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.zza;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public interface zzp {

    public interface zza {
        void zzc(int i, boolean z);

        void zzd(ConnectionResult connectionResult);

        void zzi(Bundle bundle);
    }

    ConnectionResult blockingConnect();

    ConnectionResult blockingConnect(long j, TimeUnit timeUnit);

    void connect();

    boolean disconnect();

    void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    @Nullable
    ConnectionResult getConnectionResult(@NonNull Api api);

    boolean isConnected();

    boolean isConnecting();

    zza.AbstractC0036zza zza(@NonNull zza.AbstractC0036zza abstractC0036zza);

    boolean zza(zzu zzuVar);

    zza.AbstractC0036zza zzb(@NonNull zza.AbstractC0036zza abstractC0036zza);

    void zzoW();

    void zzpj();
}
