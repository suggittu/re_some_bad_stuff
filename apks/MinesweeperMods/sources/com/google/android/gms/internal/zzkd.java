package com.google.android.gms.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzkd extends com.google.android.gms.measurement.zze {
    private final Map zzxA = new HashMap();

    private String zzaW(String str) {
        com.google.android.gms.common.internal.zzx.zzcM(str);
        if (str != null && str.startsWith("&")) {
            str = str.substring(1);
        }
        com.google.android.gms.common.internal.zzx.zzh(str, "Name can not be empty or \"&\"");
        return str;
    }

    public final void set(String str, String str2) {
        this.zzxA.put(zzaW(str), str2);
    }

    public final String toString() {
        return zzF(this.zzxA);
    }

    @Override // com.google.android.gms.measurement.zze
    public final void zza(zzkd zzkdVar) {
        com.google.android.gms.common.internal.zzx.zzz(zzkdVar);
        zzkdVar.zzxA.putAll(this.zzxA);
    }

    public final Map zziR() {
        return Collections.unmodifiableMap(this.zzxA);
    }
}
