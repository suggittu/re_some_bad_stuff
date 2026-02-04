package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes2.dex */
public class zzc implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    public final Api zzagT;
    private final int zzagU;
    private zzl zzagV;

    public zzc(Api api, int i) {
        this.zzagT = api;
        this.zzagU = i;
    }

    private void zzpi() {
        com.google.android.gms.common.internal.zzx.zzb(this.zzagV, "Callbacks must be attached to a GoogleApiClient instance before connecting the client.");
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void onConnected(@Nullable Bundle bundle) {
        zzpi();
        this.zzagV.onConnected(bundle);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zzpi();
        this.zzagV.zza(connectionResult, this.zzagT, this.zzagU);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void onConnectionSuspended(int i) {
        zzpi();
        this.zzagV.onConnectionSuspended(i);
    }

    public void zza(zzl zzlVar) {
        this.zzagV = zzlVar;
    }
}
