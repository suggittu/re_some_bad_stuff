package com.google.android.gms.tagmanager;

import android.os.Build;

/* loaded from: classes2.dex */
class zzm {
    final zza zzbhK = new zza() { // from class: com.google.android.gms.tagmanager.zzm.1
        @Override // com.google.android.gms.tagmanager.zzm.zza
        public int sizeOf(Object obj, Object obj2) {
            return 1;
        }
    };

    public interface zza {
        int sizeOf(Object obj, Object obj2);
    }

    int zzFY() {
        return Build.VERSION.SDK_INT;
    }

    public zzl zza(int i, zza zzaVar) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        return zzFY() < 12 ? new zzcw(i, zzaVar) : new zzba(i, zzaVar);
    }
}
