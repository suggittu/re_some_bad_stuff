package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zzj;
import com.google.android.gms.common.api.internal.zzl;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class zzg implements zzk {
    private final zzl zzahj;
    private boolean zzahk = false;

    public zzg(zzl zzlVar) {
        this.zzahj = zzlVar;
    }

    private void zza(zzj.zze zzeVar) {
        this.zzahj.zzagW.zzb(zzeVar);
        Api.zzb zzbVarZza = this.zzahj.zzagW.zza(zzeVar.zzoR());
        if (zzbVarZza.isConnected() || !this.zzahj.zzaio.containsKey(zzeVar.zzoR())) {
            zzeVar.zzb(zzbVarZza);
        } else {
            zzeVar.zzw(new Status(17));
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public void begin() {
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public void connect() {
        if (this.zzahk) {
            this.zzahk = false;
            this.zzahj.zza(new zzl.zza(this) { // from class: com.google.android.gms.common.api.internal.zzg.2
                @Override // com.google.android.gms.common.api.internal.zzl.zza
                public void zzpt() {
                    zzg.this.zzahj.zzais.zzi(null);
                }
            });
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public boolean disconnect() {
        if (this.zzahk) {
            return false;
        }
        if (!this.zzahj.zzagW.zzpG()) {
            this.zzahj.zzh(null);
            return true;
        }
        this.zzahk = true;
        Iterator it = this.zzahj.zzagW.zzaia.iterator();
        while (it.hasNext()) {
            ((zzx) it.next()).zzpU();
        }
        return false;
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public void onConnected(Bundle bundle) {
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public void onConnectionSuspended(int i) {
        this.zzahj.zzh(null);
        this.zzahj.zzais.zzc(i, this.zzahk);
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public zza.AbstractC0036zza zza(zza.AbstractC0036zza abstractC0036zza) {
        return zzb(abstractC0036zza);
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public void zza(ConnectionResult connectionResult, Api api, int i) {
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public zza.AbstractC0036zza zzb(zza.AbstractC0036zza abstractC0036zza) {
        try {
            zza((zzj.zze) abstractC0036zza);
        } catch (DeadObjectException e) {
            this.zzahj.zza(new zzl.zza(this) { // from class: com.google.android.gms.common.api.internal.zzg.1
                @Override // com.google.android.gms.common.api.internal.zzl.zza
                public void zzpt() {
                    zzg.this.onConnectionSuspended(1);
                }
            });
        }
        return abstractC0036zza;
    }

    void zzps() throws RemoteException {
        if (this.zzahk) {
            this.zzahk = false;
            this.zzahj.zzagW.zzaa(false);
            disconnect();
        }
    }
}
