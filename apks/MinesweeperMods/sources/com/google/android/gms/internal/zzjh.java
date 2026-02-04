package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzhb
/* loaded from: classes2.dex */
class zzjh {
    private final Object zzNm = new Object();
    private final List zzNn = new ArrayList();
    private final List zzNo = new ArrayList();
    private boolean zzNp = false;

    private void zzd(Runnable runnable) {
        zziq.zza(runnable);
    }

    private void zze(Runnable runnable) {
        com.google.android.gms.ads.internal.util.client.zza.zzMS.post(runnable);
    }

    public void zzb(Runnable runnable) {
        synchronized (this.zzNm) {
            if (this.zzNp) {
                zziq.zza(runnable);
            } else {
                this.zzNn.add(runnable);
            }
        }
    }

    public void zzc(Runnable runnable) {
        synchronized (this.zzNm) {
            if (this.zzNp) {
                zze(runnable);
            } else {
                this.zzNo.add(runnable);
            }
        }
    }

    public void zzhK() {
        synchronized (this.zzNm) {
            if (this.zzNp) {
                return;
            }
            Iterator it = this.zzNn.iterator();
            while (it.hasNext()) {
                zziq.zza((Runnable) it.next());
            }
            Iterator it2 = this.zzNo.iterator();
            while (it2.hasNext()) {
                zze((Runnable) it2.next());
            }
            this.zzNn.clear();
            this.zzNo.clear();
            this.zzNp = true;
        }
    }
}
