package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.nearby.messages.Strategy;
import java.util.HashMap;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class zzpw extends com.google.android.gms.measurement.zze {
    private String zzaUQ;
    private int zzaUR;
    private int zzaUS;
    private String zzaUT;
    private String zzaUU;
    private boolean zzaUV;
    private boolean zzaUW;
    private boolean zzaUX;

    public zzpw() {
        this(false);
    }

    public zzpw(boolean z) {
        this(z, zzBb());
    }

    public zzpw(boolean z, int i) {
        com.google.android.gms.common.internal.zzx.zzbV(i);
        this.zzaUR = i;
        this.zzaUW = z;
    }

    static int zzBb() {
        UUID uuidRandomUUID = UUID.randomUUID();
        int leastSignificantBits = (int) (uuidRandomUUID.getLeastSignificantBits() & 2147483647L);
        if (leastSignificantBits != 0) {
            return leastSignificantBits;
        }
        int mostSignificantBits = (int) (uuidRandomUUID.getMostSignificantBits() & 2147483647L);
        if (mostSignificantBits != 0) {
            return mostSignificantBits;
        }
        Log.e("GAv4", "UUID.randomUUID() returned 0.");
        return Strategy.TTL_SECONDS_INFINITE;
    }

    private void zzBf() {
        if (this.zzaUX) {
            throw new IllegalStateException("ScreenViewInfo is immutable");
        }
    }

    public final void setScreenName(String str) {
        zzBf();
        this.zzaUQ = str;
    }

    public final String toString() {
        HashMap map = new HashMap();
        map.put("screenName", this.zzaUQ);
        map.put("interstitial", Boolean.valueOf(this.zzaUV));
        map.put("automatic", Boolean.valueOf(this.zzaUW));
        map.put("screenId", Integer.valueOf(this.zzaUR));
        map.put("referrerScreenId", Integer.valueOf(this.zzaUS));
        map.put("referrerScreenName", this.zzaUT);
        map.put("referrerUri", this.zzaUU);
        return zzF(map);
    }

    public final String zzBc() {
        return this.zzaUQ;
    }

    public final int zzBd() {
        return this.zzaUR;
    }

    public final String zzBe() {
        return this.zzaUU;
    }

    @Override // com.google.android.gms.measurement.zze
    public final void zza(zzpw zzpwVar) {
        if (!TextUtils.isEmpty(this.zzaUQ)) {
            zzpwVar.setScreenName(this.zzaUQ);
        }
        if (this.zzaUR != 0) {
            zzpwVar.zziF(this.zzaUR);
        }
        if (this.zzaUS != 0) {
            zzpwVar.zziG(this.zzaUS);
        }
        if (!TextUtils.isEmpty(this.zzaUT)) {
            zzpwVar.zzeH(this.zzaUT);
        }
        if (!TextUtils.isEmpty(this.zzaUU)) {
            zzpwVar.zzeI(this.zzaUU);
        }
        if (this.zzaUV) {
            zzpwVar.zzaq(this.zzaUV);
        }
        if (this.zzaUW) {
            zzpwVar.zzap(this.zzaUW);
        }
    }

    public final void zzap(boolean z) {
        zzBf();
        this.zzaUW = z;
    }

    public final void zzaq(boolean z) {
        zzBf();
        this.zzaUV = z;
    }

    public final void zzeH(String str) {
        zzBf();
        this.zzaUT = str;
    }

    public final void zzeI(String str) {
        zzBf();
        if (TextUtils.isEmpty(str)) {
            this.zzaUU = null;
        } else {
            this.zzaUU = str;
        }
    }

    public final void zziF(int i) {
        zzBf();
        this.zzaUR = i;
    }

    public final void zziG(int i) {
        zzBf();
        this.zzaUS = i;
    }
}
