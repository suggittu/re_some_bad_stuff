package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import java.util.Map;

/* loaded from: classes2.dex */
class zzai extends zzak {
    private static final String ID = com.google.android.gms.internal.zzad.EVENT.toString();
    private final zzcp zzbhO;

    public zzai(zzcp zzcpVar) {
        super(ID, new String[0]);
        this.zzbhO = zzcpVar;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzFW() {
        return false;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzP(Map map) {
        String strZzHe = this.zzbhO.zzHe();
        return strZzHe == null ? zzdf.zzHF() : zzdf.zzR(strZzHe);
    }
}
