package com.google.android.gms.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class zznx {
    private static final double zzazE = 1000.0d / TimeUnit.SECONDS.toNanos(1);
    private static final double zzazF = 1000.0d / TimeUnit.SECONDS.toNanos(1);
    private static final zznx zzazI = new zznx();
    private final Map zzazG;
    private final Map zzazH;

    public class zza {
        private final double zzazJ;
        private final double zzazK;

        private zza(double d, double d2) {
            this.zzazJ = d;
            this.zzazK = d2;
        }

        public boolean zzh(double d) {
            return d >= this.zzazJ && d <= this.zzazK;
        }
    }

    private zznx() {
        double d = 1000.0d;
        double d2 = 100.0d;
        double d3 = 0.0d;
        HashMap map = new HashMap();
        map.put(zznt.zzaxF.name, new zza(-90.0d, 90.0d));
        map.put(zznt.zzaxG.name, new zza(-180.0d, 180.0d));
        map.put(zznt.zzaxH.name, new zza(d3, 10000.0d));
        map.put(zznt.zzaxE.name, new zza(d3, d));
        map.put(zznt.zzaxI.name, new zza(-100000.0d, 100000.0d));
        map.put(zznt.zzaxP.name, new zza(d3, d2));
        map.put(zznt.zzaxx.name, new zza(d3, d2));
        map.put(zznt.zzaxA.name, new zza(d3, 9.223372036854776E18d));
        map.put(zznt.zzaxM.name, new zza(d3, 10.0d));
        map.put(zznt.zzaxN.name, new zza(d3, d));
        map.put(zznt.zzaxQ.name, new zza(d3, 200000.0d));
        this.zzazH = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        map2.put("com.google.step_count.delta", zzf(zznt.zzaxz.name, new zza(d3, zzazE)));
        map2.put("com.google.calories.consumed", zzf(zznt.zzaxT.name, new zza(d3, zzazF)));
        map2.put("com.google.calories.expended", zzf(zznt.zzaxT.name, new zza(d3, zzazF)));
        this.zzazG = Collections.unmodifiableMap(map2);
    }

    private static Map zzf(Object obj, Object obj2) {
        HashMap map = new HashMap();
        map.put(obj, obj2);
        return map;
    }

    public static zznx zzuG() {
        return zzazI;
    }

    public zza zzC(String str, String str2) {
        Map map = (Map) this.zzazG.get(str);
        if (map != null) {
            return (zza) map.get(str2);
        }
        return null;
    }

    public zza zzdE(String str) {
        return (zza) this.zzazH.get(str);
    }
}
