package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import java.util.Map;

/* loaded from: classes2.dex */
class zzq extends zzak {
    private static final String ID = com.google.android.gms.internal.zzad.CONTAINER_VERSION.toString();
    private final String zzadc;

    public zzq(String str) {
        super(ID, new String[0]);
        this.zzadc = str;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzFW() {
        return true;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzP(Map map) {
        return this.zzadc == null ? zzdf.zzHF() : zzdf.zzR(this.zzadc);
    }
}
