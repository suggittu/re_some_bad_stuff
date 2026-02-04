package com.google.android.gms.auth.api.signin.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzmt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes2.dex */
public class zzm {
    private static final WeakHashMap zzXE = new WeakHashMap();
    private static final Lock zzXF = new ReentrantLock();
    private final Lock zzXG = new ReentrantLock();
    private final Map zzXH;

    public class zza {
        private final String zzXI;
        private final long zzXJ;
        private final zzmq zzqW;

        public zza(String str, long j) {
            this(str, j, zzmt.zzsc());
        }

        private zza(String str, long j, zzmq zzmqVar) {
            this.zzXI = zzx.zzcM(str);
            zzx.zzac(j > 0);
            this.zzXJ = j;
            this.zzqW = (zzmq) zzx.zzz(zzmqVar);
        }

        public boolean zzb() {
            return this.zzqW.currentTimeMillis() / 1000 >= this.zzXJ - 300;
        }
    }

    class zzb extends LinkedHashMap {
        private final int zzav;

        public zzb(int i) {
            this.zzav = i;
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry entry) {
            return size() > this.zzav;
        }
    }

    private zzm(Map map) {
        this.zzXH = map;
    }

    public static zzm zzbN(String str) {
        zzx.zzcM(str);
        zzXF.lock();
        try {
            zzm zzmVar = (zzm) zzXE.get(str);
            if (zzmVar == null) {
                zzmVar = new zzm(new zzb(20));
                zzXE.put(str, zzmVar);
            }
            return zzmVar;
        } finally {
            zzXF.unlock();
        }
    }

    public boolean zza(Set set, zza zzaVar) {
        zzx.zzz(set);
        zzx.zzz(zzaVar);
        if (set.size() == 0 || zzaVar.zzb()) {
            return false;
        }
        ArrayList arrayList = new ArrayList(set);
        Collections.sort(arrayList);
        this.zzXG.lock();
        try {
            this.zzXH.put(TextUtils.join(" ", arrayList), zzaVar);
            this.zzXG.unlock();
            return true;
        } catch (Throwable th) {
            this.zzXG.unlock();
            throw th;
        }
    }
}
