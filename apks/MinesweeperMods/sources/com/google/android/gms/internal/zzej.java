package com.google.android.gms.internal;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

@zzhb
/* loaded from: classes2.dex */
public class zzej implements zzei {
    private final zzeh zzBx;
    private final HashSet zzBy = new HashSet();

    public zzej(zzeh zzehVar) {
        this.zzBx = zzehVar;
    }

    @Override // com.google.android.gms.internal.zzeh
    public void zza(String str, zzdf zzdfVar) {
        this.zzBx.zza(str, zzdfVar);
        this.zzBy.add(new AbstractMap.SimpleEntry(str, zzdfVar));
    }

    @Override // com.google.android.gms.internal.zzeh
    public void zza(String str, JSONObject jSONObject) {
        this.zzBx.zza(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.zzeh
    public void zzb(String str, zzdf zzdfVar) {
        this.zzBx.zzb(str, zzdfVar);
        this.zzBy.remove(new AbstractMap.SimpleEntry(str, zzdfVar));
    }

    @Override // com.google.android.gms.internal.zzeh
    public void zzb(String str, JSONObject jSONObject) {
        this.zzBx.zzb(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.zzeh
    public void zze(String str, String str2) {
        this.zzBx.zze(str, str2);
    }

    @Override // com.google.android.gms.internal.zzei
    public void zzew() {
        Iterator it = this.zzBy.iterator();
        while (it.hasNext()) {
            AbstractMap.SimpleEntry simpleEntry = (AbstractMap.SimpleEntry) it.next();
            zzin.v("Unregistering eventhandler: " + ((zzdf) simpleEntry.getValue()).toString());
            this.zzBx.zzb((String) simpleEntry.getKey(), (zzdf) simpleEntry.getValue());
        }
        this.zzBy.clear();
    }
}
