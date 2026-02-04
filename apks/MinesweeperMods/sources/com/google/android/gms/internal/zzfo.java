package com.google.android.gms.internal;

import java.util.Map;

@zzhb
/* loaded from: classes2.dex */
public class zzfo {
    private final boolean zzDp;
    private final String zzDq;
    private final zzjp zzpD;

    public zzfo(zzjp zzjpVar, Map map) {
        this.zzpD = zzjpVar;
        this.zzDq = (String) map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            this.zzDp = Boolean.parseBoolean((String) map.get("allowOrientationChange"));
        } else {
            this.zzDp = true;
        }
    }

    public void execute() {
        if (this.zzpD == null) {
            zzin.zzaK("AdWebView is null");
        } else {
            this.zzpD.setRequestedOrientation("portrait".equalsIgnoreCase(this.zzDq) ? com.google.android.gms.ads.internal.zzr.zzbE().zzhw() : "landscape".equalsIgnoreCase(this.zzDq) ? com.google.android.gms.ads.internal.zzr.zzbE().zzhv() : this.zzDp ? -1 : com.google.android.gms.ads.internal.zzr.zzbE().zzhx());
        }
    }
}
