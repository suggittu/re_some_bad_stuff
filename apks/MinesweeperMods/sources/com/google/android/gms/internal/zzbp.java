package com.google.android.gms.internal;

import android.content.SharedPreferences;

@zzhb
/* loaded from: classes2.dex */
public abstract class zzbp {
    private final int zzvr;
    private final String zzvs;
    private final Object zzvt;

    private zzbp(int i, String str, Object obj) {
        this.zzvr = i;
        this.zzvs = str;
        this.zzvt = obj;
        com.google.android.gms.ads.internal.zzr.zzbK().zza(this);
    }

    public static zzbp zza(int i, String str) {
        zzbp zzbpVarZza = zza(i, str, (String) null);
        com.google.android.gms.ads.internal.zzr.zzbK().zzb(zzbpVarZza);
        return zzbpVarZza;
    }

    public static zzbp zza(int i, String str, int i2) {
        return new zzbp(i, str, Integer.valueOf(i2)) { // from class: com.google.android.gms.internal.zzbp.2
            @Override // com.google.android.gms.internal.zzbp
            /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
            public final Integer zza(SharedPreferences sharedPreferences) {
                return Integer.valueOf(sharedPreferences.getInt(getKey(), ((Integer) zzdq()).intValue()));
            }
        };
    }

    public static zzbp zza(int i, String str, long j) {
        return new zzbp(i, str, Long.valueOf(j)) { // from class: com.google.android.gms.internal.zzbp.3
            @Override // com.google.android.gms.internal.zzbp
            /* renamed from: zzd, reason: merged with bridge method [inline-methods] */
            public final Long zza(SharedPreferences sharedPreferences) {
                return Long.valueOf(sharedPreferences.getLong(getKey(), ((Long) zzdq()).longValue()));
            }
        };
    }

    public static zzbp zza(int i, String str, Boolean bool) {
        return new zzbp(i, str, bool) { // from class: com.google.android.gms.internal.zzbp.1
            @Override // com.google.android.gms.internal.zzbp
            /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
            public final Boolean zza(SharedPreferences sharedPreferences) {
                return Boolean.valueOf(sharedPreferences.getBoolean(getKey(), ((Boolean) zzdq()).booleanValue()));
            }
        };
    }

    public static zzbp zza(int i, String str, String str2) {
        return new zzbp(i, str, str2) { // from class: com.google.android.gms.internal.zzbp.4
            @Override // com.google.android.gms.internal.zzbp
            /* renamed from: zze, reason: merged with bridge method [inline-methods] */
            public final String zza(SharedPreferences sharedPreferences) {
                return sharedPreferences.getString(getKey(), (String) zzdq());
            }
        };
    }

    public static zzbp zzb(int i, String str) {
        zzbp zzbpVarZza = zza(i, str, (String) null);
        com.google.android.gms.ads.internal.zzr.zzbK().zzc(zzbpVarZza);
        return zzbpVarZza;
    }

    public Object get() {
        return com.google.android.gms.ads.internal.zzr.zzbL().zzd(this);
    }

    public String getKey() {
        return this.zzvs;
    }

    protected abstract Object zza(SharedPreferences sharedPreferences);

    public Object zzdq() {
        return this.zzvt;
    }
}
