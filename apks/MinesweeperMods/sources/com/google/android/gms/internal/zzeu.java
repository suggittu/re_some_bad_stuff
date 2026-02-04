package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@zzhb
/* loaded from: classes2.dex */
public class zzeu implements zzem {
    private final Context mContext;
    private final zzeo zzCf;
    private final AdRequestInfoParcel zzCu;
    private final long zzCv;
    private final long zzCw;
    private final int zzCx;
    private final zzex zzpn;
    private final boolean zzsA;
    private final boolean zzuS;
    private final Object zzpV = new Object();
    private boolean zzCy = false;
    private final Map zzCz = new HashMap();

    public zzeu(Context context, AdRequestInfoParcel adRequestInfoParcel, zzex zzexVar, zzeo zzeoVar, boolean z, boolean z2, long j, long j2, int i) {
        this.mContext = context;
        this.zzCu = adRequestInfoParcel;
        this.zzpn = zzexVar;
        this.zzCf = zzeoVar;
        this.zzsA = z;
        this.zzuS = z2;
        this.zzCv = j;
        this.zzCw = j2;
        this.zzCx = i;
    }

    private void zza(final zzjg zzjgVar) {
        zzir.zzMc.post(new Runnable() { // from class: com.google.android.gms.internal.zzeu.2
            @Override // java.lang.Runnable
            public void run() {
                for (zzjg zzjgVar2 : zzeu.this.zzCz.keySet()) {
                    if (zzjgVar2 != zzjgVar) {
                        ((zzer) zzeu.this.zzCz.get(zzjgVar2)).cancel();
                    }
                }
            }
        });
    }

    private zzes zzd(List list) {
        zzes zzesVar;
        synchronized (this.zzpV) {
            if (this.zzCy) {
                return new zzes(-1);
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzjg zzjgVar = (zzjg) it.next();
                try {
                    zzesVar = (zzes) zzjgVar.get();
                } catch (InterruptedException | ExecutionException e) {
                    zzin.zzd("Exception while processing an adapter; continuing with other adapters", e);
                }
                if (zzesVar != null && zzesVar.zzCo == 0) {
                    zza(zzjgVar);
                    return zzesVar;
                }
            }
            zza((zzjg) null);
            return new zzes(1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.google.android.gms.internal.zzes zze(java.util.List r16) {
        /*
            Method dump skipped, instructions count: 202
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzeu.zze(java.util.List):com.google.android.gms.internal.zzes");
    }

    @Override // com.google.android.gms.internal.zzem
    public void cancel() {
        synchronized (this.zzpV) {
            this.zzCy = true;
            Iterator it = this.zzCz.values().iterator();
            while (it.hasNext()) {
                ((zzer) it.next()).cancel();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzem
    public zzes zzc(List list) {
        zzin.zzaI("Starting mediation.");
        ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzen zzenVar = (zzen) it.next();
            zzin.zzaJ("Trying mediation network: " + zzenVar.zzBA);
            Iterator it2 = zzenVar.zzBB.iterator();
            while (it2.hasNext()) {
                final zzer zzerVar = new zzer(this.mContext, (String) it2.next(), this.zzpn, this.zzCf, zzenVar, this.zzCu.zzHt, this.zzCu.zzrp, this.zzCu.zzrl, this.zzsA, this.zzuS, this.zzCu.zzrD, this.zzCu.zzrH);
                zzjg zzjgVarZza = zziq.zza(executorServiceNewCachedThreadPool, new Callable() { // from class: com.google.android.gms.internal.zzeu.1
                    @Override // java.util.concurrent.Callable
                    /* renamed from: zzeE, reason: merged with bridge method [inline-methods] */
                    public zzes call() {
                        synchronized (zzeu.this.zzpV) {
                            if (zzeu.this.zzCy) {
                                return null;
                            }
                            return zzerVar.zza(zzeu.this.zzCv, zzeu.this.zzCw);
                        }
                    }
                });
                this.zzCz.put(zzjgVarZza, zzerVar);
                arrayList.add(zzjgVarZza);
            }
        }
        switch (this.zzCx) {
            case 2:
                return zze(arrayList);
            default:
                return zzd(arrayList);
        }
    }
}
