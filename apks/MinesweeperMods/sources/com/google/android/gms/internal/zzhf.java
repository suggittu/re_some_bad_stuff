package com.google.android.gms.internal;

import com.google.android.gms.internal.zzeg;
import java.util.Map;
import java.util.concurrent.Future;

@zzhb
/* loaded from: classes2.dex */
public final class zzhf {
    private String zzEY;
    private String zzJh;
    zzeg.zzd zzJj;
    zzjp zzpD;
    private final Object zzpV = new Object();
    private zzjd zzJi = new zzjd();
    public final zzdf zzJk = new zzdf() { // from class: com.google.android.gms.internal.zzhf.1
        @Override // com.google.android.gms.internal.zzdf
        public void zza(zzjp zzjpVar, Map map) {
            synchronized (zzhf.this.zzpV) {
                if (zzhf.this.zzJi.isDone()) {
                    return;
                }
                if (zzhf.this.zzEY.equals(map.get("request_id"))) {
                    zzhi zzhiVar = new zzhi(1, map);
                    zzin.zzaK("Invalid " + zzhiVar.getType() + " request error: " + zzhiVar.zzgE());
                    zzhf.this.zzJi.zzg(zzhiVar);
                }
            }
        }
    };
    public final zzdf zzJl = new zzdf() { // from class: com.google.android.gms.internal.zzhf.2
        @Override // com.google.android.gms.internal.zzdf
        public void zza(zzjp zzjpVar, Map map) {
            synchronized (zzhf.this.zzpV) {
                if (zzhf.this.zzJi.isDone()) {
                    return;
                }
                zzhi zzhiVar = new zzhi(-2, map);
                if (!zzhf.this.zzEY.equals(zzhiVar.getRequestId())) {
                    zzin.zzaK(zzhiVar.getRequestId() + " ==== " + zzhf.this.zzEY);
                    return;
                }
                String url = zzhiVar.getUrl();
                if (url == null) {
                    zzin.zzaK("URL missing in loadAdUrl GMSG.");
                    return;
                }
                if (url.contains("%40mediation_adapters%40")) {
                    String strReplaceAll = url.replaceAll("%40mediation_adapters%40", zzil.zza(zzjpVar.getContext(), (String) map.get("check_adapters"), zzhf.this.zzJh));
                    zzhiVar.setUrl(strReplaceAll);
                    zzin.v("Ad request URL modified to " + strReplaceAll);
                }
                zzhf.this.zzJi.zzg(zzhiVar);
            }
        }
    };

    public zzhf(String str, String str2) {
        this.zzJh = str2;
        this.zzEY = str;
    }

    public final void zzb(zzeg.zzd zzdVar) {
        this.zzJj = zzdVar;
    }

    public final zzeg.zzd zzgB() {
        return this.zzJj;
    }

    public final Future zzgC() {
        return this.zzJi;
    }

    public final void zzgD() {
        if (this.zzpD != null) {
            this.zzpD.destroy();
            this.zzpD = null;
        }
    }

    public final void zzh(zzjp zzjpVar) {
        this.zzpD = zzjpVar;
    }
}
