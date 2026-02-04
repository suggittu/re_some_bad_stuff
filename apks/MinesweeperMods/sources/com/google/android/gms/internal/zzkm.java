package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzkp;

/* loaded from: classes2.dex */
public class zzkm extends com.google.android.gms.common.internal.zzj {
    private final String zzUW;

    public zzkm(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, com.google.android.gms.common.internal.zzf zzfVar) {
        super(context, looper, 77, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.zzUW = zzfVar.zzqv();
    }

    private Bundle zzmm() {
        Bundle bundle = new Bundle();
        bundle.putString("authPackage", this.zzUW);
        return bundle;
    }

    public void zza(zzko zzkoVar) {
        try {
            ((zzkp) zzqJ()).zza(zzkoVar);
        } catch (RemoteException e) {
        }
    }

    public void zza(zzko zzkoVar, String str) {
        try {
            ((zzkp) zzqJ()).zza(zzkoVar, str);
        } catch (RemoteException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* renamed from: zzaj, reason: merged with bridge method [inline-methods] */
    public zzkp zzW(IBinder iBinder) {
        return zzkp.zza.zzal(iBinder);
    }

    public void zzb(zzko zzkoVar, String str) {
        try {
            ((zzkp) zzqJ()).zzb(zzkoVar, str);
        } catch (RemoteException e) {
        }
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgu() {
        return "com.google.android.gms.appinvite.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgv() {
        return "com.google.android.gms.appinvite.internal.IAppInviteService";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected Bundle zzml() {
        return zzmm();
    }
}
