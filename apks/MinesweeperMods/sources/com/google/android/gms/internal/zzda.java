package com.google.android.gms.internal;

import java.util.Map;

@zzhb
/* loaded from: classes2.dex */
public final class zzda implements zzdf {
    private final zzdb zzyW;

    public zzda(zzdb zzdbVar) {
        this.zzyW = zzdbVar;
    }

    @Override // com.google.android.gms.internal.zzdf
    public final void zza(zzjp zzjpVar, Map map) {
        String str = (String) map.get("name");
        if (str == null) {
            zzin.zzaK("App event with no name parameter.");
        } else {
            this.zzyW.onAppEvent(str, (String) map.get("info"));
        }
    }
}
