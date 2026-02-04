package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.zza;
import java.util.Collections;

/* loaded from: classes2.dex */
public class zzi implements zzk {
    private final zzl zzahj;

    public zzi(zzl zzlVar) {
        this.zzahj = zzlVar;
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public void begin() {
        this.zzahj.zzpM();
        this.zzahj.zzagW.zzahU = Collections.emptySet();
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public void connect() {
        this.zzahj.zzpK();
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public boolean disconnect() {
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public void onConnected(Bundle bundle) {
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public void onConnectionSuspended(int i) {
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public zza.AbstractC0036zza zza(zza.AbstractC0036zza abstractC0036zza) {
        this.zzahj.zzagW.zzahN.add(abstractC0036zza);
        return abstractC0036zza;
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public void zza(ConnectionResult connectionResult, Api api, int i) {
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public zza.AbstractC0036zza zzb(zza.AbstractC0036zza abstractC0036zza) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
