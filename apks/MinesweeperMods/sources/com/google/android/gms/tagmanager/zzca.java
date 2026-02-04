package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public abstract class zzca extends zzak {
    private static final String zzbiQ = com.google.android.gms.internal.zzae.ARG0.toString();
    private static final String zzbjO = com.google.android.gms.internal.zzae.ARG1.toString();

    public zzca(String str) {
        super(str, zzbiQ, zzbjO);
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzFW() {
        return true;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public /* bridge */ /* synthetic */ String zzGB() {
        return super.zzGB();
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public /* bridge */ /* synthetic */ Set zzGC() {
        return super.zzGC();
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzP(Map map) {
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            if (((zzag.zza) it.next()) == zzdf.zzHF()) {
                return zzdf.zzR(false);
            }
        }
        zzag.zza zzaVar = (zzag.zza) map.get(zzbiQ);
        zzag.zza zzaVar2 = (zzag.zza) map.get(zzbjO);
        return zzdf.zzR(Boolean.valueOf((zzaVar == null || zzaVar2 == null) ? false : zza(zzaVar, zzaVar2, map)));
    }

    protected abstract boolean zza(zzag.zza zzaVar, zzag.zza zzaVar2, Map map);
}
