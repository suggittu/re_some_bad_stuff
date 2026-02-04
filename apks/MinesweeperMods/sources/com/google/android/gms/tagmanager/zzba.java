package com.google.android.gms.tagmanager;

import android.annotation.TargetApi;
import android.util.LruCache;
import com.google.android.gms.tagmanager.zzm;

@TargetApi(12)
/* loaded from: classes2.dex */
class zzba implements zzl {
    private LruCache zzbjq;

    zzba(int i, final zzm.zza zzaVar) {
        this.zzbjq = new LruCache(i) { // from class: com.google.android.gms.tagmanager.zzba.1
            @Override // android.util.LruCache
            protected int sizeOf(Object obj, Object obj2) {
                return zzaVar.sizeOf(obj, obj2);
            }
        };
    }

    @Override // com.google.android.gms.tagmanager.zzl
    public Object get(Object obj) {
        return this.zzbjq.get(obj);
    }

    @Override // com.google.android.gms.tagmanager.zzl
    public void zzh(Object obj, Object obj2) {
        this.zzbjq.put(obj, obj2);
    }
}
