package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.flags.impl.zza;
import com.google.android.gms.internal.zzpk;

/* loaded from: classes2.dex */
public class FlagProviderImpl extends zzpk.zza {
    private boolean zzqA = false;
    private SharedPreferences zzvx;

    @Override // com.google.android.gms.internal.zzpk
    public boolean getBooleanFlagValue(String str, boolean z, int i) {
        return zza.C0070zza.zza(this.zzvx, str, Boolean.valueOf(z)).booleanValue();
    }

    @Override // com.google.android.gms.internal.zzpk
    public int getIntFlagValue(String str, int i, int i2) {
        return zza.zzb.zza(this.zzvx, str, Integer.valueOf(i)).intValue();
    }

    @Override // com.google.android.gms.internal.zzpk
    public long getLongFlagValue(String str, long j, int i) {
        return zza.zzc.zza(this.zzvx, str, Long.valueOf(j)).longValue();
    }

    @Override // com.google.android.gms.internal.zzpk
    public String getStringFlagValue(String str, String str2, int i) {
        return zza.zzd.zza(this.zzvx, str, str2);
    }

    @Override // com.google.android.gms.internal.zzpk
    public void init(zzd zzdVar) {
        Context context = (Context) zze.zzp(zzdVar);
        if (this.zzqA) {
            return;
        }
        try {
            this.zzvx = zzb.zzw(context.createPackageContext("com.google.android.gms", 0));
            this.zzqA = true;
        } catch (PackageManager.NameNotFoundException e) {
        }
    }
}
