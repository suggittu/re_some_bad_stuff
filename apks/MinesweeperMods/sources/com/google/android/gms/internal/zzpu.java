package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.plus.PlusShare;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class zzpu extends com.google.android.gms.measurement.zze {
    private String mCategory;
    private String zzSU;
    private long zzaDV;
    private String zzaUO;

    public final String getAction() {
        return this.zzSU;
    }

    public final String getLabel() {
        return this.zzaUO;
    }

    public final long getValue() {
        return this.zzaDV;
    }

    public final String toString() {
        HashMap map = new HashMap();
        map.put("category", this.mCategory);
        map.put("action", this.zzSU);
        map.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, this.zzaUO);
        map.put("value", Long.valueOf(this.zzaDV));
        return zzF(map);
    }

    public final String zzAZ() {
        return this.mCategory;
    }

    public final void zzN(long j) {
        this.zzaDV = j;
    }

    @Override // com.google.android.gms.measurement.zze
    public final void zza(zzpu zzpuVar) {
        if (!TextUtils.isEmpty(this.mCategory)) {
            zzpuVar.mCategory = this.mCategory;
        }
        if (!TextUtils.isEmpty(this.zzSU)) {
            zzpuVar.zzSU = this.zzSU;
        }
        if (!TextUtils.isEmpty(this.zzaUO)) {
            zzpuVar.zzaUO = this.zzaUO;
        }
        if (this.zzaDV != 0) {
            zzpuVar.zzaDV = this.zzaDV;
        }
    }

    public final void zzeE(String str) {
        this.mCategory = str;
    }

    public final void zzeF(String str) {
        this.zzSU = str;
    }

    public final void zzeG(String str) {
        this.zzaUO = str;
    }
}
