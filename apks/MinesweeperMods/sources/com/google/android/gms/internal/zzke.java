package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class zzke extends com.google.android.gms.measurement.zze {
    private String zzPN;
    private String zzPO;
    private String zzPP;
    private boolean zzPQ;
    private String zzPR;
    private boolean zzPS;
    private double zzPT;
    private String zzrG;

    public final String getClientId() {
        return this.zzPO;
    }

    public final String getUserId() {
        return this.zzrG;
    }

    public final void setClientId(String str) {
        this.zzPO = str;
    }

    public final void setSampleRate(double d) {
        com.google.android.gms.common.internal.zzx.zzb(d >= 0.0d && d <= 100.0d, "Sample rate must be between 0% and 100%");
        this.zzPT = d;
    }

    public final void setUserId(String str) {
        this.zzrG = str;
    }

    public final String toString() {
        HashMap map = new HashMap();
        map.put("hitType", this.zzPN);
        map.put("clientId", this.zzPO);
        map.put("userId", this.zzrG);
        map.put("androidAdId", this.zzPP);
        map.put("AdTargetingEnabled", Boolean.valueOf(this.zzPQ));
        map.put("sessionControl", this.zzPR);
        map.put("nonInteraction", Boolean.valueOf(this.zzPS));
        map.put("sampleRate", Double.valueOf(this.zzPT));
        return zzF(map);
    }

    public final void zzH(boolean z) {
        this.zzPQ = z;
    }

    public final void zzI(boolean z) {
        this.zzPS = z;
    }

    @Override // com.google.android.gms.measurement.zze
    public final void zza(zzke zzkeVar) {
        if (!TextUtils.isEmpty(this.zzPN)) {
            zzkeVar.zzPN = this.zzPN;
        }
        if (!TextUtils.isEmpty(this.zzPO)) {
            zzkeVar.zzPO = this.zzPO;
        }
        if (!TextUtils.isEmpty(this.zzrG)) {
            zzkeVar.zzrG = this.zzrG;
        }
        if (!TextUtils.isEmpty(this.zzPP)) {
            zzkeVar.zzPP = this.zzPP;
        }
        if (this.zzPQ) {
            zzkeVar.zzPQ = true;
        }
        if (!TextUtils.isEmpty(this.zzPR)) {
            zzkeVar.zzPR = this.zzPR;
        }
        if (this.zzPS) {
            zzkeVar.zzPS = this.zzPS;
        }
        if (this.zzPT != 0.0d) {
            zzkeVar.setSampleRate(this.zzPT);
        }
    }

    public final void zzaX(String str) {
        this.zzPN = str;
    }

    public final void zzaY(String str) {
        this.zzPP = str;
    }

    public final void zzaZ(String str) {
        this.zzPR = str;
    }

    public final String zziS() {
        return this.zzPN;
    }

    public final String zziT() {
        return this.zzPP;
    }

    public final boolean zziU() {
        return this.zzPQ;
    }

    public final String zziV() {
        return this.zzPR;
    }

    public final boolean zziW() {
        return this.zzPS;
    }

    public final double zziX() {
        return this.zzPT;
    }
}
