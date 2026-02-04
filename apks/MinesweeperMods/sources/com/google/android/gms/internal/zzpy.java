package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.plus.PlusShare;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class zzpy extends com.google.android.gms.measurement.zze {
    public String mCategory;
    public String zzaUO;
    public String zzaVa;
    public long zzaVb;

    public final String getLabel() {
        return this.zzaUO;
    }

    public final long getTimeInMillis() {
        return this.zzaVb;
    }

    public final void setTimeInMillis(long j) {
        this.zzaVb = j;
    }

    public final String toString() {
        HashMap map = new HashMap();
        map.put("variableName", this.zzaVa);
        map.put("timeInMillis", Long.valueOf(this.zzaVb));
        map.put("category", this.mCategory);
        map.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, this.zzaUO);
        return zzF(map);
    }

    public final String zzAZ() {
        return this.mCategory;
    }

    public final String zzBh() {
        return this.zzaVa;
    }

    @Override // com.google.android.gms.measurement.zze
    public final void zza(zzpy zzpyVar) {
        if (!TextUtils.isEmpty(this.zzaVa)) {
            zzpyVar.zzaVa = this.zzaVa;
        }
        if (this.zzaVb != 0) {
            zzpyVar.zzaVb = this.zzaVb;
        }
        if (!TextUtils.isEmpty(this.mCategory)) {
            zzpyVar.mCategory = this.mCategory;
        }
        if (TextUtils.isEmpty(this.zzaUO)) {
            return;
        }
        zzpyVar.zzaUO = this.zzaUO;
    }

    public final void zzeE(String str) {
        this.mCategory = str;
    }

    public final void zzeG(String str) {
        this.zzaUO = str;
    }

    public final void zzeL(String str) {
        this.zzaVa = str;
    }
}
