package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class zzps extends com.google.android.gms.measurement.zze {
    public int zzDC;
    public int zzDD;
    public int zzaUL;
    public int zzaUM;
    public int zzaUN;
    private String zzaaL;

    public final String getLanguage() {
        return this.zzaaL;
    }

    public final void setLanguage(String str) {
        this.zzaaL = str;
    }

    public final String toString() {
        HashMap map = new HashMap();
        map.put("language", this.zzaaL);
        map.put("screenColors", Integer.valueOf(this.zzaUL));
        map.put("screenWidth", Integer.valueOf(this.zzDC));
        map.put("screenHeight", Integer.valueOf(this.zzDD));
        map.put("viewportWidth", Integer.valueOf(this.zzaUM));
        map.put("viewportHeight", Integer.valueOf(this.zzaUN));
        return zzF(map);
    }

    public final int zzAQ() {
        return this.zzaUL;
    }

    public final int zzAR() {
        return this.zzDC;
    }

    public final int zzAS() {
        return this.zzDD;
    }

    public final int zzAT() {
        return this.zzaUM;
    }

    public final int zzAU() {
        return this.zzaUN;
    }

    @Override // com.google.android.gms.measurement.zze
    public final void zza(zzps zzpsVar) {
        if (this.zzaUL != 0) {
            zzpsVar.zzaUL = this.zzaUL;
        }
        if (this.zzDC != 0) {
            zzpsVar.zzDC = this.zzDC;
        }
        if (this.zzDD != 0) {
            zzpsVar.zzDD = this.zzDD;
        }
        if (this.zzaUM != 0) {
            zzpsVar.zzaUM = this.zzaUM;
        }
        if (this.zzaUN != 0) {
            zzpsVar.zzaUN = this.zzaUN;
        }
        if (TextUtils.isEmpty(this.zzaaL)) {
            return;
        }
        zzpsVar.zzaaL = this.zzaaL;
    }

    public final void zziA(int i) {
        this.zzaUL = i;
    }

    public final void zziB(int i) {
        this.zzDC = i;
    }

    public final void zziC(int i) {
        this.zzDD = i;
    }

    public final void zziD(int i) {
        this.zzaUM = i;
    }

    public final void zziE(int i) {
        this.zzaUN = i;
    }
}
