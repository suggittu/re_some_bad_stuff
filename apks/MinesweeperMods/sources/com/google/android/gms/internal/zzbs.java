package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;

@zzhb
/* loaded from: classes2.dex */
public class zzbs {
    private final Object zzpV = new Object();
    private boolean zzqA = false;
    private SharedPreferences zzvx = null;

    public void initialize(Context context) {
        synchronized (this.zzpV) {
            if (this.zzqA) {
                return;
            }
            Context remoteContext = com.google.android.gms.common.zze.getRemoteContext(context);
            if (remoteContext == null) {
                return;
            }
            this.zzvx = com.google.android.gms.ads.internal.zzr.zzbJ().zzw(remoteContext);
            this.zzqA = true;
        }
    }

    public Object zzd(final zzbp zzbpVar) {
        synchronized (this.zzpV) {
            if (this.zzqA) {
                return zzjb.zzb(new Callable() { // from class: com.google.android.gms.internal.zzbs.1
                    @Override // java.util.concurrent.Callable
                    public Object call() {
                        return zzbpVar.zza(zzbs.this.zzvx);
                    }
                });
            }
            return zzbpVar.zzdq();
        }
    }
}
