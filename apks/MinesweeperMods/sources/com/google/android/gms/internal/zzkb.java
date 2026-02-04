package com.google.android.gms.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzkb extends com.google.android.gms.measurement.zze {
    private Map zzPL = new HashMap(4);

    public final String toString() {
        HashMap map = new HashMap();
        for (Map.Entry entry : this.zzPL.entrySet()) {
            map.put("dimension" + entry.getKey(), entry.getValue());
        }
        return zzF(map);
    }

    @Override // com.google.android.gms.measurement.zze
    public final void zza(zzkb zzkbVar) {
        zzkbVar.zzPL.putAll(this.zzPL);
    }

    public final Map zziP() {
        return Collections.unmodifiableMap(this.zzPL);
    }
}
