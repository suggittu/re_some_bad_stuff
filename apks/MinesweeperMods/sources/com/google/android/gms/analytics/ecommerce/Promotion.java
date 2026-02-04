package com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class Promotion {
    public static final String ACTION_CLICK = "click";
    public static final String ACTION_VIEW = "view";
    Map zzPU = new HashMap();

    void put(String str, String str2) {
        zzx.zzb(str, "Name should be non-null");
        this.zzPU.put(str, str2);
    }

    public Promotion setCreative(String str) {
        put("cr", str);
        return this;
    }

    public Promotion setId(String str) {
        put("id", str);
        return this;
    }

    public Promotion setName(String str) {
        put("nm", str);
        return this;
    }

    public Promotion setPosition(String str) {
        put("ps", str);
        return this;
    }

    public String toString() {
        return zze.zzO(this.zzPU);
    }

    public Map zzba(String str) {
        HashMap map = new HashMap();
        for (Map.Entry entry : this.zzPU.entrySet()) {
            map.put(str + ((String) entry.getKey()), entry.getValue());
        }
        return map;
    }
}
