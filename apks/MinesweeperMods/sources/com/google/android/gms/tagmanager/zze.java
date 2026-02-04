package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzag;
import java.util.Map;

/* loaded from: classes2.dex */
class zze extends zzak {
    private static final String ID = com.google.android.gms.internal.zzad.ADWORDS_CLICK_REFERRER.toString();
    private static final String zzbhD = com.google.android.gms.internal.zzae.COMPONENT.toString();
    private static final String zzbhE = com.google.android.gms.internal.zzae.CONVERSION_ID.toString();
    private final Context context;

    public zze(Context context) {
        super(ID, zzbhE);
        this.context = context;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzFW() {
        return true;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzP(Map map) {
        zzag.zza zzaVar = (zzag.zza) map.get(zzbhE);
        if (zzaVar == null) {
            return zzdf.zzHF();
        }
        String strZzg = zzdf.zzg(zzaVar);
        zzag.zza zzaVar2 = (zzag.zza) map.get(zzbhD);
        String strZzf = zzax.zzf(this.context, strZzg, zzaVar2 != null ? zzdf.zzg(zzaVar2) : null);
        return strZzf != null ? zzdf.zzR(strZzf) : zzdf.zzHF();
    }
}
