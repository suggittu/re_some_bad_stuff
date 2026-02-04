package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzag;
import java.util.Map;

/* loaded from: classes2.dex */
class zzb extends zzak {
    private static final String ID = com.google.android.gms.internal.zzad.ADVERTISER_ID.toString();
    private final zza zzbhC;

    public zzb(Context context) {
        this(zza.zzaW(context));
    }

    zzb(zza zzaVar) {
        super(ID, new String[0]);
        this.zzbhC = zzaVar;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzFW() {
        return false;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzP(Map map) {
        String strZzFQ = this.zzbhC.zzFQ();
        return strZzFQ == null ? zzdf.zzHF() : zzdf.zzR(strZzFQ);
    }
}
