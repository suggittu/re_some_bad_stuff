package com.google.android.gms.analytics.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class zzh {
    private final String zzPO;
    private final long zzQD;
    private final String zzQE;
    private final boolean zzQF;
    private long zzQG;
    private final Map zzxA;

    public zzh(long j, String str, String str2, boolean z, long j2, Map map) {
        com.google.android.gms.common.internal.zzx.zzcM(str);
        com.google.android.gms.common.internal.zzx.zzcM(str2);
        this.zzQD = j;
        this.zzPO = str;
        this.zzQE = str2;
        this.zzQF = z;
        this.zzQG = j2;
        if (map != null) {
            this.zzxA = new HashMap(map);
        } else {
            this.zzxA = Collections.emptyMap();
        }
    }

    public String getClientId() {
        return this.zzPO;
    }

    public long zzjD() {
        return this.zzQD;
    }

    public String zzjE() {
        return this.zzQE;
    }

    public boolean zzjF() {
        return this.zzQF;
    }

    public long zzjG() {
        return this.zzQG;
    }

    public Map zzn() {
        return this.zzxA;
    }

    public void zzn(long j) {
        this.zzQG = j;
    }
}
