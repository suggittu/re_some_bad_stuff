package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.zzm;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
class zzcw implements zzl {
    private final Map zzbld = new HashMap();
    private final int zzble;
    private final zzm.zza zzblf;
    private int zzblg;

    zzcw(int i, zzm.zza zzaVar) {
        this.zzble = i;
        this.zzblf = zzaVar;
    }

    @Override // com.google.android.gms.tagmanager.zzl
    public synchronized Object get(Object obj) {
        return this.zzbld.get(obj);
    }

    @Override // com.google.android.gms.tagmanager.zzl
    public synchronized void zzh(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            throw new NullPointerException("key == null || value == null");
        }
        this.zzblg += this.zzblf.sizeOf(obj, obj2);
        if (this.zzblg > this.zzble) {
            Iterator it = this.zzbld.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                this.zzblg -= this.zzblf.sizeOf(entry.getKey(), entry.getValue());
                it.remove();
                if (this.zzblg <= this.zzble) {
                    break;
                }
            }
        }
        this.zzbld.put(obj, obj2);
    }
}
