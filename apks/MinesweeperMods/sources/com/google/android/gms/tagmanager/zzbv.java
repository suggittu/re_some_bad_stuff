package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import java.util.Map;

/* loaded from: classes2.dex */
abstract class zzbv extends zzca {
    public zzbv(String str) {
        super(str);
    }

    @Override // com.google.android.gms.tagmanager.zzca
    protected boolean zza(zzag.zza zzaVar, zzag.zza zzaVar2, Map map) {
        zzde zzdeVarZzh = zzdf.zzh(zzaVar);
        zzde zzdeVarZzh2 = zzdf.zzh(zzaVar2);
        if (zzdeVarZzh == zzdf.zzHD() || zzdeVarZzh2 == zzdf.zzHD()) {
            return false;
        }
        return zza(zzdeVarZzh, zzdeVarZzh2, map);
    }

    protected abstract boolean zza(zzde zzdeVar, zzde zzdeVar2, Map map);
}
