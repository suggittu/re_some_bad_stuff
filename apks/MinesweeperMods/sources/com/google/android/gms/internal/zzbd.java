package com.google.android.gms.internal;

import android.support.v4.widget.ExploreByTouchHelper;
import java.util.LinkedList;
import java.util.List;

@zzhb
/* loaded from: classes2.dex */
public class zzbd {
    private int zzsW;
    private final Object zzpV = new Object();
    private List zzsX = new LinkedList();

    public boolean zza(zzbc zzbcVar) {
        boolean z;
        synchronized (this.zzpV) {
            z = this.zzsX.contains(zzbcVar);
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0025, code lost:
    
        r2.remove();
        r0 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean zzb(com.google.android.gms.internal.zzbc r5) {
        /*
            r4 = this;
            java.lang.Object r1 = r4.zzpV
            monitor-enter(r1)
            java.util.List r0 = r4.zzsX     // Catch: java.lang.Throwable -> L2e
            java.util.Iterator r2 = r0.iterator()     // Catch: java.lang.Throwable -> L2e
        L9:
            boolean r0 = r2.hasNext()     // Catch: java.lang.Throwable -> L2e
            if (r0 == 0) goto L2b
            java.lang.Object r0 = r2.next()     // Catch: java.lang.Throwable -> L2e
            com.google.android.gms.internal.zzbc r0 = (com.google.android.gms.internal.zzbc) r0     // Catch: java.lang.Throwable -> L2e
            if (r5 == r0) goto L9
            java.lang.String r0 = r0.zzcy()     // Catch: java.lang.Throwable -> L2e
            java.lang.String r3 = r5.zzcy()     // Catch: java.lang.Throwable -> L2e
            boolean r0 = r0.equals(r3)     // Catch: java.lang.Throwable -> L2e
            if (r0 == 0) goto L9
            r2.remove()     // Catch: java.lang.Throwable -> L2e
            r0 = 1
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L2e
        L2a:
            return r0
        L2b:
            r0 = 0
            monitor-exit(r1)
            goto L2a
        L2e:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbd.zzb(com.google.android.gms.internal.zzbc):boolean");
    }

    public void zzc(zzbc zzbcVar) {
        synchronized (this.zzpV) {
            if (this.zzsX.size() >= 10) {
                zzin.zzaI("Queue is full, current size = " + this.zzsX.size());
                this.zzsX.remove(0);
            }
            int i = this.zzsW;
            this.zzsW = i + 1;
            zzbcVar.zzh(i);
            this.zzsX.add(zzbcVar);
        }
    }

    public zzbc zzcF() {
        int i;
        zzbc zzbcVar;
        zzbc zzbcVar2 = null;
        synchronized (this.zzpV) {
            if (this.zzsX.size() == 0) {
                zzin.zzaI("Queue empty");
                return null;
            }
            if (this.zzsX.size() < 2) {
                zzbc zzbcVar3 = (zzbc) this.zzsX.get(0);
                zzbcVar3.zzcA();
                return zzbcVar3;
            }
            int i2 = ExploreByTouchHelper.INVALID_ID;
            for (zzbc zzbcVar4 : this.zzsX) {
                int score = zzbcVar4.getScore();
                if (score > i2) {
                    zzbcVar = zzbcVar4;
                    i = score;
                } else {
                    i = i2;
                    zzbcVar = zzbcVar2;
                }
                i2 = i;
                zzbcVar2 = zzbcVar;
            }
            this.zzsX.remove(zzbcVar2);
            return zzbcVar2;
        }
    }
}
