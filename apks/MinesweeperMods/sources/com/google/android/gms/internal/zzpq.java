package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class zzpq extends com.google.android.gms.measurement.zze {
    private String zzSE;
    private String zzSF;
    private String zzaUE;
    private String zzaUa;

    public final void setAppId(String str) {
        this.zzaUa = str;
    }

    public final void setAppInstallerId(String str) {
        this.zzaUE = str;
    }

    public final void setAppName(String str) {
        this.zzSE = str;
    }

    public final void setAppVersion(String str) {
        this.zzSF = str;
    }

    public final String toString() {
        HashMap map = new HashMap();
        map.put("appName", this.zzSE);
        map.put("appVersion", this.zzSF);
        map.put("appId", this.zzaUa);
        map.put("appInstallerId", this.zzaUE);
        return zzF(map);
    }

    public final String zzAJ() {
        return this.zzaUE;
    }

    @Override // com.google.android.gms.measurement.zze
    public final void zza(zzpq zzpqVar) {
        if (!TextUtils.isEmpty(this.zzSE)) {
            zzpqVar.zzSE = this.zzSE;
        }
        if (!TextUtils.isEmpty(this.zzSF)) {
            zzpqVar.zzSF = this.zzSF;
        }
        if (!TextUtils.isEmpty(this.zzaUa)) {
            zzpqVar.zzaUa = this.zzaUa;
        }
        if (TextUtils.isEmpty(this.zzaUE)) {
            return;
        }
        zzpqVar.zzaUE = this.zzaUE;
    }

    public final String zzlg() {
        return this.zzSE;
    }

    public final String zzli() {
        return this.zzSF;
    }

    public final String zzwK() {
        return this.zzaUa;
    }
}
