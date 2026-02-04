package com.google.android.gms.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzkc extends com.google.android.gms.measurement.zze {
    private Map zzPM = new HashMap(4);

    public final String toString() {
        HashMap map = new HashMap();
        for (Map.Entry entry : this.zzPM.entrySet()) {
            map.put("metric" + entry.getKey(), entry.getValue());
        }
        return zzF(map);
    }

    @Override // com.google.android.gms.measurement.zze
    public final void zza(zzkc zzkcVar) {
        zzkcVar.zzPM.putAll(this.zzPM);
    }

    public final Map zziQ() {
        return Collections.unmodifiableMap(this.zzPM);
    }
}
