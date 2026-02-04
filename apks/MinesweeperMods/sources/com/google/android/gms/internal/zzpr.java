package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class zzpr extends com.google.android.gms.measurement.zze {
    private String mName;
    private String zzaPI;
    private String zzaUF;
    private String zzaUG;
    private String zzaUH;
    private String zzaUI;
    private String zzaUJ;
    private String zzaUK;
    private String zzxG;
    private String zzyv;

    public final String getContent() {
        return this.zzxG;
    }

    public final String getId() {
        return this.zzyv;
    }

    public final String getName() {
        return this.mName;
    }

    public final String getSource() {
        return this.zzaPI;
    }

    public final void setName(String str) {
        this.mName = str;
    }

    public final String toString() {
        HashMap map = new HashMap();
        map.put("name", this.mName);
        map.put("source", this.zzaPI);
        map.put("medium", this.zzaUF);
        map.put("keyword", this.zzaUG);
        map.put("content", this.zzxG);
        map.put("id", this.zzyv);
        map.put("adNetworkId", this.zzaUH);
        map.put("gclid", this.zzaUI);
        map.put("dclid", this.zzaUJ);
        map.put("aclid", this.zzaUK);
        return zzF(map);
    }

    public final String zzAK() {
        return this.zzaUF;
    }

    public final String zzAL() {
        return this.zzaUG;
    }

    public final String zzAM() {
        return this.zzaUH;
    }

    public final String zzAN() {
        return this.zzaUI;
    }

    public final String zzAO() {
        return this.zzaUJ;
    }

    public final String zzAP() {
        return this.zzaUK;
    }

    @Override // com.google.android.gms.measurement.zze
    public final void zza(zzpr zzprVar) {
        if (!TextUtils.isEmpty(this.mName)) {
            zzprVar.mName = this.mName;
        }
        if (!TextUtils.isEmpty(this.zzaPI)) {
            zzprVar.zzaPI = this.zzaPI;
        }
        if (!TextUtils.isEmpty(this.zzaUF)) {
            zzprVar.zzaUF = this.zzaUF;
        }
        if (!TextUtils.isEmpty(this.zzaUG)) {
            zzprVar.zzaUG = this.zzaUG;
        }
        if (!TextUtils.isEmpty(this.zzxG)) {
            zzprVar.zzxG = this.zzxG;
        }
        if (!TextUtils.isEmpty(this.zzyv)) {
            zzprVar.zzyv = this.zzyv;
        }
        if (!TextUtils.isEmpty(this.zzaUH)) {
            zzprVar.zzaUH = this.zzaUH;
        }
        if (!TextUtils.isEmpty(this.zzaUI)) {
            zzprVar.zzaUI = this.zzaUI;
        }
        if (!TextUtils.isEmpty(this.zzaUJ)) {
            zzprVar.zzaUJ = this.zzaUJ;
        }
        if (TextUtils.isEmpty(this.zzaUK)) {
            return;
        }
        zzprVar.zzaUK = this.zzaUK;
    }

    public final void zzeA(String str) {
        this.zzaUH = str;
    }

    public final void zzeB(String str) {
        this.zzaUI = str;
    }

    public final void zzeC(String str) {
        this.zzaUJ = str;
    }

    public final void zzeD(String str) {
        this.zzaUK = str;
    }

    public final void zzev(String str) {
        this.zzaPI = str;
    }

    public final void zzew(String str) {
        this.zzaUF = str;
    }

    public final void zzex(String str) {
        this.zzaUG = str;
    }

    public final void zzey(String str) {
        this.zzxG = str;
    }

    public final void zzez(String str) {
        this.zzyv = str;
    }
}
