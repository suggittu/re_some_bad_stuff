package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzag;
import java.util.Map;

/* loaded from: classes2.dex */
class zzaw extends zzak {
    private static final String ID = com.google.android.gms.internal.zzad.INSTALL_REFERRER.toString();
    private static final String zzbhD = com.google.android.gms.internal.zzae.COMPONENT.toString();
    private final Context context;

    public zzaw(Context context) {
        super(ID, new String[0]);
        this.context = context;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzFW() {
        return true;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzP(Map map) {
        String strZzm = zzax.zzm(this.context, ((zzag.zza) map.get(zzbhD)) != null ? zzdf.zzg((zzag.zza) map.get(zzbhD)) : null);
        return strZzm != null ? zzdf.zzR(strZzm) : zzdf.zzHF();
    }
}
