package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class zzpx extends com.google.android.gms.measurement.zze {
    public String zzSU;
    public String zzaUY;
    public String zzaUZ;

    public final String getAction() {
        return this.zzSU;
    }

    public final String getTarget() {
        return this.zzaUZ;
    }

    public final String toString() {
        HashMap map = new HashMap();
        map.put("network", this.zzaUY);
        map.put("action", this.zzSU);
        map.put("target", this.zzaUZ);
        return zzF(map);
    }

    public final String zzBg() {
        return this.zzaUY;
    }

    @Override // com.google.android.gms.measurement.zze
    public final void zza(zzpx zzpxVar) {
        if (!TextUtils.isEmpty(this.zzaUY)) {
            zzpxVar.zzaUY = this.zzaUY;
        }
        if (!TextUtils.isEmpty(this.zzSU)) {
            zzpxVar.zzSU = this.zzSU;
        }
        if (TextUtils.isEmpty(this.zzaUZ)) {
            return;
        }
        zzpxVar.zzaUZ = this.zzaUZ;
    }

    public final void zzeF(String str) {
        this.zzSU = str;
    }

    public final void zzeJ(String str) {
        this.zzaUY = str;
    }

    public final void zzeK(String str) {
        this.zzaUZ = str;
    }
}
