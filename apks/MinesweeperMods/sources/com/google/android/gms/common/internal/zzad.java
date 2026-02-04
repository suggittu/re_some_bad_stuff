package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes2.dex */
public class zzad extends zzj {
    private final Api.zzd zzamx;

    public zzad(Context context, Looper looper, int i, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, zzf zzfVar, Api.zzd zzdVar) {
        super(context, looper, i, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.zzamx = zzdVar;
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected IInterface zzW(IBinder iBinder) {
        return this.zzamx.zzW(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected void zzc(int i, IInterface iInterface) {
        this.zzamx.zza(i, iInterface);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgu() {
        return this.zzamx.zzgu();
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgv() {
        return this.zzamx.zzgv();
    }
}
