package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import java.util.Map;

/* loaded from: classes2.dex */
abstract class zzcz extends zzca {
    public zzcz(String str) {
        super(str);
    }

    @Override // com.google.android.gms.tagmanager.zzca
    protected boolean zza(zzag.zza zzaVar, zzag.zza zzaVar2, Map map) {
        String strZzg = zzdf.zzg(zzaVar);
        String strZzg2 = zzdf.zzg(zzaVar2);
        if (strZzg == zzdf.zzHE() || strZzg2 == zzdf.zzHE()) {
            return false;
        }
        return zza(strZzg, strZzg2, map);
    }

    protected abstract boolean zza(String str, String str2, Map map);
}
