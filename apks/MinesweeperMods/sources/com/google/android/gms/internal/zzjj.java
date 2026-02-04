package com.google.android.gms.internal;

import com.google.android.gms.internal.zzji;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@zzhb
/* loaded from: classes2.dex */
public class zzjj implements zzji {
    protected Object zzNr;
    private final Object zzpV = new Object();
    protected int zzBc = 0;
    protected final BlockingQueue zzNq = new LinkedBlockingQueue();

    class zza {
        public final zzji.zzc zzNs;
        public final zzji.zza zzNt;

        public zza(zzji.zzc zzcVar, zzji.zza zzaVar) {
            this.zzNs = zzcVar;
            this.zzNt = zzaVar;
        }
    }

    public int getStatus() {
        return this.zzBc;
    }

    public void reject() {
        synchronized (this.zzpV) {
            if (this.zzBc != 0) {
                throw new UnsupportedOperationException();
            }
            this.zzBc = -1;
            Iterator it = this.zzNq.iterator();
            while (it.hasNext()) {
                ((zza) it.next()).zzNt.run();
            }
            this.zzNq.clear();
        }
    }

    @Override // com.google.android.gms.internal.zzji
    public void zza(zzji.zzc zzcVar, zzji.zza zzaVar) {
        synchronized (this.zzpV) {
            if (this.zzBc == 1) {
                zzcVar.zze(this.zzNr);
            } else if (this.zzBc == -1) {
                zzaVar.run();
            } else if (this.zzBc == 0) {
                this.zzNq.add(new zza(zzcVar, zzaVar));
            }
        }
    }

    @Override // com.google.android.gms.internal.zzji
    public void zzh(Object obj) {
        synchronized (this.zzpV) {
            if (this.zzBc != 0) {
                throw new UnsupportedOperationException();
            }
            this.zzNr = obj;
            this.zzBc = 1;
            Iterator it = this.zzNq.iterator();
            while (it.hasNext()) {
                ((zza) it.next()).zzNs.zze(obj);
            }
            this.zzNq.clear();
        }
    }
}
