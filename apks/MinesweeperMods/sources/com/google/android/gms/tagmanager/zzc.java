package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzag;
import java.util.Map;

/* loaded from: classes2.dex */
class zzc extends zzak {
    private static final String ID = com.google.android.gms.internal.zzad.ADVERTISING_TRACKING_ENABLED.toString();
    private final zza zzbhC;

    public zzc(Context context) {
        this(zza.zzaW(context));
    }

    zzc(zza zzaVar) {
        super(ID, new String[0]);
        this.zzbhC = zzaVar;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzFW() {
        return false;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzP(Map map) {
        return zzdf.zzR(Boolean.valueOf(!this.zzbhC.isLimitAdTrackingEnabled()));
    }
}
