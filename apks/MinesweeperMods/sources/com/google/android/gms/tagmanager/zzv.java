package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import java.util.Map;

/* loaded from: classes2.dex */
class zzv extends zzak {
    private static final String ID = com.google.android.gms.internal.zzad.CUSTOM_VAR.toString();
    private static final String NAME = com.google.android.gms.internal.zzae.NAME.toString();
    private static final String zzbiA = com.google.android.gms.internal.zzae.DEFAULT_VALUE.toString();
    private final DataLayer zzbhN;

    public zzv(DataLayer dataLayer) {
        super(ID, NAME);
        this.zzbhN = dataLayer;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzFW() {
        return false;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzP(Map map) {
        Object obj = this.zzbhN.get(zzdf.zzg((zzag.zza) map.get(NAME)));
        if (obj != null) {
            return zzdf.zzR(obj);
        }
        zzag.zza zzaVar = (zzag.zza) map.get(zzbiA);
        return zzaVar != null ? zzaVar : zzdf.zzHF();
    }
}
