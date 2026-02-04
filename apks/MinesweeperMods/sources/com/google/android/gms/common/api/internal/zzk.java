package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.zza;

/* loaded from: classes2.dex */
public interface zzk {
    void begin();

    void connect();

    boolean disconnect();

    void onConnected(Bundle bundle);

    void onConnectionSuspended(int i);

    zza.AbstractC0036zza zza(zza.AbstractC0036zza abstractC0036zza);

    void zza(ConnectionResult connectionResult, Api api, int i);

    zza.AbstractC0036zza zzb(zza.AbstractC0036zza abstractC0036zza);
}
