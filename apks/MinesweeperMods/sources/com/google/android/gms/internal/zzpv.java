package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.plus.PlusShare;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class zzpv extends com.google.android.gms.measurement.zze {
    public boolean zzaUP;
    public String zzaxl;

    public final String getDescription() {
        return this.zzaxl;
    }

    public final void setDescription(String str) {
        this.zzaxl = str;
    }

    public final String toString() {
        HashMap map = new HashMap();
        map.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, this.zzaxl);
        map.put("fatal", Boolean.valueOf(this.zzaUP));
        return zzF(map);
    }

    public final boolean zzBa() {
        return this.zzaUP;
    }

    @Override // com.google.android.gms.measurement.zze
    public final void zza(zzpv zzpvVar) {
        if (!TextUtils.isEmpty(this.zzaxl)) {
            zzpvVar.zzaxl = this.zzaxl;
        }
        if (this.zzaUP) {
            zzpvVar.zzaUP = this.zzaUP;
        }
    }

    public final void zzao(boolean z) {
        this.zzaUP = z;
    }
}
