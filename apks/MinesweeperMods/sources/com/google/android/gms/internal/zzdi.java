package com.google.android.gms.internal;

import java.util.Map;

@zzhb
/* loaded from: classes2.dex */
public class zzdi implements zzdf {
    private final zzdj zzzy;

    public zzdi(zzdj zzdjVar) {
        this.zzzy = zzdjVar;
    }

    @Override // com.google.android.gms.internal.zzdf
    public void zza(zzjp zzjpVar, Map map) {
        boolean zEquals = "1".equals(map.get("transparentBackground"));
        boolean zEquals2 = "1".equals(map.get("blur"));
        try {
        } catch (NumberFormatException e) {
            zzin.zzb("Fail to parse float", e);
        }
        float f = map.get("blurRadius") != null ? Float.parseFloat((String) map.get("blurRadius")) : 0.0f;
        this.zzzy.zzd(zEquals);
        this.zzzy.zza(zEquals2, f);
    }
}
