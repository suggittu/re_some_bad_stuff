package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import java.util.Map;

/* loaded from: classes2.dex */
class zzbi extends zzak {
    private static final String ID = com.google.android.gms.internal.zzad.LOWERCASE_STRING.toString();
    private static final String zzbiQ = com.google.android.gms.internal.zzae.ARG0.toString();

    public zzbi() {
        super(ID, zzbiQ);
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzFW() {
        return true;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzP(Map map) {
        return zzdf.zzR(zzdf.zzg((zzag.zza) map.get(zzbiQ)).toLowerCase());
    }
}
