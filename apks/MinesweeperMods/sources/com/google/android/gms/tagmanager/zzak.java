package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
abstract class zzak {
    private final Set zzbiU;
    private final String zzbiV;

    public zzak(String str, String... strArr) {
        this.zzbiV = str;
        this.zzbiU = new HashSet(strArr.length);
        for (String str2 : strArr) {
            this.zzbiU.add(str2);
        }
    }

    public abstract boolean zzFW();

    public String zzGB() {
        return this.zzbiV;
    }

    public Set zzGC() {
        return this.zzbiU;
    }

    public abstract zzag.zza zzP(Map map);

    boolean zze(Set set) {
        return set.containsAll(this.zzbiU);
    }
}
